layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils','laytpl', 'laydate'], function () {
    var table = layui.table, $ = layui.$, active = layui.tableUtils,laytpl=layui.laytpl, laydate = layui.laydate;

    //日期
    laydate.render({
        elem: '#birthdayMinParam'
        ,max: 0
    });
    //日期
    laydate.render({
        elem: '#birthdayMaxParam'
        ,max: 0

    });

    //用户列表
    table.render({
        elem: '#userTable'
        , height: 'full-100' //表格容器距离浏览器顶部和底部的距离“和”
        , url: '/api/user/getListPage' //数据接口
        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
            groups: 5, //只显示 1 个连续页码
            limits: [5, 10, 20, 30]
        }
        , cols: [[ //表头
            {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left', type: 'checkbox', align: 'center'}
            , {field: 'username', title: '用户名', sort: true, fixed: 'left', align: 'center'}
           /* , {field: 'password', title: '登录密码', align: 'center'}*/
            , {field: 'telphone', title: '手机号码', align: 'center'}
            , {field: 'birthday', title: '出生日期', templet: '#birthdayTpl', align: 'center'}
            , {field: 'identityCard', title: '身份证号', align: 'center'}
            //, {field: 'status', title: '用户状态', fixed: 'right',templet: '#statusTpl', align: 'center'}
            //, {fixed: 'right', width: 165, toolbar: '#userTableBar', align: 'center'}
        ]]
    });

    //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        var usernameParam = $("#usernameParam").val();
        var telphoneParam = $("#telphoneParam").val();
        var birthdayMinParam = $("#birthdayMinParam").val();
        var birthdayMaxParam = $("#birthdayMaxParam").val();
        table.reload('userTable', {
            where: { //设定异步数据接口的额外参数，任意设
                username : usernameParam,
                telphone : telphoneParam,
                birthdayMin : birthdayMinParam,
                birthdayMax : birthdayMaxParam
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    //添加用户
    $("#addBtn").click(function () {
        //获得表格选中行Id
        layer.open({
            type: 2,
            title: '添加用户',
            area: ['700px', '400px'],
            fixed: false,
            maxmin: true,
            content: '/web/user/goAddPage',
            btn: ['确定', '取消'],
            yes: function (index, layero) {
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#userAddSubmit').click();
            },
            end:function () {
                active.reLoadTableData('userTable', '/api/user/getListPage');
            }
        });
    });

    //编辑用户
    $("#editBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('userTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '编辑用户',
                area: ['700px', '400px'],
                fixed: false,
                maxmin: true,
                content: '/web/user/goEditPage',
                btn: ['确定', '取消'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data[0];
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#userEditSubmit').click();
                },
                end: function () {
                    //刷新用户展示列表
                    active.reLoadTableData('userTable', '/api/user/getListPage');
                }
            });
        } else if (data.length < 1) {
            parent.layer.msg("请选择一个用户！", {icon: 5, shade: 0.4, time: 1000});
        } else {
            parent.layer.msg("只能选择一个用户！", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //查看用户详情
    $("#detailBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('userTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '用户详情',
                area: ['700px', '400px'],
                fixed: false,
                maxmin: true,
                content: '/web/user/goDetailPage',
                btn: ['关闭'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data[0];
                }
            });
        } else if (data.length < 1) {
            parent.layer.msg("请选择一个用户！", {icon: 5, shade: 0.4, time: 1000});
        } else {
            parent.layer.msg("只能选择一个用户！", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //删除
    $("#deleteBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('userTable', 'id');
        var data = active.getCheckData('userTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要删除所选用户信息', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/api/user/delete',
                    type: "post",
                    data: {ids: ids},
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('userTable', '/api/user/getListPage');
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
            parent.layer.msg("请至少选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //赋权
    $("#addRoleBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('userTable');
        if (data.length == 1) {
            //打开权限窗口
            layer.open({
                type: 2,
                title: '用户赋权',
                area: ['700px', '400px'],
                fixed: false,
                maxmin: true,
                content: '/web/user/goAddRolePage',
                btn: ['确认','关闭'],
                success: function (layero,index) {
                    var body = layer.getChildFrame('body',index);
                    body.find('#id').val(data[0].id);
                    body.find('#username').val(data[0].username);
                    body.find('#telphone').val(data[0].telphone);
                    body.find('#identityCard').val(data[0].identityCard);
                },
                yes: function (index, layero) {
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#userAddRolesSubmitBtn').click();
                }
            });
        } else if (data.length < 1) {
            parent.layer.msg("请选择一个用户！", {icon: 5, shade: 0.4, time: 1000});
        } else {
            parent.layer.msg("只能选择一个用户！", {icon: 5, shade: 0.4, time: 1000});
        }
    });
});