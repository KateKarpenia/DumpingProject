<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Bundle" var="loc"/>
<fmt:message bundle="${loc}" key="heading.login" var="m_signin"/>
<%--<fmt:message bundle="${loc}" key="button.home" var="m_home"/>--%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
    <div class="container">

        <s:url value="/j_spring_security_check" var="loginUrl"/>
        <sf:form id="form_id"
            name="loginForm"
            class="form-signin"
            action="${loginUrl}"
            modelAttribute="user"
            method="post">
            <table>
                <h2 class="form-signin-heading"><c:out value="${m_signin}"/></h2>
                <p id='result'></p>

                <tr>
                <td><label for="inputEmail" class="sr-only">Email address</label></td>
                <td><sf:input id="inputEmail"
                    class="form-control"
                    path="email"
                    type="email"
                    name="j_email"
                    value="${user.email}"
                    placeholder="Email address"
                    required="autofocus"/></td>
                </tr>

                <tr>
                <td><label for="inputPassword" class="sr-only">Password</label></td>
                <td><sf:input id="inputPassword"
                       class="form-control"
                       path="password"
                       type="password"
                       name="j_password"
                       value="${user.password}"
                       placeholder="Password"
                       required=""/></td>
                </tr>

                <p>${requestScope.errorLoginOrPassword}</p>

                <tr>
                <td><button id="button_submit"
                        type="submit"
                        onclick="return validate('form_id','inputEmail');">
                    Sign in
                </button></td><br>

                <td><label for="remember_me" class="inline">Remember me</label>
                <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/></td>

                </tr>
                    <%--<tr>--%>
                    <%--<td>--%>
                        <%--<a href="<c:url value="/main" />">--%>
                             <%--<input type="submit" id="button"--%>
                                <%--value="${m_home}" />--%>
                        <%--</a>--%>
                    <%--</td>--%>
                    <%--</tr>--%>


            </table>
        </sf:form>

    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <%--<script src="${pageContext.request.contextPath}/assets/js/jquery-2.2.4.min.js"></script>--%>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/assets/js/validator.js"></script>

</body>
</html>