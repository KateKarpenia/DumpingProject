<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%--<%@include file="/jsp/common/includes/set_language.jsp"%>--%>
<body>
	<div id="categories_header">
		<br>
		<fmt:message key="heading.login" />
	</div>
	<form id="form_id">
		<input type="hidden" name="login" value="/login" />

		<table>
			<tr>
				<td><fmt:message key="message.email"></fmt:message></td>
				<%--<td><input type="email" name="email" /></td>--%>

				<td><input id="inputEmail"
					   class="form-control"
					   type="email"
					   name="email"
					   value="${user.email}"
					   placeholder="Email address"
					   required autofocus>
				</td>
			</tr>
			<tr>
				<td><fmt:message key="message.password"></fmt:message></td>
				<%--<td><input type="password" name="password" /></td>--%>
				<td>
					<input id="inputPassword"
						   class="form-control"
						   type="password"
						   name="password"
						   value="${user.password}"
						   placeholder="Password"
						   required>
				</td>
			</tr>

			<p>${errorLoginOrPassword}</p>

			<tr>
				<td><input type="submit" id="button"
						   onclick="return validate('form_id','inputEmail');"
					value="<fmt:message key="button.login" ></fmt:message>"></input></td>
			</tr>
			<tr>
				<td colspan="2">${checkAuthentication}${fillall}</td>
			</tr>
		</table>
	</form>
</body>
</html>