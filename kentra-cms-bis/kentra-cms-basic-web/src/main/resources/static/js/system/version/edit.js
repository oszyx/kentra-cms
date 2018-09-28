layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form, $ = layui.jquery, laydate = layui.laydate, active = layui.tableUtils;

    //日期
    laydate.render({
        elem: '#vReleaseTime',
        type:'date'
    });


    //自定义验证规则
    form.verify({
        downloadUrl: function (value) {
            var reg = /(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/;
            if (!reg.test(value)) {
                return '下载地址格式不正确！';
            }
        },
        vid: function (value) {
            var reg = /^([1-9]\d|[1-9])(\.([1-9]\d|\d)){2}$/;
            if (!reg.test(value)) {
                return '版本号格式不正确！';
            }
        }
    });


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

    //提交表单
    form.on('submit(versionSubmitBtnFilter)', function(data){
        if (!data.field.vState) {
            parent.layer.msg("请选择版本状态！", {icon: 5, shade: 0.4, time: 1000});
            return false;
        }
        if (!data.field.vForcedUpdate) {
            parent.layer.msg("请选择是否强制更新！", {icon: 5, shade: 0.4, time: 1000});
            return false;
        }
        $.ajax({
            url: '/api/version/edit',
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000});
                        parent.layer.closeAll('iframe');
                    } else if (result.statusCode == "300") {
                        parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
                    }
                }
            },
            error: function (error) {
                parent.layer.alert(JSON.parse(error.responseText).message, {icon: 2, title: '提示'});
            }
        });
        return false;
    });

});
var formData = "";

