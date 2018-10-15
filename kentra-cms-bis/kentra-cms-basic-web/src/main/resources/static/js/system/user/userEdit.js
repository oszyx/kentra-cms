layui.config({
    base: "../js/utils/"
}).extend({
    tableUtils: 'tableUtils'
}).use(['form', 'laydate', 'jquery', 'tableUtils'], function () {
    var form = layui.form, $ = layui.jquery, laydate = layui.laydate, active = layui.tableUtils;

    //日期
    laydate.render({
        elem: '#birthday'
    });


    //自定义验证规则
    form.verify({
        username: [/^([a-zA-Z0-9\u4e00-\u9fa5]{2,20})$/, '2-20位任意:字母、数字、汉字'],
        password: [/^[a-zA-Z]([-#a-zA-Z0-9]{5,19})$/, '密码格式不正确！【6-20位：1.首位位字母 2.字母，数字，减号，井号】'],
        telphone: [/^[1][3,4,5,6,7,8,9][0-9]{9}$/, '手机号码格式不正确'],
        identityCard: function(value){
            var msg = IdCodeValid(value);
            if(!msg.pass){
                return msg.msg;
            }
        },
        birthday: function (value) {
            if (new Date(value) > new Date()) {
                return '出生日期不能大于当前日期';
            }
        }
    });

    $("input[name='password']").blur(function(){
        var password=$("input[name='password']").val();
        if (!password) {
            layer.msg('密码为必填项!',{icon: 5});
            return;
        }
        if(!/^[a-zA-Z]([-#a-zA-Z0-9]{5,19})$/.test(password)){
            layer.msg('密码格式不正确！【6-20位：1.首位位字母 2.字母，数字，减号，井号】', {icon: 5});
        }
    });
    $("input[name='identityCard']").blur(function(){
        var identity=$("input[name='identityCard']").val();
        var msg = IdCodeValid(identity);
        if(!msg.pass){
            layer.msg(msg.msg, {icon: 5});
        }
    });

    function IdCodeValid(code){
        //身份证号合法性验证
        //支持15位和18位身份证号
        //支持地址编码、出生日期、校验位验证
        var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
        var row={
            'pass':true,
            'msg':'验证成功'
        };
        if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|[xX])$/.test(code)){
            row={
                'pass':false,
                'msg':'身份证号格式错误'
            };
        }else if(!city[code.substr(0,2)]){
            row={
                'pass':false,
                'msg':'身份证号地址编码错误'
            };
        }else{
            //18位身份证需要验证最后一位校验位
            if(code.length == 18){
                code = code.split('');
                //∑(ai×Wi)(mod 11)
                //加权因子
                var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                //校验位
                var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                var sum = 0;
                var ai = 0;
                var wi = 0;
                for (var i = 0; i < 17; i++)
                {
                    ai = code[i];
                    wi = factor[i];
                    sum += ai * wi;
                }
                if(parity[sum % 11] != code[17].toUpperCase()){
                    row={
                        'pass':false,
                        'msg':'身份证号校验位错误'
                    };
                }
            }
        }
        return row;
    }


    //表单赋值
    form.val("userEditFormFilter", {
        "id":formData.id+""
        ,"username": formData.username == null ? "" : formData.username+""
        , "password": formData.password == null ? "" : formData.password+""
        , "telphone": formData.telphone == null ? "" : formData.telphone+""
        , "birthday": active.dateFormate(formData.birthday, "yyyy-MM-dd")+""
        , "identityCard": formData.identityCard == null ? "" : formData.identityCard+""
        , "status": formData.status == null ? "" : formData.status+""
    });

    //提交表单  JSON.stringify(data.field)
    form.on('submit(userEditSubmitBtn)', function(data){
        $.ajax({
            url: '/api/user/edit',
            type: "post",
            data: data.field,
            dataType: "json",
            success: function (result) {
                if (result != "" && result != null) {
                    if (result.statusCode == "200") {
                        parent.layer.msg(result.message, {icon: 1, shade: 0.4, time: 1000})
                        parent.layer.closeAll('iframe');
                    } else if (result.statusCode == "300") {
                        parent.layer.msg(result.message, {icon: 5, shade: [0.4], time: 1000});
                    }
                }
            },
            error: function (error) {
                parent.layer.alert(JSON.parse(error.responseText).message, {icon: 2, title: '提示'});
            }
        })
        return false;
    });

});

// window.setFormValues = function (data){
var formData = "";

