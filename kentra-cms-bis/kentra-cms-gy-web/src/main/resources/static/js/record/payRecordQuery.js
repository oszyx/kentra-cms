layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
})
.use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form, $ = layui.jquery,active = layui.tableUtils, laydate = layui.laydate;
    
    $(document).ready(function(){
    	//缴费类型
    	var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[8].value;
    	var payStatus; 
    	$.each(dict,function(index,value){
    		if(value.key==formData.payStatus)	payStatus=value.value;
    	});
    	//缴费状态
    	var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[9].value;
    	var isPay;
    	$.each(dict,function(index,value){
    		if(value.key==formData.isPay)	isPay=value.value;
    	});
    	
        //表单赋值
        form.val("payRecordQueryFormFilter", {
        	"id": formData.id + ""
            , "licenseNum": formData.licenseNum + ""
            , "drivingRecord": formData.drivingRecord + ""
            , "entranceName": formData.entranceName + ""
            , "entranceTime": active.dateFormate(formData.entranceTime, "yyyy-MM-dd hh:mm:ss")+ ""
            , "exitName":formData.exitName + ""
            , "exitTime":active.dateFormate(formData.exitTime, "yyyy-MM-dd hh:mm:ss")+""
            , "receivablesstr": formData.receivablesstr + ""
            , "payCountstr":formData.payCountstr + ""
            , "payStatus":payStatus + ""
            , "isPay":isPay + ""
            , "extends1":formData.extends1 + ""
        });
        
        //行驶轨迹
        $.ajax({
      	  type: 'POST',
      	  url: '/customer/drivingtrack/getDrivingTrack',//发送请求
      	  data: {licenseNum:formData.licenseNum,drivingRecord:formData.drivingRecord},
      	  dataType : 'json',
      	  success: function(result) {
      		var details = "";
    	  		for(var i=0;i<result.length;i++){		
    	  			details += "<div>"	
    	  			details += "<li class='layui-timeline-item' style='margin-left:50px;margin-top: 10px'>"
    	  			details += "<i class='layui-icon layui-timeline-axis'></i>"
    	  			details += "<div class='layui-timeline-content layui-text'>"
    	  			details += "<h3 class='layui-timeline-title'>"+result[i].address+ "<span style='float:right;margin-right:200px;'>"+active.dateFormate(result[i].times,"hh:mm")+"</span>"+"</h3>"
    	  			details += "</div></li>"
    	  			details += "</div>"
      		 }
    	  		details += "</div></li>"
    	  		$("#payRecordDateLine").append(details);
      	  }
      	});
    });
});

var formData = "";
