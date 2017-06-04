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

	<!-- 
<form id="upload" action="index.html" method="POST" enctype="multipart/form-data">

<fieldset>
<legend>Name Mapping Import File</legend>

<input type="hidden" id="MAX_FILE_SIZE" name="MAX_FILE_SIZE" value="300000" />

<div>
	<label for="fileselect">Files to upload:</label>
	<input type="file" id="fileselect" name="fileselect[]" multiple="multiple" />
	<div id="filedrag">or drop files here</div>
</div>

<div id="submitbutton">
	<button type="submit">Upload Files</button>
</div>

</fieldset>

</form>

<div id="messages">
<p>Status Messages</p>
</div>

<script src="js/filedrag.js"></script>

 -->

	<form action="upload-file" method="post" name="uploadForm"
		enctype="multipart/form-data">
		<fieldset>
			<legend>Name Mapping Import File</legend>
			<p>
				<input id="uploadfile" name="uploadfile" type="file" size="50">
			</p>

			<p></p>
			<input name="submit" type="submit" value="Submit">
		</fieldset>
	</form>

	<br>
	<br>

	<form action="upload-gene-file" method="post" name="uploadGeneForm"
		enctype="multipart/form-data">
		<fieldset>
			<legend>Gene Weight Import File</legend>
			<p>
				<input id="uploadfile" name="uploadfile" type="file" size="50">
			</p>

			<p></p>
			<input name="submit" type="submit" value="Submit">
		</fieldset>
	</form>


</body>
</html>
