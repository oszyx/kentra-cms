layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils', 'element'], function () {
    var table = layui.table, $ = layui.$, active = layui.tableUtils, element = layui.element;

    //维修信息列表
    table.render({
        elem: '#repairTable'
        , height: 'full-100'
        , url: '/equip/repair/getListPage'
        , page: {
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'],
            groups: 5,
            limits: [5, 10, 20, 30]
        }
        , cols: [[ //表头
            {field: 'id', align: 'center', title: 'ID', width: 80, sort: true, fixed: 'left', type: 'checkbox', rowspan: 2}
            , {field: 'repairDeviceName', align: 'center', title: '设备名称', rowspan: 2}
            , {align: 'center', title: '维修人员信息', colspan: 2}
            , {align: 'center', title: '维修时间', colspan: 2}
            , {align: 'center', title: '维修信息', colspan: 3}
            , {fixed: 'right', width: 165, align: 'center', title: '操作', toolbar: '#repairTableBar', rowspan: 2}
        ], [
            {field: 'repairUserName', align: 'center', title: '姓名'}
            , {field: 'repairUserPhone', align: 'center', title: '电话'}
            , {field: 'repairDateStar', align: 'center', title: '起始时间', templet: '#repairDateStarTpl'}
            , {field: 'repairDateEnd', align: 'center', title: '结束时间', templet: '#repairDateEndTpl'}
            , {field: 'repairStatus', align: 'center', title: '维修状态', templet: '#repairStatusTpl'}
            , {field: 'repairNotice', align: 'center', title: '通知说明'}
            , {field: 'repairReason', align: 'center', title: '原因说明'}
        ]]
    });

    //监听工具条
    table.on('tool(repairTableFilter)', function (obj) {
        var data = obj.data //获得当前行数据
            , layEvent = obj.event;
        if (layEvent === 'detail') {
            detail(data)//详情
        } else if (layEvent === 'edit') {
            edit(data); //编辑
        }
    });

    //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        var repairUserName = $("#searchParam").val();
        table.reload('repairTable', {
            where: { //设定异步数据接口的额外参数，任意设
                repairUserName: repairUserName
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    //新增维修信息
    $("#addBtn").click(function () {
        //获得表格选中行Id
        layer.open({
            type: 2,
            title: '新增维修信息',
            area: ['700px', '555px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/repair/goAdd',
            btn: ['确定', '取消'],
            yes: function (index, layero) {
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#repairSubmit').click();
            },
            end: function () {
                active.reLoadTableData('repairTable', '/equip/repair/getListPage');
            }
        });
    });

    //删除按钮
    $("#deleteBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('repairTable', 'id');
        var data = active.getCheckData('repairTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要删除所选控制器信息？', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/equip/repair/delete',
                    type: "post",
                    data: {ids: ids},
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('repairTable', '/equip/repair/getListPage');
                                parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                                parent.layer.close(index);
                            } else if (result.statusCode == "300") {
                                parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
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


    //编辑
    function edit(data) {
        layer.open({
            type: 2,
            title: '编辑维修记录',
            area: ['700px', '555px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/repair/goEdit',
            btn: ['确定', '取消'],
            success: function (layero, index) {
                var iframe = window[layero.find('iframe')[0]['name']];
                iframe.repairForm = data;
            },
            yes: function (index, layero) {
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#repairSubmit').click();
            },
            end: function () {
                //刷新用户展示列表
                active.reLoadTableData('repairTable', '/equip/repair/getListPage');
            }
        });
    }

    //详情
    function detail(data) {
        layer.open({
            type: 2,
            title: '维修记录详情',
            area: ['700px', '555px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/repair/goDetail',
            btn: ['关闭'],
            success: function (layero, index) {
                var iframe = window[layero.find('iframe')[0]['name']];
                iframe.repairForm = data;
            }
        });
    }

});