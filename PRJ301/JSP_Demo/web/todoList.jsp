<!-- Import doi tuong -->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!-- Form (HTML) input and submit-->
<form action="todoList.jsp" method="post">
    Add new item: <input type="text" name="todo">
    <input type="submit" value="Print">
</form>

<!-- Add item (Java)-->
<% 
    String item = request.getParameter("todo");
    
    // nhan du lieu danh sach items cua session 
    List<String> items = (List<String>) session.getAttribute("myToDoList");
    
    // neu doi tuong session myToDoList chua ton tai thi tao moi 
    
    if(items == null){
        items = new ArrayList<String>();
        session.setAttribute("myToDoList", items);
    }
    
    // neu nhan duoc yeu cau add item 
    if(item != null){
        items.add(item);
    }
    
%>

<!-- Display -->
<h1>To do list items</h1>
<%
  session.setMaxInactiveInterval(3);//set thoi gian ton tai cua session toi da la  bao nhieu giay
  for(String todo : items)
  {
    out.print("<li>"+todo+"</li>");
   }
   
%>

