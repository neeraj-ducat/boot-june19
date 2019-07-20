<%@ taglib uri="http://tiles.apache.org/tags-tiles" 
prefix="tiles" %>
<html>
<head>
<title>Boot Web App</title>
<jsp:include page="css_js.jsp"/>
</head>
<body>
<div class="container">

	<div class="row">
		<tiles:insertAttribute name="header"/>
	</div><hr/>
	<div class="row">
		<tiles:insertAttribute name="contents"/>
	</div><hr/>
	<div class="row">
		<tiles:insertAttribute name="footer"/>
	</div>
</div>
</body>
</html>
