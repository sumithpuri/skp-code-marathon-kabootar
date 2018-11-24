<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<html>
 <head>
	<!-- default ext js libraries -->
	<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
    <link rel="stylesheet" type="text/css" href="css/ext-all.css"/>
    <script type="text/javascript" src="js/ext-base.js"></script>
    <script type="text/javascript" src="js/ext-all.js"></script>
	<!-- endlibs -->

	<!-- custom style -->
	<style type="text/css">
		.align-fields {
			text-align:center;
		}
		.align-buttons {
			margin-left: auto;
			margin-right: auto;
			margin-top: 22px;
		}
	</style>
	<!-- endstyle -->

	<!-- additional style sheet -->
	<link rel="stylesheet" type="text/css" href="css/examples.css"/>
	<!-- endstyle -->


	<!-- kabootar chat js libraries -->
	<script type="text/javascript" src="js/kabootar-main.js"></script>
	<!-- endlibs -->

	<title>Kabootar Chat System v1.0 - Truly Desi!</title>

	<script type="text/javascript" src="/kabootar/dwr/engine.js"></script>
	<script type="text/javascript" src="/kabootar/dwr/util.js"></script>
	<script type="text/javascript" src="/kabootar/dwr/interface/Server.js"></script>

	<script type="text/javascript">
		function sendKabootar(kabootar) {
			Server.sendKabootar(kabootar);
		}

		function submitKabootar() {
			user = document.getElementById("userName").value;
			msg = document.forms[0].msgArea.value;
			document.forms[0].msgArea.value='';
			kabootar = user + "> " + msg;
			sendKabootar(kabootar);   	
		}

		function broadcastKabootar(kabootar) {
		   document.forms[0].chatArea.value=document.forms[0].chatArea.value + "\n" + kabootar;
		}

		function broadcastUsers(users) {
			  // #START - Initialize Values
			  document.forms[0].elements[3].onclick=submitKabootar;
			  document.forms[0].chatArea.value="system> Initializing...";
			  // #END
			  
			  var userVal = users.split(" ");
			  var value="" + userVal[0];
			  for(i=1;i<userVal.length;i++) value = value + "\n" + userVal[i];

			  document.forms[0].userArea.value="";
			  document.forms[0].userArea.value=value;
		}

		function initializePage() {
			Server.refreshUsers();
		}
		
	</script>
	
	<script>setTimeout("initializePage()", 500);</script>
 </head>

 <body onload="dwr.engine.setActiveReverseAjax(true);" style="margin-left: 160px;">  
 	<input id="userName" type="hidden" value='<%= request.getParameter("userName") %>'></input>
 </body>
 
</html>
