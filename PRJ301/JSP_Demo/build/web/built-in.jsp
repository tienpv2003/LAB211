<%-- 
    Document   : built-in
    Created on : 14 thg 12, 2023, 15:24:08
    Author     : bravee06
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
       Request user agent: <%= request.getHeader("User-Agent") %>
       <br>
       Language <%= request.getLocale() %>
                
    </body>
</html>
