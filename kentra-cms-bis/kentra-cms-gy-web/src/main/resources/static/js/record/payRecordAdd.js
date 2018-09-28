var index;

layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['layer','form', 'laydate', 'jquery','tableUtils'], function () {
    var form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , layer = layui.layer
        , active = layui.tableUtils;

  //自定义验证规则
    form.verify({
    	payCountstr: function(value){
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
    	receivablesstr: function(value){
    		if(value.length == 0){
    			return '应缴费用不能为空';
    		}
    		var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    		if(!reg.test(value)){
    			return '请输入正确格式金额!(金额数最多输入小数点后两位!)';
    		}
    	},
    	expensesPaidstr: function(value){
    		if(value.length == 0){
    			return '待缴费用不能为空';
    		}
    		var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    		if(!reg.test(value)){
    			return '请输入正确金额!';
    		}
    	},
    	
    	payTime:function(value){
    		if(value.length == 0){
    			return '支付时间不能为空';
    		}
    		if (new Date(value) > new Date()) {
                return '支付时间不能晚于当前时间';
            }
    	},
    	isPay:function(value){
    		if(value.length == ""){
    			return '缴费状态不能为空,请选择缴费状态';
    		}
    		var fla1 = $("#receivablesParam").val();
    		var fla2 = $("#payCountParam").val();
    		if (fla1*100 == fla2*100 && value != "payment_state_0") {
                return '费用已缴清,请选择完成缴费';
            }
    		if (fla1*100 > fla2*100 && value != "payment_state_1") {
                return '费用未缴清,请选择未完成缴费';
            }
    	}
    	,tollGate: [/[\S]+/, '收费站名不能为空']
    	,drivingRecord: [/[\S]+/, '行驶记录ID不能为空!']
    });
    
//    laydate.render({
//        elem: '#entranceTime',
//        type: 'datetime'
//    });
//    
//    laydate.render({
//        elem: '#exitTime',
//        type: 'datetime'
//    });
    
    //车牌查询按钮
    $("#searchBtn").click(function(){
    	var searchParam=$("#searchParam").val();
    	if(searchParam=="" || searchParam==null){
    		parent.layer.msg("请输入车牌号", {icon: 5, shade: [0.4], time: 2000});
    		return;
    	}
    	//调用父窗口方法弹出层
    	//parent.serachLicense(searchParam);
    	parent.layer.open({
            type: 2,
            title: '行驶记录查询信息',
            area: ['700px', '420px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/breakRecord/licenseSerach',
            success:function(layero,index){
            	var body = parent.layer.getChildFrame('body', index);
            	body.find("#licenseNum").val(searchParam);
            }
        });
    });
    
    $(document).ready(function(){
    	//加载缴费类型、缴费状态数据字典
    	var dict1=JSON.parse(window.sessionStorage.getItem("Dict"))[8].value;
    	var payStatus=$("#payStatus");
    	$.each(dict1,function(index,value){
    		if(index==0)payStatus.append("<option value=''>请选择缴费类型</option>");
    		payStatus.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    	var dict2=JSON.parse(window.sessionStorage.getItem("Dict"))[9].value;
    	var isPay=$("#isPay");
    	$.each(dict2,function(index,value){
    		if(index==0)isPay.append("<option value=''>请选择缴费状态</option>");
    		isPay.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    	//重新渲染页面
    	form.render();
    });
    
    
    //提交表单  JSON.stringify(data.field)
    form.on('submit(payRecordAddSubmitBtn)', function (data) {
        $.ajax({
            url: '/customer/record/goAdd',
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
                parent.layer.alert(JSON.parse(error.responseText).message, {icon: 2, title: '提示'});
            }
        })
        return false;
    });

});

//编辑
function addDrivingRecord(id){
	document.getElementById('drivingRecord').value = id;
    layer.close(index);
}

function contPay(){
	layui.use(['jquery','layer','form'],function(){
		var $=layui.$,layer=layui.layer,form=layui.form;
		var fla1 = $("#receivablesParam").val();
		var fla2 = $("#payCountParam").val();
		var reg = /^\d+(\.\d{0,2})?$/;//校验规则
		if(fla1!='' && fla1!=null & fla2!='' && fla2!=null){
			if(parseFloat(fla1)<parseFloat(fla2)){
				parent.layer.msg("已缴费用不能大于应缴费用!",{icon: 5, shade: [0.4], time: 2000});
				return;
			  }else if(!reg.test(fla1) || !reg.test(fla2)){
				parent.layer.msg("请输入正确格式金额!(金额数最多输入小数点后两位!)",{icon: 5, shade: [0.4], time: 2000});
				return;
			  }else if ( parseFloat(fla1)== parseFloat(fla2)) {
				$("#isPay").val("payment_state_0"); 
		      }else if (parseFloat(fla1) > parseFloat(fla2)) {
				$("#isPay").val("payment_state_1"); 
		    }
		}
		form.render(); 
	})
	
}