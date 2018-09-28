layui.use(['form', 'laydate', 'jquery'], function () {
    var form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate;
    
  //自定义验证规则
    form.verify({
    	menuName: [/[\S]+/, '菜单名不能为空'],
        menuCode: [/[\S]+/, '菜单编号不能为空']
    });
    
    //提交表单  JSON.stringify(data.field)
    form.on('submit(menuAddSubmitBtn)', function (data) {
        $.ajax({
            url: '/api/menu/goAdd',
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