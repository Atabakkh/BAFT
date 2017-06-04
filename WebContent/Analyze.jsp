<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pie Chart Demo</title>
 <link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/print.css" media="print">
<script type="text/javascript">
	function refreshPage() {
		document.forms.formId.submit();
	}
</script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
['Silimarity', 'Weight'],
[12, 0.368], [14, 0.368], [22, 0.294], [23, 0.368],   
[33, 0.368], [17, 0.294],
[19, 0.294], [27, 0.220], [28, 0.368],
[39, 0.220], [14, 0.368], [22, 0.294],
[28, 0.368], [34, 0.294], [36, 0.368]]);

        /* [0.011, 37], [0.012, 41], [0.012, 42], [0.01, 43], [0.018, 36], [0.013, 42.8], [0.012, 16.5], [0.011, 32.8],  
        [0.016, 23], [0.011, 16.5], [0.016, 22.8], [0.015, 52], [0.0076, 23], [0.017, 16.5], [0.019, 32.8]]); */
             
        
        var options = {
          title: 'Simultanously weights',
          hAxis: {title: 'Similarity'},
          vAxis: {title: 'Weight'},
          legend: 'none',
          trendlines: { 0: {} }    // Draw a trendline for data series 0.
        };

        var chart = new google.visualization.ScatterChart(document.getElementById('chart_div'));
        chart.draw(data, options);
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
	<h3>Create Pie Chart Dynamically using JFreechart</h3>
	<%
		//response.setIntHeader("Refresh", 10);
	%>
	<form id="formId">
		<input type="button" onclick="refreshPage()" value="Refresh Page" />
		<br /> <img src="displayChart" />
	</form>
	 <div id="chart_div" style="width: 900px; height: 500px;"></div>
</body>
</html>
