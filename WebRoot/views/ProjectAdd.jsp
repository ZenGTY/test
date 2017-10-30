<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>    <!-- 新增项目 -->
<style>
	body{
		height:550px;
		weight:300px;
	}
	#ProjectAdd_table{
		width:100%;
		height:100%;
	}
	#ProjectAdd_table tr{
		height:50px;
		line-height:50px;
	}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath }/lib/layui/css/layui.css">
</head>
<body>
	<table class="layui-form" id="ProjectAdd_table">
		<tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">项目名称</label>
	 			<div class="layui-input-inline">
	 				<input type="text" name="name" lay-verify="required" autocomplete="off" placeholder="请输入项目名称" class="layui-input">
	 			</div>
		 	</td>
		</tr>
		<tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">费用类型</label>
	 			<div class="layui-input-inline">
      				<select name="type">
      					<option value="0">收入</option>
      					<option value="1">支出</option>
      				</select>
    			</div>
		 	</td>
	   </tr>
		<tr>
		 	<td class="layui-form-item">
	 			<label class="layui-form-label">是否启用</label>
	 			<div class="layui-input-inline">
     				<select name="status">
     					<option value="0">启用</option>
     					<option value="1">禁用</option>
     				</select>
	   			</div>
		 	</td>
	   </tr>
		<tr>
			<td	class="layui-form-item layui-form-text">
				<label class="layui-form-label">项目介绍</label>
				<div class="layui-input-block">
					<textarea name="introduction" placeholder="请输入内容" class="layui-textarea"></textarea>
				</div>
			</td>
		</tr>
		<tr style="display:none"><td><input id="projectAddSubmit" type="button" lay-submit lay-filter="*"></td></tr>
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
		layedit=layui.layedit;
		form.on('submit(*)',function(data){
			var name=$("input[name='name']").val();
			var type=$("select[name='type']").val();
			var status=$("select[name='status']").val();
			var introduction=$("textarea[name='introduction']").val();
			var data={
				name : name,
				type : type,
				status : status,
				introduction : introduction,
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
		$("#projectAddSubmit").click();
	}
</script>
</html>