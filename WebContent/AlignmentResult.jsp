<%@page import="ir.ata.baft.Article"%>
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
<link rel="stylesheet" type="text/css" href="styles/alignment-table.css" />
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
	
	<table class="pretty-table" summary="Alignment table for Gene">
	  <caption>Alignment</caption>
	  <tr>
	    <th scope="col">ID</th>
	    <th scope="col">Title</th>
	  </tr>
	  <c:forEach items="${articles}" var="article">
		  <tr>
		    <th scope="row">${article.id}</th>
		    <td>${article.title}</td>
		  </tr>
	  </c:forEach>
	
  	</table>
	
	<%-- <table>
		<c:forEach items="${articles}" var="article">
			<c:out value="${article.id} ${article.title}" />
			<br />
		</c:forEach>
	</table> --%>
	
	<%-- <table id="tt" class="easyui-datagrid"
		style="width: 500px; height: 250px" url="${articles}"
		title="Searching" iconCls="icon-search" toolbar="#tb"
		rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="id" width="100">Code</th>
				<th field="title" width="100">Continent</th>
				<th field="id" width="100" align="right">Name</th>
				<th field="title" width="140" align="right">Region</th>
			</tr>
		</thead> --%>
	    <%-- <c:forEach items="${articles}" var="article">
	        <tr>
	            <td>${article.id}</td>
	            <td>${article.title}</td>
	            <td>${article.id}</td>
	            <td>${article.title}</td>
	        </tr>
	    </c:forEach> --%>
	<!-- </table> -->
	<div id="tb" style="padding: 3px">
		<span>Continent:</span> <input id="cname"
			style="line-height: 26px; border: 1px solid #ccc"> <span>Region:</span>
		<input id="region" style="line-height: 26px; border: 1px solid #ccc">
		<a href="#" class="easyui-linkbutton" plain="true"
			onclick="doSearch()">Search</a>
	</div>
</body>
</html>
