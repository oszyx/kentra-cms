

layui.use(['jquery'], function () {
    var $ = layui.jquery;
    $(function () {
        $.ajaxSetup({
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            complete: function (XMLHttpRequest, textStatus) {
            },
            statusCode: {
                401: function () {
                    $.ajax({
                        type: "post",
                        url: "/api/sys/chanageToken",
                        dataType: "json",
                        data: {"userId": $("#userId").val(), "password": $("#userPssword").val()},
                        cache: true,
                        async: false,
                        success: function (data) {
                            if ("success" == data.msg) {
                                console.log(data);
                                $.cookie('KentrasoftToken', data.Token, {path: '/'});
                            }
                        }
                    });
                }
            }
        });
    });
});