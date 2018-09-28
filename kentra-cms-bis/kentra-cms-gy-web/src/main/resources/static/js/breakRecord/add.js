var index;

layui.use(['layer','form', 'laydate', 'jquery'], function () {
    var form = layui.form, $ = layui.jquery, laydate = layui.laydate, layer = layui.layer, active = layui.tableUtils;

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
        	var extends1Money = $("#extends1").val();//应缴
            if (value.length < 1) {
                return '已缴费金额不能为空!';
            }
            var reg = /^\d+(\.\d{0,2})?$/;
            if(!reg.test(value)){
                return '请输入正确格式金额!(金额数最多输入小数点后两位!)';
            }
            if (extends1Money != "" && parseFloat(extends1Money)<parseFloat(value)){
            	return '已缴费用不能大于应缴费用!';
            }
        },
        remakeType: function (value) {
            if (value.length < 1) {
                return '违规类型不能为空!';
            }
        }
    });
    
    
    $(document).ready(function(){
    	var breakType=JSON.parse(window.sessionStorage.getItem("Dict"))[10].value;
    	var breakSelect=$("#remakeType");
    	$.each(breakType,function(index,value){
    		if(index==0)breakSelect.append("<option value=''>请选择违规类型</option>");
    		breakSelect.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    	form.render();
    });

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
            area: ['700px', '500px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/breakRecord/licenseSerach',
            success:function(layero,index){
            	var body = parent.layer.getChildFrame('body', index);
            	body.find("#licenseNum").val(searchParam);
            }
        });
    });
    
    //提交表单  JSON.stringify(data.field)
    form.on('submit(breakRecordSubmitBtnFilter)', function (data) {
        $.ajax({
            url: '/customer/breakRecord/add',
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.closeAll('iframe');
                        parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
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

/**
 * 自动填充待缴费用
 * @param el
 * @returns
 */
function addcountPay(){
	layui.use(['jquery','layer'],function(){
		var $=layui.$,layer=layui.layer;
		var extends1=$(":input[name='extends1']").val();//应缴
		var extends2=$(":input[name='extends2']").val();//已缴
		var reg = /^\d+(\.\d{0,2})?$/;//校验规则
		if(extends1!='' && extends1!=null & extends2!='' && extends2!=null){
			if(parseFloat(extends1)<parseFloat(extends2)){
				parent.layer.msg("已缴费用不能大于应缴费用!",{icon: 5, shade: [0.4], time: 2000});
				return;
			  }else if(!reg.test(extends1) || !reg.test(extends2)){
				parent.layer.msg("请输入正确格式金额!(金额数最多输入小数点后两位!)",{icon: 5, shade: [0.4], time: 2000});
				return;
			  }else{
				  var payMony=parseFloat(extends1)-parseFloat(extends2);
				  $(":input[name='payMoney']").val(Math.floor(payMony * 100) / 100);
			  }
		}
	});
}