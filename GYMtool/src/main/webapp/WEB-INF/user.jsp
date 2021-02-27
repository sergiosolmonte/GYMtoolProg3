<%@ include file= "/base.jsp"%>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>
</head>


<div class="container-fluid divMenu">
    <nav id="navbar">
<%--        {#            <div class="userAvatar"><img class="profileImage" src="/static/meme_harold.jpg"></div>#}--%>
        <ul class="list-group dark">
            <li class="list-group-item menuOpt dark"><a id="linkA" class="menu-link linked" href="profile"><i class="fas fa-user mr"></i><span>Profilo</span></a></li>
            <li class="list-group-item menuOpt dark"><a id="linkB" class="menu-link linked" href="archivio"><i class="fas fa-folder-open mr"></i><span>Archivio</span></a></li>
            <li class="list-group-item menuOpt dark"><a id="linkC" class="menu-link linked" href="tool"><i class="fas fa-toolbox mr"></i><span>myTool</span></a></li>
            <li class="list-group-item menuOpt dark"><a id="linkD" class="menu-link linked" href="messaggi"><i class="fas fa-comments mr"></i><span>Messaggi</span></a></li>
            <li class="list-group-item menuOpt dark"><a class="menu-link" href="pages/logout"><i class="fas fa-sign-out-alt mr"></i><span>Logout</span></a></li>
        </ul>
    </nav>
</div>

<%--<div class="container-fluid divPage">--%>
<%--    {% block userpage %}--%>

<%--    {% endblock %}--%>
<%--</div>--%>
<%--<script src="<c:url value="/resources/static/functions.js"/>" type="text/javascript"></script>--%>