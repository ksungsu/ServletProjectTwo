<%--
  Created by IntelliJ IDEA.
  User: LG677
  Date: 2022-07-13
  Time: 오후 1:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.sungsu.dto.BoardDTO" %>
<%@ page import="java.util.List" %>

<%
    request.setCharacterEncoding("utf-8");
    List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>BoardList JSP</title>
</head>
<body>
<div align="center">
    <h3>게시판 전체 목록 보기</h3>
    <table border="1">
        <tr>
            <th>카테고리</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>등록 일시</th>
            <th>수정 일시</th>
        </tr>
        <%
        if (list.size() == 0){
            out.println("<tr align='center'><td colspan='5'>작성된 글이 없습니다.</td></tr>");
        } else {
            for(int i = 0; i< list.size(); i++){
                out.println("<tr align='center'/>");
                out.println("<td>" + (list.size() - i));
            }
        }
        %>
    </table>
</div>
</body>
</html>
