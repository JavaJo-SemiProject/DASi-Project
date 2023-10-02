function enableFormAndPreventSubmit() {
    var inputField = document.getElementById("inputFieldId");
    inputField.removeAttribute("readonly");

    // 폼의 submit 이벤트를 가로채서 폼 제출을 방지
    var form = document.getElementById("statusUpdate");
    form.addEventListener("submit", function (event) {
        event.preventDefault(); // 폼 제출 방지
        // 폼 데이터를 서버로 전송하려면 이 곳에 AJAX 또는 기타 전송 로직을 추가
    });
    window.history.pushState(null, null, window.location.href);
    window.onpopstate = function (event) {
        // 뒤로 가기 클릭 시 현재 페이지를 Ajax를 사용하여 다시 불러오기
        $.ajax({
            type: "GET",
            url: window.location.href,
            success: function (data) {
                // 페이지 다시 로드
                $("body").html(data);
            }
        });
        window.history.pushState(null, null, window.location.href); // 뒤로 가기 이벤트 차단
    };
}

function submitFormAndReloadPage() {
    var form = document.getElementById("statusUpdate");
    var formData = new FormData(form);

    $.ajax({
        type: "POST",  // 또는 "GET"에 따라 폼을 제출하는 방식을 선택할 수 있습니다.
        url: form.action,
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            // AJAX 요청이 성공하면 페이지를 다시 로드합니다.
            $("body").html(response);
        },
        error: function (error) {
            // AJAX 요청이 실패한 경우 오류 처리를 수행합니다.
            console.error("AJAX 요청 실패:", error);
        }
    });
}


function submitFormWithAjax() {
    var form = document.getElementById("statusUpdate");
    var inputField = document.getElementById("inputFieldId");

    // 입력 필드 readonly 속성 제거
    inputField.removeAttribute("readonly");

    // 폼 데이터를 직렬화
    var formData = $(form).serialize();

    // AJAX로 서버에 데이터 전송
    $.ajax({
        type: "POST", // POST 요청
        url: form.action, // 폼의 액션 속성 값, 서버 주소로 수정 필요
        data: formData, // 폼 데이터를 직렬화한 데이터 전송
        success: function(data) {
            // 서버 응답을 처리
            // 이 부분에 필요한 로직을 추가하십시오.
            console.log("폼 제출 성공:", data);
            // 페이지 다시 로드 (새로고침)
            location.reload();
        },
        error: function(xhr, status, error) {
            // 서버 에러 처리
            // 이 부분에 에러 핸들링 로직을 추가하십시오.
            console.error("폼 제출 에러:", error);
        }
    });
}



function goBack() {
    window.history.back();
    return false;
}

function saveDeliveryInfo() {
    // 배송 정보를 서버로 전송하는 AJAX 요청 코드를 작성
    var orderId = document.getElementById("orderId").value;
    var receiver = document.getElementsByName("receiver")[0].value;
    var recePhone = document.getElementsByName("recePhone")[0].value;
    var zipCode = document.getElementById("zipCode").value;
    var address = document.getElementById("address").value;
    var addressDetail = document.getElementById("addressDetail").value;

    if (receiver === "" || recePhone === "" || zipCode === "" || address === "") {
        alert("배송 정보를 모두 입력하세요.");
        return; // 필수 필드가 비어 있으면 함수를 종료하고 저장 요청을 보내지 않음
    }

    // 배송 정보를 객체로 만들어서 서버로 전송
    var deliveryData = {
        orderId: orderId,
        receiver: receiver,
        recePhone: recePhone,
        zipCode: zipCode,
        address: address,
        addressDetail: addressDetail
    };

    // AJAX 요청 코드 작성 및 서버로 전송
    $.ajax({
        type: "POST", // POST 요청
        url: 'myOrderDetail', // 컨트롤러 엔드포인트 URL
        contentType: 'application/json',
        data: JSON.stringify(deliveryData), // 데이터를 JSON 문자열로 변환하여 전송
        success: function (data) {
            // 서버에서 응답을 받으면 실행됨
            console.log('배송 정보 저장 성공:', data);

            // 배송 정보 입력 폼 숨기기
            /*var deliveryForm = document.getElementById("deliveryForm");*/
            location.replace('/content/mypage/myOrderList');
        },
        error: function (xhr, textStatus, errorThrown) {
            // 에러 발생 시 실행됨
            console.error('배송 정보 저장 실패:', textStatus, errorThrown);
        }
    });
}
