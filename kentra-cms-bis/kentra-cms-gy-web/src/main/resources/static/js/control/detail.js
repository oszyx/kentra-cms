layui.use(['form', 'jquery'], function () {
    var form = layui.form, $ = layui.jquery;
    var equipStatus = JSON.parse(window.sessionStorage.getItem("Dict"))[7].value;

    $(document).ready(function(){
    	//表单赋值
        $(function () {
            form.val("controlFormFilter", {
                "id": controlForm.id + ""
                , "name": controlForm.name == null ? "" : controlForm.name + ""
                , "controllerCode": controlForm.controllerCode == null ? "" : controlForm.controllerCode + ""
                , "controllerAddress": controlForm.controllerAddress == null ? "" : controlForm.controllerAddress + ""
                , "controllerGisX": controlForm.controllerGisX == null ? "" : controlForm.controllerGisX + ""
                , "controllerGisY": controlForm.controllerGisY == null ? "" : controlForm.controllerGisY + ""
                , "extends1":controlForm.extends1==null?"":controlForm.extends1+""
                , "extends2":controlForm.extends2==null?"":controlForm.extends2+""
                , "descripInfos": controlForm.descripInfos == null ? "" : controlForm.descripInfos + ""
            });
        })
        //网络状态
         var netStatus = JSON.parse(window.sessionStorage.getItem("Dict"))[16].value;
        $.each(netStatus,function(index,value){
        	if(value.key==controlForm.controllerStatus){
        		$("input[name='controllerStatus']").val(value.value);
        	}
        });
        //天线状态
        var equipStatus=JSON.parse(window.sessionStorage.getItem("Dict"))[17].value;
        $.each(equipStatus,function(index,value){
        	if(value.key==controlForm.extends3){
        		$("input[name='extends3']").val(value.value);
        	}
        });
        //重新渲染页面
        form.render();
    });

    
});
var controlForm = "";