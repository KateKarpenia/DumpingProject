<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Bundle" var="loc"/>
<fmt:message bundle="${loc}" key="category.calendars" var="m_calendars"/>
<fmt:message bundle="${loc}" key="category.souvenirs" var="m_souvenirs"/>
<fmt:message bundle="${loc}" key="category.printing" var="m_printing"/>
<fmt:message bundle="${loc}" key="category.promostands" var="m_promostands"/>
<fmt:message bundle="${loc}" key="category.event" var="m_event"/>
<fmt:message bundle="${loc}" key="category.other" var="m_other"/>

<html>
<%--<%@include file="/jsp/common/includes/set_language.jsp"%>--%>
<body>
	<div id="categories_header">
		<br>
		<fmt:message key="heading.categories" />
	</div>
	<div id="categories">
		<%--<form action="Controller" method="post">--%>
			<%--<input type="hidden" name="page" value="category" /><input--%>
				<%--type="hidden" name="type" value="all" /><input type="hidden"--%>
				<%--name="num" value="1" /> <input type="submit" id="category"--%>
				<%--value="<fmt:message key="category.all"/>" />--%>
		<%--</form>--%>

			<%--<form action="/category" method="get">--%>

				<%--<input type="hidden" name="selectedCategoryId" value="1"/>--%>
				<%--<input type="hidden" name="num" value="1" />--%>
				<%--<input type="submit" id="category" value="<fmt:message key="category.souvenirs"/>" />--%>
			<%--</form>--%>

			<%--<form action="Controller" method="post">--%>
				<%--<input type="hidden" name="command" value="category_view" /><input--%>
					<%--type="hidden" name="selectedCategoryId" value="1"/><input type="hidden"--%>
																			  <%--name="num" value="1" /> <input type="submit" id="category"--%>
																											 <%--value="<fmt:message key="category.souvenirs"/>" />--%>
			<%--</form>--%>



			<%--<ul>--%>
			<%--<c:forEach var="category" items="${categoryList}">--%>
				<%--<li>--%>
					<%--<a type="submit" id="category" href="<c:url value="/category">--%>
                            <%--<c:param name="selectedCategoryId" value="${category.id}"></c:param>--%>
                        <%--</c:url>" >--%>
						<%--<c:out value="${category.category}" />--%>
					<%--</a>--%>
				<%--</li>--%>
			<%--</c:forEach>--%>
			<%--</ul>--%>



			<ul>
					<li>
							<%--<input type="submit" id="category">--%>
						<a type="submit" id="category" href="<c:url value="/category">
                            <%--<c:param name="selectedCategoryId" value="1" />--%>
                            <c:param name="selectedCategoryId" value="1"></c:param>
                        </c:url>" >
							<c:out value="${m_souvenirs}" />
								<%--<input type="submit" id="category">--%>
						</a>
							<%--</input>--%>
					</li>
			</ul>

			<ul>
				<li>
					<a type="submit" id="category" href="<c:url value="/category">
                            <c:param name="selectedCategoryId" value="2"></c:param>
                        </c:url>" >
						<c:out value="${m_calendars}" />
					</a>
				</li>
			</ul>

			<ul>
				<li>
					<a type="submit" id="category" href="<c:url value="/category">
                            <c:param name="selectedCategoryId" value="3"></c:param>
                        </c:url>" >
						<c:out value="${m_printing}" />
					</a>
				</li>
			</ul>

			<ul>
				<li>
					<a type="submit" id="category" href="<c:url value="/category">
                            <c:param name="selectedCategoryId" value="4"></c:param>
                        </c:url>" >
						<c:out value="${m_promostands}" />
					</a>
				</li>
			</ul>

			<ul>
				<li>
					<a type="submit" id="category" href="<c:url value="/category">
                            <c:param name="selectedCategoryId" value="5"></c:param>
                        </c:url>" >
						<c:out value="${m_event}" />
					</a>
				</li>
			</ul>

			<ul>
				<li>
					<a type="submit" id="category" href="<c:url value="/category">
                            <c:param name="selectedCategoryId" value="6"></c:param>
                        </c:url>" >
						<c:out value="${m_other}" />
					</a>
				</li>
			</ul>




			<%--<form id="category">--%>
				<%--&lt;%&ndash;<input type="hidden" name="category" value="/category" />&ndash;%&gt;--%>
				<%--&lt;%&ndash;<input type="hidden" value="/category" />&ndash;%&gt;--%>
				<%--&lt;%&ndash;<input type="hidden" name="selectedCategoryId" value="1" />&ndash;%&gt;--%>
				<%--&lt;%&ndash;<input type="hidden" name="num" value="1" />&ndash;%&gt;--%>


					<%--<input type="submit" id="category" value="${m_souvenirs}" />--%>




			<%--</form>--%>


			<%--<form>--%>
			<%--<input type="hidden" name="page" value="category" />--%>
				<%--<input type="hidden" name="category" value="/category" />--%>
				<%--<input type="hidden" name="selectedCategoryId" value="2" />--%>
				<%--<input type="hidden" name="num" value="1" />--%>
				<%--<input type="submit" id="category" value="${m_calendars}" />--%>
			<%--</form>--%>

			<%--<form>--%>
				<%--<input type="hidden" name="page" value="category" />--%>
				<%--<input type="hidden" name="category" value="/category" />--%>
				<%--<input type="hidden" name="selectedCategoryId" value="3" />--%>
				<%--<input type="hidden" name="num" value="1" />--%>
				<%--<input type="submit" id="category" value="${m_printing}" />--%>
			<%--</form>--%>

			<%--<form>--%>
				<%--<input type="hidden" name="page" value="category" />--%>
				<%--<input type="hidden" name="category" value="/category" />--%>
				<%--<input type="hidden" name="selectedCategoryId" value="4" />--%>
				<%--<input type="hidden" name="num" value="1" />--%>
				<%--<input type="submit" id="category" value="${m_promostands}" />--%>
			<%--</form>--%>

			<%--<form>--%>
				<%--<input type="hidden" name="page" value="category" />--%>
				<%--<input type="hidden" name="category" value="/category" />--%>
				<%--<input type="hidden" name="selectedCategoryId" value="5" />--%>
				<%--<input type="hidden" name="num" value="1" />--%>
				<%--<input type="submit" id="category" value="${m_event}" />--%>
			<%--</form>--%>

			<%--<form>--%>
				<%--<input type="hidden" name="page" value="category" />--%>
				<%--<input type="hidden" name="category" value="/category" />--%>
				<%--<input type="hidden" name="selectedCategoryId" value="6" />--%>
				<%--<input type="hidden" name="num" value="1" />--%>
				<%--<input type="submit" id="category" value="${m_other}" />--%>
			<%--</form>--%>


		<%--<form action="Controller" method="post">--%>
			<%--<input type="hidden" name="command" value="category_view" /><input--%>
				<%--type="hidden" name="selectedCategoryId" value="3" /><input type="hidden"--%>
				<%--name="num" value="1" /> <input type="submit" id="category"--%>
				<%--value="<fmt:message key="category.printing"/>" />--%>
		<%--</form>--%>
		<%--<form action="Controller" method="post">--%>
			<%--<input type="hidden" name="command" value="category_view" /><input--%>
				<%--type="hidden" name="selectedCategoryId" value="4" /><input type="hidden"--%>
				<%--name="num" value="1" /> <input type="submit" id="category"--%>
				<%--value="<fmt:message key="category.promostands" />" />--%>
		<%--</form>--%>
		<%--<form action="Controller" method="post">--%>
			<%--<input type="hidden" name="command" value="category_view" /><input--%>
				<%--type="hidden" name="selectedCategoryId" value="5" /><input type="hidden"--%>
				<%--name="num" value="1" /> <input type="submit" id="category"--%>
				<%--value="<fmt:message key="category.event" />" />--%>
		<%--</form>--%>
		<%--<form action="Controller" method="post">--%>
			<%--<input type="hidden" name="command" value="category_view" /><input--%>
				<%--type="hidden" name="selectedCategoryId" value="6" /><input type="hidden"--%>
				<%--name="num" value="1" /> <input type="submit" id="category"--%>
				<%--value="<fmt:message key="category.other"/>" />--%>
		<%--</form>--%>




	</div>
</body>
</html>