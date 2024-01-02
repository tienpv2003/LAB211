<%-- 
    Document   : declaration-test
    Created on : 14 thg 12, 2023, 14:58:20
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
       <!-- Khai bao mot method -->
       <%! 
       String getString(String data){
           return data.toLowerCase();
       }
       %>
       
       Lower case "HELLO WORLD": <%= getString("HELLO WORLD") %>
    </body>
</html>
