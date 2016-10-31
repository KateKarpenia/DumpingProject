<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Bundle" var="loc"/>
<fmt:message bundle="${loc}" key="message.site_title" var="m_title"/>

<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%--<title><fmt:message key="message.site_title" /></title>--%>
    <title><c:out value="${m_title}"/></title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/css.css">
</head>

</html>