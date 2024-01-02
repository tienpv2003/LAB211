
<form action="login-form.jsp">
    Username:<input type="text" name="username" value="${cookie.username.getValue()}">
    Password:<input type="text" name="password" value="${cookie.password.getValue()}">
    Remember me:<input type="checkbox" name="remember" value="Remember">
    <input type="submit" value="submit">
    
</form>
    
<%
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  String rem = request.getParameter("remember");
  //khi tick vao remmembner thi them cookie
  if(rem!=null){
    //khoi tao cookie cho tk va mk
    Cookie usernameCookie = new Cookie("username", username);
    Cookie passwordCookie = new Cookie("password",password);
    //set thoi gian song cho cookie
    usernameCookie.setMaxAge(60*60*24*90); // 3 months
    passwordCookie.setMaxAge(60*60*24*90); // 3 months
    //chuyen huong cookie
    response.addCookie(usernameCookie);
    response.addCookie(passwordCookie);
  }else{
    //neu khong tick vao remmember thi ntn:
    //tao mang cookie
    Cookie[] cookies = request.getCookies();
    //Chay vong lap cookie de set tat ca cookie bang 0
    for(Cookie c : cookies){
        //neu cookie trung voi username hoac password xoa bang 2 cach:
        if(c.getName().equals("username") || c.getName().equals("password")){
        //1. cho Value bang "" 
        c.setValue("");
        //2. cho thoi gian song bang  0
        c.setMaxAge(0);
        response.addCookie(c);
    }
    }    
  }
  
  //Display 
  out.print(username);
  %>
  <br>
  <%
  out.print(password);
  %>
  <br>
  <%
  out.print(rem);  
%>


















