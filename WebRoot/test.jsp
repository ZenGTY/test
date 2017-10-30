<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.btn {
	width: 220px;
	display: inline-block;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	font: 14px/100% Arial, Helvetica, sans-serif;
	padding: .5em 2em .55em;
	text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
	-webkit-border-radius: .5em;
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	color: #fef4e9;
	border: solid 1px #da7c0c;
	background: #f78d1d;
}
</style>
<%
	int[] testList = {1, 2, 3, 4};
%>
<script type="text/javascript">
	
</script>
</head>
<body>

	<div id="div_1"></div>
	<label>添加费用项目单据： </label>
	<button class="btn" onclick="addFundBill()">addFundBill</button>
	<br />
	<br />

	<label>添加治疗项目单据： </label>
	<button class="btn" onclick="addTreatmentBill()">addTreatmentBill</button>
	<br />
	<br />

	<label> 获取执行者 报 表： </label>
	<button class="btn" onclick="getWorkerReportRank1()">getWorkerReportRank1</button>
	<label> </label>
	<button class="btn" onclick="getWorkerReportRank2()">getWorkerReportRank2</button>
	<label> </label>
	<button class="btn" onclick="getWorkerReportRank3()">getWorkerReportRank3</button>
	<br />
	<br />

	<label>获取医生开单报表： </label>
	<button class="btn" onclick="getDoctorReportRank1()">getDoctorReportRank1</button>
	<label> </label>
	<button class="btn" onclick="getDoctorReportRank2()">getDoctorReportRank2</button>
	<label> </label>
	<button class="btn" onclick="getDoctorReportRank3()">getDoctorReportRank3</button>
	<br />
	<br />

	<label>获取治疗项目报表： </label>
	<button class="btn" onclick="getProjectReportRank1()">getProjectReportRank1</button>
	<label> </label>
	<button class="btn" onclick="getProjectReportRank2()">getProjectReportRank2</button>
	<label> </label>
	<button class="btn" onclick="getProjectReportRank3()">getProjectReportRank3</button>
	<br />
	<br />

	<label>获取科室统计报表： </label>
	<button class="btn" onclick="getDepartmentReport()">getDepartmentReport</button>
	<br />
	<br />
	
	<label>获取门诊统计报表： </label>
	<button class="btn" onclick="getClinicReport()">getClinicReport</button>
	<br />
	<br />

</body>
<script type="text/javascript" src="./lib/jquery-1.10.2/jquery.min.js"></script>
<script>
	function getClinicReport() {
		var paramInfo = {
				clinicId : 1,
				startTime : "2000-01-01",
				endTime : "2017-11-25",
			};
		$.ajax({
			data : paramInfo,
			url : "./reportController/getClinicReport",
			type : "POST",
			success : function(response) {
				console.log(response);
				$("#div_1").html(response);
			}
		});
	}

	function getDepartmentReport() {
		var paramInfo = {
			departmentId : 1,
			startTime : "2000-01-01",
			endTime : "2017-11-25",
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./reportController/getDepartmentReport",
			type : "POST",
			success : function(response) {
				console.log(response);
				$("#div_1").html(response);
			}
		});
	}

	function getProjectReportRank3() {
		var paramInfo = {
			rank : 3,
			departmentId : 3,
			clinicId : 2,
			startTime : "2000-01-01",
			endTime : "2017-11-25",
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./reportController/getProjectReport",
			type : "POST",
			success : function(response) {
				console.log(response);
				$("#div_1").html(response);
			}
		});
	};

	function getProjectReportRank2() {
		var paramInfo = {
			rank : 2,
			departmentId : 3,
			clinicId : 2,
			startTime : "2000-01-01",
			endTime : "2017-11-25",
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./reportController/getProjectReport",
			type : "POST",
			success : function(response) {
				console.log(response);
				$("#div_1").html(response);
			}
		});
	};

	function getProjectReportRank1() {
		var paramInfo = {
			rank : 1,
			departmentId : 1,
			clinicId : 1,
			startTime : "2000-01-01",
			endTime : "2017-11-25",
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./reportController/getProjectReport",
			type : "POST",
			success : function(response) {
				console.log(response);
				$("#div_1").html(response);
			}
		});
	};

	function getDoctorReportRank3() {
		var paramInfo = {
			rank : 3,
			departmentId : 1,
			clinicId : 1,
			startTime : "2000-01-01",
			endTime : "2017-11-25",
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./reportController/getDoctorReport",
			type : "POST",
			success : function(response) {
				console.log(response);
				console.log(JSON.parse(response.result));
			}
		});
	};

	function getDoctorReportRank2() {
		var paramInfo = {
			rank : 2,
			departmentId : 1,
			clinicId : 1,
			startTime : "2000-01-01",
			endTime : "2017-11-25",
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./reportController/getDoctorReport",
			type : "POST",
			success : function(response) {
				console.log(response);
				console.log(JSON.parse(response.result));
			}
		});
	};

	function getDoctorReportRank1() {
		var paramInfo = {
			rank : 1,
			departmentId : 1,
			clinicId : 1,
			startTime : "2000-01-01",
			endTime : "2017-11-25",
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./reportController/getDoctorReport",
			type : "POST",
			success : function(response) {
				console.log(response);
				console.log(JSON.parse(response.result));
			}
		});
	};

	function getWorkerReportRank3() {
		var paramInfo = {
			rank : 3,
			departmentId : 3,
			clinicId : 3,
			startTime : "2000-01-01",
			endTime : "2017-11-25",
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./reportController/getWorkerReport",
			type : "POST",
			success : function(response) {
				console.log(response);
				console.log(JSON.parse(response.result));
			}
		});
	}

	function getWorkerReportRank2() {
		var paramInfo = {
			rank : 2,
			departmentId : 3,
			clinicId : 3,
			startTime : "2000-01-01",
			endTime : "2017-11-25",
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./reportController/getWorkerReport",
			type : "POST",
			success : function(response) {
				console.log(response);
				console.log(JSON.parse(response.result));
			}
		});
	}

	function getWorkerReportRank1() {
		var paramInfo = {
			rank : 1,
			departmentId : 2,
			clinicId : 2,
			startTime : "2000-01-01",
			endTime : "2017-11-25",
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./reportController/getWorkerReport",
			type : "POST",
			success : function(response) {
				console.log(response);
				console.log(JSON.parse(response.result));
			}
		});
	}

	function addTreatmentBill() {
		var paramInfo = {
			clientId : 1,
			status : 0,
			sum : 1000,
			projects : "[{projectId : 1,number : 10,deadline : \"2017-12-10 10:10:10\",extroInfo : \"额外信息\"}"
					+ ",{projectId : 5,number : 30,deadline : \"2017-12-10 10:10:12\",extroInfo : \"额外信息2\"}]",
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./billController/addTreatmentBill",
			type : "POST",
			success : function(response) {
				console.log(response);
			}
		});
	}

	function addFundBill() {
		var projects = [ {
			markText : "收费收入项目摘要一",
			projectId : 7,
			costType : 0,
			price : 400
		}, {
			markText : "收费支出项目摘要二",
			projectId : 8,
			costType : 1,
			price : 300
		} ];
		var paramInfo = {
			clientId : 1,
			clinicId : 1,
			departmentId : 1,
			status : 0,
			sum : 100,
			incomeSum : 400,
			paySum : 300,
			submitTime : "2017-10-20",
			projects : JSON.stringify(projects),
		};
		console.log("参数");
		console.log(paramInfo);
		$.ajax({
			data : paramInfo,
			url : "./billController/addFundBill",
			type : "POST",
			success : function(response) {
				console.log(response);
			}
		});
	}
</script>
</html>