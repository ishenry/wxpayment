<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
    Hello ${name}!
    <input  id="testAjax" type="button" value="提交参数测试">
</body>

<script type="text/javascript" src="/webjars/jquery/1.11.3/jquery.js"></script>
<script type="text/javascript">
$(function () {
        $('#testAjax').click(function () {
            var users = JSON.stringify([
                {"userName": "user1", "address": "123"},
                {"userName": "user2", "address": "123"}
            ]);

            $.ajax({
            type: "POST",
            url:  "test",
            dataType: "text",
            contentType: "application/json",
            data: users,
            success: function (response) {
                alert("success");
            },
            error: function (error) {
                alert("There was an error posting the data to the server: " + error.responseText);
            }
        });
    });
});

</script>
</html>