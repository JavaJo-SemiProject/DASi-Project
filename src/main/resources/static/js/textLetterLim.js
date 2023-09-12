
$(document).ready(function() {
    $('#writeContent').on('keyup', function() {
        $('#writeContent_cnt').html("("+$(this).val().length+" / 10)");

        if($(this).val().length > 10) {
            $(this).val($(this).val().substring(0, 10));
            $('#writeContent_cnt').html("(10 / 10)");
        }
    });
});



$(document).ready(function() {
    $('#requestOrder').on('keyup', function() {
        $('#requestOrder_cnt').html("("+$(this).val().length+" / 200)");

        if($(this).val().length > 200) {
            $(this).val($(this).val().substring(0, 200));
            $('#requestOrder_cnt').html("(200 / 200)");
        }
    });
});
