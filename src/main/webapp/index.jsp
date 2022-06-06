<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>
    <c:if test="${user == null}">
        <div class="container position-absolute top-50 start-50 translate-middle">
            <h1>
                <p class="text-center">Welcome!</p>
            </h1>
        </div>
    </c:if>
</body>
</html>

