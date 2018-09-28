layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['table', 'form', 'tableUtils', 'laytpl', 'layer'], function () {
    var table = layui.table, $ = layui.$, active = layui.tableUtils, laytpl = layui.laytpl, layer = layui.layer,
        form = layui.form;

    // $(document).ready(function () {
    //     option = {
    //         title : {text : "5.8G设备统计"},//标题
    //         legend: {data: ['已启用', '维修中', '故障']},
    //         tooltip: {trigger: 'axis', axisPointer: {type: 'shadow'}},
    //         grid: {//设置位置
    //            left: '8%', right: '2%', bottom: '3%', containLabel: true
    //         },
    //         toolbox: {
    //             show: true,//是否显示
    //             orient: 'horizontal', //横向展示
    //             left: 'right',
    //             top: 'top',
    //             feature: {
    //                 saveAsImage: {show: true},//下载
    //                 mark: {show: true},
    //                 magicType: {show: true, type: ['line', 'bar']},//切换
    //                 dataView: {show: true, readOnly: false},//数据视图
    //                 restore: {show: true},//重置
    //             }
    //         },
    //         xAxis: {
    //             type: 'category',
    //             boundaryGap: true,//data数据显示位置
    //             data: ["已启用", "维修中", "故障"]
    //         },
    //         yAxis: {type: 'value'},
    //         series: []
    //     };
    //     // 基于准备好的dom，初始化echarts实例
    //     var myChart = echarts.init(document.getElementById('speedChartMain'));
    //     // 使用刚指定的配置项和数据显示图表。
    //     myChart.setOption(option);
    //     var speeds = [3, 4, 5];    //速度数组（实际用来盛放Y坐标值）
    //
    //     // $.post("equip/device/deviceCount",$("#speedFrom").serialize(),
    //     // $.post("#",$("#speedFrom").serialize(), function(data, status){
    //     //         if(data!=null){
    //     //             for (var i = 0; i < data.length; i++) {
    //     //                 times.push(data[i].timeStamp);
    //     //                 speeds.push(data[i].speed);
    //     //             }
    //     //             //之前option中legend和 XAxis的data,series 为空，所以现在将数据填充进去
    //     //             myChart.setOption({        //加载数据图表
    //     //                 xAxis: {
    //     //                     data: ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"]
    //     //                 },
    //     //                 series: [{
    //     //                     // 根据名字对应到相应的系列
    //     //                     // name: $("#roads").val(),
    //     //                     type:'bar',
    //     //                     data: speeds
    //     //                 }]
    //     //             });
    //     //         }
    //     //
    //     //         layer.open({
    //     //             title:'柱状图',
    //     //             type: 1,
    //     //             shade: false,
    //     //             area: ['620px', '460px'],
    //     //             shadeClose: true, //点击遮罩关闭
    //     //             content: $("#speedChart")
    //     //         });
    //     //     },"json");
    //
    //     $.ajax({
    //         url: '/equip/device/deviceCount',
    //         type: "post",
    //         data: {"year": "2018"},
    //         dataType: "json",
    //         async: false,
    //         success: function (result) {
    //             console.log(result);
    //             //之前option中legend和 XAxis的data,series 为空，所以现在将数据填充进去
    //             myChart.setOption({        //加载数据图表
    //                 series: [{
    //                     type: 'bar',
    //                     barWidth: 80,
    //                     data: speeds,
    //                     itemStyle: {   //配置样式，设置每个柱子的颜色
    //                         normal: {
    //                             color: function (params) {
    //                                 var colorList = ['#f54882', '#47d1de', '#8058bd'];
    //                                 return colorList[params.dataIndex];
    //                             }
    //                         }
    //                     },
    //                     label:{
    //                         show: true,
    //                         position: 'top',
    //                         textStyle: {
    //                             color: 'black'
    //                         }
    //                     }
    //                 }]
    //             });
    //
    //             // layer.open({
    //             //     title: '5.8G设备统计',
    //             //     type: 1,
    //             //     shade: false,
    //             //     area: ['900px', '500px'],
    //             //     shadeClose: true, //点击遮罩关闭
    //             //     content: $("#speedChart")
    //             // });
    //         },
    //         error: function (error) {
    //             parent.layer.alert(error.responseText, {icon: 2, title: '提示'});
    //         }
    //     })
    // });

});