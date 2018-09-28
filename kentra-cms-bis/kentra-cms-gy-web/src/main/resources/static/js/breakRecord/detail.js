layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
})
.use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form, $ = layui.jquery,active = layui.tableUtils, laydate = layui.laydate;
    
     $(document).ready(function(){
    	 //表单赋值
    	   var breakType=JSON.parse(window.sessionStorage.getItem("Dict"))[10].value;
           var remakeType;
           $.each(breakType,function(index,value){
        	   if(value.key==breakRecordForm.remakeType) remakeType=value.value;
           });
           form.val("breakRecordFormFilter", {
               "id": breakRecordForm.id + ""
               , "licenseNum": breakRecordForm.licenseNum == null ? "" : breakRecordForm.licenseNum + ""
               , "drivingRecord": breakRecordForm.drivingRecord == null ? "" : breakRecordForm.drivingRecord + ""
               , "entranceTime": active.dateFormate(breakRecordForm.entranceTime, "yyyy-MM-dd hh:mm:ss")+""
               , "exitTime": active.dateFormate(breakRecordForm.exitTime, "yyyy-MM-dd hh:mm:ss")+""
               , "entranceName": breakRecordForm.entranceName == null ? "" : breakRecordForm.entranceName + ""
               , "exitName": breakRecordForm.exitName == null ? "" : breakRecordForm.exitName + ""
               , "extends1": breakRecordForm.extends1 == null ? "" : breakRecordForm.extends1 + ""
               , "extends2": breakRecordForm.extends2 == null ? "" : breakRecordForm.extends2 + ""
               , "payMoney": breakRecordForm.payMoney == null ? "" : breakRecordForm.payMoney + ""
               , "remakeType": breakRecordForm.remakeType == null ? "" : remakeType + ""
               , "remakeContent": breakRecordForm.remakeContent == null ? "" : breakRecordForm.remakeContent + ""
           });
           //行驶轨迹
           $.ajax({
         	  type: 'POST',
         	  url: '/customer/drivingtrack/getDrivingTrack',//发送请求
         	  data: {licenseNum:breakRecordForm.licenseNum,drivingRecord:breakRecordForm.drivingRecord},
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
     	  		$("#breakRecordDateLine").append(details);
         	  }
         	});
       });
        
});
var breakRecordForm = "";