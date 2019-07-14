<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Oauth Client</title>
</head>
<body>
			<h3>Authorization Grant</h3>

	<div>
		<form action="http://localhost:8080/oauth/authorize" method="post">
			<input type="hidden" name="response_type" value="code" /> 
			<input type="hidden" name="client_id" value="techmentro" />
			<input type="hidden" name="scope" value="read" /> <br/>
		   <input type="SUBMIT" value="Fetch Employees" />
		</form>
	</div>
	<!-- use this form in an js or angular application  
	<div>
		<form action="http://localhost:8080/oauth/authorize" method="post">
			 <input type="hidden" name="response_type" value="token" /> <br/>
			 <input type="hidden" name="client_id" value="techmentro" /><br/>
			 <input type="hidden" name="scope" value="read" /> <br/>
			 <input type="SUBMIT" value="Get Acess Token" />
		</form>
	</div> 
	-->
	
	
</body>
</html>
