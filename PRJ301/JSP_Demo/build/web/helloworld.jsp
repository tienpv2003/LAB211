<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color:greenyellow">Hello World!</h1>
        The time on the server is <%= new java.util.Date() %>
        
        <br></br>
        25 * 4 <%= 25 * 4 %>
        <br></br>
        3 < 5 ? <%= 3 < 5 %>
        
        Converting a string to uppercase: <%= new String("Hello world").toUpperCase() %>
        
    </body>
</html>
