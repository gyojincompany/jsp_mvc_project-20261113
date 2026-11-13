<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공 축하</title>
</head>
<body>
	<h2>로그인 성공</h2>
	<hr>
	<h3>${memberDto.username }님 로그인 성공하셨습니다.</h3>
	<h3>가입하신 아이디는 ${memberDto.userid }이고, </h3>
	<h3>가입일은 ${memberDto.userdate } 입니다. </h3>
	
</body>
</html>