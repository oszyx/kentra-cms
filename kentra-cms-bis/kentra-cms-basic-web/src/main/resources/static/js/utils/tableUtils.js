layui.define(['table', 'form','jquery'], function(exports){
    var $ = layui.jquery;
    var form = layui.form;
    var table = layui.table;
    /**
     * @type {{getCheckData: (function(*=): *), getCheckAttrValue: (function(*=, *): string), reLoadTable: reLoadTable}}
     */
    var active ={
        /**
         * 描述：获得表格选中行的数据
         *
         * @param tableName
         * @returns {*}
         */
        getCheckData : function(tableName){
            var checkStatus = table.checkStatus(tableName);
            var data = checkStatus.data;
            return data;
        },
        /**
         * 描述：获得表格指定列选中行的数据
         * @param tableName
         * @param attrName
         * @returns {string} 例：a,b,c,d
         */
        getCheckAttrValue : function(tableName,attrName){
            var checkStatus = table.checkStatus(tableName);
            var data = checkStatus.data;
            var attrValue = '';
            for (var i = 0; i < data.length; i++) {
                if (i == data.length - 1) {
                    attrValue += data[i][attrName];
                } else {
                    attrValue += data[i][attrName] + ",";
                }
            }
            return attrValue;
        },
        /**
         * 描述：重新加载渲染表格数据 or 条件查询
         * @param tableName
         * @param url
         * @param otherParam  额外参数格式：key1:'value1',key2:'value2',...,keyN:'valueN'
         */
        reLoadTableData : function (tableName,url,otherParam) {
            table.reload(tableName, {
                url: url
                ,where:{otherParam}
                ,done: function(res, curr, count){
                    if((curr-1)!=0&&((curr-1)*res.limit==count)){
                        window.location.reload();
                    }
                }
            });
        },
        /**
         * 描述：时间戳转换日期  formate
         * @param datetime
         * @param fmt
         * @returns {*}
         */
        timestampsToString : function (datetime, fmt) {
            if (parseInt(datetime) == datetime) {
                if (datetime.length == 10) {
                    datetime = parseInt(datetime) * 1000;
                } else if (datetime.length == 13) {
                    datetime = parseInt(datetime);
                }
            }
            datetime = new Date(datetime);
            var o = {
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
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        },

        /**
         * 描述：时间格式转换
         * @param String
         * @param fmt
         * @returns {*}
         */
        dateFormate : function (String, fmt) {
            var oldTime = (new Date(String)).getTime();
            var datetime = new Date(oldTime);
            var o = {
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
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        }
    }
    exports('tableUtils',active);
});