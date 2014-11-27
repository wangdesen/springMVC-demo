<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springMVC demo</title>
<style type="text/css">
ul li {
	list-style-type: decimal;
	margin:5px;
}

a {
	text-decoration: none;
}

a:hover {
	color: red;
	text-decoration: underline;
}
</style>
</head>
<body>
	<h1>springMVC demo</h1>
	<div>
		<ul>
			<li><a href="redirect/test" target="_blank">redirect test</a></li>
			<li><a href="forward/test" target="_blank">forward test</a></li>
			<li><a href="ajax.jsp" target="_blank">ajax test</a></li>
			<li><a href="multiView/test1" target="_blank">multiView test1</a></li>
			<li><a href="multiView/test2" target="_blank">multiView test2</a></li>
			<li><a href="interceptor/test" target="_blank">interceptor test</a></li>
			<li><a href="exception/normal" target="_blank">normal exception test</a></li>
			<li><a href="exception/global" target="_blank">global exception test</a></li>
			<li><a href="exception/custom" target="_blank">custom exception test</a></li>
			<li><a href="freemarker/test" target="_blank">freemarker test</a></li>
			<li><a href="fileUpload.jsp" target="_blank">fileUpload test</a></li>
			<li><a href="validate/test" target="_blank">validate test</a></li>
			<li><a href="i18n/test" target="_blank">international test</a></li>
			<li><a href="i18n/session?langType=zh" target="_blank">session international test</a></li>
			<li><a href="i18n/cookie?langType=en" target="_blank">cookie international test</a></li>
		</ul>
	</div>

</body>
</html>