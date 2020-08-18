<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
</head>
<body>
	<div align="center">
		<h1><em>BoardList</em></h1>
		<h3>[${userName}]님 환영합니다.<a href="logout.do">Log-out</a></h3>

		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" style="border-spacing: 0; border-collapse: collapse;" style="width: 700px">
				<tr>
					<td align="right">
						<select name="searchCondition" style="border: 0px;">
							<!-- <option value="TITLE">제목</option>
							<option value="CONTENT">내용</option> -->
							<c:forEach var="option" items="${conditionMap}">
								<option value="${option.value}">${option.key}</option>
							</c:forEach>
						</select>
						<input type="text" name="searchKeyword" style="border: 0px;" />
						<input type="submit" value="검색" />
					</td>
				</tr>
			</table>
		</form>
		<br />

		<!-- 검색 종료 -->
		<table border="1" style="border-spacing: 0; border-collapse: collapse;" style="width: 700px">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.seq}</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq}" style="text-decoration: none;">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<a href="insertBoard.jsp">새 글 등록</a>
	</div>
</body>
</html>