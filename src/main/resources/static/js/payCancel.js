const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose'); // Mongoose를 사용하여 MongoDB 연결
const axios = require('axios'); // axios 모듈 추가

const app = express();
app.use(bodyParser.json());

// MongoDB 연결 설정
mongoose.connect('mongodb://localhost:27017/paymentDB', {
    useNewUrlParser: true,
    useUnifiedTopology: true,
});

// 결제 정보 모델 정의
const Payment = mongoose.model('Payment', {
    imp_uid: String,
    merchant_uid: String,
    amount: Number,
    cancel_amount: { type: Number, default: 0 },
});

// 환불 요청 엔드포인트
app.post('/payments/cancel', async (req, res, next) => {
    try {
        const { body } = req;
        const { merchant_uid, reason, cancel_request_amount } = body;
        // Payment 모델 사용
        Payment.find({ merchant_uid }, async function(err, payment) {
            if (err) {
                return res.status(500).json({ error: "서버 오류" });
            }
            if (!payment || payment.length === 0) {
                return res.status(404).json({ message: "결제 정보를 찾을 수 없습니다." });
            }

            // 조회한 결제정보로부터 필요한 데이터 추출
            const paymentData = payment[0];
            const { imp_uid, amount, cancel_amount } = paymentData;
            const cancelableAmount = amount - cancel_amount;

            // 이미 전액 환불된 경우
            if (cancelableAmount <= 0) {
                return res.status(400).json({ message: "이미 전액 환불된 주문입니다." });
            }

            // 포트원 REST API로 결제환불 요청
            const accessToken = "21ffab4f7d6c2c92fc756156b22aae52ed818568";
            const iamportAPI = "https://api.iamport.kr/payments/cancel";

            const cancelData = {
                reason,          // 환불사유
                imp_uid,         // imp_uid를 환불 unique key로 입력
                amount: cancel_request_amount,  // 환불금액
                checksum: cancelableAmount     // [권장] 환불 가능 금액 입력
            };

            const response = await axios.post(iamportAPI, cancelData, {
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": accessToken
                }
            });

            // 환불 결과 확인
            if (response.status === 200 && response.data.response) {
                // 환불 결과에 따른 처리 (수정 필요)
                // 이 부분에 환불 성공 또는 실패 시 필요한 로직을 추가하세요.
                return res.status(200).json({ message: "환불 성공" });
            } else {
                return res.status(400).json({ message: "환불 실패" });
            }
        });
    } catch (error) {
        console.error(error);
        res.status(500).json({ error: "서버 오류" });
    }
});

const port = process.env.PORT || 3000;
app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
