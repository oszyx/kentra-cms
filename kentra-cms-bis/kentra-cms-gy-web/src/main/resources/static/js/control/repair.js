layui.use(['form', 'laydate', 'jquery'], function () {
    var form = layui.form, laydate = layui.laydate, $ = layui.jquery;
    var erStatus = JSON.parse(window.sessionStorage.getItem("Dict"))[11].value;

    $(document).ready(function(){
        //设备状态
        var repairStatus=$("#repairStatus");
        $.each(erStatus,function(index,value){
            if(index==0){
                repairStatus.append("<option value=''>请选择维修状态</option>");
            }
            repairStatus.append("<option value='"+value.key+"'>"+value.value+"</option>");
        });
        //重新渲染页面
        form.render();
    });

    //日期
    laydate.render({
        elem: '#repairDateStar'
        ,type: 'datetime'
        ,format: 'yyyy-MM-dd HH:mm:ss'
    });

    laydate.render({
        elem: '#repairDateEnd'
        ,type: 'datetime'
        ,format: 'yyyy-MM-dd HH:mm:ss'
    });

    //自定义验证规则
    form.verify({
        name: function (value) {
            if (value.length < 2) {
                return '姓名至少2个字符!';
            }
        },
        telphone: [/^[1][3,4,5,6,7,8,9][0-9]{9}$/, '手机号码格式不正确'],
        repairDateStar: function (value) {
            if (new Date(value) > new Date()) {
                return '维修开始时间不能大于当前日期';
            }
        },
        repairDateEnd: function (value) {
            var repairDateStar = $("input[name='repairDateStar']").val();
            if (new Date(repairDateStar) > new Date(value)) {
                return '维修结束时间不能小于维修开始时间';
            }
            if (new Date(value) > new Date()) {
                return '维修结束时间不能大于当前日期';
            }
        }
    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(repairSubmitFilter)', function (data) {
        $.ajax({
            url: '/equip/control/repair',
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.closeAll('iframe');
                        parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                    } else if (result.statusCode == "300") {
                        parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
                    }
                }
            },
            error: function (error) {
                parent.layer.alert(JSON.parse(error.responseText).message, {icon: 2, title: '提示'});
            }
        })
        return false;
    });
});