<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Login</title>
<style type="text/css">
	input {
	border: 0px;
}
</style>
</head>
<body>
	<div align="center">
		<h1>
			<em>Login!</em>
		</h1>
		<hr />
		<form action="login.do" method="post">
			<table border="1" style="border-spacing: 0; border-collapse: collapse;">
				<tr>
					<td bgcolor="orange">ID</td>
					<td><input type="text" name="id" value="${user.id}" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">Password</td>
					<td><input type="password" name="password" value="${user.password}" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>