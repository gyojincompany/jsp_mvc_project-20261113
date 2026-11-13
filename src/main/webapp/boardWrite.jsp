<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<h2>게시판 글쓰기</h2>
	<hr>
	<form action="boardWriteAction.do">
		제목 : <input type="text" name="title" size="50"><br><br>
		내용 : <textarea rows="10" cols="70" name="content"></textarea><br><br>
		<button type="submit">등록하기</button>
	</form>
</body>
</html>