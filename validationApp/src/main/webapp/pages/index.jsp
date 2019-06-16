<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="signup" method="post"
modelAttribute="user">
Name <form:input type="text" path="name"/><br/>
<form:errors path="name"/> <br/>
MailId <form:input type="text" path="mailId"/><br/>
<form:errors path="mailId"/> <br/>
Password <form:input type="password" path="password"/><br/>
<form:errors path="password"/> <br/>
<input type="submit" value="Register" />
</form:form>