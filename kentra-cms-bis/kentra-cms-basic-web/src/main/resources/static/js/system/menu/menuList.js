layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils','jquery'], function () {
    var table = layui.table, $ = layui.$, active = layui.tableUtils;
    
  //ztree 全局设置  
    var setting = {
    	async:{
    		enable: true,//开启异步加载
    		url: "/api/menu/getTreeList",
    		type:"post"
    	},
    	data: {
    		key:{
    			name: "menuName",
    			url: "menuUrl"//后台替换掉了menurl 指定回调函数， 机构树显示
    		},
    		simpleData: {
    			enable: true,
    			idKey: "id",
    			pIdKey: "menuParentId"
    		}
    	},
    	check: {
    	    enable: false
    	}
    };
    
    var menuTree;
    //菜单列表
    $(document).ready(function(){
    	//加载机构树
    	menuTree=$.fn.zTree.init($("#menuZtree"), setting, null);
    	//初始化数据
    	table.render({
            elem: '#menuTable'
            , height: 'full-100' 
            , url: '/api/menu/getPageList' //数据接口
            , where: {"id":"1"}
            , page: { 
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], 
                groups: 5, //只显示 1 个连续页码
                limits: [5, 10, 20, 30]
            }
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left', type: 'checkbox'}
                , {field: 'menuName', title: '菜单名称', align: 'center',sort: true}
                , {field: 'menuCode', title: '菜单编号',align: 'center'}
                , {field: 'menuUrl', title: '菜单链接',align: 'center'}
            ]]
        });
    })
    
    
  //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        var menuName = $("#searchParam").val();
        table.reload('menuTable', {
            where: { //设定异步数据接口的额外参数，任意设
            	menuName : menuName
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

//添加菜单
$("#addBtn").click(function () {
    //获得表格选中行Id
    layer.open({
        type: 2,
        title: '添加菜单',
        area: ['700px', '300px'],
        fixed: false,
        maxmin: true,
        content: '/web/menu/goAdd',
        btn: ['确定', '取消'],
        success:function (layero,index){
        	var body = layer.getChildFrame('body', index);
        	body.find("#menuParentId").val($("#parentId").val());
        },
        yes: function (index, layero) {
            //提交表单1
            var body = layer.getChildFrame('body', index);
            body.find('#menuAddSubmit').click();
        },
        end:function () {
            active.reLoadTableData('menuTable', '/api/menu/getPageList');
            menuTree.reAsyncChildNodes(null, "refresh");
        }
    	});
        
	});


//编辑菜单
$("#editBtn").click(function () {
    //获得表格选中行Id
    var data = active.getCheckData('menuTable');
    if (data.length == 1) {
        layer.open({
            type: 2,
            title: '编辑菜单',
            area: ['700px', '300px'],
            fixed: false,
            maxmin: true,
            content: '/web/menu/goEdit',
            btn: ['确定', '取消'],
            success: function (layero, index) {
            	var iframe = window[layero.find('iframe')[0]['name']];
                iframe.formData = data[0];
            },
            yes: function (index, layero) {
                //提交表单1
            	var body = layer.getChildFrame('body', index);//获取dom
                body.find('#menuEditSubmit').click();
            },
            end: function () {
                //刷新菜单展示列表
            	active.reLoadTableData('menuTable', '/api/menu/getPageList');
            	//刷新菜单树
            	menuTree.reAsyncChildNodes(null, "refresh");
            	
            }
        });
    } else if (data.length < 1) {
        parent.layer.msg("请选择一个菜单！", {icon: 5, shade: 0.4, time: 1000});
    } else {
        parent.layer.msg("只能选择一个菜单！", {icon: 5, shade: 0.4, time: 1000});
    }
});


//菜单详情
$("#detailBtn").click(function () {
    //获得表格选中行Id
    var data = active.getCheckData('menuTable');
    if (data.length == 1) {
        layer.open({
            type: 2,
            title: '菜单详情',
            area: ['700px', '300px'],
            fixed: false,
            maxmin: true,
            content: '/web/menu/goQuery',
            btn: ['关闭'],
            success: function (layero, index) {
            	var iframe = window[layero.find('iframe')[0]['name']];
                iframe.formData = data[0];
            }
        });
    } else if (data.length < 1) {
        parent.layer.msg("请选择一个菜单！", {icon: 5, shade: 0.4, time: 1000});
    } else {
        parent.layer.msg("只能选择一个菜单！", {icon: 5, shade: 0.4, time: 1000});
    }
});


	//批量删除
	$("#deleteBtn").click(function () {
    	//获得表格选中行Id
    	var ids = active.getCheckAttrValue('menuTable', 'id');
    	var data = active.getCheckData('menuTable');
    	if (data.length > 0) {
        	parent.layer.confirm('确定要删除所选信息', {icon: 3}, function (index) {
            	parent.layer.closeAll('dialog');
            	$.ajax({
                	url: '/api/menu/delete',
                	type: "post",
                	data: {ids: ids},
                	dataType: "json",
                	success: function (result) {
                    	if (result != "" && result != null) {
                        	if (result.statusCode == "200") {
                            	active.reLoadTableData('menuTable', '/api/menu/getPageList');
                            	parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                            	$.fn.zTree.init($("#menuZtree"), setting, null);//刷新机构树
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
