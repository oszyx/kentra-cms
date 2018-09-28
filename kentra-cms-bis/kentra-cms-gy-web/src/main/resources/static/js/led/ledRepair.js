layui.use(['form', 'laydate', 'jquery'], function () {
    var form = layui.form, laydate = layui.laydate, $ = layui.jquery;

    //日期
    laydate.render({
        elem: '#repairDateStar'
        ,type: 'datetime'
    });

    laydate.render({
        elem: '#repairDateEnd'
        ,type: 'datetime'
    });

    //自定义验证规则
    form.verify({
        name: function (value) {
            if (value.length < 2) {
                return '姓名至少2个字符!';
            }
            if (value.length > 10) {
                return '设备名最多10个字符!';
            }
        },
        repairDateStar: function (value) {
            if (new Date(value) > new Date()) {
                return '维修开始时间不能大于当前日期';
            }
        },
        telphone: [/^[1][3,4,5,6,7,8,9][0-9]{9}$/, '手机号码格式不正确'],
        repairDateEnd: function (value) {
            var repairDateStar = $("input[name='repairDateStar']").val();
            if (new Date(repairDateStar) > new Date(value)) {
                return '维修结束时间不能小于维修开始时间';
            }
            if (new Date(value) > new Date()) {
                return '维修结束时间不能大于当前日期';
            }
        },
        repairUserName: function (value) {
            if (value.length < 2) {
                return '设备名至少2个字符!';
            }
        }
    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(lefSubmitFilter)', function(data){
        $.ajax({
            url: '/equip/led/ledRepair',
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                        parent.layer.closeAll('iframe');
                    } else if (result.statusCode == "300") {
                        parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
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