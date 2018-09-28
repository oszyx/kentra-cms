layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form, laydate = layui.laydate, $ = layui.jquery, active = layui.tableUtils;

    //表单赋值
    form.val("repairFromFilter", {
        "id":repairForm.id+""
        ,"repairDeviceName": repairForm.repairDeviceName == null ? "" : repairForm.repairDeviceName+""
        , "repairUserName": repairForm.repairUserName == null ? "" : repairForm.repairUserName+""
        , "repairUserPhone": repairForm.repairUserPhone == null ? "" : repairForm.repairUserPhone+""
        , "repairDateStar": repairForm.repairDateStar == null ? "" :  active.dateFormate(repairForm.repairDateStar, "yyyy-MM-dd")+""
        , "repairDateEnd": repairForm.repairDateEnd == null ? "" :  active.dateFormate(repairForm.repairDateEnd, "yyyy-MM-dd")+""
        , "repairStatus": repairForm.repairStatus == null ? "" : repairForm.repairStatus+""
        , "repairNotice": repairForm.repairNotice == null ? "" : repairForm.repairNotice+""
        , "repairReason": repairForm.repairReason == null ? "" : repairForm.repairReason+""
    });

});

var repairForm = "";