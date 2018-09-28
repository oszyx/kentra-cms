layui.use(['form', 'jquery'], function () {
    var form = layui.form , $ = layui.jquery;

    //自定义验证规则
    form.verify({
        name: function (value) {
            if (value.length < 2) {
                return '设备名至少2个字符!';
            }
            if (value.length > 10) {
                return '设备名最多10个字符!';
            }
        },
        ledCode: function (value) {
            if (value.length < 2) {
                return '设备编号至少2个字符';
            }
        },
        ledAddress: function (value) {
            if (value.length < 2) {
                return '设备地址至少2个字符';
            }
        }
        ,ledGisX: [/^[\-\+]?(0?\d{1,2}|0?\d{1,2}\.\d{1,15}|1[0-7]?\d{1}|1[0-7]?\d{1}\.\d{1,15}|180|180\.0{1,15})$/,'经度格式为:(-180～+180)']
        ,ledGisY: [/^[\-\+]?([0-8]?\d{1}|[0-8]?\d{1}\.\d{1,15}|90|90\.0{1,15})$/,'纬度格式为:(-90～+90)']

    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(ledSubmitBtnFilter)', function (data) {
        $.ajax({
            url: '/equip/led/add',
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.closeAll('iframe');
                        parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                    } else if (result.statusCode == "300") {
                        parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 2000});
                    }
                }
            },
            error: function (error) {
                parent.layer.alert(JSON.parse(error.responseText).message, {icon: 2, title: '提示'});
            }
        })
        return false;
    });
});