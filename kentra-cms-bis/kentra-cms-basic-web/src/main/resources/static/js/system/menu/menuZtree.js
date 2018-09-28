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



//回调函数，查询该机构下所有节点显示
function zTreeOnClick(id){
	layui.use(['table'],function(){
		var table=layui.table;
		table.render({
	        elem: '#menuTable', 
	        height: 'full-100' 
	        , url: '/api/menu/getPageList' //查询当前节点子节点信息
	        , where: {"id":id}
	        , page: { //分页
	            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], 
	            groups: 5, //只显示 1 个连续页码
	            limits: [5, 10, 20, 30]
	        }
	        , cols: [[ //表头
	            {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left', type: 'checkbox'}
	            , {field: 'menuName', title: '菜单名称',align: 'center', sort: true}
	            , {field: 'menuCode', title: '菜单编号',align: 'center'}
	            , {field: 'menuUrl', title: '菜单链接',align: 'center'}
//	            , {fixed: 'right',title:'操作', width: 165, align: 'center', toolbar: '#menuTableBar'}
	        ]]
	    });
		$("#parentId").val(id);
	})	
}