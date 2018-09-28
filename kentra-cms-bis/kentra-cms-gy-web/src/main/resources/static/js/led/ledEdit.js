layui.use(['form', 'jquery'], function () {
    var form = layui.form
        , $ = layui.jquery;

    //自定义验证规则
    form.verify({
        name: function (value) {
            if (value.length < 2) {
                return '设备名至少2个字符!';
            }
            if (value.length > 10) {
                return '设备名最多10个字符!';
            }
        },
        ledCode: function (value) {
            if (value.length < 2) {
                return '设备编号至少2个字符';
            }
            if (ledForm.ledStatus !=='equipment_state_0' && value !=ledForm.ledCode){
                return '该设备已启用，请勿更改设备编号！';
            }
        },
        ledAddress: function (value) {
            if (value.length < 2) {
                return '设备地址至少2个字符';
            }
        }
        ,ledGisX: [/^[\-\+]?(0?\d{1,2}|0?\d{1,2}\.\d{1,15}|1[0-7]?\d{1}|1[0-7]?\d{1}\.\d{1,15}|180|180\.0{1,15})$/,'经度格式为:(-180～+180)']
        ,ledGisY: [/^[\-\+]?([0-8]?\d{1}|[0-8]?\d{1}\.\d{1,15}|90|90\.0{1,15})$/,'纬度格式为:(-90～+90)']

    });

    //表单赋值
    form.val("ledFormFilter", {
        "id":ledForm.id+""
        ,"name": ledForm.name == null ? "" : ledForm.name+""
        , "ledCode": ledForm.ledCode == null ? "" : ledForm.ledCode+""
        , "ledAddress": ledForm.ledAddress == null ? "" : ledForm.ledAddress+""
        , "ledGisX": ledForm.ledGisX == null ? "" : ledForm.ledGisX+""
        , "ledGisY": ledForm.ledGisY == null ? "" : ledForm.ledGisY+""
        , "descripInfos": ledForm.descripInfos == null ? "" : ledForm.descripInfos+""
    });
    $(document).ready(function(){
        //设备状态值
        var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[7].value;
        var ledStatus=$("#ledStatus");
        $.each(dict,function(index,value){
            if(index===0){ledStatus.append("<option value=''>请选择设备状态</option>")}
            if(value.key===ledForm.ledStatus){
                ledStatus.append("<option value='"+value.key+"' selected>"+value.value+"</option>");
            }else{
                ledStatus.append("<option value='"+value.key+"'>"+value.value+"</option>");
            }
        });
        form.render();
    });
    //提交表单  JSON.stringify(data.field)
    form.on('submit(ledFormSubmitBtnFilter)', function(data){
        $.ajax({
            url: '/equip/led/ledEdit',
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                        parent.layer.closeAll('iframe');
                    } else if (result.statusCode == "300") {
                        parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 2000});
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

var ledForm = "";