layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils'], function () {
    var table = layui.table, $ = layui.$,active = layui.tableUtils;

    //用户列表
    table.render({
        elem: '#tollStationTable'
        , height: 'full-100'
        , url: '/customer/tollStation/getListPage'
        , page: {
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'],
            groups: 5,
            limits: [5, 10, 20, 30]
        }
        , cols: [[ //表头
            {field: 'id', align: 'center', title: 'ID', width: 80, sort: true, type: 'checkbox'}
            , {field: 'tollStationName', align: 'center', title: '收费站名称'}
            , {field: 'tollStationCode', align: 'center', title: '收费站编码'}
            , {field: 'longitude', align: 'center', title: '经度'}
            , {field: 'latitude', align: 'center', title: '纬度'}
        ]]
    });


    //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        var searchTollStationName = $(":input[name='tollStationName']").val();
        var searchTollStationCode = $(":input[name='tollStationCode']").val();
        table.reload('tollStationTable', {
            where: { //设定异步数据接口的额外参数，任意设
            	tollStationName : searchTollStationName,
            	tollStationCode : searchTollStationCode
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
            title: '新增收费站信息',
            area: ['700px', '230px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/tollStation/add', 
            btn: ['确定', '取消'],
            yes: function (index, layero) {
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#tollStationSubmitBtn').click();
            },
            end:function () {
                active.reLoadTableData('tollStationTable', '/customer/tollStation/getListPage');
            }
        });
    });


    //删除按钮
    $("#deleteBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('tollStationTable', 'id');
        var data = active.getCheckData('tollStationTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要删除所选收费站信息？', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/customer/tollStation/delete',
                    type: "post",
                    data: {ids: ids},
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('tollStationTable', '/customer/tollStation/getListPage');
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

    //编辑
    $("#edit").click(function () {
        var data = active.getCheckData('tollStationTable');
        if (data.length > 0 && data.length == 1) {
            layer.open({
                type: 2,
                title: '编辑收费站信息',
                area: ['700px', '230px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/tollStation/edit',
                btn: ['确定', '取消'],
                success: function (layero,index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.tollStationForm = data[0];
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#tollStationSubmitBtn').click();
                },
                end:function () {
                    //刷新用户展示列表
                    active.reLoadTableData('tollStationTable', '/customer/tollStation/getListPage');
                }
            });
        } else if (data.length > 1) {
        	parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
		} else{
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    
    //打印
    $("#printBtn").click(function () {
    	var data = active.getCheckData('tollStationTable');
    	var tollStation = data[0];
        //获得表格选中行Id
    	if (data.length > 0 && data.length == 1) {
            $("#tollStationName").text(tollStation.tollStationName);
            $("#tollStationCode").text(tollStation.tollStationCode);
            $("#longitude").text(tollStation.longitude);
            $("#latitude").text(tollStation.latitude);

          //打印
	        $("#tollStationPrint").jqprint({  
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
    
    //导出功能
    $("#exportBtn").click(function () {
    	parent.layer.confirm('确定导出收费站信息？', {icon: 3}, function (index) {
    		parent.layer.close();
        	var tollStationName = $(":input[name='tollStationName']").val();
        	var tollStationCode = $(":input[name='tollStationCode']").val();
        	window.location.href="/customer/tollStation/exportTollStation"+"?tollStationName="+tollStationName+"&tollStationCode="+tollStationCode;
        	parent.layer.close(index);
        })
        return false;
    });

});