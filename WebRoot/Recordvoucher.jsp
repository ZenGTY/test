<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
@import url("${pageContext.request.contextPath }/css/indexcss.css");

-->
@media screen and (max-width:1920px) {
	body {
		font-size: 20px;
	}
	
}

@media screen and (max-width:1680px) {
	body {
		font-size: 18px;
	}
}

@media screen and (max-width:1440px) {
	body {
		font-size: 17px;
	}
}

* {
	font-family: 微软雅黑;
	margin: 0px;
	padding: 0px;
}

.incomeMain {
	width: 100%;
	height: auto;
	background: #efefef;
}

.incomeTop {
	width: 100%;
	height: auto;
	margin: 0px;
	padding: 0px;
	
}

.incomeTop ul {
	width: 100%;
	height: auto;
	list-style: none;
	margin: 0px;
	padding: 0px;
}

.incomeTop ul li {
	float: left;
	height: 60px;
	line-height: 60px; margin-left : 10px;
	margin-top: 10px;
	margin-left: 20px;
	margin-top: 10px
}

.incomeTop ul li img {
	margin-top: 10px
}
.right{  
    text-align: right!important  
}  
#table_example{
	width:90%;
	margin:0px 5%;
	
}
#table_example tr{
	height:70px;
	width:auto;
	border:1px solid #000000;
}
#table_example tr th{
	height:70px;
	width:auto;
	border:1px solid #000000;
}
#table_example tr td{
	border:1px solid #000000;
	width:12%;
	height:70px;
	line-height:70px;
}
.inputCss{
	background:transparent;
	border:0px;
	width:100%;
	height:100%;
}
.addImg{
	width:15px;
	height:15px;
	margin-left:10px;
}
.deleteImg{
	width:15px;
	height:15px;
	margin-left:10px;
}
.table_example_handleimg{
	position:absolute;
	display:none;
}
.floatleft{
	float:left;
}
.account{
	position:relative;
}
.account input{
	width:80%;
}
.accountAdd{
	position:absolute;
	display:none;
	left:80%;
	color:#0072E3;
}
.costType{
	text-align:center;
}
.total input{
	background:transparent;
	border:0px;
	color:red;
}
</style>
<!-- jQuery -->
 <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
 <link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
 <link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css">
 
</head>
<body>
	<div class="incomeMain">
		<div class="incomeTop">
			<ul>
				<li style="font-weight: bold">录凭证</li>
				<li>
					日期：<input id="dateTime" type="text">
				</li>
				<li><img src="${pageContext.request.contextPath }/images/10.png"></li>
				<li style="position:absolute;top:0px;left:0px;margin-left:45%;"><h2>记账凭证</h2></li>
			</ul>
		
		</div>

		<div>
			<table id="table_example">
				<thead>
					<tr>
						<th>摘要</th>
						<th>客戶</th>
						<th>项目名称</th>
						<th>费用类型</th>
						<th>门诊</th>
						<th>科室</th>
						<th>金额</th>
					</tr>
				</thead>
				<tbody>
					<tr class="table_example_tbodytr">
						<td class="mark">
							<input type="text" class="inputCss">						
						</td>
						<td class="layui-form">
							
						</td>
						<td class="account">
							<span class="accountAdd">添加</span>
							<input type="text" list="account_list" class="inputCss" onfocus="if(value=='项目名称不能为空或不存在'){value='',style='color:#000000'}">
						</td>
						<td class="costType"><span></span></td>
						<td class="section">
							<input type="text" list="section_for_outpatients_list" class="inputCss" onfocus="if(value=='门诊不能为空或不存在'){value='',style='color:#000000'}">
						</td>
						<td class="executive"><input type="text" list="executive_office_list" class="inputCss"></td>
						<td>
							<input type="text" class="inputCss floatleft" id="money_list_1" onchange="this.value=currency(this.value)" onfocus="if(value=='金额不能为零或空'){value='',style='color:#000000'}">
							<span class="table_example_handleimg">
								<img class="addImg"src="../images/recordvoucherImage/RecordvoucherAdd.png">
								<img class="deleteImg" src="../images/recordvoucherImage/RecordvoucherDelete.png">
							</span>
						</td>
						
					</tr>
					<tr class="table_example_tbodytr">
						<td class="mark">
							<input type="text" class="inputCss">
						</td>
						<td>
							<input type="text" list="client_list" class="inputCss">
						</td>
						<td class="account">
							<span class="accountAdd">添加</span>
							<input type="text" list="account_list" class="inputCss" onfocus="if(value=='项目名称不能为空或不存在'){value='',style='color:#000000'}">
						</td>
						<td class="costType"><span></span></td>
						<td class="section">
							<input type="text" list="section_for_outpatients_list" class="inputCss" onfocus="if(value=='门诊不能为空或不存在'){value='',style='color:#000000'}">
						</td>
						<td class="executive"><input type="text" list="executive_office_list" class="inputCss"></td>
						<td><input type="text" class="inputCss floatleft" id="money_list_2" onchange="this.value=currency(this.value)" onfocus="if(value=='金额不能为零或空'){value='',style='color:#000000'}">
							<span class="table_example_handleimg">
								<img class="addImg"src="../images/recordvoucherImage/RecordvoucherAdd.png">
								<img class="deleteImg" src="../images/recordvoucherImage/RecordvoucherDelete.png">
							</span>
						</td>
						
					</tr>
					<tr class="table_example_tbodytr">
						<td class="mark">
							<input type="text" class="inputCss">
						</td>
						<td>
							<input type="text" list="client_list" class="inputCss">
						</td>
						<td class="account">
							<span class="accountAdd">添加</span>
							<input type="text" list="account_list" class="inputCss" onfocus="if(value=='项目名称不能为空或不存在'){value='',style='color:#000000'}">
						</td>
						<td class="costType"><span></span></td>
						<td class="section">
							<input type="text" list="section_for_outpatients_list" class="inputCss" onfocus="if(value=='门诊不能为空或不存在'){value='',style='color:#000000'}">
						</td>
						<td class="executive"><input type="text" list="executive_office_list" class="inputCss"></td>
						<td><input type="text" class="inputCss floatleft" id="money_list_3" onchange="this.value=currency(this.value)" onfocus="if(value=='金额不能为零或空'){value='',style='color:#000000'}">
							<span class="table_example_handleimg">
								<img class="addImg"src="../images/recordvoucherImage/RecordvoucherAdd.png">
								<img class="deleteImg" src="../images/recordvoucherImage/RecordvoucherDelete.png">
							</span>
						</td>
						
					</tr>
					<tr class="table_example_tbodytr">
						<td class="mark">
							<input type="text" class="inputCss">
						</td>
						<td>
							<input type="text" list="client_list" class="inputCss">
						</td>
						<td class="account">
							<span class="accountAdd">添加</span>
							<input type="text" list="account_list" class="inputCss" onfocus="if(value=='项目名称不能为空或不存在'){value='',style='color:#000000'}">
						</td>
						<td class="costType"><span></span></td>
						<td class="section">
							<input type="text" list="section_for_outpatients_list" class="inputCss" onfocus="if(value=='门诊不能为空或不存在'){value='',style='color:#000000'}">
						</td>
						<td class="executive"><input type="text" list="executive_office_list" class="inputCss"></td>
						<td><input type="text" class="inputCss floatleft" id="money_list_4" onchange="this.value=currency(this.value)" onfocus="if(value=='金额不能为零或空'){value='',style='color:#000000'}">
							<span class="table_example_handleimg">
								<img class="addImg"src="../images/recordvoucherImage/RecordvoucherAdd.png">
								<img class="deleteImg" src="../images/recordvoucherImage/RecordvoucherDelete.png">
							</span>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr class="total">
						<td colspan="2">
							总收入：<input type="text" readonly="readonly" id="Recordvoucher_money_incomeSum">
						</td>
						<td colspan="2">总支出：<input type="text" readonly="readonly" id="Recordvoucher_money_paySum"></td>
						<td colspan="3">合    计：<input type="text" readonly="readonly" id="Recordvoucher_money_sum"></td>
					</tr>
				</tfoot>
			</table>
			<hr style="height:2px;border:none;border-top:2px solid #ccc;margin-top:2%" >
			<button id="recordviucherSumbit">保存并新增</button>
		</div>
	</div>
	<datalist id="account_list">
		<option>a</option>
		<option>b</option>
		<option>c</option>
		<option>d</option>
		<option>e</option>
	</datalist>
	<datalist id="section_for_outpatients_list">
		<option>qweqwe</option>
		<option>qweqwe</option>
		<option>qweqwe</option>
		<option>qweqwe</option>
		<option>qweqwe</option>
		
	</datalist>
	<datalist id="executive_office_list">
		<option>zxczxc</option>
		<option>zxczxc</option>
		<option>zxczxc</option>
		<option>zxczxc</option>
		<option>zxczxc</option>
	</datalist>
	
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
<script>
	layui.use('form', function(){
	  var form = layui.form; 
	  form.render();
	});      
	function currency(s){			//货币格式化
    	if(/[^0-9\.]/.test(s)) return "invalid value";
    	s=s.replace(/^(\d*)$/,"$1.");
   	    s=(s+"00").replace(/(\d*\.\d\d)\d*/,"$1");
    	s=s.replace(".",".");
    	var re=/(\d)(\d{3},)/;
    	while(re.test(s))
            s=s.replace(re,"$1,$2");
    		s=s.replace(/,(\d\d)$/,".$1");
    		return s.replace(/^\./,"0.");
    }
	$(document).ready(function(){
		var nowdate=new Date();
		var str =nowdate.getFullYear() + "-";
		str += (nowdate.getMonth()+1) + "-";
		str += nowdate.getDate();
		$( "#dateTime" ).datepicker({	//日历
		     changeMonth: true,
		     changeYear: true,
		     dateFormat: "yy-mm-dd" 
		});
		$( "#dateTime" ).val(str);
		$('#table_example').on('mouseenter','.table_example_tbodytr',function(){
			$(this).find('.table_example_handleimg').show();
		});
		$('#table_example').on('mouseleave','.table_example_tbodytr',function(){
			$(this).find('.table_example_handleimg').hide();
		});
		$('#table_example').on('mouseenter','.account',function(){
			$(this).find('span').show();
		});
		$('#table_example').on('mouseleave','.account',function(){
			$(this).find('span').hide();
		});
		$('#table_example').on('mouseenter','.accountAdd',function(){
			$(this).css({'color':'#00AEAE'});
		});
		$('#table_example').on('mouseleave','.accountAdd',function(){
			$(this).css({'color':'#0072E3'});
		});
		$('#table_example').on('click','.addImg',function(){   	//新增一行
			var list=$("input[id^=money_list_]");
			var newlistsize=list.length+1;
			var i1=$(this).parent().parent().parent().index();
			var insertHtml="<tr class="+"table_example_tbodytr"+"><td><input type="+"text"+" class="+"inputCss"+"></td><td class="+"account"+"><span class="+"accountAdd"+">添加</span><input type="+"text"+" list="+"account_list"+" class="+"inputCss"+" onfocus="+"if(value=='项目名称不能为空或不存在'){value='',style='color:#000000'}"+"></td><td class="+"costType"+"><span></span></td><td class="+"section"+"><input type="+"text"+" list="+"section_for_outpatients_list"+" class="+"inputCss"+" onfocus="+"if(value=='门诊不能为空或不存在'){value='',style='color:#000000'}"+"></td><td class="+"executive"+"><input type="+"text"+" list="+"executive_office_list"+" class="+"inputCss"+"></td><td><input type="+"text"+" class="+"inputCss"+" id="+"money_list_"+newlistsize+""+" onchange="+"this.value=currency(this.value)"+" style="+"float:left"+" onfocus="+"if(value=='金额不能为零或空'){value='',style='color:#000000'}"+"><span class="+"table_example_handleimg"+"><img class="+"addImg"+" src="+"../images/recordvoucherImage/RecordvoucherAdd.png"+" style="+"margin-top:50%"+"><img class="+"deleteImg"+" src="+"../images/recordvoucherImage/RecordvoucherDelete.png"+"></span></td></tr>";
			$('#table_example').find("tbody").find("tr").eq(i1).after(insertHtml);
			$('.account').on('change','input',function(){		//检测会计科目所属的费用类型
				var accoundName=$(this).val();
				var trindex=$(this).parent().parent().index();
				if(accoundName=="a"){
					$('.table_example_tbodytr').eq(trindex).find($('.costType')).find("span").text("收入");
				}else if(accoundName=="b"){
					$('.table_example_tbodytr').eq(trindex).find($('.costType')).find("span").text("支出");
				}else if(accoundName==""){
					$('.costType').find("span").text("");
				}
			});
		});
		$('#table_example').on('click','.deleteImg',function(){	//删除一行
			var i2=$(this).parent().parent().parent().index();
			$("#table_example").find("tbody").find("tr").eq(i2).remove();
		});
		$('#table_example').on('mouseleave','.table_example_tbodytr',function(){
			$(this).find('.table_example_handleimg').hide();
		});
		$("#table_example").on("input propertychange change",$('input[id^=money_list_]'),function(event){
			var list=$("input[id^=money_list_]");
			var listsize=list.length;
			var incomeSum=0;
			var paySum=0;
			var sum=0;
			for(var i4=1;i4<=listsize;i4++){
				if($("#money_list_"+i4+"").val()>0){
					var a=$("#money_list_"+i4+"").parent().parent().index();
					var b=$(".table_example_tbodytr").eq(a).find(".costType").find("span").text();
					if(b=="收入"){
						incomeSum+=parseFloat($("#money_list_"+i4+"").val());
					}else if(b=="支出"){
						paySum+=parseFloat($("#money_list_"+i4+"").val());
					}
					sum=incomeSum-paySum;
				}
			}
			sum=sum.toFixed(2);
			incomeSum=incomeSum.toFixed(2);
			paySum=paySum.toFixed(2);
	      	$("#Recordvoucher_money_incomeSum").val(incomeSum);
	      	$("#Recordvoucher_money_paySum").val(paySum);
	      	$("#Recordvoucher_money_sum").val(sum);
		});
		$('#table_example').on('click','.accountAdd',function(){   //新增项目名称
			layer.open({
				  type: 2,
				  title: '新增科目',
				  scrollbar: false,
				  area: ['500px', '90%'],
				  btn:["保存","取消"],
				  yes:function(layero,index){
					  var iframeWin=window[index.find('iframe')[0]['name']];
					  iframeWin.submit();	//接收form表提交后返回结果，1为提交成功，2为提交失败
					 
				  },btn2: function(index, layero){
					    
				  },
				  content: '${pageContext.request.contextPath}/view/ProjectAdd.jsp' //iframe的url
				});
		});
		$('.account').on('change','input',function(){		//检测会计科目所属的费用类型
			var accoundName=$(this).val();
			var trindex=$(this).parent().parent().index();
			if(accoundName=="a"){
				$('.table_example_tbodytr').eq(trindex).find($('.costType')).find("span").text("收入");
			}else if(accoundName=="b"){
				$('.table_example_tbodytr').eq(trindex).find($('.costType')).find("span").text("支出");
			}else{
				$('.table_example_tbodytr').eq(trindex).find($('.costType')).find("span").text("");
			}
		});
		//提交Recordvoucher表单验证，查看项目名称是否存在，查看门诊是否存在，查看科室是否存在，
		//金额、项目名称、门诊必须同时有值。
		$('#recordviucherSumbit').click(function(){		//提交表单
			var list=$('input[id^=money_list_]');
			var listsize=list.length;
			var e=0;
			var f=0;
			for(var i=1;i<=listsize;i++){
				var a=$("#money_list_"+i+"");
				var b=$('.table_example_tbodytr').eq(i-1).find('.account').find('input');		//获取项目名称框的值
				var b2=$.trim(b.val());
				var c=$('.table_example_tbodytr').eq(i-1).find('.section').find('input');		//获取门诊框的值
				var c2=$.trim(c.val());
				var d=$('.table_example_tbodytr').eq(i-1).find('.executive').find('input');   //获取科室框的值
				var d2=$.trim(d.val());
				var mark=$('.table_example_tbodytr').eq(i-1).find('.mark').find('input');		//获取摘要框的值
				var mark2=$.trim(mark.val());
				if(a.val()!="" && a.val()!=0 && a.val()!="invalid value"){
					e+=1;
					if(b2!=""){	//金额框有数值时判断项目名称和门诊是否为空
						//项目名称有值时判断名称是否存在
						//......
						if(c2!=""){
							//门诊有值时判断门诊是否存在
							//......
							//科室有值时判断科室是否存在
							//......
						}else{
							f+=1;
							e=0;
						}	
					}else{
						f+=1;
						e=0;
					}
				}else if(b2!=""){	//项目名称框有数值时判断门诊和金额是否为空
					e+=1;
					//项目名称有值时判断名称是否存在
					//......
					if(c2!=""){
						//门诊有值时判断门诊是否存在
						//......
						//科室有值时判断科室是否存在
						//......
						if(a.val()!="" && a.val()!=0 && a.val()!="invalid value"){
						
						}else{
							f+=1;
							e=0;
						}
					}else{
						f+=1;
						e=0;
					}	
				}else if(c2!=""){	  //门诊有数值时判断项目名称和金额是否为空
					e+=1;
					//门诊有值时判断门诊是否存在
					//......
					//科室有值时判断科室是否存在
					//......
					if(b2!=""){
						//项目名称有值时判断名称是否存在
						//......
						if(a.val()!="" && a.val()!=0 && a.val()!="invalid value"){
							
						}else{
							f+=1;
							e=0;
						}
					}else{
						f+=1;
						e=0;
					}
				}else if(mark2!=""){
					if(b2!=""){	//项目名称框有数值时判断门诊和金额是否为空
						e+=1;
						//项目名称有值时判断名称是否存在
						//......
						if(c2!=""){
							//门诊有值时判断门诊是否存在
							//......
							//科室有值时判断科室是否存在
							//......
							if(a.val()!="" && a.val()!=0 && a.val()!="invalid value" && a.val()!="金额不能为零或空"){
							
							}else{
								f+=1;
								e=0;
							}
						}else{
							f+=1;
							e=0;
						}	
					}else{
						f+=1;
						e=0;
					}
				}else if(d2!=""){
					if(b2!=""){	//项目名称框有数值时判断门诊和金额是否为空
						e+=1;
						//项目名称有值时判断名称是否存在
						//......
						if(c2!=""){
							//门诊有值时判断门诊是否存在
							//......
							//科室有值时判断科室是否存在
							//......
							if(a.val()!="" && a.val()!=0 && a.val()!="invalid value"){
							
							}else{
								f+=1;
								e=0;
							}
						}else{
							f+=1;
							e=0;
						}	
					}else{
						f+=1;
						e=0;
					}
				}
				
			}
			if(e==0){
				layer.msg("请输入必要的信息（金额、项目名称、门诊）");
				f+=1;
			}
			if(f==0){				//确认提交
				var data=new Array();
				var dataindex=0;
				for(var i=1;i<=listsize;i++){
					if($('.table_example_tbodytr').eq(i-1).find('.account').find('input').val()!=""){	
						var submitTime=$('#dateTime').val();
						var markText=$.trim($('.table_example_tbodytr').eq(i-1).find('.mark').find('input').val());
						var projectName=$('.table_example_tbodytr').eq(i-1).find('.account').find('input').val();
						var costType=$('.table_example_tbodytr').eq(i-1).find('.costType').find('span').text();
						var sectionName=$('.table_example_tbodytr').eq(i-1).find('.section').find('input').val();
						var executiveName=$('.table_example_tbodytr').eq(i-1).find('.executive').find('input').val();
						var money=$("#money_list_"+i+"").val();
						var incomeSum=$("#Recordvoucher_money_incomeSum").val();
						var paySum=$("#Recordvoucher_money_paySum").val();
						var Sum=$("#Recordvoucher_money_sum").val();
						data[dataindex]={
							markText : markText,
							projectId : projectName,
							costType : costType,
							clinicId : sectionName,
							departmentId : executiveName,
							price : money,
						};
						dataindex+=1;
						layer.msg("提交");
					}
				}
				var msg = {
					projects : data,
					incomeSum : incomeSum,
					paySum : paySum,
					sum : Sum,
					submitTime : submitTime,
					status : 0,
					
				};
				console.log(JSON.stringify(msg));
				$.ajax({
					"data" : msg,
					"url" : "",
					"type": "POST",
					"success": function(result){
						return result;
					}
				});
			}	
		});
	});
</script>

</html>