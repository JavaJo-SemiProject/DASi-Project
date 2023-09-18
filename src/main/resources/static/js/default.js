//로딩 부드럽게

jQuery(function($) {
    $("body").css("display", "none");
    $("body").fadeIn(2000);
    $("a.transition").click(function(event){
        event.preventDefault();
        linkLocation = this.href;
        $("body").fadeOut(1000, redirectPage);
    });
    function redirectPage() {
        window.location = linkLocation;
    }
});

// id 중복확인

/*function useridCheck() {
    const userid = $("#userid").val();
    if (userid == "") {
        alert("아이디를 입력해 주세요. 필수항목입니다.");
        $("#userid").focus();
        return false;
    }
    $.ajax({
        type: "get",
        url: "/signup",
        data: {"userid": userid},
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        Accept: "application / json",

        success: function (result) {
            if (result.result == "0") {
                if (confirm("이 아이디는 사용 가능합니다. \n사용하시겠습니까?")) {
                    useridOverlapCheck = 1;
                    $("#userid").attr("readonly", true);
                    $("#useridOverlay").attr("disabled", true);
                    $("#useridOverlay").css("display", "none");
                    $("#resetUserid").attr("disabled", false);
                    $("#resetUserid").css("display", "inline-block");
                }
                return false;
            } else if (result.result == "1") {
                alert("이미 사용중인 아이디입니다.");
                $("#userid").focus();
            } else {
                alert("success이지만 result 값이 undefined 잘못됨");
            }
        },
        error: function (request, status,error) {
            alert("ajax 실행 실패");
            alert("code:" + request.status + "\n" + "error :" + error);
        }
    });

}*/

function checkId(){
    var userid = $('#userid').val(); //id값이 "id"인 입력란의 값을 저장
    $.ajax({
        url:'./idCheck', //Controller에서 요청 받을 주소
        type:'post', //POST 방식으로 전달
        data:{userid:userid},
        success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다
            if(cnt == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
                $('.userid_ok').css("display","inline-block");
                $('.userid_already').css("display", "none");
            } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                $('.userid_already').css("display","inline-block");
                $('.userid_ok').css("display", "none");
                alert("아이디를 다시 입력해주세요");
                $('#userid').val('');
            }
        },
        error:function(){
            alert("에러입니다");
        }
    });
};