layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils', 'laytpl', 'laydate'], function () {
    var table = layui.table, $ = layui.$, active = layui.tableUtils, laytpl = layui.laytpl, laydate = layui.laydate;


    //用户列表
    table.render({
        elem: '#versionTable'
        , height: 'full-100' //表格容器距离浏览器顶部和底部的距离“和”
        , url: '/api/version/getVersionList' //数据接口
        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
            groups: 5, //只显示 1 个连续页码
            limits: [5, 10, 20, 30]
        }
        , cols: [[ //表头
            {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left', type: 'checkbox', align: 'center'}
            , {field: 'vId', title: '版本号', align: 'center'}
            , {field: 'vName', title: '版本名称', align: 'center'}
            , {field: 'vDownloadUrl', title: '下载地址', align: 'center'}
            , {field: 'vForcedUpdate', title: '是否强制', templet: '#vForcedUpdateTpl', align: 'center'}
            , {field: 'vState', title: '版本状态', templet: '#vStateTpl', align: 'center'}
            , {field: 'vReleaseTime', title: '发布时间', templet: '#vReleaseTimeTpl', align: 'center'}
        ]]
    });

    //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        var versionId = $("#versionIdParam").val();
        var versionName = $("#versionNameParam").val();
        var vForcedUpdate = $("#vForcedUpdateParam").val();
        var vState = $("#vStateParam").val();
        table.reload('versionTable', {
            where: {
                vId: versionId,
                vName: versionName,
                vForcedUpdate: vForcedUpdate,
                vState: vState
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    //新增
    $("#addBtn").click(function () {
        //获得表格选中行Id
        layer.open({
            type: 2,
            title: '新增版本信息',
            area: ['700px', '400px'],
            fixed: false,
            maxmin: true,
            content: '/web/sysVersion/goAdd',
            btn: ['确定', '取消'],
            yes: function (index, layero) {
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#versionSubmitBtn').click();
            },
            end: function () {
                active.reLoadTableData('versionTable', '/api/version/getVersionList');
            }
        });
    });
    //详情
    $("#detailBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('versionTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '版本信息详情',
                area: ['700px', '400px'],
                fixed: false,
                maxmin: true,
                content: '/web/sysVersion/goDetail',
                btn: ['关闭'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data[0];
                }
            });
        } else {
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //编辑
    $("#editBtn").click(function () {
        var data = active.getCheckData('versionTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '编辑版本信息',
                area: ['700px', '400px'],
                fixed: false,
                maxmin: true,
                content: '/web/sysVersion/goEdit',
                btn: ['确定', '取消'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data[0];
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#versionSubmitBtn').click();
                },
                end: function () {
                    //刷新用户展示列表
                    active.reLoadTableData('versionTable', '/api/version/getVersionList');
                }
            });
        } else{
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    //上方删除按钮
    $("#deleteBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('versionTable', 'id');
        var data = active.getCheckData('versionTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要删除所选版本信息？', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/api/version/delete',
                    type: "post",
                    data: {ids: ids},
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('versionTable', '/api/version/getVersionList');
                                parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                                parent.layer.close(index);
                            } else if (result.statusCode == "300") {
                                parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 2000});
                            }
                        }
                    },
                    error: function (error) {
                        parent.layer.alert(JSON.parse(error.responseText).message, {icon: 2, title: '提示'});
                    }
                })
            });
        } else {
            parent.layer.msg("至少选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });
});