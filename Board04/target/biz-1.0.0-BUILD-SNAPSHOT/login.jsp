<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title><spring:message code="message.user.login.title"/></title>
<style type="text/css">
	input {
	border: 0px;
}
</style>
</head>
<body>
	<div align="center">
		<h1>
			<em><spring:message code="message.user.login.title"/></em>
		</h1>
		<a href="login.do?lang=en">
			<spring:message code="message.user.login.language.en" />
		</a>&nbsp;&nbsp;
		<a href="login.do?lang=ko">
			<spring:message code="message.user.login.language.ko" />
		</a>
		<hr />
		<form action="login.do" method="post">
			<table border="1" style="border-spacing: 0; border-collapse: collapse;">
				<tr>
					<td bgcolor="orange"><spring:message code="message.user.login.id" /></td>
					<td><input type="text" name="id" value="${user.id}" /></td>
				</tr>
				<tr>
					<td bgcolor="orange"><spring:message code="message.user.login.password" /></td>
					<td><input type="password" name="password" value="${user.password}" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="<spring:message code="message.user.login.loginBtn" />" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>