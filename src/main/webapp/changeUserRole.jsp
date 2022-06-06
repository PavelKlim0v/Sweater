<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>ChangeUserRole</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>
    <div class="container">
        <%-- show users --%>
        <div class="row justify-content-center">
            <div class="col-sm-5">
                <form class="text-center" action="/changeUserRole" method="get">
                    <ul>
                        <br>
                        <div class="alert alert-success" role="alert">
                            <c:forEach var="post" items="${requestScope.all}">
                                <li>${post}</li>
<%--                                <fmt:formatDate type="both" value="${now}"/>--%>
                            </c:forEach>
                        </div>
                    </ul>
                </form>
            </div>
        </div>
        <%-- change role --%>
        <div class="form-floating">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-sm-3">
                        <form class="text-center" action="/changeUserRole" method="post">
                            <br>
                            <h4 class="text-center">Role improvement</h4>
                            <input type="text" name="userName" required placeholder="enter login">
                            <br><br>
                            <button type="submit" class="btn btn-success">change</button>
                        </form>
                    </div>
                    <%-- print pesult --%>
                    <div class="col-sm-1 text-center">
                        <% if (request.getAttribute("getText") != null) { %>
                            <div class="alert alert-success" role="alert">
                                <% out.print (request.getAttribute("getText")); %>
                            </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
