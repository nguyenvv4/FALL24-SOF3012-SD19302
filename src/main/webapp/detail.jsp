<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 8/11/24
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="" method="post">
    <label>Id</label>
    <input type="text" name="id" value="${user.id}"> <br>
    <label>Fullname</label>
    <input type="text" name="fullname" value="${user.fullname}"> <br>
    <label>Password</label>
    <input type="text" name="password" value="${user.password}"> <br>
    <label>Email</label>
    <input type="text" name="email" value="${user.email}"> <br>
    <label>Admin</label>
    <input type="radio" name="admin" value="true" value="${user.admin == 'true' ? 'checked':''}"> Quan Ly
    <input type="radio" name="admin" value="false" value="${user.admin == 'false' ? 'checked':''}">Nhan Vien
    <br>
    <button type="submit">Add</button>
</form>
</body>
</html>