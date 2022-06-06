<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.tms.sweater.model.UserRole" %>
<html>
<head>
    <title>Post</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>
    <div class="form-floating">
        <div class="container">
            <div class="row justify-content-center">
                <%-- add --%>
                <div class="col-sm-3">
                    <form class="text-center" action="/addPost" method="post">
                        <br>
                        <h3 class="text-center">Add Post</h3>
                        <input type="text" name="text" required placeholder="text">
                        <br><br>
                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                            <input type="text" name="userName" required placeholder="userName">
                            <br><br>
                        </c:if>
                        <button type="submit" class="btn btn-success">add</button>
                    </form>
                    <br>
                    <%-- edit --%>
                    <form class="text-center" action="/editPost" method="post">
                        <br>
                        <h3 class="text-center">Edit Post</h3>
                        <input type="text" name="text" required placeholder="text">
                        <br><br>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                        <input type="text" name="userName" required placeholder="userName">
                            <br><br>
                        </c:if>
                        <button type="submit" class="btn btn-warning">edit</button>
                    </form>
                    <%-- print pesult --%>
                    <% if (request.getAttribute("getText") != null) { %>
                        <div class="alert alert-success" role="alert">
                            <% out.print (request.getAttribute("getText")); %>
                        </div>
                    <% } %>
                </div>
                <%-- delete --%>
                <div class="col-sm-3">
                    <form class="text-center" action="/deletePost" method="post">
                        <br>
                        <h3 class="text-center">Delete Post</h3>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                            <input type="text" name="userName" required placeholder="userName">
                            <br><br>
                        </c:if>
                        <button type="submit" class="btn btn-danger">delete</button>
                    </form>
                    <%-- publish --%>
                    <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                        <form class="text-center" action="/checkPublish" method="post">
                            <br>
                            <h3 class="text-center">Publish Post</h3>
                            <input type="number" name="idPost" required placeholder="idPost">
                             <br><br>
                            <input type="text" name="userName" required placeholder="userName">
                            <br><br>
                            <button type="submit" class="btn btn-primary">publish</button>
                            <br><br>
                        </form>
                    </c:if>
                    <br>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
