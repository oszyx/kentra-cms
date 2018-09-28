var zTreeObj;
var roleMap = new Map();
var setting = {
    async:{
        enable: true,//开启异步加载
        url: "/api/role/getTreeList",
        type:"post"
    },
    data: {
        key: {
            name: "roleName",
        },
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "roleParentId",
        }
    },
    check: {
        enable: true,
        chkStyle: "checkbox",
        chkboxType: {"Y": "ps", "N": "ps"}//影响map数据结构  请勿更改
    },
    callback: {
        onCheck: zTreeOnCheck,
        onAsyncSuccess : zTreeOnAsyncSuccess
   }
};

//异步加载成功后回调
function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
    var userId = $("#id").val();
    $.ajax({
        url: '/api/user/selectUserWithRole',
        type: "post",
        data: {id:userId},
        dataType: "json",
        success: function (result) {
            if (result != "" && result != null) {
                if (result.statusCode == "200") {
                    //选择勾选
                    for(var i=0 ; i<result.result.length ; i++ ){
                        roleMap.set(result.result[i].id,result.result[i].roleName);
                        //选择勾选
                        var treeObj = $.fn.zTree.getZTreeObj("roleTree");
                        var node = treeObj.getNodeByParam("id", result.result[i].id, null);
                        //父节点不勾选
                        if(node!=undefined && node!=null && (node.children==undefined || node.children==null) ){
                        	treeObj.checkNode(node, true, true);
               		   } 
                    }
                   // showRole(roleMap);不显示
                } else if (result.statusCode == "300") {
                    parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
                }
            }
        },
        error: function (error) {
            parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
        }
    })
};

//单机选择框回调
function zTreeOnCheck(event, treeId, treeNode) {
    /*if(!treeNode.isParent&&treeNode.checked){//如果不是父节点并且是选中状态添加到集合
        roleMap.set(treeNode.id,treeNode.roleName);
    }else if(!treeNode.isParent&&!treeNode.checked){//如果不是父节点并且是取消选中状态 需要从集合移除
        roleMap.delete(treeNode.id);
    }*/
	//获取选中数据
	roleMap.clear();
	nodes=zTreeObj.getCheckedNodes(true);
	$.each(nodes,function(index,value){
		roleMap.set(value.id,value.roleName);
	});
    //showRole(roleMap);不显示
};

//初始化
$(document).ready(function () {
    zTreeObj = $.fn.zTree.init($("#roleTree"), setting, null);
});

//用户添加角色
function userAddRolesSubmit() {
    var userId = $("#id").val();
    var idArr = getRolesId(roleMap);
    var ids = idArr.join(",");
    $.ajax({
        url: '/api/user/userAddRoles',
        type: "post",
        data: {userId:userId ,roleIds:ids},
        dataType: "json",
        success: function (result) {
            if (result != "" && result != null) {
                if (result.statusCode == "200") {
                    parent.layer.closeAll();
                    parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                } else if (result.statusCode == "300") {
                    parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
                }
            }
        },
        error: function (error) {
            parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
        }
    });
}


//选择权限展示
function showRole(mapsss) {
    $("#showRoles").html("");
    mapsss.forEach(function (value, key, map) {
        if(map.size%5==0){
            $("#showRoles").append("<button class='layui-btn' style='margin-top:20px'>"+value+"</button>");
        }else if(map.size%5==1){
            $("#showRoles").append("<button class='layui-btn layui-btn-primary' style='margin-top:20px'>"+value+"</button>");
        }else if(map.size%5==2){
            $("#showRoles").append("<button class='layui-btn layui-btn-normal' style='margin-top:20px'>"+value+"</button>");
        }else if(map.size%5==3){
            $("#showRoles").append("<button class='layui-btn layui-btn-warm' style='margin-top:20px'>"+value+"</button>");
        }else if(map.size%5==4){
            $("#showRoles").append("<button class='layui-btn ayui-btn-dange' style='margin-top:20px'>"+value+"</button>");
        }
    })
};

//遍历map获得RoleId
function getRolesId(mapss){
    var roleId = new Array();
    mapss.forEach(function (value, key, map) {
        roleId.push(key);
    })
    return roleId;
}

//点击机构树--加载列表
function roleTreeOnClick(id){
	layui.use(['table'],function(){
		var table=layui.table;
		//用户列表
	    table.render({
	        elem: '#roleTable'
	        , height: 'full-100' //表格容器距离浏览器顶部和底部的距离“和”
	        , url: '/api/role/getListPage' //数据接口
	        , where: {"roleParentId":id}
	        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
	            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
	            groups: 5, //只显示 1 个连续页码
	            limits: [5, 10, 20, 30]
	        }
	        , cols: [[ //表头
	            {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left', type: 'checkbox'}
	            , {field: 'roleName', title: '角色名', sort: true, fixed: 'left'}
	            , {field: 'roleCode', title: '角色code'}
	            , {field: 'relySystem', title: '所属系统'}
	            , {field: 'desc', title: '角色描述'}
	            , {field: 'status', title: '角色状态', fixed: 'right'}
	            , {fixed: 'right', width: 165, align: 'center', toolbar: '#roleTableBar'}
	        ]]
	    });
	});
	    
	$("#parentId").val(id);
}