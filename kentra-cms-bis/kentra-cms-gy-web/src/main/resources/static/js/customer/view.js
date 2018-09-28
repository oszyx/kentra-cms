var formData = "";
layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'jquery', 'tableUtils'], function () {
    var form = layui.form, $ = layui.jquery, active = layui.tableUtils;

    //表单赋值
    form.val("customerFromFilter", {
        "name":formData[0].name == null ? "" : formData[0].name+""
        , "birthday": formData[0].birthday == null ? "" : active.dateFormate(formData[0].birthday, "yyyy-MM-dd")+""
        , "linkTelphone1": formData[0].linkTelphone1 == null ? "" : formData[0].linkTelphone1+""
        , "linkTelphone2": formData[0].linkTelphone2 == null ? "" : formData[0].linkTelphone2+""
        , "documentNum": formData[0].documentNum == null ? "" : formData[0].documentNum+""
        , "driveNum": formData[0].driveNum == null ? "" : formData[0].driveNum+""
        , "linkAddress": formData[0].linkAddress == null ? "" : formData[0].linkAddress+""
        , "evidenceStart": formData[0].evidenceStart == null ? "" : active.dateFormate(formData[0].evidenceStart, "yyyy-MM-dd")+""
        , "effectiveStart": formData[0].effectiveStart == null ? "" : active.dateFormate(formData[0].effectiveStart, "yyyy-MM-dd")+""
        , "effectiveEnd": formData[0].effectiveEnd == null ? "" : active.dateFormate(formData[0].effectiveEnd, "yyyy-MM-dd")+""
    });
    $(document).ready(function(){
        var dicSex = JSON.parse(window.sessionStorage.getItem("Dict"))[1].value;
        var dicCity = JSON.parse(window.sessionStorage.getItem("Dict"))[3].value;
        var dicDocumentType = JSON.parse(window.sessionStorage.getItem("Dict"))[4].value;
        var drivingCarModel = JSON.parse(window.sessionStorage.getItem("Dict"))[5].value;
        $.each(dicSex,function(index,value){
            if(value.key==formData[0].sex){
                $("input[name='sex']").val(value.value);
            }
        });
        $.each(dicCity,function(index,value){
            if(value.key==formData[0].national){
                $("input[name='national']").val(value.value);
            }
        });
        $.each(dicDocumentType,function(index,value){
            if(value.key==formData[0].documentType){
                $("input[name='documentType']").val(value.value);
            }
        });
        $.each(drivingCarModel,function(index,value){
            if(value.key==formData[0].driveType){
                $("input[name='driveType']").val(value.value);
            }
        });
    });
    
});