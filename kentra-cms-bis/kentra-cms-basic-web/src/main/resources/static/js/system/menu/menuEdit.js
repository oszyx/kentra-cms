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
    form.val("menuEditFormFilter", {
        "id": formData.id + ""
        , "menuName": formData.menuName + ""
        , "menuCode": formData.menuCode + ""
        , "menuUrl": formData.menuUrl + ""
        , "menuTarget":formData.menuTarget + ""
        , "relySystem":formData.relySystem + ""
        , "status":formData.status + ""
        , "menuParentId":formData.menuParentId + ""
    });
  //提交表单  JSON.stringify(data.field)
    form.on('submit(menuEditSubmitBtn)', function (data) {
        $.ajax({
            url: '/api/menu/goEdit',
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                        parent.layer.closeAll('iframe');
                    } else if (result.statusCode == "300") {
                        parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
                    }
                }
            },
            error: function (error) {
                parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
            }
        })
        return false;
    });
});

var formData = "";
