var formData = "";
layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , active = layui.tableUtils;

    //日期
    laydate.render({
        elem: '#registerDate',
        max: 'date'
    });
    laydate.render({
        elem: '#issueDate',
        max: 'date'
    });

    //自定义验证规则
    form.verify({
        name: function (value) {
            if (value.length < 2) {
                return '用户名至少得2个字符啊';
            }
        },
        licenseNum: function (value) {
            // [/^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/,'车牌号格式错误'],
            var plateNumPrefix = $('#plateNumPrefix').val();
            var licNum = $('#licNum').val();
            if (plateNumPrefix != null && licNum != null) {
                var licenseNums = plateNumPrefix + licNum;
                // var reg = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
                var reg = /^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$/;
                if (!reg.test(licenseNums)) {
                    return '车牌号格式错误';
                }
            } else {
                return '请输入车牌号码！';
            }
        },
        carIndetcode: [/^([A-Z0-9]{17})$/, '车辆识别代号格式错误'],
        carFramenumber: [/^[\da-zA-Z]{7,8}$/, '发动机编号格式错误'],
        issueDate: function (value) {
            var registerDate = $("input[name='registerDate']").val();
            if (new Date(registerDate) > new Date(value)) {
                return '注册时间不可晚于发证时间';
            }
        }
    });

    //表单赋值
    form.val("drivingLicenseFromFilter", {
        "customerId": formData[0].id + ""
    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(drivingLicenseSubmitBtnFilter)', function (data) {
        var licenseNums = $('#plateNumPrefix').val() + "·" + $('#licNum').val();
        data.field.licenseNum = licenseNums;
        $.ajax({
            url: '/customer/management/drivingLicense/add',
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