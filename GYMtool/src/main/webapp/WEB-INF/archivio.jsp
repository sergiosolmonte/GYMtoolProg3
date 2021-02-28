<%@include file="user.jsp"%>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>
<%--    <script src="<c:url value="/resources/static/functions.js"/>" type="text/javascript"></script>--%>

</head>
<div class="container-fluid divPage">
    <div class="container">
        <h2 class="great">Workout Programs</h2>
        <div class="list-group programCont">
            <c:forEach items="${schede}" var= "s">
            <div id="program" class="clickResult">
                <a href="archivio/viewProgram?ID=${s.get().getID()}">    <!-- viewProgram<id>-->

                    <div class="programName">
                        <div style="width:90%;float:left;color:#ff5600"class="list-group-item list-group-item-action">${s.get().getNome()}</div>
                        <div class="pluto"><span style="display:none">${s.get().getID()}</span></div>
                        <div class="rightIcon"><i class="fas fa-arrow-right"></i></div>
                    </div>
                </a>
               
            </div>
            </c:forEach>
        </div>
    </div>
</div>
