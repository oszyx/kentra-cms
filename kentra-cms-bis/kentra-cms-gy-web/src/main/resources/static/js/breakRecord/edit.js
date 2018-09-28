layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
})
.use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form, $ = layui.jquery,active = layui.tableUtils, laydate = layui.laydate;
    var nowTime = new Date().valueOf();
    var max = null;
    var start = laydate.render({
        elem: '#entranceTime',
        type: 'datetime',
        max: nowTime,
        btns: ['clear', 'confirm'],
        done: function(value, date){
            endMax = end.config.max;
            end.config.min = date;
            end.config.min.month = date.month -1;
        }
    });
    var end = laydate.render({
        elem: '#exitTime',
        type: 'datetime',
        max: nowTime,
        done: function(value, date){
            if($.trim(value) == ''){
                var curDate = new Date();
                date = {'date': curDate.getDate(), 'month': curDate.getMonth()+1, 'year': curDate.getFullYear()};
            }
            start.config.max = date;
            start.config.max.month = date.month -1;
        }
    });
    
    //自定义验证规则
    form.verify({
    	licenseNum: function (value) {
            if (value.length < 1) {
                return '车牌号码不能为空!';
            }
            var reg = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
            if(!reg.test(value)){
                return '请输入正确的车牌号码！';
            }
        },
        drivingRecord: function (value) {
            if (value.length < 1) {
                return '行驶记录不能为空!';
            }
        },
        entranceTime: function (value) {
            if (value.length < 1) {
                return '行驶时间起不能为空!';
            }
        },
        exitTime: function (value) {
            if (value.length < 1) {
                return '行驶时间止不能为空!';
            }
        },
        entranceName: function (value) {
            if (value.length < 1) {
                return '入口不能为空!';
            }
        },
        exitName: function (value) {
            if (value.length < 1) {
                return '出口不能为空!';
            }
        },
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
            if (value.length < 1) {
                return '已缴费金额不能为空!';
            }
            var reg = /^\d+(\.\d{0,2})?$/;
            if(!reg.test(value)){
                return '请输入正确格式金额!(金额数最多输入小数点后两位!)';
            }
            if (extends1Money != ""&& parseFloat(extends1Money)<parseFloat(value)){
            	return '已缴费用不能大于应缴费用!';
            }
        },
        remakeType: function (value) {
            if (value.length < 1) {
                return '违规类型不能为空!';
            }
        }
    });
    
    //加载数据
    $(document).ready(function(){
    	//违规类型
    	var breakType=JSON.parse(window.sessionStorage.getItem("Dict"))[10].value;
    	var remakeType=$("#remakeType");
    	$.each(breakType,function(index,value){
    		if(index==0) remakeType.append("<option value=''>请选择违规类型</option>");
    		if(value.key==breakRecordForm.remakeType) {
    			remakeType.append("<option value='"+value.key+"' selected>"+value.value+"</option>");
    		}else{
    		    remakeType.append("<option value='"+value.key+"'>"+value.value+"</option>");
    		}
    	});
    	//初始表单赋值
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
            , "payMoney": breakRecordForm.payMoney == null ? "" : breakRecordForm.payMoney +""
            , "remakeContent": breakRecordForm.remakeContent == null ? "" : breakRecordForm.remakeContent + ""
        });
       //如果审核完成，不可更改数据
    	if(breakRecordForm.auditStatus!='break_underview_01'){
    		document.getElementById("extends1").setAttribute('disabled','true');
    		document.getElementById("extends2").setAttribute('disabled','true');
    		document.getElementById("remakeType").setAttribute('disabled','true');
    		document.getElementById("remakeContent").setAttribute('disabled','true');
    	};
    	
    	form.render();
    	
    });
    //提交表单  JSON.stringify(data.field)
    form.on('submit(breakRecordFormSubmitBtnFilter)', function(data){
        $.ajax({
            url: '/customer/breakRecord/edit',
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

var controlForm = "";

//编辑
function addDrivingRecord(id){
	document.getElementById('drivingRecord').value = id;
    layer.close(index);
}
//计算待缴费用
function countPay(el){
	layui.use(['jquery','layer'],function(){
		var $=layui.$,layer=layui.layer;
		var extends1=$(":input[name='extends1']").val();//应缴
		var extends2=$(":input[name='extends2']").val();//已缴
		var reg = /^\d+(\.\d{0,2})?$/;//校验规则
		if(extends1!='' && extends1!=null & extends2!='' && extends2!=null){
			if(parseFloat(extends1)<parseFloat(extends2)){
				parent.layer.msg("请输入正确已缴/待缴金额大小",{icon: 5, shade: [0.4], time: 2000});
				return;
			  }else if(!reg.test(extends1) || !reg.test(extends2)){
				parent.layer.msg("应缴/已缴金额最多保留小数后两位",{icon: 5, shade: [0.4], time: 2000});
				return;
			  }else{
				  var payMony=parseFloat(extends1)-parseFloat(extends2);
				  $(":input[name='payMoney']").val(Math.floor(payMony * 100) / 100);
			  }
		}
	});
}

