var formRoleData = "";
layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'jquery', 'tableUtils'], function () {
    var form = layui.form, $ = layui.jquery, active = layui.tableUtils;

    //自定义验证规则
    form.verify({
        roleName: [/[\S]+/, '角色名称不能为空'],
        roleCode: [/[\S]+/, '角色编号不能为空']
    });

    //表单赋值
    form.val("roleEditFormFilter", {
        "id": formRoleData.id + ""
        , "roleName": formRoleData.roleName + ""
        , "roleCode": formRoleData.roleCode + ""
        , "desc": formRoleData.desc + ""
    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(roleEditSubmitBtn)', function (data) {
        $.ajax({
            url: '/api/role/edit',
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


