<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="validator/test" method="POST" enctype="multipart/form-data">
	username:<input type="text" name="username" value="" /> <br>
	password:<input type="password" name="password" value="" /> <br>
	email:<input type="text" name="email" value="" /> <br>
	<input type="submit" value="上传"/>
</form>
${message}
</body>
</html>