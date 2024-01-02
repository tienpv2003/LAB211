<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.List" %>
<%@page import="model.student" %>

<%
    List<student> students = new ArrayList<>();
    
    students.add(new student("Nguyen Van", "A", true));
    students.add(new student("Tran Thi", "B", false));
    students.add(new student("Pham Van", "C", true));
    
    pageContext.setAttribute("mystudents",students);
%>

<table border="1px">
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
        </tr>
    </thead>   

    <tbody>
        <c:forEach var="tempstudent" items="${mystudents}">
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>