
function roleTreeOnClick(roleParentId){
	layui.use(['table'],function(){
		var table=layui.table;
		table.render({
            elem: '#roleTable'
            , height: 'full-100' //表格容器距离浏览器顶部和底部的距离“和”
            , url: '/api/role/getListPage' //数据接口
            , where: {"roleParentId": roleParentId}
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
                groups: 5, //只显示 1 个连续页码
                limits: [5, 10, 20, 30]
            }
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left', type: 'checkbox', align: 'center'}
                , {field: 'roleName', title: '角色名', sort: true, fixed: 'left', align: 'center'}
                , {field: 'roleCode', title: '角色编号', align: 'center'}
                , {field: 'desc', title: '角色描述', align: 'center'}
            ]]
        });
		$("#parentId").val(roleParentId);
	})	
}