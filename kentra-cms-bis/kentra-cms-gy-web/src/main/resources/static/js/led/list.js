layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils', 'element'], function () {
    var table = layui.table, $ = layui.$, active = layui.tableUtils, element = layui.element;
    var equipStatus = JSON.parse(window.sessionStorage.getItem("Dict"))[7].value;
    var equipRepairStatus =JSON.parse(window.sessionStorage.getItem("Dict"))[11].value;
    //用户列表
    table.render({
        elem: '#ledTable'
        , height: '240px'
        , url: '/equip/led/getLedPage'
        , method: 'post'
        , page: {layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], groups: 5, limits: [5, 10, 20, 30]}
        , cols: [[
            {field: 'id', align: 'center', title: 'ID', width: 68, sort: true, fixed: 'left', type: 'checkbox', rowspan: 2}
            , {field: 'name',align: 'center',title: '设备名称',sort: true, rowspan: 2, event: 'getRepairRecord'}
            , {field: 'ledCode', align: 'center', title: '设备编号',rowspan: 2, event: 'getRepairRecord'}
            , {field: 'ledGisX', align: 'center', title: '经度', event: 'getRepairRecord'}
            , {field: 'ledGisY', align: 'center', title: '纬度', event: 'getRepairRecord'}
            , {field: 'ledStatus', align: 'center', title: '设备状态',templet:function (el){
                    for(var i=0;i<equipStatus.length;i++){
                        if(el.ledStatus==equipStatus[i].key){
                            return equipStatus[i].value;
                        }
                    }
                }, rowspan: 2, event: 'getRepairRecord'}
        ]],
        done: function (res, curr, count) {
            //单机行数据
            $('.layui-table-body tr').each(function (i) {
                var index = $(this).attr('data-index');
                $(this).click(function () {
                    //调用维护记录  index当前行号
                    //repairDetail(formData[index]);
                });
            });
        }
    });

    //监听工具条
    table.on('tool(ledTableFilter)', function (obj) {
        var data = obj.data //获得当前行数据
            , layEvent = obj.event;
        // if (layEvent === 'ledDetail') {
        //     ledDetail(data)//详情
        // } else if (layEvent === 'ledEdit') {
        //     ledEdit(data); //编辑
        // }
        // else if (layEvent === 'ledRepair') {
        //     ledRepair(data);//维护
        // }else
        if (layEvent === 'getRepairRecord') {
            getRepairRecord(data);//维护记录
        }
        //  else if (layEvent === 'deleteLed') {
        //     deleteLed(data);//删除
        // }
    });

    //详情
    $("#ledDetail").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('ledTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: 'LED设备详情',
                area: ['700px', '400px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/led/goLedDetail',
                btn: ['关闭'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.ledForm = data[0];
                }
            });
        } else{
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //维修
    $("#ledRepair").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('ledTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '添加LED设备维修记录',
                area: ['700px', '420px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/led/repairLed',
                btn: ['确定', '取消'],
                success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#repairDeviceId').val(data[0].id);
                    body.find('#repairDeviceName').val(data[0].name);
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#ledFormSubmitBtn').click();
                }
            });
        } else{
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //编辑
    $("#ledEdit").click(function () {
        var data = active.getCheckData('ledTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '编辑LED设备信息',
                area: ['700px', '400px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/led/goLedEdit',
                btn: ['确定', '取消'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.ledForm = data[0];
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#ledFormSubmitBtn').click();
                },
                end: function () {
                    //刷新用户展示列表
                    active.reLoadTableData('ledTable', '/equip/led/getLedPage');
                }
            });
        } else{
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //上方删除按钮
    $("#deleteBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('ledTable', 'id');
        var data = active.getCheckData('ledTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要删除所选LED信息？', {icon: 3}, function (index) {
                for (i=0;i<data.length;i++){
                    if (data[i].ledStatus!=='equipment_state_0'){
                        parent.layer.msg("设备已启用无法删除", {icon: 5, shade: 0.4, time: 2000});
                    	return;
                    }
                }
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/equip/led/delete',
                    type: "post",
                    data: {ids: ids},
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('ledTable', '/equip/led/getLedPage');
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

    var searchNameValue='' ;
    var searchCodeValue='' ;
    var searchStatusValue='' ;
    //搜索功能
    $("#searchBtn").click(function () {
        // 查询内容
        var nameValue = $("#nameParam").val();
        var codeValue = $("#codeParam").val();
        var statusValue = $("#statusParam").val();
        searchNameValue = nameValue;
        searchCodeValue = codeValue;
        searchStatusValue = statusValue;
        table.reload('ledTable', {
            where: { //设定异步数据接口的额外参数，任意设
                name: nameValue,
                ledCode: codeValue,
                ledStatus: statusValue
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });

    });

    //添加功能
    $("#addBtn").click(function () {
        //获得表格选中行Id
        layer.open({
            type: 2,
            title: '添加LED设备',
            area: ['700px', '400px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/led/addLed',
            btn: ['确定', '取消'],
            yes: function (index, layero) {
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#ledSubmitBtn').click();
            },
            end: function () {
                active.reLoadTableData('ledTable', '/equip/led/getLedPage');
            }
        });
    });

    //导出功能
    $("#exportBtn").click(function () {
        parent.layer.confirm('确定要导出LED信息？', {icon: 3}, function (index) {
            parent.layer.closeAll('dialog');
            // 查询内容
            var searchName = $("#nameParam").val();
            var searchCode = $("#codeParam").val();
            var searchStatus = $("#statusParam").val();
            window.location.href = "/equip/led/export" + "?searchName=" + searchName+ "&searchCode=" +searchCode+ "&searchStatus=" +searchStatus;
        })
    });

    var  repairList ;
    //打印功能
    $("#printBtn").click(function () {
            var formData = active.getCheckData('ledTable');
            if (formData.length != 1) {
        	   parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
    	       return;
            }
            //清空数据
            $("#ledRepairTbody").empty();
            var ledStatus = "";
            $.each(equipStatus,function(index,value){
                if(formData[0].ledStatus==value.key) ledStatus=value.value;
            });
            $("#nameSpan").text(formData[0].name);
            $("#ledCode").text(formData[0].ledCode);
            $("#ledGisX").text(formData[0].ledGisX);
            $("#ledGisY").text(formData[0].ledGisY);
            $("#ledAddress").text(formData[0].name);
            $("#ledStatus").text(ledStatus);
            $("#descripInfos").text(formData[0].descripInfos);
            //打印维修记录
            printLedRepair(formData[0]);
            for(var i=0;i<repairList.length;i++){ //
                var repairStatus = "";
                $.each(equipRepairStatus,function(index,value){
                    if(repairList[i].repairStatus==value.key){
                        repairStatus=value.value;
                    }
                });
                var rowTem =
                    "<tr height='36px'><td align='center'>" + (repairList[i].repairUserName ==null?"暂无":repairList[i].repairUserName) +
                    "</td><td align='center'>" + (repairList[i].repairUserPhone==null?"暂无":repairList[i].repairUserPhone) +
                    "</td><td align='center'>" + (repairList[i].repairDateStar ==null?"暂无":formatDate(repairList[i].repairDateStar)) +
                    "</td><td align='center'>" + (repairList[i].repairDateEnd ==null?"暂无":formatDate(repairList[i].repairDateEnd))+
                    "</td><td align='center'>" + repairStatus +
                    "</td></tr><tr height='36px'><td align='center' >通知说明</td><td colspan='4' align='center'>" + (repairList[i].repairNotice==null?"暂无":repairList[i].repairNotice)+
                    "</td></tr><tr height='36px'><td align='center' >原因说明</td><td colspan='4' align='center'>" + (repairList[i].repairReason==null?"暂无":repairList[i].repairReason)+
                    "</td></tr>";
                $("#ledRepairTbody").append(rowTem);
            }
            /*active.printPage('ledPrint');*/
            $("#ledPrint").jqprint({
                debug: false,
                importCSS: true,
                printContainer: true,
                operaSupport: false
            });

    });

    //打印维修记录
    function printLedRepair(data) {
        $.ajax({
            url: '/equip/led/getRepairRecord',
            type: "post",
            data: {"ledId": data.id},
            dataType: "json",
            async: false,
            success: function (result) {
                repairList = result;
            }
        })
    }

    //定义column
    var column = [
        [{field: 'repairDeviceName',align: 'center', title: '设备名称'}
            , {field: 'repairUserName', align: 'center', title: '姓名'}
            , {field: 'repairUserPhone',align: 'center', title: '电话'}
            , {field: 'repairDateStar',align: 'center', title: '起始时间',sort: true, templet: '#StarDateFormate'}
            , {field: 'repairDateEnd',align: 'center', title: '结束时间',sort: true, templet: '#EndDateFormate'}
            , {field: 'repairStatus', align: 'center', title: '维修状态', templet: '#repairStatusTpl'}
            , {field: 'repairNotice',align: 'center', title: '通知说明'}
            , {field: 'repairReason',align: 'center', title: '原因说明'}
        ],
        [ //标题
            {field: '', title: '暂无数据', align: 'center', colspan: 8}
        ]];

    var height ;
    //默认加载维修表格 和 设备状态
    $(document).ready(function () {
        height = Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);
        //加载设备状态数据字典
        var statusParam = $("#statusParam");
        $.each(equipStatus, function (index, value) {
            if (index == 0) {
                statusParam.append("<option value=''>请选择设备状态</option>");
            }
            statusParam.append("<option value='" + value.key + "'>" + value.value + "</option>");
        });
        table.render({
            elem: "#ledRepairTable",
            cols: column,
            height: height-421+"px",
        });
    });

    //维修记录
    function getRepairRecord(data) {
        $.ajax({
            url: '/equip/led/getRepairRecord',
            type: "post",
            data: {"ledId": data.id},
            dataType: "json",
            async: false,
            success: function (result) {
                if (result != "" && result != null) {
                    table.render({
                        elem: "#ledRepairTable",
                        height: height-421+"px",
                        cols: [[{field: 'repairDeviceName',align: 'center', title: '设备名称'}
                            , {field: 'repairUserName',  align: 'center', title: '姓名'}
                            , {field: 'repairUserPhone', align: 'center', title: '电话'}
                            , {field: 'repairDateStar', align: 'center', title: '起始时间',sort: true, templet: '#StarDateFormate'}
                            , {field: 'repairDateEnd',align: 'center', title: '结束时间',sort: true, templet: '#EndDateFormate'}
                            , {field: 'repairStatus',align: 'center', title: '维修状态', templet:function (el){
                                    for(var i=0;i<equipRepairStatus.length;i++){
                                        if(el.repairStatus===equipRepairStatus[i].key){
                                            return equipRepairStatus[i].value;
                                        }
                                    }
                                }}
                            , {field: 'repairNotice',align: 'center', title: '通知说明'}
                            , {field: 'repairReason',align: 'center', title: '原因说明'}
                        ]],
                        data: result
                    });
                } else {
                    table.render({
                        elem: "#ledRepairTable",
                        cols: column
                    });
                }
            }
        })
    }

    function formatDate(time){
        var date = new Date(time);

        var year = date.getFullYear(),
            month = date.getMonth() + 1,//月份是从0开始的
            day = date.getDate(),
            hour = date.getHours(),
            min = date.getMinutes(),
            sec = date.getSeconds();
        var newTime = year + '-' +
            month + '-' +
            day + ' ' +
            hour + ':' +
            min + ':' +
            sec;
        return newTime;
    }
})