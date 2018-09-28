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
    form.val("roleQueryFormFilter", {
        "id": formRoleData.id + ""
        , "roleName": formRoleData.roleName + ""
        , "roleCode": formRoleData.roleCode + ""
        , "relySystem": formRoleData.relySystem + ""
        , "desc": formRoleData.desc + ""
        , "status": formRoleData.status + ""
    });
});