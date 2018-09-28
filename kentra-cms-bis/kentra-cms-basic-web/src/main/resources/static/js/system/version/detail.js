layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form, active = layui.tableUtils;

    //表单赋值
    form.val("versionFormFilter", {
        "id":formData.id+""
        ,"vId": formData.vId == null ? "" : formData.vId+""
        , "vName": formData.vName == null ? "" : formData.vName+""
        , "vDownloadUrl": formData.vDownloadUrl == null ? "" : formData.vDownloadUrl+""
        , "vForcedUpdate": formData.vForcedUpdate==null?"":formData.vForcedUpdate+""
        , "identityCard": formData.identityCard == null ? "" : formData.identityCard+""
        , "vState": formData.vState == null ? "" : formData.vState+""
        , "vReleaseTime":formData.vReleaseTime==null?"":active.dateFormate(formData.vReleaseTime, "yyyy-MM-dd")+""
    });

});
var formData = "";

