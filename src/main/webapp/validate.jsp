<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <form:form commandName="user" modelAttribute="user" method="post" action="validate/test"> --%>
	<form:form modelAttribute="user" method="post"> 
		<form:errors path="*"></form:errors>
		<br />
        username：<form:input path="username" />
		<form:errors path="username"></form:errors>
		<br />
        
        password：<form:input path="password" />
		<form:errors path="password"></form:errors>
		<br />
        
        email：<form:input path="email" />
		<form:errors path="email"></form:errors>
		<br />

		<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>