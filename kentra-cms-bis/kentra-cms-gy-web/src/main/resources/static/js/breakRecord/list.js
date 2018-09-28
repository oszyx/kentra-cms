var iframepage_1_index;
layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils'], function () {
    var table = layui.table, $ = layui.$,active = layui.tableUtils;
     
    $(document).ready(function(){
    	//搜索：审核状态，违规类型
    	var breakRemakeType=JSON.parse(window.sessionStorage.getItem("Dict"))[12].value;
    	var breakType=JSON.parse(window.sessionStorage.getItem("Dict"))[10].value;
    	var remakeTypeParam=$("#remakeTypeParam"),remakebreakType=$("#breakType");
    	$.each(breakRemakeType,function(index,value){
    		if(index==0) remakeTypeParam.append("<option value=''>请选择审核状态</option>");
    		remakeTypeParam.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    	$.each(breakType,function(index,value){
    		if(index==0) remakebreakType.append("<option value=''>请选择违规类型</option>");
    		remakebreakType.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    	//用户列表
        table.render({
            elem: '#breakRecordTable'
            , height: 'full-100'
            , url: '/customer/breakRecord/getListPage'
            , page: {
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'],
                groups: 5,
                limits: [5, 10, 20, 30]
            }
            , cols: [[ //表头
                {field: 'id', align: 'center', title: 'ID', width: 80, sort: true, type: 'checkbox'}
                , {field: 'licenseNum', align: 'center', title: '车牌号码'}
                , {field: 'entranceName', align: 'center', title: '进站名称'}
                , {field: 'exitName', align: 'center', title: '出站名称'}
                , {field: 'extends1', align: 'center', title: '应缴费(元)'}
                , {field: 'extends2', align: 'center', title: '已缴费(元)'}
                , {field: 'payMoney', align: 'center', title: '待缴费(元)'}
                , {field: 'remakeType', align: 'center', title: '违规类型',templet:function(el){for(var i=0;i<breakType.length;i++){if(el.remakeType==breakType[i].key) return breakType[i].value;}}}
                , {field: 'auditStatus', align: 'center', title: '审核状态',templet:function(el){for(var i=0;i<breakRemakeType.length;i++){if(el.auditStatus==breakRemakeType[i].key) return breakRemakeType[i].value;}}}
            ]]
        });
    });
    
    //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        var searchLicenseNum = $(":input[name='licenseNum']").val();
        var searchAuditStatus = $(":input[name='auditStatus']").val();
        var searchRemakeType =  $(":input[name='breakType']").val();
        table.reload('breakRecordTable', {
            where: { //设定异步数据接口的额外参数，任意设
            	licenseNum : searchLicenseNum,
            	remakeType : searchAuditStatus,
            	searchBreakType:searchRemakeType
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });
    
    //新增
    $("#addBtn").click(function () {
        //获得表格选中行Id
        layer.open({
            type: 2,
            title: '新增违规信息',
            area: ['700px', '500px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/breakRecord/add', 
            btn: ['确定', '取消'],
            yes: function (index, layero) {
            	iframepage_1_index=index;
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#breakRecordSubmitBtn').click();
            },
            end:function () {
                active.reLoadTableData('breakRecordTable', '/customer/breakRecord/getListPage');
            }
        });
    });


    //删除按钮
    $("#deleteBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('breakRecordTable', 'id');
        var data = active.getCheckData('breakRecordTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要删除所选违规信息？', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/customer/breakRecord/delete',
                    type: "post",
                    data: {ids: ids},
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('breakRecordTable', '/customer/breakRecord/getListPage');
                                parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                                parent.layer.close(index);
                            } else if (result.statusCode == "300") {
                                parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
                            }
                        }
                    },
                    error: function (error) {
                        parent.layer.alert(JSON.parse(error.responseText).message, {icon: 2, title: '提示'});
                    }
                })
            });
        } else {
            parent.layer.msg("请至少选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //详情
    $("#detail").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('breakRecordTable');
        if (data.length > 0 && data.length == 1) {
            layer.open({
                type: 2,
                title: '违规详情',
                area: ['700px', '500px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/breakRecord/goDetail',
                btn: ['关闭'],
                success: function (layero,index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.breakRecordForm = data[0];
                }
            });
        } else if (data.length > 1) {
        	parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
		} else{
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //审核
    $("#examineBth").click(function () {
    	var data = active.getCheckData('breakRecordTable');
        //获得表格选中行Id
    	var ids = active.getCheckAttrValue('breakRecordTable', 'id');
    	if (data.length > 0 && data.length == 1) {
    		if(data[0].auditStatus == 'break_underview_01'){
    			layer.open({
    	        	type: 2,
    	            title: '审核违规信息',
    	            area: ['700px', '470px'],
    	            fixed: false,
    	            maxmin: true,
    	            content: '/gyWeb/breakRecord/examine',
    	            btn: ['确定', '取消'],
    	            success: function (layero,index) {
    	                var iframe = window[layero.find('iframe')[0]['name']];
    	                iframe.breakRecordForm = data[0];
    	            },
    	            yes: function (index, layero) {
    	                //提交表单1
    	                var body = layer.getChildFrame('body', index);//获取dom
    	                body.find('#breakRecordFormSubmitBtn').click();
    	            },
    	            end:function () {
    	                //刷新用户展示列表
    	                active.reLoadTableData('breakRecordTable', '/customer/breakRecord/getListPage');
    	            }
    	        });
    		}else{
    			parent.layer.msg("请选择待审核的数据", {icon: 5, shade: 0.4, time: 1000});
    		}
    	}else if (data.length > 1) {
        	parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
		} else{
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    
    //编辑
    $("#edit").click(function () {
        var data = active.getCheckData('breakRecordTable');
        if (data.length > 0 && data.length == 1) {
        	if(data[0].auditStatus == 'break_underview_01'){
	            layer.open({
	                type: 2,
	                title: '编辑违规信息',
	                area: ['700px', '470px'],
	                fixed: false,
	                maxmin: true,
	                content: '/gyWeb/breakRecord/edit',
	                btn: ['确定', '取消'],
	                success: function (layero,index) {
	                    var iframe = window[layero.find('iframe')[0]['name']];
	                    iframe.breakRecordForm = data[0];
	                },
	                yes: function (index, layero) {
	                    //提交表单1
	                    var body = layer.getChildFrame('body', index);//获取dom
	                    body.find('#breakRecordFormSubmitBtn').click();
	                },
	                end:function () {
	                    //刷新用户展示列表
	                    active.reLoadTableData('breakRecordTable', '/customer/breakRecord/getListPage');
	                }
	            });
        	} else {
                parent.layer.msg("审核状态已完成，无法编辑数据", {icon: 5, shade: 0.4, time: 2000});
            }
        } else if (data.length > 1) {
        	parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
		} else{
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //导出功能
    $("#exportBtn").click(function () {
    	
    	var searchLicenseNum = $(":input[name='licenseNum']").val();
    	var searchAuditStatus = $(":input[name='auditStatus']").val();
    	var searchRemakeType =  $(":input[name='breakType']").val();
    	console.info("searchLicenseNum=" + searchLicenseNum+"&searchAuditStatus="+searchAuditStatus+"&searchRemakeType="+searchRemakeType)
           	parent.layer.confirm('确定导出违规信息？', {icon: 3}, function (index) {
           		parent.layer.closeAll('dialog');
                window.location.href="/customer/breakRecord/exportPayRecord"+"?searchLicenseNum="+searchLicenseNum+"&searchAuditStatus="+searchAuditStatus+"&searchRemakeType="+searchRemakeType;
            })
    });
    
    //打印
    $("#printBth").click(function(){
    	var data = active.getCheckData('breakRecordTable');
        if (data.length == 1) {
        	var bareak = data[0],remakeTypeStatus;
        	var breakType=JSON.parse(window.sessionStorage.getItem("Dict"))[10].value;
        	$.each(breakType,function(index,value){
        		if(value.key==bareak.remakeType) remakeTypeStatus=value.value;
        	});
            $("#licenseNum").text(bareak.licenseNum);
            $("#entranceName").text(bareak.entranceName);
            $("#entranceTime").text(createTime(bareak.entranceTime));
            $("#exitName").text(bareak.exitName);
            $("#exitTime").text(createTime(bareak.exitTime));
            $("#extends1").text(bareak.extends1);
            $("#extends2").text(bareak.extends2);
            $("#payMoney").text(bareak.payMoney);
            $("#remakeType").text(remakeTypeStatus);
            $("#remakeContent").text(bareak.remakeContent);
            
	        if (data.length > 0 && data.length == 1) {
	        	//赋值
	        	$.ajax({
	            	url: '/customer/drivingtrack/getDrivingTrack',
	            	type: "post",
	            	data: {licenseNum:bareak.licenseNum,drivingRecord:bareak.drivingRecord},
	            	dataType: "json",
	            	async:false,
	            	success: function (result) {
	            		$('#drivingTrackPrintTbodyjilu').html("");      	
	                	if(result!=null){
	                		for(var i=0;i<result.length;i++){
	                		var rowTem =
	                				"<tr height='36px'><td align='center'>" + (i+1) +
	    							"</td><td align='center'>" + result[i].num +
	    							"</td><td align='center'>" + result[i].address +
	    							"</td><td align='center'>" + createTime(result[i].times) +
	    							"</td><td align='center'>" + result[i].gisX +
	    							"</td><td align='center'>" + result[i].gisY +
	    							"</td></tr>";
	                			$("#drivingTrackPrintTbodyjilu").append(rowTem);
	                		}
	                	}
	            	},
	            	error: function (error) {
	                	parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
	            	}
	        	})
	        }
	      //打印
	        $("#breakRecordPrint").jqprint({  
	            debug: false,            
	            importCSS: true,         
	            printContainer: true,    
	            operaSupport: false      
	        });
        } else if (data.length > 1) {
        	parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
		} else{
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
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
//子页面回调方法
function callbakLicenseSerach(value){
	layui.use(['tableUtils'],function(){
		var data=JSON.parse(value),active = layui.tableUtils;;
		//获取iframe弹出第一层
		var body = layer.getChildFrame('body', iframepage_1_index);//获取dom
	    body.find('#licenseNum').val(data.licenseNum);//车牌号码
	    body.find('#drivingRecord').val(data.drivingRecord);//记录编号
	    body.find('#entranceTime').val(active.dateFormate(data.entranceTime,"yyyy-MM-dd hh:mm:ss"));//起始时间
	    body.find('#exitTime').val(active.dateFormate(data.exitTime,"yyyy-MM-dd hh:mm:ss") );//结束时间
	    body.find('#entranceName').val(data.entranceName);//进站名称
	    body.find('#exitName').val(data.exitName);//出站名称
	});
}