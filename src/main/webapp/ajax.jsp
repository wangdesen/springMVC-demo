<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax test</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function get1() {
		$.ajax({
			url : "ajax/get1",
			data : "user=get1",
			type : 'GET',
			async : true,
			dataType : 'json',
			contentType : 'application/json',
			success : successFunc,
			error : errorFunc
		});
	}

	function get2() {
		$.ajax({
			url : "ajax/get2",
			data : {
				user : "get2"
			},
			type : 'GET',
			async : true,
			dataType : 'json',
			contentType : 'application/json',
			success : successFunc,
			error : errorFunc
		});
	}

	function get3() {
		$.ajax({
			url : "ajax/get3",
			data : "user=get3",
			type : 'GET',
			async : true,
			dataType : 'json',
			contentType : 'application/json',
			success : successFunc,
			error : errorFunc
		});
	}

	function get4() {
		$.ajax({
			url : "ajax/get4",
			data : {
				user : "get4"
			},
			type : 'GET',
			async : true,
			dataType : 'json',
			contentType : 'application/json',
			success : successFunc,
			error : errorFunc
		});
	}

	function post1() {
		$.ajax({
			url : "ajax/post1",
			data : {
				user : "post1"
			},
			type : 'POST',
			async : true,
			dataType : 'json',
			contentType : 'application/json',
			success : successFunc,
			error : errorFunc
		});

	}

	function post2() {
		$.ajax({
			url : "ajax/post2",
			data : JSON.stringify({
				user : "post2"
			}),
			type : 'POST',
			async : true,
			dataType : 'json',
			contentType : 'application/json',
			success : successFunc,
			error : errorFunc
		});

	}

	function successFunc(data) {
		$("#msg").text(JSON.stringify(data))
	}
	function errorFunc(data) {
		$("#msg").text(JSON.stringify(data))
	}
</script>
</head>
<body>
	<input type="button" onclick="get1();" value="get1">
	<input type="button" onclick="get2();" value="get2">
	<input type="button" onclick="get3();" value="get3">
	<input type="button" onclick="get4();" value="get4">

	<form action="ajax/get" method="get">
		<input type="hidden" name="hd" value="hdVal" /> <input type="submit" value="submit">
	</form>

	<input type="button" onclick="post1();" value="post1">
	<input type="button" onclick="post2();" value="post2">
	<div id="msg"></div>
</body>
</html>