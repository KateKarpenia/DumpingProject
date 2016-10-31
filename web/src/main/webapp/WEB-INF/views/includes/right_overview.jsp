<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Bundle" var="loc"/>
<fmt:message bundle="${loc}" key="heading.welcome" var="m_welcome"/>
<fmt:message bundle="${loc}" key="message.slogen" var="m_slogen"/>

<html>
<%--<%@include file="/jsp/common/includes/set_language.jsp"%>--%>
<body>
	<div id="categories_header">
		<br>
		<fmt:message key="${m_welcome}" />
	</div>
	<div id="teaser">
		<fmt:message key="${m_slogen}" />
	</div>
</body>
</html>

