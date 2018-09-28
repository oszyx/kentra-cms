layui.use(['form','layer','jquery'], function () {
    var $ = layui.$,form=layui.form,layer=layui.layer;
    
    //显示设备详情
    form.val("frameForm", {
        "name": formData.name,
        "frameCode": formData.frameCode, 
        "frameGisX": formData.frameGisX , 
        "frameGisY":formData.frameGisY ,
        "descripInfos":formData.descripInfos,
        "frameAddress":formData.frameAddress
    });
    
    //frameStatus单独赋值
    $(document).ready(function(){
    	//设备状态值
    	var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[7].value;
    	$.each(dict,function(index,value){
    		if(value.key==formData.frameStatus){
    			$("input[name='frameStatus']").val(value.value);
    		}
    	});
    });
    
});