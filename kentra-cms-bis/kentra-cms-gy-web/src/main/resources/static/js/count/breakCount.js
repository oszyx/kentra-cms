layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['tableUtils','laydate'], function () {
    var laydate = layui.laydate,active = layui.tableUtils;
    laydate.render({
        elem: '#breakCountYear'
        , type: 'year'
        , format: 'yyyy'
        , max: 0
        , value: new Date()
        , isInitValue: true
    });

    /*搜索*/
    $("#searchBtn").click(function () {
        var year = $("#breakCountYear").val();
        getYearDate(year);
    })
    getYearDate();
    function getYearDate(year) {
        if (year == null || year == null) {
            year=active.dateFormate(new Date(), "yyyy")
        }
        $.ajax({
            url: '/customer/breakRecord/breakCount',
            type: "post",
            async: false,
            data: {year: year},
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        var data = result.result;
                        var review = new Array();
                        var breaked = new Array();
                        var nobreak = new Array();
                        for (var i = 0; i < data.length; i++) {
                            var rw=data[i].review == null ? 0 : data[i].review;/*待审核*/
                            var bd=data[i].breaked == null ? 0 : data[i].breaked;/*审核通过-违规*/
                            var nk=data[i].nobreak == null ? 0 : data[i].nobreak;/*审核未通过-未违规*/
                            if(data[i].mon!=null&&data[i].mon!=""){
                                if(data[i].mon=="01月"){
                                    review[0] = rw;
                                    breaked[0]= bd;
                                    nobreak[0]= nk;
                                }else if(data[i].mon=="02月"){
                                    review[1] = rw;
                                    breaked[1]= bd;
                                    nobreak[1]= nk;
                                }else if(data[i].mon=="03月"){
                                    review[2] = rw;
                                    breaked[2]= bd;
                                    nobreak[2]= nk;
                                }else if(data[i].mon=="04月"){
                                    review[3] = rw;
                                    breaked[3]= bd;
                                    nobreak[3]= nk;
                                }else if(data[i].mon=="05月"){
                                    review[4] = rw;
                                    breaked[4]= bd;
                                    nobreak[4]= nk;
                                }else if(data[i].mon=="06月"){
                                    review[5] = rw;
                                    breaked[5]= bd;
                                    nobreak[5]= nk;
                                }else if(data[i].mon=="07月"){
                                    review[6] = rw;
                                    breaked[6]= bd;
                                    nobreak[6]= nk;
                                }else if(data[i].mon=="08月"){
                                    review[7] = rw;
                                    breaked[7]= bd;
                                    nobreak[7]= nk;
                                }else if(data[i].mon=="09月"){
                                    review[8] = rw;
                                    breaked[8]= bd;
                                    nobreak[8]= nk;
                                }else if(data[i].mon=="10月"){
                                    review[9] = rw;
                                    breaked[9]= bd;
                                    nobreak[9]= nk;
                                }else if(data[i].mon=="11月"){
                                    review[10] = rw;
                                    breaked[10]= bd;
                                    nobreak[10]= nk;
                                }else if(data[i].mon=="12月"){
                                    review[11] = rw;
                                    breaked[11]= bd;
                                    nobreak[11]= nk;
                                }
                            }
                        }
                        showGraph(review, breaked, nobreak,year);
                    } else if (result.statusCode == "300") {
                        parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
                    }
                }
            },
            error: function (error) {
                parent.layer.alert(JSON.parse(error.responseText).message, {icon: 2, title: '提示'});
            }
        });
    }

});

function showGraph(review,breaked,nobreak,year) {
    // 基于准备好的dom，初始化echarts实例
    var dom = document.getElementById("breakCountGraph");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    var posList = [
        'left', 'right', 'top', 'bottom',
        'inside',
        'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
        'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
    ];

    app.configParameters = {
        rotate: {//旋转角度
            min: -90,
            max: 90
        },
        align: {//文字对齐方式   水平对齐方式，可选为：'left' | 'right' | 'center'
            options: {
                left: 'left',
                center: 'center',
                right: 'right'
            }
        },
        verticalAlign: {
            options: {
                top: 'top',
                middle: 'middle',
                bottom: 'bottom'
            }
        },
        position: {
            options: echarts.util.reduce(posList, function (map, pos) {
                map[pos] = pos;
                return map;
            }, {})
        },
        distance: {
            min: 0,
            max: 100
        }
    };

    app.config = {
        rotate: 90,//柱状图  文字旋转角度
        align: 'left',
        verticalAlign: 'middle',
        position: 'insideBottom',
        distance: 15,//文字距底部距离
        onChange: function () {
            var labelOption = {
                normal: {
                    rotate: app.config.rotate,
                    align: app.config.align,
                    verticalAlign: app.config.verticalAlign,
                    position: app.config.position,
                    distance: app.config.distance
                }
            };
            myChart.setOption({
                series: [{
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }]
            });
        }
    };


    var labelOption = {
        normal: {
            show: true,
            position: app.config.position,
            distance: app.config.distance,
            align: app.config.align,
            verticalAlign: app.config.verticalAlign,
            rotate: app.config.rotate,
            formatter: '{c}',
            fontSize: 14,
            rich: {
                name: {
                    color: '#000',
                    fontWeight:'bold',
                    textBorderColor:'transparent'
                }
            }
        }
    };

    option = {
        title: {
            text: '贵阳环高'+year+'年违规记录统计',
            right: 'center',
            bottom: '0'
        },
        color: ['#4C9BC7', '#E29F39', '#D06052'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            },
            formatter:function(params,ticket, callback) {
                var res = "";
                var count = 0;
                for(var i=0;i<params.length;i++){
                    count += params[i].value
                }
                for(var i=0;i<params.length;i++){
                        res += '<font color='+params[i].color+'>'+params[i].seriesName + '</font>:'+params[i].value;
                    if (count!=0) {
                        res += '(' + (params[i].value /count*100).toFixed(2) +'%)<br/>';
                    }else{
                        res += '(0.00%)<br/>';
                    }
                }
                return res;
            }
        },
        legend: {//表头标示
            data: ['审核中', '已违规', '未违规'],
            right:10,
            textStyle:{
                fontSize:14
            }
        },
        toolbox: {
            show: true,
            orient: 'horizontal',
            left: '15',
            itemSize:20,
            itemGap:20,
            feature: {
                mark: {show: true},
                magicType: {
                    show: true,
                    type: ['line', 'bar', 'stack', 'tiled'],
                    title:{
                        line: '折线图',
                        bar:'柱状图',
                        stack:'堆叠',
                        tiled:'平铺'
                    }
                },
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        grid:{
            x:80,
            x2:80,
            y:100,
            height:320
        },
        xAxis: [
            {
                name: 'X(时间)',
                type: 'category',
                axisTick: {show: false},
                data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            }
        ],
        yAxis: [
            {
                name: 'Y(数量)',
                type: 'value'
            }
        ],
        series: [
            {
                name: '审核中',
                type: 'bar',
                label: labelOption,
                data: review
            },
            {
                name: '已违规',
                type: 'bar',
                label: labelOption,
                data: breaked
            },
            {
                name: '未违规',
                type: 'bar',
                label: labelOption,
                data: nobreak

            }
        ]
    };

    if (option && typeof option === "object") {
        myChart.setOption(option, true);
        window.onresize = myChart.resize;
    }
}
