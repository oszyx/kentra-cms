layui.use(['form','layer','jquery'], function () {
    var $ = layui.$,form=layui.form,layer=layui.layer;
    
  //自定义验证
    form.verify({
    	
    	
    	deviceGisX: function(value){
    		if(value.length == 0){
    		    return '设备经度不能为空';
    		}
    		var reg = /^[\-\+]?(0?\d{1,2}|0?\d{1,2}\.\d{1,15}|1[0-7]?\d{1}|1[0-7]?\d{1}\.\d{1,15}|180|180\.0{1,15})$/;
    		if(!reg.test(value)){
    			return '经度格式为:(-180～+180)';
			}
    	},
    	deviceGisY: function(value){
    		if(value.length == 0){
    		    return '设备纬度不能为空';
    		}
    		var reg = /^[\-\+]?([0-8]?\d{1}|[0-8]?\d{1}\.\d{1,15}|90|90\.0{1,15})$/;
    		if(!reg.test(value)){
    			return '纬度格式为:(-90～+90)';
			}
    	}
    	
    });
    
    //显示设备详情
    form.val("deviceForm", {
    	"id":formData.id,
        "name": formData.name,
        "deviceCode": formData.deviceCode, 
        "deviceGisX": formData.deviceGisX , 
        "deviceGisY":formData.deviceGisY , 
        /*"deviceStatus":formData.deviceStatus, 
        "belongEqipment":formData.belongEqipment,*/
        "descripInfos":formData.descripInfos,
        "deviceAddress":formData.deviceAddress
    });
    
    //deviceStatus、belongEqipment单独赋值
    $(document).ready(function(){
    	//设备状态值
    	var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[7].value;
    	var deviceSelectStatus=$("#deviceStatus");
    	$.each(dict,function(index,value){
    		if(index==0){deviceSelectStatus.append("<option value=''>请选择设备状态</option>")};
    		if(value.key==formData.deviceStatus){
    			deviceSelectStatus.append("<option value='"+value.key+"' selected>"+value.value+"</option>");
    		}else{
    			deviceSelectStatus.append("<option value='"+value.key+"'>"+value.value+"</option>");
    		}
    	});
    	//所属设备值
    	$.ajax({
        	url: '/equip/device/getDeviceBelEqu',
        	type: "post",
        	data: {},
        	dataType: "json",
        	async:false,
        	success: function (result) {
        		var BelEquiSelect=$("#belongEqipment");
        		if(BelEquiSelect!=undefined){
        			BelEquiSelect.append("<option value=''>请选择</option>");
        			for(var i=0;i<result.length;i++){
            			if(result[i].id==formData.belongEqipment){
            				BelEquiSelect.append("<option value="+result[i].id+" selected>"+result[i].name+"</option>");
            			}else{
            				BelEquiSelect.append("<option value="+result[i].id+">"+result[i].name+"</option>");
            			}
            		}
        		}
        	}
    	});
    	form.render();
    });
    
  //提交方法
    form.on('submit(deviceAddSubmitBtn)',function(data){
    	var datas=data.field;
    	$.ajax({
        	url: '/equip/device/updateDevice',
        	type: "post",
        	data: data.field,
        	dataType: "json",
        	async:false,
        	success: function (result) {
        		if(result.statusCode=='200'){
        			parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                    parent.layer.closeAll('iframe');
        		}else if(result.statusCode=='300'){
        			parent.layer.msg(result.message, {icon: 5, shade: 0.6, time: 2000})
        		}
        	 }
    	   })
    	   return false;
    });
    
});