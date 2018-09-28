layui.use(['form', 'jquery'], function () {
    var form = layui.form , $ = layui.jquery;
    //获取行驶轨迹
    $(document).ready(function(){
    	var trackid=$("#trackid").val();
    	var license=$("#license").val();
    	$.ajax({
    		url:"/customer/getMapInfos",
    		type:"post",
    		data:{trackid:trackid},
    		success:function(data){
    			if(data!="" && data!=null){
    				var map = new BMap.Map("allmap");
    				map.disableDragging();//禁止拖拽
    				var pointArray=[];
    				var waypointArray=[];
    				$.each(data,function(index,obj){
    					var point=new BMap.Point(obj.gisx,obj.gisy)
    					pointArray.push(point);
    					if(index>0 && index<data.length-1){
    						waypointArray.push(point);
    					}
    				})
    				
    				if(data.length>1){
    					var gisx=(data[0].gisx+data[data.length-1].gisx)/2;
    					var gisy=(data[0].gisy+data[data.length-1].gisy)/2
    					map.centerAndZoom(new BMap.Point(gisx,gisy),13);  //设置中心点
    					var driving = new BMap.DrivingRoute(map,{
        					renderOptions : {
        						map : map,
        						autoViewport : true
        					}
        				});
        				//查询
        				driving.search(pointArray[0],pointArray[data.length-1],{
        					waypoints : waypointArray
        				});
        				//添加车辆信息
    				    addCarInfo(map,data,license);
    				}else if(data.length==1){//一个点标记为经过点
    					map.centerAndZoom(pointArray[0],12);  //设置中心点
    					var marker = new BMap.Marker(pointArray[0]);
    					map.addOverlay(marker); 
    					//添加车辆信息
    				    addCarInfo(map,data,license);
    				}
    			}else{
    				var map = new BMap.Map("allmap");
    				map.addControl(new BMap.NavigationControl());   //缩放按钮
    				map.enableScrollWheelZoom(true);                //开启鼠标滚轮缩放
    				map.centerAndZoom(new BMap.Point(106.698974,26.605967),12);  //贵阳中心
    				var driving = new BMap.DrivingRoute(map,{
    					renderOptions : {
    						map : map,
    						autoViewport : true
    					}
    				});
    				driving.search();
    				//添加车辆信息
				    addCarInfo(map,data,license);
    			}
    		}
    	})
    })
    
});

/**
 * 添加车辆信息
 * @param map
 * @returns
 */
function addCarInfo(map,data,license){
	   function ZoomControl(){// 默认停靠位置和偏移量
	     this.defaultAnchor = BMAP_ANCHOR_TOP_RIGHT;
	     this.defaultOffset = new BMap.Size(30, 20);
	   }
	   ZoomControl.prototype = new BMap.Control();
	   ZoomControl.prototype.initialize = function(map){
	   var div = document.createElement("div");
	   div.style.width = "260px";
	   div.style.height = "200px";
	   div.style.color = "rgba(237,45,45)";
	   div.style.backgroundColor = "rgba(0,0,0,0~1)";
	   div.innerHTML="<h1>"+license+"</h1>";
	   map.getContainer().appendChild(div);
		  return div;
		}
		var myZoomCtrl = new ZoomControl();
		map.addControl(myZoomCtrl);
}