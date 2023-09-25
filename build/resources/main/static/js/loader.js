$(document).ready(function(){
    setInterval(function(){
        $('.loader-area').hide();
        $('.loader').hide();
    }, 2000)
    $('.loader-area').show();
    $('.loader').show();
});