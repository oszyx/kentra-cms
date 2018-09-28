layui.use(['form', 'element'], function () {
    var $ = layui.$,
    	element=layui.element;

    $.ajax({
  	  type: 'POST',
  	  url: '/customer/cardPort/getCardPortIllegalImages',//发送请求
  	  data: {licenseNum:breakRecordForm.licenseNum,drivingRecord:breakRecordForm.drivingRecord},
  	  dataType : 'json',
  	  success: function(result) {  
  		var details = "";
//  			details += "<h4 class='layui-timeline-title' style='margin-left: 60px;margin-top: 10px'>"+createTime(result[0].passTime)+ "<span style='margin-left:70px;'>"+result[0].stationName+"</span>"+"</h4>"
		for(var i=0;i<result.length;i++){
			details += "<h4 class='layui-timeline-title' style='margin-left: 60px;margin-top: 10px'>"+createTime(result[i].passTime)+ "<span style='margin-left:70px;'>"+result[i].stationName+"</span>"+"</h4>"
			details += "<img src= '"+result[i].imgUrl+"' style='width:82%; margin-left: 60px;margin-top: 10px' />"
  		 }
		$("#IllegalImage").append(details);
  	  }
  	});
});

function createTime(v){
	var date = new Date(v);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    m = m<10?'0'+m:m;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var h = date.getHours();
    h = h<10?("0"+h):h;
    var M = date.getMinutes();
    M = M<10?("0"+M):M;
    var str = y+"-"+m+"-"+d+" "+h+":"+M;
    return str;
}

var breakRecordForm = "";