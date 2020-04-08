<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: user--%>
<%--  Date: 08-Apr-20--%>
<%--  Time: 6:33 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>User Registration Page</title>
</head>
<body>
<form action="registrationServletPage" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" placeholder="Ente Name" required></td>
        </tr>
        <tr>
            <td>Email :</td>
            <td><input type="email" name="email" placeholder="Enter Email" required></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><input type="password" name="userPassword" placeholder="Enter Password" required></td>
        </tr>
        <tr>
            <td>Mobile No :</td>
            <td><select name="phone">
                <option>+91</option>
                <option>+92</option>
                <option>+93</option>
                <option>+94</option>
            </select>
                <input type="number" name="number" placeholder="Enter Mobile Number" required></td>
        </tr>
        <tr>
            <td>Select Gender:</td>
            <td><input type="radio" name="gender"><span>Male</span>
                <input type="radio" name="gender"><span>Female</span></td>
        </tr>
        <tr>
            <td><input type="submit" value="Register"></td>
        </tr>
    </table>
</form>
</body>
</html>
