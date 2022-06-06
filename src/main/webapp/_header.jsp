<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="by.tms.sweater.model.UserRole" %>
<html>
<head>
    <title>Header</title>
    <link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <%-- img sweater --%>
            <img src="https://flomaster.club/uploads/posts/2020-06/1593114736_1-p-raskraski-sviter-3.jpg" height="70px" width="70px">
            <%-- pannel collapse --%>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <%-- pannel button --%>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/">Home</a>
                    </li>
                    <c:if test="${user == null}">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/authorization">Authorization</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/registration">Registration</a>
                        </li>
                    </c:if>
                    <c:if test="${user != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/addPost">Post</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/addComment">Comment</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/addLike">Like</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/postHistory">History</a>
                        </li>
                        <c:if test="${user.role == UserRole.ADMIN_ROLE}">
                            <li class="nav-item">
                                <a class="nav-link" href="/changeUserRole">ChangeUserRole</a>
                            </li>
                        </c:if>
                    </c:if>
                </ul>
                <%-- button logout justify end --%>
                <ul class="nav justify-content-end">
                    <c:if test="${user != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/logout" style="color:gray">Logout</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous">
    </script>
</body>
</html>
