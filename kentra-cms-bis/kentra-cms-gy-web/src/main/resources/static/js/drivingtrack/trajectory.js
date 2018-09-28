layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils','laytpl'], function () {
    var table = layui.table, $ = layui.$, form=layui.form ,active = layui.tableUtils,laytpl=layui.laytpl;

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
		$("#drivingDetailsDateLine").append(details);
  		  
  	  }
  	});
    
    //显示轨迹信息
    form.val("drivingTrackForm", {
        "licenseNum": formData.licenseNum,
        "entranceName": formData.entranceName, 
        "entranceTime":formData.entranceTime==null?"暂无数据":active.dateFormate(formData.entranceTime,"hh:mm"), 
        "exitName":formData.exitName , 
        "exitTime":formData.exitTime==null?"暂无数据":active.dateFormate(formData.exitTime,"hh:mm"), 
        "travelTime":formData.entranceTime==null?"暂无数据":active.dateFormate(formData.entranceTime,"yyyy年MM月dd日") 
    });

});
var travelTime ;
var formData = "";