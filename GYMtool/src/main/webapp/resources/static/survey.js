Survey.defaultBootstrapMaterialCss.navigationButton = "btn btn-green";
Survey.defaultBootstrapMaterialCss.rating.item = "btn btn-default my-rating";
Survey
    .StylesManager
    .applyTheme("bootstrapmaterial");

var json = {
    pages: [
        {
            questions: [
                {
                    type: "matrix",
                    name: "first",
                    title: "Quanti giorni alla settimana vorresti allenarti?",
                    columns: [
                        {
                            value: 1,
                            text: "1",

                        }, {
                            value: 2,
                            text: "2"
                        }, {
                            value: 3,
                            text: "3"
                        }, {
                            value: 4,
                            text: "4"
                        }, {
                            value: 5,
                            text: "5"
                        },{
                            value: 6,
                            text: "6"
                        }
                    ],
                    rows:
                        {
                           // value: "Nday",
                            text: "Quanti Giorni alla settimana vuoi allenarti?"
                        }

                },{
                    type: "matrix",
                    name: "second",
                    title: "Quanti esercizi al giorno?",
                    columns: [
                        {
                            value: 1,
                            text: "1",

                        }, {
                            value: 2,
                            text: "2"
                        }, {
                            value: 3,
                            text: "3"
                        }, {
                            value: 4,
                            text: "4"
                        }, {
                            value: 5,
                            text: "5"
                        },{
                            value: 6,
                            text: "6"
                        }
                    ],
                    rows:
                       {
                            //value: "Nrow",
                            text: "Quanti allenamenti al giorno vuoi sostenere?"
                        }

                }, {
                    type: "rating",
                    name: "impegno",
                    title: "Quanto vuoi impegnarti in questi allenamenti?",
                    mininumRateDescription: "Non Molto",
                    maximumRateDescription: "Al 100%"
                }, {
                    type: "rating",
                    name: "sforzo",
                    title: "Quanto vuoi sforzarti per migliorare?",
                    mininumRateDescription: "Non molto",
                    maximumRateDescription: "Totalmente"
                }
            ]
        }, {
            questions: [

                {
                    type: "matrix",
                    name: "consistenza1",
                    title: "Come valuteresti i tuoi allenamenti attuali?",
                    columns: [
                        {
                            value: 1,
                            text: "1",

                        }, {
                            value: 2,
                            text: "2"
                        }, {
                            value: 3,
                            text: "3"
                        }, {
                            value: 4,
                            text: "4"
                        }, {
                            value: 5,
                            text: "5"
                        }
                    ],
                    rows:
                        {
                            //value: "actualValue",
                            text: "Come valuteresti il tuo stile di allenamento attualmente?"
                        }

                },
                {
                    type: "matrix",
                    name: "consistenza2",
                    title: "Scegli la velocità con cui vorresti migliorare",
                    columns: [
                        {
                            value: 1,
                            text: "1",

                        }, {
                            value: 2,
                            text: "2"
                        }, {
                            value: 3,
                            text: "3"
                        }, {
                            value: 4,
                            text: "4"
                        }, {
                            value: 5,
                            text: "5"
                        }
                    ],
                    rows:
                         {
                            //value: "newValue",
                            text: "Vuoi migliorare Lentamente o Velocemente?"
                        }

                }
            ]
        }
    ]
};

window.survey = new Survey.Model(json);

survey
    .onComplete
    .add(function (result) {
        document
            .querySelector('#surveyResult')
            .textContent = "Result JSON:\n" + JSON.stringify(result.data, null, 3);
            $('#doEditorPro').show();
            $('#myResult').attr("value", JSON.stringify(result.data));

    });

$("#surveyElement").Survey({model: survey});