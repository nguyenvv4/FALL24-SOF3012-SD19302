<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 28/10/2024
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<table class="table table-striped">
    <thead>
    <tr>
        <td>id</td>
        <td>ma san pham</td>
        <td>ten san pham</td>
        <td>ten danh muc</td>
        <td>trang thai</td>
        <td>hanh dong</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sanPham" items="${list}">
        <tr>
            <td>${sanPham.id}</td>
            <td>${sanPham.maSanPham}</td>
            <td>${sanPham.tenSanPham}</td>
            <td>${sanPham.tenDanhMuc}</td>
            <td>${sanPham.trangThai}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

