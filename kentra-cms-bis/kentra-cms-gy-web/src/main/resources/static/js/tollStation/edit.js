layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
})
.use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form
        , $ = layui.jquery
        ,active = layui.tableUtils
        , laydate = layui.laydate;
    
    //自定义验证规则
    form.verify({
    	tollStationName: function (value) {
            if (value.length < 1) {
                return '收费站名称不能为空!';
            }
        },
        tollStationCode: function (value) {
            if (value.length < 1) {
                return '收费站编码不能为空!';
            }
        },
        longitude: function (value) {
            if (value.length < 1) {
                return '经度不能为空!';
            }
            var reg = /^[\-\+]?(0?\d{1,2}|0?\d{1,2}\.\d{1,15}|1[0-7]?\d{1}|1[0-7]?\d{1}\.\d{1,15}|180|180\.0{1,15})$/;
            if(!reg.test(value)){
                return '经度格式错误【-180度～+180度】';
            }
        },
        latitude: function (value) {
            if (value.length < 1) {
                return '纬度不能为空!';
            }
            var reg = /^[\-\+]?([0-8]?\d{1}|[0-8]?\d{1}\.\d{1,15}|90|90\.0{1,15})$/;
            if(!reg.test(value)){
                return '纬度格式错误【-90度～+90度】';
            }
        }
    });

    
    form.val("tollStationFormFilter", {
        "id": tollStationForm.id + ""
        , "tollStationName": tollStationForm.tollStationName == null ? "" : tollStationForm.tollStationName + ""
        , "tollStationCode": tollStationForm.tollStationCode == null ? "" : tollStationForm.tollStationCode + ""
        , "longitude": tollStationForm.longitude == null ? "" : tollStationForm.longitude + ""
        , "latitude": tollStationForm.latitude == null ? "" : tollStationForm.latitude + ""
    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(tollStationSubmitBtnFilter)', function(data){
        $.ajax({
            url: '/customer/tollStation/edit',
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

