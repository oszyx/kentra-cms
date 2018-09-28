$(function(){
	$(".nav-list li").click(function(){
		$(".nav-list li").removeClass('active');
		if($(this).find('.submenu').length >= 1){
			$(this).addClass('open');
		}else if($(this).find('.submenu').length == 0){
			$(this).addClass('active');
			$('.index-head-nav').text($(this).find('.menu-text').text())
		}
	})

	/* 左侧子菜单被选中时，把值赋给导航条 */
	$(".submenu li").click(function(){
		$(".submenu li").removeClass('sub-active');
		$(this).addClass('sub-active');
		$('.index-head-nav').text($(".submenu .sub-active a label").text());
	})

	$(".navbar").css({
		width:$(window).width()
	})
	$(".breadcrumbs").css({
		width:$(window).width() - 190
	})

	/* 右侧内容可视区域的高度 */
	$(".page-content").css({
		height:$("iframe .ifr-box").height()
	});
	$("iframe").css({
		height:$(document).height()
	});

	/* 左侧菜单：设置height */
	$(".sidebar").css({
		height:$(window).height()-$(".navbar").height()-24
	})

	/* 编辑表单：点击添加显示弹层 */
	$('.btn-add').click(function(){
		$('.lay-box').show();
	})

	/* 隐藏弹层 */
	$('.lay-close').click(function(){
		$(this).parents('.lay-box').hide();
	})

	/* Form表单：文件上传 */
	$('#id-input-file-1 , #id-input-file-2').ace_file_input({

		no_file:'No File ...',

		btn_choose:'Choose',

		btn_change:'Change',

		droppable:false,

		onchange:null,

		thumbnail:false //| true | large

		//whitelist:'gif|png|jpg|jpeg'

		//blacklist:'exe|php'

		//onchange:''

		//

	});
	$('#id-input-file-3').ace_file_input({

		style:'well',

		btn_choose:'Drop files here or click to choose',

		btn_change:null,

		no_icon:'icon-cloud-upload',

		droppable:true,

		thumbnail:'small'//large | fit

		//,icon_remove:null//set null, to hide remove/reset button

		/**,before_change:function(files, dropped) {

			//Check an example below

			//or examples/file-upload.html

			return true;

		}*/

		/**,before_remove : function() {

			return true;

		}*/

		,

		preview_error : function(filename, error_code) {

			//name of the file that failed

			//error_code values

			//1 = 'FILE_LOAD_FAILED',

			//2 = 'IMAGE_LOAD_FAILED',

			//3 = 'THUMBNAIL_FAILED'

			//alert(error_code);

		}

	})

	/* 日期（年月日）：date-picker */
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){

		$(this).prev().focus();

	});

	/* 时间段选择：date-range-picker */
	$('input[name=date-range-picker]').daterangepicker().prev().on(ace.click_event, function(){

		$(this).next().focus();

	});

	/* 时分秒：timepicker */
	$('#timepicker1').timepicker({

		minuteStep: 1,

		showSeconds: true,

		showMeridian: false

	}).next().on(ace.click_event, function(){

		$(this).prev().focus();

	});
})