<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>OAuth2 Demo</title>
</head>
<body>

<!-- <h3>No data is loaded yet.</h3> -->
<h3>Following Employees are found</h3>
	<table style="width:60%; height:30%;" border="1px;solid">
	
	<c:forEach var="emp" items="${empList}">
			<tr><td>${emp.name}</td><td>${emp.job}</td><td>${emp.salary}</td></tr>
	</c:forEach>
	
	</table> 
		
	</ul>
</body>
</html>