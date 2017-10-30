<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#main{
		width:100%;
		height:100%;
	}
	#chartFrame{
		width:100%;
	}
	#chartFrame ul{
		list-style: none;
		width:100%;
		height:50%;
	}
	#chartFrame ul li{
		float:left;
		width:50%;	
	}
	#echarts1{
		float:left;
		position:relative;
		width:500px;
		height:300px;
		margin-left:5%;
	}
	#echarts2{
		float:left;
		position:relative;
		width:500px;
		height:300px;
	}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath }/lib/layui/css/layui.css">
</head>
<body style="background:#F0F0F0;">
	<div id="main">
		<div id="chartFrame">
			<ul>
				<li>
					<div id="echarts1"></div>
				</li>
				<li>
					<div id="echarts2"></div>
				</li>
			</ul>	
		</div>
		
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/lib/echarts/echarts.js"></script>

<script type="text/javascript">
	var echartsWidth1 = window.innerWidth*0.55+'px';
	var echartsWidth2 = window.innerWidth*0.5+'px';
	var echartHeight1 = window.innerHeight*0.95+'px';
	var echartHeight2 = window.innerHeight*0.8+'px';
	var chartWidth = window.innerWidth+'px';
	var chartHeight = window.innerHeight+'px';
	$('#chartFrame').css({'height':chartHeight});
	$('#chartFrame').css({'weight':chartWidth});
	$('#echarts1').css({'width':echartsWidth1,'height':echartHeight1});
	$('#echarts2').css({'width':echartsWidth2,'height':echartHeight2});
	//基于准备好的DOM，初始化echarts实例
	var myCharts=echarts.init(document.getElementById('echarts1'));
	var myCharts2=echarts.init(document.getElementById('echarts2'));
	var date=new Date();			//获取当前时间
	var nowdateYear=date.getFullYear();//获取当前年份
	var tenYear=new Array();
	var dataY=new Array();
	for(var i=0;i<10;i++){
		tenYear[i]=nowdateYear-i;
		//根据dataY[i]索引从后台获取到1-10年的数据，例-从2017年开始到2008年
		for(var m=0;m<12;m++){
			//根据m索引从后台获取dataY[i]年中1-12月的数据，检索每个月的数据放置到mdata中后push到dataY[i]
			 var mdata={
				sum : 11,
				incomeSum : 22,
				paySum : 33
			};
			 if(m==0){
				 dataY[i]=[{
						sum:mdata.sum,
						incomeSum:mdata.incomeSum,
						paySum:mdata.paySum
				}];
			 }else{
				 dataY[i].push(mdata);
			 }	 
		}		
	}
	alert(dataY[0][3].incomeSum);
	var option={
		baseOption:{
			title: {text: '总费用统计表',top:'3%'},
			legend:{
				data:['利润','支出','收入'],
				top:'4%',
				left:'70%'
			},
			timeline:{
				axisType:'category',
				show:'true',
				autoPlay:false,
				data:tenYear,		//以当前年份为终点，取十年间数据
			},
			 grid: { left: '1%',right: '4%',bottom: '10%',containLabel: true },  
		     xAxis: {type: 'value'},  
		     yAxis: {
					type: 'category',
					axisTick:{show:false},
					data:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
					axisLabel:{   //文字标签添加事件
						clickable:true
					}
				},  
		     series: [  
		         {  
		             type: 'bar',  
		         },  
		     ],  
		     tooltip: {
		    	 trigger:'axis',
				 axisPointer:{
					type:'shadow'
				 }
		     }
		},
		
		options:[
	         {  
              series: [  
                 {
                    name:'利润',
                    type:'bar',
                    label: {
                        normal: {
                            show: true,
                            position: 'inside'
                        }
                    },
                    data:[200, 170, 240, 244, 200, 220, 210,240, 244, 200, 220, 210]
                 },
                 {
                    name:'收入',
                    type:'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true
                        }
                    },
                    data:[320, 302, 341, 374, 390, 450, 420,341, 374, 390, 450, 420]
                 },
                 {
                    name:'支出',
                    type:'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'left'
                        }
                    },
                    data:[-120, -132, -101, -134, -190, -230, -210,-101, -134, -190, -230, -210]
                 }
              ]  
	       },  
	       {  
             series: [  
                {
                   name:'利润',
                   type:'bar',
                   label: {
                       normal: {
                           show: true,
                           position: 'inside'
                       }
                   },
                   data:[100, 370, 540, 144, 300, 120, 310,200, 144, 400, 320, 210]
                },
                {
                   name:'收入',
                   type:'bar',
                   stack: '总量',
                   label: {
                       normal: {
                           show: true
                       }
                   },
                   data:[120, 202, 341, 474, 490, 350, 220,141, 74, 190, 250, 320]
                },
                {
                   name:'支出',
                   type:'bar',
                   stack: '总量',
                   label: {
                       normal: {
                           show: true,
                           position: 'left'
                       }
                   },
                   data:[-20, -232, -121, -234, -390, -430, -310,-201, -134, -90, -130, -210]
                }
             ]  
		   }
		]
	};
	var option2={
			title:{text: '1月费用详情图',left: '47%',top:'10%'},	
			legend: {
   				top:'90%',
                left:'60%',
                data:['治疗收入','其他收入','其他支出']
            },
			series:[
				{
		            name: '费用类型',
		            type: 'pie',
		            radius: '50%',
		            
		            tooltip:{
		    			trigger:'item',	
		    		},
		    		itemStyle:{
		    			normal:{
		    				label:{
		    					show:true,
		    					position:'outside',
		    					formatter: '{b} : {c} ({d}%)'
		    				}
		    			}
		    		},
		    		
		    		selectedOffset:'10',
		            center: ['55%', '55%'],	
		            data:[
		                  {value:500, name:'治疗收入'},
			              {value:400, name:'其他收入'},
			              {value:240, name:'其他支出'},
		            ]
		    		
		        }
			]
	};
	//指定图表的配置项和数据
	myCharts.setOption(option,true);
	myCharts2.setOption(option2,true);
	myCharts.on('click',function(params){
		if(params.value){
		   if(params.name.indexOf('月')>0){   //判断是否点击了图表的Y轴
			   var month=params.name.substring(0,params.name.length-1);
	           var option2={
	       			title:{text: month+'月费用详情图',left: '47%',top:'10%'},
	       			legend: {
	       				top:'90%',
	                    left:'60%',
	                    data:['治疗收入','其他收入','其他支出']
	                },
	       			series:[
	       				{
	       		            name: '费用类型',
	       		            type: 'pie',
	       		            radius: '50%',
	       		            tooltip:{
	       		    			trigger:'item',	
	       		    		},
	       		    		itemStyle:{
	       		    			normal:{
	       		    				label:{
	       		    					show:true,
	       		    					position:'outside',
	       		    					formatter: '{b} : {c} ({d}%)'
	       		    				}
	       		    			}
	       		    		},
	       		            center: ['55%', '55%'],	
		       		        data:[
		 		                  {value:320, name:'治疗收入'},
		 			              {value:500, name:'其他收入'},
		 			              {value:240, name:'其他支出'},
		 		            ]
	       		        }
	       			]
	       	};
	           myCharts2.setOption(option2,true);
			}   
		}
	});
	window.onresize=function(){
		resizeWorldMapContainer();
		myCharts.resize();
		myCharts2.resize();
	};
</script>
</html>