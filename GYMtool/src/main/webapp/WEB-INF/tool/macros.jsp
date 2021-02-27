<%@include file="../user.jsp"%>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/style.css" type="text/css"/>
</head>

<div class="container-bmi" id="macros" >
    <h2 id="descriptionApp" style="z-index: 10000"> <a href="javascript:history.back()"> <i class="fas fa-arrow-alt-circle-left" ></i> </a> </h2>

    <div id="imageResult"> <img src="../../resources/static/images/food_pyramid.jpg" style="width: 100%;height: 100%"></div>
    <div id="textResult" style="overflow-y: scroll;overflow-x: hidden; height: 78%">
        <a style="font-size: 25px ; font-weight: bold">Proteins: <br> </a>
        <a id="proteins"></a>
        <br>
        <a style="font-size: 25px ; font-weight: bold">Fruits: <br></a>
        <a id="fruits"></a>
        <br>
        <a style="font-size: 25px ; font-weight: bold">Beverage: <br></a>
        <a id="beverage"></a>
        <br>
        <a style="font-size: 25px ; font-weight: bold">Snacks: <br></a>
        <a id="snacks"></a>
        <br>
        <a style="font-size: 25px ; font-weight: bold">Vegetables: <br></a>
        <a id="vegetables"></a>
    </div>
</div>

<script>
   $(function () {
       const settings = {
           "async": true,
           "crossDomain": true,
           "url": "https://fitness-calculator.p.rapidapi.com/macros",
           "method": "GET",
           "headers": {
               "x-rapidapi-key": "c6fbfcb232msh3b394cd68530564p127516jsn8d645e8cc631",
               "x-rapidapi-host": "fitness-calculator.p.rapidapi.com"
           }
       };

       $.ajax(settings).done(function (response) {
           $.each(response.Proteins, function(k, v){
               $("#proteins").append('<ul style="background-color: grey">'+(k)+'</ul> <li> Porzione '+(v.ServingSize)+'</li> <li> Proteine '+(v.Protein)+'</li> <li> Carboidrati '+(v.Carbs)+'</li> <li> Grassi'+(v.Fat)+'</li>');
           });
           $.each(response.Fruits, function(k, v){
               $("#fruits").append('<ul style="background-color: orange">'+(k)+'</ul> <li> Porzione '+(v.ServingSize)+'</li> <li> Proteine '+(v.Protein)+'</li> <li> Carboidrati '+(v.Carbs)+'</li> <li> Grassi'+(v.Fat)+'</li>');
           });
           $.each(response.Beverages, function(k, v){
               $("#beverage").append('<ul style="background-color: cyan">'+(k)+'</ul> <li> Porzione '+(v.ServingSize)+'</li> <li> Proteine '+(v.Protein)+'</li> <li> Carboidrati '+(v.Carbs)+'</li> <li> Grassi'+(v.Fat)+'</li>');
           });
           $.each(response.Snacks, function(k, v){
               $("#snacks").append('<ul style="background-color: saddlebrown">'+(k)+'</ul> <li> Porzione '+(v.ServingSize)+'</li> <li> Proteine '+(v.Protein)+'</li> <li> Carboidrati '+(v.Carbs)+'</li> <li> Grassi'+(v.Fat)+'</li>');
           });
           $.each(response.Vegetables, function(k, v){
               $("#vegetables").append('<ul style="background-color: green">'+(k)+'</ul> <li> Porzione '+(v.ServingSize)+'</li> <li> Proteine '+(v.Protein)+'</li> <li> Carboidrati '+(v.Carbs)+'</li> <li> Grassi'+(v.Fat)+'</li>');
           });
       });
   })


</script>
