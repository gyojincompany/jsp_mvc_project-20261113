<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 내용 보기</title>
</head>
<body>
	<h2>게시글 내용 보기</h2>
	<hr>
	<p>번호 : ${boardDto.boardnum }</p>
	<p>조회수 : ${boardDto.hit }</p>
	<p>작성자 : ${boardDto.userid }</p>
	<p>제목 : ${boardDto.title }</p>
	<p>내용 : ${boardDto.content }</p>
	<p>작성일 : ${boardDto.regdate }</p>
	
</body>
</html>