layui.use(['form', 'jquery'], function () {
    var form = layui.form, $ = layui.jquery;

    //自定义验证规则
    form.verify({
        roleName: [/[\S]+/, '角色名称不能为空'],
        roleCode: [/[\S]+/, '角色编号不能为空']
    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(roleAddSubmitBtn)', function (data) {
        $.ajax({
            url: '/api/role/add',
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
                parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
            }
        })
        return false;
    });
});