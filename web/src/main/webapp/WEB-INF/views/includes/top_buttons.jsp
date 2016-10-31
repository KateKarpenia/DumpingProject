<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
    <%--pageEncoding="UTF-8"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Bundle" var="loc"/>
<fmt:message bundle="${loc}" key="button.en" var="m_en"/>
<fmt:message bundle="${loc}" key="button.ru" var="m_ru"/>
<fmt:message bundle="${loc}" key="button.login" var="m_login"/>
<fmt:message bundle="${loc}" key="button.home" var="m_home"/>

<html>
<%--<%@include file="/jsp/common/includes/set_language.jsp"%>--%>
<body>
	<div id="top_buttons">
		<table align="right">
			<tr>
				<%--<td>--%>
					<%--<form action="Controller" method="post">--%>

						<%--<input type="hidden" name="command" value="language" />--%>
						<%--<input--%>
							<%--type="hidden" name="language" value="en" />--%>
						<%--<input type="submit" id="lang_button"--%>
							<%--value='<fmt:message key="button.en"></fmt:message>'>--%>
					<%--</form>--%>

					<%--<a href="?locale=en">--%>
						<%--<input type="submit" id="lang_button"--%>
						<%--&lt;%&ndash;value='<fmt:message key="button.en"></fmt:message>'>&ndash;%&gt;--%>
						<%--&lt;%&ndash;<output lang="button.en" />&ndash;%&gt;--%>
						<%--&lt;%&ndash;<c:out value="button.en" />&ndash;%&gt;--%>
						<%--value="<s:message key="button.en" />">--%>

					<%--</a>--%>

						<%--<form>--%>
					<%--<input type="hidden" name="language" value="en" />--%>
					<%--<input type="submit" id="lang_button"--%>
					<%--value="<fmt:message key="button.en"></fmt:message>--%>
					<%--</form>--%>

					<td>
					<form>
						<%--<input type="submit" id="lang_button" />--%>
						<%--<a href="<c:url value="/${requestScope.currentPage}">--%>
                        <%--<c:param name="language" value="en" />--%>

                     <%--</c:url>">--%>
							<%--<input type="submit" id="lang_button" value="${m_en}"/>--%>
						<%--</a>--%>


							<input type="hidden" name="language" value="en" /> <input
								type="submit" id="lang_button"
								value="${m_en}">
						</form>
					</td>

					<td>
						<form>
							<%--<input type="submit" id="lang_button" />--%>
							<%--<a href="<c:url value="/${requestScope.currentPage}">--%>
                        <%--<c:param name="language" value="ru" />--%>
                     <%--</c:url>">--%>
								<%--<input type="submit" id="lang_button" value="${m_ru}"/>--%>
							<%--</a>--%>


							<input type="hidden" name="language" value="ru" /> <input
								type="submit" id="lang_button"
								value="${m_ru}">
						</form>
					</td>

					<td>
						<div>
							${pageContext.request.userPrincipal.name}
							${pageContext.request.userPrincipal}
								<c:if test="${userType == null}">
									<a href="<c:url value="/login" />">
										<input type="submit" id="button" value="${m_login}"/>
									</a>
								</c:if>


							<%--<input type="hidden" name="login" value="/login" />--%>
								<%--<input type="submit" id="button"--%>
								<%--value="${m_login}" />--%>
						</div>
					</td>

					<td>
						<div>
							<%--<a href="<c:url value="/main" />">--%>
								<%--<input type="submit" id="button" value="${m_home}"/>--%>
							<%--</a>--%>



							<%--<input type="hidden" name="main" value="/main" /> <input--%>
								<%--type="submit" id="button"--%>
								<%--value="${m_home}" />--%>
						</div>
					</td>




				<%--</td>--%>
				<%--<td>--%>
					<%--<form action="Controller" method="post">--%>

						<%--<input type="hidden" name="command" value="language" />--%>
						<%--<input--%>
							<%--type="hidden" name="command" value="ru" />--%>
						<%--<input type="submit" id="lang_button"--%>
							<%--value='<fmt:message key="button.ru"></fmt:message>'>--%>
					<%--</form>--%>
				<%--</td>--%>


					<%--<td>--%>
					<%--<form action="Controller" method="post">--%>
						<%--<input type="hidden" name="command" value="want_login" /> <input--%>
							<%--type="submit" id="button"--%>
							<%--value='<fmt:message key="button.login"></fmt:message>'>--%>
					<%--</form>--%>
				<%--</td>--%>
				<%--<td>--%>
					<%--<form action="Controller" method="post">--%>
						<%--<input type="hidden" name="command" value="want_home" /> <input--%>
							<%--type="submit" id="button"--%>
							<%--value="<fmt:message key="button.home"></fmt:message>">--%>
					<%--</form>--%>
				<%--</td>--%>
			</tr>
		</table>
	</div>
</body>
</html>