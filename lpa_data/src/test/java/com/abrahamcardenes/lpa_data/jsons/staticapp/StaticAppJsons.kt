package com.abrahamcardenes.lpa_data.jsons.staticapp

object StaticAppJsons {
    val listResponse200 = """
    {
      "Respuesta": {
        "Concesiones": {
          "Concesion": [
            {
              "Nombre": "Puerto - Hoya de La Plata",
              "Comercial": "12",
              "Color": "rgb(226, 0, 26)"
            },
            {
              "Nombre": "Mercado de Vegueta - Tres Palmas",
              "Comercial": "13",
              "Color": "rgb(185, 102, 161)"
            },
            {
              "Nombre": "Teatro - Tamaraceite",
              "Comercial": "L3",
              "Color": "rgb(188, 228, 246)"
            }
          ]
        }
      }
    }
    """.trimIndent()

    val detailResponse200 = """
    {
    "line": "13",
    "name": "Mercado de Vegueta - Tres Palmas",
    "color": "rgb(185, 102, 161)",
    "nodes": [
      "Mercado de Vegueta",
      "Tres Palmas"
    ],
    "variantsGo": [
      {
        "type": "A",
        "name": "Mercado de Vegueta - Tres Palmas",
        "color": "rgb(185, 102, 161)"
      }
    ],
    "variantsBack": [
      {
        "type": "B",
        "name": "Tres Palmas - Mercado de Vegueta",
        "color": "rgb(185, 102, 161)"
      }
    ],
    "stops": [
      {
        "number": "993",
        "name": "Mercado de Vegueta",
        "longitude": "-15.41300107",
        "latitude": "28.10265634",
        "node": "Mercado de Vegueta",
        "variants": [
          "A"
        ]
      },
      {
        "number": "936",
        "name": "Tres Palmas",
        "longitude": "-15.42283358",
        "latitude": "28.06985503",
        "node": "Mercado de Vegueta",
        "variants": [
          "A"
        ]
      },
      {
        "number": "936",
        "name": "Tres Palmas",
        "longitude": "-15.42283358",
        "latitude": "28.06985503",
        "node": "Tres Palmas",
        "variants": [
          "B"
        ]
      },
      {
        "number": "993",
        "name": "Mercado de Vegueta",
        "longitude": "-15.41300107",
        "latitude": "28.10265634",
        "node": "Tres Palmas",
        "variants": [
          "B"
        ]
      }
    ],
    "schedule": [
      {
        "node": "Mercado de Vegueta",
        "tipology": "De lunes a viernes",
        "time": "06:55",
        "color": "rgb(245, 245, 245)"
      },
      {
        "node": "Mercado de Vegueta",
        "tipology": "Sábado",
        "time": "08:05",
        "color": "rgba(0, 0, 0, 0)"
      },
      {
        "node": "Mercado de Vegueta",
        "tipology": "Domingo y festivo",
        "time": "07:50",
        "color": "rgb(245, 245, 245)"
      },
      {
        "node": "Tres Palmas",
        "tipology": "De lunes a viernes",
        "time": "06:10",
        "color": "rgb(245, 245, 245)"
      },
      {
        "node": "Tres Palmas",
        "tipology": "Sábado",
        "time": "07:10",
        "color": "rgb(245, 245, 245)",
        "variant": "F"
      },
      {
        "node": "Tres Palmas",
        "tipology": "Domingo y festivo",
        "time": "08:35",
        "color": "rgba(0, 0, 0, 0)"
      }
    ]
  }
    """.trimIndent()

    val detailResponse200WithEmptyLatituteLongitude = """
    {
    "line": "13",
    "name": "Mercado de Vegueta - Tres Palmas",
    "color": "rgb(185, 102, 161)",
    "nodes": [
      "Mercado de Vegueta",
      "Tres Palmas"
    ],
     "variantsGo": [],
    "variantsBack": [],
    "stops": [
      {
        "number": "993",
        "name": "Mercado de Vegueta",
        "longitude": "-15.41300107",
        "latitude": "",
        "node": "Mercado de Vegueta",
        "variants": [
          "A"
        ]
      },
      {
        "number": "936",
        "name": "Tres Palmas",
        "longitude": "",
        "latitude": "28.06985503",
        "node": "Tres Palmas",
        "variants": [
          "B"
        ]
      }
    ],
    "schedule": []
  }
    """.trimIndent()
}
