layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils','laytpl'], function () {
    var table = layui.table,form = layui.form, $ = layui.$,active = layui.tableUtils,laytpl=layui.laytpl;

    //列表
    table.render({
        elem: '#drivingRecordTable'
        , height: 'full-100' //表格容器距离浏览器顶部和底部的距离“和”
        , url: '/customer/drivingrecord/getPageList' //数据接口
        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
            groups: 5, //只显示 1 个连续页码
            limits: [5, 10, 20, 30]
        }
        , cols: [[ //表头
            {field: 'id', align: 'center', title: 'ID', width: 80, sort: true, type: 'checkbox'}
            , {field: 'licenseNum', align: 'center', title: '车牌号'}
            , {field: 'entranceName', align: 'center', title: '进站名称'}
            , {field: 'entranceTime', align: 'center', title: '进站时间' , sort: true,templet: '#entranceTimeTpl'}
            , {field: 'exitName', align: 'center', title: '出站名称'}
            , {field: 'exitTime',align: 'center', title: '出站时间',sort: true,templet: '#exitTimeTpl'}
            ]
        ]
    });
    
    table.on('tool(drivingRecordTableFilter)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            , layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'detail') {
            detail(data);//查看详情
        } else if (layEvent === 'delet') {
        	delet(data); //删除
        }
    });
    
    //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        var licenseNum = $("#searchParamlicenseNum").val();
        var entranceName = $("#searchParamEntranceName").val();
        var exitName = $("#searchParamExitName").val();
        table.reload('drivingRecordTable', {
            where: { //设定异步数据接口的额外参数，任意设
            	licenseNum : licenseNum,
            	entranceName : entranceName,
            	exitName : exitName
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });
    
    //查看详情
    $("#detailBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('drivingRecordTable');
        if (data.length > 0 && data.length == 1) {
            layer.open({
                type: 2,
                title: '行驶记录详情',
                area: ['700px', '470px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/drivingtrack/goQuery',
                btn: ['关闭'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data[0];
                }
            });
        } else if (data.length > 1) {
        	parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
		} else {
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    
  //删除按钮
    $("#deleteBtn").click(function () {
    	//获得表格选中行Id
        var ids = active.getCheckAttrValue('drivingRecordTable', 'id');
        var data = active.getCheckData('drivingRecordTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要删除所选信息？', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/customer/drivingrecord/delete',
                    type: "post",
                    data: {ids: ids},
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('drivingRecordTable', '/customer/drivingrecord/getPageList');
                                parent.layer.msg('删除成功', {icon: 1, shade: 0.4, time: 1000})
                                parent.layer.close(index);
                            } else if (result.statusCode == "300") {
                                parent.layer.msg("删除失败", {icon: 5, shade: [0.4], time: 1000});
                            }
                        }
                    },
                    error: function (error) {
                        parent.layer.alert(JSON.parse(error.responseText).message, {icon: 2, title: '提示'});
                    }
                })
            });
        } else {
            parent.layer.msg("至少选择一条数据!", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    
    
    //违规
    $("#addBtn").click(function (data) {
    	
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('drivingRecordTable', 'id');
        var data = active.getCheckData('drivingRecordTable');
        if (data.length > 0 && data.length == 1) {
        //获得表格选中行Id
        layer.open({
            type: 2,
            title: '新增违规记录',
            area: ['700px', '470px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/drivingrecord/saveIrregularities',
            btn: ['确定', '取消'],
            success: function (layero,index) {
                var iframe = window[layero.find('iframe')[0]['name']];
                iframe.formData = data[0];
            },
        	yes: function (index, layero) {
            //提交表单1
            var body = layer.getChildFrame('body', index);//获取dom
            	body.find('#IrregularitiesSubmit').click();
        	}
        });
        } else if (data.length > 1) {
        	parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
		} else {
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    
  //打印
    $("#print").click(function(){
    	
        var licenseNum = active.getCheckAttrValue('drivingRecordTable', 'licenseNum');
        var drivingRecord = active.getCheckAttrValue('drivingRecordTable','drivingRecord');
        
        var entranceName = active.getCheckAttrValue('drivingRecordTable', 'entranceName');
        var entranceTime = active.getCheckAttrValue('drivingRecordTable', 'entranceTime')=='null'?"暂无数据":active.dateFormate(active.getCheckAttrValue('drivingRecordTable', 'entranceTime'),"yyyy-MM-dd hh:mm:ss");
        var exitName = active.getCheckAttrValue('drivingRecordTable', 'exitName');
        var exitTime = active.getCheckAttrValue('drivingRecordTable', 'exitTime')=='null'?"暂无数据":active.dateFormate(active.getCheckAttrValue('drivingRecordTable', 'exitTime'),"yyyy-MM-dd hh:mm:ss");
        var data = active.getCheckData('drivingRecordTable');
        if (data.length > 0 && data.length == 1) {
    	//赋值
    	$.ajax({
        	url: '/customer/drivingtrack/getDrivingTrack',
        	type: "post",
        	data: {licenseNum:licenseNum,drivingRecord:drivingRecord},
        	dataType: "json",
        	async:false,
        	success: function (result) {
        		$('#drivingtrackFormFilter').html("");
        		$('#drivingTrackPrintTbody').html("");
        		var details = 
				"<tr height='36px'><td align='center'>" + licenseNum +
				"</td><td align='center'>" + entranceName +
				"</td><td align='center'>" + entranceTime +
				"</td><td align='center'>" + exitName +
				"</td><td align='center'>" + exitTime +
				"</td></tr>";
        		
        		$("#drivingtrackFormFilter").append(details);
        		
            	if(result!=null){
            		for(var i=0;i<result.length;i++){
            		var rowTem =
							"<tr height='36px'><td align='center'>" + (i+1) +
							"</td><td align='center'>" + result[i].num +
							"</td><td align='center'>" + result[i].address +
							"</td><td align='center'>" + active.dateFormate(result[i].times,"yyyy-MM-dd hh:mm:ss") +
							"</td><td align='center'>" + result[i].gisX +
							"</td><td align='center'>" + result[i].gisY +
							"</td></tr>";
            			$("#drivingTrackPrintTbody").append(rowTem);
            		}
            	}
        	},
        	error: function (error) {
            	parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
        	}
    	})
    	
    	$("#drivingTrackPrint").jqprint({  
            debug: false,            
            importCSS: true,         
            printContainer: true,    
            operaSupport: false      
        }); 
    	
        } else if (data.length > 1) {
        	parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
		} else {
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    })        
});   