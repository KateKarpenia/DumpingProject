<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%--<%@include file="/jsp/common/includes/set_language.jsp"%>--%>
<%--<%@include file="/jsp/common/includes/pagination.jsp"%>--%>
<body>
	<div id="categories_header">
		<br>
		<fmt:message key="heading.catalogue" />
	</div>

	<table width="100%" align="left">
		<%--<c:forEach var="goods" items="${catalogue}">--%>
			<%--<c:if test="${userType != 'USER'}">--%>
			<%--<c:if test="${userType != 'ADMIN'}">--%>
			<c:forEach var="product" items="${productList}">

				<li>
					<a type="submit" id="button" href="<c:url value="/bodytext">
                        <%--<c:param name="bodytext" value="/bodytext" />--%>
                        <c:param name="selectedProductId" value="${product.id}" />
                    </c:url>" >
						<c:out value="${product.name}"/>
					</a>
				</li>
				<li>
					<c:out value="${product.description}"/>
						<%--<c:out value="HELLO"/>--%>
				</li>

			<%--<tr>--%>
				<%--<td><img alt="${goods.photo}"--%>
					<%--src="${pageContext.request.contextPath}${goods.photo}"--%>
					<%--width="150px"></td>--%>
				<%--<td>${goods.title}</td>--%>
				<%--<td>${goods.price}</td>--%>
					<%--<td>${product.name}</td>--%>
					<%--<td>${product.description}</td>--%>
				<%--<td><form action="Controller" method="post">--%>
						<%--<input type="hidden" name="page" value="goods_details" /><input--%>
							<%--type="hidden" name="id" value="${goods.goodsId }" /> <input--%>
							<%--type="submit" id="button"--%>
							<%--value="<fmt:message key="button.details"></fmt:message>" />--%>
					<%--</form></td>--%>
			<%--</tr>--%>
		</c:forEach>
			<%--</c:if>--%>
	</table>

	<div id="footer_section">
		<jsp:include page="/jsp/common/includes/pagination.jsp" /></div>
	</div>

	<%--<center>--%>
		<%--<table>--%>
			<%--<tr>--%>

				<%--<c:import url="pagination.jsp"/>--%>

				<%--<c:forEach begin="1" end="${pages}" varStatus="loop">--%>
					<%--<td><form action="Controller" method="post">--%>
							<%--<input type="hidden" name="page" value="category" /><input--%>
								<%--type="hidden" name="type" value="${type}" /><input--%>
								<%--type="hidden" name="num" value="${loop.index}" /> <input--%>
								<%--type="submit" id="num" value="${loop.index}" />--%>
						<%--</form></td>--%>
				<%--</c:forEach>--%>
			<%--</tr>--%>
		<%--</table>--%>
	<%--</center>--%>
</body>
</html>