/*左侧导航栏*/
function navBar(data) {
    var ulHtml = '<ul class="layui-nav layui-nav-tree">';
    for (var i = 0; i < data.length; i++) {
        if (data[i].menuSpread=="true") {// 是否展开菜单
            ulHtml += '<li class="layui-nav-item layui-nav-itemed">';
        } else {
            ulHtml += '<li class="layui-nav-item">';
        }

        if (data[i].childrens != undefined && data[i].childrens.length > 0) { //子菜单
            ulHtml += '<a href="javascript:;">';
            if (data[i].menuIcon != undefined && data[i].menuIcon != '') { //菜单图标
                if (data[i].menuIcon.indexOf("icon-") != -1) {
                    ulHtml += '<i class="iconfont ' + data[i].menuIcon + '" data-icon="' + data[i].menuIcon + '"></i>';
                } else {
                    ulHtml += '<i class="layui-icon" data-icon="' + data[i].menuIcon + '">' + data[i].menuIcon + '</i>';
                }
            }
            ulHtml += '<span><cite>' + data[i].menuName + '</cite></span>'; //菜单名称
            ulHtml += '<span class="layui-nav-more"></span>';
            ulHtml += '</a>'
            ulHtml += '<dl class="layui-nav-child">';
            for (var j = 0; j < data[i].childrens.length; j++) { //子菜单
                ulHtml += '<dd><a href="javascript:;" data-url="' + data[i].childrens[j].menuUrl + '">';//菜单路径
                if (data[i].childrens[j].menuIcon != undefined && data[i].childrens[j].menuIcon != '') {//菜单图标
                    if (data[i].childrens[j].menuIcon.indexOf("icon-") != -1) {
                        ulHtml += '<i class="iconfont ' + data[i].childrens[j].menuIcon + '" data-icon="' + data[i].childrens[j].menuIcon + '"></i>';
                    } else {
                        ulHtml += '<i class="layui-icon" data-icon="' + data[i].childrens[j].menuIcon + '">' + data[i].childrens[j].menuIcon + '</i>';
                    }
                }
                ulHtml += '<cite>' + data[i].childrens[j].menuName + '</cite></a></dd>';//菜单名称
            }
            ulHtml += "</dl>"
        } else {
            ulHtml += '<a href="javascript:;" data-url="' + data[i].menuUrl + '">';//父菜单菜单 路径
            if (data[i].menuIcon != undefined && data[i].menuIcon != '') {//菜单图标
                if (data[i].menuIcon.indexOf("icon-") != -1) {
                    ulHtml += '<i class="iconfont ' + data[i].menuIcon + '" data-icon="' + data[i].menuIcon + '"></i>';
                } else {
                    ulHtml += '<i class="layui-icon" data-icon="' + data[i].menuIcon + '">' + data[i].menuIcon + '</i>';
                }
            }
            ulHtml += '<cite>' + data[i].menuName + '</cite></a>';//菜单名称
        }
        ulHtml += '</li>'
    }
    ulHtml += '</ul>';
    return ulHtml;
}