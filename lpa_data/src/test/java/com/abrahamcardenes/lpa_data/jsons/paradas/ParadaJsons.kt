package com.abrahamcardenes.lpa_data.jsons.paradas

object ParadaJsons {

    val busStopNamePar = """
        {
            "nombre": "NOMBRE",
            "numero": "PAR"
        }
    """.trimIndent()

    val busStopBasic = """
        {
            "nombre": "TEATRO",
            "numero": "1"
        }
    """.trimIndent()

    val longlongBusStop = """
        {
            "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CENTRO INSULAR DE DEPORTES)",
            "numero": "38"
        }
    """.trimIndent()

    val busStopDetailWithLinesComing = """
        {
          "nombre": "IND. JOSÉ SÁNCHEZ PEÑATE (C.C. LAS ARENAS)",
          "lineas": [
            {
              "numero": "17",
              "destino": "TEATRO",
              "llegada": ">>"
            },
            {
              "numero": "92",
              "destino": "",
              "llegada": "8min"
            },
            {
              "numero": "65",
              "destino": "PUERTO",
              "llegada": "22min"
            },
            {
              "numero": "L2",
              "destino": "CDAD ALTA-STA CAT",
              "llegada": "27min"
            }
          ]
        }
    """.trimIndent()

    val busStopDetailWithoutLinesIncoming = """
        {
          "nombre": "LEONARDO TORRIANI (ZÁRATE)",
          "lineas": []
        }
    """.trimIndent()
}
