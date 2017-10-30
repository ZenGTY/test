<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>    <!-- 新增客户 -->
<style>
	body{
		height:600px;
		weight:500px;
	}
	#clientAdd_table{
		margin:auto auto;
		width:80%;
		height:100%;
	}
	#clientAdd_table tr{
		margin-top:50px;
	}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath }/lib/layui/css/layui.css">
</head>
<body>
	<table class="layui-form" id="clientAdd_table">
		 <tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">用户名称</label>
	 			<div class="layui-input-inline">
	 				<input type="text" name="name" lay-verify="required" autocomplete="off" placeholder="请输入名称" class="layui-input">
	 			</div>
		 	</td>
		 </tr>
		  <tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">身份证</label>
	 			<div class="layui-input-block">
	 				<input type="text" name="identity" lay-verify="identity" placeholder="" autocomplete="off" class="layui-input">
	 			</div>
		 	</td>
		 </tr>
		 <tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">出生日期</label>
	 			<div class="layui-input-inline">
       				<input type="text" name="age" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
     			</div>
		 	</td>
		 </tr>
		 <tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">性别</label>
	 			<div class="layui-input-inline">
       				<select name="sex">
       					<option value="0">男</option>
       					<option value="1">女</option>
       				</select>
     			</div>
		 	</td>
		 </tr>
		 <tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">联系电话</label>
	 			<div class="layui-input-inline">
       				<input type="tel" name="phone" lay-verify="phone" autocomplete="off" class="layui-input">
     			</div>
		 	</td>
		 </tr>
		 <tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">住址</label>
	 			<div class="layui-input-block">
	 				<input type="text" name="address"  lay-verify="required" placeholder="省/市/县" autocomplete="off" class="layui-input">
	 			</div>
		 	</td>
		 </tr>
		<tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">民族</label>
	 			<div class="layui-input-inline">
	 				<input type="text" name="nation" lay-verify="required" autocomplete="off" class="layui-input">
	 			</div>
		 	</td>
		 </tr>
		  <tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">婚况</label>
	 			<div class="layui-input-inline">
       				<select name="marriage">
       					<option value="0">未婚</option>
       					<option value="1">已婚</option>
       				</select>
     			</div>
		 	</td>
		 </tr>
		 <tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">职业</label>
	 			<div class="layui-input-inline">
       				<input type="text" name="occupation" class="layui-input">
     			</div>
		 	</td>
		 </tr>
		 <tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">所属公司</label>
	 			<div class="layui-input-inline">
       				<input type="text" name="company" class="layui-input">
     			</div>
		 	</td>
		 </tr>
		 <tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">客户类型</label>
	 			<div class="layui-input-inline">
       				<select name="status">
       					<option value="0">用户</option>
       					<option value="1">会员用户</option>
       					<option value="2">超级会员用户</option>
       					<option value="-1">黑名单用户</option>
       				</select>
     			</div>
		 	</td>
		 </tr>
		 <tr style="display:none"><td><input id="clientAddSubmit" type="button" lay-submit lay-filter="*"></td></tr>
	</table>
</body>
<script type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/lib/layer/layer.js"></script>
<script src="${pageContext.request.contextPath }/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
	layui.use(['form','layedit','laydate'],function(){
		var form=layui.form,
		layer=layui.layer,
		layedit=layui.layedit,
		laydate=layui.laydate;
		laydate.render({
			elem:'#date'
		});
		form.on('submit(*)',function(data){
			var name=$("input[name='name']").val();
			var identity=$("input[name='identity']").val();
			var age=$("input[name='age']").val();
			var sex=$("select[name='sex']").val();
			var phone=$("input[name='phone']").val();
			var address=$("input[name='address']").val();
			var nation=$("input[name='nation']").val();
			var marriage=$("input[name='marriage']").val();
			var occupation=$("input[name='occupation']").val();
			var company=$("input[name='company']").val();
			var status=$("select[name='status']").val();
			var data={
				name : name,
				identity : identity,
				age : age,
				sex : sex,
				phone : phone,
				address : address,
				nation : nation,
				marriage : marriage,
				occupation : occupation,
				company : company,
				status : status
			};
			console.log(JSON.stringify(data));
			$.ajax({
				"data" : data,
				"url" : "",
				"type" : "POST",
				"success" : function(result){
					return result;
				}
			});
		});
		form.render();
	});
	function submit(){   
		$('#clientAddSubmit').click();
	}
</script>
</html>