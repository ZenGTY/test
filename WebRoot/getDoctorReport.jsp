<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'test2.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1>getDoctorReport</h1>
	<div class="mt-20">
		<table class="">
			<thead>
				<tr class="">
					<th width="200">employeeId</th>
					<th width="200">employeeName</th>
					<th width="200">sumNumber</th>
					<th width="200">sumPrice</th>
					<th id="th_operator" width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.rowInfos}" var="rowInfos">
					<tr>
						<td><c:out value="${rowInfos.employeeId}"></c:out></td>
						<td><c:out value="${rowInfos.employeeName}"></c:out></td>
						<td><c:out value="${rowInfos.sumNumber}"></c:out></td>
						<td><c:out value="${rowInfos.sumPrice}"></c:out></td>
						<td class=""><a title="编辑" onclick="edit(this)"></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:forEach items="${requestScope.sumInfo}" var="sumInfo" varStatus="status">
         ${sumInfo}<br />
	</c:forEach>
</body>
</html>
