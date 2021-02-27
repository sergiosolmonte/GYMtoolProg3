<%@include file="../user.jsp"%>
<div class="container-bmi" id="#bodyfatPage">
    <h2 id="descriptionApp"> <a href="javascript:history.back()"> <i class="fas fa-arrow-alt-circle-left" ></i> </a> Inserisci i tuoi dati:</h2>
    <div class="inputData">
        <table>
            <tr>
                <th>Gender: </th>
                <td>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="FATgen" value="male" checked>
                        <label class="form-check-label" for="exampleRadios1">
                            Male
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="FATgen" value="female">
                        <label class="form-check-label" for="exampleRadios2">
                            Female
                        </label>
                    </div>
                </td>
            </tr>
            <tr>
                <th>Age: </th>
                <td> <input id="age" class="camp" type="text" name="links" placeholder=22 value="${sessionScope.utente.getAge()}"/> </td>
                <td>years</td>
            </tr>
            <tr>
                <th>Weight: </th>
                <td> <input id="weight" class="camp" type="text" name="links" placeholder=85 value=<c:if test="${sessionScope.utente.getPeso()!=0.0}">"${sessionScope.utente.getPeso()}" /></c:if>  </td>
                <td>kg</td>
            </tr>
            <tr>
                <th>Height: </th>
                <td> <input id="height" class="camp" type="text" name="links" placeholder=180 value=<c:if test="${sessionScope.utente.getAltezza()!=0.0}">"${sessionScope.utente.getAltezza()}" /></c:if>  </td>
                <td>cm</td>
            </tr>
            <tr>
                <th>Neck: </th>
                <td> <input id="neck" class="camp" type="text" name="links" placeholder=50 value=<c:if test="${sessionScope.utente.getCollo()!=0.0}">"${sessionScope.utente.getCollo()}" /></c:if>  </td>
                <td>cm</td>
            </tr>
            <tr>
                <th>Hip: </th>
                <td> <input id="hip" class="camp" type="text" name="links" placeholder=92 value="92"/> </td>
                <td>cm</td>
            </tr>
            <tr>
                <th>Waist: </th>
                <td> <input id="waiste" class="camp" type="text" name="links" placeholder=96 value=<c:if test="${sessionScope.utente.getVita()!=0.0}">"${sessionScope.utente.getVita()}" /></c:if>   </td>
                <td>cm</td>
            </tr>
            <tr>
                <td></td> <td colspan="2"> <button id="calculateBodyfat"> Calculate</button></td>
            </tr>
        </table>
    </div>
    <div class="resultData" style="display: none">
        <div id="imageResult"> <img src="../../resources/static/toolImages/bodyfat.png" style="width: 100%; height: 100%!important;"></div>
        <div id="textResult">
            <a style="font-weight: bold">Body Fat BMI: <br> </a>
            <a id="fatBmi"></a>
            <br>
            <a style="font-weight: bold">Body Fat U.S. Navy: <br></a>
            <a id="fatUS"></a>
            <br>
            <a style="font-weight: bold">Body Fat Mass: <br></a>
            <a id="fatMass"></a>
            <br>
            <a style="font-weight: bold">Lean Body Mass: <br></a>
            <a id="leanMass"></a>
            <br>
            <a style="font-weight: bold">Body Fat Category: <br></a>
            <a id="fatCategory"></a>

        </div>
    </div>
</div>

<script>
    $("#calculateBodyfat").on("click", function () {

        let waiste = $(".inputData #waiste").val();
        let w = $(".inputData #weight").val();
        let h = $(".inputData #height").val();
        let gen=  $(".inputData #FATgen:checked").val();
        let neck=$(".inputData #neck").val();
        let hip=$(".inputData #hip").val();
        let age=$(".inputData #age").val();


        const settings = {
            "async": true,
            "crossDomain": true,
            "url": "https://fitness-calculator.p.rapidapi.com/bodyfat?age="+age+"&gender="+gen+"&weigth="+w+"&heigth="+h+"&neck="+neck+"&waist="+waiste+"&hip="+hip+"",
            "method": "GET",
            "headers": {
                "x-rapidapi-key": "c6fbfcb232msh3b394cd68530564p127516jsn8d645e8cc631",
                "x-rapidapi-host": "fitness-calculator.p.rapidapi.com"
            }
        };
        console.log("https://fitness-calculator.p.rapidapi.com/bodyfat?age="+age+"&gender="+gen+"&weigth="+w+"&heigth="+h+"&neck="+neck+"&waist="+waiste+"&hip="+hip+"");

        $.ajax(settings).done(function (response) {
           $("#fatBmi").text(''+response['Body Fat (BMI method)']);
            $("#fatUS").text(''+response['Body Fat (U.S. Navy Method)']);
            $("#fatMass").text(''+response['Body Fat Mass']);
            $("#leanMass").text(''+response['Lean Body Mass']);
            $("#fatCategory").text(''+response['Body Fat Category']);
            $(".resultData").show();
        });
    });

</script>
