<%@include file="../user.jsp"%>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>

</head>

<h2 id="descriptionApp"> <a href="javascript:history.back()"> <i class="fas fa-arrow-alt-circle-left" ></i> </a>${sessionScope.nomeScheda}</h2>
<div class="pluto"><span style="display:none">${sessionScope.schedaID}</span></div>
<div id="printTable" class="container">
    <div class="div2">
        <div class="content">
            <div id="leftA" onclick=scrollLeft1()>
                <i class=" leftA fas fa-chevron-left fa-2x"></i>
            </div>
            <div id="rightA" onclick=scrollRight1()>
                <i class=" rightA fas fa-chevron-right fa-2x"></i>
            </div>
            <div id="pippo">

            </div>
        </div>
    </div>
</div>
<script>
    var json = ${sessionScope.JSON};
    // var pippo = JSON.parse(json);
    console.log("IL JSON:"+json[0].name);
    createTable(json);

</script>