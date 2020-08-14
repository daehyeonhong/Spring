<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 등록</title>
</head>
<body>
	<div align="center">
		<h1>새 글 등록</h1>
		<a href="getBoardList.do">Log-out</a>
		<form action="insertBoard.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70px">제목</td>
					<td align="left"><input type="text" name="title" required="required" autofocus="autofocus" /></td>
				</tr>

				<tr>
					<td bgcolor="orange" width="70px">작성자</td>
					<td align="left">
						<p>${user.name}</p>
						<input type="hidden" name="writer" value="${user.name}" />
					</td>
				</tr>

				<tr>
					<td bgcolor="orange" width="70px">내용</td>
					<td align="left"><textarea rows="10" cols="40" name="content" required="required" ></textarea></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="새 글 등록" /></td>
				</tr>
			</table>
		</form>
		<hr />
		<a href="getBoardList.do">글 목록</a>
	</div>
</body>
</html>