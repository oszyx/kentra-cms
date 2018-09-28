layui.use(['form','layer','jquery'], function () {
    var $ = layui.$,form=layui.form,layer=layui.layer;
    
    //显示设备详情
    form.val("deviceForm", {
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
    	$.each(dict,function(index,value){
    		if(value.key==formData.deviceStatus){
    			$("input[name='deviceStatus']").val(value.value);
    		}
    	});
    	//所属设备值
    	$.ajax({
        	url: '/equip/device/getDeviceBelEqu',
        	type: "post",
        	data: {id:formData.belongEqipment},
        	dataType: "json",
        	async:false,
        	success: function (result) {
        		if(result!=null && result.length==1){
        			$("input[name='belongEqipment']").val(result[0].name);
        		}
        	},
        	error: function (error) {
            	parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
        	}
       });
    	
    });
    
});