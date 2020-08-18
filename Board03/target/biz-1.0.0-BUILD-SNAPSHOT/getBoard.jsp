<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
			function readURL(input) {
					if (input.files && input.files[0]) {
							let reader = new FileReader();
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

	<div align="center">
		<h1>getBoard</h1>
		<a href="logout.do">Log-out</a>
		<form action="updateBoard.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="seq" value="${board.seq}" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70px">제목</td>
					<td align="left"><input type="text" name="title" value="${board.title}" /></td>
				</tr>

				<tr>
					<td bgcolor="orange" width="70px">작성자</td>
					<td align="left">${board.writer}</td>
				</tr>

				<tr>
					<td bgcolor="orange" width="70px">내용</td>
					<td align="left"><textarea rows="10" cols="40" name="content" >${board.content}</textarea></td>
				</tr>

				<tr>
					<td bgcolor="orange">File: </td>
					<td><img alt="image" id="foo" src="${board.images}" />
					<input type="file" name="uploadFile" id="uploadFile" /></td>
				</tr>


				<tr>
					<td bgcolor="orange" width="70px">등록일자</td>
					<td align="left">${board.regDate}</td>
				</tr>

				<tr>
					<td bgcolor="orange" width="70px">조회수</td>
					<td align="left">${board.cnt}</td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="글 수정" /></td>
				</tr>
			</table>
		</form>

		<hr />
		<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=${board.seq}">글 삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">글 목록</a>
	</div>
</body>
</html>