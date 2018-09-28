/**
 * 废弃
 */
/*layui.use(['form', 'element'], function () {
});

var zNodes;
var dictParentId;

//ztree 全局设置  
var dictTree,setting = {
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

$(document).ready(function(){ 
	dictParentId = $(":input[name='dictParentId']").val();
	$.ajax({   
	    type : "POST", //提交方式   
	    url : "/api/sys/dict/getNodeList",//路径   
	    data : {},//数据，这里使用的是Json格式进行传输   
	    success : function(result) {//返回数据根据结果进行相应的处理   
	    	zNodes = result;
	        dictTree = $.fn.zTree.init($("#dictTree"), setting, result);
	    }  
	}); 
	
    var nodes = dictTree.getCheckedNodes();
    var ids = "";
    for (var i = 0; i < nodes.length; i++) {
        ids += (i != nodes.length - 1 ? nodes[i].dictCode + "," : nodes[i].dictCode);
    }
    $("#setRights_ids").val(ids);
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
	dictParentId = dictPid;
	console.info(dictParentId)
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
	            , {field: 'dictName', title: '字典名称', sort: true, fixed: 'left'}
	            , {field: 'dictCode', title: '字典code'}
	            , {field: 'dictLevel', title: '字典等级'}
	            , {field: 'dictStatus', title: '字典状态', fixed: 'right',templet: '#statusTpl'}
	            // , {fixed: 'right', width: 165, align: 'center', toolbar: '#dictTableBar'}
	        ]]
		});
	    $("#parentId").val(dictPid);
	});
}*/