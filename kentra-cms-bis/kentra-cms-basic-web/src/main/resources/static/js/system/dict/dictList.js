layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils'], function () {
    var table = layui.table;
    var $ = layui.$;
    var active = layui.tableUtils;
    
    //ztree 全局设置  
    var dictTree,setting = {
    	async:{
        	enable: true,//开启异步加载
        	url: "/api/sys/dict/getNodeList",
        	type:"post"
        },
    	data: {
    		key: {
    			checked : "checked",
    			children : "children",
    			name : "dictName",
                isParent:"dictParentId",
    			url : "url"
    		}
    	},
        check: {
            enable: false
        },
        callback : {
            onCheck: onCheck //设置每次选中时触发事件
        }
    };
    //加载字典树
    $(document).ready(function(){
    	 //加载字典树
    	 dictTree = $.fn.zTree.init($("#dictTree"), setting, null);
    	//用户列表
    	    table.render({
    	        elem: '#dictTable'
    	        , height: 'full-100' //表格容器距离浏览器顶部和底部的距离“和”
    	        , url: '/api/sys/dict/getPageList' //数据接口
    	        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
    	            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
    	            groups: 5, //只显示 1 个连续页码
    	            limits: [5, 10, 20, 30]
    	        }
    	    	,where: {pid:"1"}
    	    	,id: 'dictTable'
    	    	, cols: [[ //表头
    	            {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left', type: 'checkbox'}
    	            , {field: 'dictName', title: '字典名称', sort: true, fixed: 'left',align: 'center'}
    	            , {field: 'dictCode', title: '字典编号',align: 'center'}
    	            , {field: 'dictStatus', title: '字典状态', fixed: 'right',align: 'center', templet: '#statusTpl'}
    	            , {field: 'dictDesc', title: '字典描述',align: 'center'}
    	        ]]
    	  });
    });
    
    //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        var searchDictName = $("#dictName").val();
        var searchStatus = $("#dictStatus").val();
        table.reload('dictTable', {
            where: { //设定异步数据接口的额外参数，任意设
            	dictName : searchDictName,
                dictStatus : searchStatus
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });
    
    //添加
    $("#addBtn").click(function () {
        //获得表格选中行Id
    	dictParentId = $(":input[name='dictParentId']").val();
        layer.open({
            type: 2,
            title: '添加数据字典',
            area: ['700px', '400px'],
            fixed: false,
            maxmin: true,
            content: '/web/dict/goAddPage?dictParentId='+dictParentId,
            btn: ['确定', '取消'],
            yes: function (index, layero) {
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#dictAddSubmit').click();
            },
            end:function () {
                //刷新展示列表
                active.reLoadTableData('dictTable', '/api/sys/dict/getPageList');
                //刷新展示tree
                dictTree.reAsyncChildNodes(null, "refresh");
            }
        });
    });

    //编辑
    $("#edit").click(function () {
        var data = active.getCheckData('dictTable');
        if (data.length == 0 || data.length >1) {
        	parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }else{
            layer.open({
                type: 2,
                title: '编辑数据字典',
                area: ['700px', '400px'],
                fixed: false,
                maxmin: true,
                content: '/web/dict/goEditPage?type=0',
                btn: ['确定', '取消'],
                success: function (layero,index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data[0];
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#dictEditSubmit').click();
                },
                end:function () {
                    //刷新展示列表
                    active.reLoadTableData('dictTable', '/api/sys/dict/getPageList');
                    //刷新展示tree
                    dictTree.reAsyncChildNodes(null, "refresh");
                }
            });
        }
    });

    //详情
    $("#detail").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('dictTable');
        if (data.length == 0 || data.length >1) {
        	parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }else{
            layer.open({
                type: 2,
                title: '数据字典详情',
                area: ['700px', '400px'],
                fixed: false,
                maxmin: true,
                content: '/web/dict/goEditPage?type=1',
                btn: ['关闭'],
                success: function (layero,index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data[0];
                }
            });
        }
    });

    //批量删除
    $("#deleteBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('dictTable', 'id');
        var data = active.getCheckData('dictTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要删除所选信息', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/api/sys/dict/delete',
                    type: "post",
                    data: {ids: ids},
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                            	//刷新展示列表
                                active.reLoadTableData('dictTable', '/api/sys/dict/getPageList');
                                //刷新展示tree
                                dictTree.reAsyncChildNodes(null, "refresh");
                                parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                                parent.layer.close(index);
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
        } else {
            parent.layer.msg("请至少选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

});

function onCheck(e, treeId, treeNode) {
    var nodes = dictTree.getCheckedNodes();
    console.info(nodes)
    var ids = "";
    for (var i = 0; i < nodes.length; i++) {
        ids += (i != nodes.length - 1 ? nodes[i].dictCode + "," : nodes[i].dictCode);
    }
    $("#setRights_ids").val(ids);
}
function openTab(dictPid){
	$(":input[name='dictParentId']").val(dictPid);
	layui.use(['table'], function () {
		var table = layui.table;
	    var $ = layui.$;
	    var active = layui.tableUtils;
	    //用户列表
	    table.render({
	        elem: '#dictTable'
	        , height: 'full-100' //表格容器距离浏览器顶部和底部的距离“和”
	        , url: '/api/sys/dict/getPageList' //数据接口
	        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
	            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
	            groups: 5, //只显示 1 个连续页码
	            limits: [5, 10, 20, 30]
	        }
	    	,where: {pid:dictPid}
	    	,id: 'dictTable'
	    	, cols: [[ //表头
	    		{field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left', type: 'checkbox'}
	            , {field: 'dictName', title: '字典名称', sort: true, fixed: 'left',align: 'center'}
	            , {field: 'dictCode', title: '字典编号',align: 'center'}
	            , {field: 'dictStatus', title: '字典状态', fixed: 'right',align: 'center', templet: '#statusTpl'}
	            , {field: 'dictDesc', title: '字典描述',align: 'center'}
	        ]]
		});
	    $("#parentId").val(dictPid);
	});
}
