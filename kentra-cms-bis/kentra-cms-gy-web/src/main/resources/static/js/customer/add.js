layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'laydate', 'jquery', 'upload'], function () {
    var form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , upload = layui.upload
        , date = new Date();

    //日期
    laydate.render({
        elem: '#birthday',
        max: 'date'
    });
    laydate.render({
        elem: '#evidenceStart',
        max: 'date'
    });
    laydate.render({
        elem: '#effectiveStart'
    });
    laydate.render({
        elem: '#effectiveEnd'
    });

    //自定义验证规则
    form.verify({
        name: function (value) {
            if (value.length < 2) {
                return '用户名至少得2个字符';
            }
        },
        linkTelphone1: function (value) {
            var reg = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
            if (value == null || value == '') {
                return '请输入手机号码';
            }
            if (value != "" && value != null && !reg.test(value)) {
                return '手机号码格式不正确！';
            }
        },
        linkTelphone2: function (value) {
            var reg = /^0\d{2}-\d{7,8}$/;
            if (value != "" && value != null && !reg.test(value)) {
                return '请输入正确的座机号码！';
            }
        },
        documentNumS: function (value) {
            var reg = /^([1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/;
            var documentType = $("#documentType").val();
            if (documentType == 'document_type_0' && !reg.test(value)) {
                return '请输入正确的身份证号码！';
            }
            // var certificateReg = /^[a-zA-Z0-9]{7,21}$/;
            // if(documentType=='document_type_1'&&!reg.test(value)){
            //     return '请输入正确的驾驶证号码！';
            // }
            // if(documentType=='document_type_2'&&!certificateReg.test(value)){
            //     return '请输入正确的军官证号码！';
            // }
        },
        driveNum: function (value) {
            var documentNum = $("#documentNum").val();
            if (documentNum != value){
                return '驾驶证号码须与身份证号码保持一致！';
            }
        },
        effectiveEnd: function (value) {
            var effectiveStart = $("input[name='effectiveStart']").val();
            if (new Date(effectiveStart) > new Date(value)) {
                return '有效结束时间不小于有效期起始时间';
            }
        }
    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(customerSubmitBtnFilter)', function (data) {
        $.ajax({
            url: '/customer/management/customer/add',
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
                parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
            }
        })
        return false;
    });
});