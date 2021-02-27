<%--
  Created by IntelliJ IDEA.
  User: soke
  Date: 19/02/21
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ include file= "user.jsp"%>
<%--<%@ taglib prefix="gravatar" uri="http://www.paalgyula.hu/schemas/tld/gravatar" %>--%>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>
</head>
<div class="container-fluid divPage">
<div class="profilePage">
    <div class="container rounded bg-white mt-5" style="border:1px solid #cccccc;margin-top:-40px;margin-bottom: 15%;padding: 0">
        <div class="row">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                    <img class="rounded-circle" width="200px" height="200px" src="https://www.gravatar.com/avatar/${sessionScope.avatar}?d=identicon")>
<%--                    <gravatar:image email="paalgyula@paalgyula.hu" size="64"/>--%>
                    <span class="font-weight-bold">${sessionScope.userName}</span>
                    <p>Username: ${sessionScope.utente.getUsername()}</p>
                    <span class="text-black-50">${sessionScope.utente.getEmail()}</span>
<%--                    ${sessionScope.utente.getEmail()}--%>
                    <span> </span>
                </div>


            </div>
            <div class="col-md-5 border-right"  id="profile" style="height: 90%">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">

                        <h4 class="text-right">Profile </h4>
                        <div class="d-flex justify-content-between align-items-center experience" id="editProfile"><span class="border px-3 p-1 add-experience"><i class="fas fa-cog"></i>&nbsp;Edit</span></div><br>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-6"><label class="labels">Name</label><br><span>${sessionScope.utente.getNome()}</span></div>
                        <div class="col-md-6"><label class="labels">Surname</label><br><span> ${sessionScope.utente.getCognome()} </span></div>
                        <div class="col-md-6"><label class="labels">Birthdate</label><br><span>${sessionScope.utente.getDataNascita()}</span></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">Username</label><br><span>${sessionScope.userName}</span></div>
                        <div class="col-md-12"><label class="labels">Email ID</label><br><span>${sessionScope.utente.getEmail()}</span></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6"><label class="labels">Weight</label><br>
                        <c:choose>
                        <c:when test="${sessionScope.utente.getPeso()!=0.0}">
                            <span>${sessionScope.utente.getPeso()}</span><i>kg</i>
                        </c:when>
                            <c:otherwise>

                            <span> 80</span><i>kg</i>

                            </c:otherwise>
                        </c:choose>
                        </div>
                        <div class="col-md-6"><label class="labels">Height</label><br>
                            <c:choose>
                                <c:when test="${sessionScope.utente.getAltezza()!=0.0}">
                                    <span>${sessionScope.utente.getAltezza()}</span><i>cm</i>
                                </c:when>
                                <c:otherwise>

                                    <span> 170</span><i>cm</i>

                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="col-md-6"><label class="labels">Waiste</label><br>
                            <c:choose>
                                <c:when test="${sessionScope.utente.getVita()!=0.0}">
                                    <span>${sessionScope.utente.getVita()}</span><i>cm</i>
                                </c:when>
                                <c:otherwise>

                                    <span> 70</span><i>cm</i>

                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="col-md-6"><label class="labels">Neck</label><br>
                            <c:choose>
                                <c:when test="${sessionScope.utente.getCollo()!=0.0}">
                                    <span>${sessionScope.utente.getCollo()}</span><i>cm</i>
                                </c:when>
                                <c:otherwise>

                                    <span> 50</span><i>cm</i>

                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-5 border-right"  id="prSetting" style="display: none">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Profile Settings</h4>
                    </div>
                    <form action="profile" method="post">
                    <div class="row mt-2">
                        <div class="col-md-6"><label class="labels">Name</label><input type="text" class="form-control" placeholder="first name" name="nome" value="${sessionScope.utente.getNome()}"></div>
                        <div class="col-md-6"><label class="labels">Surname</label><input type="text" class="form-control" placeholder="surname" name="cognome" value="${sessionScope.utente.getCognome()}"></div>
                        <div class="col-md-6"><label class="labels">Birthdate</label><input type="date" class="form-control"  name="data_nascita" value=${sessionScope.utente.dataNascita}></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">Username</label><br><span>${sessionScope.utente.getUsername()}</span></div>
                        <div class="col-md-12"><label class="labels">Email ID</label><br><span>${sessionScope.utente.getEmail()}</span></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6"><label class="labels">Weight</label><input type="text" class="form-control" placeholder="Weight" name="peso" value=<c:if test="${sessionScope.utente.getPeso()!=0.0}">"${sessionScope.utente.getPeso()}" </c:if>  ><i>kg</i></div>
                        <div class="col-md-6"><label class="labels">Height</label><input type="text" class="form-control" placeholder="Height" name="altezza" value=<c:if test="${sessionScope.utente.getAltezza()!=0.0}">"${sessionScope.utente.getAltezza()}" </c:if> ><i>cm</i></div>
                        <div class="col-md-6"><label class="labels">Waiste</label><input type="text" class="form-control" placeholder="Waist" name="vita" value=<c:if test="${sessionScope.utente.getVita()!=0.0}">"${sessionScope.utente.getVita()}" </c:if> ><i>cm</i></div>
                        <div class="col-md-6"><label class="labels">Neck</label><input type="text" class="form-control" placeholder="Neck" name="collo" value=<c:if test="${sessionScope.utente.getCollo()!=0.0}">"${sessionScope.utente.getCollo()}" </c:if> ><i>cm</i></div>
                    </div>


<%--                    <a href="#"><div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button" id="saveProfile"> Save Profile</button></div></a>--%>
                                    <input class="btn btn-primary profile-button" id="saveProfile" type="submit" value="Save Profile">
                    </form>
                </div>
            </div>
            <div class="col-md-4">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center experience"><span>Interessi</span></div><br>
                    <ol>
                        <li><div class="col-md-12">Corsa</div><br></li>
                        <li><div class="col-md-12">Nuoto</div><br></li>
                        <li><div class="col-md-12">Crossfit</div><br></li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
