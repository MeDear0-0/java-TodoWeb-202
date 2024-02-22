<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 2/12/2024
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
  <%
    Date today = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("EE dd MMMM yyyy");
    String strToday = dateFormat.format(today);
  %>
  <h1>Todo List</h1>
  <h3>Today: <%=strToday%></h3>
  <%@include file="partials/todoForm.jsp"%>
  <c:choose>
    <c:when test="${fn:length(tasks)==0}">
      <h3>No Task</h3>
    </c:when>
    <c:otherwise>
      <ul>
        <c:forEach items="${tasks}" var="task">
          <li>${task.title} ${task.status=="NOT_COMPLETED"?"[Not completed]":"[Completed]"}
<%--            <a href="completed-todo?title=${task.title}">Done</a>--%>
<%--            <a href="toggle-todo?title=${task.title}">Toggle</a>--%>
<%--            <a href="remove-todo?title=${task.title}">Remove</a>--%>
            <a href="action-todo?title=${task.title}&action=completed">Done</a>
            <a href="action-todo?title=${task.title}&action=toggle">Toggle</a>
            <a href="action-todo?title=${task.title}&action=remove">Remove</a>
          </li>
        </c:forEach>
      </ul>
    </c:otherwise>
  </c:choose>
</body>
</html>
