<%@include file="../user.jsp"%>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>
</head>
<div class="container-bmi" >
    <h2 id="descriptionApp"> <a href="javascript:history.back()"> <i class="fas fa-arrow-alt-circle-left" ></i> </a> Inserisci i tuoi dati:</h2>
    <div class="inputData">
        <table>
            <tr>
                <th>Age: </th>
                <td> <input id="age" class="camp" type="text" name="links" placeholder=22 value="${sessionScope.utente.getAge()}"/> </td>
                <td>years</td>

            </tr>
            <c:choose>
                <c:when test="${sessionScope.utente.getPeso()!=0.0}">
                <tr>
                    <th>Weight: </th>
                    <td> <input id="weight" class="camp" type="text" name="links" placeholder=85 value="${sessionScope.utente.getPeso()}" /></td>
                    <td>kg</td>
                </tr>
                </c:when>
                <c:otherwise>
                <tr>
                    <th>Weight: </th>
                    <td> <input id="weight" class="camp" type="text" name="links" placeholder=85 /> </td>
                    <td>kg</td>
                </tr>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${sessionScope.utente.getAltezza()!=0.0}">
                <tr>
                    <th>Height: </th>
                    <td> <input id="height" class="camp" type="text" name="links" placeholder=180 value="${sessionScope.utente.getAltezza()}"/> </td>
                    <td>cm</td>
                </tr>
                </c:when>
                <c:otherwise>
                <tr>
                    <th>Height: </th>
                    <td> <input id="height" class="camp" type="text" name="links" placeholder=180 /> </td>
                    <td>cm</td>
                </tr>
                </c:otherwise>
            </c:choose>
            <tr>
                <td></td> <td colspan="2"> <button id="calculateBMI"> Calculate</button></td>
            </tr>
        </table>
    </div>
    <div class="resultData" style="display: none">
        <div id="imageResult"> <img src="../../resources/static/toolImages/bmi.png" style="width: 100%; height: 100%"></div>
        <div id="textResult">
            <a style="font-weight: bold">BMI: <br> </a>
            <a id="myBmi"></a>
            <br>
            <a style="font-weight: bold">Status: <br></a>
            <a id="myhealth"></a>
            <br>
            <a style="font-weight: bold">Range: <br></a>
            <a id="myRange"></a>
        </div>
    </div>
</div>


<script>
    $("#calculateBMI").on("click",function () {

        let age = $(".inputData #age").val();
        let w = $(".inputData #weight").val();
        let h = $(".inputData #height").val();
        const settings = {
            "async": true,
            "crossDomain": true,
            "url": "https://fitness-calculator.p.rapidapi.com/bmi?age=" + age + "&height=" + h + "&weight=" + w + "",
            "method": "GET",
            "headers": {
                "x-rapidapi-key": "c419d3ec83msh29d6315bc8cfd87p1ba5c0jsn27409de2cb24",
                "x-rapidapi-host": "fitness-calculator.p.rapidapi.com"
            }
        };

        $.ajax(settings).done(function (response) {
            let json = response;
            $(".resultData").show();
            $("#textResult #myBmi").text('' + json.bmi.toFixed(3));
            $("#textResult #myhealth").text('' + json.health);
            $("#textResult #myRange").text('' + json.healthy_bmi_range);
        });
    });
</script>

