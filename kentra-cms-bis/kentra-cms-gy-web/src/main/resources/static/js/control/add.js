layui.use(['form', 'jquery'], function () {
    var form = layui.form, $ = layui.jquery;
    //网络状态
    var netStatus = JSON.parse(window.sessionStorage.getItem("Dict"))[16].value;
    //天线状态
    var equipStatus=JSON.parse(window.sessionStorage.getItem("Dict"))[17].value;
    
    $(document).ready(function(){
        //网络状态下拉
        var netStatusSelect=$("#controllerStatus");
        $.each(netStatus,function(index,value){
            if(index==0){
            	netStatusSelect.append("<option value=''>请选择网络状态</option>");
            }
            netStatusSelect.append("<option value='"+value.key+"'>"+value.value+"</option>");
        });
      //天线状态下拉
        var equipStatusSelect=$("#extends3");
        $.each(equipStatus,function(index,value){
            if(index==0){
            	equipStatusSelect.append("<option value=''>请选择天线状态</option>");
            }
            equipStatusSelect.append("<option value='"+value.key+"'>"+value.value+"</option>");
        });
        //重新渲染页面
        form.render();
    });

    //自定义验证规则
    form.verify({
        name: function (value) {
            if (value.length < 2) {
                return '设备名至少2个字符!';
            }
        },
        controllerCode: function (value) {
            if (value.length < 2) {
                return '设备编号至少2个字符';
            }
        },
        controllerAddress: function (value) {
            if (value.length < 2) {
                return '设备地址至少2个字符';
            }
        }
        ,
        controllerGisX: [/^[\-\+]?(0?\d{1,2}|0?\d{1,2}\.\d{1,15}|1[0-7]?\d{1}|1[0-7]?\d{1}\.\d{1,15}|180|180\.0{1,15})$/, '经度格式为:(-180～+180)']
        ,
        controllerGisY: [/^[\-\+]?([0-8]?\d{1}|[0-8]?\d{1}\.\d{1,15}|90|90\.0{1,15})$/, '纬度格式为:(-90～+90)']
        ,extends1: function(value){
        	if(value.length == 0){
        		return '网络地址不能为空';
        	}
        	var reg = /^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/;
        	if(!reg.test(value)){
        		return '请输入正确格式网络地址!';
        	}
        }
        ,extends2: function(value){
        	if(value.length == 0){
        		return '网络端口不能为空';
        	}
        	var reg = /^[0-9]\d{0,4}$/;
        	if(!reg.test(value)){
        		return '请输入正确格式网络端口!';
        	}
        }		
    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(controlSubmitBtnFilter)', function (data) {
        $.ajax({
            url: '/equip/control/add',
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.closeAll('iframe');
                        parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                    } else if (result.statusCode == "300") {
                        parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 2000});
                    }
                }
            },
            error: function (error) {
                parent.layer.alert(JSON.parse(error.responseText).message, {icon: 2, title: '提示'});
            }
        })
        return false;
    });
});