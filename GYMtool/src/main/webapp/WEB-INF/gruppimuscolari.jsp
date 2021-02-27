<%@ include file= "/base.jsp"%>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>
</head>
<div class="row">
    <div class="div1 side-menu" id="side-muscle" style="width: 200px">
        <div id="accordion wrapper">
            <c:forEach items="${categorie}" var= "c">
                <div class="card">
                    <div class="card-header ">
                        <a class="collapsed card-link " data-toggle="collapse" href="#collapse${c.get().getID()}">
                            <h4 class="muscle" id="${c.get().getID()}"> ${c.get().getNome()} </h4>
                        </a>
                    </div>
                    <c:forEach items="${esercizi}" var= "e">
                        <c:if test="${c.get().getID()==e.get().getCategoria()}">
                            <div id="collapse${c.get().getID()}" class="collapse" >
                                <div class="card-body">
                                    <div>
                                        <a >${e.get().getNome()}<span style="display:none">${e.get().getID()}</span></a>
                                        <img class="icon-navBar" src=<c:url value="/resources/static/images/exImage/${e.get().getID()}.png"/>>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="div2 ">
        <p ><h3 style="padding-left: 37%; width:100%">Discover your body!</h3></p>
<%--        <p>${pageContext.request.contextPath}</p>--%>
        <div><img style="display: block"class="gruppi_muscolari" src=<c:url value="/resources/static/images/muscoliSpento.png"/>></div>
    <c:forEach items="${esercizi}" var= "e">
        <div id="overlay" class="${e.get().getID()}" style="display: none">
            <i class="far fa-times-circle closePopUp" ></i>
            <span>${e.get().getDescrizione()}</span>
        </div>
    </c:forEach>
    </div>
</div>

<script src="<c:url value="/resources/static/functions.js"/>" type="text/javascript"></script>