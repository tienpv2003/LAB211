<%
    
    // read form data
    String fruit = request.getParameter("fruit");
    
    // create the cookies
    Cookie theCookie =new Cookie("fruits", fruit);
    

    // set the life of cookies
    theCookie.setMaxAge(60*60*24*365); // for one year
    
    // send cookie to browser
    response.addCookie(theCookie);
%>

<body>
    Fruit: ${param.fruit}
    <br></br>
    <a href="cookie-homepage.jsp" >Return homepage</a>
</body>