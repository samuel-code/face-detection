$(function () {
    $("button").click(function(){
        alert('test');
        $.get("/api/authen/login?channel=web",function (data,status) {
            alert("Data: " + data + "nStatus: " + status);
        })
    });
});