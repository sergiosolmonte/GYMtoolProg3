<%--
  Created by IntelliJ IDEA.
  User: soke
  Date: 17/02/21
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ include file= "/base.jsp"%>
<%--<head>--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>--%>

<%--    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>--%>
<%--    <script src="${pageContext.request.contextPath}/resources/static/survey.js" type="text/javascript"></script>--%>
<%--</head>--%>
<%--<div class="question-container"></div>--%>
<%--<a id="backBtn" href="#" class="button"><< Back</a>--%>
<%--<a id="nextBtn" href="#" class="button">Continue >></a>--%>

<head>
    <title>Bootstrap Material theme, jQuery Survey Library Example</title><meta name="viewport" content="width=device-width"/>
    <script src="https://unpkg.com/jquery"></script>
    <script src="https://unpkg.com/survey-jquery@1.8.31/survey.jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
    <script>
        $(document).ready(function () {
            $('body').bootstrapMaterialDesign();
        });
    </script>

</head>
<body>
<div id="surveyElement" style="display:inline-block;width:100%;height: 60%"></div>
<form action="editorPro" method="post">
    <div id="surveyResult" style="display: none"></div>
<input type="text" id="myResult" name="survey" style="display: none">
<script src="${pageContext.request.contextPath}/resources/static/survey.js" type="text/javascript"></script>

<input id="doEditorPro" type="submit" style="display: none" value="Crea">
</form>
</body>