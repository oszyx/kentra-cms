layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'jquery', 'tableUtils'], function () {
    var form = layui.form, $ = layui.jquery, active = layui.tableUtils;
    
    //自定义验证规则
    form.verify({
    	menuName: [/[\S]+/, '菜单名不能为空'],
        menuCode: [/[\S]+/, '菜单编号不能为空']
    });
    
    //表单赋值
    form.val("menuQueryFormFilter", {
        "id": formData.id + ""
        , "menuName": formData.menuName + ""
        , "menuCode": formData.menuCode + ""
        , "menuUrl": formData.menuUrl + ""
        , "menuTarget":formData.menuTarget + ""
        , "relySystem":formData.relySystem + ""
        , "status":formData.status + ""
        , "menuParentId":formData.menuParentId + ""
    });
});

var formData = "";
