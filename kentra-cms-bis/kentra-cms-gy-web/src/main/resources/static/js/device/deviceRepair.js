layui.use(['form','layer','jquery','laydate'], function () {
    var $ = layui.$,form=layui.form,layer=layui.layer,laydate=layui.laydate;
    
    //显示维修设备信息
    laydate.render({
        elem: '#repairDateStar',
        type: 'datetime'
    });

    laydate.render({
        elem: '#repairDateEnd',
        type: 'datetime'
    });
    
    form.val("deviceRepair", {
    	"repairDeviceId":deviceData.id,
        "repairDeviceName": deviceData.name
    });
    //加载维修状态
    $(document).ready(function(){
    	var selectReapirStatus=$("#repairStatus");
    	var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[11].value;
    	$.each(dict,function(index,value){
    		if(index==0) selectReapirStatus.append("<option value=''>请选择维修状态</option>");
    		selectReapirStatus.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    	form.render();
    });
    
    form.verify({
    	telphone:function(value){
    		var pattern=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/; 
    		if(!pattern.test(value)){
    			return "请输入正确电话号码";
    		}
    	},
    	repairDateStar:function(value){
    		if (new Date(value) > new Date()) {
                return '维修开始时间不能大于当前日期';
            }
    	},
    	repairDateEnd:function(value){
    		var starTime = $("#repairDateStar").val();
    		if (starTime!=null && starTime !='' && new Date(starTime) > new Date(value)) {
                return '维修结束时间不能小于开始时间';
            }
    	}
    });
    
    
    //提交维修信息
    form.on('submit(deviceAddSubmitBtn)',function(data){
    	var datas=data.field;
    	$.ajax({
        	url: '/equip/device/insertRepair',
        	type: "post",
        	data: data.field,
        	dataType: "json",
        	async:false,
        	success: function (result) {
        		if(result.statusCode=='200'){
        			parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                    parent.layer.closeAll('iframe');
        		}else if(result.statusCode=='300'){
        			parent.layer.msg(result.message, {icon: 5, shade: 0.6, time: 1000})
        		}
        	 }
    	   })
       });
    
});