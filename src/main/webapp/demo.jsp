<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 15/11/24
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <script>
        function handlerClick() {
            $.ajax({
                    url: "http://localhost:8082/api/test-ajax",
                    async: false,
                    crossDomain: true,
                    type: "GET",
                    contentType: "application/json; charset=utf-8",
                    datatype: "jsonp",

                    success: function (response) {
                        console.log(response)
                    },
                }
            )

        }
    </script>
</head>
<body>
<button onclick="handlerClick()">Click me</button>
</body>
</html>
