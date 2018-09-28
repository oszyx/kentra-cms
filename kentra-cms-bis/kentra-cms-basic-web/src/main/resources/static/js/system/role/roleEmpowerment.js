layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'jquery', 'tableUtils','element'], function () {
	var form = layui.form, $ = layui.jquery, active = layui.tableUtils,element=layui.element;
	
	
	//表单赋值
    form.val("roleEmpowermentFormFilter", {
        "id": formRoleData.id , 
        "roleName": formRoleData.roleName, 
        "roleCode": formRoleData.roleCode
    });
    
  //角色机构树设置
    var setting = {
    		async:{
    			enable: true,//开启异步加载
    			url: "/api/menu/getTreeList",
    			type:"post"
    		},
    		data: {
    			key:{
    				name: "menuName"
    			},
    			simpleData: {
    				enable: true,
    				idKey: "id",
    				pIdKey: "menuParentId"
    			}
    		},
    		check: {
    		    enable: true
    		},
    		callback:{
    			beforeCheck:true,  
                onCheck:onCheck,
                onAsyncSuccess : zTreeOnAsyncSuccess
    		}
    		
     };
    //加载角色树
    var roleEmpZtree;
    $(document).ready(function(){
    	roleEmpZtree=$.fn.zTree.init($("#roleEmpZtree"), setting, null);
    });
    //加载已勾选
    function zTreeOnAsyncSuccess(){
    	 $.ajax({
             url: '/api/role/getroleMenu',
             type: "post",
             data: {"id":formRoleData.id},
             dataType: "json",
             async:true,
             success: function (result) {
             	var ids="";
             	$.each(result,function(index,value){
             	   if(index > 0) ids+=",";
           		   ids += value.id;
           		   var nodes= roleEmpZtree.getNodeByParam("id", value.id, null);
           		 if(nodes!=undefined && nodes!=null && (nodes.children==undefined || nodes.children==null) ){
         			  roleEmpZtree.checkNode(nodes, true, true);
         		   }
             	})
          	  $("#menuIds").val(ids);
             }
         })
    }
	
	//勾选事件
    function onCheck(e,treeId,treeNode){
    	var treeObj=$.fn.zTree.getZTreeObj("roleEmpZtree"),nodes=treeObj.getCheckedNodes(true), ids="";  
        for(var i=0;i<nodes.length;i++){  
        	if(i>0) {ids+=","}
            ids +=nodes[i].id;
        }
        $("#menuIds").val(ids);
    }
    //提交事件
    form.on('submit(roleEmpowermentSubmitBtn)',function(data){
    	var checkedIds=$("#menuIds").val();
    	$.ajax({
            url: '/api/role/addRoleMenu',
            type: "post",
            data: data.field,
            dataType: "json",
            async:false,
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.msg('赋权成功', {icon: 1, shade: 0.4, time: 1000})
                        parent.layer.closeAll('iframe');
                    } else if (result.statusCode == "300") {
                        parent.layer.msg("赋权失败", {icon: 5, shade: [0.4], time: 1000});
                    }
                }
            },
            error: function (error) {
                parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
            }
        })
    	
    });
	
	
});