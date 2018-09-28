layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form , $ = layui.jquery ,active = layui.tableUtils , laydate = layui.laydate;
    
    //必填字段验证
    form.verify({
    	
    	payCount: function(value){
    		if(value.length == 0){
    			return '已缴费用不能为空';
    		}
    		var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    		if(!reg.test(value)){
    			return '请输入正确格式金额!(金额数最多输入小数点后两位!)';
    		}
    		var fla1 = $("#receivablesParam").val();
    		var fla2 = $("#payCountParam").val();
    		if(fla1 != "" && fla1 * 100 < fla2 * 100){
    			return '已缴费用不能大于应缴费用!';
    		}
    	},
    	receivables: function(value){
    		if(value.length == 0){
    			return '应缴费用不能为空';
    		}
    		var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    		if(!reg.test(value)){
    			return '请输入正确格式金额!(金额数最多输入小数点后两位!)';
    		}
    	}
    });
    
    //表单赋值
    form.val("IrregularitiesFormFilter", {
        "id": formData.id + ""
        , "drivingRecord":formData.drivingRecord + ""
        , "licenseNum": formData.licenseNum + ""
        ,"drivingRecord":formData.drivingRecord+""
        , "entranceName": formData.entranceName + ""
        , "entranceTime": active.dateFormate(formData.entranceTime, "yyyy-MM-dd hh:mm:ss")+""
        , "exitName":formData.exitName + ""
        , "exitTime":active.dateFormate(formData.exitTime, "yyyy-MM-dd hh:mm:ss")+""        
        , "payCount":"" 	//已缴费用
        , "receivables": "" //应缴费用
        , "extends1": "" //违规类型
        , "extends2": "" //违规备注
    });
    //加载：违规类型下拉框 
    $(document).ready(function(){
    	var breadkStatus=$("#extends1");
    	var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[10].value;
    	$.each(dict,function(index,value){
    		if(index==0) breadkStatus.append("<option value=''>请选择违规类型</option>");
    		breadkStatus.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    	form.render();
    });
    
  //提交表单  JSON.stringify(data.field)
    form.on('submit(IrregularitiesSubmitBtn)', function (data) {
        $.ajax({
            url: '/customer/drivingrecord/saveIrregularities',
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
        return false;
    });

});
var formData = "";
