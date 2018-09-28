layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils','laytpl'], function () {
    var table = layui.table, $ = layui.$, active = layui.tableUtils,laytpl=layui.laytpl,form=layui.form;
    
    $(document).ready(function(){
    	var userId=$("#userId").val();
    	$.ajax({
        	url: '/api/user/findById',
        	type: "post",
        	data: {id: userId},
        	dataType: "json",
        	success: function (result) {
            	if(result!=null){
            		var birthday,createTime,updateTime;
            		if(result.birthday!=null && result.birthday!=''){
            			birthday=Format(result.birthday,'yyyy-MM-dd')
            		}else{
            			birthday="";
            		}
            		if(result.createTime!=null && result.createTime!=''){
            			createTime=Format(result.createTime,'yyyy-MM-dd hh:mm:ss')
            		}else{
            			createTime="";
            		}
            		if(result.updateTime!=null && result.updateTime!=''){
            			updateTime=Format(result.updateTime,'yyyy-MM-dd hh:mm:ss')
            		}else{
            			updateTime="";
            		}
            		
            		form.val("index_userInfosPage", {
            	    	"id":result.id,
            	        "username": result.username, //用户名
            	        "telphone": result.telphone, //联系电话
            	        "birthday": birthday,//出生日期 
            	        "identityCard":result.identityCard , //身份证号
            	        "createTime":createTime,//创建日期
            	        "updateTime":updateTime//更新日期
            	    });
            	}
        	},
        	error: function (error) {
            	parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
        	}
    	})
    });
    
});