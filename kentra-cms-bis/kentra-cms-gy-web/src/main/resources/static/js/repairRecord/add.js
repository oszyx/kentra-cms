layui.use(['form', 'laydate', 'jquery'], function () {
    var form = layui.form, laydate = layui.laydate, $ = layui.jquery;

    //日期
    laydate.render({
        elem: '#repairDateStar'
    });

    laydate.render({
        elem: '#repairDateEnd'
    });

    //自定义验证规则
    form.verify({
        name: function (value) {
            if (value.length < 2) {
                return '姓名至少2个字符!';
            }
        },
        repairDateStar: function (value) {
            if (new Date(value) > new Date()) {
                return '维修开始时间不能大于当前日期';
            }
        },
        repairDateEnd: function (value) {
            if (new Date(value) > new Date()) {
                return '维修结束时间不能大于当前日期';
            }
        }
    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(repairSubmitFilter)', function (data) {
        $.ajax({
            url: '/equip/repair/add',
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.closeAll('iframe');
                        parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
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