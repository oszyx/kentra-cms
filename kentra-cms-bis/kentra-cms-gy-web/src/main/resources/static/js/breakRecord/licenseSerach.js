layui.use(['layer','form','table','laydate', 'jquery'], function () {
	var table = layui.table, $ = layui.$,active = layui.tableUtils;
	  //查询数据
	  $(document).ready(function(){
		var licenseSerachNum=$("#licenseNum").val();
		table.render({
	        elem: '#drvingRecordTable', 
	        height: '410px', 
	        url: '/customer/drivingrecord/getLicenseNumList',
	        where:{"licenseNum":licenseSerachNum}, 
	        cols: [[ //表头
	              {field: 'entranceName',width:100,align: 'center', title: '进站名称'}, 
	              {field: 'entranceTime',width:186,sort:true,align: 'center', title: '进站时间',templet:'#entranceTimeTpl'}, 
	              {field: 'exitName',width:100, align: 'center', title: '出站名称'}, 
	              {field: 'exitTime',width:186,sort:true,align: 'center', title: '出站时间',templet:'#exitTimeTpl'},
	              {fixed: 'right',width:80,align: 'center', title: '操作', toolbar: '#drvingRecordTableBar'}
	            ]]
	      });
	  });
	  
	  //监听工具条
	  table.on('tool(drvingRecordTableFilter)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
	        var data = obj.data //获得当前行数据
	            , layEvent = obj.event; //获得 lay-event 对应的值
	        if (layEvent === 'drvingRecordChecked') {
	        	drvingRecordBack(data); //添加驾驶证信息
	        }
	    });
	  
	 //选择数据回调 
     function drvingRecordBack(data){
    	 //调用父类方法
    	 window.parent.callbakLicenseSerach(JSON.stringify(data));
    	 //关闭当前窗口
    	 var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    	 parent.layer.close(index); //再执行关闭
     }
	  
});


