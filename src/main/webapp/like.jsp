<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Like</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>
    <div class="form-floating">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-3">
                    <%-- add --%>
                    <form class="text-center" action="/addLike" method="post">
                        <br>
                        <h3 class="text-center">Add Like</h3>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <input type="text" name="userName" placeholder="userName">
                        <br><br>
                        <button type="submit" class="btn btn-success">add</button>
                    </form>
                    <br>
                    <%-- delete --%>
                    <form class="text-center" action="/deleteLike" method="post">
                        <br>
                        <h3 class="text-center">Delete Like</h3>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <input type="text" name="userName" placeholder="userName">
                        <br><br>
                        <button type="submit" class="btn btn-danger">delete</button>
                    </form>
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
