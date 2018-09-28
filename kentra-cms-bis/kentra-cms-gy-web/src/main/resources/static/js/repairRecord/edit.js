layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form, laydate = layui.laydate, $ = layui.jquery, active = layui.tableUtils;

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

    //提交表单  JSON.stringify(data.field)
    form.on('submit(repairSubmitFilter)', function(data){
        $.ajax({
            url: '/equip/repair/edit',
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
                parent.layer.alert(JSON.parse(error.responseText).messaget, {icon: 2, title: '提示'});
            }
        })
        return false;
    });
});

var repairForm = "";