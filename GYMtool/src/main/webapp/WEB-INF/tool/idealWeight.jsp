<%@include file="../user.jsp"%>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>
</head>
<div class="container-bmi" >
    <h2 id="descriptionApp"> <a href="javascript:history.back()"> <i class="fas fa-arrow-alt-circle-left" ></i> </a> Inserisci i tuoi dati:</h2>
    <div class="inputData">
        <table>
            <tr>
                <th>Gender: </th>
                <td>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="IDEALgen" value="male" checked>
                        <label class="form-check-label" for="exampleRadios1">
                            Male
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="IDEALgen" value="female">
                        <label class="form-check-label" for="exampleRadios2">
                            Female
                        </label>
                    </div>

                </td>

            </tr>

                <c:choose>
                <c:when test="${sessionScope.utente.getPeso()!=0.0}">
            <tr>
                <th>Weight: </th>
                <td> <input id="IDEALweight" class="camp" type="text" name="links" placeholder=85 value="${sessionScope.utente.getPeso()}" /></td>
                <td>kg</td>
            </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <th>Weight: </th>
                    <td> <input id="IDEALweight" class="camp" type="text" name="links" placeholder=85 /> </td>
                    <td>kg</td>
                </tr>
            </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${sessionScope.utente.getAltezza()!=0.0}">
                    <tr>
                        <th>Height: </th>
                        <td> <input id="IDEALheight" class="camp" type="text" name="links" placeholder=180 value="${sessionScope.utente.getAltezza()}"/> </td>
                        <td>cm</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <th>Height: </th>
                        <td> <input id="IDEALheight" class="camp" type="text" name="links" placeholder=180 /> </td>
                        <td>cm</td>
                    </tr>
                </c:otherwise>
            </c:choose>
            <tr>
                <td></td> <td colspan="2"> <button id="calculateIdealW"> Calculate</button></td>
            </tr>
        </table>
    </div>
    <div class="resultData" style="display: none">
        <div id="imageResult"> <img src="../../resources/static/images/idealweight.png" style="width: 100%; height: 100%"></div>
        <div id="textResult">
            <a style="font-weight: bold">Devine: <br> </a>
            <a id="Devine"></a>
            <br>
            <a style="font-weight: bold">Hamwi: <br></a>
            <a id="Hamwi"></a>
            <br>
            <a style="font-weight: bold">Miller: <br></a>
            <a id="Miller"></a>
            <br>
            <a style="font-weight: bold">Robinson: <br></a>
            <a id="Robinson"></a>
        </div>
    </div>
</div>
<script>
    $("#calculateIdealW").on("click",function () {

        let gen=  $(".inputData #IDEALgen:checked").val();
        let w=  $(".inputData #IDEALweight").val();
        let h=  $(".inputData #IDEALheight").val();
        const settings = {
            "async": true,
            "crossDomain": true,
            "url": "https://fitness-calculator.p.rapidapi.com/idealweight?weight="+w+"&gender="+gen+"&height="+h+"",
            "method": "GET",
            "headers": {
                "x-rapidapi-key": "c6fbfcb232msh3b394cd68530564p127516jsn8d645e8cc631",
                "x-rapidapi-host": "fitness-calculator.p.rapidapi.com"
            }
        };

        $.ajax(settings).done(function (response) {
            $("#Hamwi").text(''+response.Hamwi.toFixed(3));
            $("#Devine").text(''+response.Devine.toFixed(3));
            $("#Robinson").text(''+response.Robinson.toFixed(3));
            $("#Miller").text(''+response.Miller.toFixed(3));
            $(".resultData").show();
        });
    });
</script>



