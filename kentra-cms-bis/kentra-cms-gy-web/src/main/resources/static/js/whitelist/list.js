layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils'], function () {
    var table = layui.table;
    var $ = layui.$;
    var active = layui.tableUtils;
    var dicSex = JSON.parse(window.sessionStorage.getItem("Dict"))[1].value;
    var dicCity = JSON.parse(window.sessionStorage.getItem("Dict"))[3].value;
    var dicDocumentType = JSON.parse(window.sessionStorage.getItem("Dict"))[4].value;
    var drivingCarModel = JSON.parse(window.sessionStorage.getItem("Dict"))[5].value;
    var useType = JSON.parse(window.sessionStorage.getItem("Dict"))[13].value;
    var carstype = JSON.parse(window.sessionStorage.getItem("Dict"))[14].value;
    //国籍
    var nation = JSON.parse(window.sessionStorage.getItem("Dict"))[3].value;
    //用户列表
    table.render({
        elem: '#whitelistTable'
        , height: 'full-100' //表格容器距离浏览器顶部和底部的距离“和”
        , url: '/customer/management/customer/getPageList' //数据接口
        , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
            groups: 5, //只显示 1 个连续页码
            limits: [5, 10, 20, 30]
        }
        , where: {customerStatus: "customer_status_2"}
        , id: 'whitelistTable'
        , cols: [[ //表头
            {field: 'id', align: 'center', title: 'ID', width: 80, sort: true, fixed: 'left', type: 'checkbox'}
            , {field: 'name', align: 'center', title: '姓名', sort: true, fixed: 'left'}
            , {
                field: 'sex', align: 'center', title: '性别', templet: function (el) {
                    for (var i = 0; i < dicSex.length; i++) {
                        if (el.sex == null || el.sex == '') {
                            return '';
                        }
                        if (el.sex == dicSex[i].key) {
                            return dicSex[i].value;
                        }
                    }
                }
            }
            , {
                field: 'national', align: 'center', title: '国籍', templet: function (el) {
                    for (var i = 0; i < dicCity.length; i++) {
                        if (el.national == null || el.national == '') {
                            return '';
                        }
                        if (el.national == dicCity[i].key) {
                            return dicCity[i].value;
                        }
                    }
                }
            }
            , {field: 'birthday', align: 'center', title: '出生日期', templet: '#dateTpl'}
            , {field: 'linkTelphone1', align: 'center', title: '手机号'}
            , {field: 'driveNum', align: 'center', title: '驾驶证号码'}
        ]]
    });

    //监听工具条
    table.on('tool(whitelistTableFilter)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            , layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'detail') {
            detail(data);//查看详情
        } else if (layEvent === 'edit') {
            edit(data); //编辑用户
        }
    });


    //删除按钮
    $("#deleteBtn").click(function () {
        //获得表格选中行Id
        var ids = active.getCheckAttrValue('whitelistTable', 'id');
        var data = active.getCheckData('whitelistTable');
        if (data.length > 0) {
            parent.layer.confirm('确定要将该用户移除白名单？', {icon: 3}, function (index) {
                parent.layer.closeAll('dialog');
                $.ajax({
                    url: '/customer/management/customer/updateCustomerStatus',
                    type: "post",
                    data: {
                        ids: ids,
                        customerStatus: "customer_status_0"
                    },
                    dataType: "json",
                    success: function (result) {
                        if (result != "" && result != null) {
                            if (result.statusCode == "200") {
                                active.reLoadTableData('whitelistTable', '/customer/management/customer/getPageList');
                                parent.layer.msg('移除白名单成功', {icon: 1, shade: 0.4, time: 1000})
                                parent.layer.close(index);
                            } else if (result.statusCode == "300") {
                                parent.layer.msg("移除白名单失败", {icon: 5, shade: [0.4], time: 1000});
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

    var searchNameValue = '';
    var searchPhoneValue = '';
    var searchDrivNumValue = '';
    //搜索功能
    $("#searchBtn").click(function () {
        // 查询内容
        var nameParam = $(":input[name='nameParam']").val();
        var phoneParam = $(":input[name='phoneParam']").val();
        var drivNumParam = $(":input[name='drivNumParam']").val();
        searchNameValue = nameParam;
        searchPhoneValue = phoneParam;
        searchDrivNumValue = drivNumParam;
        table.reload('whitelistTable', {
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

    var drivingLicenseList;
    //打印
    $("#printBtn").click(function () {
        var formData = active.getCheckData('whitelistTable');
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
                $("#whitePrintTbody").append(rowTem);
            }
            //打印
            $("#whitePrint").jqprint({debug: false, importCSS: true, printContainer: true, operaSupport: false});
            $(".cleanDate").empty();
            $("#whitePrintTbody").empty();
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

    //导出
    $("#exportBtn").click(function () {
        parent.layer.confirm('确定要导出客户信息？', {icon: 3}, function () {
            parent.layer.closeAll('dialog');
            window.location.href = '/customer/management/customer/exportCustomerInfos'
                + '?phoneNum=' + searchPhoneValue + '&name=' + searchNameValue + '&driveNum=' + searchDrivNumValue + '&code=customer_status_2';
        })
    });
});