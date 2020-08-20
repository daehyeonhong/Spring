<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>글 상세</title>
</head>
<body>
<center>
  <h1>글 상세</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="updateBoard.do" method="post"  enctype="multipart/form-data">
  <input name="seq" type="hidden" value="${board.seq}">
  <table border="1" cellpadding="0" cellspacing="0">
  <tr>
   <td bgcolor="orange" width="70">제목</td>
   <td align="left"><input type="text" name="title" value="${board.title}"></td>
  </tr>
  
  <tr>
   <td bgcolor="orange">작성자</td>
   <td align="left">${board.writer}</td>
  </tr>
  
  <tr>
   <td bgcolor="orange">내용</td>
   <td align="left"><textarea rows="10" cols="40" name="content">${board.content}</textarea> </td>
  </tr>
  
  <tr>
   <td bgcolor="orange">등록일자</td>
   <td align="left">${board.regDate}</td>
  </tr>
  <tr>
   <td bgcolor="orange">조회수</td>
   <td align="left">${board.cnt}</td>
  </tr>

   <tr>
    <td bgcolor="orange">파일</td>
    <td><input type="file" name="uploadFile" id="uploadFile"><img id="foo" src="/img/${board.images}"></td>
   </tr>
   
  <tr>
    <td colspan="2" align="center"><input type="submit" value="글 수정">
  </tr>
  
  </table>
</form>

<hr>
<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=${board.seq}">글 삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글 목록</a>

</center>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#foo').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#uploadFile").change(function() {
        readURL(this);
    });
</script>
</body>
</html>