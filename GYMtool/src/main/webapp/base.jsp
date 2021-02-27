<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script type="application/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="application/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <script type="application/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script type="application/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/js-cookie/2.2.1/js.cookie.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/static/functions.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-md nav-color">
    <a class="navbar-brand color-text" href="pages/index"><div class="logo"></div></a>
    <button class="navbar-toggler custom-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon custom-toggler"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav ml-auto">
            <li id="link5" class="nav-item">
                <a  class="nav-link link-color"  href="pages/editorPro">EditorPro</a>
            </li>
            <li id="link1" class="nav-item">
                <a  class="nav-link link-color"  href="pages/editor">Editor</a>
            </li>
            <li id="link2" class="nav-item">
                <a  class="nav-link link-color" href="pages/gruppimuscolari">Gruppi Muscolari</a>
            </li>
            <c:choose>
                <c:when test= "${sessionScope.userName == null}">
                <li id="link3" class="nav-item">
                    <a  class="nav-link link-color" href="pages/login">myGYMtool</a>
                </li>
            </c:when>
            <c:otherwise>
                <li id="link4" class="nav-item">
                    <a  class="nav-link link-color" href="pages/profile">Hi,  ${sessionScope.userName}</a>
                </li>
            </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
</body>

</html>
