<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">

            <div class="col-sm-3">
                <form class="position-absolute top-50 start-50 translate-middle" action="/registration" method="post"><%-- confirmation --%>
                    <br>
                    <h3 class="text-center">Registration</h3>
                    <br>
                    <input type="text" name="name" required placeholder="name">
                    <br><br>
                    <input type="text" name="login" required placeholder="login">
                    <br><br>
                    <input type="text" name="password" required placeholder="password">
                    <br><br>
                    <div class="text-center">
                        <button type="submit" class="btn btn-secondary">ok</button>
                    </div>

                    <% if (request.getAttribute("getText") != null) { %>
                        <div class="alert alert-success" role="alert">
                            <% out.print (request.getAttribute("getText")); %>
                        </div>
                    <% } %>
                </form>
            </div>

        </div>
    </div>
</body>
</html>
