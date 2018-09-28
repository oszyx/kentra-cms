layui.use(['form','layer','jquery'], function () {
    var $ = layui.$,form=layui.form,layer=layui.layer;
    
  //自定义验证
    form.verify({
    	frameGisX: function(value){
    		if(value.length == 0){
    		    return '设备经度不能为空';
    		}
    		var reg = /^[\-\+]?(0?\d{1,2}|0?\d{1,2}\.\d{1,15}|1[0-7]?\d{1}|1[0-7]?\d{1}\.\d{1,15}|180|180\.0{1,15})$/;
    		if(!reg.test(value)){
    			return '经度格式为:(-180～+180)';
			}
    	},
    	frameGisY: function(value){
    		if(value.length == 0){
    		    return '设备纬度不能为空';
    		}
    		var reg = /^[\-\+]?([0-8]?\d{1}|[0-8]?\d{1}\.\d{1,15}|90|90\.0{1,15})$/;
    		if(!reg.test(value)){
    			return '纬度格式为:(-90～+90)';
			}
    	}
    	
    });
    
    $(document).ready(function(){
    	//设备状态
    	var frameSelectStatus=$("#frameStatus");
    	var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[7].value;
    	$.each(dict,function(index,value){
    		if(index==0)frameSelectStatus.append("<option value=''>请选择设备状态</option>");
    		frameSelectStatus.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    	//重新渲染页面
    	form.render();
    });
    
    //提交方法
    form.on('submit(frameAddSubmitBtn)',function(data){
    	var datas=data.field;
    	$.ajax({
        	url: '/equip/frame/insertframe',
        	type: "post",
        	data: data.field,
        	dataType: "json",
        	async:false,
        	success: function (result) {
        		if(result.statusCode=='200'){
        			parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                    parent.layer.closeAll('iframe');
        		}else if(result.statusCode=='300'){
        			parent.layer.msg(result.message, {icon: 5, shade: 0.4, time: 1000})
        		}
        	 }
    	   })
    	   return false;
    });
    
});