layui.use(['jquery','table','element','form'],function(){
	var $=layui.$,table=layui.table,element=layui.element,form=layui.form;
	
	$(document).ready(function(){
		//数据字典存放本地
		$.ajax({
			url:"/api/sys/getDict",
			type:"post",
			dataType:"json",
			data:{},
			success: function(data){
				//转换字典树
				var dictTree=JSON.stringify(getJsonTree(data,"1"));
				//存放缓存
				window.sessionStorage.setItem("Dict",dictTree);
            }
		});
	});
	//迭代数据
	function getJsonTree(data,parentId){
        var dictTreeArr=[];
        for(var i=0;i<data.length;i++){
             if(data[i].dictParentId==parentId ){
            	var children=getJsonTree(data,data[i].id);
                var node={key:data[i].dictCode,value:children.length==0?data[i].dictName:children};
                dictTreeArr.push(node);              
             }
        }
        return dictTreeArr;
    }
	
	 //个人资料
	 $("#userInfos").on('click',function(){
		layer.open({
			type: 2,
	        title: '个人资料',
	        area: ['700px', '400px'],
	        shade: 0.3,
	        fixed: false,
	        maxmin: true,
	        content: '/web/sys/userInfos',
	        success: function (layero,index) {
	            var body = layer.getChildFrame('body', index);
	        	body.find("#userId").val($("#userId").val());
	        }
		})
	 });
	 //修改密码
	 $("#resetPassword").on('click',function(){
		 layer.open({
				type:2,
				title:'修改密码',
				closeBtn:1,
				area:['400px','300px'],
				shade:0.3,
				id:'index_resetPassword',
				moveType:1,
				btn:['确认','取消'],
				content:'/web/sys/resetPassword',
				success: function(layero,index){
					var body = layer.getChildFrame('body', index);
		        	body.find("#userId").val($("#userId").val());
				},
			    yes:function(index,layero){
			    	var body = layer.getChildFrame('body', index);
			    	var oldpassword=body.find("#index_resetpassword_oldpassword").val(),newpasswordOne=body.find("#index_resetpassword_newpassword_one").val(),
			    	    newpasswordTwo=body.find("#index_resetpassword_newpassword_two").val(),userId=body.find("#userId").val();
			    	if(checkResetInfos(body,oldpassword,newpasswordOne,newpasswordTwo)){
			    		$.ajax({
		        			type:"post",
		        			url:"/api/sys/resetPassword",
		        			dataType:"json",
		        			data:{"userId":userId,"password":oldpassword,"resetpassword":newpasswordOne},
		        			cache:false,
		        			async:false,
		        			success: function(data){
		        				if("02" == data.msg){//更新成功
		        					layer.msg("密码更新成功");
		                        	layer.close(index);
		                        }else if("01" == data.msg){//更新失败
		                        	body.find("#login_warn").text("原始密码错误");
		                        }else if("03" == data.msg){
		                        	body.find("#login_warn").text("更新失败");
		                        }
		                    }
		        		});
			    	}
			     },
			    btn2:function(index,layero){layer.close(index);}
			   })
	       })
	    //密码校验
	    function checkResetInfos(body,oldpassword,newpasswordOne,newpasswordTwo){
		    var reg=/^[a-zA-Z]([-#a-zA-Z0-9]{5,19})$/;
			if(oldpassword==""||newpasswordOne==""|| newpasswordTwo==""){
				body.find("#login_warn").text("请输入完整信息");
				return false;
			}else if(newpasswordOne!=newpasswordTwo){
				body.find("#login_warn").text("请确认重置密码是否一致");
				return false;
			}else if(oldpassword==newpasswordOne){
				body.find("#login_warn").text("重置密码与原始密码一致");
				return false;
			}else if(!reg.test(newpasswordOne) || !reg.test(newpasswordTwo)){
				body.find("#login_warn").text("首位为字母的6-20位密码");
				return false;
			}
			return true;
			
		}
	 //导航收缩
	 var i=0;
	 $("#closeLeft,#openRight").on('click',function(){
		 if(i==0){
				$(".layui-side").animate({width:'40px'},'fast');
				$(".layui-body").animate({left:'40px'},'fast');
				$(".layui-footer").animate({left:'40px'},'fast');
				$("#openRight")[0].style.display="block";
				$("#closeLeft")[0].style.display="none";
				i++;
			}else{
				$(".layui-side").animate({width:'190px'},'fast');
				$(".layui-body").animate({left:'192px'},'fast');
				$(".layui-footer").animate({left:'192px'},'fast');
				$("#openRight")[0].style.display="none";
				$("#closeLeft")[0].style.display="block";
				i--;
			}
	 });
	 //重新登录
	 $("#backLogin").on('click',function(){
		 //刪除cookie
		 var isaa=$.removeCookie('KentrasoftToken', {path: '/' });
		 //获取所有menu
		 var menu = window.sessionStorage.getItem("menu")=="undefined" ? "undefined": window.sessionStorage.getItem("menu")=="" ? '' :JSON.parse(window.sessionStorage.getItem("menu"));
		 //获取打开窗口
		 var curmenu = window.sessionStorage.getItem("curmenu")=="undefined" ? "undefined" : window.sessionStorage.getItem("curmenu")=="" ? '' : JSON.parse(window.sessionStorage.getItem("curmenu"));
		 if(menu!=null && menu!=undefined){
			 $.each(menu,function(index,menu){
				 element.tabDelete("bodyTab", menu.layId);
			 });
		 }
		 //清空session缓存
		 window.sessionStorage.removeItem("menu");
		 //清空打开窗口
		 window.sessionStorage.removeItem("curmenu");
		 window.location.href = "/web/gyfvs";
	 });
	 
	 //点击导航下拉
	 element.on('nav(moreData)',function(data){
		 var selectName=data[0].innerText;
		 var nav=$(".layui-nav");
		 $.each(nav,function(index,nav){
			 if(nav.innerText.indexOf(selectName)<0){
				 nav.children[0].className="layui-nav-item";
			 }
		 })
		 
	 })
	 
})
	
	
	

	

	

