<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="en_AU"></fmt:setLocale>
<%--!
     set Locale o Viet Nam:
<fmt:setLocale value="vi_VN"></fmt:setLocale> --%>

<fmt:setBundle basename="./resources.mylables" var="lang"/>

<fmt:message key="label.greeting"></fmt:message>
    <br>
<fmt:message key="label.firstname"></fmt:message>
    <br>
<fmt:message key="label.lastname"></fmt:message>
    <br>
<fmt:message key="label.welcome"></fmt:message>
<br>