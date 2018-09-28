layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils', 'element'], function () {
    var table = layui.table, $ = layui.$, active = layui.tableUtils, element = layui.element;
    //网络状态
    var netStatus=JSON.parse(window.sessionStorage.getItem("Dict"))[16].value;
   //天线状态
    var equipStatusSelect=JSON.parse(window.sessionStorage.getItem("Dict"))[17].value;
    var erStatus = JSON.parse(window.sessionStorage.getItem("Dict"))[11].value;
    
    $(document).ready(function () {
        //加载设备状态数据字典
    	
        var controllerStatusParam = $("#controllerStatusParam");
        $.each(netStatus, function (index, value) {
            if (index == 0) {
                controllerStatusParam.append("<option value=''>请选择网络状态</option>");
            }
            controllerStatusParam.append("<option value='" + value.key + "'>" + value.value + "</option>");
        });
        
        var equipStatusParam = $("#extends3StatusParam");
        $.each(equipStatusSelect, function (index, value) {
            if (index == 0) {
            	equipStatusParam.append("<option value=''>请选择天线状态</option>");
            }
            equipStatusParam.append("<option value='" + value.key + "'>" + value.value + "</option>");
        });
        //用户列表
        table.render({
            elem: '#controlTable'
            , height: '240px'
            , url: '/equip/control/getListPage'
            , page: {
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'],
                groups: 5,
                limits: [5, 10, 20, 30]
            }
            , cols: [[
                {field: 'id', align: 'center', title: 'ID', width: 68, fixed: 'left',type: 'checkbox'}
                , {field: 'name', align: 'center', title: '设备名称',width:170, sort: true, event: 'getRepairRecord'}
                , {field: 'controllerCode', align: 'center', title: '设备编号', width:170,event: 'getRepairRecord'}
                , {field: 'controllerGisX', align: 'center', title: '经度',width:170, event: 'getRepairRecord'}
                , {field: 'controllerGisY', align: 'center', title: '纬度',width:170, event: 'getRepairRecord'}
                , {field: 'controllerStatus', align: 'center', title: '网络状态',width:160,event: 'getRepairRecord',
                    templet:function (el){
                        for(var i=0;i<netStatus.length;i++){
                            if(el.controllerStatus==netStatus[i].key){
                                return netStatus[i].value;
                            }
                        }
                    }

                }
                , {field: 'extends3', align: 'center', title: '天线状态',width:160, event: 'getRepairRecord',templet:function(el){
                	for(var i=0;i<equipStatusSelect.length;i++){
                		if(el.extends3==equipStatusSelect[i].key){
                			return equipStatusSelect[i].value
                		}
                	}
                }}
            ]]
        });
    });


    //监听工具条
    table.on('tool(controlTableFilter)', function (obj) {
        var data = obj.data, //获得当前行数据
            layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent == 'getRepairRecord') {
            repairDetail(data);
        }
    });


    var nameParam = "";
    var controllerCodeParam = "";
    var controllerStatusParam = "";

    //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        nameParam = $("#nameParam").val();
        controllerCodeParam = $("#controllerCodeParam").val();
        controllerStatusParam = $("#controllerStatusParam").val();
        extends3 = $("#extends3StatusParam").val();
        table.reload('controlTable', {
            where: { //设定异步数据接口的额外参数，任意设
            	name: nameParam,
            	controllerCode: controllerCodeParam,
            	controllerStatus: controllerStatusParam,
            	extends3:extends3
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
            title: '添加控制器设备',
            area: ['700px', '440px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/control/goAdd',
            btn: ['确定', '取消'],
            yes: function (index, layero) {
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#controlSubmitBtn').click();
            },
            end: function () {
                active.reLoadTableData('controlTable', '/equip/control/getListPage');
            }
        });
    });

    //删除按钮
    $("#deleteBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('controlTable', 'id');
        var data = active.getCheckData('controlTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要删除所选控制器设备？', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/equip/control/delete',
                    type: "post",
                    data: {ids: ids},
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('controlTable', '/equip/control/getListPage');
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

    //详情
    $("#detailBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('controlTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '控制器设备详情',
                area: ['700px', '440px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/control/goDetail',
                btn: ['关闭'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.controlForm = data[0];
                }
            });
        } else {
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //编辑
    $("#editBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('controlTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '编辑控制器设备信息',
                area: ['700px', '440px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/control/goEdit',
                btn: ['确定', '取消'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.controlForm = data[0];
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#controlFromSubmitBtn').click();
                },
                end: function () {
                    //刷新用户展示列表
                    active.reLoadTableData('controlTable', '/equip/control/getListPage');
                }
            });
        } else {
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });

    //维修
    $("#repairBtn").click(function () {
        //获得表格选中行Id
        var data = active.getCheckData('controlTable');
        if (data.length == 1) {
            layer.open({
                type: 2,
                title: '添加控制器设备维修记录',
                area: ['700px', '500px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/control/goRepair',
                btn: ['确定', '取消'],
                success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#repairDeviceId').val(data[0].id);
                    body.find('#repairDeviceName').val(data[0].name);
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#repairSubmit').click();
                }
            });
        } else {
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        }
    });
    var column =
        [[{field: 'repairDeviceName', width: 100, align: 'center', title: '设备名称'}
            , {field: 'repairUserName', width: 100, align: 'center', title: '姓名'}
            , {field: 'repairUserPhone', width: 130, align: 'center', title: '电话'}
            , {field: 'repairDateStar', width: 180, align: 'center', sort: true, title: '起始时间', templet: '#DateFormateTpl'}
            , {field: 'repairDateEnd', width: 180, align: 'center', sort: true, title: '结束时间', templet: '#DateFormateTpl'}
            , {field: 'repairStatus', width: 100, align: 'center', title: '维修状态',
                templet: function (el){
                    for(var i=0;i<erStatus.length;i++){
                        if(el.repairStatus==erStatus[i].key) return erStatus[i].value;
                    }
                }
            }
            , {field: 'repairNotice', width: 138, align: 'center', title: '通知说明'}
            , {field: 'repairReason', width: 138, align: 'center', title: '原因说明'}
            ], [{field: '', title: '暂无数据', align: 'center', colspan: 8}
        ]];
    var height;

    //默认加载维修表格
    $(document).ready(function () {
        height = Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);

        table.render({
            elem: "#controlRepair",
            cols: column
        });
    });

    //维修记录
    function repairDetail(data) {
        console.info(height);
        $.ajax({
            url: '/equip/repair/findByRepairDeviceId',
            type: "post",
            data: {"repairDeviceId": data.id},
            dataType: "json",
            async: false,
            success: function (result) {
                if (result != "" && result != null) {
                    table.render({
                        elem: "#controlRepair",
                        height: height - 421 + "px",
                        cols: [[{field: 'repairDeviceName', width: 100, align: 'center', title: '设备名称'}
                            , {field: 'repairUserName', width: 100, align: 'center', title: '姓名'}
                            , {field: 'repairUserPhone', width: 130, align: 'center', title: '电话'}
                            , {field: 'repairDateStar', width: 180, align: 'center', sort: true, title: '起始时间', templet: '#DateFormateTpl'}
                            , {field: 'repairDateEnd', width: 180, align: 'center', sort: true, title: '结束时间', templet: '#DateFormateTpl'}
                            , {field: 'repairStatus', width: 100, align: 'center', title: '维修状态',
                                templet: function (el){
                                    for(var i=0;i<erStatus.length;i++){
                                        if(el.repairStatus==erStatus[i].key) return erStatus[i].value;
                                    }
                                }
                            }
                            , {field: 'repairNotice', width: 138, align: 'center', title: '通知说明'}
                            , {field: 'repairReason', width: 138, align: 'center', title: '原因说明'}
                        ]],
                        data: result.data
                    });
                }
            }
        })
    };

    //打印
    $("#printBtn").click(function () {

        $("#controlPrintTbody").html("");
        //获得表格选中行Id
        var formData = active.getCheckData('controlTable');
        if (formData.length != 1) {
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        } else {
            //设置设备信息
            var control = formData[0];
            $("#nameSpan").text(control.name);
            $("#controllerCodeSpan").text(control.controllerCode);
            $("#controllerGisXSpan").text(control.controllerGisX);
            $("#controllerGisYSpan").text(control.controllerGisY);
            //网络地址
            $("#extends1").text(control.extends1);
            //网络端口
            $("#extends2").text(control.extends2);
            //网络状态
            var controllerStatus = getControlStatus(control.controllerStatus,netStatus);
            $("#controllerStatusSpan").text(controllerStatus);
            //天线状态
            var extends3=getControlStatus(control.extends3,equipStatusSelect)
            $("#extends3").text(extends3);
            //设备地址
            $("#controllerAddressSpan").text(control.controllerAddress);
            //描述信息
            $("#descripInfosSpan").text(control.descripInfos);

            //设置维修信息
            $.ajax({
                url: '/equip/repair/findByRepairDeviceId',
                type: "post",
                data: {repairDeviceId: control.id},
                async: false,
                dataType: "json",
                success: function (result) {
                    if (result != "" && result != null) {
                        var repairData = result.data;
                        for (var i = 0; i < repairData.length; i++) {
                            var repairStatus = getRepairStatus(repairData[i].repairStatus);
                            var rowTem =
                                "<tr height='36px'><td align='center'>" + repairData[i].repairUserName +
                                "</td><td align='center'>" + repairData[i].repairUserPhone +
                                "</td><td align='center'>" + active.dateFormate(repairData[i].repairDateStar, 'yyyy-MM-dd hh:mm:ss') +
                                "</td><td align='center'>" + active.dateFormate(repairData[i].repairDateEnd, 'yyyy-MM-dd hh:mm:ss') +
                                "</td><td align='center'>" + repairStatus +
                                "</td></tr><tr height='36px'><td align='center' >通知说明</td><td colspan='4'>" + repairData[i].repairNotice +
                                "</td></tr><tr height='36px'><td align='center' >原因说明</td><td colspan='4'>" + repairData[i].repairReason +
                                "</td></tr>";
                            $('#controlPrintTbody').append(rowTem);
                        }
                    }
                },
                error: function (error) {
                    parent.layer.alert(JSON.parse(error.responseText).message, {icon: 2, title: '提示'});
                }
            })

            //打印
            $("#controlPrint").jqprint({
                debug: false,
                importCSS: true,
                printContainer: true,
                operaSupport: false
            });
        }
    })

    //导出所有记录
    $("#exportBtn").click(function () {
        console.info("name=" + nameParam + "&controllerCode=" + controllerCodeParam + "&controllerCode=" + controllerStatusParam)
        parent.layer.confirm('确定导出控制器设备信息？', {icon: 3}, function (index) {
            parent.layer.closeAll('dialog');
            window.location.href = "/equip/control/export" + "?name=" + nameParam + "&controllerCode=" + controllerCodeParam + "&controllerStatus=" + controllerStatusParam;
        })
    });


    //设备状态判断
    function getControlStatus(status,selectValue) {
        for(var i=0;i<selectValue.length;i++){
            if(status==selectValue[i].key){
                return selectValue[i].value;
            }
        }
    }

    // 維修狀態判断
    function getRepairStatus(status) {
        for(var i=0;i<erStatus.length;i++){
            if(status==erStatus[i].key){
                return erStatus[i].value;
            }
        }
    }

});



