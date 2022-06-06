<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.tms.sweater.model.UserRole" %>
<html>
<head>
    <title>Comment</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>
    <div class="form-floating">
        <div class="container">
            <div class="row justify-content-center">
                <%-- add --%>
                <div class="col-sm-3">
                    <form class="text-center" action="/addComment" method="post">
                        <br>
                        <h3 class="text-center">Add Comment</h3>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <input type="text" name="text" required placeholder="text">
                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                            <br><br>
                            <input type="text" name="userName" required placeholder="userName">
                        </c:if>
                        <br> <br>
                        <button type="submit" class="btn btn-success">add</button>
                    </form>
                </div>
                <%-- edit --%>
                <div class="col-sm-3">
                    <form class="text-center" action="/editComment" method="post">
                        <br>
                        <h3 class="text-center">Edit Comment</h3>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <input type="number" name="idComment" required placeholder="idComment">
                        <br><br>
                        <input type="text" name="text" required placeholder="text">
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
                    <form class="text-center" action="/deleteComment" method="post">
                        <br>
                        <h3 class="text-center">Delete Comment</h3>
                        <input type="number" name="idPost" required placeholder="idPost">
                        <br><br>
                        <input type="number" name="idComment" required placeholder="idComment">
                        <br><br>
                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                            <input type="text" name="userName" required placeholder="userName">
                            <br><br>
                        </c:if>
                        <button type="submit" class="btn btn-danger">delete</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

