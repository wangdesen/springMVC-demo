<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="test?langType=zh">中文</a>
<a href="test?langType=en">英文</a>
<br><br>

后台获取的国际化信息：<br/>
${username}<br/>
${password}<br/>
<br/>

直接绑定的国际化信息：<br/>
<spring:message code="username"></spring:message><br>
<spring:message code="password"></spring:message>

</body>
</html>