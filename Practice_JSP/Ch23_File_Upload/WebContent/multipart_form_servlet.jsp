<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>multipart 폼</title>
</head>
<body>

<form action="/Ch23_File_Upload/upload" method="post" enctype="multipart/form-data">
text1: <input type="text" name="text1"/><br/>
file1: <input type="file" name="file1"/><br/>
file2: <input type="file" name="file2"/><br/>
<input type="submit" value="전송">
</form>
<!-- multipart/form-data 방식으로 데이터를 전송해주는 입력 폼 -->
</body>
</html>