<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>새글 등록</title>
</head>
<body>
<center>
  <h1>새글 등록</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="insertBoard.do" 
          method="post" enctype="multipart/form-data">
  <table border="1" cellpadding="0" cellspacing="0">
  <tr>
   <td bgcolor="orange" width="70">제목</td>
   <td align="left"><input type="text" name="title"></td>
  </tr>
  
  <tr>
   <td bgcolor="orange">작성자</td>
   <td align="left"><input type="text" name="writer" size="10" value="${useName}"></td>
  </tr>
  
  <tr>
   <td bgcolor="orange">내용</td>
   <td align="left"><textarea rows="10" cols="40" name="content"></textarea> </td>
  </tr>

   <tr>
    <td bgcolor="orange">파일</td>
    <td><input type="file" name="uploadFile"></td>
   </tr>
  <tr>
    <td colspan="2" align="center"><input type="submit" value="새글 등록">
  </tr>
  
  </table>
</form>

<hr>
<a href="getBoardList.do">글 목록</a>

</center>
</body>
</html>