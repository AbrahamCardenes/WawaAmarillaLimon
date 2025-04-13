package com.abrahamcardenes.lpa_data.jsons

val shortLine10Timetable = """
    {
      "Horarios": [
        {
          "Linea_ID": "Teatro - Hosp. Dr. Negrín (Exprés)",
          "Nodo": "Teatro",
          "Aviso": "GC-1 Collapse",
          "Observaciones": "Sábado, domingo y festivo no circula",
          "TiposTrayectos": [
            {
              "Tipo": "A",
              "Color": "#009036",
              "Observaciones": "Avoid Julio Luengo"
            }
          ],
          "ListaParadas": [
            {
              "NombreParada": "Teatro",
              "Tipo": [
                "A"
              ]
            },
            {
              "NombreParada": "Hospital Dr. Negrín (Consultas Externas)",
              "Tipo": [
                "A"
              ]
            }
          ],
          "Tipologias": [
            {
              "Tipologia": "De lunes a viernes",
              "Hora": [
                "06:15",
                "06:40",
                "22:35"
              ]
            }
          ]
        },
        {
          "Linea_ID": "Hosp. Dr. Negrín - Teatro (Exprés)",
          "Nodo": "Hosp. Dr. Negrín",
          "Aviso": "",
          "Observaciones": "Sábado, domingo y festivo no circula",
          "TiposTrayectos": [
            {
              "Tipo": "B",
              "Color": "#009036",
              "Observaciones": ""
            }
          ],
          "ListaParadas": [
            {
              "NombreParada": "Hospital Dr. Negrín (Consultas Externas)",
              "Tipo": [
                "B"
              ]
            },
            {
              "NombreParada": "Av. de Canarias (San Telmo)",
              "Tipo": [
                "B"
              ]
            },
            {
              "NombreParada": "Teatro",
              "Tipo": [
                "B"
              ]
            }
          ],
          "Tipologias": [
            {
              "Tipologia": "De lunes a viernes",
              "Hora": [
                "06:40",
                "07:10",
                "22:05"
              ]
            }
          ]
        }
      ]
    }
""".trimIndent()
