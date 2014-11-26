<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="fileUpload/test" method="POST" enctype="multipart/form-data">
	文件1: <input type="file" name="myfiles" /><br/>
	文件2: <input type="file" name="myfiles"/><br/>
	文件3: <input type="file" name="myfiles"/><br/>
	<input type="submit" value="上传"/>
</form>
${message}
</body>
</html>