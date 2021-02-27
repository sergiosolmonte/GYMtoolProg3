<%--
  Created by IntelliJ IDEA.
  User: soke
  Date: 17/02/21
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ include file= "/base.jsp"%>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>

<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

</head>


<div class="row" >
    <div class="div1 side-menu"  data-toggle="collapse">
        <div id="accordion wrapper">
            <c:forEach items="${categorie}" var= "c">
                <div class="card">
                    <div class="card-header">
                        <a class="collapsed card-link" data-toggle="collapse" href="#collapse${c.get().getID()}">
                            <h4> ${c.get().getNome()} </h4>
                        </a>
                    </div>
                    <c:forEach items="${esercizi}" var= "e">
                        <c:if test="${c.get().getID()==e.get().getCategoria()}">
                            <div id="collapse${c.get().getID()}" class="collapse">
                                <div class="card-body">
                                    <div>
                                        <a class="card-text draggable">${e.get().getNome()}<span style="display:none">${e.get().getID()}</span></a>
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
    <div class="div3">
        <div class="cont">
            <div id="colSidebar" class="fas fa-angle-left fa-3x"></div>
        </div>
    </div>
    <div class="div2">
        <p><h4 class="great">Welcome to GYMtool editor</h4></p>
        <p>
        <h3 class="great" id="planTitle" contentEditable="true">${sessionScope.userName}'s Plan</h3>
        </p>
        <p>
        <h6 class="great">(Double-click to remove exercise and save to add in your archive)</h6>
        </p>


        <div class="content">
<%--            {# --------Tabella----------- #}--%>

            <div id="leftB">
                <i class=" leftB fas fa-chevron-left fa-2x"></i>
            </div>
            <div id="rightB">
                <i class=" rightB fas fa-chevron-right fa-2x"></i>
            </div>

            <div id="pippo">
                <div class="workoutPlan" id="editor">
                    <div class="daysHeader">
                        <div class="day" id="day1"> <a id="textD"> Giorno 1</a></div>
                        <div class="day" id="day2"> <a id="textD"> Giorno 2</a><i class="far fa-times-circle" id="rDay"></i></div>
                        <div class="day" id="day3"> <a id="textD"> Giorno 3</a><i class="far fa-times-circle" id="rDay"></i></div>
                    </div>

                    <div id="planBody">
                        <div class="exHeader">
                            <div class="exDescr">
                                <div class="descr principal"><div class="testo"> Exercise</div></div>
                                <div class="descr set"> <div class="testo">Set </div></div>
                                <div class="descr rep"> <div class="testo">Rep</div></div>
                                <div class="descr im"> <div class="testo">Time</div></div>
                            </div>
                            <div class="exDescr" id="day2">
                                <div class="descr principal"><div class="testo"> Exercise</div></div>
                                <div class="descr set"> <div class="testo">Set </div></div>
                                <div class="descr rep"> <div class="testo">Rep</div></div>
                                <div class="descr im"> <div class="testo">Time</div></div>
                            </div>
                            <div class="exDescr" id="day3">
                                <div class="descr principal"><div class="testo"> Exercise</div></div>
                                <div class="descr set"> <div class="testo">Set </div></div>
                                <div class="descr rep"> <div class="testo">Rep</div></div>
                                <div class="descr im"> <div class="testo">Time</div></div>
                            </div>
                        </div>
                        <div class="exercise">
                            <div class="ex_cell">
                                <div class="container" >
                                    <div class="cell droppable " type="droppable"></div>
                                    <div class="cell set" contenteditable="true" id="textareaTable"></div>
                                    <div class="cell rep" contenteditable="true" id="textareaTable"></div>
                                    <div class="cell im" contenteditable="true" id="textareaTable"></div>
                                </div>
                            </div>
                            <div class="ex_cell" id="day2">
                                <div class="container" >
                                    <div class="cell droppable " type="droppable"></div>
                                    <div class="cell set" contenteditable="true" id="textareaTable"></div>
                                    <div class="cell rep" contenteditable="true" id="textareaTable"></div>
                                    <div class="cell im" contenteditable="true" id="textareaTable"></div>
                                </div>
                            </div>
                            <div class="ex_cell" id="day3">
                                <div class="container" >
                                    <div class="cell droppable " type="droppable"></div>
                                    <div class="cell set" contenteditable="true" id="textareaTable"></div>
                                    <div class="cell rep" contenteditable="true" id="textareaTable"></div>
                                    <div class="cell im" contenteditable="true" id="textareaTable"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="buttonCont">
                <button class="btn btn-dark " id="addRow" >Add Row <i class="fas fa-arrow-alt-to-bottom"></i></button>
                <button class="btn btn-dark" id="rRow">Remove Row </button>
            </div>
            <div class="buttonCont">
                <button class="btn btn-dark" id="addDay">Add Day <i class="fas fa-plus"></i></button>
                <button class="btn" id="save"><a href=""></a>Save</button>
                <button class="btn btn-dark" id="Trash" ><a>Delete All <i class="far fa-trash-alt"></i></a></button>
            </div>
        </div>
    </div>
</div>
<span id="usernameEditor" style="display: none">${sessionScope.userName}</span>
<script src="<c:url value="/resources/static/functions.js"/>" type="text/javascript"></script>
