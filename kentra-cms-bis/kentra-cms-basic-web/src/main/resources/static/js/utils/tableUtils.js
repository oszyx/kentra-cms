layui.define(['table', 'form','jquery'], function(exports){
    var $ = layui.jquery;
    var form = layui.form;
    var table = layui.table;

    var tableUtils ={
        /**
         * 描述：获得表格数据指定列选中行的数据
         *
         * @param tableName
         * @param attrName
         * @returns {string} 例：a,b,c,d
         */
        getCheckAttrValueFromTableData : function(tableData,attrName){
            var attrValue = '';
            for (var i = 0; i < tableData.length; i++) {
                if (i == tableData.length - 1) {
                    attrValue += tableData[i][attrName];
                } else {
                    attrValue += tableData[i][attrName] + ",";
                }
            }
            return attrValue;
        },
        /**
         * 描述：获得表格指定列选中行的数据
         * @param tableName
         * @param attrName
         * @returns {string} 例：a,b,c,d
         */
        getCheckAttrValueFromTableName : function(tableName,attrName){
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
         *
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
        }
    }
    exports('tableUtils',tableUtils);
});