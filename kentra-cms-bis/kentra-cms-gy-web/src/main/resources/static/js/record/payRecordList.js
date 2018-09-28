var iframepage_1_index;
layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils','laytpl'], function () {
    var table = layui.table, $ = layui.$,active = layui.tableUtils,laytpl=layui.laytpl;

    $(document).ready(function(){
    	//加载缴费类型、缴费状态数据字典
    	var dict1=JSON.parse(window.sessionStorage.getItem("Dict"))[8].value;
    	var searchParamPayStatus=$("#searchParamPayStatus");
    	$.each(dict1,function(index,value){
    		if(index==0)searchParamPayStatus.append("<option value=''>请选择缴费类型</option>");
    		searchParamPayStatus.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    	var dict2=JSON.parse(window.sessionStorage.getItem("Dict"))[9].value;
    	var searchParamIsPay=$("#searchParamIsPay");
    	$.each(dict2,function(index,value){
    		if(index==0)searchParamIsPay.append("<option value=''>请选择缴费状态</option>");
    		searchParamIsPay.append("<option value='"+value.key+"'>"+value.value+"</option>");
    	});
    //列表
    table.render({
        elem: '#payRecordTable'
        , height: 'full-100' //表格容器距离浏览器顶部和底部的距离“和”
        , url: '/customer/record/getListPage' //数据接口
        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
            groups: 5, //只显示 1 个连续页码
            limits: [5, 10, 20, 30]
        }
        , cols: [[ //表头
            {field: 'id', align: 'center', title: 'ID', width: 80, sort: true, type: 'checkbox'}
            , {field: 'licenseNum', align: 'center', title: '车牌号码'}
            , {field: 'entranceName', align: 'center', title: '进站名称'}
//            , {field: 'entranceTime', align: 'center', title: '进站时间',sort: true,templet: '#entranceTimeTpl'}
            , {field: 'exitName', align: 'center', title: '出站名称'}
//            , {field: 'exitTime', align: 'center', title: '出站时间',sort: true,templet: '#exitTimeTpl'}
            , {field: 'payStatus', align: 'center', title: '缴费类型',
            			templet:function (el){
            				for(var i=0;i<dict1.length;i++){
            					if(el.payStatus==dict1[i].key) return dict1[i].value;
            					}
            				}
              			}
            , {field: 'receivablesstr',align: 'center', title: '应缴费(元)'}
            , {field: 'payCountstr',align: 'center', title: '已缴费(元)'}
            , {field: 'expensesPaidstr',align: 'center', title: '待缴费(元)'}
            , {field: 'isPay', align: 'center', title: '缴费状态',
            			templet:function (el){
            				for(var i=0;i<dict2.length;i++){
            					if(el.isPay==dict2[i].key) return dict2[i].value;
            					}
            				}
              			}
           ]]
    	});
    });
    
    table.on('tool(payRecordTableFilter)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            , layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'detail') {
            detail(data);//查看详情
        } else if (layEvent === 'edit') {
            edit(data); //编辑
        } else if (layEvent === 'delet') {
        	delet(data); //删除
        }
        
    });
    
  //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        var licenseNum = $("#searchParamlicenseNum").val();
        var payStatus = $("#searchParamPayStatus").val();
        var isPay = $("#searchParamIsPay").val();
        table.reload('payRecordTable', {
            where: { //设定异步数据接口的额外参数，任意设
            	licenseNum : licenseNum,
            	payStatus : payStatus,
            	isPay : isPay
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
          title: '新增缴费记录',
          area: ['700px', '500px'],
          fixed: false,
          maxmin: true,
          content: '/gyWeb/record/goAdd',
          btn: ['确定', '取消'],
          yes: function (index, layero) {
              //提交表单1
              var body = layer.getChildFrame('body', index);//获取dom
              body.find('#payRecordAddSubmit').click();
          },
          end:function () {
              active.reLoadTableData('payRecordTable', '/customer/record/getListPage');
          }
      });
  });
    
  //删除按钮
    $("#deleteBtn").click(function () {
    	//获得表格选中行Id
      var ids = active.getCheckAttrValue('payRecordTable', 'id');
      var data = active.getCheckData('payRecordTable');
      if (data.length > 0) {
          parent.layer.confirm('确定要删除所选信息？', {icon: 3}, function (index) {
              parent.layer.closeAll('dialog');
              $.ajax({
                  url: '/customer/record/delete',
                  type: "post",
                  data: {ids: ids},
                  dataType: "json",
                  success: function (result) {
                      if (result != "" && result != null) {
                          if (result.statusCode == "200") {
                              active.reLoadTableData('payRecordTable', '/customer/record/getListPage');
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
            parent.layer.msg("至少选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //详情
    $("#detailBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('payRecordTable');
        if (data.length > 0 && data.length == 1) {
        	layer.open({
              type: 2,
              title: '缴费记录详情',
              area: ['700px', '500px'],
              fixed: false,
              maxmin: true,
              content: '/gyWeb/record/goQuery',
              btn: ['关闭'],
              success: function (layero,index) {
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

    //编辑
    $("#editBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('payRecordTable');
        if (data.length > 0 && data.length == 1) {
        	if(data[0].isPay != 'payment_state_0'){
        	layer.open({
              type: 2,
              title: '编辑缴费记录信息',
              area: ['700px', '450px'],
              fixed: false,
              maxmin: true,
              content: '/gyWeb/record/goEdit',
              btn: ['确定', '取消'],
              success: function (layero,index) {
                  var iframe = window[layero.find('iframe')[0]['name']];
                  iframe.formData = data[0];
              },
              yes: function (index, layero) {
                  //提交表单1
                  var body = layer.getChildFrame('body', index);//获取dom
                  body.find('#payRecordEditSubmit').click();
              },
              end:function () {
                  //刷新用户展示列表
                  active.reLoadTableData('payRecordTable', '/customer/record/getListPage');
              }
            });
		}else{
			parent.layer.msg("已完成缴费状态数据不允许编辑!", {icon: 5, shade: 0.4, time: 1000});
		}
        } else if (data.length > 1) {
        	parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
		} else {
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    
    //导出功能
    $("#exportBtn").click(function () {
    	
    	var licenseNumParam = $("#searchParamlicenseNum").val();
        var PayStatusParam = $("#searchParamPayStatus").val();
        var IsPayParam = $("#searchParamIsPay").val();
    	
    	console.info("licenseNumParam=" + licenseNumParam + "&PayStatusParam="+PayStatusParam+"&IsPayParam="+IsPayParam)
           	parent.layer.confirm('确定导出缴费记录信息？', {icon: 3}, function (index) {
           		parent.layer.closeAll('dialog');
                window.location.href="/customer/record/exportPayRecord"+"?licenseNumParam="+licenseNumParam+"&PayStatusParam="+PayStatusParam+"&IsPayParam="+IsPayParam;
            })
    });
    
    //打印
    $("#printBth").click(function(){
    	
        var licenseNum = active.getCheckAttrValue('payRecordTable', 'licenseNum');
        var drivingRecord = active.getCheckAttrValue('payRecordTable', 'drivingRecord');
        var data = active.getCheckData('payRecordTable');
        if (data.length > 0 && data.length == 1) {
        	
        	var payRecord = data[0],payStatus,isPay;
        	var dict1=JSON.parse(window.sessionStorage.getItem("Dict"))[8].value;
        	$.each(dict1,function(index,value){
        		if(value.key==payRecord.payStatus) payStatus=value.value;
        	});
        	var dict2=JSON.parse(window.sessionStorage.getItem("Dict"))[9].value;
        	$.each(dict2,function(index,value){
        		if(value.key==payRecord.isPay) isPay=value.value;
        	});
        	
        	$("#licenseNum").text(payRecord.licenseNum);
            $("#entranceName").text(payRecord.entranceName);
            $("#entranceTime").text(createTime(payRecord.entranceTime));
            $("#exitName").text(payRecord.exitName);
            $("#exitTime").text(createTime(payRecord.exitTime));
            $("#receivables").text(payRecord.receivablesstr);
            $("#payCount").text(payRecord.payCountstr);
            $("#expensesPaid").text(payRecord.expensesPaidstr);
            $("#payStatus").text(payStatus);
            $("#isPay").text(isPay);
        	
    	//赋值
    	$.ajax({
        	url: '/customer/drivingtrack/getDrivingTrack',
        	type: "post",
        	data: {licenseNum:licenseNum,drivingRecord:drivingRecord},
        	dataType: "json",
        	async:false,
        	success: function (result) {
        		$('#payRecordPrintTbody').html("");      		
            	if(result!=null){
            		for(var i=0;i<result.length;i++){
            		var rowTem =
						"<tr height='36px'><td align='center'>" + (i+1) +
						"</td><td align='center'>" + result[i].num +
						"</td><td align='center'>" + result[i].address +
						"</td><td align='center'>" + createTime(result[i].times) +
						"</td><td align='center'>" + result[i].gisX +
						"</td><td align='center'>" + result[i].gisY +
						"</td></tr>";
            			$("#payRecordPrintTbody").append(rowTem);
            		}
            	}
        	},
        	error: function (error) {
            	parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
        	}
    	})
    	
    	$("#payRecordPrint").jqprint({  
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
    })   
    
});  
//打印数据日期格式化
function createTime(v){
	var date = new Date(v);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    m = m<10?'0'+m:m;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var h = date.getHours();
    h = h<10?("0"+h):h;
    var M = date.getMinutes();
    M = M<10?("0"+M):M;
    var str = y+"-"+m+"-"+d+" "+h+":"+M;
    return str;
}

//子页面回调方法
function callbakLicenseSerach(value){
	layui.use(['tableUtils'],function(){
		var data=JSON.parse(value),active = layui.tableUtils;;
		//获取iframe弹出第一层
		var body = layer.getChildFrame('body', iframepage_1_index);//获取dom
	    body.find('#licenseNum').val(data.licenseNum);//车牌号码
	    body.find('#drivingRecord').val(data.drivingRecord);//记录编号
	    body.find('#entranceTime').val(active.dateFormate(data.entranceTime,"yyyy-MM-dd hh:mm:ss"));//起始时间
	    body.find('#exitTime').val(active.dateFormate(data.exitTime,"yyyy-MM-dd hh:mm:ss") );//结束时间
	    body.find('#entranceName').val(data.entranceName);//进站名称
	    body.find('#exitName').val(data.exitName);//出站名称
	});
}