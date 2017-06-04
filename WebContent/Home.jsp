<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<title>Bio-inspired Approach for Forewarning of Tumors</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/print.css" media="print">
<script src="js/jquery-1.6.4.min.js"></script>
<script src="js/custom.js"></script>
<script type='text/javascript'>
	function invokeServlet() {
		// form a URL with the servlet name to be invoked
		var URL = 'http://hostname/servlet/servletName';

		// This line will inkove a servlet and reload your page
		location.href = URL;
	}
</script>

<!--[if lt IE 9]>
<script src="js/css3-mediaqueries.min.js"></script>
<script src="js/html5.js"></script>
<script src="js/IE9.js"></script>
<![endif]-->
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
								<li><a href="GGA.jsp">Greedy-Genetic</a></li>
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
	<hr>
	<div id="intro">
		<div class="inner">
			<div class="wrap clearFix">
				<h1>
					Share something. <strong>Worldwide.</strong>
				</h1>
				<p>Computational precise detection of DNA sequence variant in
					brain cancer using hybrid Weighted Network and Genetic Algorithm</p>
				<a href="#" class="button">SIGN UP</a>
			</div>
		</div>
	</div>
	<!-- / #intro -->
	<hr>
	<div id="content">
		<div class="wrap clearFix">
			<h2>SOME OF THE COOL FEATURES</h2>
			<div class="clearFix">
				<div class="col floatLeft">
					<img src="images/icon-location.png" alt="" class="icon">
					<h3>Location Services</h3>
					<p>Maecenas faucibus mollis interdum. Donec ullamcorper nulla
						non metus auctor fringilla. Nulla vitae elit libero, austo odio,
						dapibus ac facilisis in.</p>
				</div>
				<div class="col floatRight">
					<img src="images/icon-backup.png" alt="" class="icon">
					<h3>24/7 Back Up</h3>
					<p>Maecenas faucibus mollis interdum. Donec ullamcorpe it
						libero, a pharetra r nulla non metus auctor fringilla. Nulla vitae
						elit libero, a pharetra augue. Cras justo odio, dapibus ac
						facilisis in.</p>
				</div>
			</div>
			<div class="clearFix">
				<div class="col floatLeft">
					<img src="images/icon-twitter.png" alt="" class="icon">
					<h3>Twitter Integration</h3>
					<p>
						Maecenas faucibus mollis interdum. Donec <a href="#">ullamcorper
							nulla</a> non metus auctor fringilla. Nulla vitae elit libero, a
						pharetra augue. Cras justo odio, dapibus ac facilisis in.
					</p>
				</div>
				<div class="col floatRight">
					<img src="images/icon-stats.png" alt="" class="icon">
					<h3>Full Realtime Statistics</h3>
					<p>Maecenas faucibus mollis interdum. Donec ullamcorper nuletus
						auctor fringilla. Nulla vitae elit libero, a pharetra augue. Cras
						justo odio, dapibus ac facilisis in.</p>
				</div>
			</div>
			<div class="clearFix">
				<div class="col floatLeft">
					<img src="images/icon-tools.png" alt="" class="icon">
					<h3>Highly Customisable</h3>
					<p>Maecenas faucibus mollis interdum. Donec ullamcorper nulla
						non auctor fringilla. Nulla viit libero, a pharetra tae elit
						libero, a pharetra augue. Cras justo odio, dapibus ac facilisis
						in.</p>
				</div>
				<div class="col floatRight">
					<img src="images/icon-awards.png" alt="" class="icon">
					<h3>Award Winner Service</h3>
					<p>Maecenas follis interdum. Metus auctor it libero, a pharetra
						fringilla. Nulla vitae elit libero, a pharetra augue. Cras justo
						odio, dapibus ac facilisis in.</p>
				</div>
			</div>
			<div class="buttonCentered">
				<a href="#" class="button iconRight">TAKE A FEATURE TOUR <i
					class="more"></i></a>
			</div>
			<h2>WHAT OUR CUSTOMERS ARE SAYING</h2>
			<ul class="cols clearFix">
				<li>
					<p>Nullam id dolor id nibh ultricies vehicula id elit. Donec id
						elit non mi porta gravida at eget metus. Aenean lacinia bibendum
						nulla sed consectetur. Donec sed odio dui. Vivamus sagittis.</p>
					<p>
						<strong>John Doe</strong>, Apple
					</p>
				</li>
				<li class="middle">
					<p>Nullam id dolor id nibh ultricies vehicula id elit. Donec id
						elit non mi porta gravida at eget metus. Aenean lacinia bibendum
						nulla sed consectetur. Donec sed odio dui. Vivamus sagittis.</p>
					<p>
						<strong>John Doe</strong>, Apple
					</p>
				</li>
				<li>
					<p>Nullam id dolor id nibh ultricies vehicula id elit. Donec id
						elit non mi porta gravida at eget metus. Aenean lacinia bibendum
						nulla sed consectetur. Donec sed odio dui. Vivamus sagittis.</p>
					<p>
						<strong>John Doe</strong>, Apple
					</p>
				</li>
			</ul>
			<form action="#" method="post">
				<fieldset>
					<label for="email">To stay in touch, simply subscribe to
						our newsletter.</label> <input type="text" class="text" id="email">
					<button type="submit" class="button iconLeft">
						<i class="email"></i> SUBSCRIBE
					</button>
				</fieldset>
			</form>
		</div>
	</div>
	<!-- / #content -->
	<hr class="noPrint">
	<div id="twitter">
		<div class="wrap clearFix">
			<span class="icon"></span>
			<p>
				Etiam porta sem malesuada magna mollis euismod. Nullam quis risus
				eget urna mollis <a href="#">domain.com</a> <small>2 days
					ago</small>
			</p>
		</div>
	</div>
	<hr>
	<footer class="clearFix">
		<div class="wrap clearFix">
			<p class="floatRight">
				Copyright &copy; 2012 <a href="#">Your Name</a> &ndash; All Rights
				Reserved<br> Template by <a target="_blank"
					href="http://www.templatestar.net">Templatestar</a> &amp; <a
					target="_blank" href="http://www.os-templates.com/">OS
					Templates</a>
			</p>
			<p class="socialIcons">
				<a href="#" class="rss">RSS</a> <a href="#" class="facebook">Facebook</a>
				<a href="#" class="twitter">Twitter</a>
			</p>
		</div>
	</footer>
	<div align=center>
		This template downloaded form <a
			href='http://all-free-download.com/free-website-templates/'>free
			website templates</a>
	</div>
</body>
</html>
