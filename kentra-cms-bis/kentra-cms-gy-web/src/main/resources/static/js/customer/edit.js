var formData = "";
layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form, $ = layui.jquery, laydate = layui.laydate, active = layui.tableUtils, date = new Date();

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
        elem: '#effectiveStart',
        type: 'date'
    });
    laydate.render({
        elem: '#effectiveEnd',
        type: 'date'
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
        }
        , linkTelphone2: function (value) {
            var reg = /^0\d{2}-\d{7,8}$/;
            if (value != "" && value != null && !reg.test(value)) {
                return '请输入正确的座机号码！';
            }
        },
        documentNumS: function (value) {
            var reg = /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/;
            var documentType = $("#documentType").val();
            if (documentType == 'document_type_0' && !reg.test(value)) {
                return '请输入正确的身份证号码！';
            }
            // var certificateReg = /^[a-zA-Z0-9]{7,21}$/;
            // if (documentType == 'document_type_1' && !reg.test(value)) {
            //     return '请输入正确的驾驶证号码！';
            // }
            // if (documentType == 'document_type_2' && !certificateReg.test(value)) {
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
                return '有效开始时间不可晚于有效结束时间';
            }
        }
    });

    //表单赋值
    form.val("customerFromFilter", {
        "id": formData[0].id + ""
        ,
        "name": formData[0].name == null ? "" : formData[0].name + ""
        ,
        "birthday": formData[0].birthday == null ? "" : active.dateFormate(formData[0].birthday, "yyyy-MM-dd") + ""
        ,
        "linkTelphone1": formData[0].linkTelphone1 == null ? "" : formData[0].linkTelphone1 + ""
        ,
        "linkTelphone2": formData[0].linkTelphone2 == null ? "" : formData[0].linkTelphone2 + ""
        ,
        "documentNum": formData[0].documentNum == null ? "" : formData[0].documentNum + ""
        ,
        "driveNum": formData[0].driveNum == null ? "" : formData[0].driveNum + ""
        ,
        "linkAddress": formData[0].linkAddress == null ? "" : formData[0].linkAddress + ""
        ,
        "evidenceStart": formData[0].evidenceStart == null ? "" : active.dateFormate(formData[0].evidenceStart, "yyyy-MM-dd") + ""
        ,
        "effectiveStart": formData[0].effectiveStart == null ? "" : active.dateFormate(formData[0].effectiveStart, "yyyy-MM-dd") + ""
        ,
        "effectiveEnd": formData[0].effectiveEnd == null ? "" : active.dateFormate(formData[0].effectiveEnd, "yyyy-MM-dd") + ""
    });
    $(document).ready(function () {
        var dicSex = JSON.parse(window.sessionStorage.getItem("Dict"))[1].value;
        var dicCity = JSON.parse(window.sessionStorage.getItem("Dict"))[3].value;
        var dicDocumentType = JSON.parse(window.sessionStorage.getItem("Dict"))[4].value;
        var drivingCarModel = JSON.parse(window.sessionStorage.getItem("Dict"))[5].value;
        //设备状态值
        var sex = $("#sex");
        var national = $("#national");
        var documentType = $("#documentType");
        var driveType = $("#driveType");
        $.each(dicSex, function (index, value) {
            if (index === 0) {
                sex.append("<option value=''>请选择性别</option>")
            }
            if (value.key === formData[0].sex) {
                sex.append("<option value='" + value.key + "' selected>" + value.value + "</option>");
            } else {
                sex.append("<option value='" + value.key + "'>" + value.value + "</option>");
            }
        });
        $.each(dicCity, function (index, value) {
            if (index === 0) {
                national.append("<option value=''>请选择国籍</option>")
            }
            if (value.key === formData[0].national) {
                national.append("<option value='" + value.key + "' selected>" + value.value + "</option>");
            } else {
                national.append("<option value='" + value.key + "'>" + value.value + "</option>");
            }
        });
        $.each(dicDocumentType, function (index, value) {
            if (index === 0) {
                documentType.append("<option value=''>请选择证件类型</option>")
            }
            if (value.key === formData[0].documentType) {
                documentType.append("<option value='" + value.key + "' selected>" + value.value + "</option>");
            } else {
                documentType.append("<option value='" + value.key + "'>" + value.value + "</option>");
            }
        });
        $.each(drivingCarModel, function (index, value) {
            if (index === 0) {
                driveType.append("<option value=''>请选择准驾车型</option>")
            }
            if (value.key === formData[0].driveType) {
                driveType.append("<option value='" + value.key + "' selected>" + value.value + "</option>");
            } else {
                driveType.append("<option value='" + value.key + "'>" + value.value + "</option>");
            }
        });
        form.render();
    });
    //提交表单  JSON.stringify(data.field)
    form.on('submit(customerFromSubmitBtnFilter)', function (data) {
        $.ajax({
            url: '/customer/management/customer/edit',
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