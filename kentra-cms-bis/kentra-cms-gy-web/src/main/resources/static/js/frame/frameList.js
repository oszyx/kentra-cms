layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils','laytpl','layer'], function () {
    var table = layui.table, $ = layui.$, active = layui.tableUtils,laytpl = layui.laytpl,layer=layui.layer;

    $(document).ready(function(){
    	//加载设备状态数据字典
    	var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[7].value;
    	var frameSelectStatus=$("#serchStatus");
    	$.each(dict,function(index,value){
    		if(index==0)frameSelectStatus.append("<option value=''>请选择设备状态</option>");
    		frameSelectStatus.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    //加载table数据
    table.render({
        elem: '#frameTable', 
        height: '240px', //表格容器距离浏览器顶部和底部的距离“和”
        url: '/equip/frame/getPageList', //数据接口
        page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
            groups: 5, //只显示 1 个连续页码
            limits: [5, 10, 20, 30]
        },
        cols: [[ //表头
            {field: 'id', align: 'center',title: 'ID', width: 68, fixed: 'left', type: 'checkbox'}, 
            {field: 'name', align: 'center',title: '设备名称',width: 200, sort: true,event:'getRepairRecord'}, 
            {field: 'frameCode', align: 'center',title: '设备编号',width: 200,event:'getRepairRecord'},
            {field: 'frameGisX', align: 'center',title: '设备经度',width: 200,event:'getRepairRecord'},
            {field: 'frameGisY', align: 'center',title: '设备纬度',width: 200,event:'getRepairRecord'},
            {field: 'frameStatus', align: 'center',title: '设备状态',width: 200,event:'getRepairRecord',
            	templet:function (el){
          	    	 for(var i=0;i<dict.length;i++){
          	    		 if(el.frameStatus==dict[i].key) return dict[i].value;
          	    	    }
          	    	}
            	}
            ]]
    	});
    });  
    //监听工具条
    table.on('tool(frameTableFilter)', function (obj) {
        var data = obj.data, //获得当前行数据
            layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent=='getRepairRecord'){
        	getRepairRecord(data);
        }
    });

    //查询方法
    $("#searchBtn").click(function () {
        var serchname = $("#searchParam").val();
        var searchNo = $("#searchNo").val();
        var serchStatus = $("#serchStatus").val();
        table.reload('frameTable', {
            where: { //设定异步数据接口的额外参数，任意设
            	serchName : serchname,
            	searchNo : searchNo,
            	serchStatus : serchStatus
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });
    //新增
    $("#addBtn").click(function(){
    	layer.open({
            type: 2,
            title: '添加龙门架设备',
            area: ['700px', '450px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/frame/goAdd',
            btn: ['确定', '取消'],
            yes: function (index, layero) {
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#frameAddSubmitBtn').click();
            },
            end:function () {
                active.reLoadTableData('frameTable', '/equip/frame/getPageList');
            }
        });
    })
    
    //删除数据
    $('#deleteBtn').click(function (){
    	var ids = active.getCheckAttrValue('frameTable', 'id');
    	var data = active.getCheckData('frameTable');
    	if(data.length>0){
    		parent.layer.confirm('确定要删除所选信息', {icon: 3}, function (index) {
            	parent.layer.closeAll('dialog');
            	$.ajax({
                	url: '/equip/frame/deleteFrame',
                	type: "post",
                	data: {ids: ids},
                	dataType: "json",
                	success: function (result) {
                    	if (result != "" && result != null) {
                        	if (result.statusCode == "200") {
                            	active.reLoadTableData('frameTable', '/equip/frame/getPageList');
                            	layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                            	layer.close(index);
                        	} else if (result.statusCode == "300") {
                            	parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
                        	}
                    	}
                	},
                	error: function (error) {
                    	parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
                	}
            	})
        	});
    	}else{
    		parent.layer.msg("至少选择一条数据", {icon:5, shade: 0.4, time: 1000})
    	}
    })
    
    //详情
    $("#detail").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('frameTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '龙门架设备详情',
                area: ['700px', '400px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/frame/goQuery',
                btn: ['关闭'],
                success: function (layero,index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data[0];
                }
            });
        } else {
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    

    //编辑
    $("#edit").click(function () {
        var data = active.getCheckData('frameTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '编辑龙门架设备信息',
                area: ['700px', '420px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/frame/goEdit',
                btn: ['确定','关闭'],
                success: function (layero,index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data[0];
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#frameEditSubmitBtn').click();
                },
                end:function () {
                    active.reLoadTableData('frameTable', '/equip/frame/getPageList');
                }
            });
        } else {
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    
    //维修
    $("#repair").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('frameTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '添加龙门架设备维修记录',
                area: ['700px', '500px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/frame/goRepair',
                btn: ['确定','关闭'],
                success: function (layero,index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.frameData = data[0];
                },
                yes:function(index, layero){
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#frameRepairSubmitBtn').click();
                },
                end:function () {
                    active.reLoadTableData('frameTable', '/equip/frame/getPageList');
                }
            });
        } else {
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    
    //导出
    $("#expor").click(function(){
    	
    	var serchnameParam = $("#searchParam").val();
        var searchNoParam = $("#searchNo").val();
        var serchStatusParam = $("#serchStatus").val();
    	
        parent.layer.confirm('确定导出龙门架信息？', {icon: 3}, function (index) {
       		parent.layer.closeAll('dialog');
            window.location.href="/equip/frame/exporFrameInfos"+"?serchnameParam="+serchnameParam+"&searchNoParam="+searchNoParam+"&serchStatusParam="+serchStatusParam;
        })
    })
    
    //打印
    $("#print").click(function(){
    	var ids = active.getCheckAttrValue('frameTable', 'id');
    	var data = active.getCheckData('frameTable');
    	if(data.length!=1){
    		parent.layer.msg("只能选择一条数据", {icon:5, shade: 0.4, time: 1000});
    		return;
    	}
    	//清空数据
    	$("#controlPrintTbody").html("");
    	//赋值
    	$("#nameSpan").text(data[0].name);
    	$("#controllerCodeSpan").text(data[0].frameCode);
    	$("#controllerGisXSpan").text(data[0].frameGisX);
    	$("#controllerGisYSpan").text(data[0].frameGisY);
    	$("#controllerAddressSpan").text(data[0].frameAddress);
    	var frameStatus;
    	var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[7].value;
    	$.each(dict,function(index,value){
    		if(data[0].frameStatus==value.key) frameStatus=value.value;
    	});
    	$("#controllerStatusSpan").text(frameStatus);
    	$("#descripInfosSpan").text(data[0].descripInfos);
    	
    	//查询维修信息
    	$.ajax({
        	url: '/equip/device/getRepairRecord',
        	type: "post",
        	data: {"DeviceId":ids},
        	dataType: "json",
        	async:false,
        	success: function (result) {
        		for (var i = 0; i < result.length; i++) {
                    var repairStatus = getRepairStatus(result[i].repairStatus);
                    var rowTem =
                        "<tr height='36px'><td align='center'>" + result[i].repairUserName +
                        "</td><td align='center'>" + result[i].repairUserPhone +
                        "</td><td align='center'>" + active.dateFormate(result[i].repairDateStar,'yyyy-MM-dd hh:mm:ss') +
                        "</td><td align='center'>" + active.dateFormate(result[i].repairDateEnd,'yyyy-MM-dd hh:mm:ss') +
                        "</td><td align='center'>" + repairStatus +
                        "</td></tr><tr height='36px'><td align='center' >通知说明</td><td colspan='4'>" + result[i].repairNotice +
                        "</td></tr><tr height='36px'><td align='center' >原因说明</td><td colspan='4'>" + result[i].repairReason +
                        "</td></tr>";
                    $('#controlPrintTbody').append(rowTem);
                }
        	},
        	error: function (error) {
            	parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
        	}
    	})
    	//打印
    	$("#framePrint").jqprint({  
            debug: false,            
            importCSS: true,         
            printContainer: true,    
            operaSupport: false      
        });
    });
  //设备状态判断
    function getRepairStatus(status) {
    	var msg ;
        var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[11].value;
        $.each(dict,function(index,value){
     	   if(status==value.key) msg=value.value;
        })
        return msg;
      }
    

    //定义column
    var column =[
    	[{field: 'repairDeviceName', width: 100,align: 'center', title: '设备名称'}
        , {field: 'repairUserName',width: 100, align: 'center', title: '姓名'}
        , {field: 'repairUserPhone',width: 130, align: 'center', title: '电话'}
        , {field: 'repairDateStar',width:180, align: 'center',sort: true, title: '起始时间', templet: '#DateFormate'}
        , {field: 'repairDateEnd',width:180, align: 'center',sort: true, title: '结束时间', templet: '#DateFormate'}
        , {field: 'repairStatus',width: 100, align: 'center', title: '维修状态', templet: '#repairStatusTpl'}
        , {field: 'repairNotice',width: 138, align: 'center', title: '通知说明'}
        , {field: 'repairReason',width: 138, align: 'center', title: '原因说明'}
       ], [{field: '', title: '暂无数据',align:'center', colspan:8}
       ]];

    //默认加载维修表格
    var height ;
    $(document).ready(function(){
    	height = Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);
        table.render({
            elem: "#frameRepairTable",
            cols: column
        });
    });
    //获取维修记录
    function getRepairRecord(data){
    	var dict=JSON.parse(window.sessionStorage.getItem("Dict"))[11].value;
    	$.ajax({
        	url: '/equip/repair/findByRepairDeviceId',
        	type: "post",
        	data: {"repairDeviceId":data.id},
        	dataType: "json",
        	async:false,
        	success: function (result) {
                if(result!="" && result!=null){
                	table.render({
                		elem:"#frameRepairTable",
                		height: height-421+"px",
                		cols:[[{field: 'repairDeviceName', width: 100,align: 'center', title: '设备名称'}
                        , {field: 'repairUserName',width: 100, align: 'center', title: '姓名'}
                        , {field: 'repairUserPhone',width: 130, align: 'center', title: '电话'}
                        , {field: 'repairDateStar',width:180, align: 'center',sort: true, title: '起始时间', templet: '#DateFormate'}
                        , {field: 'repairDateEnd',width:180, align: 'center',sort: true, title: '结束时间', templet: '#DateFormate'}
                        , {field: 'repairStatus',width: 100, align: 'center', title: '维修状态',
                        	
                        	templet: function (el){
                 	    	   for(var i=0;i<dict.length;i++){
                 	    		   if(el.repairStatus==dict[i].key) return dict[i].value;
                 	    	   }
                 	       }
                          
                        }
                        , {field: 'repairNotice',width: 138, align: 'center', title: '通知说明'}
                        , {field: 'repairReason',width: 138, align: 'center', title: '原因说明'}
                        ]],
                		data:result.data
                	});
               	}
        	}
    	})
    };
    
    
});