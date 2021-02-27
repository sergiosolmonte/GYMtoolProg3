$('.draggable').draggable({
    revert: "invalid",
    stack: ".draggable",
    helper: 'clone'
});
$('.droppable').droppable({
    accept: ".draggable",

    drop: function (event, ui) {
            var droppable = $(this);
            var draggable = ui.draggable;
            draggable.clone().appendTo(droppable);
    }
});

var idDaY=$(" .daysHeader .day").length;

function addTableRow(){
    let drpOptions = {
      drop: function(event, ui) {
          ui.draggable.clone().appendTo($(this));
      }
    };

    var len = $("#planBody .exercise:first .ex_cell");
    let row = $("<div class='exercise'>");

    if(len.length>0){
            for(var i=0; i<len.length; i++) {
                var day = $(".daysHeader .day");
                 let newDiv=$(" <div class='ex_cell' id="+day[i].id+">\n" +
            "                                <div class=\"container\" >\n" +
            "                                     <div class=\"cell droppable \" type=\"droppable\"></div>\n" +
            "                                     <div class=\"cell set\" contenteditable=\"true\" id=\"textareaTable\"></div>\n" +
            "                                     <div class=\"cell rep\" contenteditable=\"true\" id=\"textareaTable\"></div>\n" +
            "                                     <div class=\"cell im\" contenteditable=\"true\" id=\"textareaTable\"></div>\n" +
            "                                </div>\n" +
            "                            </div>" );

                newDiv.appendTo(row);
            }

            (row).appendTo('#planBody')


            $(' .exercise  .droppable').droppable(drpOptions);

    }
    else{
        var h_len = $("#userTable .daysHeader .day");
        for(var i=0; i<h_len.length; i++) {
                let newDiv=$(" <div class='ex_cell'>\n" +
            "                                <div class=\"container\" >\n" +
            "                                     <div class=\"cell droppable \" type=\"droppable\"></div>\n" +
            "                                     <div class=\"cell set\" contenteditable=\"true\" id=\"textareaTable\"></div>\n" +
            "                                     <div class=\"cell rep\" contenteditable=\"true\" id=\"textareaTable\"></div>\n" +
            "                                     <div class=\"cell im\" contenteditable=\"true\" id=\"textareaTable\"></div>\n" +
            "                                </div>\n" +
            "                            </div>" );

                newDiv.appendTo(row);
            }
            (row).appendTo('#planBody')
    }
}

$('#addRow').click(function(){
    addTableRow();
});


function addTableDay(){
    let drpOptions = {
      drop: function(event, ui) {
          ui.draggable.clone().appendTo($(this));
      }
    };

    var len = $(" .daysHeader .day");
    var count = len.length;
    var day = count+1;
    idDaY+=1;

    if (day <= 7){

        /*-----HEADER------*/
        let d = $(" <div class='day'  id= day"+idDaY+"> <a id='textD'> Giorno "+day+"</a> <i class='far fa-times-circle' id='rDay'></div>");
        $('.daysHeader ').append(d);

        if(count==0){

            let descr = $("<div class=\"exDescr\">\n" +
                "                                    <div class=\"descr principal\"><div class=\"testo\"> Exercise</div></div>\n" +
                "                                    <div class=\"descr set\"> <div class=\"testo\">Set </div></div>\n" +
                "                                    <div class=\"descr rep\"> <div class=\"testo\">Rep</div></div>\n" +
                "                                    <div class=\"descr im\"> <div class=\"testo\">Time</div></div>\n" +
                "                                </div>");

             $("#planBody .exHeader").append(descr);

        }else{
            let h = $('.exDescr:first').clone();
            $(h).attr('id','day'+idDaY)
            $('.exHeader').append(h);

            /*-----BODY------*/
            let newDiv=$(" <div class='ex_cell' id= day"+idDaY+">\n" +
                "                                <div class=\"container\" >\n" +
                "                                     <div class=\"cell droppable \" type=\"droppable\"></div>\n" +
                "                                     <div class=\"cell set\" contenteditable=\"true\" id=\"textareaTable\"></div>\n" +
                "                                     <div class=\"cell rep\" contenteditable=\"true\" id=\"textareaTable\"></div>\n" +
                "                                     <div class=\"cell im\" contenteditable=\"true\" id=\"textareaTable\"></div>\n" +
                "                                </div>\n" +
                "                            </div>" );

            let otherDiv = newDiv.clone();
            otherDiv.appendTo('.exercise');
            $('.exercise .droppable').droppable(drpOptions);


            $(' #rDay').click(function(){

                var len = $(".daysHeader .day");
                var count = len.length;
                var id= $(this).parent().attr('id');

                 if(count >1) {
                     $('.exDescr#'+id).remove();

                     $('.daysHeader .day#'+id).remove();

                     $('.exercise > .ex_cell#'+id).remove();
                    count--;
                 }

                 let x;
                 x=1;
                 $(".day #textD").each(function(x, object){
                        $(this).text('Giorno '+(x+1));
                });

            });
            scrollRight();
        }
    }
}


$('#addDay').click(function(){
    addTableDay();
});


$('#rRow').click(function(){

    var len = $("#planBody .exercise");
    var count = len.length;

    if(count >1){
        $("#planBody .exercise:last").remove();
        count--;
    }
});


$(' #rDay').click(function(){

    var len = $(".daysHeader .day");
    var count = len.length;
    var id= $(this).parent().attr('id');

     if(count >1 ) {
         $('.exDescr#'+id).remove();

         $('.daysHeader .day#'+id).remove();

         $('.exercise>.ex_cell#'+id).remove();
     }

     let x;
     x=1;
     $(".day #textD").each(function(x, object){
            $(this).text('Giorno '+(x+1));
     });
});


$('#colSidebar').click(function() {

    if( $('.div1.side-menu').is(':visible')){
        $('div2').css("width","100%");
        $('.div1.side-menu').hide("slide", {direction: "left"}, 500);  //Per la direzione dello scorrimento
        $('.fas.fa-angle-left').css({ WebkitTransform: 'rotate(' + 180 + 'deg)'});
        $('.cont').css({ WebkitTransform: 'translate(left)'});

        $('.cont').animate({left: '1px'},500);

        $(".div2").height($(".div1").height());

    }
    else{

        $('.fas.fa-angle-left').css({ WebkitTransform: 'rotate(' + 0 + 'deg)'});
        $('div2').css("width","80%");
        $('.div1.side-menu').show("slide", {direction: "left"}, 500);
        let w = $('.div1').width();
        $('.cont').animate({left: ''+w-15},500);


    }
});

var $table = $(' .content #pippo #editor');
var $table1 = $(' #printTable .content #pippo #userTable');

var leftTimeout, left = $('.leftB');

function scrollLeft(){
	$('#pippo').scrollLeft($('#pippo').scrollLeft()-$('.ex_cell').width());
	$.each($table.find('.exercise'),function(){
		$(this).children().detach().prependTo(this);
	});
}

left.mousedown(function(){
	scrollLeft();
    leftTimeout = setInterval(function(){
    	scrollLeft();
    }, 500);
    return false;
});

$(document).mouseup(function(){
    clearInterval(leftTimeout);
    return false;
});

var rightTimeout, right = $('.rightB'), day = $('#icol');

function scrollRight(){

	$('#pippo').scrollLeft($('#pippo').scrollLeft()+$('.ex_cell').width());
	$.each($table.find('.exercise'),function(){
		$(this).children().detach().appendTo(this);
	});
}

right.mousedown(function(){
	scrollRight();
    leftTimeout = setInterval(function(){
    	scrollRight();
    }, 500);
    return false;
});

$(document).mouseup(function(){
    clearInterval(rightTimeout);
    return false;
});

day.mousedown(function() {
    scrollRight();
    leftTimeout = setInterval(function(){
    	scrollRight();
    }, 500);

    return false;
});

$('div#leftB').click(function () {

    $('div#leftB').animate({left: '-10px'});
    $('div#leftB').animate({left: '0px'});

});

$('div#rightB').click(function () {

    $('div#rightB').animate({right: '-10px'});
    $('div#rightB').animate({right: '0px'});

});


function scrollLeft1(){
	$('#pippo').scrollLeft($('#pippo').scrollLeft()-$('.ex_cell').width());
	$.each($table1.find('.exercise'),function(){
		$(this).children().detach().prependTo(this);
	});
}

function scrollRight1(){

	$('#pippo').scrollLeft($('#pippo').scrollLeft()+$('.ex_cell').width());
	$.each($table1.find('.exercise'),function(){
		$(this).children().detach().appendTo(this);
	});
}


var postUrl = "/test";
$('#save').click(function(){
    var title = $('#planTitle').text();
    console.log("SONO QUIIII");
    var divDrop = $('.cell.droppable').map(function () {
        if($(this).has("span")){
            var span = $(this).find("span");
            return span.text();
        }
        else{
            return "";
        }
    });
    var divRep = $('.cell.rep').map(function () { return $(this).text(); });
    var divSet =  $('.cell.set').map(function () { return $(this).text(); });
    var divIm =  $('.cell.im').map(function () { return $(this).text(); });

    var arrayTable = [];
    let divJ = {};
    divJ.title = title;
    arrayTable.push(divJ);

    var len = $(" .daysHeader .day");
    var count = len.length;

    var len= $('.ex_cell').length;

    let flag = false;
    for(var i=0;i<len;i++){

        if(divDrop[i] != ""){
            flag = true;
            divJ = {};
            divJ.exercise=divDrop[i];
            divJ.rep=divRep[i];
            divJ.set=divSet[i];
            divJ.time=divIm[i];
            divJ.day=(i%count);
            divJ.exNum=Math.floor(i/count);
            arrayTable.push(divJ);
        }
    }
    console.log(arrayTable);
    //arrayProva=Cookies.get('Table');
    //  This gives you a string representing that element and its content

    var jsonTest = JSON.stringify(arrayTable);

    var pippo = "Ole!"

    if(flag) {

        $.ajax({
            url: "editor",
            type: 'POST',
            data: {"jsonArray": jsonTest},
            dataType: "json",
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log("Error: " + errorThrown);
            }
        }).done(function (data) {
            alert(data['text']);

        });

        Cookies.remove('Table');
        $(".cell").contents().remove();
        alert("Salvataggio Effettuato");
    }
    else
        alert("Scheda Vuota!");
});


function saveCookie(){

    if ($('#editor div.cell.droppable'))
    {
            var divDrop = $('#editor .cell.droppable').map(function () {
                if ($(this).has("span")) {
                    var span = $(this).find("span");
                    return span.text();
                } else {
                    return "";
                }
            });
            var divRep = $('#editor .cell.rep').map(function () {
                return $(this).text();
            });
            var divSet = $('#editor .cell.set').map(function () {
                return $(this).text();
            });
            var divIm = $('#editor .cell.im').map(function () {
                return $(this).text();
            });

            var arrayTable = [];
            var title = $('#planTitle').text();
            var divJ= {};
            divJ.title = title;
            divJ.day = -1;
            divJ.exNum = -1;

            arrayTable.push(divJ);

            var lung = $("#editor .daysHeader .day");
            var count = lung.length;

            var len = $('#editor .ex_cell').length;
            for (var i = 0; i < len; i++) {

                if (divDrop[i] != "") {
                    var divJ = {};
                    divJ.exercise = divDrop[i];
                    divJ.rep = divRep[i];
                    divJ.set = divSet[i];
                    divJ.time = divIm[i];
                    divJ.day = (i % count);
                    divJ.exNum = Math.floor(i / count);
                    arrayTable.push(divJ);
                }
            }
            Cookies.set('Table', JSON.stringify(arrayTable));
            arrayProva = Cookies.get('Table');
        }
}





$("viewProgram",function (){
   console.log("Dentro viewProgram 1");
    var id= $('.pluto span').text();
    console.log("ID scheda: "+id);
});




    function createTable(data) {
        var n_row = Math.max.apply(Math,data.map(function(o) { return o.exNum; }))
        var n_day = Math.max.apply(Math,data.map(function(o) { return o.day; }))

        $("#printTable #userTable").remove();
        if(data){

            let mydiv= $(" <div class=\"workoutPlan\" id=\"userTable\">\n" +
                "                        <div class=\"daysHeader\">\n" +
                "                        </div>\n" +
                "                        <div id=\"planBody\">\n" +
                "                            <div class=\"exHeader\">\n" +
                "                            </div>\n"+
                "                         </div>\n"+
                "                       </div>" );
            $("#printTable .div2 .content #pippo").append(mydiv);


            for(var i=0;i<=n_day;i++){
                addTableDay();
                $("#rDay").remove()
            }

            for(var i=0;i<=n_row;i++){
                addTableRow();
                $(".cell").attr("contenteditable",'false');
                $(".cell").removeAttr('id');
            }
            var DropCell= $(".ex_cell .droppable");
            var setCell = $(".ex_cell .set");
            var repCell = $(".ex_cell .rep");
            var timeCell= $(".ex_cell .im");

            var index=0;
            var indexObj=0;
            var size = data.length;

            for(var i=0;i<=n_row;i++){
                for(var j=0;j<=n_day; j++) {
                    var riga = data[indexObj].exNum;
                    var col  = data[indexObj].day;
                    index = col+(riga*(n_day+1));
                    DropCell[index].prepend(data[indexObj].name);
                    setCell[index].prepend(data[indexObj].set);
                    repCell[index].prepend(data[indexObj].rep);
                    timeCell[index].prepend(data[indexObj].time);
                    indexObj++;
                }
            }
        }
    }




$(function() {

    //loadDraft();
    $(".cell.droppable").dblclick(function () {
        $(this).parent().children().contents().remove();
    });


    $("a.navbar-brand.color-text").on("click",function () {
        $(".active1").removeClass("active1");
        // Cookies.remove('navbar-active');
        Cookies.set('navbar-active',"linkUndefined",{path:"/"});
        //location.reload(true);
    });


    console.log("LO ZIO SIAMO QUI"+$(location).attr("href").substr(43,1))
    // "http://localhost:8080/GYMtool-1.0-SNAPSHOT/" 43 perchè sono 42 caratteri e io conto dal primo successivo
    if($(location).attr("href").substr(43,1)===""){
        console.log("SONO dentro");
        $(".active1").removeClass("active1");
        Cookies.set('navbar-active',"linkUndefined",{path:"/"});
        // location.reload(true);
    }

    $(".nav-item a.nav-link.link-color").on("click",function(){
            $(".active1").removeClass("active1");
            $(this).parent().addClass("active1");
            Cookies.set('navbar-active', $(this).parent().attr("id"), {path: "/"});
            if ($(this).parent().attr("id") === "link4")
                Cookies.set('opt-active', "linkA");
            $('#linkA').addClass("active2");
            var cc = Cookies.get('navbar-active');
            //location.reload(true);
    });

    $("a.menu-link.linked").on("click",function(){


         $(".active2").removeClass("active2");
         $(this).addClass("active2");

         Cookies.set('opt-active', $(this).attr("id"),{ path: "/" });
         //location.reload(true);
         var cc = Cookies.get('opt-active');

    });

    $("#"+Cookies.get("opt-active")).addClass("active2");
    $("#"+Cookies.get("navbar-active")).addClass("active1");

});

function loadDraft() {

   var myC=Cookies.get('Table');

    if( myC == null){

    }else{

        var parsedElement= JSON.parse(myC);
        var size= parsedElement.length;

        var row;
        row = Math.max.apply(Math, parsedElement.map(function(o) { return o.exNum; }));
        var col;
        col = Math.max.apply(Math, parsedElement.map(function(o) { return o.day; }));

        for (var i=0; i<row; i++){
            addTableRow();
        }

        for (var i=2; i<col; i++){
            addTableDay()
        }

        if(parsedElement[0].title){
            $("#planTitle").text(''+parsedElement[0].title);

        }



        let DropCell= $("#editor .ex_cell .droppable");
        let repCell = $('#editor .cell.rep');
        let setCell =  $('#editor .cell.set');
        let imCell =  $('#editor .cell.im');


        let index=0;
        let indexObj=1;
        for(let i=0; i <= row; i++){
            for(let j=0; j <= col; j++) {

                if(indexObj >= size){
                    break;
                }

                if((i===parsedElement[indexObj].exNum) && (j===parsedElement[indexObj].day) ){
                    let thatName= $("a.card-text span:contains("+parsedElement[indexObj].exercise+")");
                    if(DropCell[index])
                        DropCell[index].prepend(thatName.parent().contents().not(thatName).text());
                        $(DropCell[index]).append("<span style=\"display:none\">"+thatName.text()+"</span>");
                    if(repCell[index])
                        repCell[index].prepend(parsedElement[indexObj].rep);
                    if(setCell[index])
                        setCell[index].prepend(parsedElement[indexObj].set);
                    if(imCell[index])
                        imCell[index].prepend(parsedElement[indexObj].time);

                    index ++;
                    indexObj++;

                }else{
                    index++;
                }
            }
        }
    }
};

// $(document).ready(function () {
//    loadDraft();
//    $(".cell.droppable").dblclick(function () {
//        $(this).parent().children().contents().remove();
//    });
//
// });


$("#Trash").click(function () {
        $(".cell").contents().remove();
        let title =$("#usernameEditor").text();
        $("#planTitle").text(''+title+'\'s Plan');
});


$("a.nav-link.link-color").click(function () {
    if(window.location.href.indexOf("editor")>=0)
        saveCookie();
});





$(function () {
    $(".card-body").on("click",function () {


        $(".gruppi_muscolari").addClass("overlay-on-request");
        let w= $("#side-muscle").width() ;
        $("img.gruppi_muscolari").animate({left: w*3});

        var id = $(this).find("span").text();
        console.log("id1  : "+id)
        $("div#overlay."+id).show();



        })

        $(".closePopUp").on("click", function () {
            $(this).parent().hide();
            $("img.gruppi_muscolari").animate({left: '50%'});
            $(".gruppi_muscolari").removeClass("overlay-on-request");


        });
    })
/*Modificato*/
$("h4.muscle").click(function () {

    if($(this).hasClass("activeMuscle")){
        $(this).removeClass("activeMuscle");
        $(".gruppi_muscolari").attr('src','/GYMtool-1.0-SNAPSHOT/resources/static/images/muscoliSpento.png');

    }
    else{
        let myId=$(this).attr('id');
        $(".activeMuscle").removeClass('activeMuscle');

        $(this).addClass('activeMuscle');
        $(".gruppi_muscolari").on("error",function () {
            $(this).attr('src','/GYMtool-1.0-SNAPSHOT/resources/static/images/muscoliSpento.png');
            }).attr('src','/GYMtool-1.0-SNAPSHOT/resources/static/images/catImage/'+myId+'.png');

        let parentID=$(this).parent().attr('href');
        $("div.collapse.show").each(function () {
            if($(this).attr('id') !== parentID)
                $(this).removeClass('show');
          });
    }
});

$(function(){











});

//------------------PROFILO------------------//
$("profile.html").ready(function () {
    $("#editProfile").click(function () {

        $("#profile").hide();
        $("#prSetting").show();

    });
    $("#saveProfile").click(function () {

        let change= $('#prSetting input').map(function () { return $(this).val(); });

        let divJ={};
        divJ.firstname=change[0];
        divJ.lastname=change[1];
        divJ.birthdate=change[2]+" 00:00:00";
        divJ.weight=change[3];
        divJ.height=change[4];
        divJ.waist=change[5];
        divJ.neck=change[6];

        let json=JSON.stringify(divJ);

        $.ajax({
            url: 'editProfile',
            type: 'POST',
            data: json,
            dataType: "json",
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                console.log("Error: " + errorThrown);  }
            }).done(function(data){
                alert('Salvataggio Effettuato');
        });

     $("#profile").show();
     $("#prSetting").hide();
    });
});