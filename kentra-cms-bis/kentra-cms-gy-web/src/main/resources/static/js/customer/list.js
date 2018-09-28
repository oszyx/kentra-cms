layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils'], function () {
    var table = layui.table;
    var $ = layui.$;
    var active = layui.tableUtils;
    var dicSex = JSON.parse(window.sessionStorage.getItem("Dict"))[1].value;
    var dicDocumentType = JSON.parse(window.sessionStorage.getItem("Dict"))[4].value;
    var drivingCarModel = JSON.parse(window.sessionStorage.getItem("Dict"))[5].value;
    var useType = JSON.parse(window.sessionStorage.getItem("Dict"))[13].value;
    var carstype = JSON.parse(window.sessionStorage.getItem("Dict"))[14].value;
    //国籍
    var nation = JSON.parse(window.sessionStorage.getItem("Dict"))[3].value;
    //用户列表
    table.render({
        elem: '#customerTable'
        , height: '240px' //表格容器距离浏览器顶部和底部的距离“和”
        , url: '/customer/management/customer/getPageList' //数据接口
        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
            groups: 5, //只显示 5 个连续页码
            limits: [5, 10, 20, 30]
        }
        , where: {customerStatus: "customer_status_0"}
        , id: 'customerTable'
        , cols: [[ //表头
            {field: 'id', align: 'center', title: 'ID', width: 60, type: 'checkbox'}
            , {field: 'name', align: 'center', title: '姓名', event: 'drivingLicenseBtn'}
            , {field: 'sex', align: 'center', title: '性别', event: 'drivingLicenseBtn', templet: function (el) {
                    for (var i = 0; i < dicSex.length; i++) {
                        if (el.sex == null || el.sex == '') return '';
                        if (el.sex == dicSex[i].key) {
                            return dicSex[i].value;
                        }
                    }
                }}
            , {field: 'birthday', align: 'center', title: '出生日期', templet: '#dateTpl', event: 'drivingLicenseBtn'}
            , {field: 'linkTelphone1', align: 'center', title: '手机号', event: 'drivingLicenseBtn'}
            , {field: 'driveNum', align: 'center', title: '驾驶证号码', event: 'drivingLicenseBtn'}
            , {field: 'driveType', align: 'center', title: '准驾车型', event: 'drivingLicenseBtn', templet: function (el) {
                    for (var i = 0; i < drivingCarModel.length; i++) {
                        if (el.driveType == null || el.driveType == '') {
                            return '';
                        }
                        if (el.driveType == drivingCarModel[i].key) {
                            return drivingCarModel[i].value;
                        }
                    }
                }}
            , {field: 'createTime', align: 'center', title: '注册时间', templet: '#createDateFormate', event: 'drivingLicenseBtn'}
        ]]
    });

    //监听工具条
    table.on('tool(customerTableFilter)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            , layEvent = obj.event; //获得 lay-event 对应的值
        /*if (layEvent === 'detail') {
            detail(data);//查看详情
        } else if (layEvent === 'edit') {
            edit(data); //编辑用户
        } else*/
        if (layEvent === 'drivingLicenseBtn') {
            drivingLicense(data); //添加驾驶证信息
        }
    });

    var searchNameValue = '';
    var searchPhoneValue = '';
    var searchDrivNumValue = '';
    //查询按钮
    $("#searchBtn").click(function () {
        // 查询内容
        var nameParam = $(":input[name='nameParam']").val();
        var phoneParam = $(":input[name='phoneParam']").val();
        var drivNumParam = $(":input[name='drivNumParam']").val();
        searchNameValue = nameParam;
        searchPhoneValue = phoneParam;
        searchDrivNumValue = drivNumParam;
        table.reload('customerTable', {
            where: { //设定异步数据接口的额外参数，任意设
                name: nameParam,
                linkTelphone1: phoneParam,
                driveNum: drivNumParam
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
            title: '新增客户',
            area: ['700px', '463px'],
            fixed: false,
            maxmin: true,
            content: '/gyWeb/customer/goAdd',
            btn: ['确定', '取消'],
            yes: function (index, layero) {
                //提交表单1
                var body = layer.getChildFrame('body', index);//获取dom
                body.find('#customerSubmitBtn').click();
            },
            end: function () {
                active.reLoadTableData('customerTable', '/customer/management/customer/getPageList');
            }
        });
    });

    //删除按钮
    $("#deleteBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('customerTable', 'id');
        var data = active.getCheckData('customerTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要删除所选客户信息？', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/customer/management/customer/delete',
                    type: "post",
                    data: {ids: ids},
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('customerTable', '/customer/management/customer/getPageList');
                                parent.layer.msg('删除成功', {icon: 1, shade: 0.4, time: 1000})
                                parent.layer.close(index);
                            } else if (result.statusCode == "300") {
                                parent.layer.msg("删除失败", {icon: 5, shade: [0.4], time: 1000});
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

    //编辑客户信息
    $("#editBtn").click(function () {
        var data = active.getCheckData('customerTable');
        if (data.length == 0 || data.length > 1) {
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        } else {
            layer.open({
                type: 2,
                title: '编辑客户信息',
                area: ['700px', '463px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/customer/goEdit',
                btn: ['确定', '取消'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data;
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#customerFromSubmitBtn').click();
                },
                end: function () {
                    //刷新用户展示列表
                    active.reLoadTableData('customerTable', '/customer/management/customer/getPageList');
                }
            });
        }
    });

    //查看客户信息
    $("#detailBtn").click(function () {
        var data = active.getCheckData('customerTable');
        console.info(data)
        if (data.length == 0 || data.length > 1) {
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        } else {
            layer.open({
                type: 2,
                title: '查看客户信息',
                area: ['700px', '430px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/customer/goView',
                btn: ['关闭'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data;
                },
                yes: function (index, layero) {
                    layer.close(index);
                }
            });
        }
    });

    //加入黑名单按钮
    $("#joinBlacklistBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('customerTable', 'id');
        var data = active.getCheckData('customerTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要将所选客户加入黑名单？', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/customer/management/customer/updateCustomerStatus',
                    type: "post",
                    data: {
                        ids: ids,
                        customerStatus: "customer_status_1"
                    },
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('customerTable', '/customer/management/customer/getPageList');
                                parent.layer.msg('加入黑名单成功', {icon: 1, shade: 0.4, time: 1000})
                                parent.layer.close(index);
                            } else if (result.statusCode == "300") {
                                parent.layer.msg("加入黑名单失败", {icon: 5, shade: [0.4], time: 1000});
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

    //加入白名单按钮
    $("#joinWhitelistBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('customerTable', 'id');
        var data = active.getCheckData('customerTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要将所选客户加入白名单？', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/customer/management/customer/updateCustomerStatus',
                    type: "post",
                    data: {
                        ids: ids,
                        customerStatus: "customer_status_2"
                    },
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('customerTable', '/customer/management/customer/getPageList');
                                parent.layer.msg('加入白名单成功', {icon: 1, shade: 0.4, time: 1000})
                                parent.layer.close(index);
                            } else if (result.statusCode == "300") {
                                parent.layer.msg("加入白名单失败", {icon: 5, shade: [0.4], time: 1000});
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
    var height;
    //默认加载维修表格 和 设备状态
    $(document).ready(function () {
        height = Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);
    });

    //行驶证信息
    function drivingLicense(data) {
        table.render({
            elem: '#drivingLicense'
            , height: height - 421 + "px"
            , url: '/customer/management/drivingLicense/getPageList'
            , where: {customerId: data.id}
            , cols: [[ //表头
//                {field: 'customerLevel', align: 'center', title: '优先等级'}
                {field: 'licenseNum', align: 'center', title: '车牌号码'}
                , {field: 'carType', align: 'center', title: '车辆类型', templet: function (el) {
                        for (var i = 0; i < carstype.length; i++) {
                            if (el.carType == null || el.carType == '') {
                                return '';
                            }
                            if (el.carType == carstype[i].key) {
                                return carstype[i].value;
                            }
                        }
                    }}
                , {field: 'owner', align: 'center', title: '所有人'}
                , {field: 'carUsetype', align: 'center', title: '使用性质', templet: function (el) {
                        for (var i = 0; i < useType.length; i++) {
                            if (el.carUsetype == null || el.carUsetype == '') {
                                return '';
                            }
                            if (el.carUsetype == useType[i].key) {
                                return useType[i].value;
                            }
                        }
                    }}
                , {field: 'carVehicle', align: 'center', title: '车辆品牌型号'}
                , {field: 'carIndetcode', align: 'center', title: '车辆识别代号'}
                , {field: 'carFramenumber', align: 'center', title: '车发动机号码'}
                , {fixed: 'right', align: 'center', title: '刪除', toolbar: '#customerTableBar'}
            ]]
        });
    }

    table.on('tool(drivingLicenseFilter)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            , layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'deleteLicense') {
            deleteLicense(data, obj);//查看详情
        }
    });

    //删除行驶证
    function deleteLicense(data, obj) {
        parent.layer.confirm('确认要删除所选行驶证信息？', {icon: 3}, function (index) {
            // layer.confirm('确认删除行驶证', function (index) {
            obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
            layer.close(index);
            //向服务端发送删除指令
            $.ajax({
                url: "/customer/management/drivingLicense/deleteLicense",
                type: "post",
                data: {id: data.id},
                dataType: "json",
                success: function (result) {
                    if (result != null && result.statusCode == "200") {
                        parent.layer.msg(result.message, {icon: 1, shade: [0.4], time: 1000});
                    } else {
                        parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
                    }
                }
            });
        });

    }


    //添加行驶证
    $("#addDrivingLicenseBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('customerTable', 'id');
        var data = active.getCheckData('customerTable');
        if (data.length == 0 || data.length > 1) {
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        } else {
            //获得表格选中行Id
            layer.open({
                type: 2,
                title: '新增行驶证',
                area: ['700px', '430px'],
                fixed: false,
                maxmin: true,
                content: '/gyWeb/customer/goAddDrivingLicense',
                btn: ['确定', '取消'],
                success: function (layero, index) {
                    var iframe = window[layero.find('iframe')[0]['name']];
                    iframe.formData = data;
                },
                yes: function (index, layero) {
                    //提交表单1
                    var body = layer.getChildFrame('body', index);//获取dom
                    body.find('#drivingLicenseSubmitBtn').click();
                },
                end: function () {
                    active.reLoadTableData('customerTable', '/customer/management/customer/getPageList');
                }
            });
        }
    });

    //导出
    $("#exportBtn").click(function () {
        parent.layer.confirm('确定要导出客户信息？', {icon: 3}, function () {
            parent.layer.closeAll('dialog');
            window.location.href = '/customer/management/customer/exportCustomerInfos'
                + '?phoneNum=' + searchPhoneValue + '&name=' + searchNameValue + '&driveNum=' + searchDrivNumValue + '&code=customer_status_0';
        })
    });

    var drivingLicenseList;
    //打印
    $("#printBtn").click(function () {
        var formData = active.getCheckData('customerTable');
        if (formData.length < 1) {
            parent.layer.msg("请选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        } else if (formData.length > 1) {
            parent.layer.msg("只能选择一条数据", {icon: 5, shade: 0.4, time: 1000});
        } else {
            $("#nameSpan").text(formData[0].name);
            $("#linkTelphone1").text(formData[0].linkTelphone1);
            $.each(dicSex, function (index, value) {
                if (value.key === formData[0].sex) {
                    $("#sex").text(value.value);
                }
            });
            //国籍
            $.each(nation, function (index, value) {
                if (value.key == formData[0].national) {
                    $("#national").text(value.value);
                }
            });
            $.each(dicDocumentType, function (index, value) {
                if (value.key === formData[0].documentType) {
                    $("#documentType").text(value.value);
                }
            });
            $.each(drivingCarModel, function (index, value) {
                if (value.key === formData[0].driveType) {
                    $("#driveType").text(value.value);
                }
            });
            $("#documentNum").text(formData[0].documentNum);
            $("#driveNum").text(formData[0].driveNum);

            getDrivingLicense(formData[0]);
            var carType = '';
            var type = '';
            for (var i = 0; i < drivingLicenseList.length; i++) {
                $.each(carstype, function (index, value) {
                    if (value.key === drivingLicenseList[i].carType) {
                        carType = value.value;
                    }
                });
                $.each(useType, function (index, value) {
                    if (value.key === drivingLicenseList[i].carUsetype) {
                        type = value.value;
                    }
                });
                var rowTem =
                    "<tr height='36px'><td align='center'>" + (drivingLicenseList[i].licenseNum == null ? "" : drivingLicenseList[i].licenseNum) +
                    "</td><td align='center'>" + carType +
                    "</td><td align='center'>" + (drivingLicenseList[i].owner == null ? "" : drivingLicenseList[i].owner) +
                    "</td><td align='center'>" + type +
                    "</td><td align='center'>" + (drivingLicenseList[i].carIndetcode == null ? "" : drivingLicenseList[i].carIndetcode) +
                    "</td><td align='center'>" + (drivingLicenseList[i].carFramenumber == null ? "" : drivingLicenseList[i].carFramenumber) +
                    "</td></tr>";
                $("#customerPrintTbody").append(rowTem);
            }
            //打印
            $("#customerPrint").jqprint({debug: false, importCSS: true, printContainer: true, operaSupport: false});
            $(".cleanDate").empty();
            $("#customerPrintTbody").empty();
        }
    });

    //打印所选客户的所有行驶证信息
    function getDrivingLicense(data) {
        $.ajax({
            url: '/customer/management/drivingLicense/getDrivingLicenseList',
            type: "post",
            data: {"customerId": data.id},
            dataType: "json",
            async: false,
            success: function (result) {
                drivingLicenseList = result;
            }
        })
    };


});