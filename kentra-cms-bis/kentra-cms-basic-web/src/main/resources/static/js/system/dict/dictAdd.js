layui.use(['form', 'laydate', 'jquery'], function () {
    var form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate;

    //自定义验证规则
    form.verify({
    	dictName: function (value) {
    		if(value=="" || value==null){
                return '字典名称不能为空';
    		}else  if (value.length > 20) {
                return '字典名称不能超过20个长度';
            }
        }
    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(dictAddSubmitBtn)', function (data) {
        $.ajax({
            url: '/api/sys/dict/add',
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.msg('新增成功', {icon: 1, shade: 0.4, time: 1000})
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