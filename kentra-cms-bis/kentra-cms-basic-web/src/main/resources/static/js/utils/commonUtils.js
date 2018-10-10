/**
 * 描述：通用工具类
 */
layui.define(['jquery'], function(exports){
    var $ = layui.jquery;
    var commonUtils ={
        /**描述：时间戳格式化为日期*/
        formateTimestamps : function (datetime, fmt) {
            return timestampsFormat(datetime, fmt);
        },
        /**描述：字符串格式化为日期*/
        formateDate : function (String, fmt) {
            var oldTime = new Date(String).getTime();
            return format(oldTime, fmt);
        }
    }
    exports('commonUtils',commonUtils);
});


/**
 * 描述：时间戳格式化为日期
 *
 * @param timestamps
 * @param fmt
 * @returns {*}
 */
function format(datetime, fmt) {
    if (parseInt(datetime) == datetime) {
        if (datetime.length == 10) {
            datetime = parseInt(datetime) * 1000;
        } else if (datetime.length == 13) {
            datetime = parseInt(datetime);
        }
    }
    var datetime = new Date(datetime);
    var obj = {
        "M+": datetime.getMonth() + 1,                 //月份
        "d+": datetime.getDate(),                    //日
        "h+": datetime.getHours(),                   //小时
        "m+": datetime.getMinutes(),                 //分
        "s+": datetime.getSeconds(),                 //秒
        "q+": Math.floor((datetime.getMonth() + 3) / 3), //季度
        "S": datetime.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in obj)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (obj[k]) : (("00" + obj[k]).substr(("" + obj[k]).length)));
    return fmt;
}