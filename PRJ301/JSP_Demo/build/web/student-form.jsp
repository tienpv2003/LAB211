<%-- 
    Document   : student-form
    Created on : 22 thg 12, 2023, 14:35:10
    Author     : bravee06
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <form action="student-response.jsp" >
        <%--Input dang text--%>
        Name: <input type="text" name="name"><br>
        <%--Dạng drop list  --%>
        Country: 
        <select name="country">
            <option>Vietnam</option>
            <option>USA</option>
            <option>China</option>
            <option>England</option>
        </select>

        <%--Có duy nhất 1 lựa chọn--%>
        <!--        Favorite Programming Languges:
                <input type="radio" name="favoriteLangs" value="java">Java
                <input type="radio" name="favoriteLangs" value="C">C
                <input type="radio" name="favoriteLangs" value="javascript">Javascript-->

        <%--Có nhiều lựa chọn--%>
        Favorite Programming Languges:
        <input type="checkbox" name="favoriteLangs" value="java">Java
        <input type="checkbox" name="favoriteLangs" value="C">C
        <input type="checkbox" name="favoriteLangs" value="javascript">Javascript
        <input type="submit" value="Choose">


    </form>
</html>
