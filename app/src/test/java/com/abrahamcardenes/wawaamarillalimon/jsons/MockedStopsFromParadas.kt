package com.abrahamcardenes.wawaamarillalimon.jsons

/*
The original API returns not only a wrong busStop but also repeated bus stops, usually 4 times the same stop.
 */
val mockedBusStops =
    """
    [
      {
        "nombre": "NOMBRE",
        "numero": "PAR"
      },
      {
        "nombre": "TEATRO",
        "numero": "1"
      },
      {
        "nombre": "C / FRANCISCO GOURIÉ, 103",
        "numero": "2"
      },
      {
        "nombre": "TEATRO",
        "numero": "1"
      }
    ]
    """.trimIndent()
