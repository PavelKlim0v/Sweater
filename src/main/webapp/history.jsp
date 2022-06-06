<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="by.tms.sweater.model.UserRole" %>
<html>
<head>
    <title>History</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-5">
                <%-- get history --%>
                <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                    <form class="text-center" action="/postHistory" method="post">
                        <br>
                        <h4 class="text-center">Get history</h4>
                        <input type="text" name="userName" placeholder="userName">
                        <br><br>
                        <button type="submit" class="btn btn-success">get</button>
                    </form>
                    <%-- print pesult --%>
                    <% if (request.getAttribute("getText") != null) { %>
                        <div class="alert alert-success" role="alert">
                            <% out.print (request.getAttribute("getText")); %>
                        </div>
                    <% } %>
                </c:if>
                <%-- show history --%>
                <form class="text-center" action="/postHistory" method="get">
                    <c:if test="${user.role == UserRole.USER_ROLE}">
                        <br>
                        <h4 class="text-center">The post is being processed</h4>
                    </c:if>
                    <ul>
                        <br>
                        <div class="alert alert-success" role="alert">
                            <c:forEach var="post" items="${requestScope.all}">
                                <li>${post}</li>
                            </c:forEach>
                        </div>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
