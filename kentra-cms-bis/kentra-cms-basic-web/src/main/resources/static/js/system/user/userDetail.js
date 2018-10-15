layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form, active = layui.tableUtils;

    //表单赋值
    form.val("userEditFormFilter", {
        "id":formData.id+""
        ,"username": formData.username == null ? "" : formData.username+""
        , "password": formData.password == null ? "" : formData.password+""
        , "telphone": formData.telphone == null ? "" : formData.telphone+""
        , "birthday": formData.birthday==null?"":active.dateFormate(formData.birthday, "yyyy-MM-dd")+""
        , "identityCard": formData.identityCard == null ? "" : formData.identityCard+""
        , "status": formData.status == null ? "" : formData.status+""
        , "createTime":formData.createTime==null?"":active.dateFormate(formData.createTime, "yyyy-MM-dd hh:mm:ss")+""
        , "updateTime":formData.updateTime==null?"":active.dateFormate(formData.updateTime, "yyyy-MM-dd hh:mm:ss")+""
    });

});
// window.setFormValues = function (data){
var formData = "";

