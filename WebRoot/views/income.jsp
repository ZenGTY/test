<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	height: 50px;
	line-height: 50px; margin-left : 10px;
	margin-top: 10px;
	margin-left: 10px;
	margin-top: 10px
}

.incomeTop ul li img {
	margin-top: 10px
}
.right{  
    text-align: right!important  
}  
</style>

<!--第一步：引入Javascript / CSS （CDN）-->
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">




</head>
<body>
	<div class="incomeMain">
		<div class="incomeTop">
			<ul>
				<li style="font-weight: bold;">利润表</li>
				<li><select>
						<option selected="selected">月报</option>
						<option>季报</option>
				</select></li>
				<li><select>
						<option>2017年1期</option>
						<option selected="selected">2017年2期</option>
						<option>2017年3期</option>
						<option>2017年4期</option>
						<option>2017年5期</option>
						<option>2017年6期</option>
						<option>2017年7期</option>
				</select></li>
				<li><img
					src="${pageContext.request.contextPath }/resources/img/10.png"></li>
				<li>打印</li>
				<li>导出</li>
				<li>报税</li>
			</ul>
		</div>
		<div>
			<table id="table_id_example" class="display">
				<thead>
					<tr>
						<th>name</th>
						<th>position</th>
						<th>salary</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>阿斯顿</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
					<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery.min.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
<script>
	var clientheight=document.documentElement.clientHeight;
	var c=clientheight*0.72;
	$('.display').dataTable({
		//"dom": '<"toolbar">frtip',
		'paging' : false,
		"sScrollY" : c, //DataTables的高  
		"scrollCollapse" : true,
		"searching" : false,
		//columnDefs:[{
		//    targets: 2 ,
		//    render: function (data, type, row, meta) {
		//        return '<a type="button" class="btn btn-danger btn-block" href="#">删除</a>';
		//    }
		// }
		//],
		language : {
			"sProcessing" : "处理中...",
			"sLengthMenu" : "显示 _MENU_ 项结果",
			"sZeroRecords" : "没有匹配结果",
			"sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
			"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
			"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
			"sInfoPostFix" : "",
			"sSearch" : "搜索:",
			"sUrl" : "",
			"sEmptyTable" : "表中数据为空",
			"sLoadingRecords" : "载入中...",
			"sInfoThousands" : ",",
			"oPaginate" : {
				"sFirst" : "首页",
				"sPrevious" : "上页",
				"sNext" : "下页",
				"sLast" : "末页"
			}
		}
	});
	//$("div.toolbar").html('<b style="color:red">自定义文字、图片等等</b>');
</script>

</html>