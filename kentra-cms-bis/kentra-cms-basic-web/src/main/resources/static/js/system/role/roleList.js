layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils', 'jquery'], function () {
    var table = layui.table, $ = layui.$, active = layui.tableUtils;

    //角色机构树设置
    var setting = {
        async: {
            enable: true,//开启异步加载
            url: "/api/role/getTreeList",
            type: "post"
        },
        data: {
            key: {
                name: "roleName",
                url: "roleTreeUrl"//后台替换掉了menurl 指定回调函数， 机构树显示
            },
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "roleParentId"
            }
        },
        check: {
            enable: false
        }
    };
    var roleZtree;
    //初始化加载
    $(document).ready(function () {
        //加载角色tree
    	roleZtree=$.fn.zTree.init($("#roleZtree"), setting, null);
        //加载角色列表
        table.render({
            elem: '#roleTable'
            , height: 'full-100' //表格容器距离浏览器顶部和底部的距离“和”
            , url: '/api/role/getListPage' //数据接口
            , where: {"roleParentId": "1"}
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
                groups: 5, //只显示 1 个连续页码
                limits: [5, 10, 20, 30]
            }
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left', type: 'checkbox', align: 'center'}
                , {field: 'roleName', title: '角色名', sort: true, fixed: 'left', align: 'center'}
                , {field: 'roleCode', title: '角色编号', align: 'center'}
                , {field: 'desc', title: '角色描述', align: 'center'}
            ]]
        });
    });

    //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        var roleName = $("#searchParam").val();
        table.reload('roleTable', {
            where: { //设定异步数据接口的额外参数，任意设
                roleName: roleName
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    //添加角色
    $("#addBtn").click(function () {
        //获得表格选中行Id
        layer.open({
            type: 2,
            title: '添加角色',
            area: ['700px', '360px'],
            fixed: false,
            maxmin: true,
            content: '/web/role/goAddPage',
            btn: ['确定', '取消'],
            success: function (layero, index) {
                var body = layer.getChildFrame('body', index);
                body.find("#roleParentId").val($("#parentId").val());
            },
            yes: function (index, layero) {
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#roleAddSubmit').click();
            },
            end: function () {
                active.reLoadTableData('roleTable', '/api/role/getListPage');
                roleZtree.reAsyncChildNodes(null, "refresh");
            }
        });
    });


    //编辑角色
    $("#editBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('roleTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '编辑角色',
                area: ['700px', '360px'],
                fixed: false,
                maxmin: true,
                content: '/web/role/goEditPage',
                btn: ['确定', '取消'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formRoleData = data[0];
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#roleEditSubmit').click();
                },
                end: function () {
                    //刷新用户展示列表
                    active.reLoadTableData('roleTable', '/api/role/getListPage');
                    roleZtree.reAsyncChildNodes(null, "refresh");
                }
            });
        } else if (data.length < 1) {
            parent.layer.msg("请选择一个角色！", {icon: 5, shade: 0.4, time: 1000});
        } else {
            parent.layer.msg("只能选择一个角色！", {icon: 5, shade: 0.4, time: 1000});
        }
    });


    //角色详情
    $("#detailBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('roleTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '角色详情',
                area: ['700px', '360px'],
                fixed: false,
                maxmin: true,
                content: '/web/role/goQueryPage',
                btn: ['关闭'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formRoleData = data[0];
                }
            });
        } else if (data.length < 1) {
            parent.layer.msg("请选择一个角色！", {icon: 5, shade: 0.4, time: 1000});
        } else {
            parent.layer.msg("只能选择一个角色！", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //删除
    $("#deleteBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('roleTable', 'id');
        var data = active.getCheckData('roleTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要删除所选角色信息', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/api/role/delete',
                    type: "post",
                    data: {ids: ids},
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('roleTable', '/api/role/getListPage');
                                parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                                //$.fn.zTree.init($("#roleZtree"), setting, null);//刷新roleTree
                                roleZtree.reAsyncChildNodes(null, "refresh");
                                parent.layer.close(index);
                            } else if (result.statusCode == "300") {
                                parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
                            }
                        }
                    },
                    error: function (error) {
                        parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
                    }
                })
            });
        } else {
            parent.layer.msg("请至少选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //赋权角色
    $("#empowermentBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('roleTable');
        if (data.length == 1) {
            //打开赋权页面
            layer.open({
                type: 2,
                title: '角色赋权',
                area: ['700px', '400px'],
                fixed: false,
                maxmin: true,
                content: '/web/role/empowerment',
                btn: ['确认', '关闭'],
                success: function (layero, index) {
                    //页面赋值
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formRoleData = data[0];
                },
                yes: function (index, layero) {
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#roleEmpowermentSubmit').click();
                },
                end: function () {
                    //刷新用户展示列表
                    /* active.reLoadTableData('roleTable', '/api/role/getListPage');*/
                }
            });
        } else if (data.length < 1) {
            parent.layer.msg("请选择一个角色！", {icon: 5, shade: 0.4, time: 1000});
        } else {
            parent.layer.msg("只能选择一个角色！", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    
});



