<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   
<!DOCTYPE html><html><head><meta charset="UTF-8"><title>글 목록</title>
</head>
<body>
<center>
 <h1><spring:message code="message.board.list.mainTitle"/> </h1>
 <h3>${useName}<spring:message code="message.board.list.welcomeMsg"/> <a href="logout.do">Log-out</a></h3>
 <!-- 검색 시작 -->
 <form action="getBoardList.do" method="post">
   <table border="1" cellspacing="0" width="700">
    <tr>
    	<td align="right">
    	<select name="searchCondition">
    	<c:forEach var="option" items="${conditionMap}">
    	   <option value="${option.value}">${option.key}
    	</c:forEach>
    	</select>
    	    <input type="text" name="searchKeyword">
    	    <input type="submit" value="검색">
    	 </td>   
    </tr>
   </table>
 </form>
 <!-- 검색 종료 -->
 <table border="1" cellspacing="0" cellpadding="0" width="700">
  <tr>
   <th bgcolor="orange" width="100">번호</th>
   <th bgcolor="orange" width="200">제목</th>
   <th bgcolor="orange" width="150">작성자</th>
   <th bgcolor="orange" width="150">등록일</th>
   <th bgcolor="orange" width="100">조회수</th>
  </tr>
 <c:forEach items="${boardList}" var="board">
      <tr>
       <td>${board.seq}</td>
       <td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
       <td>${board.writer}</td>
       <td>${board.regDate}</td>
       <td>${board.cnt}</td>
      </tr>
 </c:forEach>
 </table>
 <br><a href="insertBoard.jsp">새글 등록</a> 
 </center>
</body>
</html>