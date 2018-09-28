layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
})
.use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form, $ = layui.jquery,active = layui.tableUtils, laydate = layui.laydate;
    //自定义验证规则
    form.verify({
    	extends1: function (value) {
            if (value.length < 1) {
                return '应缴费金额不能为空!';
            }
            var reg = /^\d+(\.\d{0,2})?$/;
            if(!reg.test(value)){
                return '请输入正确格式金额!(金额数最多输入小数点后两位!)';
            }
        },
        extends2: function (value) {
        	var extends1Money = $("#extends1").val();
        	console.log(extends1Money+"-----"+value);
            if (value.length < 1) {
                return '已缴费金额不能为空!';
            }
            var reg = /^\d+(\.\d{0,2})?$/;
            if(!reg.test(value)){
                return '请输入正确格式金额!(金额数最多输入小数点后两位!)';
            }
            if (extends1Money != ""&&extends1Money<value){
            	return '已缴费用不能大于应缴费用!';
            }
        }
    });
    $(document).ready(function(){
    	//违规类型
    	var breakType=JSON.parse(window.sessionStorage.getItem("Dict"))[10].value;//违规类型
    	var remakeType=$("#remakeType");
    	$.each(breakType,function(index,value){
    		if(index==0)remakeType.append("<option value=''>请选择违规类型</option>");
    		if(value.key==breakRecordForm.remakeType){
    			remakeType.append("<option value='"+value.key+"' selected>"+value.value+"</option>");
    		}else{
    			remakeType.append("<option value='"+value.key+"'>"+value.value+"</option>");
    		}
    	});
    	//审核状态
    	var breakRemakeType=JSON.parse(window.sessionStorage.getItem("Dict"))[12].value;//审核状态
    	var auditStatus=$("#auditStatus");
    	
    	$.each(breakRemakeType,function(index,value){
    		if(index==0){auditStatus.append("<option value=''>请选择审核状态</option>")};
    		auditStatus.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    	
//    	$.each(breakRemakeType,function(index,value){
//    		if(index==0)auditStatus.append("<option value=''>请选择审核状态</option>");
//    		if(value.key==breakRecordForm.auditStatus){
//    			auditStatus.append("<option value='"+value.key+"' selected>"+value.value+"</option>");
//    		}else{
//    			auditStatus.append("<option value='"+value.key+"'>"+value.value+"</option>");
//    		}
//    	});
    	//违规类型
    	var breakType=JSON.parse(window.sessionStorage.getItem("Dict"))[8].value;//违规类型
    	var breakTypeSelect=$("#extends3");
    	$.each(breakType,function(index,value){
    		if(index==0){breakTypeSelect.append("<option value=''>请选择缴费类型</option>")};
    		breakTypeSelect.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    	//初始赋值
    	form.val("breakRecordFormFilter", {
            "id": breakRecordForm.id + "",
            "licenseNum": breakRecordForm.licenseNum == null ? "" : breakRecordForm.licenseNum + "",
            "drivingRecord":breakRecordForm.drivingRecord==null ? "":breakRecordForm.drivingRecord+"",
            "entranceTime":breakRecordForm.entranceTime==null? "":active.dateFormate(breakRecordForm.entranceTime,'yyyy-MM-dd hh:mm:ss')+"",
            "exitTime":breakRecordForm.exitTime==null? "":active.dateFormate(breakRecordForm.exitTime,'yyyy-MM-dd hh:mm:ss')+"",
            "entranceName":breakRecordForm.entranceName==null? "":breakRecordForm.entranceName+"",
            "exitName":breakRecordForm.exitName==null?"":breakRecordForm.exitName+"",
            "extends1": breakRecordForm.extends1 == null ? "0" : breakRecordForm.extends1 + "",
            "extends2": breakRecordForm.extends2 == null ? "0" : breakRecordForm.extends2 + "",
            "payMoney": breakRecordForm.payMoney == null ? "0" : breakRecordForm.payMoney + "",
            "remakeContent": breakRecordForm.remakeContent==null?"":breakRecordForm.remakeContent+""
        });
    });
    

    //提交表单  JSON.stringify(data.field)
    form.on('submit(breakRecordFormSubmitBtnFilter)', function(data){
    	var payMony=$(":input[name='payMoney']").val();
    	var auditStatus=$(":input[name='auditStatus']").val();
    	if(payMony=='0.00' && auditStatus=='break_underview_02'){
    		 parent.layer.confirm('确定审核通过待缴费用为0.00的违规记录', {icon: 3}, function (index) {
    			 parent.layer.closeAll('dialog');
    			 $.ajax({
    			        url: '/customer/breakRecord/examine',
    			        type: "post",
    			        data: data.field,
    			        dataType: "json",
    			        success: function (result) {
    			            if (result != "" && result != null) {
    			                if (result.statusCode == "200") {
    			                    parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
    			                    parent.layer.closeAll('iframe');
    			                } else if (result.statusCode == "300") {
    			                    parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
    			                }
    			            }
    			        },
    			        error: function (error) {
    			            parent.layer.alert(JSON.parse(error.responseText).messaget, {icon: 2, title: '提示'});
    			        }
    			    })
    		 });
    	}else{
    		$.ajax({
    	        url: '/customer/breakRecord/examine',
    	        type: "post",
    	        data: data.field,
    	        dataType: "json",
    	        success: function (result) {
    	            if (result != "" && result != null) {
    	                if (result.statusCode == "200") {
    	                    parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
    	                    parent.layer.closeAll('iframe');
    	                } else if (result.statusCode == "300") {
    	                    parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
    	                }
    	            }
    	        },
    	        error: function (error) {
    	            parent.layer.alert(JSON.parse(error.responseText).messaget, {icon: 2, title: '提示'});
    	        }
    	    })
    	}
        
        return false;
    });
});

function numMoney(){
	var extends1 = document.getElementById('extends1').value;
	var extends2 = document.getElementById('extends2').value;
	if(extends1 == "" || extends2 == ""){
		return false;
	}
	var num = (extends1 - extends2).toFixed(2);
	document.getElementById('payMoney').value = num;
}

var controlForm = "";