<!-- read data by cookie -->

<%
    // no cookie set default fruit
    String fruitDefault = "Cam";
    // get the cookie from browser request
    Cookie[] cookies = request.getCookies();

    // find the our cookie
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("fruits"))
            {
               fruitDefault = cookie.getValue();
            }
        }
    }
%>
<!-- Display fruit -->
<h1> Fruit in browser: <%= fruitDefault %>
