layui.use(['form', 'jquery'], function () {
    var form = layui.form, $ = layui.jquery;

    //表单赋值
    $(function () {
        form.val("ledFormFilter", {
            "id": ledForm.id + ""
            , "name": ledForm.name == null ? "" : ledForm.name + ""
            , "ledCode": ledForm.ledCode == null ? "" : ledForm.ledCode + ""
            , "ledAddress": ledForm.ledAddress == null ? "" : ledForm.ledAddress + ""
            , "ledGisX": ledForm.ledGisX == null ? "" : ledForm.ledGisX + ""
            , "ledGisY": ledForm.ledGisY == null ? "" : ledForm.ledGisY + ""
            , "descripInfos": ledForm.descripInfos == null ? "" : ledForm.descripInfos + ""
            , "createTime": ledForm.createTime == null ? "" : ledForm.createTime + ""
            , "updateTime": ledForm.updateTime == null ? "" : ledForm.updateTime + ""
        });
    });
    $(document).ready(function () {
        //设备状态值
        var dict = JSON.parse(window.sessionStorage.getItem("Dict"))[7].value;
        $.each(dict, function (index, value) {
            if (value.key == ledForm.ledStatus) {
                $("input[name='ledStatus']").val(value.value);
            }
        });
    });
});
var ledForm = "";