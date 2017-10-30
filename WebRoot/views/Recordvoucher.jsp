<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>		<!-- 记账表 -->
<style>
@import url("${pageContext.request.contextPath }/resources/css/indexcss.css");

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

.incomeTop table{
	margin:30px 0px 30px 5%;
}

.right{  
    text-align: right!important  
}  

#table_example{
	width:90%;
	margin:0px 5%;
	
}
#table_example tr{
	height:80px;
	width:auto;
	border:1px solid #000000;
}
#table_example tr th{
	height:80px;
	width:auto;
	border:1px solid #000000;
}
#table_example tr td{
	border:1px solid #000000;
	width:12%;
	height:80px;
	line-height:80px;
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
.account div{
	position:relative;
}
.accountAdd{
	color:#0072E3;
	cursor:pointer;
	position:relative;
	left:10%;
}
.client div{
	position:relative;
}
.clientAdd{
	color:#0072E3;
	cursor:pointer;
	position:relative;
	left:10%
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
 <link rel="stylesheet" href="${pageContext.request.contextPath }/lib/layui/css/layui.css">

</head>
<body>
	<div class="incomeMain">
		<div class="incomeTop">
			<table id="recordvoucherTable">
				<tr>
					<td>日期：<input id="dateTime" type="text"></td>
					<td class="layui-form section"> 
					    <label class="layui-form-label">门诊:</label>  
				          <div class="layui-input-block" style="width: 120px">  
				              <select name="city" lay-search>  
				                  <option value=""></option>  
				                  <option value="0">北京</option>  
				                  <option value="1">上海</option>  
				                  <option value="2">广州</option>  
				                  <option value="3">深圳</option>  
				                  <option value="4">杭州</option>  
				              </select>  
				          </div>     
					</td>
					<td class="layui-form executive"> 
					    <label class="layui-form-label">科室:</label>  
				          <div class="layui-input-block" style="width: 120px">  
				              <select name="city" lay-verify="required" lay-search>  
				                  <option value=""></option>  
				                  <option value="0">北京</option>  
				                  <option value="1">上海</option>  
				                  <option value="2">广州</option>  
				                  <option value="3">深圳</option>  
				                  <option value="4">杭州</option>  
				              </select>  
				          </div>     
					</td>
				</tr>
			</table>
		</div>

		<div class="layui-form">
			<table id="table_example">
				<thead>
					<tr>
						<th>摘要</th>
						<th>客戶 <span class="clientAdd">添加</span></th>
						<th>项目名称 <span class="accountAdd">添加</span></th>
						<th>费用类型</th>
						<th>金额</th>
					</tr>
				</thead>
				<tbody>
					<tr class="table_example_tbodytr">
						<td class="mark">
							<input type="text" class="inputCss">						
						</td>
						<td class="layui-form-item">	
				 			<div class="layui-input-inline">
			       				<select name="client" lay-search="">
			       					<option value=""></option>
			       					<option value="0">客户A</option>
			       					<option value="1">客户B</option>
			       				</select>
			     			</div>
		 				</td>
						<td class="layui-form-item">	
				 			<div class="layui-input-inline">
			       				<select name="account" lay-search="" lay-filter="test">
			       					<option value=""></option>
			       					<option value="0">项目A</option>
			       					<option value="1">项目B</option>
			       				</select>
			     			</div>
		 				</td>
						<td class="costType"><span></span></td>
						<td>
							<input type="text" class="inputCss floatleft" id="money_list_1" onchange="this.value=currency(this.value)">
							<span class="table_example_handleimg">
								<img class="addImg" src="${pageContext.request.contextPath }/resources/img/recordvoucherImage/RecordvoucherAdd.png">
								<img class="deleteImg" src="${pageContext.request.contextPath }/resources/img/recordvoucherImage/RecordvoucherDelete.png">
							</span>
						</td>
						
					</tr>
					<tr class="table_example_tbodytr">
						<td class="mark">
							<input type="text" class="inputCss">
						</td>
						<td class="layui-form-item">	
				 			<div class="layui-input-inline">
			       				<select name="client" lay-search="">
			       					<option value=""></option>
			       					<option value="0">客户A</option>
			       					<option value="1">客户B</option>
			       				</select>
			     			</div>
		 				</td>
						<td class="layui-form-item">	
				 			<div class="layui-input-inline">
			       				<select name="account" lay-search="" lay-filter="test">
			       					<option value=""></option>
			       					<option value="0">项目A</option>
			       					<option value="1">项目B</option>
			       				</select>
			     			</div>
		 				</td>
						<td class="costType"><span></span></td>
						<td><input type="text" class="inputCss floatleft" id="money_list_2" onchange="this.value=currency(this.value)" onfocus="if(value=='金额不能为零或空'){value='',style='color:#000000'}">
							<span class="table_example_handleimg">
								<img class="addImg" src="${pageContext.request.contextPath }/resources/img/recordvoucherImage/RecordvoucherAdd.png">
								<img class="deleteImg" src="${pageContext.request.contextPath }/resources/img/recordvoucherImage/RecordvoucherDelete.png">
							</span>
						</td>
						
					</tr>
					<tr class="table_example_tbodytr">
						<td class="mark">
							<input type="text" class="inputCss">
						</td>
						<td class="layui-form-item">	
				 			<div class="layui-input-inline">
			       				<select name="client" lay-search="">
			       					<option value=""></option>
			       					<option value="0">客户A</option>
			       					<option value="1">客户B</option>
			       				</select>
			     			</div>
		 				</td>
						<td class="layui-form-item">	
				 			<div class="layui-input-inline">
			       				<select name="account" lay-search="" lay-filter="test">
			       					<option value=""></option>
			       					<option value="0">项目A</option>
			       					<option value="1">项目B</option>
			       				</select>
			     			</div>
		 				</td>
						<td class="costType"><span></span></td>
						<td><input type="text" class="inputCss floatleft" id="money_list_3" onchange="this.value=currency(this.value)">
							<span class="table_example_handleimg">
								<img class="addImg" src="${pageContext.request.contextPath }/resources/img/recordvoucherImage/RecordvoucherAdd.png">
								<img class="deleteImg" src="${pageContext.request.contextPath }/resources/img/recordvoucherImage/RecordvoucherDelete.png">
							</span>
						</td>
						
					</tr>
					<tr class="table_example_tbodytr">
						<td class="mark">
							<input type="text" class="inputCss">
						</td>
						<td class="layui-form-item">	
				 			<div class="layui-input-inline">
			       				<select name="client" lay-search="">
			       					<option value=""></option>
			       					<option value="0">客户A</option>
			       					<option value="1">客户B</option>
			       				</select>
			     			</div>
		 				</td>
						<td class="layui-form-item">	
				 			<div class="layui-input-inline">
			       				<select name="account" lay-search="" lay-filter="test">
			       					<option value=""></option>
			       					<option value="0">项目A</option>
			       					<option value="1">项目B</option>
			       				</select>
			     			</div>
		 				</td>
						<td class="costType"><span></span></td>
						<td><input type="text" class="inputCss floatleft" id="money_list_4" onchange="this.value=currency(this.value)">
							<span class="table_example_handleimg">
								<img class="addImg" src="${pageContext.request.contextPath }/resources/img/recordvoucherImage/RecordvoucherAdd.png">
								<img class="deleteImg" src="${pageContext.request.contextPath }/resources/img/recordvoucherImage/RecordvoucherDelete.png">
							</span>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr class="total">
						<td>
							总收入：<input type="text" readonly="readonly" id="Recordvoucher_money_incomeSum">
						</td>
						<td>总支出：<input type="text" readonly="readonly" id="Recordvoucher_money_paySum"></td>
						<td colspan="3">合    计：<input type="text" readonly="readonly" id="Recordvoucher_money_sum"></td>
					</tr>
				</tfoot>
			</table>
			<hr style="height:2px;border:none;border-top:2px solid #ccc;margin-top:2%" >
			<button id="recordviucherSumbit">保存并新增</button>
		</div>
	</div>
	
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath }/lib/layer/layer.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
<script>   
	layui.use('form',function(){
		var form=layui.form;
		form.on('select(test)',function(data){  //检测项目所属的费用类型
			var trindex=(data.othis).parent().parent().parent().index();
			if(data.value==0){
				$('.table_example_tbodytr').eq(trindex).find($('.costType')).find("span").text("收入");
			}else if(data.value==1){
				$('.table_example_tbodytr').eq(trindex).find($('.costType')).find("span").text("支出");
			}else{
				$('.table_example_tbodytr').eq(trindex).find($('.costType')).find("span").text("");
			}
		});
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
		$('#table_example').on('mouseenter','.accountAdd',function(){
			$(this).css({'color':'#00AEAE'});
		});
		$('#table_example').on('mouseleave','.accountAdd',function(){
			$(this).css({'color':'#0072E3'});
		});
		$('#table_example').on('mouseenter','.clientAdd',function(){
			$(this).css({'color':'#00AEAE'});
		});
		$('#table_example').on('mouseleave','.clientAdd',function(){
			$(this).css({'color':'#0072E3'});
		});
		$('#table_example').on('click','.addImg',function(){   	//新增一行
			var list=$("input[id^=money_list_]");
			var newlistsize=list.length+1;
			var i1=$(this).parent().parent().parent().index();
			var insertHtml="<tr class="+"table_example_tbodytr"+"><td class="+"mark"+"><input type="+"text"+" class="+"inputCss"+"></td><td class="+"layui-form-item"+"><div class="+"layui-input-inline"+"><select name="+"marriage"+" lay-search="+""+"><option value="+""+"></option><option value="+"0"+">客户A</option><option value="+"1"+">客户B</option></select></div></td><td class="+"layui-form-item"+"><div class="+"layui-input-inline"+"><select lay-filter="+"test"+" name="+"marriage"+" lay-search="+""+"><option value="+""+"></option><option value="+"0"+">项目A</option><option value="+"1"+">项目B</option></select></div></td><td class="+"costType"+"><span></span></td><td><input type="+"text"+" class="+"inputCss"+" style="+"float:left"+" id="+"money_list_"+newlistsize+""+" onchange="+"this.value=currency(this.value)"+"><span class="+"table_example_handleimg"+" style="+"margin-top:2%"+"><img class="+"addImg"+" src="+"${pageContext.request.contextPath }/resources/img/recordvoucherImage/RecordvoucherAdd.png"+"><img class="+"deleteImg"+" src="+"${pageContext.request.contextPath }/resources/img/recordvoucherImage/RecordvoucherDelete.png"+"></span></td></tr>";
			$('#table_example').find("tbody").find("tr").eq(i1).after(insertHtml);
			layui.use('form',function(){			//新增一行后对事件进行重新绑定
				var form=layui.form;
				form.on('select(test)',function(data){
					var trindex=(data.othis).parent().parent().parent().index();
					if(data.value==0){
						$('.table_example_tbodytr').eq(trindex).find($('.costType')).find("span").text("收入");
					}else if(data.value==1){
						$('.table_example_tbodytr').eq(trindex).find($('.costType')).find("span").text("支出");
					}else{
						$('.table_example_tbodytr').eq(trindex).find($('.costType')).find("span").text("");
					}
				});
				form.render();
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
				  area: ['40%', '90%'],
				  btn:["保存","取消"],
				  yes:function(layero,index){
					  var iframeWin=window[index.find('iframe')[0]['name']];
					  iframeWin.submit();	//接收form表提交后返回结果，1为提交成功，2为提交失败
					 
				  },btn2: function(index, layero){
					    
				  },
				  content: '${pageContext.request.contextPath}/view/ProjectAdd.jsp' //iframe的url
				});
		});
		$('#table_example').on('click','.clientAdd',function(){   //新增项目名称
			layer.open({
				  type: 2,
				  title: '新增客户',
				  scrollbar: false,
				  area: ['40%', '90%'],
				  btn:["添加","取消"],
				  yes:function(layero,index){
					  var iframeWin=window[index.find('iframe')[0]['name']];
					  iframeWin.submit();	//接收form表提交后返回结果，1为提交成功，2为提交失败
					 
				  },btn2: function(index, layero){
					    
				  },
				  content: '${pageContext.request.contextPath}/view/ClientAdd.jsp' //iframe的url
				});
		});
		//提交Recordvoucher表单验证，查看项目名称是否存在，查看门诊是否存在，查看科室是否存在，
		//金额、项目名称、门诊必须有值。
		$('#recordviucherSumbit').click(function(){		//提交表单
			var list=$('input[id^=money_list_]');
			var listsize=list.length;
			var e=0;
			var ok=0;
			var no=0;
			var c=$('.section').find('select').val();	//获取门诊的值
			var d=$('.executive').find('select').val();	//获取科室的值
			for(var i=1;i<=listsize;i++){
				var a=$("#money_list_"+i+"").val();
				var index=$("#money_list_"+i+"").parent().parent().index();
				var b=$('.table_example_tbodytr').eq(index).find('select[name="account"]').val();		//获取项目名称框的值
				var clientid=$('.table_example_tbodytr').eq(index).find('select[name="client"]').val(); //获取客户框的值
				var mark=$.trim($('.table_example_tbodytr').eq(index).find('.mark').find('input').val());//获取摘要框的值		
				if((a!="" && a!=0 && a!="invalid value") || b!="" || mark!="" || clientid!=""){  //判断行是否有值
					if((a!="" && a!=0 && a!="invalid value") && b!="" && c!="" && clientid!=""){
						e+=1;
						ok=1;
					}else{
						layer.msg("请输入必要的信息（金额、项目名称、门诊）");
						return;
					}
				}
			}
			if(e==0){
				layer.msg("请输入必要的信息（金额、项目名称、门诊）");
			}
			if(ok==1 && no==0){
				tijiao(listsize);
			}
		});
		function tijiao(listsize){
			var data=new Array();
			var dataindex=0;
			layer.msg("提交");
			for(var i=1;i<=listsize;i++){
				var index=$("#money_list_"+i+"").parent().parent().index();
				if($("#money_list_"+i+"").val()!=""){	
					var submitTime=$('#dateTime').val();
					var clientId=$('.table_example_tbodytr').eq(index).find('select[name="client"]').val();
					var markText=$.trim($('.table_example_tbodytr').eq(index).find('.mark').find('input').val());
					var projectName=$('.table_example_tbodytr').eq(index).find('select[name="account"]').val();
					var costType=$('.table_example_tbodytr').eq(index).find('.costType').find('span').text();
					var sectionName=$('.section').find('select').val();
					var executiveName=$('.executive').find('select').val();
					var money=$("#money_list_"+i+"").val();
					var incomeSum=$("#Recordvoucher_money_incomeSum").val();
					var paySum=$("#Recordvoucher_money_paySum").val();
					var Sum=$("#Recordvoucher_money_sum").val();
					data[dataindex]={
						clientId : clientId,
						markText : markText,
						projectId : projectName,
						costType : costType,
						clinicId : sectionName,
						departmentId : executiveName,
						price : money,
					};
					dataindex+=1;
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
</script>

</html>