<%@include file="../user.jsp"%>


<div class="container-bmi" >
    <h2 id="descriptionApp"> <a href="javascript:history.back()"> <i class="fas fa-arrow-alt-circle-left" ></i> </a> Inserisci i tuoi dati:</h2>
    <div class="inputData">
        <table>
            <tr>
                <th>Gender: </th>
                <td>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="KCALgen" value="male" checked>
                        <label class="form-check-label" for="exampleRadios1">
                            Male
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="KCALgen" value="female">
                        <label class="form-check-label" for="exampleRadios2">
                            Female
                        </label>
                    </div>
                </td>
            </tr>
            <tr>
                <th>Age: </th>
                <td> <input id="KCALage" class="camp" type="text" name="links" placeholder=22 value="${sessionScope.utente.getAge()}"/> </td>
                <td>years</td>
            </tr>
            <tr>
                <c:choose>
                <c:when test="${sessionScope.utente.getPeso()!=0.0}">
            <tr>
                <th>Weight: </th>
                <td> <input id="KCALweight" class="camp" type="text" name="links" placeholder=85 value="${sessionScope.utente.getPeso()}" /></td>
                <td>kg</td>
            </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <th>Weight: </th>
                    <td> <input id="KCALweight" class="camp" type="text" name="links" placeholder=85 /> </td>
                    <td>kg</td>
                </tr>
            </c:otherwise>
            </c:choose>
            </tr>
            <tr>
                <c:choose>
                <c:when test="${sessionScope.utente.getAltezza()!=0.0}">
            <tr>
                <th>Height: </th>
                <td> <input id="KCALheight" class="camp" type="text" name="links" placeholder=180 value="${sessionScope.utente.getAltezza()}"/> </td>
                <td>cm</td>
            </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <th>Height: </th>
                    <td> <input id="KCALheight" class="camp" type="text" name="links" placeholder=180 /> </td>
                    <td>cm</td>
                </tr>
            </c:otherwise>
            </c:choose>
            <tr>
                <td></td> <td colspan="2"> <button id="calculatekcal"> Calculate</button></td>
            </tr>
        </table>
    </div>
    <div class="resultData" style="display: none">
        <div id="imageResult"> <img src="../../resources/static/toolImages/kcal.jpg" style="width: 100%; height: 100%"></div>
        <div id="textResult">
            <a style="font-weight: bold">BMR (Basal Metabolic Rate): <br> </a>
            <a id="myBmr"></a>
            <br>
            <a style="font-weight: bold">Sedentary(little or no exercise): <br></a>
            <a id="sedentary"></a>
            <br>
            <a style="font-weight: bold">Exercise 1-3 times/week: <br></a>
            <a id="1-3week"></a>
            <br>
            <a style="font-weight: bold">Exercise 3-4 times/week: <br></a>
            <a id="3-4week"></a>
            <br>
            <a style="font-weight: bold">Exercise 4-5 times/week: <br></a>
            <a id="4-5week"></a>
            <br>
            <a style="font-weight: bold">Intense exercise 6-7 times/week: <br></a>
            <a id="6-7week"></a>
            <br>
            <a style="font-weight: bold">Very intense exercise daily, or physical job: <br></a>
            <a id="intense"></a>
        </div>
    </div>
</div>

<script>
    $("#calculatekcal").on("click" , function () {

        let gen=  $(".inputData #KCALgen:checked").val();
        let w=  $(".inputData #KCALweight").val();
        let h=  $(".inputData #KCALheight").val();
        let age=  $(".inputData #KCALage").val();
        const settings = {
            "async": true,
            "crossDomain": true,
            "url": "https://fitness-calculator.p.rapidapi.com/dailycalory?age="+age+"&gender="+gen+"&heigth="+h+"&weigth="+w+"",
            "method": "GET",
            "headers": {
                "x-rapidapi-key": "c6fbfcb232msh3b394cd68530564p127516jsn8d645e8cc631",
                "x-rapidapi-host": "fitness-calculator.p.rapidapi.com"
            }
        };

        $.ajax(settings).done(function (response) {
            $("#myBmr").text(''+response.data['BMR']);
            $("#sedentary").text(''+response.data['Sedentary: little or no exercise'].toFixed(3));
            $("#1-3week").text(''+response.data['Exercise 1-3 times/week'].toFixed(3));
            $("#4-5week").text(''+response.data['Daily exercise or intense exercise 3-4 times/week'].toFixed(3));
            $("#3-4week").text(''+response.data['Exercise 4-5 times/week'].toFixed(3));
            $("#6-7week").text(''+response.data['Intense exercise 6-7 times/week'].toFixed(3));
            $("#intense").text(''+response.data['Very intense exercise daily, or physical job'].toFixed(3));
            $(".resultData").show();
        });
    });
</script>


