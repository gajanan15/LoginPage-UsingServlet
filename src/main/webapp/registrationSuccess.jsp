<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 08-Apr-20
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Success Page</title>
</head>
<body>
<h1>Hi <%=session.getAttribute("userName")%>, Registration Successful.</h1>
<h3><%=session.getAttribute("userName")%> This Is Your Details.</h3>
Email:<%=session.getAttribute("email")%><br>
Mobile NO.:<%=session.getAttribute("mobileNo")%><br>
<a href="loginPage.html">Login Page</a>
</body>
</html>
