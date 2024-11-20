<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 20/11/24
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <label>Email</label>
    <input type="text" name="email"> <br>
    <label>Pass</label>
    <input type="text" name="pass"> <br>
    <button type="submit">Login</button>
    <h1>${error}</h1>
</form>
</body>
</html>
