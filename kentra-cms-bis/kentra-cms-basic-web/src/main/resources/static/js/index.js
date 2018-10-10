var $, tab;
layui.config({
    base: "../js/utils/"
}).use(['bodyTab', 'form', 'element', 'layer', 'jquery'], function () {
    var form = layui.form,
        layer = layui.layer,
        element = layui.element;
    $ = layui.jquery;
    tab = layui.bodyTab({
        openTabNum: "8"//打开的选项卡数量
    });

    //初始化菜单
    $(function () {
        var user = JSON.parse(window.sessionStorage.getItem("user"));
        if (user == null || user == "") {
            window.location.href="../login.html";
            return;
        }
        console.info(user.id);
        $("#left_username").text(user.username);
        $("#top_username").text(user.username);

        $.ajax({
            type: "get",
            url: "/user/initIndex",
            dataType: "json",
            data: {"id": user.id},
            cache: false,
            async: false,
            success: function (data) {
                if (data != null && data != "") {
                    if ("200" == data.status) {
                        //菜单数据
                        tab.navBar(data.result);
                    } else if ("300" == data.status) {
                        window.location.href="http://localhost:8081";
                    }
                }
            }
        });
    })


    //折叠导航栏
    $("#switchNav").click(function () {
        var sideNavExpand = $('body').hasClass('nav-mini');
        if (!sideNavExpand) {
            $('body').addClass('nav-mini');
        } else {
            $('body').removeClass('nav-mini');
        }
        $('.nav-mini .layui-side .layui-nav .layui-nav-item').hover(function () {
            //图标模式 鼠标悬浮  菜单信息提示
            var that = $(this), text = that.children("a:eq(0)").find("cite").text();
            if ($('body').hasClass('nav-mini') && document.body.clientWidth > 750) {
                layer.tips(text, this);
            }
        }, function () {
            layer.closeAll('tips');
        });
    });

    //显示导航栏
    $(".navBar").on("click", function () {
        if ($('body').hasClass('nav-mini')) {
            $('body').removeClass('nav-mini');
        }
    });

    // 添加新窗口
    $(".layui-nav .layui-nav-item a").on("click", function () {
        addTab($(this));
        $(this).parent("li").siblings().removeClass("layui-nav-itemed");
    })

    //刷新后还原打开的窗口
    if (window.sessionStorage.getItem("menu") != null) {
        menu = JSON.parse(window.sessionStorage.getItem("menu"));
        curmenu = window.sessionStorage.getItem("curmenu");
        var openTitle = '';
        for (var i = 0; i < menu.length; i++) {
            openTitle = '';
            if (menu[i].icon.split("-")[0] == 'icon') {
                openTitle += '<i class="iconfont ' + menu[i].icon + '"></i>';
            } else {
                openTitle += '<i class="layui-icon">' + menu[i].icon + '</i>';
            }
            openTitle += '<cite>' + menu[i].title + '</cite>';
            openTitle += '<i class="layui-icon layui-unselect layui-tab-close" data-id="' + menu[i].layId + '">&#x1006;</i>';
            element.tabAdd("bodyTab", {
                title: openTitle,
                content: "<iframe src='" + menu[i].href + "' data-id='" + menu[i].layId + "'></frame>",
                id: menu[i].layId
            })
            //定位到刷新前的窗口
            if (curmenu != "undefined") {
                if (curmenu == '' || curmenu == "null") {  //定位到后台首页
                    element.tabChange("bodyTab", '');
                } else if (JSON.parse(curmenu).title == menu[i].title) {  //定位到刷新前的页面
                    element.tabChange("bodyTab", menu[i].layId);
                }
            } else {
                element.tabChange("bodyTab", menu[menu.length - 1].layId);
            }
        }
    }
})

//打开新窗口
function addTab(_this) {
    tab.tabAdd(_this);
}