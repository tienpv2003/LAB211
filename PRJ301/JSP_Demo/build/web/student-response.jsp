Name:
<%=
request.getParameter("name")
%>
<br>
Country:
<%=
request.getParameter("country")
%>
<br>
Favorite languages:
<%  
    //Tao mot mang de luu cac gia tri da tron
    String[] langs = request.getParameterValues("favoriteLangs");
    
    //Vong lap in ra tat ca gia tri trong mang da luu
    for(String i: langs){
        out.print("<ul>");
        out.print("<li>"+ i +"</li>");
        out.print("</ul>");
    }

%>

