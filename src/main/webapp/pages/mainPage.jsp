<%@ page import="dbCheck.TestDB" %><%--
  Created by IntelliJ IDEA.
  User: oxqqq
  Date: 11.04.2021
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<h1>
<%= "Добро пожаловать, " + request.getParameter("username")%>
</h1>
<h3>
    ${param["username"]}
</h3>

<%
    TestDB tdb = new TestDB();

%>
<%=tdb.check()%>

</body>
</html>
