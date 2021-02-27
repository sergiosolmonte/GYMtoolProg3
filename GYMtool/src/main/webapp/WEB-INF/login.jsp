<%@ include file= "/base.jsp"%>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>
</head>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
    <!-- Icon -->
    <div class="fadeIn first">
      <img src=<c:url value="/resources/static/images/user.png"/> id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form action="login" method="post">
        <input type="text" class="fadeIn second" name="username" placeholder="username">
        <input type="password" class="fadeIn third" name="password" placeholder="password">
        <div class="fadeIn fourth">
            <p href="#" class="left" >Forgot Password?</p>
            <p class="right">
                <input type="checkbox" checked="checked" name="remember"> Remember me
            </p>
        </div>
        <div class="center" >
            <input type="submit" class="fadeIn fifth" value="login">
        </div>
    </form>
    <div id="formFooter">
        <p>New user?<a class="underlineHover" href="registration">Click to register!</a></p>
    </div>
  </div>
</div>
<%--<p>risukltato:${risultato}</p>--%>
<%--<script src="<c:url value="/resources/static/functions.js"/>" type="text/javascript"></script>--%>