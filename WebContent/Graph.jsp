<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="styles/gexfjs.css" />
<link rel="stylesheet" type="text/css"
	href="styles/jquery-ui-1.10.3.custom.min.css" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script type="text/javascript">
        // Fallback in case JQuery CDN isn't available
            if (typeof jQuery == 'undefined') {
                document.write(unescape("%3Cscript type='text/javascript' src='js/jquery-2.0.2.min.js'%3E%3C/script%3E"));
            }
        </script>
<script type="text/javascript" src="js/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
<script type="text/javascript" src="js/gexfjs.js"></script>

<script type="text/javascript">
        var myParam = location.search.split('searchGene=')[1] ? location.search.split('searchGene=')[1] : 'newGraph';
        //alert(myParam);
        setParams({
        	
            graphFile : "graphs//"+myParam+".gexf",
                /*
                    The GEXF file to show ! -- can be overriden by adding
                    a hash to the document location, e.g. index.html#celegans.gexf
                */
        	showEdges : true,
                /*
                    Default state of the "show edges" button
                */
            useLens : false,
                /*
                    Default state of the "use lens" button
                */
            zoomLevel : 0,
                /*
                    Default zoom level. At zoom = 0, the graph should fill a 800x700px zone
                 */
            curvedEdges : false,
                /*
                    False for curved edges, true for straight edges
                    this setting can't be changed from the User Interface
                */
            edgeWidthFactor : 1,
                /*
                    Change this parameter for wider or narrower edges
                    this setting can't be changed from the User Interface
                */
            minEdgeWidth : 1,
            maxEdgeWidth : 50,
            //textDisplayThreshold: 9,
            nodeSizeFactor : 1,
                /*
                    Change this parameter for smaller or larger nodes
                   this setting can't be changed from the User Interface
                */
            replaceUrls : true,
                /*
                    Enable the replacement of Urls by Hyperlinks
                    this setting can't be changed from the User Interface
                */
            showEdgeWeight : true,
                /*
                    Show the weight of edges in the list
                    this setting can't be changed from the User Interface
                */
            language: false
                /*
                    Set to an ISO language code to switch the interface to that language.
                    Available languages are English [en], French [fr], Spanish [es],
                    Italian [it], Finnish [fi], Turkish [tr] and Greek [el].
                    If set to false, the language will be that of the user's browser.
                */
        });

        </script>


<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/print.css" media="print">
<link rel="stylesheet" type="text/css" media="all" href="css/styles.css" />
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
	<div id="zonecentre" class="gradient">
		<canvas id="carte" width="0" height="0"></canvas>
		<ul id="ctlzoom">
			<li><a href="#" id="zoomPlusButton" title="S'approcher"> </a></li>
			<li id="zoomSliderzone">
				<div id="zoomSlider"></div>
			</li>
			<li><a href="#" id="zoomMinusButton" title="S'éloigner"> </a></li>
			<li><a href="#" id="lensButton"> </a></li>
			<li><a href="#" id="edgesButton"> </a></li>
		</ul>
	</div>
	<div id="overviewzone" class="gradient">
		<canvas id="overview" width="0" height="0"></canvas>
	</div>
	<div id="leftcolumn">
		<div id="unfold">
			<a href="#" id="aUnfold" class="rightarrow"> </a>
		</div>
		<div id="leftcontent"></div>
	</div>
	<div id="titlebar">

		<form id="recherche">
			<input id="searchinput" class="grey" autocomplete="off" /> <input
				id="searchsubmit" type="submit" />
		</form>
	</div>
	<ul id="autocomplete">
	</ul>
</body>
</html>