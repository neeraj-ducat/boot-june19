<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="register" method="post" 
modelAttribute="user">
Name: <form:input type="text" path="name" />
<form:errors path="name"/> <br/>
MailId: <form:input type="text" path="mailId"/>
<form:errors path="mailId"/> <br/>
Password: <form:input type="password" path="password"/>
<form:errors path="password"/> <br/>
<input type="submit" value="Register">
</form:form>

