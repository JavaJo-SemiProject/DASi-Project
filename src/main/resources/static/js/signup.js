// id 정규식


// id 중복 체크


// 2. 비밀번호 일치 여부 및 정규식(인라인)


// 3. 이메일 인증(인라인) 및 정규식



// 4. 이메일 코드 확인
function sendEmailCode(){
    $.ajax({
        url:"/mail",
        type:"post",
        crossDomain: true,
        headers: {  'Access-Control-Allow-Origin': 'http://The web site allowed to access' },
        dataType:"json",
        data:{"email" : $("#email").val()},
        success: function(data){
            alert("인증번호 발송");
            //$("#email").attr("readonly", true);
            $("#confirm").attr("value",data);
            $("#emailCodeArea").css({'display' : ''});

        },
    })
}


function confirmEmailCode(){
    var emailCode = $("#emailCode").val();
    var confirm = $("#confirm").val();

    if(emailCode == confirm){
        alert("인증되었습니다.");
        $("#emailConfirmArea").addClass('ic2');
        $("#checkEmailCodeButton").css({'display' : 'none'});
        $("#sendEmailCodeButton").css({'display' : 'none'});
        $("#confirmEmailCodeButton").css({'display' : 'none'});
        $("#resetEmailProcessButton").css({'display' : ''})
        $("#confirmEmailProcessButton").css({'display' : ''})
    }else{
        alert("번호가 다릅니다.");
    }
}

function confirmEmailProcess(){
    $("#email").attr("readonly", true);
    $("#emailCode").attr("readonly", true);
    $("#checkEmailCodeButton").css({'display' : 'none'});
    $("#sendEmailCodeButton").css({'display' : 'none'});
    $("#confirmEmailProcessButton").css({'display' : 'none'});
    $("#resetEmailProcessButton").css({'display' : ''})


}
function resetEmailProcess(){
    var resetEmail = confirm('인증을 취소하고 다른 이메일 주소를 사용할까요?');
    if (resetEmail) {
        $("#email").val('');
        $("#email").removeAttr('readonly');
        $("#emailCode").val('');
        $("#emailCode").removeAttr('readonly');
        $("#emailCode").css({'display': 'none'});
        $("#emailConfirmArea").removeClass('ic2');
        $("#emailConfirmArea").addClass('ic1');
        $("#checkEmailButton").css({'display': ''});
        $("#confirmEmailProcessButton").css({'display' : 'none'})
        $("#resetEmailProcessButton").css({'display' : 'none'})
    }

}

// 5. 전화번호 형식 지정은 인라인에서 서술해야 작동


// 6. 주소 api
function addressFinder() {
    new daum.Postcode({
        oncomplete: function(data) {

            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("addressDetail").value = extraAddr;

            } else {
                document.getElementById("addressDetail").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipCode').value = data.zonecode;
            document.getElementById('address').value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('addressDetail').focus();
        }
    }).open();
}

// 8. 약관 및 이메일 검증
function signupValidationCheck(){

    var emailCode = $("#emailCode").val();
    var confirm = $("#confirm").val();

    if(emailCode != confirm) {
        alert("이메일 인증이 완료되지 않았습니다.");
        return;

    } else if (emailCode == '') {
        alert("이메일 인증이 완료되지 않았습니다.");
        return;
    }

    if($("input[name='agreeTou']:checked" == false)){
        alert("모든 약관에 동의하셔야 다음 단계로 진행이 가능합니다.");
        return;
    } else if ($("input[name='agreePp']:checked" == false)) {
        alert("모든 약관에 동의하셔야 다음 단계로 진행이 가능합니다.");
        return;
    }

}