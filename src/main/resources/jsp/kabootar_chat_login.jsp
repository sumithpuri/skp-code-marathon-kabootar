<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta content="en-gb" http-equiv="Content-Language" />
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<title>Kabootar Chat System v1.0 - Truly Desi!</title>
	
	<link rel="stylesheet" type="text/css" href="css/ext-all.css"/>
	<script type="text/javascript" src="js/ext-base.js"></script>
	<script type="text/javascript" src="js/ext-all.js"></script>
	
	<!-- additional style sheet -->
	<link rel="stylesheet" type="text/css" href="css/examples.css"/>
	<!-- endstyle -->
	
	
	<!-- kabootar chat js libraries -->
	<script type="text/javascript" src="js/kabootar-login.js"></script>
	<!-- endlibs -->
	
	<script type="text/javascript" src="/kabootar/dwr/engine.js"></script>
	<script type="text/javascript" src="/kabootar/dwr/util.js"></script>
	<script type="text/javascript" src="/kabootar/dwr/interface/Server.js"></script>
	
	<script>setTimeout("initializePage()", 500);</script>
	
	<script type="text/javascript">
		function initializePage() {
			document.forms[0].name="userForm";
			document.forms[0].action="verify.kabootar";
			document.forms[0].elements[3].value="<%= Math.round (Math.random() * 123) %>";
			document.getElementById("loginButton").onclick=submitLogin;
			document.getElementById("cancelButton").onclick=confirmClose;
		}
		
		function submitLogin() {
			document.forms[0].submit();
		}
		
		function confirmClose() {
			window.close();
		}
	</script>
</head>

<body style="margin-left: 475px;">

</body>
</html>
