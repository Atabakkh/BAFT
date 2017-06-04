<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<title>Bio-inspired Approach for Forewarning of Tumors</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/print.css" media="print">
<link rel="stylesheet" type="text/css" media="all" href="css/styles.css" />
<script src="js/jquery-1.6.4.min.js"></script>
<script src="js/custom.js"></script>

<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	function doSearch() {
		$('#tt').datagrid('load', {
			cname : $('#cname').val(),
			region : $('#region').val()
		});
	}
	  
</script>

</head>
<body>
	<header class="clearFix">
		<div class="wrap">
			<a id="logo" href="#">BAFT</a>
			<hr>
			<nav>
				<div id="nav">
					<strong>Navigation</strong>
					<ul>
						<li class="active"><a href="Home.jsp">Home</a></li>
						<li class="parent"><a href="#">Process</a>
							<ul>
								<li><a href="Import.jsp">Import</a></li>
								<li><a href="Search.jsp">Search</a></li>
								<li><a href="Prediction.jsp">Prediction</a></li>
							</ul></li>
						<%-- 						<li><a href='<%=request.getRequestURL()%>' --%>
						<!-- 							onclick='invokeServlet()'>Simulation</a></li> -->
						<li class="parent"><a href="#">DNA Sequencing</a>
							<ul>
								<li><a href="Alignment.jsp">Alignment</a></li>
								<li><a href="Analyze.jsp">Analyze</a></li>
								<li><a href="Detection.jsp">Detection</a></li>
							</ul>
						</li>
						<li class="parent"><a href="#">About us</a>
							<ul>
								<li><a href="#">Lorem ipsum</a></li>
								<li><a href="#">Lorem ipsum</a></li>
								<li><a href="#">Lorem ipsum</a></li>
							</ul></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Contacts</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</header>

	<form action="AlignmentResult" method="get" name="alignmentform"
		enctype="multipart/form-data">
		<fieldset>
			<p>
				Gene Name: <input id="geneName" name="geneName" type="text"
					size="40" style="margin-left: 53px">
			</p>
			<p>
				Similarity Score: <input id="similarity" name="similarity"
					type="number" size="5" value="1" style="margin-left: 33px">
			</p>
			<p>
				Non Similarity Score: <input id="nonSimilarity" name="nonSimilarity"
					type="number" size="5" value="-1" style="margin-left: 1px">
			</p>
			<p>
				Gap Score: <input id="gap" name="gap" type="number" size="5"
					value="-2" style="margin-left: 65px">
			</p>

			<p></p>
			<input name="alignment" type="submit" value="Align"
				style="margin-left: 136px; width: 200px; height: 30px">
		</fieldset>
	</form>

	<br>
	<p><label>${required}</label></p>
	<br>
	<table>
		<c:forEach items="${articles}" var="article">
			<c:out value="${article.id} ${article.title}" />
			<br />
		</c:forEach>
	</table>
	<div id="myDiv" name="myDiv" class="myDiv">
	</div>

	<table id="tt" class="easyui-datagrid"
		style="width: 500px; height: 250px" url="servlet/ResponseServlet"
		title="Searching" iconCls="icon-search" toolbar="#tb"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="code" width="100">Code</th>
				<th field="continent" width="100">Continent</th>
				<th field="name" width="100" align="right">Name</th>
				<th field="region" width="140" align="right">Region</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding: 3px">
		<span>Continent:</span> <input id="cname"
			style="line-height: 26px; border: 1px solid #ccc"> <span>Region:</span>
		<input id="region" style="line-height: 26px; border: 1px solid #ccc">
		<a href="#" class="easyui-linkbutton" plain="true"
			onclick="doSearch()">Search</a>
	</div>
</body>
</html>
