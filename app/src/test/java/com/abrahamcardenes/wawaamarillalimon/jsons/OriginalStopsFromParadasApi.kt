package com.abrahamcardenes.wawaamarillalimon.jsons

val originalResponseFromApiParadas =
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
        "nombre": "AVDA. RAFAEL CABRERA (SAN TELMO)",
        "numero": "3"
      },
      {
        "nombre": "C/ TRIANA",
        "numero": "4"
      },
      {
        "nombre": "C/ VENEGAS (USOS MÚLTIPLES)",
        "numero": "5"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 13",
        "numero": "6"
      },
      {
        "nombre": "C/ VENEGAS (FUENTE LUMINOSA)",
        "numero": "7"
      },
      {
        "nombre": "C/ LEON Y CASTILLO (PLAZA DE LA FERIA)",
        "numero": "8"
      },
      {
        "nombre": "C/ LUIS DORESTE SILVA, 22",
        "numero": "9"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 145",
        "numero": "10"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "11"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 185",
        "numero": "12"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (C.N. METROPOLE)",
        "numero": "13"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 209",
        "numero": "14"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (OFICINAS MUNICIPALES)",
        "numero": "15"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (COLEGIO SALESIANO)",
        "numero": "16"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (TORRE LAS PALMAS)",
        "numero": "17"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "20"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (EDIFICIO JOSÉ ANTONIO)",
        "numero": "22"
      },
      {
        "nombre": "PL. SAN JUAN BAUTISTA (BASE NAVAL)",
        "numero": "23"
      },
      {
        "nombre": "C/ PRESIDENTE ALVEAR (IGLESIA DEL PINO)",
        "numero": "24"
      },
      {
        "nombre": "C/ EDUARDO BENOT, FRENTE 5",
        "numero": "25"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "26"
      },
      {
        "nombre": "C/ EDUARDO BENOT, FRENTE 23",
        "numero": "27"
      },
      {
        "nombre": "C/ ALBAREDA, 43",
        "numero": "28"
      },
      {
        "nombre": "C/ AGUSTÍN MILLARES SALL (EDIFICIO MAPFRE)",
        "numero": "29"
      },
      {
        "nombre": "C/ JUAN REJÓN,25",
        "numero": "30"
      },
      {
        "nombre": "C/ JUAN REJÓN (CASTILLO DE LA LUZ)",
        "numero": "31"
      },
      {
        "nombre": "C/ LA NAVAL",
        "numero": "33"
      },
      {
        "nombre": "C/ JUAN REJÓN, 67",
        "numero": "34"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (JUAN XXIII)",
        "numero": "35"
      },
      {
        "nombre": "AVDA. DE CANARIAS (SAN TELMO)",
        "numero": "36"
      },
      {
        "nombre": "C/ LUIS DORESTE SILVA, 50",
        "numero": "37"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CENTRO INSULAR DE DEPORTES)",
        "numero": "38"
      },
      {
        "nombre": "AVDA. JUAN XXIII (CLINICA DEL PINO)",
        "numero": "39"
      },
      {
        "nombre": "AVDA.  ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CARVAJAL)",
        "numero": "40"
      },
      {
        "nombre": "AVDA. JUAN XXIII (COLEGIO CANTERBURY)",
        "numero": "41"
      },
      {
        "nombre": "DR. WALKSMANN, 10 (PLAZA LA FERIA)",
        "numero": "42"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 80 (BARRANQUILLO DON ZOILO)",
        "numero": "43"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "44"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 154 (BARRANQUILLO DON ZOILO)",
        "numero": "45"
      },
      {
        "nombre": "C/ PÉREZ DEL TORO, 13",
        "numero": "46"
      },
      {
        "nombre": "C/ CARLOS M. BLANDY (PLAZA DE ARUCAS)",
        "numero": "47"
      },
      {
        "nombre": "C/ PÉREZ DEL TORO (PLAZA DR. JUAN BOSCH MILLARES)",
        "numero": "48"
      },
      {
        "nombre": "C/ ALMIRANTE BENÍTEZ INGLOTT, 12",
        "numero": "49"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 61 (BARRANQUILLO DON ZOILO)",
        "numero": "50"
      },
      {
        "nombre": "C/ ALMIRANTE BENÍTEZ INGLOTT (C.S. ESCALERITAS)",
        "numero": "51"
      },
      {
        "nombre": "C/ PARROCO MATIAS ARTILES",
        "numero": "52"
      },
      {
        "nombre": "C/ PINTOR JUAN ISMAEL (IGLESIA REDONDA)",
        "numero": "53"
      },
      {
        "nombre": "C/ ECHEGARAY, 137",
        "numero": "54"
      },
      {
        "nombre": "C/ TEOBALDO POWER, FRENTE 51",
        "numero": "55"
      },
      {
        "nombre": "C/ HENRY DUNANT, FRENTE 10",
        "numero": "56"
      },
      {
        "nombre": "AVDA. ESCALERITAS, FRENTE 111",
        "numero": "57"
      },
      {
        "nombre": "C/ PRESIDENTE ALVEAR, 17",
        "numero": "58"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN SANSOFÉ)",
        "numero": "59"
      },
      {
        "nombre": "C/ DEAN RODRÍGUEZ BOLAÑOS (PL. ALVARADO Y SAZ)",
        "numero": "60"
      },
      {
        "nombre": "AVDA. ESCALERITAS( FRENTE C.C. LA BALLENA)",
        "numero": "61"
      },
      {
        "nombre": "C/ TEOBALDO POWER (IGLESIA REDONDA)",
        "numero": "62"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 1",
        "numero": "63"
      },
      {
        "nombre": "C/ MARIUCHA, 139",
        "numero": "64"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 19",
        "numero": "65"
      },
      {
        "nombre": "C/ MARIUCHA, 171",
        "numero": "66"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 33",
        "numero": "67"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN SANSOFÉ)",
        "numero": "68"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO (PACUCO PENICHET)",
        "numero": "69"
      },
      {
        "nombre": "AVDA. ESCALERITAS (C.C. LA BALLENA)",
        "numero": "70"
      },
      {
        "nombre": "AVDA. ALCALDE DÍAZ SAAVEDRA NAVARRO (PL. SANTA ISABEL)",
        "numero": "71"
      },
      {
        "nombre": "AVDA. DE LA FERIA (INFECAR)",
        "numero": "72"
      },
      {
        "nombre": "C/ DR. HERNAN PEREZ DE GRADO, 6",
        "numero": "73"
      },
      {
        "nombre": "C/ DIEGO BETANCOR SUAREZ , 19",
        "numero": "74"
      },
      {
        "nombre": "C/ DR. HERNÁN PEREZ DE GRADO (LA PORTADILLA)",
        "numero": "75"
      },
      {
        "nombre": "C/ DIEGO BETANCOR SUAREZ, 39",
        "numero": "76"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (CARREFOUR)",
        "numero": "77"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (JUZGADOS)",
        "numero": "78"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        "numero": "79"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO, FRENTE 32",
        "numero": "80"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 170",
        "numero": "81"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        "numero": "82"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 214",
        "numero": "83"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 154",
        "numero": "84"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 264",
        "numero": "85"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 208",
        "numero": "86"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 290",
        "numero": "87"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 266",
        "numero": "88"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (IGLESIA SANTA CLARA)",
        "numero": "89"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 298",
        "numero": "90"
      },
      {
        "nombre": "C/ MARIANAO, 12",
        "numero": "91"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, FRENTE 306",
        "numero": "92"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (PARKING HOSPITAL MATERNO INSULAR)",
        "numero": "93"
      },
      {
        "nombre": "Primero de Mayo ,6",
        "numero": "21"
      },
      {
        "nombre": "Primero de Mayo (ONCE)",
        "numero": "19"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (IGLESIA SANTA CLARA)",
        "numero": "94"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (MARTÍN FREIRE)",
        "numero": "95"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (PARKING HOSPITAL MATERNO INSULAR)",
        "numero": "96"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, 14",
        "numero": "97"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (MARTÍN FREIRE)",
        "numero": "98"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 8",
        "numero": "99"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, FRENTE 16",
        "numero": "100"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 30",
        "numero": "101"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (CARREFOUR)",
        "numero": "102"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 46",
        "numero": "103"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, FRENTE 8",
        "numero": "104"
      },
      {
        "nombre": "C/ MIGUEL MARTÍN FERNÁNDEZ DE LA TORRE , 7",
        "numero": "105"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 15",
        "numero": "106"
      },
      {
        "nombre": "C/ CÓRDOBA, 40",
        "numero": "107"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 41",
        "numero": "108"
      },
      {
        "nombre": "C/ CÓRDOBA, FRENTE 31",
        "numero": "109"
      },
      {
        "nombre": "C/ CÓRDOBA (BOMBEROS VEGUETA)",
        "numero": "110"
      },
      {
        "nombre": "C/ AYAGAURES (TANATORIO SAN MIGUEL)",
        "numero": "111"
      },
      {
        "nombre": "C/ CÓRDOBA, FRENTE 49",
        "numero": "113"
      },
      {
        "nombre": "C/ CÓRDOBA, 19",
        "numero": "114"
      },
      {
        "nombre": "C/ CÓRDOBA, 54",
        "numero": "115"
      },
      {
        "nombre": "C/ CÓRDOBA, 29",
        "numero": "116"
      },
      {
        "nombre": "C/ ALICANTE (COLEGIO ISLAS CANARIAS)",
        "numero": "117"
      },
      {
        "nombre": "C/ CÓRDOBA, 49",
        "numero": "118"
      },
      {
        "nombre": "AVDA. DE AMURGA (C.S. CONO SUR)",
        "numero": "119"
      },
      {
        "nombre": "C/ CÓRDOBA, 71",
        "numero": "120"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 10",
        "numero": "121"
      },
      {
        "nombre": "C/ ALICANTE (COLEGIO ISLAS CANARIAS)",
        "numero": "122"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 20",
        "numero": "123"
      },
      {
        "nombre": "C/ SARGENTO SALOM, 34",
        "numero": "124"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS, FRENTE 16",
        "numero": "125"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 35",
        "numero": "126"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS, FRENTE 2",
        "numero": "127"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 53",
        "numero": "128"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES,  6",
        "numero": "129"
      },
      {
        "nombre": "C/ DEBUSSY, 3",
        "numero": "130"
      },
      {
        "nombre": "C/ JUAN SÁNCHEZ DE LA COBA, 2",
        "numero": "131"
      },
      {
        "nombre": "C/ DEBUSSY, 9",
        "numero": "132"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 6",
        "numero": "133"
      },
      {
        "nombre": "C/ DEBUSSY, FRENTE  6",
        "numero": "134"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 33)",
        "numero": "135"
      },
      {
        "nombre": "C/ ANTON DVORAK, 5",
        "numero": "136"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 1)",
        "numero": "137"
      },
      {
        "nombre": "C/ JUAN SEBASTIAN BACH, FRENTE 4",
        "numero": "138"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 5)",
        "numero": "139"
      },
      {
        "nombre": "C/ BERLIOZ, 5",
        "numero": "140"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 17)",
        "numero": "141"
      },
      {
        "nombre": "C/ SCHUBERT, FRENTE 6",
        "numero": "142"
      },
      {
        "nombre": "C/ SARGENTO SALOM, 44",
        "numero": "143"
      },
      {
        "nombre": "C/ SCHUBERT, 5",
        "numero": "144"
      },
      {
        "nombre": "C/PEDRO HIDALGO (POLIDEPORTIVO)",
        "numero": "145"
      },
      {
        "nombre": "C/ SCHUBERT, 17",
        "numero": "146"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, FRENTE 91",
        "numero": "147"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, 5",
        "numero": "148"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, FRENTE 51",
        "numero": "149"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES, 19",
        "numero": "150"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 96",
        "numero": "151"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES, 33",
        "numero": "152"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA,  FRENTE 133",
        "numero": "153"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 19",
        "numero": "154"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 168",
        "numero": "155"
      },
      {
        "nombre": "AVDA. DE AMURGA (C.S. CONO SUR)",
        "numero": "156"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "157"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TEERRERAS EL LASSO, 33)",
        "numero": "158"
      },
      {
        "nombre": "C/ CANDELARIA DE LÉON, 6",
        "numero": "159"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 1)",
        "numero": "160"
      },
      {
        "nombre": "C/ FARMACEÚTICO ARENCIBIA CABRERA (COFARCA)",
        "numero": "161"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 4)",
        "numero": "162"
      },
      {
        "nombre": "C/ CONCEJAL ANDRÉS ALVARADO JANINA (LOCAL SOCIAL HOYA DE LA PLATA)",
        "numero": "163"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 17)",
        "numero": "164"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (HOSPITAL MATERNO INSULAR)",
        "numero": "165"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 97",
        "numero": "166"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (ESCUELA DE ARTE)",
        "numero": "167"
      },
      {
        "nombre": "C/ SALAMANCA, 63",
        "numero": "168"
      },
      {
        "nombre": "C/ ARGUINEGUÍN",
        "numero": "169"
      },
      {
        "nombre": "C/ SALAMANCA, 99",
        "numero": "170"
      },
      {
        "nombre": "C/ REYES CATÓLICOS, 9",
        "numero": "171"
      },
      {
        "nombre": "C/ SALAMANCA, 135",
        "numero": "172"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 2",
        "numero": "173"
      },
      {
        "nombre": "AVDA.  JUAN CARLOS I, 9",
        "numero": "174"
      },
      {
        "nombre": "C/ NUEVA, FRENTE  67",
        "numero": "175"
      },
      {
        "nombre": "AVDA JUAN CARLOS I, 23",
        "numero": "176"
      },
      {
        "nombre": "C/ ANDENES, FRENTE 15",
        "numero": "177"
      },
      {
        "nombre": "C/ CANDELARIA DE LEÓN, 7",
        "numero": "178"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN, 10",
        "numero": "179"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 128",
        "numero": "180"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN, 42",
        "numero": "181"
      },
      {
        "nombre": "TAFIRA BAJA",
        "numero": "528"
      },
      {
        "nombre": "C/ CONCEJAL ANDRES ALVARADO JANINA (LOCAL SOCIAL HOYA DE LA PLATA)",
        "numero": "182"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN (PLAZA DEL SOL NACIENTE)",
        "numero": "183"
      },
      {
        "nombre": "RESIDENCIAL FLOR SIRERA",
        "numero": "184"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN, 16",
        "numero": "185"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 1",
        "numero": "186"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN, 48",
        "numero": "187"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (TRÓPICO)",
        "numero": "188"
      },
      {
        "nombre": "C/ REAL DE SAN ROQUE, FRENTE 11",
        "numero": "189"
      },
      {
        "nombre": "C/ ANDENES, 9",
        "numero": "190"
      },
      {
        "nombre": "C/ FARNESIO, FRENTE 15",
        "numero": "191"
      },
      {
        "nombre": "C/ NÉSTOR ÁLAMO (CAMPO DE LUCHA)",
        "numero": "192"
      },
      {
        "nombre": "C/ FARNESIO, FRENTE 59",
        "numero": "193"
      },
      {
        "nombre": "CARRETERA EL CARDON (ROTONDA)",
        "numero": "194"
      },
      {
        "nombre": "C/ FAMA, FRENTE 85",
        "numero": "195"
      },
      {
        "nombre": "AVDA. JUAN XXIII (CLINICA DEL PINO)",
        "numero": "196"
      },
      {
        "nombre": "C/ ANDENES, FRENTE 39",
        "numero": "197"
      },
      {
        "nombre": "ACCESO ANTIGUA CARCEL",
        "numero": "198"
      },
      {
        "nombre": "C/ NUEVA, FRENTE 25",
        "numero": "199"
      },
      {
        "nombre": "C/ LOS MANZANO",
        "numero": "200"
      },
      {
        "nombre": "C/ BARAHONA, 77",
        "numero": "201"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN",
        "numero": "202"
      },
      {
        "nombre": "C/ BARAHONA, FRENTE 19",
        "numero": "203"
      },
      {
        "nombre": "C/ JUAN DE QUESADA (RECTORADO ULPGC)",
        "numero": "204"
      },
      {
        "nombre": "LA MATULA, FRENTE 25",
        "numero": "205"
      },
      {
        "nombre": "C/ REAL DE SAN ROQUE, 13",
        "numero": "206"
      },
      {
        "nombre": "LA MATULA, FRENTE 61",
        "numero": "207"
      },
      {
        "nombre": "C/ FARNESIO, 13",
        "numero": "208"
      },
      {
        "nombre": "LA MATULA, FRENTE  95",
        "numero": "209"
      },
      {
        "nombre": "C/ FARNESIO, 53",
        "numero": "210"
      },
      {
        "nombre": "PUENTE LA MATULA",
        "numero": "211"
      },
      {
        "nombre": "C/ FAMA, 71",
        "numero": "212"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (HNOS. TOLEDO SUAREZ)",
        "numero": "213"
      },
      {
        "nombre": "C/ ANDENES, 19",
        "numero": "214"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (LOMO VERDEJO)",
        "numero": "215"
      },
      {
        "nombre": "C/ NUEVA, 35",
        "numero": "216"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (FELIPE MARTELL)",
        "numero": "217"
      },
      {
        "nombre": "C/ NUEVA, 77",
        "numero": "218"
      },
      {
        "nombre": "C/ SAN JOSÉ ARTESANO, 24",
        "numero": "219"
      },
      {
        "nombre": "C/ BARAHONA, 19",
        "numero": "220"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 62",
        "numero": "221"
      },
      {
        "nombre": "C/ LA MATULA, 25",
        "numero": "222"
      },
      {
        "nombre": "C/ SEVERO OCHOA",
        "numero": "223"
      },
      {
        "nombre": "C/ LA MATULA, 65",
        "numero": "224"
      },
      {
        "nombre": "C/ SEVERO OCHOA,  12",
        "numero": "225"
      },
      {
        "nombre": "C/ LA MATULA, 97",
        "numero": "226"
      },
      {
        "nombre": "C/ SEVERO OCHOA (GEORGE PIRE)",
        "numero": "227"
      },
      {
        "nombre": "C/ AYAGAURES (TANATORIO SAN MIGUEL)",
        "numero": "228"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS, 5",
        "numero": "229"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (PUENTE LA MATULA)",
        "numero": "230"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS (IGLESIA EL BATÁN)",
        "numero": "231"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (HNOS. TOLEDO SUÁREZ)",
        "numero": "232"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 116",
        "numero": "233"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (EL HORNILLO)",
        "numero": "234"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, FRENTE 121",
        "numero": "235"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (FELIPE MARTEL)",
        "numero": "236"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 166",
        "numero": "237"
      },
      {
        "nombre": "C/ ARGUINEGUÍN, 8",
        "numero": "238"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 220",
        "numero": "239"
      },
      {
        "nombre": "AUTOVIA DE GUINIGUADA (SAN JUAN BOSCO)",
        "numero": "240"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 276",
        "numero": "241"
      },
      {
        "nombre": "C/ SEVERO OCHOA, FRENTE 10",
        "numero": "242"
      },
      {
        "nombre": "AVDA. PRIMERO DE MAYO (CORREOS)",
        "numero": "243"
      },
      {
        "nombre": "C/ SEVERO OCHOA (ALBERT SCHWITZER)",
        "numero": "244"
      },
      {
        "nombre": "C/ INGENIERO JOSÉ BOSCH Y SINTÉS, 1",
        "numero": "245"
      },
      {
        "nombre": "C/ SEVERO OCHOA (GEORGE BERNARD SHAW)",
        "numero": "246"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "247"
      },
      {
        "nombre": "C/ MIGUEL ANGEL ASTURIAS, FRENTE 5",
        "numero": "248"
      },
      {
        "nombre": "PASEO TOMÁS MORALES, FRENTE 69",
        "numero": "249"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS (IGLESIA EL BATAN)",
        "numero": "250"
      },
      {
        "nombre": "PASEO TOMÁS MORALES, 120",
        "numero": "251"
      },
      {
        "nombre": "ROTONDA DE LOMO BLANCO",
        "numero": "252"
      },
      {
        "nombre": "C/ EMILIO LEY (PISCINAS JULIO NAVARRO)",
        "numero": "253"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY, 9",
        "numero": "254"
      },
      {
        "nombre": "C/ PÍO XII (COLEGIO TERESIANO)",
        "numero": "255"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY, FRENTE 132",
        "numero": "256"
      },
      {
        "nombre": "C/ PÍO XII (ESTADIO INSULAR)",
        "numero": "257"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY (COLEGIO EL BATÁN)",
        "numero": "258"
      },
      {
        "nombre": "C/ GALICIA (MERCADO CENTRAL)",
        "numero": "259"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA (COFARCA)",
        "numero": "260"
      },
      {
        "nombre": "C/ GALICIA, 32",
        "numero": "261"
      },
      {
        "nombre": "AVDA. PRIMERO DE MAYO, 35",
        "numero": "262"
      },
      {
        "nombre": "C/ TOMÁS MILLER, FRENTE 31",
        "numero": "263"
      },
      {
        "nombre": "C/ PASEO TOMÁS MORALES, 5",
        "numero": "264"
      },
      {
        "nombre": "C/ LUJÁN PÉREZ, 20",
        "numero": "265"
      },
      {
        "nombre": "C/ EMILIO LEY (PARQUE DORAMAS)",
        "numero": "266"
      },
      {
        "nombre": "C/ LUJÁN PÉREZ, 66",
        "numero": "267"
      },
      {
        "nombre": "AVDA PRIMERO DE MAYO, 1",
        "numero": "268"
      },
      {
        "nombre": "C/ TINGUARÓ, 18",
        "numero": "269"
      },
      {
        "nombre": "C/ PÍO XII , 27 (COLEGIO TERESIANO)",
        "numero": "270"
      },
      {
        "nombre": "C/ GUMIDAFE, 30",
        "numero": "271"
      },
      {
        "nombre": "C/ PÍO XII (ESTADIO INSULAR)",
        "numero": "272"
      },
      {
        "nombre": "C / OSORIO, 28",
        "numero": "273"
      },
      {
        "nombre": "C/ PÍO XII, 75",
        "numero": "274"
      },
      {
        "nombre": "C/ OSORIO, 58",
        "numero": "275"
      },
      {
        "nombre": "C/ GALICIA, 15 (MERCADO CENTRAL)",
        "numero": "276"
      },
      {
        "nombre": "C/ FELIPE MARTELL (LINDERO)",
        "numero": "277"
      },
      {
        "nombre": "C/ BANDAMA, 25",
        "numero": "278"
      },
      {
        "nombre": "C/ PRIMERO DE MAYO, 56",
        "numero": "279"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 38",
        "numero": "280"
      },
      {
        "nombre": "CARRETERA DE MATA (PL. DEL PINO)",
        "numero": "281"
      },
      {
        "nombre": "C/ ALBAREDA (MERCADO DEL PUERTO)",
        "numero": "282"
      },
      {
        "nombre": "CARRETERA DE MATA, 10-12  (SAN ANTONIO)",
        "numero": "283"
      },
      {
        "nombre": "C/ FARO, 11",
        "numero": "284"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, FRENTE AL Nº83",
        "numero": "285"
      },
      {
        "nombre": "C/ FARO, 43",
        "numero": "286"
      },
      {
        "nombre": "PASEO DE SAN ANTONIO, 56",
        "numero": "287"
      },
      {
        "nombre": "C/ FARO, 99",
        "numero": "288"
      },
      {
        "nombre": "C/ MARIUCHA (PLAZA DON BENITO)",
        "numero": "289"
      },
      {
        "nombre": "C/ CORONEL ROCHA (NUEVA ISLETA)",
        "numero": "290"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 24",
        "numero": "291"
      },
      {
        "nombre": "C/ EDUARDO PEÑATE SANTANA, LOCAL 4",
        "numero": "292"
      },
      {
        "nombre": "C/ ZARAGOZA, 26",
        "numero": "293"
      },
      {
        "nombre": "C/ PALMAR, FRENTE 82",
        "numero": "294"
      },
      {
        "nombre": "C/ OBISPO ROMO, FRENTE 27",
        "numero": "295"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 172",
        "numero": "296"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 51",
        "numero": "297"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 186",
        "numero": "298"
      },
      {
        "nombre": "AVDA. ESCALERITAS (CÁRITAS)",
        "numero": "299"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO (IGLESIA DE LOS DOLORES)",
        "numero": "300"
      },
      {
        "nombre": "AVDA. ESCALERITAS (CLUB LA CORNISA)",
        "numero": "301"
      },
      {
        "nombre": "C/ ALCESTE, 27",
        "numero": "302"
      },
      {
        "nombre": "PASEO DE CHIL (ESTADIO INSULAR)",
        "numero": "303"
      },
      {
        "nombre": "C/ ZARAGOZA, 27",
        "numero": "304"
      },
      {
        "nombre": "C/ OBISPO ROMO (MERCADO DE ALTAVISTA)",
        "numero": "306"
      },
      {
        "nombre": "C/ PÁRROCO VILLAR REINA, F/ Nª8",
        "numero": "307"
      },
      {
        "nombre": "C/ OBISPO ROMO (PARQUE HERMANOS MILLARES)",
        "numero": "308"
      },
      {
        "nombre": "PASEO DE CHIL (JARDINES RUBIÓ)",
        "numero": "309"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 48",
        "numero": "310"
      },
      {
        "nombre": "C/ TOMÁS MILLER (PLAYA DE LAS CANTERAS)",
        "numero": "311"
      },
      {
        "nombre": "PASEO DE CHIL (ESTADIO INSULAR)",
        "numero": "312"
      },
      {
        "nombre": "C/ ALFREDO L. JONES, 1",
        "numero": "313"
      },
      {
        "nombre": "C/ OLOF PALME, 40",
        "numero": "314"
      },
      {
        "nombre": "C/ FARMACÉUTICO PEDRO RIVERO (POLÍGONO CRUZ DE PIEDRA)",
        "numero": "315"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 40",
        "numero": "316"
      },
      {
        "nombre": "CARRETERA DE MATA, 42",
        "numero": "317"
      },
      {
        "nombre": "CARRETERA DE MATA (PARQUE DE LAS REHOYAS)",
        "numero": "319"
      },
      {
        "nombre": "CALZADA LATERAL DEL NORTE (DIVINA PASTORA)",
        "numero": "320"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 14",
        "numero": "321"
      },
      {
        "nombre": "CALZADA LATERAL DEL NORTE (C.S. MILLER BAJO)",
        "numero": "322"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 30",
        "numero": "323"
      },
      {
        "nombre": "C/ VIRGEN DE LA PALOMA, FRENTE 19",
        "numero": "324"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC, 43",
        "numero": "325"
      },
      {
        "nombre": "C/ VIRGEN DE LA PALOMA (IGLESIA DE LA PAZ)",
        "numero": "326"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC (PLAZA MARTÍN COBOS)",
        "numero": "327"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO,54",
        "numero": "328"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC (BINGO CINEMA)",
        "numero": "329"
      },
      {
        "nombre": "C/ JUAN SARAZÁ ORTÍZ, FRENTE 7",
        "numero": "330"
      },
      {
        "nombre": "C/ JUAN SARAZÁ ORTÍZ, 14",
        "numero": "331"
      },
      {
        "nombre": "C/ CRUZ DE PIEDRA, 9",
        "numero": "332"
      },
      {
        "nombre": "C/ CRUZ DE PIEDRA, FRENTE  7",
        "numero": "333"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 1",
        "numero": "334"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE  1",
        "numero": "335"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 33",
        "numero": "336"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE 35",
        "numero": "337"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 71",
        "numero": "338"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE 73",
        "numero": "339"
      },
      {
        "nombre": "C/ PINO APOLINARIO, 9",
        "numero": "340"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, FRENTE 92",
        "numero": "341"
      },
      {
        "nombre": "C/ PINO APOLINARIO,  53",
        "numero": "342"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, FRENTE  42",
        "numero": "343"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, FRENTE 238",
        "numero": "344"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, 7",
        "numero": "345"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO (BARRANCO)",
        "numero": "346"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (BAMBÚ)",
        "numero": "347"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO",
        "numero": "348"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 32",
        "numero": "349"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO, 117",
        "numero": "350"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA (REAL DEL CASTILLO)",
        "numero": "351"
      },
      {
        "nombre": "C/ FARMACÉUTICO PEDRO RIVERO, 1",
        "numero": "352"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA, 50",
        "numero": "353"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA, 24",
        "numero": "355"
      },
      {
        "nombre": "C/ FARMACEÚTICO PEDRO RIVERO (JOAQUIN BELÓN)",
        "numero": "356"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (HOSPITAL DR. NEGRÍN)",
        "numero": "357"
      },
      {
        "nombre": "C/ FARMACEÚTICO PEDRO RIVERO, 20",
        "numero": "359"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN, 67",
        "numero": "360"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN, 145",
        "numero": "362"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 120",
        "numero": "363"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN (IGLESIA SAN MARCOS)",
        "numero": "364"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 152",
        "numero": "365"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 114",
        "numero": "366"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 194",
        "numero": "367"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 104",
        "numero": "368"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 204",
        "numero": "369"
      },
      {
        "nombre": "AVDA, ESCALERITAS, 84",
        "numero": "370"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 109",
        "numero": "371"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 70",
        "numero": "372"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 95",
        "numero": "373"
      },
      {
        "nombre": "CARRETERA DEL NORTE (IES CRUZ DE PIEDRA)",
        "numero": "374"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 79",
        "numero": "375"
      },
      {
        "nombre": "CARRETERA DEL NORTE (FRENTE CC LA BALLENA)",
        "numero": "376"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 57",
        "numero": "377"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (SALIDA DE LA PATERNA)",
        "numero": "378"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 40",
        "numero": "379"
      },
      {
        "nombre": "CARRETERA DEL NORTE (CC LA BALLENA)",
        "numero": "380"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 68",
        "numero": "381"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, 383",
        "numero": "382"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (PUENTE AÉREO)",
        "numero": "383"
      },
      {
        "nombre": "C/ HENRY DUNANT, FRENTE 42",
        "numero": "384"
      },
      {
        "nombre": "CARRETERA DEL NORTE (LOS TARAHALES)",
        "numero": "385"
      },
      {
        "nombre": "C/ CRONISTA MARTÍN MORENO,8",
        "numero": "386"
      },
      {
        "nombre": "ACCESO MANUEL DE FALLA",
        "numero": "387"
      },
      {
        "nombre": "C/ PEPE DAMASO, 43",
        "numero": "388"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 118",
        "numero": "389"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 234",
        "numero": "390"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE  11",
        "numero": "391"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 169",
        "numero": "392"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 84",
        "numero": "393"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN PARQUE CENTRAL)",
        "numero": "394"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 72",
        "numero": "395"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 7",
        "numero": "396"
      },
      {
        "nombre": "C/ EMILIO ARRIETA, FRENTE  7",
        "numero": "397"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (C.S. ALCARAVANERAS)",
        "numero": "398"
      },
      {
        "nombre": "CARRETERA DEL NORTE (LOS TARAHALES)",
        "numero": "399"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (MADERA Y CORCHO)",
        "numero": "400"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 178",
        "numero": "401"
      },
      {
        "nombre": "C/ COSTA RICA, FRENTE 33",
        "numero": "402"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 50",
        "numero": "403"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (C.C. LAS RAMBLAS)",
        "numero": "404"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 225",
        "numero": "405"
      },
      {
        "nombre": "C/ CASTILLEJOS, 23",
        "numero": "406"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSÉ SÁNCHEZ PEÑATE (CC LAS ARENAS),NORTE",
        "numero": "407"
      },
      {
        "nombre": "C/ CASTILLEJOS, 71",
        "numero": "408"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (C.S. ALCARAVANERAS)",
        "numero": "409"
      },
      {
        "nombre": "C/ NUMANCIA, 68",
        "numero": "410"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (MADERA Y CORCHO)",
        "numero": "411"
      },
      {
        "nombre": "PLAZA DE SAN LORENZO",
        "numero": "412"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 118",
        "numero": "413"
      },
      {
        "nombre": "C/ MARIA DOLOROSA, 1",
        "numero": "414"
      },
      {
        "nombre": "C/ SIMANCAS, 70",
        "numero": "415"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 282",
        "numero": "416"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 34",
        "numero": "417"
      },
      {
        "nombre": "C/ LORENZO SUÁREZ RIVERO, 9",
        "numero": "418"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 78",
        "numero": "419"
      },
      {
        "nombre": "C/ VEGA DE RÍO PALMA, 48",
        "numero": "420"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 100",
        "numero": "421"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 52",
        "numero": "422"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "423"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 28",
        "numero": "424"
      },
      {
        "nombre": "AVDA. SEMANA DE LA PASION, 29",
        "numero": "425"
      },
      {
        "nombre": "C/ SAN FERMÍN, 20",
        "numero": "426"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "427"
      },
      {
        "nombre": "C/ GALILEA, 34",
        "numero": "428"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "429"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 30",
        "numero": "430"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 2",
        "numero": "431"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 20",
        "numero": "432"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 14",
        "numero": "433"
      },
      {
        "nombre": "C/ JUAN SÁNCHEZ DE LA COBA, 16",
        "numero": "434"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN F/89",
        "numero": "435"
      },
      {
        "nombre": "AUTOVÍA DE GUINIGUADA",
        "numero": "436"
      },
      {
        "nombre": "AVDA. MESA Y LOPEZ, 86",
        "numero": "437"
      },
      {
        "nombre": "C/ SEVERO OCHOA (C.S. EL BATÁN)",
        "numero": "438"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSÉ SÁNCHEZ PEÑATE (CC LAS ARENAS),SUR",
        "numero": "439"
      },
      {
        "nombre": "C/ JOSE LUIS GUERRA DE ARMAS (CRUCE LAS COLORADAS)",
        "numero": "440"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (CLUB NÁUTICO)",
        "numero": "441"
      },
      {
        "nombre": "C/ CRUZ DEL OVEJERO, 28",
        "numero": "442"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "443"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 172",
        "numero": "444"
      },
      {
        "nombre": "AVDA. DE AMURGA (PASEO BLAS CABRERA FELIPE)",
        "numero": "445"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 140",
        "numero": "446"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASABLANCA)",
        "numero": "447"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 68",
        "numero": "448"
      },
      {
        "nombre": "SABINO BERTHELOT (ENLACE LINEAS 9- 12-13)",
        "numero": "449"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE F/Nº 35  (ROTONDA LOMO LOS FRAILES)",
        "numero": "450"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS (ENLACE LINEAS 12-13)",
        "numero": "451"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (URBANIZACIÓN LA GUILLENA)",
        "numero": "452"
      },
      {
        "nombre": "C/ MIMOSA (NARDO)",
        "numero": "454"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 196",
        "numero": "455"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE FRENTE 71",
        "numero": "456"
      },
      {
        "nombre": "C/ JOSE LUIS GUERRA DE ARMAS (ALONSO QUIJANO)",
        "numero": "457"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (LAS PERRERAS)",
        "numero": "458"
      },
      {
        "nombre": "C/ CRUZ DEL OVEJERO, 25",
        "numero": "459"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE, FRENTE 21",
        "numero": "460"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 171",
        "numero": "461"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (URB. IND. LOMO BLANCO)",
        "numero": "462"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 143",
        "numero": "463"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (CRUCE LAS TORRES)",
        "numero": "464"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (URBANIZACIÓN DÍAZ CASANOVAS)",
        "numero": "466"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN, FRENTE 49",
        "numero": "468"
      },
      {
        "nombre": "CARRETERA GENERAL DEL NORTE",
        "numero": "469"
      },
      {
        "nombre": "CARRETERA DE CHILE, FRENTE 91",
        "numero": "470"
      },
      {
        "nombre": "CARRETERA GENERAL DEL NORTE (LA GUILLENA)",
        "numero": "471"
      },
      {
        "nombre": "CARRETERA DE CHILE, 68",
        "numero": "472"
      },
      {
        "nombre": "CARRETERA TAMARACEITE (LAS PERRERAS)",
        "numero": "473"
      },
      {
        "nombre": "CARRETERA DE CHILE (CAMPO DE GOLF)",
        "numero": "474"
      },
      {
        "nombre": "CARRETERA TAMARACEITE, FRENTE 62",
        "numero": "475"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 150",
        "numero": "476"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE  (LAS MAJADILLAS)",
        "numero": "477"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 138",
        "numero": "478"
      },
      {
        "nombre": "CARRETERA TAMARACEITE (DANONE)",
        "numero": "479"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO (TISCAMANITA)",
        "numero": "480"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (CRUCE LAS TORRES)",
        "numero": "481"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 62",
        "numero": "482"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (URBANIZACIÓN DÍAZ CASANOVAS)",
        "numero": "483"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 30",
        "numero": "484"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN, 41",
        "numero": "485"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME (PLAZOLETA FARRAY)",
        "numero": "486"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, 1",
        "numero": "487"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME (FRAY JUNIPERO)",
        "numero": "488"
      },
      {
        "nombre": "CARRETERA DE CHILE, 75",
        "numero": "489"
      },
      {
        "nombre": "C/ JUNCO (AMAPOLA)",
        "numero": "490"
      },
      {
        "nombre": "CARRETERA DE CHILE, 45",
        "numero": "491"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 138",
        "numero": "492"
      },
      {
        "nombre": "CARRETERA DE CHILE (CAMPO DE GOLF)",
        "numero": "493"
      },
      {
        "nombre": "C/ MUNGUÍA, 8",
        "numero": "494"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 185",
        "numero": "495"
      },
      {
        "nombre": "AVDA. RAFAEL CABRERA (SAN TELMO)",
        "numero": "496"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 85",
        "numero": "497"
      },
      {
        "nombre": "C/ JUNCO (HIPERDINO)",
        "numero": "498"
      },
      {
        "nombre": "C/ AREQUIPA (GUAGUAS MUNICIPALES)",
        "numero": "500"
      },
      {
        "nombre": "C/ MADRESELVA, FRENTE 69",
        "numero": "501"
      },
      {
        "nombre": "CARRETERA A LAS TORRES, 21 ESQUINA MADRESELVA",
        "numero": "502"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 94",
        "numero": "504"
      },
      {
        "nombre": "C/ NARDO, 31",
        "numero": "506"
      },
      {
        "nombre": "C/ MADRESELVA F/Nº 82",
        "numero": "508"
      },
      {
        "nombre": "C/ ACONCAGUA, 1",
        "numero": "510"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 42",
        "numero": "511"
      },
      {
        "nombre": "C/ ACONCAGUA (COLEGIO CASABLANCA III)",
        "numero": "512"
      },
      {
        "nombre": "C/ LENTINI (MONOPOL)",
        "numero": "513"
      },
      {
        "nombre": "C/ ACONCAGUA, FRENTE 3",
        "numero": "515"
      },
      {
        "nombre": "C/ ACONCAGUA  (COLEGIO CASABLANCA III)",
        "numero": "517"
      },
      {
        "nombre": "C/ARCHIVERO JOAQUIN BLANCO MONTESDEOCA (PEDRO BARBER)",
        "numero": "518"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO (MIMOSA)",
        "numero": "519"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA , 21",
        "numero": "520"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, 4",
        "numero": "521"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, 27",
        "numero": "522"
      },
      {
        "nombre": "AVDA. RAFAEL CABRERA (TEATRO)",
        "numero": "523"
      },
      {
        "nombre": "C/ PASEO DE SAN ANTONIO, 85",
        "numero": "524"
      },
      {
        "nombre": "C/ ARMINDA, FRENTE 1",
        "numero": "525"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA 28",
        "numero": "527"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUÍN BLANCO MONTESDEOCA (RTDA. NICOLÁS DÍAZ CHICO)",
        "numero": "529"
      },
      {
        "nombre": "C/ ALCALDE DÍAZ SAAVEDRA NAVARRO (PRUDENCIO GUZMÁN)",
        "numero": "530"
      },
      {
        "nombre": "C/ VERACRUZ, 16",
        "numero": "531"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA, FRENTE 18",
        "numero": "532"
      },
      {
        "nombre": "C/ MARIANAO, 60",
        "numero": "533"
      },
      {
        "nombre": "C/ PINO APOLINARIO (IGLESIA LOMO APOLINARIO)",
        "numero": "534"
      },
      {
        "nombre": "C/ MONTERREY, 1",
        "numero": "535"
      },
      {
        "nombre": "C/ BUENOS AIRES, 43",
        "numero": "536"
      },
      {
        "nombre": "C/ ARMINDA (LA FAVORITA)",
        "numero": "540"
      },
      {
        "nombre": "AVDA. DE AMURGA (IGLESIA)",
        "numero": "541"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (CANARIAS 7)",
        "numero": "543"
      },
      {
        "nombre": "C/ MARIANAO, 5",
        "numero": "544"
      },
      {
        "nombre": "PLAZA BARRANCO LA BALLENA",
        "numero": "545"
      },
      {
        "nombre": "C/ MARIANAO, 53",
        "numero": "546"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR, 28",
        "numero": "547"
      },
      {
        "nombre": "C/ MARIANAO, 103",
        "numero": "548"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, FRENTE 74",
        "numero": "549"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, 55",
        "numero": "551"
      },
      {
        "nombre": "C/ PROFESOR LOZANO, 10",
        "numero": "552"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 25",
        "numero": "554"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 2",
        "numero": "555"
      },
      {
        "nombre": "AVDA AMURGA (IGLESIA)",
        "numero": "556"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 18",
        "numero": "557"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR (PLAZA BARRANCO DE LA BALLENA)",
        "numero": "558"
      },
      {
        "nombre": "C/ PINO APOLINARIO, 86",
        "numero": "559"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR, FRENTE 26",
        "numero": "560"
      },
      {
        "nombre": "CARRETERA EL CARDÓN, FRENTE 118",
        "numero": "561"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (NUEVA PATERNA)",
        "numero": "562"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (IES FELO MONZON)",
        "numero": "563"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 52",
        "numero": "564"
      },
      {
        "nombre": "CTRA. LOMO BLANCO, 94",
        "numero": "565"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (COLEGIO LA PATERNA)",
        "numero": "566"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (URBANIZACIÓN EL ZURBARÁN)",
        "numero": "567"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 49",
        "numero": "568"
      },
      {
        "nombre": "C/ VERACRUZ, 36",
        "numero": "569"
      },
      {
        "nombre": "C/ ZARAGOZA ( DON PEDRO INFINITO)",
        "numero": "570"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 20",
        "numero": "572"
      },
      {
        "nombre": "AUTOVÍA GUINIGUADA (TEATRO GUINIGUADA)",
        "numero": "574"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 17",
        "numero": "576"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (URBANIZACIÓN EL ZURBARÁN)",
        "numero": "578"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "579"
      },
      {
        "nombre": "CTRA. LOMO BLANCO, 81",
        "numero": "580"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 12",
        "numero": "581"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, FRENTE 51",
        "numero": "582"
      },
      {
        "nombre": "C/ BETANIA, 69",
        "numero": "583"
      },
      {
        "nombre": "C/ BETANIA, 41",
        "numero": "585"
      },
      {
        "nombre": "C/ BETANIA, 7",
        "numero": "587"
      },
      {
        "nombre": "C/ SAN BORONDÓN, 10",
        "numero": "589"
      },
      {
        "nombre": "AVDA. DE LA FERIA (URBANIZACIÓN LOS GERANIOS)",
        "numero": "595"
      },
      {
        "nombre": "C/ HEBRÓN, 2",
        "numero": "596"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA, FRENTE 3",
        "numero": "597"
      },
      {
        "nombre": "C/ HEBRÓN, 24",
        "numero": "598"
      },
      {
        "nombre": "C/ GALILEA, FRENTE 6",
        "numero": "599"
      },
      {
        "nombre": "C/ VENTURA DORESTE,  7",
        "numero": "600"
      },
      {
        "nombre": "C/ SAN ANDRÉS, FRENTE 6",
        "numero": "601"
      },
      {
        "nombre": "CARRETERA DE TEROR",
        "numero": "603"
      },
      {
        "nombre": "C/ LAS BORRERAS, 1",
        "numero": "604"
      },
      {
        "nombre": "CIENCIAS BÁSICAS/ INFORMÁTICA",
        "numero": "605"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA, 3",
        "numero": "606"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA (HOSPITAL JUAN CARLOS I)",
        "numero": "607"
      },
      {
        "nombre": "AVDA. DE LA FERIA (URBANIZACIÓN LOS GERANIOS)",
        "numero": "608"
      },
      {
        "nombre": "C/ ALICANTE (C.S. SAN JOSÉ)",
        "numero": "610"
      },
      {
        "nombre": "C/ SAN JOSÉ ARTESANO, 46",
        "numero": "611"
      },
      {
        "nombre": "CIENCIAS BÁSICAS/ TEOLOGÍA",
        "numero": "612"
      },
      {
        "nombre": "CARRETERA LOMO BLANCO, 54",
        "numero": "613"
      },
      {
        "nombre": "C/ NUEVA, 73",
        "numero": "614"
      },
      {
        "nombre": "HOSPITAL JUAN CARLOS I",
        "numero": "615"
      },
      {
        "nombre": "AVDA. DE LA FERIA (INFECAR)",
        "numero": "617"
      },
      {
        "nombre": "C/ GALILEA, 8",
        "numero": "618"
      },
      {
        "nombre": "HOSPITAL JUAN CARLOS I (REHABILITACIÓN)",
        "numero": "619"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 6",
        "numero": "620"
      },
      {
        "nombre": "C/ ACONCAGUA, 38",
        "numero": "621"
      },
      {
        "nombre": "CARRETERA DE TEROR, 16",
        "numero": "622"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 39",
        "numero": "623"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (FRENTE HIPERCOR)",
        "numero": "624"
      },
      {
        "nombre": "CARRETERA DEL CENTRO (ANTIGUA CÁRCEL)",
        "numero": "625"
      },
      {
        "nombre": "C/ CASTILLO, 16",
        "numero": "626"
      },
      {
        "nombre": "C/ LAS BORRERAS, 10",
        "numero": "627"
      },
      {
        "nombre": "C/ LAS BORRERAS, FRENTE 1",
        "numero": "629"
      },
      {
        "nombre": "C/ ACONCAGUA- CRUCE CON ORINOCO",
        "numero": "630"
      },
      {
        "nombre": "C/ SAN FERNANDO, 38",
        "numero": "631"
      },
      {
        "nombre": "AVDA. DE AMURGA (CARRETERA SAN JUAN DE DIOS)",
        "numero": "633"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (JUZGADOS)",
        "numero": "634"
      },
      {
        "nombre": "C/ FONDOS DE SEGURA, FRENTE 17",
        "numero": "635"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 37",
        "numero": "636"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 28",
        "numero": "637"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 29",
        "numero": "638"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (CATAMARCA)",
        "numero": "639"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (REYES CATÓLICOS)",
        "numero": "640"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (ROTONDA AREQUIPA)",
        "numero": "641"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (PARQUE ROMANO)",
        "numero": "642"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 26",
        "numero": "643"
      },
      {
        "nombre": "C/ CÓRDOBA (BOMBEROS VEGUETA)",
        "numero": "644"
      },
      {
        "nombre": "CATAMARCA, FRENTE  2",
        "numero": "646"
      },
      {
        "nombre": "C/ PROFESOR LOZANO, 34",
        "numero": "648"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 39",
        "numero": "650"
      },
      {
        "nombre": "AVDA.DE AMURGA (EL LASSO, BLOQUE 1)",
        "numero": "651"
      },
      {
        "nombre": "C/ GUANTÁNAMO, FRENTE 121",
        "numero": "655"
      },
      {
        "nombre": "AVDA. DE AMURGA (ACCESO A LOS GRANJEROS)",
        "numero": "656"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 108",
        "numero": "657"
      },
      {
        "nombre": "AVDA. DE AMURGA (CARRETERA SAN JUAN DE DIOS)",
        "numero": "658"
      },
      {
        "nombre": "LOMO DEL CAPON POSTERIOR, 6",
        "numero": "659"
      },
      {
        "nombre": "C/ MARIANAO, FRENTE 82",
        "numero": "660"
      },
      {
        "nombre": "C/ GALILEA, 31",
        "numero": "661"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 115",
        "numero": "662"
      },
      {
        "nombre": "C/ ALBAHACA (I.E.S. JOSE SARAMAGO)",
        "numero": "663"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 165",
        "numero": "664"
      },
      {
        "nombre": "C/ JUDAS TADEO (BARRANQUILLO)",
        "numero": "665"
      },
      {
        "nombre": "PARQUE TECNOLÓGICO",
        "numero": "666"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO",
        "numero": "667"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CARVAJAL)",
        "numero": "668"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO (SAN NICOLÁS)",
        "numero": "669"
      },
      {
        "nombre": "C/ ALBAHACA (I.E.S. JOSE SARAMAGO)",
        "numero": "670"
      },
      {
        "nombre": "C/ SIERRA NEVADA, FRENTE  44",
        "numero": "671"
      },
      {
        "nombre": "C/ JUDAS TADEO, 34",
        "numero": "672"
      },
      {
        "nombre": "C/ GUANTÁNAMO (CENTRO P. SALTO DEL NEGRO)",
        "numero": "673"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 215",
        "numero": "674"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 72",
        "numero": "675"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 102B",
        "numero": "676"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 42",
        "numero": "677"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 64",
        "numero": "678"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, 41",
        "numero": "679"
      },
      {
        "nombre": "C/ SAN JUDAS TADEO (BARRANQUILLO)",
        "numero": "680"
      },
      {
        "nombre": "C/ ARQUITECTO JOSE LUIS JIMENEZ, 3",
        "numero": "681"
      },
      {
        "nombre": "BIBLIOTECA UNIVERSITARIA",
        "numero": "682"
      },
      {
        "nombre": "VIAL SIN NOMBRE",
        "numero": "683"
      },
      {
        "nombre": "ALAMEDA DE COLÓN",
        "numero": "684"
      },
      {
        "nombre": "C/ ISLA DE LA MONTAÑA CLARA, FRENTE 5",
        "numero": "685"
      },
      {
        "nombre": "BERNARDINO CORREA VIERA (C.S. TRIANA)",
        "numero": "686"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 73",
        "numero": "687"
      },
      {
        "nombre": "BIBLIOTECA UNIVERSITARIA",
        "numero": "688"
      },
      {
        "nombre": "BERNARDINO CORREA VIERA,  FRENTE 13",
        "numero": "689"
      },
      {
        "nombre": "AULARIO CIENCIAS JURÍDICAS",
        "numero": "690"
      },
      {
        "nombre": "CIENCIAS JURIDICAS (MÓDULO B)",
        "numero": "691"
      },
      {
        "nombre": "C/ TABLERO DE GONZALO, FRENTE  7",
        "numero": "692"
      },
      {
        "nombre": "C/ JUDAS TADEO, 36",
        "numero": "693"
      },
      {
        "nombre": "C/ MIGUEL MARTIN FERNANDEZ DE LA TORRE (CENTRO DE MENORES)",
        "numero": "694"
      },
      {
        "nombre": "C/ MANZANILLA FRENTE 14",
        "numero": "695"
      },
      {
        "nombre": "C/ TUNERILLAS, FRENTE 20",
        "numero": "696"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 17",
        "numero": "698"
      },
      {
        "nombre": "C/ TABLERO DE GONZALO",
        "numero": "699"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 25",
        "numero": "700"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 88",
        "numero": "701"
      },
      {
        "nombre": "AVDA. DE ANSITE ( FRENTE CEMENTERIO DEL PUERTO)",
        "numero": "702"
      },
      {
        "nombre": "AVDA. DE ANSITE (CEMENTERIO DEL PUERTO)",
        "numero": "703"
      },
      {
        "nombre": "C/ HOYA DE LA GALLINA (ESTADIO GRAN CANARIA)",
        "numero": "704"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (HOSPITALIZACIÓN)",
        "numero": "705"
      },
      {
        "nombre": "ROTONDA HOSPITAL DR. NEGRÍN",
        "numero": "706"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (ROTONDA HOSPITAL DR. NEGRÍN)",
        "numero": "708"
      },
      {
        "nombre": "CARRETERA CIUDAD SAN JUAN DE DIOS (GUINCHO)",
        "numero": "709"
      },
      {
        "nombre": "C/ PARDELA 14",
        "numero": "711"
      },
      {
        "nombre": "C/ MIMOSA",
        "numero": "712"
      },
      {
        "nombre": "CIENCIAS BÁSICAS",
        "numero": "714"
      },
      {
        "nombre": "CARRETERA CIUDAD SAN JUAN DE DIOS (GUINCHO)",
        "numero": "715"
      },
      {
        "nombre": "C/ MIMOSA",
        "numero": "717"
      },
      {
        "nombre": "C/ CAMELIA, FRENTE 11",
        "numero": "719"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 22",
        "numero": "721"
      },
      {
        "nombre": "C/ MARIUCHA (CANÓDROMO)",
        "numero": "722"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 38",
        "numero": "723"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 3",
        "numero": "724"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (C.C. SIETE PALMAS)",
        "numero": "725"
      },
      {
        "nombre": "C/ JUDAS TADEO, 66",
        "numero": "726"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, FRENTE 102",
        "numero": "728"
      },
      {
        "nombre": "INGENIERÍAS",
        "numero": "731"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 12",
        "numero": "733"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 3",
        "numero": "734"
      },
      {
        "nombre": "C/ JUDAS TADEO, 61",
        "numero": "735"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "736"
      },
      {
        "nombre": "C/ SERVENTIA, 145",
        "numero": "738"
      },
      {
        "nombre": "C/ PLUTÓN, FRENTE 14",
        "numero": "739"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE (FÁBRICA DE TEJAS)",
        "numero": "740"
      },
      {
        "nombre": "C/ LEOPOLDO ALONSO, 5",
        "numero": "741"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE (GASOLINERA)",
        "numero": "742"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 20",
        "numero": "743"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE",
        "numero": "744"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, FRENTE 47",
        "numero": "745"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 135",
        "numero": "746"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, FRENTE 71",
        "numero": "747"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 169",
        "numero": "748"
      },
      {
        "nombre": "C/ SERVENTÍA, 189",
        "numero": "749"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 259",
        "numero": "750"
      },
      {
        "nombre": "C/ SERVENTÍA, 101",
        "numero": "751"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 400",
        "numero": "752"
      },
      {
        "nombre": "C/ SERVENTIA, 85",
        "numero": "753"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 3",
        "numero": "754"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, FRENTE 32",
        "numero": "756"
      },
      {
        "nombre": "C/ PLUTÓN (CEIP HOYA ANDREA)",
        "numero": "757"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 69",
        "numero": "758"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 230",
        "numero": "759"
      },
      {
        "nombre": "C/ LORENZO SUÁREZ RIVERO, FRENTE 51",
        "numero": "760"
      },
      {
        "nombre": "CARRETERA NUEVA DE SAN LORENZO",
        "numero": "761"
      },
      {
        "nombre": "C/ LORENZO SUAREZ RIVERO, 22",
        "numero": "762"
      },
      {
        "nombre": "CARRETERA NUEVA DE SAN LORENZO (GASOLINERA)",
        "numero": "763"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 282",
        "numero": "764"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 120",
        "numero": "765"
      },
      {
        "nombre": "C/ OLIVO (CARRETERA DE ALMATRICHE)",
        "numero": "766"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 154",
        "numero": "767"
      },
      {
        "nombre": "C/ HABANA, 27",
        "numero": "768"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 188",
        "numero": "769"
      },
      {
        "nombre": "C/ PINTOR JUAN GUILLERMO, FRENTE 19",
        "numero": "770"
      },
      {
        "nombre": "CARRETERA SAN LORENZO 254",
        "numero": "771"
      },
      {
        "nombre": "C/ PINTOR JUAN GUILLERMO (C.C. LA MINILLA)",
        "numero": "772"
      },
      {
        "nombre": "C/ LEOPOLDO ALONSO",
        "numero": "773"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 13",
        "numero": "774"
      },
      {
        "nombre": "C/ EL OLIVO (CARRETERA DE ALMATRICHE)",
        "numero": "775"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 61",
        "numero": "776"
      },
      {
        "nombre": "C/ HABANA, 28",
        "numero": "777"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 9",
        "numero": "778"
      },
      {
        "nombre": "AVDA. GARCIA LORCA, FRENTE 14",
        "numero": "779"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 41",
        "numero": "780"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, FRENTE 11",
        "numero": "781"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 70",
        "numero": "783"
      },
      {
        "nombre": "CARRETERA SUBIDA A TAFIRA (LA FAVORITA)",
        "numero": "786"
      },
      {
        "nombre": "CTRA. PICO VIENTO (ASILO DE ANCIANOS)",
        "numero": "787"
      },
      {
        "nombre": "CTRA. PICO VIENTO (ASILO DE ANCIANOS)",
        "numero": "788"
      },
      {
        "nombre": "AVDA. GARCIA LORCA, 17",
        "numero": "789"
      },
      {
        "nombre": "C/ LÁZARO  DE ORTEGA (CIUDAD DEL CAMPO)",
        "numero": "791"
      },
      {
        "nombre": "C/ LÁZARO DE ORTEGA, 39",
        "numero": "793"
      },
      {
        "nombre": "C/ CUESTA BLANCA, FRENTE 11",
        "numero": "795"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 34",
        "numero": "797"
      },
      {
        "nombre": "PASEO TOMAS MORALES, 4",
        "numero": "799"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "892"
      },
      {
        "nombre": "INTERCAMBIADOR DE TAMARACEITE",
        "numero": "893"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "894"
      },
      {
        "nombre": "LATERAL NORTE - MERCADO VEGUETA",
        "numero": "895"
      },
      {
        "nombre": "C/ SIERRA NEVADA (SAN FRANCISCO)",
        "numero": "897"
      },
      {
        "nombre": "INGENIERÍAS",
        "numero": "898"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "899"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "901"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (IES FELO MONZON)",
        "numero": "902"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, FRENTE 51",
        "numero": "903"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (FRENTE HIPERCOR)",
        "numero": "904"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 72",
        "numero": "905"
      },
      {
        "nombre": "C/ BETANIA, 69",
        "numero": "906"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, FRENTE 51",
        "numero": "907"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "928"
      },
      {
        "nombre": "LA BALLENA",
        "numero": "929"
      },
      {
        "nombre": "TEATRO",
        "numero": "930"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "931"
      },
      {
        "nombre": "TEATRO",
        "numero": "932"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "933"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "934"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "935"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "936"
      },
      {
        "nombre": "TEATRO",
        "numero": "938"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "939"
      },
      {
        "nombre": "GUINIGUADA",
        "numero": "940"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "941"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "942"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ (EL SEBADAL)",
        "numero": "943"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "944"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (HOSPITAL DR. NEGRÍN)",
        "numero": "945"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "946"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "947"
      },
      {
        "nombre": "GUINIGUADA",
        "numero": "948"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 56",
        "numero": "949"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "950"
      },
      {
        "nombre": "RESIDENCIAS (CAMPUS UNIVERSITARIO)",
        "numero": "951"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "955"
      },
      {
        "nombre": "TEATRO",
        "numero": "956"
      },
      {
        "nombre": "AVDA. SEMANA DE LA PASIÓN, 13  (LAS COLORADAS)",
        "numero": "957"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "958"
      },
      {
        "nombre": "C/ JUDAS TADEO (ISLA PERDIDA)",
        "numero": "959"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "960"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "962"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "963"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "965"
      },
      {
        "nombre": "INTERCAMBIADOR DE TAMARACEITE",
        "numero": "966"
      },
      {
        "nombre": "CAMPUS UNIVERSITARIO (INGENIERÍAS)",
        "numero": "968"
      },
      {
        "nombre": "C/ LEONARDO TORRIANI (ZÁRATE)",
        "numero": "970"
      },
      {
        "nombre": "AVDA DEL PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "971"
      },
      {
        "nombre": "C/ GAVILAN (RESIDENCIAL LOS GRANJEROS)",
        "numero": "972"
      },
      {
        "nombre": "C/ OTOÑO (HOYA ANDREA)",
        "numero": "973"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "974"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN",
        "numero": "975"
      },
      {
        "nombre": "TEATRO",
        "numero": "976"
      },
      {
        "nombre": "C/ CRONISTA NAVARRO RUIZ ,6",
        "numero": "977"
      },
      {
        "nombre": "CIUDAD DE SAN JUAN DE DIOS",
        "numero": "978"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "979"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO (SAN FRANCISCO DE PAULA)",
        "numero": "980"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "981"
      },
      {
        "nombre": "TEATRO",
        "numero": "982"
      },
      {
        "nombre": "CAMPUS UNIVERSITARIO (INGENIERÍAS)       (ES LA MISMA QUE LA P898)",
        "numero": "983"
      },
      {
        "nombre": "TEATRO",
        "numero": "984"
      },
      {
        "nombre": "C/ ARMINDA, 28 (EL SECADERO)",
        "numero": "985"
      },
      {
        "nombre": "TEATRO",
        "numero": "986"
      },
      {
        "nombre": "C/ LOMO DE LA CRUZ",
        "numero": "987"
      },
      {
        "nombre": "TEATRO",
        "numero": "988"
      },
      {
        "nombre": "C/ SIERRA NEVADA (SAN FRANCISCO)",
        "numero": "989"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "990"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "991"
      },
      {
        "nombre": "TEATRO",
        "numero": "992"
      },
      {
        "nombre": "MERCADO DE  VEGUETA",
        "numero": "993"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "994"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "995"
      },
      {
        "nombre": "EDUARDO BENOT (frente los bardinos)",
        "numero": "996"
      },
      {
        "nombre": "TEATRO",
        "numero": "998"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "999"
      },
      {
        "nombre": "GLORIA",
        "numero": "465"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "892"
      },
      {
        "nombre": "AVDA. MARITIMA DEL SUR",
        "numero": "516"
      },
      {
        "nombre": "Aparcamiento Inter-Modal El Rincón",
        "numero": "509"
      },
      {
        "nombre": "Carretera de Mata (Castillo de Mata)",
        "numero": "318"
      },
      {
        "nombre": "JUAN M DURAN GALICIA",
        "numero": "782"
      },
      {
        "nombre": "MIGUEL CURBELO AUTORIDAD PORTUARIA",
        "numero": "573"
      },
      {
        "nombre": "ROTONDA CAPITAN N.MASTRO",
        "numero": "575"
      },
      {
        "nombre": "MUELLE LEON Y CASTILLO GASOLINERA BP",
        "numero": "577"
      },
      {
        "nombre": "Av de las Petroliferas Depositos Comerciales",
        "numero": "579"
      },
      {
        "nombre": "MIGUEL CURBELO AUTORIDAD PORTUARIA",
        "numero": "586"
      },
      {
        "nombre": "MUELLE LEON Y CASTILLO GASOLINERA BP",
        "numero": "588"
      },
      {
        "nombre": "Av de las Petroliferas Depositos Comerciales",
        "numero": "590"
      },
      {
        "nombre": "Av de las Petroliferas Astican",
        "numero": "591"
      },
      {
        "nombre": "Av de las Petroliferas Astican",
        "numero": "592"
      },
      {
        "nombre": "Av de las Petroliferas Repnaval",
        "numero": "593"
      },
      {
        "nombre": "Av de las Petroliferas Repnaval",
        "numero": "594"
      },
      {
        "nombre": "REINA SOFIA",
        "numero": "937"
      },
      {
        "nombre": "M BECERRA L20",
        "numero": "953"
      },
      {
        "nombre": "San Cristobal Acceso Av Maritima",
        "numero": "526"
      },
      {
        "nombre": "San Cristobal Estribor",
        "numero": "514"
      },
      {
        "nombre": "C/ FARMACEUTICO PEDRO RIVERO, FRENTE 15",
        "numero": "361"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (OFICINAS MUNICIPALES)",
        "numero": "18"
      },
      {
        "nombre": "Carretera Centro Barrio Quilmes 3",
        "numero": "790"
      },
      {
        "nombre": "Hermanos Dominguez Santana - CC ALISIOS",
        "numero": "755"
      },
      {
        "nombre": "Hermanos Dominguez Santana (CC ALISIOS)",
        "numero": "727"
      },
      {
        "nombre": "C/ RAFAEL MESA Y LOPEZ (CEIP TIMPLISTA JOSE ANTONIO RAMOS)",
        "numero": "467"
      },
      {
        "nombre": "C/ RAFAEL MESA Y LOPEZ (EL AUDAZ)",
        "numero": "499"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSE SANCHEZ PENATE (CC LAS ARENAS)",
        "numero": "961"
      },
      {
        "nombre": "GALILEA 60",
        "numero": "730"
      },
      {
        "nombre": "C/ GAVILAN (RESIDENCIAL LOS GRANJEROS)",
        "numero": "713"
      },
      {
        "nombre": "C/ IGNACIO PEREZ GALDOS CON CALZADA LATERAL DEL NORTE",
        "numero": "507"
      },
      {
        "nombre": "C/ OBISPO MARQUINA (CEIP SANTIAGO RAMON Y CAJAL)",
        "numero": "453"
      },
      {
        "nombre": "AVDA. 8 DE MARZO DIA INTERNACIONAL DE LA MUJER",
        "numero": "729"
      },
      {
        "nombre": "AVDA. 8 DE MARZO DIA INTERNACIONAL DE LA MUJER",
        "numero": "732"
      },
      {
        "nombre": "REINA SOFIA",
        "numero": "628"
      },
      {
        "nombre": "AV. DE LAS PETROLIFERAS (REINA SOFIA)",
        "numero": "602"
      },
      {
        "nombre": "NELSON MANDELA (ACCESO)",
        "numero": "609"
      },
      {
        "nombre": "NELSON MANDELA (SALIDA)",
        "numero": "616"
      },
      {
        "nombre": "HERMANOS DOMINGUEZ SANTANA (DECATHLON)",
        "numero": "737"
      },
      {
        "nombre": "NELSON MANDELA (ARMAS)",
        "numero": "964"
      },
      {
        "nombre": "PROVISIONAL FRANCISCO GOURIE",
        "numero": "926"
      },
      {
        "nombre": "MESA Y LOPEZ (BASE NAVAL)",
        "numero": "798"
      },
      {
        "nombre": "PICO VIENTO",
        "numero": "794"
      },
      {
        "nombre": "Ciudad Deportiva Gran Canaria",
        "numero": "792"
      },
      {
        "nombre": "Hoya de la Plata",
        "numero": "796"
      },
      {
        "nombre": "CONCEPCIÓN ARENAL (PL.ESPAÑA)",
        "numero": "305"
      },
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
        "nombre": "AVDA. RAFAEL CABRERA (SAN TELMO)",
        "numero": "3"
      },
      {
        "nombre": "C/ TRIANA",
        "numero": "4"
      },
      {
        "nombre": "C/ VENEGAS (USOS MÚLTIPLES)",
        "numero": "5"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 13",
        "numero": "6"
      },
      {
        "nombre": "C/ VENEGAS (FUENTE LUMINOSA)",
        "numero": "7"
      },
      {
        "nombre": "C/ LEON Y CASTILLO (PLAZA DE LA FERIA)",
        "numero": "8"
      },
      {
        "nombre": "C/ LUIS DORESTE SILVA, 22",
        "numero": "9"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 145",
        "numero": "10"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "11"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 185",
        "numero": "12"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (C.N. METROPOLE)",
        "numero": "13"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 209",
        "numero": "14"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (OFICINAS MUNICIPALES)",
        "numero": "15"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (COLEGIO SALESIANO)",
        "numero": "16"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (TORRE LAS PALMAS)",
        "numero": "17"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "20"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (EDIFICIO JOSÉ ANTONIO)",
        "numero": "22"
      },
      {
        "nombre": "PL. SAN JUAN BAUTISTA (BASE NAVAL)",
        "numero": "23"
      },
      {
        "nombre": "C/ PRESIDENTE ALVEAR (IGLESIA DEL PINO)",
        "numero": "24"
      },
      {
        "nombre": "C/ EDUARDO BENOT, FRENTE 5",
        "numero": "25"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "26"
      },
      {
        "nombre": "C/ EDUARDO BENOT, FRENTE 23",
        "numero": "27"
      },
      {
        "nombre": "C/ ALBAREDA, 43",
        "numero": "28"
      },
      {
        "nombre": "C/ AGUSTÍN MILLARES SALL (EDIFICIO MAPFRE)",
        "numero": "29"
      },
      {
        "nombre": "C/ JUAN REJÓN,25",
        "numero": "30"
      },
      {
        "nombre": "C/ JUAN REJÓN (CASTILLO DE LA LUZ)",
        "numero": "31"
      },
      {
        "nombre": "C/ LA NAVAL",
        "numero": "33"
      },
      {
        "nombre": "C/ JUAN REJÓN, 67",
        "numero": "34"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (JUAN XXIII)",
        "numero": "35"
      },
      {
        "nombre": "AVDA. DE CANARIAS (SAN TELMO)",
        "numero": "36"
      },
      {
        "nombre": "C/ LUIS DORESTE SILVA, 50",
        "numero": "37"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CENTRO INSULAR DE DEPORTES)",
        "numero": "38"
      },
      {
        "nombre": "AVDA. JUAN XXIII (CLINICA DEL PINO)",
        "numero": "39"
      },
      {
        "nombre": "AVDA.  ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CARVAJAL)",
        "numero": "40"
      },
      {
        "nombre": "AVDA. JUAN XXIII (COLEGIO CANTERBURY)",
        "numero": "41"
      },
      {
        "nombre": "DR. WALKSMANN, 10 (PLAZA LA FERIA)",
        "numero": "42"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 80 (BARRANQUILLO DON ZOILO)",
        "numero": "43"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "44"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 154 (BARRANQUILLO DON ZOILO)",
        "numero": "45"
      },
      {
        "nombre": "C/ PÉREZ DEL TORO, 13",
        "numero": "46"
      },
      {
        "nombre": "C/ CARLOS M. BLANDY (PLAZA DE ARUCAS)",
        "numero": "47"
      },
      {
        "nombre": "C/ PÉREZ DEL TORO (PLAZA DR. JUAN BOSCH MILLARES)",
        "numero": "48"
      },
      {
        "nombre": "C/ ALMIRANTE BENÍTEZ INGLOTT, 12",
        "numero": "49"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 61 (BARRANQUILLO DON ZOILO)",
        "numero": "50"
      },
      {
        "nombre": "C/ ALMIRANTE BENÍTEZ INGLOTT (C.S. ESCALERITAS)",
        "numero": "51"
      },
      {
        "nombre": "C/ PARROCO MATIAS ARTILES",
        "numero": "52"
      },
      {
        "nombre": "C/ PINTOR JUAN ISMAEL (IGLESIA REDONDA)",
        "numero": "53"
      },
      {
        "nombre": "C/ ECHEGARAY, 137",
        "numero": "54"
      },
      {
        "nombre": "C/ TEOBALDO POWER, FRENTE 51",
        "numero": "55"
      },
      {
        "nombre": "C/ HENRY DUNANT, FRENTE 10",
        "numero": "56"
      },
      {
        "nombre": "AVDA. ESCALERITAS, FRENTE 111",
        "numero": "57"
      },
      {
        "nombre": "C/ PRESIDENTE ALVEAR, 17",
        "numero": "58"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN SANSOFÉ)",
        "numero": "59"
      },
      {
        "nombre": "C/ DEAN RODRÍGUEZ BOLAÑOS (PL. ALVARADO Y SAZ)",
        "numero": "60"
      },
      {
        "nombre": "AVDA. ESCALERITAS( FRENTE C.C. LA BALLENA)",
        "numero": "61"
      },
      {
        "nombre": "C/ TEOBALDO POWER (IGLESIA REDONDA)",
        "numero": "62"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 1",
        "numero": "63"
      },
      {
        "nombre": "C/ MARIUCHA, 139",
        "numero": "64"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 19",
        "numero": "65"
      },
      {
        "nombre": "C/ MARIUCHA, 171",
        "numero": "66"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 33",
        "numero": "67"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN SANSOFÉ)",
        "numero": "68"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO (PACUCO PENICHET)",
        "numero": "69"
      },
      {
        "nombre": "AVDA. ESCALERITAS (C.C. LA BALLENA)",
        "numero": "70"
      },
      {
        "nombre": "AVDA. ALCALDE DÍAZ SAAVEDRA NAVARRO (PL. SANTA ISABEL)",
        "numero": "71"
      },
      {
        "nombre": "AVDA. DE LA FERIA (INFECAR)",
        "numero": "72"
      },
      {
        "nombre": "C/ DR. HERNAN PEREZ DE GRADO, 6",
        "numero": "73"
      },
      {
        "nombre": "C/ DIEGO BETANCOR SUAREZ , 19",
        "numero": "74"
      },
      {
        "nombre": "C/ DR. HERNÁN PEREZ DE GRADO (LA PORTADILLA)",
        "numero": "75"
      },
      {
        "nombre": "C/ DIEGO BETANCOR SUAREZ, 39",
        "numero": "76"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (CARREFOUR)",
        "numero": "77"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (JUZGADOS)",
        "numero": "78"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        "numero": "79"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO, FRENTE 32",
        "numero": "80"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 170",
        "numero": "81"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        "numero": "82"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 214",
        "numero": "83"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 154",
        "numero": "84"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 264",
        "numero": "85"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 208",
        "numero": "86"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 290",
        "numero": "87"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 266",
        "numero": "88"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (IGLESIA SANTA CLARA)",
        "numero": "89"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 298",
        "numero": "90"
      },
      {
        "nombre": "C/ MARIANAO, 12",
        "numero": "91"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, FRENTE 306",
        "numero": "92"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (PARKING HOSPITAL MATERNO INSULAR)",
        "numero": "93"
      },
      {
        "nombre": "Primero de Mayo ,6",
        "numero": "21"
      },
      {
        "nombre": "Primero de Mayo (ONCE)",
        "numero": "19"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (IGLESIA SANTA CLARA)",
        "numero": "94"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (MARTÍN FREIRE)",
        "numero": "95"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (PARKING HOSPITAL MATERNO INSULAR)",
        "numero": "96"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, 14",
        "numero": "97"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (MARTÍN FREIRE)",
        "numero": "98"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 8",
        "numero": "99"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, FRENTE 16",
        "numero": "100"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 30",
        "numero": "101"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (CARREFOUR)",
        "numero": "102"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 46",
        "numero": "103"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, FRENTE 8",
        "numero": "104"
      },
      {
        "nombre": "C/ MIGUEL MARTÍN FERNÁNDEZ DE LA TORRE , 7",
        "numero": "105"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 15",
        "numero": "106"
      },
      {
        "nombre": "C/ CÓRDOBA, 40",
        "numero": "107"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 41",
        "numero": "108"
      },
      {
        "nombre": "C/ CÓRDOBA, FRENTE 31",
        "numero": "109"
      },
      {
        "nombre": "C/ CÓRDOBA (BOMBEROS VEGUETA)",
        "numero": "110"
      },
      {
        "nombre": "C/ AYAGAURES (TANATORIO SAN MIGUEL)",
        "numero": "111"
      },
      {
        "nombre": "C/ CÓRDOBA, FRENTE 49",
        "numero": "113"
      },
      {
        "nombre": "C/ CÓRDOBA, 19",
        "numero": "114"
      },
      {
        "nombre": "C/ CÓRDOBA, 54",
        "numero": "115"
      },
      {
        "nombre": "C/ CÓRDOBA, 29",
        "numero": "116"
      },
      {
        "nombre": "C/ ALICANTE (COLEGIO ISLAS CANARIAS)",
        "numero": "117"
      },
      {
        "nombre": "C/ CÓRDOBA, 49",
        "numero": "118"
      },
      {
        "nombre": "AVDA. DE AMURGA (C.S. CONO SUR)",
        "numero": "119"
      },
      {
        "nombre": "C/ CÓRDOBA, 71",
        "numero": "120"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 10",
        "numero": "121"
      },
      {
        "nombre": "C/ ALICANTE (COLEGIO ISLAS CANARIAS)",
        "numero": "122"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 20",
        "numero": "123"
      },
      {
        "nombre": "C/ SARGENTO SALOM, 34",
        "numero": "124"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS, FRENTE 16",
        "numero": "125"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 35",
        "numero": "126"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS, FRENTE 2",
        "numero": "127"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 53",
        "numero": "128"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES,  6",
        "numero": "129"
      },
      {
        "nombre": "C/ DEBUSSY, 3",
        "numero": "130"
      },
      {
        "nombre": "C/ JUAN SÁNCHEZ DE LA COBA, 2",
        "numero": "131"
      },
      {
        "nombre": "C/ DEBUSSY, 9",
        "numero": "132"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 6",
        "numero": "133"
      },
      {
        "nombre": "C/ DEBUSSY, FRENTE  6",
        "numero": "134"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 33)",
        "numero": "135"
      },
      {
        "nombre": "C/ ANTON DVORAK, 5",
        "numero": "136"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 1)",
        "numero": "137"
      },
      {
        "nombre": "C/ JUAN SEBASTIAN BACH, FRENTE 4",
        "numero": "138"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 5)",
        "numero": "139"
      },
      {
        "nombre": "C/ BERLIOZ, 5",
        "numero": "140"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 17)",
        "numero": "141"
      },
      {
        "nombre": "C/ SCHUBERT, FRENTE 6",
        "numero": "142"
      },
      {
        "nombre": "C/ SARGENTO SALOM, 44",
        "numero": "143"
      },
      {
        "nombre": "C/ SCHUBERT, 5",
        "numero": "144"
      },
      {
        "nombre": "C/PEDRO HIDALGO (POLIDEPORTIVO)",
        "numero": "145"
      },
      {
        "nombre": "C/ SCHUBERT, 17",
        "numero": "146"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, FRENTE 91",
        "numero": "147"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, 5",
        "numero": "148"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, FRENTE 51",
        "numero": "149"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES, 19",
        "numero": "150"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 96",
        "numero": "151"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES, 33",
        "numero": "152"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA,  FRENTE 133",
        "numero": "153"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 19",
        "numero": "154"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 168",
        "numero": "155"
      },
      {
        "nombre": "AVDA. DE AMURGA (C.S. CONO SUR)",
        "numero": "156"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "157"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TEERRERAS EL LASSO, 33)",
        "numero": "158"
      },
      {
        "nombre": "C/ CANDELARIA DE LÉON, 6",
        "numero": "159"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 1)",
        "numero": "160"
      },
      {
        "nombre": "C/ FARMACEÚTICO ARENCIBIA CABRERA (COFARCA)",
        "numero": "161"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 4)",
        "numero": "162"
      },
      {
        "nombre": "C/ CONCEJAL ANDRÉS ALVARADO JANINA (LOCAL SOCIAL HOYA DE LA PLATA)",
        "numero": "163"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 17)",
        "numero": "164"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (HOSPITAL MATERNO INSULAR)",
        "numero": "165"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 97",
        "numero": "166"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (ESCUELA DE ARTE)",
        "numero": "167"
      },
      {
        "nombre": "C/ SALAMANCA, 63",
        "numero": "168"
      },
      {
        "nombre": "C/ ARGUINEGUÍN",
        "numero": "169"
      },
      {
        "nombre": "C/ SALAMANCA, 99",
        "numero": "170"
      },
      {
        "nombre": "C/ REYES CATÓLICOS, 9",
        "numero": "171"
      },
      {
        "nombre": "C/ SALAMANCA, 135",
        "numero": "172"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 2",
        "numero": "173"
      },
      {
        "nombre": "AVDA.  JUAN CARLOS I, 9",
        "numero": "174"
      },
      {
        "nombre": "C/ NUEVA, FRENTE  67",
        "numero": "175"
      },
      {
        "nombre": "AVDA JUAN CARLOS I, 23",
        "numero": "176"
      },
      {
        "nombre": "C/ ANDENES, FRENTE 15",
        "numero": "177"
      },
      {
        "nombre": "C/ CANDELARIA DE LEÓN, 7",
        "numero": "178"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN, 10",
        "numero": "179"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 128",
        "numero": "180"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN, 42",
        "numero": "181"
      },
      {
        "nombre": "C/ CONCEJAL ANDRES ALVARADO JANINA (LOCAL SOCIAL HOYA DE LA PLATA)",
        "numero": "182"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN (PLAZA DEL SOL NACIENTE)",
        "numero": "183"
      },
      {
        "nombre": "RESIDENCIAL FLOR SIRERA",
        "numero": "184"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN, 16",
        "numero": "185"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 1",
        "numero": "186"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN, 48",
        "numero": "187"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (TRÓPICO)",
        "numero": "188"
      },
      {
        "nombre": "C/ REAL DE SAN ROQUE, FRENTE 11",
        "numero": "189"
      },
      {
        "nombre": "C/ ANDENES, 9",
        "numero": "190"
      },
      {
        "nombre": "C/ FARNESIO, FRENTE 15",
        "numero": "191"
      },
      {
        "nombre": "C/ NÉSTOR ÁLAMO (CAMPO DE LUCHA)",
        "numero": "192"
      },
      {
        "nombre": "C/ FARNESIO, FRENTE 59",
        "numero": "193"
      },
      {
        "nombre": "CARRETERA EL CARDON (ROTONDA)",
        "numero": "194"
      },
      {
        "nombre": "C/ FAMA, FRENTE 85",
        "numero": "195"
      },
      {
        "nombre": "AVDA. JUAN XXIII (CLINICA DEL PINO)",
        "numero": "196"
      },
      {
        "nombre": "C/ ANDENES, FRENTE 39",
        "numero": "197"
      },
      {
        "nombre": "ACCESO ANTIGUA CARCEL",
        "numero": "198"
      },
      {
        "nombre": "C/ NUEVA, FRENTE 25",
        "numero": "199"
      },
      {
        "nombre": "C/ LOS MANZANO",
        "numero": "200"
      },
      {
        "nombre": "C/ BARAHONA, 77",
        "numero": "201"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN",
        "numero": "202"
      },
      {
        "nombre": "C/ BARAHONA, FRENTE 19",
        "numero": "203"
      },
      {
        "nombre": "C/ JUAN DE QUESADA (RECTORADO ULPGC)",
        "numero": "204"
      },
      {
        "nombre": "LA MATULA, FRENTE 25",
        "numero": "205"
      },
      {
        "nombre": "C/ REAL DE SAN ROQUE, 13",
        "numero": "206"
      },
      {
        "nombre": "LA MATULA, FRENTE 61",
        "numero": "207"
      },
      {
        "nombre": "C/ FARNESIO, 13",
        "numero": "208"
      },
      {
        "nombre": "LA MATULA, FRENTE  95",
        "numero": "209"
      },
      {
        "nombre": "C/ FARNESIO, 53",
        "numero": "210"
      },
      {
        "nombre": "PUENTE LA MATULA",
        "numero": "211"
      },
      {
        "nombre": "C/ FAMA, 71",
        "numero": "212"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (HNOS. TOLEDO SUAREZ)",
        "numero": "213"
      },
      {
        "nombre": "C/ ANDENES, 19",
        "numero": "214"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (LOMO VERDEJO)",
        "numero": "215"
      },
      {
        "nombre": "C/ NUEVA, 35",
        "numero": "216"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (FELIPE MARTELL)",
        "numero": "217"
      },
      {
        "nombre": "C/ NUEVA, 77",
        "numero": "218"
      },
      {
        "nombre": "C/ SAN JOSÉ ARTESANO, 24",
        "numero": "219"
      },
      {
        "nombre": "C/ BARAHONA, 19",
        "numero": "220"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 62",
        "numero": "221"
      },
      {
        "nombre": "C/ LA MATULA, 25",
        "numero": "222"
      },
      {
        "nombre": "C/ SEVERO OCHOA",
        "numero": "223"
      },
      {
        "nombre": "C/ LA MATULA, 65",
        "numero": "224"
      },
      {
        "nombre": "C/ SEVERO OCHOA,  12",
        "numero": "225"
      },
      {
        "nombre": "C/ LA MATULA, 97",
        "numero": "226"
      },
      {
        "nombre": "C/ SEVERO OCHOA (GEORGE PIRE)",
        "numero": "227"
      },
      {
        "nombre": "C/ AYAGAURES (TANATORIO SAN MIGUEL)",
        "numero": "228"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS, 5",
        "numero": "229"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (PUENTE LA MATULA)",
        "numero": "230"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS (IGLESIA EL BATÁN)",
        "numero": "231"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (HNOS. TOLEDO SUÁREZ)",
        "numero": "232"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 116",
        "numero": "233"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (EL HORNILLO)",
        "numero": "234"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, FRENTE 121",
        "numero": "235"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (FELIPE MARTEL)",
        "numero": "236"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 166",
        "numero": "237"
      },
      {
        "nombre": "C/ ARGUINEGUÍN, 8",
        "numero": "238"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 220",
        "numero": "239"
      },
      {
        "nombre": "AUTOVIA DE GUINIGUADA (SAN JUAN BOSCO)",
        "numero": "240"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 276",
        "numero": "241"
      },
      {
        "nombre": "C/ SEVERO OCHOA, FRENTE 10",
        "numero": "242"
      },
      {
        "nombre": "AVDA. PRIMERO DE MAYO (CORREOS)",
        "numero": "243"
      },
      {
        "nombre": "C/ SEVERO OCHOA (ALBERT SCHWITZER)",
        "numero": "244"
      },
      {
        "nombre": "C/ INGENIERO JOSÉ BOSCH Y SINTÉS, 1",
        "numero": "245"
      },
      {
        "nombre": "C/ SEVERO OCHOA (GEORGE BERNARD SHAW)",
        "numero": "246"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "247"
      },
      {
        "nombre": "C/ MIGUEL ANGEL ASTURIAS, FRENTE 5",
        "numero": "248"
      },
      {
        "nombre": "PASEO TOMÁS MORALES, FRENTE 69",
        "numero": "249"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS (IGLESIA EL BATAN)",
        "numero": "250"
      },
      {
        "nombre": "PASEO TOMÁS MORALES, 120",
        "numero": "251"
      },
      {
        "nombre": "ROTONDA DE LOMO BLANCO",
        "numero": "252"
      },
      {
        "nombre": "C/ EMILIO LEY (PISCINAS JULIO NAVARRO)",
        "numero": "253"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY, 9",
        "numero": "254"
      },
      {
        "nombre": "C/ PÍO XII (COLEGIO TERESIANO)",
        "numero": "255"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY, FRENTE 132",
        "numero": "256"
      },
      {
        "nombre": "C/ PÍO XII (ESTADIO INSULAR)",
        "numero": "257"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY (COLEGIO EL BATÁN)",
        "numero": "258"
      },
      {
        "nombre": "C/ GALICIA (MERCADO CENTRAL)",
        "numero": "259"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA (COFARCA)",
        "numero": "260"
      },
      {
        "nombre": "C/ GALICIA, 32",
        "numero": "261"
      },
      {
        "nombre": "AVDA. PRIMERO DE MAYO, 35",
        "numero": "262"
      },
      {
        "nombre": "C/ TOMÁS MILLER, FRENTE 31",
        "numero": "263"
      },
      {
        "nombre": "C/ PASEO TOMÁS MORALES, 5",
        "numero": "264"
      },
      {
        "nombre": "C/ LUJÁN PÉREZ, 20",
        "numero": "265"
      },
      {
        "nombre": "C/ EMILIO LEY (PARQUE DORAMAS)",
        "numero": "266"
      },
      {
        "nombre": "C/ LUJÁN PÉREZ, 66",
        "numero": "267"
      },
      {
        "nombre": "AVDA PRIMERO DE MAYO, 1",
        "numero": "268"
      },
      {
        "nombre": "C/ TINGUARÓ, 18",
        "numero": "269"
      },
      {
        "nombre": "C/ PÍO XII , 27 (COLEGIO TERESIANO)",
        "numero": "270"
      },
      {
        "nombre": "C/ GUMIDAFE, 30",
        "numero": "271"
      },
      {
        "nombre": "C/ PÍO XII (ESTADIO INSULAR)",
        "numero": "272"
      },
      {
        "nombre": "C / OSORIO, 28",
        "numero": "273"
      },
      {
        "nombre": "C/ PÍO XII, 75",
        "numero": "274"
      },
      {
        "nombre": "C/ OSORIO, 58",
        "numero": "275"
      },
      {
        "nombre": "C/ GALICIA, 15 (MERCADO CENTRAL)",
        "numero": "276"
      },
      {
        "nombre": "C/ FELIPE MARTELL (LINDERO)",
        "numero": "277"
      },
      {
        "nombre": "C/ BANDAMA, 25",
        "numero": "278"
      },
      {
        "nombre": "C/ PRIMERO DE MAYO, 56",
        "numero": "279"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 38",
        "numero": "280"
      },
      {
        "nombre": "CARRETERA DE MATA (PL. DEL PINO)",
        "numero": "281"
      },
      {
        "nombre": "C/ ALBAREDA (MERCADO DEL PUERTO)",
        "numero": "282"
      },
      {
        "nombre": "CARRETERA DE MATA, 10-12  (SAN ANTONIO)",
        "numero": "283"
      },
      {
        "nombre": "C/ FARO, 11",
        "numero": "284"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, FRENTE AL Nº83",
        "numero": "285"
      },
      {
        "nombre": "C/ FARO, 43",
        "numero": "286"
      },
      {
        "nombre": "PASEO DE SAN ANTONIO, 56",
        "numero": "287"
      },
      {
        "nombre": "C/ FARO, 99",
        "numero": "288"
      },
      {
        "nombre": "C/ MARIUCHA (PLAZA DON BENITO)",
        "numero": "289"
      },
      {
        "nombre": "C/ CORONEL ROCHA (NUEVA ISLETA)",
        "numero": "290"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 24",
        "numero": "291"
      },
      {
        "nombre": "C/ EDUARDO PEÑATE SANTANA, LOCAL 4",
        "numero": "292"
      },
      {
        "nombre": "C/ ZARAGOZA, 26",
        "numero": "293"
      },
      {
        "nombre": "C/ PALMAR, FRENTE 82",
        "numero": "294"
      },
      {
        "nombre": "C/ OBISPO ROMO, FRENTE 27",
        "numero": "295"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 172",
        "numero": "296"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 51",
        "numero": "297"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 186",
        "numero": "298"
      },
      {
        "nombre": "AVDA. ESCALERITAS (CÁRITAS)",
        "numero": "299"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO (IGLESIA DE LOS DOLORES)",
        "numero": "300"
      },
      {
        "nombre": "AVDA. ESCALERITAS (CLUB LA CORNISA)",
        "numero": "301"
      },
      {
        "nombre": "C/ ALCESTE, 27",
        "numero": "302"
      },
      {
        "nombre": "PASEO DE CHIL (ESTADIO INSULAR)",
        "numero": "303"
      },
      {
        "nombre": "C/ ZARAGOZA, 27",
        "numero": "304"
      },
      {
        "nombre": "C/ OBISPO ROMO (MERCADO DE ALTAVISTA)",
        "numero": "306"
      },
      {
        "nombre": "C/ PÁRROCO VILLAR REINA, F/ Nª8",
        "numero": "307"
      },
      {
        "nombre": "C/ OBISPO ROMO (PARQUE HERMANOS MILLARES)",
        "numero": "308"
      },
      {
        "nombre": "PASEO DE CHIL (JARDINES RUBIÓ)",
        "numero": "309"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 48",
        "numero": "310"
      },
      {
        "nombre": "C/ TOMÁS MILLER (PLAYA DE LAS CANTERAS)",
        "numero": "311"
      },
      {
        "nombre": "PASEO DE CHIL (ESTADIO INSULAR)",
        "numero": "312"
      },
      {
        "nombre": "C/ ALFREDO L. JONES, 1",
        "numero": "313"
      },
      {
        "nombre": "C/ OLOF PALME, 40",
        "numero": "314"
      },
      {
        "nombre": "C/ FARMACÉUTICO PEDRO RIVERO (POLÍGONO CRUZ DE PIEDRA)",
        "numero": "315"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 40",
        "numero": "316"
      },
      {
        "nombre": "CARRETERA DE MATA, 42",
        "numero": "317"
      },
      {
        "nombre": "CARRETERA DE MATA (PARQUE DE LAS REHOYAS)",
        "numero": "319"
      },
      {
        "nombre": "CALZADA LATERAL DEL NORTE (DIVINA PASTORA)",
        "numero": "320"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 14",
        "numero": "321"
      },
      {
        "nombre": "CALZADA LATERAL DEL NORTE (C.S. MILLER BAJO)",
        "numero": "322"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 30",
        "numero": "323"
      },
      {
        "nombre": "C/ VIRGEN DE LA PALOMA, FRENTE 19",
        "numero": "324"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC, 43",
        "numero": "325"
      },
      {
        "nombre": "C/ VIRGEN DE LA PALOMA (IGLESIA DE LA PAZ)",
        "numero": "326"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC (PLAZA MARTÍN COBOS)",
        "numero": "327"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO,54",
        "numero": "328"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC (BINGO CINEMA)",
        "numero": "329"
      },
      {
        "nombre": "C/ JUAN SARAZÁ ORTÍZ, FRENTE 7",
        "numero": "330"
      },
      {
        "nombre": "C/ JUAN SARAZÁ ORTÍZ, 14",
        "numero": "331"
      },
      {
        "nombre": "C/ CRUZ DE PIEDRA, 9",
        "numero": "332"
      },
      {
        "nombre": "C/ CRUZ DE PIEDRA, FRENTE  7",
        "numero": "333"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 1",
        "numero": "334"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE  1",
        "numero": "335"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 33",
        "numero": "336"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE 35",
        "numero": "337"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 71",
        "numero": "338"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE 73",
        "numero": "339"
      },
      {
        "nombre": "C/ PINO APOLINARIO, 9",
        "numero": "340"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, FRENTE 92",
        "numero": "341"
      },
      {
        "nombre": "C/ PINO APOLINARIO,  53",
        "numero": "342"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, FRENTE  42",
        "numero": "343"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, FRENTE 238",
        "numero": "344"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, 7",
        "numero": "345"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO (BARRANCO)",
        "numero": "346"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (BAMBÚ)",
        "numero": "347"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO",
        "numero": "348"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 32",
        "numero": "349"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO, 117",
        "numero": "350"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA (REAL DEL CASTILLO)",
        "numero": "351"
      },
      {
        "nombre": "C/ FARMACÉUTICO PEDRO RIVERO, 1",
        "numero": "352"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA, 50",
        "numero": "353"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA, 24",
        "numero": "355"
      },
      {
        "nombre": "C/ FARMACEÚTICO PEDRO RIVERO (JOAQUIN BELÓN)",
        "numero": "356"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (HOSPITAL DR. NEGRÍN)",
        "numero": "357"
      },
      {
        "nombre": "C/ FARMACEÚTICO PEDRO RIVERO, 20",
        "numero": "359"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN, 67",
        "numero": "360"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN, 145",
        "numero": "362"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 120",
        "numero": "363"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN (IGLESIA SAN MARCOS)",
        "numero": "364"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 152",
        "numero": "365"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 114",
        "numero": "366"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 194",
        "numero": "367"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 104",
        "numero": "368"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 204",
        "numero": "369"
      },
      {
        "nombre": "AVDA, ESCALERITAS, 84",
        "numero": "370"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 109",
        "numero": "371"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 70",
        "numero": "372"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 95",
        "numero": "373"
      },
      {
        "nombre": "CARRETERA DEL NORTE (IES CRUZ DE PIEDRA)",
        "numero": "374"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 79",
        "numero": "375"
      },
      {
        "nombre": "CARRETERA DEL NORTE (FRENTE CC LA BALLENA)",
        "numero": "376"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 57",
        "numero": "377"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (SALIDA DE LA PATERNA)",
        "numero": "378"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 40",
        "numero": "379"
      },
      {
        "nombre": "CARRETERA DEL NORTE (CC LA BALLENA)",
        "numero": "380"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 68",
        "numero": "381"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, 383",
        "numero": "382"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (PUENTE AÉREO)",
        "numero": "383"
      },
      {
        "nombre": "C/ HENRY DUNANT, FRENTE 42",
        "numero": "384"
      },
      {
        "nombre": "CARRETERA DEL NORTE (LOS TARAHALES)",
        "numero": "385"
      },
      {
        "nombre": "C/ CRONISTA MARTÍN MORENO,8",
        "numero": "386"
      },
      {
        "nombre": "ACCESO MANUEL DE FALLA",
        "numero": "387"
      },
      {
        "nombre": "C/ PEPE DAMASO, 43",
        "numero": "388"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 118",
        "numero": "389"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 234",
        "numero": "390"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE  11",
        "numero": "391"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 169",
        "numero": "392"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 84",
        "numero": "393"
      },
      {
        "nombre": "CARRETERA DE CHILE, 75",
        "numero": "489"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN PARQUE CENTRAL)",
        "numero": "394"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 72",
        "numero": "395"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 7",
        "numero": "396"
      },
      {
        "nombre": "C/ EMILIO ARRIETA, FRENTE  7",
        "numero": "397"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (C.S. ALCARAVANERAS)",
        "numero": "398"
      },
      {
        "nombre": "CARRETERA DEL NORTE (LOS TARAHALES)",
        "numero": "399"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (MADERA Y CORCHO)",
        "numero": "400"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 178",
        "numero": "401"
      },
      {
        "nombre": "C/ COSTA RICA, FRENTE 33",
        "numero": "402"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 50",
        "numero": "403"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (C.C. LAS RAMBLAS)",
        "numero": "404"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 225",
        "numero": "405"
      },
      {
        "nombre": "C/ CASTILLEJOS, 23",
        "numero": "406"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSÉ SÁNCHEZ PEÑATE (CC LAS ARENAS),NORTE",
        "numero": "407"
      },
      {
        "nombre": "C/ CASTILLEJOS, 71",
        "numero": "408"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (C.S. ALCARAVANERAS)",
        "numero": "409"
      },
      {
        "nombre": "C/ NUMANCIA, 68",
        "numero": "410"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (MADERA Y CORCHO)",
        "numero": "411"
      },
      {
        "nombre": "PLAZA DE SAN LORENZO",
        "numero": "412"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 118",
        "numero": "413"
      },
      {
        "nombre": "C/ MARIA DOLOROSA, 1",
        "numero": "414"
      },
      {
        "nombre": "C/ SIMANCAS, 70",
        "numero": "415"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 282",
        "numero": "416"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 34",
        "numero": "417"
      },
      {
        "nombre": "C/ LORENZO SUÁREZ RIVERO, 9",
        "numero": "418"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 78",
        "numero": "419"
      },
      {
        "nombre": "C/ VEGA DE RÍO PALMA, 48",
        "numero": "420"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 100",
        "numero": "421"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 52",
        "numero": "422"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "423"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 28",
        "numero": "424"
      },
      {
        "nombre": "AVDA. SEMANA DE LA PASION, 29",
        "numero": "425"
      },
      {
        "nombre": "C/ SAN FERMÍN, 20",
        "numero": "426"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "427"
      },
      {
        "nombre": "C/ GALILEA, 34",
        "numero": "428"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "429"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 30",
        "numero": "430"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 2",
        "numero": "431"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 20",
        "numero": "432"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 14",
        "numero": "433"
      },
      {
        "nombre": "C/ JUAN SÁNCHEZ DE LA COBA, 16",
        "numero": "434"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN F/89",
        "numero": "435"
      },
      {
        "nombre": "AUTOVÍA DE GUINIGUADA",
        "numero": "436"
      },
      {
        "nombre": "AVDA. MESA Y LOPEZ, 86",
        "numero": "437"
      },
      {
        "nombre": "C/ SEVERO OCHOA (C.S. EL BATÁN)",
        "numero": "438"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSÉ SÁNCHEZ PEÑATE (CC LAS ARENAS),SUR",
        "numero": "439"
      },
      {
        "nombre": "C/ JOSE LUIS GUERRA DE ARMAS (CRUCE LAS COLORADAS)",
        "numero": "440"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (CLUB NÁUTICO)",
        "numero": "441"
      },
      {
        "nombre": "C/ CRUZ DEL OVEJERO, 28",
        "numero": "442"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "443"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 172",
        "numero": "444"
      },
      {
        "nombre": "AVDA. DE AMURGA (PASEO BLAS CABRERA FELIPE)",
        "numero": "445"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 140",
        "numero": "446"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASABLANCA)",
        "numero": "447"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 68",
        "numero": "448"
      },
      {
        "nombre": "SABINO BERTHELOT (ENLACE LINEAS 9- 12-13)",
        "numero": "449"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE F/Nº 35  (ROTONDA LOMO LOS FRAILES)",
        "numero": "450"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS (ENLACE LINEAS 12-13)",
        "numero": "451"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (URBANIZACIÓN LA GUILLENA)",
        "numero": "452"
      },
      {
        "nombre": "C/ MIMOSA (NARDO)",
        "numero": "454"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 196",
        "numero": "455"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE FRENTE 71",
        "numero": "456"
      },
      {
        "nombre": "C/ JOSE LUIS GUERRA DE ARMAS (ALONSO QUIJANO)",
        "numero": "457"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (LAS PERRERAS)",
        "numero": "458"
      },
      {
        "nombre": "C/ CRUZ DEL OVEJERO, 25",
        "numero": "459"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE, FRENTE 21",
        "numero": "460"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 171",
        "numero": "461"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (URB. IND. LOMO BLANCO)",
        "numero": "462"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 143",
        "numero": "463"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (CRUCE LAS TORRES)",
        "numero": "464"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (URBANIZACIÓN DÍAZ CASANOVAS)",
        "numero": "466"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN, FRENTE 49",
        "numero": "468"
      },
      {
        "nombre": "CARRETERA GENERAL DEL NORTE",
        "numero": "469"
      },
      {
        "nombre": "CARRETERA DE CHILE, FRENTE 91",
        "numero": "470"
      },
      {
        "nombre": "CARRETERA GENERAL DEL NORTE (LA GUILLENA)",
        "numero": "471"
      },
      {
        "nombre": "CARRETERA DE CHILE, 68",
        "numero": "472"
      },
      {
        "nombre": "CARRETERA TAMARACEITE (LAS PERRERAS)",
        "numero": "473"
      },
      {
        "nombre": "CARRETERA DE CHILE (CAMPO DE GOLF)",
        "numero": "474"
      },
      {
        "nombre": "CARRETERA TAMARACEITE, FRENTE 62",
        "numero": "475"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 150",
        "numero": "476"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE  (LAS MAJADILLAS)",
        "numero": "477"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 138",
        "numero": "478"
      },
      {
        "nombre": "CARRETERA TAMARACEITE (DANONE)",
        "numero": "479"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO (TISCAMANITA)",
        "numero": "480"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (CRUCE LAS TORRES)",
        "numero": "481"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 62",
        "numero": "482"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (URBANIZACIÓN DÍAZ CASANOVAS)",
        "numero": "483"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 30",
        "numero": "484"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN, 41",
        "numero": "485"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME (PLAZOLETA FARRAY)",
        "numero": "486"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, 1",
        "numero": "487"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME (FRAY JUNIPERO)",
        "numero": "488"
      },
      {
        "nombre": "C/ LOS MANZANO",
        "numero": "200"
      },
      {
        "nombre": "C/ JUNCO (AMAPOLA)",
        "numero": "490"
      },
      {
        "nombre": "CARRETERA DE CHILE, 45",
        "numero": "491"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 138",
        "numero": "492"
      },
      {
        "nombre": "CARRETERA DE CHILE (CAMPO DE GOLF)",
        "numero": "493"
      },
      {
        "nombre": "C/ MUNGUÍA, 8",
        "numero": "494"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 185",
        "numero": "495"
      },
      {
        "nombre": "AVDA. RAFAEL CABRERA (SAN TELMO)",
        "numero": "496"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 85",
        "numero": "497"
      },
      {
        "nombre": "C/ JUNCO (HIPERDINO)",
        "numero": "498"
      },
      {
        "nombre": "C/ AREQUIPA (GUAGUAS MUNICIPALES)",
        "numero": "500"
      },
      {
        "nombre": "C/ MADRESELVA, FRENTE 69",
        "numero": "501"
      },
      {
        "nombre": "CARRETERA A LAS TORRES, 21 ESQUINA MADRESELVA",
        "numero": "502"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 94",
        "numero": "504"
      },
      {
        "nombre": "C/ NARDO, 31",
        "numero": "506"
      },
      {
        "nombre": "C/ MADRESELVA F/Nº 82",
        "numero": "508"
      },
      {
        "nombre": "C/ ACONCAGUA, 1",
        "numero": "510"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 42",
        "numero": "511"
      },
      {
        "nombre": "C/ ACONCAGUA (COLEGIO CASABLANCA III)",
        "numero": "512"
      },
      {
        "nombre": "C/ LENTINI (MONOPOL)",
        "numero": "513"
      },
      {
        "nombre": "C/ ACONCAGUA, FRENTE 3",
        "numero": "515"
      },
      {
        "nombre": "C/ ACONCAGUA  (COLEGIO CASABLANCA III)",
        "numero": "517"
      },
      {
        "nombre": "C/ARCHIVERO JOAQUIN BLANCO MONTESDEOCA (PEDRO BARBER)",
        "numero": "518"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO (MIMOSA)",
        "numero": "519"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA , 21",
        "numero": "520"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, 4",
        "numero": "521"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, 27",
        "numero": "522"
      },
      {
        "nombre": "AVDA. RAFAEL CABRERA (TEATRO)",
        "numero": "523"
      },
      {
        "nombre": "C/ PASEO DE SAN ANTONIO, 85",
        "numero": "524"
      },
      {
        "nombre": "C/ ARMINDA, FRENTE 1",
        "numero": "525"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA 28",
        "numero": "527"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUÍN BLANCO MONTESDEOCA (RTDA. NICOLÁS DÍAZ CHICO)",
        "numero": "529"
      },
      {
        "nombre": "C/ ALCALDE DÍAZ SAAVEDRA NAVARRO (PRUDENCIO GUZMÁN)",
        "numero": "530"
      },
      {
        "nombre": "C/ VERACRUZ, 16",
        "numero": "531"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA, FRENTE 18",
        "numero": "532"
      },
      {
        "nombre": "C/ MARIANAO, 60",
        "numero": "533"
      },
      {
        "nombre": "C/ PINO APOLINARIO (IGLESIA LOMO APOLINARIO)",
        "numero": "534"
      },
      {
        "nombre": "C/ MONTERREY, 1",
        "numero": "535"
      },
      {
        "nombre": "C/ BUENOS AIRES, 43",
        "numero": "536"
      },
      {
        "nombre": "C/ ARMINDA (LA FAVORITA)",
        "numero": "540"
      },
      {
        "nombre": "AVDA. DE AMURGA (IGLESIA)",
        "numero": "541"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (CANARIAS 7)",
        "numero": "543"
      },
      {
        "nombre": "C/ MARIANAO, 5",
        "numero": "544"
      },
      {
        "nombre": "PLAZA BARRANCO LA BALLENA",
        "numero": "545"
      },
      {
        "nombre": "C/ MARIANAO, 53",
        "numero": "546"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR, 28",
        "numero": "547"
      },
      {
        "nombre": "C/ MARIANAO, 103",
        "numero": "548"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, FRENTE 74",
        "numero": "549"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, 55",
        "numero": "551"
      },
      {
        "nombre": "C/ PROFESOR LOZANO, 10",
        "numero": "552"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 25",
        "numero": "554"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 2",
        "numero": "555"
      },
      {
        "nombre": "AVDA AMURGA (IGLESIA)",
        "numero": "556"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 18",
        "numero": "557"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR (PLAZA BARRANCO DE LA BALLENA)",
        "numero": "558"
      },
      {
        "nombre": "C/ PINO APOLINARIO, 86",
        "numero": "559"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR, FRENTE 26",
        "numero": "560"
      },
      {
        "nombre": "CARRETERA EL CARDÓN, FRENTE 118",
        "numero": "561"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (NUEVA PATERNA)",
        "numero": "562"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (IES FELO MONZON)",
        "numero": "563"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 52",
        "numero": "564"
      },
      {
        "nombre": "CTRA. LOMO BLANCO, 94",
        "numero": "565"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (COLEGIO LA PATERNA)",
        "numero": "566"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (URBANIZACIÓN EL ZURBARÁN)",
        "numero": "567"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 49",
        "numero": "568"
      },
      {
        "nombre": "C/ VERACRUZ, 36",
        "numero": "569"
      },
      {
        "nombre": "C/ ZARAGOZA ( DON PEDRO INFINITO)",
        "numero": "570"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 20",
        "numero": "572"
      },
      {
        "nombre": "AUTOVÍA GUINIGUADA (TEATRO GUINIGUADA)",
        "numero": "574"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 17",
        "numero": "576"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (URBANIZACIÓN EL ZURBARÁN)",
        "numero": "578"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "579"
      },
      {
        "nombre": "CTRA. LOMO BLANCO, 81",
        "numero": "580"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 12",
        "numero": "581"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, FRENTE 51",
        "numero": "582"
      },
      {
        "nombre": "C/ BETANIA, 69",
        "numero": "583"
      },
      {
        "nombre": "C/ BETANIA, 41",
        "numero": "585"
      },
      {
        "nombre": "C/ BETANIA, 7",
        "numero": "587"
      },
      {
        "nombre": "C/ SAN BORONDÓN, 10",
        "numero": "589"
      },
      {
        "nombre": "AVDA. DE LA FERIA (URBANIZACIÓN LOS GERANIOS)",
        "numero": "595"
      },
      {
        "nombre": "C/ HEBRÓN, 2",
        "numero": "596"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA, FRENTE 3",
        "numero": "597"
      },
      {
        "nombre": "C/ HEBRÓN, 24",
        "numero": "598"
      },
      {
        "nombre": "C/ GALILEA, FRENTE 6",
        "numero": "599"
      },
      {
        "nombre": "C/ VENTURA DORESTE,  7",
        "numero": "600"
      },
      {
        "nombre": "C/ SAN ANDRÉS, FRENTE 6",
        "numero": "601"
      },
      {
        "nombre": "CARRETERA DE TEROR",
        "numero": "603"
      },
      {
        "nombre": "C/ LAS BORRERAS, 1",
        "numero": "604"
      },
      {
        "nombre": "CIENCIAS BÁSICAS/ INFORMÁTICA",
        "numero": "605"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA, 3",
        "numero": "606"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA (HOSPITAL JUAN CARLOS I)",
        "numero": "607"
      },
      {
        "nombre": "AVDA. DE LA FERIA (URBANIZACIÓN LOS GERANIOS)",
        "numero": "608"
      },
      {
        "nombre": "C/ ALICANTE (C.S. SAN JOSÉ)",
        "numero": "610"
      },
      {
        "nombre": "C/ SAN JOSÉ ARTESANO, 46",
        "numero": "611"
      },
      {
        "nombre": "CIENCIAS BÁSICAS/ TEOLOGÍA",
        "numero": "612"
      },
      {
        "nombre": "CARRETERA LOMO BLANCO, 54",
        "numero": "613"
      },
      {
        "nombre": "C/ NUEVA, 73",
        "numero": "614"
      },
      {
        "nombre": "HOSPITAL JUAN CARLOS I",
        "numero": "615"
      },
      {
        "nombre": "AVDA. DE LA FERIA (INFECAR)",
        "numero": "617"
      },
      {
        "nombre": "C/ GALILEA, 8",
        "numero": "618"
      },
      {
        "nombre": "HOSPITAL JUAN CARLOS I (REHABILITACIÓN)",
        "numero": "619"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 6",
        "numero": "620"
      },
      {
        "nombre": "C/ ACONCAGUA, 38",
        "numero": "621"
      },
      {
        "nombre": "CARRETERA DE TEROR, 16",
        "numero": "622"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 39",
        "numero": "623"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (FRENTE HIPERCOR)",
        "numero": "624"
      },
      {
        "nombre": "CARRETERA DEL CENTRO (ANTIGUA CÁRCEL)",
        "numero": "625"
      },
      {
        "nombre": "C/ CASTILLO, 16",
        "numero": "626"
      },
      {
        "nombre": "C/ LAS BORRERAS, 10",
        "numero": "627"
      },
      {
        "nombre": "C/ LAS BORRERAS, FRENTE 1",
        "numero": "629"
      },
      {
        "nombre": "C/ ACONCAGUA- CRUCE CON ORINOCO",
        "numero": "630"
      },
      {
        "nombre": "C/ SAN FERNANDO, 38",
        "numero": "631"
      },
      {
        "nombre": "AVDA. DE AMURGA (CARRETERA SAN JUAN DE DIOS)",
        "numero": "633"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (JUZGADOS)",
        "numero": "634"
      },
      {
        "nombre": "C/ FONDOS DE SEGURA, FRENTE 17",
        "numero": "635"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 37",
        "numero": "636"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 28",
        "numero": "637"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 29",
        "numero": "638"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (CATAMARCA)",
        "numero": "639"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (REYES CATÓLICOS)",
        "numero": "640"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (ROTONDA AREQUIPA)",
        "numero": "641"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (PARQUE ROMANO)",
        "numero": "642"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 26",
        "numero": "643"
      },
      {
        "nombre": "C/ CÓRDOBA (BOMBEROS VEGUETA)",
        "numero": "644"
      },
      {
        "nombre": "CATAMARCA, FRENTE  2",
        "numero": "646"
      },
      {
        "nombre": "C/ PROFESOR LOZANO, 34",
        "numero": "648"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 39",
        "numero": "650"
      },
      {
        "nombre": "AVDA.DE AMURGA (EL LASSO, BLOQUE 1)",
        "numero": "651"
      },
      {
        "nombre": "C/ GUANTÁNAMO, FRENTE 121",
        "numero": "655"
      },
      {
        "nombre": "AVDA. DE AMURGA (ACCESO A LOS GRANJEROS)",
        "numero": "656"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 108",
        "numero": "657"
      },
      {
        "nombre": "AVDA. DE AMURGA (CARRETERA SAN JUAN DE DIOS)",
        "numero": "658"
      },
      {
        "nombre": "LOMO DEL CAPON POSTERIOR, 6",
        "numero": "659"
      },
      {
        "nombre": "C/ MARIANAO, FRENTE 82",
        "numero": "660"
      },
      {
        "nombre": "C/ GALILEA, 31",
        "numero": "661"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 115",
        "numero": "662"
      },
      {
        "nombre": "C/ ALBAHACA (I.E.S. JOSE SARAMAGO)",
        "numero": "663"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 165",
        "numero": "664"
      },
      {
        "nombre": "C/ JUDAS TADEO (BARRANQUILLO)",
        "numero": "665"
      },
      {
        "nombre": "PARQUE TECNOLÓGICO",
        "numero": "666"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO",
        "numero": "667"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CARVAJAL)",
        "numero": "668"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO (SAN NICOLÁS)",
        "numero": "669"
      },
      {
        "nombre": "C/ ALBAHACA (I.E.S. JOSE SARAMAGO)",
        "numero": "670"
      },
      {
        "nombre": "C/ SIERRA NEVADA, FRENTE  44",
        "numero": "671"
      },
      {
        "nombre": "C/ JUDAS TADEO, 34",
        "numero": "672"
      },
      {
        "nombre": "C/ GUANTÁNAMO (CENTRO P. SALTO DEL NEGRO)",
        "numero": "673"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 215",
        "numero": "674"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 72",
        "numero": "675"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 102B",
        "numero": "676"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 42",
        "numero": "677"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 64",
        "numero": "678"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, 41",
        "numero": "679"
      },
      {
        "nombre": "C/ SAN JUDAS TADEO (BARRANQUILLO)",
        "numero": "680"
      },
      {
        "nombre": "C/ ARQUITECTO JOSE LUIS JIMENEZ, 3",
        "numero": "681"
      },
      {
        "nombre": "BIBLIOTECA UNIVERSITARIA",
        "numero": "682"
      },
      {
        "nombre": "VIAL SIN NOMBRE",
        "numero": "683"
      },
      {
        "nombre": "ALAMEDA DE COLÓN",
        "numero": "684"
      },
      {
        "nombre": "C/ ISLA DE LA MONTAÑA CLARA, FRENTE 5",
        "numero": "685"
      },
      {
        "nombre": "BERNARDINO CORREA VIERA (C.S. TRIANA)",
        "numero": "686"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 73",
        "numero": "687"
      },
      {
        "nombre": "BIBLIOTECA UNIVERSITARIA",
        "numero": "688"
      },
      {
        "nombre": "BERNARDINO CORREA VIERA,  FRENTE 13",
        "numero": "689"
      },
      {
        "nombre": "AULARIO CIENCIAS JURÍDICAS",
        "numero": "690"
      },
      {
        "nombre": "CIENCIAS JURIDICAS (MÓDULO B)",
        "numero": "691"
      },
      {
        "nombre": "C/ TABLERO DE GONZALO, FRENTE  7",
        "numero": "692"
      },
      {
        "nombre": "C/ JUDAS TADEO, 36",
        "numero": "693"
      },
      {
        "nombre": "C/ MIGUEL MARTIN FERNANDEZ DE LA TORRE (CENTRO DE MENORES)",
        "numero": "694"
      },
      {
        "nombre": "C/ MANZANILLA FRENTE 14",
        "numero": "695"
      },
      {
        "nombre": "C/ TUNERILLAS, FRENTE 20",
        "numero": "696"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 17",
        "numero": "698"
      },
      {
        "nombre": "C/ TABLERO DE GONZALO",
        "numero": "699"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 25",
        "numero": "700"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 88",
        "numero": "701"
      },
      {
        "nombre": "AVDA. DE ANSITE ( FRENTE CEMENTERIO DEL PUERTO)",
        "numero": "702"
      },
      {
        "nombre": "AVDA. DE ANSITE (CEMENTERIO DEL PUERTO)",
        "numero": "703"
      },
      {
        "nombre": "C/ HOYA DE LA GALLINA (ESTADIO GRAN CANARIA)",
        "numero": "704"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (HOSPITALIZACIÓN)",
        "numero": "705"
      },
      {
        "nombre": "ROTONDA HOSPITAL DR. NEGRÍN",
        "numero": "706"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (ROTONDA HOSPITAL DR. NEGRÍN)",
        "numero": "708"
      },
      {
        "nombre": "CARRETERA CIUDAD SAN JUAN DE DIOS (GUINCHO)",
        "numero": "709"
      },
      {
        "nombre": "C/ PARDELA 14",
        "numero": "711"
      },
      {
        "nombre": "C/ MIMOSA",
        "numero": "712"
      },
      {
        "nombre": "CIENCIAS BÁSICAS",
        "numero": "714"
      },
      {
        "nombre": "CARRETERA CIUDAD SAN JUAN DE DIOS (GUINCHO)",
        "numero": "715"
      },
      {
        "nombre": "C/ MIMOSA",
        "numero": "717"
      },
      {
        "nombre": "C/ CAMELIA, FRENTE 11",
        "numero": "719"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 22",
        "numero": "721"
      },
      {
        "nombre": "C/ MARIUCHA (CANÓDROMO)",
        "numero": "722"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 38",
        "numero": "723"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 3",
        "numero": "724"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (C.C. SIETE PALMAS)",
        "numero": "725"
      },
      {
        "nombre": "C/ JUDAS TADEO, 66",
        "numero": "726"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, FRENTE 102",
        "numero": "728"
      },
      {
        "nombre": "INGENIERÍAS",
        "numero": "731"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 12",
        "numero": "733"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 3",
        "numero": "734"
      },
      {
        "nombre": "C/ JUDAS TADEO, 61",
        "numero": "735"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "736"
      },
      {
        "nombre": "C/ SERVENTIA, 145",
        "numero": "738"
      },
      {
        "nombre": "C/ PLUTÓN, FRENTE 14",
        "numero": "739"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE (FÁBRICA DE TEJAS)",
        "numero": "740"
      },
      {
        "nombre": "C/ LEOPOLDO ALONSO, 5",
        "numero": "741"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE (GASOLINERA)",
        "numero": "742"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 20",
        "numero": "743"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE",
        "numero": "744"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, FRENTE 47",
        "numero": "745"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 135",
        "numero": "746"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, FRENTE 71",
        "numero": "747"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 169",
        "numero": "748"
      },
      {
        "nombre": "C/ SERVENTÍA, 189",
        "numero": "749"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 259",
        "numero": "750"
      },
      {
        "nombre": "C/ SERVENTÍA, 101",
        "numero": "751"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 400",
        "numero": "752"
      },
      {
        "nombre": "C/ SERVENTIA, 85",
        "numero": "753"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 3",
        "numero": "754"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, FRENTE 32",
        "numero": "756"
      },
      {
        "nombre": "C/ PLUTÓN (CEIP HOYA ANDREA)",
        "numero": "757"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 69",
        "numero": "758"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 230",
        "numero": "759"
      },
      {
        "nombre": "C/ LORENZO SUÁREZ RIVERO, FRENTE 51",
        "numero": "760"
      },
      {
        "nombre": "CARRETERA NUEVA DE SAN LORENZO",
        "numero": "761"
      },
      {
        "nombre": "C/ LORENZO SUAREZ RIVERO, 22",
        "numero": "762"
      },
      {
        "nombre": "CARRETERA NUEVA DE SAN LORENZO (GASOLINERA)",
        "numero": "763"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 282",
        "numero": "764"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 120",
        "numero": "765"
      },
      {
        "nombre": "C/ OLIVO (CARRETERA DE ALMATRICHE)",
        "numero": "766"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 154",
        "numero": "767"
      },
      {
        "nombre": "C/ HABANA, 27",
        "numero": "768"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 188",
        "numero": "769"
      },
      {
        "nombre": "C/ PINTOR JUAN GUILLERMO, FRENTE 19",
        "numero": "770"
      },
      {
        "nombre": "CARRETERA SAN LORENZO 254",
        "numero": "771"
      },
      {
        "nombre": "C/ PINTOR JUAN GUILLERMO (C.C. LA MINILLA)",
        "numero": "772"
      },
      {
        "nombre": "C/ LEOPOLDO ALONSO",
        "numero": "773"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 13",
        "numero": "774"
      },
      {
        "nombre": "C/ EL OLIVO (CARRETERA DE ALMATRICHE)",
        "numero": "775"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 61",
        "numero": "776"
      },
      {
        "nombre": "C/ HABANA, 28",
        "numero": "777"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 9",
        "numero": "778"
      },
      {
        "nombre": "AVDA. GARCIA LORCA, FRENTE 14",
        "numero": "779"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 41",
        "numero": "780"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, FRENTE 11",
        "numero": "781"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 70",
        "numero": "783"
      },
      {
        "nombre": "CARRETERA SUBIDA A TAFIRA (LA FAVORITA)",
        "numero": "786"
      },
      {
        "nombre": "CTRA. PICO VIENTO (ASILO DE ANCIANOS)",
        "numero": "787"
      },
      {
        "nombre": "CTRA. PICO VIENTO (ASILO DE ANCIANOS)",
        "numero": "788"
      },
      {
        "nombre": "AVDA. GARCIA LORCA, 17",
        "numero": "789"
      },
      {
        "nombre": "C/ LÁZARO  DE ORTEGA (CIUDAD DEL CAMPO)",
        "numero": "791"
      },
      {
        "nombre": "C/ LÁZARO DE ORTEGA, 39",
        "numero": "793"
      },
      {
        "nombre": "C/ CUESTA BLANCA, FRENTE 11",
        "numero": "795"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 34",
        "numero": "797"
      },
      {
        "nombre": "PASEO TOMAS MORALES, 4",
        "numero": "799"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "892"
      },
      {
        "nombre": "INTERCAMBIADOR DE TAMARACEITE",
        "numero": "893"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "894"
      },
      {
        "nombre": "LATERAL NORTE - MERCADO VEGUETA",
        "numero": "895"
      },
      {
        "nombre": "C/ SIERRA NEVADA (SAN FRANCISCO)",
        "numero": "897"
      },
      {
        "nombre": "INGENIERÍAS",
        "numero": "898"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "899"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "901"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (IES FELO MONZON)",
        "numero": "902"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, FRENTE 51",
        "numero": "903"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (FRENTE HIPERCOR)",
        "numero": "904"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 72",
        "numero": "905"
      },
      {
        "nombre": "C/ BETANIA, 69",
        "numero": "906"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, FRENTE 51",
        "numero": "907"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "928"
      },
      {
        "nombre": "LA BALLENA",
        "numero": "929"
      },
      {
        "nombre": "TEATRO",
        "numero": "930"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "931"
      },
      {
        "nombre": "TEATRO",
        "numero": "932"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "933"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "934"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "935"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "936"
      },
      {
        "nombre": "TEATRO",
        "numero": "938"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "939"
      },
      {
        "nombre": "GUINIGUADA",
        "numero": "940"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "941"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "942"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ (EL SEBADAL)",
        "numero": "943"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "944"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (HOSPITAL DR. NEGRÍN)",
        "numero": "945"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "946"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "947"
      },
      {
        "nombre": "GUINIGUADA",
        "numero": "948"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 56",
        "numero": "949"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "950"
      },
      {
        "nombre": "C/ BARAHONA, 77",
        "numero": "201"
      },
      {
        "nombre": "RESIDENCIAS (CAMPUS UNIVERSITARIO)",
        "numero": "951"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "955"
      },
      {
        "nombre": "TEATRO",
        "numero": "956"
      },
      {
        "nombre": "AVDA. SEMANA DE LA PASIÓN, 13  (LAS COLORADAS)",
        "numero": "957"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "958"
      },
      {
        "nombre": "C/ JUDAS TADEO (ISLA PERDIDA)",
        "numero": "959"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "960"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "962"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "963"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "965"
      },
      {
        "nombre": "INTERCAMBIADOR DE TAMARACEITE",
        "numero": "966"
      },
      {
        "nombre": "CAMPUS UNIVERSITARIO (INGENIERÍAS)",
        "numero": "968"
      },
      {
        "nombre": "C/ LEONARDO TORRIANI (ZÁRATE)",
        "numero": "970"
      },
      {
        "nombre": "AVDA DEL PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "971"
      },
      {
        "nombre": "C/ GAVILAN (RESIDENCIAL LOS GRANJEROS)",
        "numero": "972"
      },
      {
        "nombre": "C/ OTOÑO (HOYA ANDREA)",
        "numero": "973"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "974"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN",
        "numero": "975"
      },
      {
        "nombre": "TEATRO",
        "numero": "976"
      },
      {
        "nombre": "C/ CRONISTA NAVARRO RUIZ ,6",
        "numero": "977"
      },
      {
        "nombre": "CIUDAD DE SAN JUAN DE DIOS",
        "numero": "978"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "979"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO (SAN FRANCISCO DE PAULA)",
        "numero": "980"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "981"
      },
      {
        "nombre": "TEATRO",
        "numero": "982"
      },
      {
        "nombre": "CAMPUS UNIVERSITARIO (INGENIERÍAS)       (ES LA MISMA QUE LA P898)",
        "numero": "983"
      },
      {
        "nombre": "TEATRO",
        "numero": "984"
      },
      {
        "nombre": "C/ ARMINDA, 28 (EL SECADERO)",
        "numero": "985"
      },
      {
        "nombre": "TEATRO",
        "numero": "986"
      },
      {
        "nombre": "C/ LOMO DE LA CRUZ",
        "numero": "987"
      },
      {
        "nombre": "TEATRO",
        "numero": "988"
      },
      {
        "nombre": "C/ SIERRA NEVADA (SAN FRANCISCO)",
        "numero": "989"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "990"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "991"
      },
      {
        "nombre": "TEATRO",
        "numero": "992"
      },
      {
        "nombre": "MERCADO DE  VEGUETA",
        "numero": "993"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "994"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "995"
      },
      {
        "nombre": "EDUARDO BENOT (frente los bardinos)",
        "numero": "996"
      },
      {
        "nombre": "TEATRO",
        "numero": "998"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "999"
      },
      {
        "nombre": "GLORIA",
        "numero": "465"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "892"
      },
      {
        "nombre": "AVDA. MARITIMA DEL SUR",
        "numero": "516"
      },
      {
        "nombre": "Aparcamiento Inter-Modal El Rincón",
        "numero": "509"
      },
      {
        "nombre": "Carretera de Mata (Castillo de Mata)",
        "numero": "318"
      },
      {
        "nombre": "JUAN M DURAN GALICIA",
        "numero": "782"
      },
      {
        "nombre": "MIGUEL CURBELO AUTORIDAD PORTUARIA",
        "numero": "573"
      },
      {
        "nombre": "ROTONDA CAPITAN N.MASTRO",
        "numero": "575"
      },
      {
        "nombre": "MUELLE LEON Y CASTILLO GASOLINERA BP",
        "numero": "577"
      },
      {
        "nombre": "Av de las Petroliferas Depositos Comerciales",
        "numero": "579"
      },
      {
        "nombre": "MIGUEL CURBELO AUTORIDAD PORTUARIA",
        "numero": "586"
      },
      {
        "nombre": "MUELLE LEON Y CASTILLO GASOLINERA BP",
        "numero": "588"
      },
      {
        "nombre": "Av de las Petroliferas Depositos Comerciales",
        "numero": "590"
      },
      {
        "nombre": "Av de las Petroliferas Astican",
        "numero": "591"
      },
      {
        "nombre": "Av de las Petroliferas Astican",
        "numero": "592"
      },
      {
        "nombre": "Av de las Petroliferas Repnaval",
        "numero": "593"
      },
      {
        "nombre": "Av de las Petroliferas Repnaval",
        "numero": "594"
      },
      {
        "nombre": "REINA SOFIA",
        "numero": "937"
      },
      {
        "nombre": "M BECERRA L20",
        "numero": "953"
      },
      {
        "nombre": "San Cristobal Acceso Av Maritima",
        "numero": "526"
      },
      {
        "nombre": "San Cristobal Estribor",
        "numero": "514"
      },
      {
        "nombre": "C/ FARMACEUTICO PEDRO RIVERO, FRENTE 15",
        "numero": "361"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (OFICINAS MUNICIPALES)",
        "numero": "18"
      },
      {
        "nombre": "Carretera Centro Barrio Quilmes 3",
        "numero": "790"
      },
      {
        "nombre": "Hermanos Dominguez Santana - CC ALISIOS",
        "numero": "755"
      },
      {
        "nombre": "Hermanos Dominguez Santana (CC ALISIOS)",
        "numero": "727"
      },
      {
        "nombre": "C/ RAFAEL MESA Y LOPEZ (CEIP TIMPLISTA JOSE ANTONIO RAMOS)",
        "numero": "467"
      },
      {
        "nombre": "C/ RAFAEL MESA Y LOPEZ (EL AUDAZ)",
        "numero": "499"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSE SANCHEZ PENATE (CC LAS ARENAS)",
        "numero": "961"
      },
      {
        "nombre": "GALILEA 60",
        "numero": "730"
      },
      {
        "nombre": "C/ GAVILAN (RESIDENCIAL LOS GRANJEROS)",
        "numero": "713"
      },
      {
        "nombre": "C/ IGNACIO PEREZ GALDOS CON CALZADA LATERAL DEL NORTE",
        "numero": "507"
      },
      {
        "nombre": "C/ OBISPO MARQUINA (CEIP SANTIAGO RAMON Y CAJAL)",
        "numero": "453"
      },
      {
        "nombre": "AVDA. 8 DE MARZO DIA INTERNACIONAL DE LA MUJER",
        "numero": "729"
      },
      {
        "nombre": "AVDA. 8 DE MARZO DIA INTERNACIONAL DE LA MUJER",
        "numero": "732"
      },
      {
        "nombre": "REINA SOFIA",
        "numero": "628"
      },
      {
        "nombre": "AV. DE LAS PETROLIFERAS (REINA SOFIA)",
        "numero": "602"
      },
      {
        "nombre": "NELSON MANDELA (ACCESO)",
        "numero": "609"
      },
      {
        "nombre": "NELSON MANDELA (SALIDA)",
        "numero": "616"
      },
      {
        "nombre": "HERMANOS DOMINGUEZ SANTANA (DECATHLON)",
        "numero": "737"
      },
      {
        "nombre": "NELSON MANDELA (ARMAS)",
        "numero": "964"
      },
      {
        "nombre": "PROVISIONAL FRANCISCO GOURIE",
        "numero": "926"
      },
      {
        "nombre": "MESA Y LOPEZ (BASE NAVAL)",
        "numero": "798"
      },
      {
        "nombre": "PICO VIENTO",
        "numero": "794"
      },
      {
        "nombre": "Ciudad Deportiva Gran Canaria",
        "numero": "792"
      },
      {
        "nombre": "Hoya de la Plata",
        "numero": "796"
      },
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
        "nombre": "AVDA. RAFAEL CABRERA (SAN TELMO)",
        "numero": "3"
      },
      {
        "nombre": "C/ TRIANA",
        "numero": "4"
      },
      {
        "nombre": "C/ VENEGAS (USOS MÚLTIPLES)",
        "numero": "5"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 13",
        "numero": "6"
      },
      {
        "nombre": "C/ VENEGAS (FUENTE LUMINOSA)",
        "numero": "7"
      },
      {
        "nombre": "C/ LEON Y CASTILLO (PLAZA DE LA FERIA)",
        "numero": "8"
      },
      {
        "nombre": "C/ LUIS DORESTE SILVA, 22",
        "numero": "9"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 145",
        "numero": "10"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "11"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 185",
        "numero": "12"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (C.N. METROPOLE)",
        "numero": "13"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 209",
        "numero": "14"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (OFICINAS MUNICIPALES)",
        "numero": "15"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (COLEGIO SALESIANO)",
        "numero": "16"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (TORRE LAS PALMAS)",
        "numero": "17"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "20"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (EDIFICIO JOSÉ ANTONIO)",
        "numero": "22"
      },
      {
        "nombre": "PL. SAN JUAN BAUTISTA (BASE NAVAL)",
        "numero": "23"
      },
      {
        "nombre": "C/ PRESIDENTE ALVEAR (IGLESIA DEL PINO)",
        "numero": "24"
      },
      {
        "nombre": "C/ EDUARDO BENOT, FRENTE 5",
        "numero": "25"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "26"
      },
      {
        "nombre": "C/ EDUARDO BENOT, FRENTE 23",
        "numero": "27"
      },
      {
        "nombre": "C/ ALBAREDA, 43",
        "numero": "28"
      },
      {
        "nombre": "C/ AGUSTÍN MILLARES SALL (EDIFICIO MAPFRE)",
        "numero": "29"
      },
      {
        "nombre": "C/ JUAN REJÓN,25",
        "numero": "30"
      },
      {
        "nombre": "C/ JUAN REJÓN (CASTILLO DE LA LUZ)",
        "numero": "31"
      },
      {
        "nombre": "C/ LA NAVAL",
        "numero": "33"
      },
      {
        "nombre": "C/ JUAN REJÓN, 67",
        "numero": "34"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (JUAN XXIII)",
        "numero": "35"
      },
      {
        "nombre": "AVDA. DE CANARIAS (SAN TELMO)",
        "numero": "36"
      },
      {
        "nombre": "C/ LUIS DORESTE SILVA, 50",
        "numero": "37"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CENTRO INSULAR DE DEPORTES)",
        "numero": "38"
      },
      {
        "nombre": "AVDA. JUAN XXIII (CLINICA DEL PINO)",
        "numero": "39"
      },
      {
        "nombre": "AVDA.  ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CARVAJAL)",
        "numero": "40"
      },
      {
        "nombre": "AVDA. JUAN XXIII (COLEGIO CANTERBURY)",
        "numero": "41"
      },
      {
        "nombre": "DR. WALKSMANN, 10 (PLAZA LA FERIA)",
        "numero": "42"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 80 (BARRANQUILLO DON ZOILO)",
        "numero": "43"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "44"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 154 (BARRANQUILLO DON ZOILO)",
        "numero": "45"
      },
      {
        "nombre": "C/ PÉREZ DEL TORO, 13",
        "numero": "46"
      },
      {
        "nombre": "C/ CARLOS M. BLANDY (PLAZA DE ARUCAS)",
        "numero": "47"
      },
      {
        "nombre": "C/ PÉREZ DEL TORO (PLAZA DR. JUAN BOSCH MILLARES)",
        "numero": "48"
      },
      {
        "nombre": "C/ ALMIRANTE BENÍTEZ INGLOTT, 12",
        "numero": "49"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 61 (BARRANQUILLO DON ZOILO)",
        "numero": "50"
      },
      {
        "nombre": "C/ ALMIRANTE BENÍTEZ INGLOTT (C.S. ESCALERITAS)",
        "numero": "51"
      },
      {
        "nombre": "C/ PARROCO MATIAS ARTILES",
        "numero": "52"
      },
      {
        "nombre": "C/ PINTOR JUAN ISMAEL (IGLESIA REDONDA)",
        "numero": "53"
      },
      {
        "nombre": "C/ ECHEGARAY, 137",
        "numero": "54"
      },
      {
        "nombre": "C/ TEOBALDO POWER, FRENTE 51",
        "numero": "55"
      },
      {
        "nombre": "C/ HENRY DUNANT, FRENTE 10",
        "numero": "56"
      },
      {
        "nombre": "AVDA. ESCALERITAS, FRENTE 111",
        "numero": "57"
      },
      {
        "nombre": "C/ PRESIDENTE ALVEAR, 17",
        "numero": "58"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN SANSOFÉ)",
        "numero": "59"
      },
      {
        "nombre": "C/ DEAN RODRÍGUEZ BOLAÑOS (PL. ALVARADO Y SAZ)",
        "numero": "60"
      },
      {
        "nombre": "AVDA. ESCALERITAS( FRENTE C.C. LA BALLENA)",
        "numero": "61"
      },
      {
        "nombre": "C/ TEOBALDO POWER (IGLESIA REDONDA)",
        "numero": "62"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 1",
        "numero": "63"
      },
      {
        "nombre": "C/ MARIUCHA, 139",
        "numero": "64"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 19",
        "numero": "65"
      },
      {
        "nombre": "C/ MARIUCHA, 171",
        "numero": "66"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 33",
        "numero": "67"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN SANSOFÉ)",
        "numero": "68"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO (PACUCO PENICHET)",
        "numero": "69"
      },
      {
        "nombre": "AVDA. ESCALERITAS (C.C. LA BALLENA)",
        "numero": "70"
      },
      {
        "nombre": "AVDA. ALCALDE DÍAZ SAAVEDRA NAVARRO (PL. SANTA ISABEL)",
        "numero": "71"
      },
      {
        "nombre": "AVDA. DE LA FERIA (INFECAR)",
        "numero": "72"
      },
      {
        "nombre": "C/ DR. HERNAN PEREZ DE GRADO, 6",
        "numero": "73"
      },
      {
        "nombre": "C/ DIEGO BETANCOR SUAREZ , 19",
        "numero": "74"
      },
      {
        "nombre": "C/ DR. HERNÁN PEREZ DE GRADO (LA PORTADILLA)",
        "numero": "75"
      },
      {
        "nombre": "C/ DIEGO BETANCOR SUAREZ, 39",
        "numero": "76"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (CARREFOUR)",
        "numero": "77"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (JUZGADOS)",
        "numero": "78"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        "numero": "79"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO, FRENTE 32",
        "numero": "80"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 170",
        "numero": "81"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        "numero": "82"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 214",
        "numero": "83"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 154",
        "numero": "84"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 264",
        "numero": "85"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 208",
        "numero": "86"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 290",
        "numero": "87"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 266",
        "numero": "88"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (IGLESIA SANTA CLARA)",
        "numero": "89"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 298",
        "numero": "90"
      },
      {
        "nombre": "C/ MARIANAO, 12",
        "numero": "91"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, FRENTE 306",
        "numero": "92"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (PARKING HOSPITAL MATERNO INSULAR)",
        "numero": "93"
      },
      {
        "nombre": "Primero de Mayo ,6",
        "numero": "21"
      },
      {
        "nombre": "Primero de Mayo (ONCE)",
        "numero": "19"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (IGLESIA SANTA CLARA)",
        "numero": "94"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (MARTÍN FREIRE)",
        "numero": "95"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (PARKING HOSPITAL MATERNO INSULAR)",
        "numero": "96"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, 14",
        "numero": "97"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (MARTÍN FREIRE)",
        "numero": "98"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 8",
        "numero": "99"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, FRENTE 16",
        "numero": "100"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 30",
        "numero": "101"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (CARREFOUR)",
        "numero": "102"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 46",
        "numero": "103"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, FRENTE 8",
        "numero": "104"
      },
      {
        "nombre": "C/ MIGUEL MARTÍN FERNÁNDEZ DE LA TORRE , 7",
        "numero": "105"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 15",
        "numero": "106"
      },
      {
        "nombre": "C/ CÓRDOBA, 40",
        "numero": "107"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 41",
        "numero": "108"
      },
      {
        "nombre": "C/ CÓRDOBA, FRENTE 31",
        "numero": "109"
      },
      {
        "nombre": "C/ CÓRDOBA (BOMBEROS VEGUETA)",
        "numero": "110"
      },
      {
        "nombre": "C/ AYAGAURES (TANATORIO SAN MIGUEL)",
        "numero": "111"
      },
      {
        "nombre": "C/ CÓRDOBA, FRENTE 49",
        "numero": "113"
      },
      {
        "nombre": "C/ CÓRDOBA, 19",
        "numero": "114"
      },
      {
        "nombre": "C/ CÓRDOBA, 54",
        "numero": "115"
      },
      {
        "nombre": "C/ CÓRDOBA, 29",
        "numero": "116"
      },
      {
        "nombre": "C/ ALICANTE (COLEGIO ISLAS CANARIAS)",
        "numero": "117"
      },
      {
        "nombre": "C/ CÓRDOBA, 49",
        "numero": "118"
      },
      {
        "nombre": "AVDA. DE AMURGA (C.S. CONO SUR)",
        "numero": "119"
      },
      {
        "nombre": "C/ CÓRDOBA, 71",
        "numero": "120"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 10",
        "numero": "121"
      },
      {
        "nombre": "C/ ALICANTE (COLEGIO ISLAS CANARIAS)",
        "numero": "122"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 20",
        "numero": "123"
      },
      {
        "nombre": "C/ SARGENTO SALOM, 34",
        "numero": "124"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS, FRENTE 16",
        "numero": "125"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 35",
        "numero": "126"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS, FRENTE 2",
        "numero": "127"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 53",
        "numero": "128"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES,  6",
        "numero": "129"
      },
      {
        "nombre": "C/ DEBUSSY, 3",
        "numero": "130"
      },
      {
        "nombre": "C/ JUAN SÁNCHEZ DE LA COBA, 2",
        "numero": "131"
      },
      {
        "nombre": "C/ DEBUSSY, 9",
        "numero": "132"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 6",
        "numero": "133"
      },
      {
        "nombre": "C/ DEBUSSY, FRENTE  6",
        "numero": "134"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 33)",
        "numero": "135"
      },
      {
        "nombre": "C/ ANTON DVORAK, 5",
        "numero": "136"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 1)",
        "numero": "137"
      },
      {
        "nombre": "C/ JUAN SEBASTIAN BACH, FRENTE 4",
        "numero": "138"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 5)",
        "numero": "139"
      },
      {
        "nombre": "C/ BERLIOZ, 5",
        "numero": "140"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 17)",
        "numero": "141"
      },
      {
        "nombre": "C/ SCHUBERT, FRENTE 6",
        "numero": "142"
      },
      {
        "nombre": "C/ SARGENTO SALOM, 44",
        "numero": "143"
      },
      {
        "nombre": "C/ SCHUBERT, 5",
        "numero": "144"
      },
      {
        "nombre": "C/PEDRO HIDALGO (POLIDEPORTIVO)",
        "numero": "145"
      },
      {
        "nombre": "C/ SCHUBERT, 17",
        "numero": "146"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, FRENTE 91",
        "numero": "147"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, 5",
        "numero": "148"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, FRENTE 51",
        "numero": "149"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES, 19",
        "numero": "150"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 96",
        "numero": "151"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES, 33",
        "numero": "152"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA,  FRENTE 133",
        "numero": "153"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 19",
        "numero": "154"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 168",
        "numero": "155"
      },
      {
        "nombre": "AVDA. DE AMURGA (C.S. CONO SUR)",
        "numero": "156"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "157"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TEERRERAS EL LASSO, 33)",
        "numero": "158"
      },
      {
        "nombre": "C/ CANDELARIA DE LÉON, 6",
        "numero": "159"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 1)",
        "numero": "160"
      },
      {
        "nombre": "C/ FARMACEÚTICO ARENCIBIA CABRERA (COFARCA)",
        "numero": "161"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 4)",
        "numero": "162"
      },
      {
        "nombre": "C/ CONCEJAL ANDRÉS ALVARADO JANINA (LOCAL SOCIAL HOYA DE LA PLATA)",
        "numero": "163"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 17)",
        "numero": "164"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (HOSPITAL MATERNO INSULAR)",
        "numero": "165"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 97",
        "numero": "166"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (ESCUELA DE ARTE)",
        "numero": "167"
      },
      {
        "nombre": "C/ SALAMANCA, 63",
        "numero": "168"
      },
      {
        "nombre": "C/ ARGUINEGUÍN",
        "numero": "169"
      },
      {
        "nombre": "C/ SALAMANCA, 99",
        "numero": "170"
      },
      {
        "nombre": "C/ REYES CATÓLICOS, 9",
        "numero": "171"
      },
      {
        "nombre": "C/ SALAMANCA, 135",
        "numero": "172"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 2",
        "numero": "173"
      },
      {
        "nombre": "AVDA.  JUAN CARLOS I, 9",
        "numero": "174"
      },
      {
        "nombre": "C/ NUEVA, FRENTE  67",
        "numero": "175"
      },
      {
        "nombre": "AVDA JUAN CARLOS I, 23",
        "numero": "176"
      },
      {
        "nombre": "C/ ANDENES, FRENTE 15",
        "numero": "177"
      },
      {
        "nombre": "C/ CANDELARIA DE LEÓN, 7",
        "numero": "178"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN, 10",
        "numero": "179"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 128",
        "numero": "180"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN, 42",
        "numero": "181"
      },
      {
        "nombre": "C/ CONCEJAL ANDRES ALVARADO JANINA (LOCAL SOCIAL HOYA DE LA PLATA)",
        "numero": "182"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN (PLAZA DEL SOL NACIENTE)",
        "numero": "183"
      },
      {
        "nombre": "RESIDENCIAL FLOR SIRERA",
        "numero": "184"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN, 16",
        "numero": "185"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 1",
        "numero": "186"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN, 48",
        "numero": "187"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (TRÓPICO)",
        "numero": "188"
      },
      {
        "nombre": "C/ REAL DE SAN ROQUE, FRENTE 11",
        "numero": "189"
      },
      {
        "nombre": "C/ ANDENES, 9",
        "numero": "190"
      },
      {
        "nombre": "C/ FARNESIO, FRENTE 15",
        "numero": "191"
      },
      {
        "nombre": "C/ NÉSTOR ÁLAMO (CAMPO DE LUCHA)",
        "numero": "192"
      },
      {
        "nombre": "C/ FARNESIO, FRENTE 59",
        "numero": "193"
      },
      {
        "nombre": "CARRETERA EL CARDON (ROTONDA)",
        "numero": "194"
      },
      {
        "nombre": "C/ FAMA, FRENTE 85",
        "numero": "195"
      },
      {
        "nombre": "AVDA. JUAN XXIII (CLINICA DEL PINO)",
        "numero": "196"
      },
      {
        "nombre": "C/ ANDENES, FRENTE 39",
        "numero": "197"
      },
      {
        "nombre": "ACCESO ANTIGUA CARCEL",
        "numero": "198"
      },
      {
        "nombre": "C/ NUEVA, FRENTE 25",
        "numero": "199"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN",
        "numero": "202"
      },
      {
        "nombre": "C/ BARAHONA, FRENTE 19",
        "numero": "203"
      },
      {
        "nombre": "C/ JUAN DE QUESADA (RECTORADO ULPGC)",
        "numero": "204"
      },
      {
        "nombre": "LA MATULA, FRENTE 25",
        "numero": "205"
      },
      {
        "nombre": "C/ REAL DE SAN ROQUE, 13",
        "numero": "206"
      },
      {
        "nombre": "LA MATULA, FRENTE 61",
        "numero": "207"
      },
      {
        "nombre": "C/ FARNESIO, 13",
        "numero": "208"
      },
      {
        "nombre": "LA MATULA, FRENTE  95",
        "numero": "209"
      },
      {
        "nombre": "C/ FARNESIO, 53",
        "numero": "210"
      },
      {
        "nombre": "PUENTE LA MATULA",
        "numero": "211"
      },
      {
        "nombre": "C/ FAMA, 71",
        "numero": "212"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (HNOS. TOLEDO SUAREZ)",
        "numero": "213"
      },
      {
        "nombre": "C/ ANDENES, 19",
        "numero": "214"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (LOMO VERDEJO)",
        "numero": "215"
      },
      {
        "nombre": "C/ NUEVA, 35",
        "numero": "216"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (FELIPE MARTELL)",
        "numero": "217"
      },
      {
        "nombre": "C/ NUEVA, 77",
        "numero": "218"
      },
      {
        "nombre": "C/ SAN JOSÉ ARTESANO, 24",
        "numero": "219"
      },
      {
        "nombre": "C/ BARAHONA, 19",
        "numero": "220"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 62",
        "numero": "221"
      },
      {
        "nombre": "C/ LA MATULA, 25",
        "numero": "222"
      },
      {
        "nombre": "C/ SEVERO OCHOA",
        "numero": "223"
      },
      {
        "nombre": "C/ LA MATULA, 65",
        "numero": "224"
      },
      {
        "nombre": "C/ SEVERO OCHOA,  12",
        "numero": "225"
      },
      {
        "nombre": "C/ LA MATULA, 97",
        "numero": "226"
      },
      {
        "nombre": "C/ SEVERO OCHOA (GEORGE PIRE)",
        "numero": "227"
      },
      {
        "nombre": "C/ AYAGAURES (TANATORIO SAN MIGUEL)",
        "numero": "228"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS, 5",
        "numero": "229"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (PUENTE LA MATULA)",
        "numero": "230"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS (IGLESIA EL BATÁN)",
        "numero": "231"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (HNOS. TOLEDO SUÁREZ)",
        "numero": "232"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 116",
        "numero": "233"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (EL HORNILLO)",
        "numero": "234"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, FRENTE 121",
        "numero": "235"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (FELIPE MARTEL)",
        "numero": "236"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 166",
        "numero": "237"
      },
      {
        "nombre": "C/ ARGUINEGUÍN, 8",
        "numero": "238"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 220",
        "numero": "239"
      },
      {
        "nombre": "AUTOVIA DE GUINIGUADA (SAN JUAN BOSCO)",
        "numero": "240"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 276",
        "numero": "241"
      },
      {
        "nombre": "C/ SEVERO OCHOA, FRENTE 10",
        "numero": "242"
      },
      {
        "nombre": "AVDA. PRIMERO DE MAYO (CORREOS)",
        "numero": "243"
      },
      {
        "nombre": "C/ SEVERO OCHOA (ALBERT SCHWITZER)",
        "numero": "244"
      },
      {
        "nombre": "C/ INGENIERO JOSÉ BOSCH Y SINTÉS, 1",
        "numero": "245"
      },
      {
        "nombre": "C/ SEVERO OCHOA (GEORGE BERNARD SHAW)",
        "numero": "246"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "247"
      },
      {
        "nombre": "C/ MIGUEL ANGEL ASTURIAS, FRENTE 5",
        "numero": "248"
      },
      {
        "nombre": "PASEO TOMÁS MORALES, FRENTE 69",
        "numero": "249"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS (IGLESIA EL BATAN)",
        "numero": "250"
      },
      {
        "nombre": "PASEO TOMÁS MORALES, 120",
        "numero": "251"
      },
      {
        "nombre": "ROTONDA DE LOMO BLANCO",
        "numero": "252"
      },
      {
        "nombre": "C/ EMILIO LEY (PISCINAS JULIO NAVARRO)",
        "numero": "253"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY, 9",
        "numero": "254"
      },
      {
        "nombre": "C/ PÍO XII (COLEGIO TERESIANO)",
        "numero": "255"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY, FRENTE 132",
        "numero": "256"
      },
      {
        "nombre": "C/ PÍO XII (ESTADIO INSULAR)",
        "numero": "257"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY (COLEGIO EL BATÁN)",
        "numero": "258"
      },
      {
        "nombre": "C/ GALICIA (MERCADO CENTRAL)",
        "numero": "259"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA (COFARCA)",
        "numero": "260"
      },
      {
        "nombre": "C/ GALICIA, 32",
        "numero": "261"
      },
      {
        "nombre": "AVDA. PRIMERO DE MAYO, 35",
        "numero": "262"
      },
      {
        "nombre": "C/ TOMÁS MILLER, FRENTE 31",
        "numero": "263"
      },
      {
        "nombre": "C/ PASEO TOMÁS MORALES, 5",
        "numero": "264"
      },
      {
        "nombre": "C/ LUJÁN PÉREZ, 20",
        "numero": "265"
      },
      {
        "nombre": "C/ EMILIO LEY (PARQUE DORAMAS)",
        "numero": "266"
      },
      {
        "nombre": "C/ LUJÁN PÉREZ, 66",
        "numero": "267"
      },
      {
        "nombre": "AVDA PRIMERO DE MAYO, 1",
        "numero": "268"
      },
      {
        "nombre": "C/ TINGUARÓ, 18",
        "numero": "269"
      },
      {
        "nombre": "C/ PÍO XII , 27 (COLEGIO TERESIANO)",
        "numero": "270"
      },
      {
        "nombre": "C/ GUMIDAFE, 30",
        "numero": "271"
      },
      {
        "nombre": "C/ PÍO XII (ESTADIO INSULAR)",
        "numero": "272"
      },
      {
        "nombre": "C / OSORIO, 28",
        "numero": "273"
      },
      {
        "nombre": "C/ PÍO XII, 75",
        "numero": "274"
      },
      {
        "nombre": "C/ OSORIO, 58",
        "numero": "275"
      },
      {
        "nombre": "C/ GALICIA, 15 (MERCADO CENTRAL)",
        "numero": "276"
      },
      {
        "nombre": "C/ FELIPE MARTELL (LINDERO)",
        "numero": "277"
      },
      {
        "nombre": "C/ BANDAMA, 25",
        "numero": "278"
      },
      {
        "nombre": "C/ PRIMERO DE MAYO, 56",
        "numero": "279"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 38",
        "numero": "280"
      },
      {
        "nombre": "CARRETERA DE MATA (PL. DEL PINO)",
        "numero": "281"
      },
      {
        "nombre": "C/ ALBAREDA (MERCADO DEL PUERTO)",
        "numero": "282"
      },
      {
        "nombre": "CARRETERA DE MATA, 10-12  (SAN ANTONIO)",
        "numero": "283"
      },
      {
        "nombre": "C/ FARO, 11",
        "numero": "284"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, FRENTE AL Nº83",
        "numero": "285"
      },
      {
        "nombre": "C/ FARO, 43",
        "numero": "286"
      },
      {
        "nombre": "PASEO DE SAN ANTONIO, 56",
        "numero": "287"
      },
      {
        "nombre": "C/ FARO, 99",
        "numero": "288"
      },
      {
        "nombre": "C/ MARIUCHA (PLAZA DON BENITO)",
        "numero": "289"
      },
      {
        "nombre": "C/ CORONEL ROCHA (NUEVA ISLETA)",
        "numero": "290"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 24",
        "numero": "291"
      },
      {
        "nombre": "C/ EDUARDO PEÑATE SANTANA, LOCAL 4",
        "numero": "292"
      },
      {
        "nombre": "C/ ZARAGOZA, 26",
        "numero": "293"
      },
      {
        "nombre": "C/ PALMAR, FRENTE 82",
        "numero": "294"
      },
      {
        "nombre": "C/ OBISPO ROMO, FRENTE 27",
        "numero": "295"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 172",
        "numero": "296"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 51",
        "numero": "297"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 186",
        "numero": "298"
      },
      {
        "nombre": "AVDA. ESCALERITAS (CÁRITAS)",
        "numero": "299"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO (IGLESIA DE LOS DOLORES)",
        "numero": "300"
      },
      {
        "nombre": "AVDA. ESCALERITAS (CLUB LA CORNISA)",
        "numero": "301"
      },
      {
        "nombre": "C/ ALCESTE, 27",
        "numero": "302"
      },
      {
        "nombre": "PASEO DE CHIL (ESTADIO INSULAR)",
        "numero": "303"
      },
      {
        "nombre": "C/ ZARAGOZA, 27",
        "numero": "304"
      },
      {
        "nombre": "C/ OBISPO ROMO (MERCADO DE ALTAVISTA)",
        "numero": "306"
      },
      {
        "nombre": "C/ PÁRROCO VILLAR REINA, F/ Nª8",
        "numero": "307"
      },
      {
        "nombre": "C/ OBISPO ROMO (PARQUE HERMANOS MILLARES)",
        "numero": "308"
      },
      {
        "nombre": "PASEO DE CHIL (JARDINES RUBIÓ)",
        "numero": "309"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 48",
        "numero": "310"
      },
      {
        "nombre": "C/ TOMÁS MILLER (PLAYA DE LAS CANTERAS)",
        "numero": "311"
      },
      {
        "nombre": "PASEO DE CHIL (ESTADIO INSULAR)",
        "numero": "312"
      },
      {
        "nombre": "C/ ALFREDO L. JONES, 1",
        "numero": "313"
      },
      {
        "nombre": "C/ OLOF PALME, 40",
        "numero": "314"
      },
      {
        "nombre": "C/ FARMACÉUTICO PEDRO RIVERO (POLÍGONO CRUZ DE PIEDRA)",
        "numero": "315"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 40",
        "numero": "316"
      },
      {
        "nombre": "CARRETERA DE MATA, 42",
        "numero": "317"
      },
      {
        "nombre": "CARRETERA DE MATA (PARQUE DE LAS REHOYAS)",
        "numero": "319"
      },
      {
        "nombre": "CALZADA LATERAL DEL NORTE (DIVINA PASTORA)",
        "numero": "320"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 14",
        "numero": "321"
      },
      {
        "nombre": "CALZADA LATERAL DEL NORTE (C.S. MILLER BAJO)",
        "numero": "322"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 30",
        "numero": "323"
      },
      {
        "nombre": "C/ VIRGEN DE LA PALOMA, FRENTE 19",
        "numero": "324"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC, 43",
        "numero": "325"
      },
      {
        "nombre": "C/ VIRGEN DE LA PALOMA (IGLESIA DE LA PAZ)",
        "numero": "326"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC (PLAZA MARTÍN COBOS)",
        "numero": "327"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO,54",
        "numero": "328"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC (BINGO CINEMA)",
        "numero": "329"
      },
      {
        "nombre": "C/ JUAN SARAZÁ ORTÍZ, FRENTE 7",
        "numero": "330"
      },
      {
        "nombre": "C/ JUAN SARAZÁ ORTÍZ, 14",
        "numero": "331"
      },
      {
        "nombre": "C/ CRUZ DE PIEDRA, 9",
        "numero": "332"
      },
      {
        "nombre": "C/ CRUZ DE PIEDRA, FRENTE  7",
        "numero": "333"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 1",
        "numero": "334"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE  1",
        "numero": "335"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 33",
        "numero": "336"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE 35",
        "numero": "337"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 71",
        "numero": "338"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE 73",
        "numero": "339"
      },
      {
        "nombre": "C/ PINO APOLINARIO, 9",
        "numero": "340"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, FRENTE 92",
        "numero": "341"
      },
      {
        "nombre": "C/ PINO APOLINARIO,  53",
        "numero": "342"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, FRENTE  42",
        "numero": "343"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, FRENTE 238",
        "numero": "344"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, 7",
        "numero": "345"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO (BARRANCO)",
        "numero": "346"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (BAMBÚ)",
        "numero": "347"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO",
        "numero": "348"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 32",
        "numero": "349"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO, 117",
        "numero": "350"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA (REAL DEL CASTILLO)",
        "numero": "351"
      },
      {
        "nombre": "C/ FARMACÉUTICO PEDRO RIVERO, 1",
        "numero": "352"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA, 50",
        "numero": "353"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA, 24",
        "numero": "355"
      },
      {
        "nombre": "C/ FARMACEÚTICO PEDRO RIVERO (JOAQUIN BELÓN)",
        "numero": "356"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (HOSPITAL DR. NEGRÍN)",
        "numero": "357"
      },
      {
        "nombre": "C/ FARMACEÚTICO PEDRO RIVERO, 20",
        "numero": "359"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN, 67",
        "numero": "360"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN, 145",
        "numero": "362"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 120",
        "numero": "363"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN (IGLESIA SAN MARCOS)",
        "numero": "364"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 152",
        "numero": "365"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 114",
        "numero": "366"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 194",
        "numero": "367"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 104",
        "numero": "368"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 204",
        "numero": "369"
      },
      {
        "nombre": "AVDA, ESCALERITAS, 84",
        "numero": "370"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 109",
        "numero": "371"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 70",
        "numero": "372"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 95",
        "numero": "373"
      },
      {
        "nombre": "CARRETERA DEL NORTE (IES CRUZ DE PIEDRA)",
        "numero": "374"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 79",
        "numero": "375"
      },
      {
        "nombre": "CARRETERA DEL NORTE (FRENTE CC LA BALLENA)",
        "numero": "376"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 57",
        "numero": "377"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (SALIDA DE LA PATERNA)",
        "numero": "378"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 40",
        "numero": "379"
      },
      {
        "nombre": "CARRETERA DEL NORTE (CC LA BALLENA)",
        "numero": "380"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 68",
        "numero": "381"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, 383",
        "numero": "382"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (PUENTE AÉREO)",
        "numero": "383"
      },
      {
        "nombre": "C/ HENRY DUNANT, FRENTE 42",
        "numero": "384"
      },
      {
        "nombre": "CARRETERA DEL NORTE (LOS TARAHALES)",
        "numero": "385"
      },
      {
        "nombre": "C/ CRONISTA MARTÍN MORENO,8",
        "numero": "386"
      },
      {
        "nombre": "ACCESO MANUEL DE FALLA",
        "numero": "387"
      },
      {
        "nombre": "C/ PEPE DAMASO, 43",
        "numero": "388"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 118",
        "numero": "389"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 234",
        "numero": "390"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE  11",
        "numero": "391"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 169",
        "numero": "392"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 84",
        "numero": "393"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN PARQUE CENTRAL)",
        "numero": "394"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 72",
        "numero": "395"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 7",
        "numero": "396"
      },
      {
        "nombre": "C/ EMILIO ARRIETA, FRENTE  7",
        "numero": "397"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (C.S. ALCARAVANERAS)",
        "numero": "398"
      },
      {
        "nombre": "CARRETERA DEL NORTE (LOS TARAHALES)",
        "numero": "399"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (MADERA Y CORCHO)",
        "numero": "400"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 178",
        "numero": "401"
      },
      {
        "nombre": "C/ COSTA RICA, FRENTE 33",
        "numero": "402"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 50",
        "numero": "403"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (C.C. LAS RAMBLAS)",
        "numero": "404"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 225",
        "numero": "405"
      },
      {
        "nombre": "C/ CASTILLEJOS, 23",
        "numero": "406"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSÉ SÁNCHEZ PEÑATE (CC LAS ARENAS),NORTE",
        "numero": "407"
      },
      {
        "nombre": "C/ CASTILLEJOS, 71",
        "numero": "408"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (C.S. ALCARAVANERAS)",
        "numero": "409"
      },
      {
        "nombre": "C/ NUMANCIA, 68",
        "numero": "410"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (MADERA Y CORCHO)",
        "numero": "411"
      },
      {
        "nombre": "PLAZA DE SAN LORENZO",
        "numero": "412"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 118",
        "numero": "413"
      },
      {
        "nombre": "C/ MARIA DOLOROSA, 1",
        "numero": "414"
      },
      {
        "nombre": "C/ SIMANCAS, 70",
        "numero": "415"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 282",
        "numero": "416"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 34",
        "numero": "417"
      },
      {
        "nombre": "C/ LORENZO SUÁREZ RIVERO, 9",
        "numero": "418"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 78",
        "numero": "419"
      },
      {
        "nombre": "C/ VEGA DE RÍO PALMA, 48",
        "numero": "420"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 100",
        "numero": "421"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 52",
        "numero": "422"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "423"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 28",
        "numero": "424"
      },
      {
        "nombre": "AVDA. SEMANA DE LA PASION, 29",
        "numero": "425"
      },
      {
        "nombre": "C/ SAN FERMÍN, 20",
        "numero": "426"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "427"
      },
      {
        "nombre": "C/ GALILEA, 34",
        "numero": "428"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "429"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 30",
        "numero": "430"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 2",
        "numero": "431"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 20",
        "numero": "432"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 14",
        "numero": "433"
      },
      {
        "nombre": "C/ JUAN SÁNCHEZ DE LA COBA, 16",
        "numero": "434"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN F/89",
        "numero": "435"
      },
      {
        "nombre": "AUTOVÍA DE GUINIGUADA",
        "numero": "436"
      },
      {
        "nombre": "AVDA. MESA Y LOPEZ, 86",
        "numero": "437"
      },
      {
        "nombre": "C/ SEVERO OCHOA (C.S. EL BATÁN)",
        "numero": "438"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSÉ SÁNCHEZ PEÑATE (CC LAS ARENAS),SUR",
        "numero": "439"
      },
      {
        "nombre": "C/ JOSE LUIS GUERRA DE ARMAS (CRUCE LAS COLORADAS)",
        "numero": "440"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (CLUB NÁUTICO)",
        "numero": "441"
      },
      {
        "nombre": "C/ CRUZ DEL OVEJERO, 28",
        "numero": "442"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "443"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 172",
        "numero": "444"
      },
      {
        "nombre": "AVDA. DE AMURGA (PASEO BLAS CABRERA FELIPE)",
        "numero": "445"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 140",
        "numero": "446"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASABLANCA)",
        "numero": "447"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 68",
        "numero": "448"
      },
      {
        "nombre": "SABINO BERTHELOT (ENLACE LINEAS 9- 12-13)",
        "numero": "449"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE F/Nº 35  (ROTONDA LOMO LOS FRAILES)",
        "numero": "450"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS (ENLACE LINEAS 12-13)",
        "numero": "451"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (URBANIZACIÓN LA GUILLENA)",
        "numero": "452"
      },
      {
        "nombre": "C/ MIMOSA (NARDO)",
        "numero": "454"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 196",
        "numero": "455"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE FRENTE 71",
        "numero": "456"
      },
      {
        "nombre": "C/ JOSE LUIS GUERRA DE ARMAS (ALONSO QUIJANO)",
        "numero": "457"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (LAS PERRERAS)",
        "numero": "458"
      },
      {
        "nombre": "C/ CRUZ DEL OVEJERO, 25",
        "numero": "459"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE, FRENTE 21",
        "numero": "460"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 171",
        "numero": "461"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (URB. IND. LOMO BLANCO)",
        "numero": "462"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 143",
        "numero": "463"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (CRUCE LAS TORRES)",
        "numero": "464"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (URBANIZACIÓN DÍAZ CASANOVAS)",
        "numero": "466"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN, FRENTE 49",
        "numero": "468"
      },
      {
        "nombre": "CARRETERA GENERAL DEL NORTE",
        "numero": "469"
      },
      {
        "nombre": "CARRETERA DE CHILE, FRENTE 91",
        "numero": "470"
      },
      {
        "nombre": "CARRETERA GENERAL DEL NORTE (LA GUILLENA)",
        "numero": "471"
      },
      {
        "nombre": "CARRETERA DE CHILE, 68",
        "numero": "472"
      },
      {
        "nombre": "CARRETERA TAMARACEITE (LAS PERRERAS)",
        "numero": "473"
      },
      {
        "nombre": "CARRETERA DE CHILE (CAMPO DE GOLF)",
        "numero": "474"
      },
      {
        "nombre": "CARRETERA TAMARACEITE, FRENTE 62",
        "numero": "475"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 150",
        "numero": "476"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE  (LAS MAJADILLAS)",
        "numero": "477"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 138",
        "numero": "478"
      },
      {
        "nombre": "CARRETERA TAMARACEITE (DANONE)",
        "numero": "479"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO (TISCAMANITA)",
        "numero": "480"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (CRUCE LAS TORRES)",
        "numero": "481"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 62",
        "numero": "482"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (URBANIZACIÓN DÍAZ CASANOVAS)",
        "numero": "483"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 30",
        "numero": "484"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN, 41",
        "numero": "485"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME (PLAZOLETA FARRAY)",
        "numero": "486"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, 1",
        "numero": "487"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME (FRAY JUNIPERO)",
        "numero": "488"
      },
      {
        "nombre": "CARRETERA DE CHILE, 75",
        "numero": "489"
      },
      {
        "nombre": "C/ JUNCO (AMAPOLA)",
        "numero": "490"
      },
      {
        "nombre": "CARRETERA DE CHILE, 45",
        "numero": "491"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 138",
        "numero": "492"
      },
      {
        "nombre": "CARRETERA DE CHILE (CAMPO DE GOLF)",
        "numero": "493"
      },
      {
        "nombre": "C/ MUNGUÍA, 8",
        "numero": "494"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 185",
        "numero": "495"
      },
      {
        "nombre": "AVDA. RAFAEL CABRERA (SAN TELMO)",
        "numero": "496"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 85",
        "numero": "497"
      },
      {
        "nombre": "C/ JUNCO (HIPERDINO)",
        "numero": "498"
      },
      {
        "nombre": "C/ AREQUIPA (GUAGUAS MUNICIPALES)",
        "numero": "500"
      },
      {
        "nombre": "C/ MADRESELVA, FRENTE 69",
        "numero": "501"
      },
      {
        "nombre": "CARRETERA A LAS TORRES, 21 ESQUINA MADRESELVA",
        "numero": "502"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 94",
        "numero": "504"
      },
      {
        "nombre": "C/ NARDO, 31",
        "numero": "506"
      },
      {
        "nombre": "C/ MADRESELVA F/Nº 82",
        "numero": "508"
      },
      {
        "nombre": "C/ ACONCAGUA, 1",
        "numero": "510"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 42",
        "numero": "511"
      },
      {
        "nombre": "C/ ACONCAGUA (COLEGIO CASABLANCA III)",
        "numero": "512"
      },
      {
        "nombre": "C/ LENTINI (MONOPOL)",
        "numero": "513"
      },
      {
        "nombre": "C/ ACONCAGUA, FRENTE 3",
        "numero": "515"
      },
      {
        "nombre": "C/ ACONCAGUA  (COLEGIO CASABLANCA III)",
        "numero": "517"
      },
      {
        "nombre": "C/ARCHIVERO JOAQUIN BLANCO MONTESDEOCA (PEDRO BARBER)",
        "numero": "518"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO (MIMOSA)",
        "numero": "519"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA , 21",
        "numero": "520"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, 4",
        "numero": "521"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, 27",
        "numero": "522"
      },
      {
        "nombre": "AVDA. RAFAEL CABRERA (TEATRO)",
        "numero": "523"
      },
      {
        "nombre": "C/ PASEO DE SAN ANTONIO, 85",
        "numero": "524"
      },
      {
        "nombre": "C/ ARMINDA, FRENTE 1",
        "numero": "525"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA 28",
        "numero": "527"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUÍN BLANCO MONTESDEOCA (RTDA. NICOLÁS DÍAZ CHICO)",
        "numero": "529"
      },
      {
        "nombre": "C/ ALCALDE DÍAZ SAAVEDRA NAVARRO (PRUDENCIO GUZMÁN)",
        "numero": "530"
      },
      {
        "nombre": "C/ VERACRUZ, 16",
        "numero": "531"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA, FRENTE 18",
        "numero": "532"
      },
      {
        "nombre": "C/ MARIANAO, 60",
        "numero": "533"
      },
      {
        "nombre": "C/ PINO APOLINARIO (IGLESIA LOMO APOLINARIO)",
        "numero": "534"
      },
      {
        "nombre": "C/ MONTERREY, 1",
        "numero": "535"
      },
      {
        "nombre": "C/ BUENOS AIRES, 43",
        "numero": "536"
      },
      {
        "nombre": "C/ ARMINDA (LA FAVORITA)",
        "numero": "540"
      },
      {
        "nombre": "AVDA. DE AMURGA (IGLESIA)",
        "numero": "541"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (CANARIAS 7)",
        "numero": "543"
      },
      {
        "nombre": "C/ MARIANAO, 5",
        "numero": "544"
      },
      {
        "nombre": "PLAZA BARRANCO LA BALLENA",
        "numero": "545"
      },
      {
        "nombre": "C/ MARIANAO, 53",
        "numero": "546"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR, 28",
        "numero": "547"
      },
      {
        "nombre": "C/ MARIANAO, 103",
        "numero": "548"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, FRENTE 74",
        "numero": "549"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, 55",
        "numero": "551"
      },
      {
        "nombre": "C/ PROFESOR LOZANO, 10",
        "numero": "552"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 25",
        "numero": "554"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 2",
        "numero": "555"
      },
      {
        "nombre": "AVDA AMURGA (IGLESIA)",
        "numero": "556"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 18",
        "numero": "557"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR (PLAZA BARRANCO DE LA BALLENA)",
        "numero": "558"
      },
      {
        "nombre": "C/ PINO APOLINARIO, 86",
        "numero": "559"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR, FRENTE 26",
        "numero": "560"
      },
      {
        "nombre": "CARRETERA EL CARDÓN, FRENTE 118",
        "numero": "561"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (NUEVA PATERNA)",
        "numero": "562"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (IES FELO MONZON)",
        "numero": "563"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 52",
        "numero": "564"
      },
      {
        "nombre": "CTRA. LOMO BLANCO, 94",
        "numero": "565"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (COLEGIO LA PATERNA)",
        "numero": "566"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (URBANIZACIÓN EL ZURBARÁN)",
        "numero": "567"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 49",
        "numero": "568"
      },
      {
        "nombre": "C/ VERACRUZ, 36",
        "numero": "569"
      },
      {
        "nombre": "C/ ZARAGOZA ( DON PEDRO INFINITO)",
        "numero": "570"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 20",
        "numero": "572"
      },
      {
        "nombre": "AUTOVÍA GUINIGUADA (TEATRO GUINIGUADA)",
        "numero": "574"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 17",
        "numero": "576"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (URBANIZACIÓN EL ZURBARÁN)",
        "numero": "578"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "579"
      },
      {
        "nombre": "CTRA. LOMO BLANCO, 81",
        "numero": "580"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 12",
        "numero": "581"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, FRENTE 51",
        "numero": "582"
      },
      {
        "nombre": "C/ BETANIA, 69",
        "numero": "583"
      },
      {
        "nombre": "C/ BETANIA, 41",
        "numero": "585"
      },
      {
        "nombre": "C/ BETANIA, 7",
        "numero": "587"
      },
      {
        "nombre": "C/ SAN BORONDÓN, 10",
        "numero": "589"
      },
      {
        "nombre": "AVDA. DE LA FERIA (URBANIZACIÓN LOS GERANIOS)",
        "numero": "595"
      },
      {
        "nombre": "C/ HEBRÓN, 2",
        "numero": "596"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA, FRENTE 3",
        "numero": "597"
      },
      {
        "nombre": "C/ HEBRÓN, 24",
        "numero": "598"
      },
      {
        "nombre": "C/ GALILEA, FRENTE 6",
        "numero": "599"
      },
      {
        "nombre": "C/ VENTURA DORESTE,  7",
        "numero": "600"
      },
      {
        "nombre": "C/ SAN ANDRÉS, FRENTE 6",
        "numero": "601"
      },
      {
        "nombre": "CARRETERA DE TEROR",
        "numero": "603"
      },
      {
        "nombre": "C/ LAS BORRERAS, 1",
        "numero": "604"
      },
      {
        "nombre": "CIENCIAS BÁSICAS/ INFORMÁTICA",
        "numero": "605"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA, 3",
        "numero": "606"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA (HOSPITAL JUAN CARLOS I)",
        "numero": "607"
      },
      {
        "nombre": "AVDA. DE LA FERIA (URBANIZACIÓN LOS GERANIOS)",
        "numero": "608"
      },
      {
        "nombre": "C/ ALICANTE (C.S. SAN JOSÉ)",
        "numero": "610"
      },
      {
        "nombre": "C/ SAN JOSÉ ARTESANO, 46",
        "numero": "611"
      },
      {
        "nombre": "CIENCIAS BÁSICAS/ TEOLOGÍA",
        "numero": "612"
      },
      {
        "nombre": "CARRETERA LOMO BLANCO, 54",
        "numero": "613"
      },
      {
        "nombre": "C/ NUEVA, 73",
        "numero": "614"
      },
      {
        "nombre": "HOSPITAL JUAN CARLOS I",
        "numero": "615"
      },
      {
        "nombre": "AVDA. DE LA FERIA (INFECAR)",
        "numero": "617"
      },
      {
        "nombre": "C/ GALILEA, 8",
        "numero": "618"
      },
      {
        "nombre": "HOSPITAL JUAN CARLOS I (REHABILITACIÓN)",
        "numero": "619"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 6",
        "numero": "620"
      },
      {
        "nombre": "C/ ACONCAGUA, 38",
        "numero": "621"
      },
      {
        "nombre": "CARRETERA DE TEROR, 16",
        "numero": "622"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 39",
        "numero": "623"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (FRENTE HIPERCOR)",
        "numero": "624"
      },
      {
        "nombre": "CARRETERA DEL CENTRO (ANTIGUA CÁRCEL)",
        "numero": "625"
      },
      {
        "nombre": "C/ CASTILLO, 16",
        "numero": "626"
      },
      {
        "nombre": "C/ LAS BORRERAS, 10",
        "numero": "627"
      },
      {
        "nombre": "C/ LAS BORRERAS, FRENTE 1",
        "numero": "629"
      },
      {
        "nombre": "C/ ACONCAGUA- CRUCE CON ORINOCO",
        "numero": "630"
      },
      {
        "nombre": "C/ SAN FERNANDO, 38",
        "numero": "631"
      },
      {
        "nombre": "AVDA. DE AMURGA (CARRETERA SAN JUAN DE DIOS)",
        "numero": "633"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (JUZGADOS)",
        "numero": "634"
      },
      {
        "nombre": "C/ FONDOS DE SEGURA, FRENTE 17",
        "numero": "635"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 37",
        "numero": "636"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 28",
        "numero": "637"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 29",
        "numero": "638"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (CATAMARCA)",
        "numero": "639"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (REYES CATÓLICOS)",
        "numero": "640"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (ROTONDA AREQUIPA)",
        "numero": "641"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (PARQUE ROMANO)",
        "numero": "642"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 26",
        "numero": "643"
      },
      {
        "nombre": "C/ CÓRDOBA (BOMBEROS VEGUETA)",
        "numero": "644"
      },
      {
        "nombre": "CATAMARCA, FRENTE  2",
        "numero": "646"
      },
      {
        "nombre": "C/ PROFESOR LOZANO, 34",
        "numero": "648"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 39",
        "numero": "650"
      },
      {
        "nombre": "AVDA.DE AMURGA (EL LASSO, BLOQUE 1)",
        "numero": "651"
      },
      {
        "nombre": "C/ GUANTÁNAMO, FRENTE 121",
        "numero": "655"
      },
      {
        "nombre": "AVDA. DE AMURGA (ACCESO A LOS GRANJEROS)",
        "numero": "656"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 108",
        "numero": "657"
      },
      {
        "nombre": "AVDA. DE AMURGA (CARRETERA SAN JUAN DE DIOS)",
        "numero": "658"
      },
      {
        "nombre": "LOMO DEL CAPON POSTERIOR, 6",
        "numero": "659"
      },
      {
        "nombre": "C/ MARIANAO, FRENTE 82",
        "numero": "660"
      },
      {
        "nombre": "C/ GALILEA, 31",
        "numero": "661"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 115",
        "numero": "662"
      },
      {
        "nombre": "C/ ALBAHACA (I.E.S. JOSE SARAMAGO)",
        "numero": "663"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 165",
        "numero": "664"
      },
      {
        "nombre": "C/ JUDAS TADEO (BARRANQUILLO)",
        "numero": "665"
      },
      {
        "nombre": "PARQUE TECNOLÓGICO",
        "numero": "666"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO",
        "numero": "667"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CARVAJAL)",
        "numero": "668"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO (SAN NICOLÁS)",
        "numero": "669"
      },
      {
        "nombre": "C/ ALBAHACA (I.E.S. JOSE SARAMAGO)",
        "numero": "670"
      },
      {
        "nombre": "C/ SIERRA NEVADA, FRENTE  44",
        "numero": "671"
      },
      {
        "nombre": "C/ JUDAS TADEO, 34",
        "numero": "672"
      },
      {
        "nombre": "C/ GUANTÁNAMO (CENTRO P. SALTO DEL NEGRO)",
        "numero": "673"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 215",
        "numero": "674"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 72",
        "numero": "675"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 102B",
        "numero": "676"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 42",
        "numero": "677"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 64",
        "numero": "678"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, 41",
        "numero": "679"
      },
      {
        "nombre": "C/ SAN JUDAS TADEO (BARRANQUILLO)",
        "numero": "680"
      },
      {
        "nombre": "C/ ARQUITECTO JOSE LUIS JIMENEZ, 3",
        "numero": "681"
      },
      {
        "nombre": "BIBLIOTECA UNIVERSITARIA",
        "numero": "682"
      },
      {
        "nombre": "VIAL SIN NOMBRE",
        "numero": "683"
      },
      {
        "nombre": "ALAMEDA DE COLÓN",
        "numero": "684"
      },
      {
        "nombre": "C/ ISLA DE LA MONTAÑA CLARA, FRENTE 5",
        "numero": "685"
      },
      {
        "nombre": "BERNARDINO CORREA VIERA (C.S. TRIANA)",
        "numero": "686"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 73",
        "numero": "687"
      },
      {
        "nombre": "BIBLIOTECA UNIVERSITARIA",
        "numero": "688"
      },
      {
        "nombre": "BERNARDINO CORREA VIERA,  FRENTE 13",
        "numero": "689"
      },
      {
        "nombre": "AULARIO CIENCIAS JURÍDICAS",
        "numero": "690"
      },
      {
        "nombre": "CIENCIAS JURIDICAS (MÓDULO B)",
        "numero": "691"
      },
      {
        "nombre": "C/ TABLERO DE GONZALO, FRENTE  7",
        "numero": "692"
      },
      {
        "nombre": "C/ JUDAS TADEO, 36",
        "numero": "693"
      },
      {
        "nombre": "C/ MIGUEL MARTIN FERNANDEZ DE LA TORRE (CENTRO DE MENORES)",
        "numero": "694"
      },
      {
        "nombre": "C/ MANZANILLA FRENTE 14",
        "numero": "695"
      },
      {
        "nombre": "C/ TUNERILLAS, FRENTE 20",
        "numero": "696"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 17",
        "numero": "698"
      },
      {
        "nombre": "C/ TABLERO DE GONZALO",
        "numero": "699"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 25",
        "numero": "700"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 88",
        "numero": "701"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, FRENTE 51",
        "numero": "907"
      },
      {
        "nombre": "AVDA. DE ANSITE ( FRENTE CEMENTERIO DEL PUERTO)",
        "numero": "702"
      },
      {
        "nombre": "AVDA. DE ANSITE (CEMENTERIO DEL PUERTO)",
        "numero": "703"
      },
      {
        "nombre": "C/ HOYA DE LA GALLINA (ESTADIO GRAN CANARIA)",
        "numero": "704"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (HOSPITALIZACIÓN)",
        "numero": "705"
      },
      {
        "nombre": "ROTONDA HOSPITAL DR. NEGRÍN",
        "numero": "706"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (ROTONDA HOSPITAL DR. NEGRÍN)",
        "numero": "708"
      },
      {
        "nombre": "CARRETERA CIUDAD SAN JUAN DE DIOS (GUINCHO)",
        "numero": "709"
      },
      {
        "nombre": "C/ PARDELA 14",
        "numero": "711"
      },
      {
        "nombre": "C/ MIMOSA",
        "numero": "712"
      },
      {
        "nombre": "CIENCIAS BÁSICAS",
        "numero": "714"
      },
      {
        "nombre": "CARRETERA CIUDAD SAN JUAN DE DIOS (GUINCHO)",
        "numero": "715"
      },
      {
        "nombre": "C/ MIMOSA",
        "numero": "717"
      },
      {
        "nombre": "C/ CAMELIA, FRENTE 11",
        "numero": "719"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 22",
        "numero": "721"
      },
      {
        "nombre": "C/ MARIUCHA (CANÓDROMO)",
        "numero": "722"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 38",
        "numero": "723"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 3",
        "numero": "724"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (C.C. SIETE PALMAS)",
        "numero": "725"
      },
      {
        "nombre": "C/ JUDAS TADEO, 66",
        "numero": "726"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, FRENTE 102",
        "numero": "728"
      },
      {
        "nombre": "INGENIERÍAS",
        "numero": "731"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 12",
        "numero": "733"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 3",
        "numero": "734"
      },
      {
        "nombre": "C/ JUDAS TADEO, 61",
        "numero": "735"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "736"
      },
      {
        "nombre": "C/ SERVENTIA, 145",
        "numero": "738"
      },
      {
        "nombre": "C/ PLUTÓN, FRENTE 14",
        "numero": "739"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE (FÁBRICA DE TEJAS)",
        "numero": "740"
      },
      {
        "nombre": "C/ LEOPOLDO ALONSO, 5",
        "numero": "741"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE (GASOLINERA)",
        "numero": "742"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 20",
        "numero": "743"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE",
        "numero": "744"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, FRENTE 47",
        "numero": "745"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 135",
        "numero": "746"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, FRENTE 71",
        "numero": "747"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 169",
        "numero": "748"
      },
      {
        "nombre": "C/ SERVENTÍA, 189",
        "numero": "749"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 259",
        "numero": "750"
      },
      {
        "nombre": "C/ SERVENTÍA, 101",
        "numero": "751"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 400",
        "numero": "752"
      },
      {
        "nombre": "C/ SERVENTIA, 85",
        "numero": "753"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 3",
        "numero": "754"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, FRENTE 32",
        "numero": "756"
      },
      {
        "nombre": "C/ PLUTÓN (CEIP HOYA ANDREA)",
        "numero": "757"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 69",
        "numero": "758"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 230",
        "numero": "759"
      },
      {
        "nombre": "C/ LORENZO SUÁREZ RIVERO, FRENTE 51",
        "numero": "760"
      },
      {
        "nombre": "CARRETERA NUEVA DE SAN LORENZO",
        "numero": "761"
      },
      {
        "nombre": "C/ LORENZO SUAREZ RIVERO, 22",
        "numero": "762"
      },
      {
        "nombre": "CARRETERA NUEVA DE SAN LORENZO (GASOLINERA)",
        "numero": "763"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 282",
        "numero": "764"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 120",
        "numero": "765"
      },
      {
        "nombre": "C/ OLIVO (CARRETERA DE ALMATRICHE)",
        "numero": "766"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 154",
        "numero": "767"
      },
      {
        "nombre": "C/ HABANA, 27",
        "numero": "768"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 188",
        "numero": "769"
      },
      {
        "nombre": "C/ PINTOR JUAN GUILLERMO, FRENTE 19",
        "numero": "770"
      },
      {
        "nombre": "CARRETERA SAN LORENZO 254",
        "numero": "771"
      },
      {
        "nombre": "C/ PINTOR JUAN GUILLERMO (C.C. LA MINILLA)",
        "numero": "772"
      },
      {
        "nombre": "C/ LEOPOLDO ALONSO",
        "numero": "773"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 13",
        "numero": "774"
      },
      {
        "nombre": "C/ EL OLIVO (CARRETERA DE ALMATRICHE)",
        "numero": "775"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 61",
        "numero": "776"
      },
      {
        "nombre": "C/ HABANA, 28",
        "numero": "777"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 9",
        "numero": "778"
      },
      {
        "nombre": "AVDA. GARCIA LORCA, FRENTE 14",
        "numero": "779"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 41",
        "numero": "780"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, FRENTE 11",
        "numero": "781"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 70",
        "numero": "783"
      },
      {
        "nombre": "CARRETERA SUBIDA A TAFIRA (LA FAVORITA)",
        "numero": "786"
      },
      {
        "nombre": "CTRA. PICO VIENTO (ASILO DE ANCIANOS)",
        "numero": "787"
      },
      {
        "nombre": "CTRA. PICO VIENTO (ASILO DE ANCIANOS)",
        "numero": "788"
      },
      {
        "nombre": "AVDA. GARCIA LORCA, 17",
        "numero": "789"
      },
      {
        "nombre": "C/ LÁZARO  DE ORTEGA (CIUDAD DEL CAMPO)",
        "numero": "791"
      },
      {
        "nombre": "C/ LÁZARO DE ORTEGA, 39",
        "numero": "793"
      },
      {
        "nombre": "C/ CUESTA BLANCA, FRENTE 11",
        "numero": "795"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 34",
        "numero": "797"
      },
      {
        "nombre": "PASEO TOMAS MORALES, 4",
        "numero": "799"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "892"
      },
      {
        "nombre": "INTERCAMBIADOR DE TAMARACEITE",
        "numero": "893"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "894"
      },
      {
        "nombre": "LATERAL NORTE - MERCADO VEGUETA",
        "numero": "895"
      },
      {
        "nombre": "C/ SIERRA NEVADA (SAN FRANCISCO)",
        "numero": "897"
      },
      {
        "nombre": "INGENIERÍAS",
        "numero": "898"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "899"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "901"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (IES FELO MONZON)",
        "numero": "902"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, FRENTE 51",
        "numero": "903"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (FRENTE HIPERCOR)",
        "numero": "904"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 72",
        "numero": "905"
      },
      {
        "nombre": "C/ BETANIA, 69",
        "numero": "906"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "928"
      },
      {
        "nombre": "LA BALLENA",
        "numero": "929"
      },
      {
        "nombre": "TEATRO",
        "numero": "930"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "931"
      },
      {
        "nombre": "TEATRO",
        "numero": "932"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "933"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "934"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "935"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "936"
      },
      {
        "nombre": "TEATRO",
        "numero": "938"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "939"
      },
      {
        "nombre": "GUINIGUADA",
        "numero": "940"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "941"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "942"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ (EL SEBADAL)",
        "numero": "943"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "944"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (HOSPITAL DR. NEGRÍN)",
        "numero": "945"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "946"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "947"
      },
      {
        "nombre": "GUINIGUADA",
        "numero": "948"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 56",
        "numero": "949"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "950"
      },
      {
        "nombre": "RESIDENCIAS (CAMPUS UNIVERSITARIO)",
        "numero": "951"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "955"
      },
      {
        "nombre": "TEATRO",
        "numero": "956"
      },
      {
        "nombre": "AVDA. SEMANA DE LA PASIÓN, 13  (LAS COLORADAS)",
        "numero": "957"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "958"
      },
      {
        "nombre": "C/ JUDAS TADEO (ISLA PERDIDA)",
        "numero": "959"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "960"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "962"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "963"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "965"
      },
      {
        "nombre": "INTERCAMBIADOR DE TAMARACEITE",
        "numero": "966"
      },
      {
        "nombre": "CAMPUS UNIVERSITARIO (INGENIERÍAS)",
        "numero": "968"
      },
      {
        "nombre": "C/ LEONARDO TORRIANI (ZÁRATE)",
        "numero": "970"
      },
      {
        "nombre": "AVDA DEL PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "971"
      },
      {
        "nombre": "C/ GAVILAN (RESIDENCIAL LOS GRANJEROS)",
        "numero": "972"
      },
      {
        "nombre": "C/ OTOÑO (HOYA ANDREA)",
        "numero": "973"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "974"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN",
        "numero": "975"
      },
      {
        "nombre": "TEATRO",
        "numero": "976"
      },
      {
        "nombre": "C/ CRONISTA NAVARRO RUIZ ,6",
        "numero": "977"
      },
      {
        "nombre": "CIUDAD DE SAN JUAN DE DIOS",
        "numero": "978"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "979"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO (SAN FRANCISCO DE PAULA)",
        "numero": "980"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "981"
      },
      {
        "nombre": "TEATRO",
        "numero": "982"
      },
      {
        "nombre": "CAMPUS UNIVERSITARIO (INGENIERÍAS)       (ES LA MISMA QUE LA P898)",
        "numero": "983"
      },
      {
        "nombre": "TEATRO",
        "numero": "984"
      },
      {
        "nombre": "C/ ARMINDA, 28 (EL SECADERO)",
        "numero": "985"
      },
      {
        "nombre": "TEATRO",
        "numero": "986"
      },
      {
        "nombre": "C/ LOMO DE LA CRUZ",
        "numero": "987"
      },
      {
        "nombre": "TEATRO",
        "numero": "988"
      },
      {
        "nombre": "C/ SIERRA NEVADA (SAN FRANCISCO)",
        "numero": "989"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "990"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "991"
      },
      {
        "nombre": "TEATRO",
        "numero": "992"
      },
      {
        "nombre": "MERCADO DE  VEGUETA",
        "numero": "993"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "994"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "995"
      },
      {
        "nombre": "EDUARDO BENOT (frente los bardinos)",
        "numero": "996"
      },
      {
        "nombre": "TEATRO",
        "numero": "998"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "999"
      },
      {
        "nombre": "GLORIA",
        "numero": "465"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "892"
      },
      {
        "nombre": "AVDA. MARITIMA DEL SUR",
        "numero": "516"
      },
      {
        "nombre": "Aparcamiento Inter-Modal El Rincón",
        "numero": "509"
      },
      {
        "nombre": "Carretera de Mata (Castillo de Mata)",
        "numero": "318"
      },
      {
        "nombre": "JUAN M DURAN GALICIA",
        "numero": "782"
      },
      {
        "nombre": "MIGUEL CURBELO AUTORIDAD PORTUARIA",
        "numero": "573"
      },
      {
        "nombre": "ROTONDA CAPITAN N.MASTRO",
        "numero": "575"
      },
      {
        "nombre": "MUELLE LEON Y CASTILLO GASOLINERA BP",
        "numero": "577"
      },
      {
        "nombre": "Av de las Petroliferas Depositos Comerciales",
        "numero": "579"
      },
      {
        "nombre": "MIGUEL CURBELO AUTORIDAD PORTUARIA",
        "numero": "586"
      },
      {
        "nombre": "MUELLE LEON Y CASTILLO GASOLINERA BP",
        "numero": "588"
      },
      {
        "nombre": "Av de las Petroliferas Depositos Comerciales",
        "numero": "590"
      },
      {
        "nombre": "Av de las Petroliferas Astican",
        "numero": "591"
      },
      {
        "nombre": "Av de las Petroliferas Astican",
        "numero": "592"
      },
      {
        "nombre": "Av de las Petroliferas Repnaval",
        "numero": "593"
      },
      {
        "nombre": "Av de las Petroliferas Repnaval",
        "numero": "594"
      },
      {
        "nombre": "REINA SOFIA",
        "numero": "937"
      },
      {
        "nombre": "M BECERRA L20",
        "numero": "953"
      },
      {
        "nombre": "San Cristobal Acceso Av Maritima",
        "numero": "526"
      },
      {
        "nombre": "San Cristobal Estribor",
        "numero": "514"
      },
      {
        "nombre": "C/ FARMACEUTICO PEDRO RIVERO, FRENTE 15",
        "numero": "361"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (OFICINAS MUNICIPALES)",
        "numero": "18"
      },
      {
        "nombre": "Carretera Centro Barrio Quilmes 3",
        "numero": "790"
      },
      {
        "nombre": "Hermanos Dominguez Santana - CC ALISIOS",
        "numero": "755"
      },
      {
        "nombre": "Hermanos Dominguez Santana (CC ALISIOS)",
        "numero": "727"
      },
      {
        "nombre": "C/ RAFAEL MESA Y LOPEZ (CEIP TIMPLISTA JOSE ANTONIO RAMOS)",
        "numero": "467"
      },
      {
        "nombre": "C/ RAFAEL MESA Y LOPEZ (EL AUDAZ)",
        "numero": "499"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSE SANCHEZ PENATE (CC LAS ARENAS)",
        "numero": "961"
      },
      {
        "nombre": "GALILEA 60",
        "numero": "730"
      },
      {
        "nombre": "C/ GAVILAN (RESIDENCIAL LOS GRANJEROS)",
        "numero": "713"
      },
      {
        "nombre": "C/ IGNACIO PEREZ GALDOS CON CALZADA LATERAL DEL NORTE",
        "numero": "507"
      },
      {
        "nombre": "C/ OBISPO MARQUINA (CEIP SANTIAGO RAMON Y CAJAL)",
        "numero": "453"
      },
      {
        "nombre": "AVDA. 8 DE MARZO DIA INTERNACIONAL DE LA MUJER",
        "numero": "729"
      },
      {
        "nombre": "AVDA. 8 DE MARZO DIA INTERNACIONAL DE LA MUJER",
        "numero": "732"
      },
      {
        "nombre": "REINA SOFIA",
        "numero": "628"
      },
      {
        "nombre": "AV. DE LAS PETROLIFERAS (REINA SOFIA)",
        "numero": "602"
      },
      {
        "nombre": "NELSON MANDELA (ACCESO)",
        "numero": "609"
      },
      {
        "nombre": "NELSON MANDELA (SALIDA)",
        "numero": "616"
      },
      {
        "nombre": "HERMANOS DOMINGUEZ SANTANA (DECATHLON)",
        "numero": "737"
      },
      {
        "nombre": "NELSON MANDELA (ARMAS)",
        "numero": "964"
      },
      {
        "nombre": "PROVISIONAL FRANCISCO GOURIE",
        "numero": "926"
      },
      {
        "nombre": "MESA Y LOPEZ (BASE NAVAL)",
        "numero": "798"
      },
      {
        "nombre": "PICO VIENTO",
        "numero": "794"
      },
      {
        "nombre": "Ciudad Deportiva Gran Canaria",
        "numero": "792"
      },
      {
        "nombre": "Hoya de la Plata",
        "numero": "796"
      },
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
        "nombre": "AVDA. RAFAEL CABRERA (SAN TELMO)",
        "numero": "3"
      },
      {
        "nombre": "C/ TRIANA",
        "numero": "4"
      },
      {
        "nombre": "C/ VENEGAS (USOS MÚLTIPLES)",
        "numero": "5"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 13",
        "numero": "6"
      },
      {
        "nombre": "C/ VENEGAS (FUENTE LUMINOSA)",
        "numero": "7"
      },
      {
        "nombre": "C/ LEON Y CASTILLO (PLAZA DE LA FERIA)",
        "numero": "8"
      },
      {
        "nombre": "C/ LUIS DORESTE SILVA, 22",
        "numero": "9"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 145",
        "numero": "10"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "11"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 185",
        "numero": "12"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (C.N. METROPOLE)",
        "numero": "13"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO, 209",
        "numero": "14"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (OFICINAS MUNICIPALES)",
        "numero": "15"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (COLEGIO SALESIANO)",
        "numero": "16"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (TORRE LAS PALMAS)",
        "numero": "17"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "20"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (EDIFICIO JOSÉ ANTONIO)",
        "numero": "22"
      },
      {
        "nombre": "PL. SAN JUAN BAUTISTA (BASE NAVAL)",
        "numero": "23"
      },
      {
        "nombre": "C/ PRESIDENTE ALVEAR (IGLESIA DEL PINO)",
        "numero": "24"
      },
      {
        "nombre": "C/ EDUARDO BENOT, FRENTE 5",
        "numero": "25"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "26"
      },
      {
        "nombre": "C/ EDUARDO BENOT, FRENTE 23",
        "numero": "27"
      },
      {
        "nombre": "C/ ALBAREDA, 43",
        "numero": "28"
      },
      {
        "nombre": "C/ AGUSTÍN MILLARES SALL (EDIFICIO MAPFRE)",
        "numero": "29"
      },
      {
        "nombre": "C/ JUAN REJÓN,25",
        "numero": "30"
      },
      {
        "nombre": "C/ JUAN REJÓN (CASTILLO DE LA LUZ)",
        "numero": "31"
      },
      {
        "nombre": "C/ LA NAVAL",
        "numero": "33"
      },
      {
        "nombre": "C/ JUAN REJÓN, 67",
        "numero": "34"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (JUAN XXIII)",
        "numero": "35"
      },
      {
        "nombre": "AVDA. DE CANARIAS (SAN TELMO)",
        "numero": "36"
      },
      {
        "nombre": "C/ LUIS DORESTE SILVA, 50",
        "numero": "37"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CENTRO INSULAR DE DEPORTES)",
        "numero": "38"
      },
      {
        "nombre": "AVDA. JUAN XXIII (CLINICA DEL PINO)",
        "numero": "39"
      },
      {
        "nombre": "AVDA.  ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CARVAJAL)",
        "numero": "40"
      },
      {
        "nombre": "AVDA. JUAN XXIII (COLEGIO CANTERBURY)",
        "numero": "41"
      },
      {
        "nombre": "DR. WALKSMANN, 10 (PLAZA LA FERIA)",
        "numero": "42"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 80 (BARRANQUILLO DON ZOILO)",
        "numero": "43"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "44"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 154 (BARRANQUILLO DON ZOILO)",
        "numero": "45"
      },
      {
        "nombre": "C/ PÉREZ DEL TORO, 13",
        "numero": "46"
      },
      {
        "nombre": "C/ CARLOS M. BLANDY (PLAZA DE ARUCAS)",
        "numero": "47"
      },
      {
        "nombre": "C/ PÉREZ DEL TORO (PLAZA DR. JUAN BOSCH MILLARES)",
        "numero": "48"
      },
      {
        "nombre": "C/ ALMIRANTE BENÍTEZ INGLOTT, 12",
        "numero": "49"
      },
      {
        "nombre": "C/ PARROCO VILLAR REINA, 61 (BARRANQUILLO DON ZOILO)",
        "numero": "50"
      },
      {
        "nombre": "C/ ALMIRANTE BENÍTEZ INGLOTT (C.S. ESCALERITAS)",
        "numero": "51"
      },
      {
        "nombre": "C/ PARROCO MATIAS ARTILES",
        "numero": "52"
      },
      {
        "nombre": "C/ PINTOR JUAN ISMAEL (IGLESIA REDONDA)",
        "numero": "53"
      },
      {
        "nombre": "C/ ECHEGARAY, 137",
        "numero": "54"
      },
      {
        "nombre": "C/ TEOBALDO POWER, FRENTE 51",
        "numero": "55"
      },
      {
        "nombre": "C/ HENRY DUNANT, FRENTE 10",
        "numero": "56"
      },
      {
        "nombre": "AVDA. ESCALERITAS, FRENTE 111",
        "numero": "57"
      },
      {
        "nombre": "C/ PRESIDENTE ALVEAR, 17",
        "numero": "58"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN SANSOFÉ)",
        "numero": "59"
      },
      {
        "nombre": "C/ DEAN RODRÍGUEZ BOLAÑOS (PL. ALVARADO Y SAZ)",
        "numero": "60"
      },
      {
        "nombre": "AVDA. ESCALERITAS( FRENTE C.C. LA BALLENA)",
        "numero": "61"
      },
      {
        "nombre": "C/ TEOBALDO POWER (IGLESIA REDONDA)",
        "numero": "62"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 1",
        "numero": "63"
      },
      {
        "nombre": "C/ MARIUCHA, 139",
        "numero": "64"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 19",
        "numero": "65"
      },
      {
        "nombre": "C/ MARIUCHA, 171",
        "numero": "66"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO, FRENTE 33",
        "numero": "67"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN SANSOFÉ)",
        "numero": "68"
      },
      {
        "nombre": "AVDA. GUILLERMO SANTANA RIVERO (PACUCO PENICHET)",
        "numero": "69"
      },
      {
        "nombre": "AVDA. ESCALERITAS (C.C. LA BALLENA)",
        "numero": "70"
      },
      {
        "nombre": "AVDA. ALCALDE DÍAZ SAAVEDRA NAVARRO (PL. SANTA ISABEL)",
        "numero": "71"
      },
      {
        "nombre": "AVDA. DE LA FERIA (INFECAR)",
        "numero": "72"
      },
      {
        "nombre": "C/ DR. HERNAN PEREZ DE GRADO, 6",
        "numero": "73"
      },
      {
        "nombre": "C/ DIEGO BETANCOR SUAREZ , 19",
        "numero": "74"
      },
      {
        "nombre": "C/ DR. HERNÁN PEREZ DE GRADO (LA PORTADILLA)",
        "numero": "75"
      },
      {
        "nombre": "C/ DIEGO BETANCOR SUAREZ, 39",
        "numero": "76"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (CARREFOUR)",
        "numero": "77"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (JUZGADOS)",
        "numero": "78"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        "numero": "79"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO, FRENTE 32",
        "numero": "80"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 170",
        "numero": "81"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        "numero": "82"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 214",
        "numero": "83"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 154",
        "numero": "84"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 264",
        "numero": "85"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 208",
        "numero": "86"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, 290",
        "numero": "87"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 266",
        "numero": "88"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (IGLESIA SANTA CLARA)",
        "numero": "89"
      },
      {
        "nombre": "PASEO DE SAN JOSÉ, FRENTE 298",
        "numero": "90"
      },
      {
        "nombre": "C/ MARIANAO, 12",
        "numero": "91"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, FRENTE 306",
        "numero": "92"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (PARKING HOSPITAL MATERNO INSULAR)",
        "numero": "93"
      },
      {
        "nombre": "Primero de Mayo ,6",
        "numero": "21"
      },
      {
        "nombre": "Primero de Mayo (ONCE)",
        "numero": "19"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (IGLESIA SANTA CLARA)",
        "numero": "94"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (MARTÍN FREIRE)",
        "numero": "95"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (PARKING HOSPITAL MATERNO INSULAR)",
        "numero": "96"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, 14",
        "numero": "97"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (MARTÍN FREIRE)",
        "numero": "98"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 8",
        "numero": "99"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE, FRENTE 16",
        "numero": "100"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 30",
        "numero": "101"
      },
      {
        "nombre": "C/ BLAS CABRERA FELIPE (CARREFOUR)",
        "numero": "102"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 46",
        "numero": "103"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, FRENTE 8",
        "numero": "104"
      },
      {
        "nombre": "C/ MIGUEL MARTÍN FERNÁNDEZ DE LA TORRE , 7",
        "numero": "105"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 15",
        "numero": "106"
      },
      {
        "nombre": "C/ CÓRDOBA, 40",
        "numero": "107"
      },
      {
        "nombre": "C/ PÁRROCO JOSÉ C. QUINTANA, 41",
        "numero": "108"
      },
      {
        "nombre": "C/ CÓRDOBA, FRENTE 31",
        "numero": "109"
      },
      {
        "nombre": "C/ CÓRDOBA (BOMBEROS VEGUETA)",
        "numero": "110"
      },
      {
        "nombre": "C/ AYAGAURES (TANATORIO SAN MIGUEL)",
        "numero": "111"
      },
      {
        "nombre": "C/ CÓRDOBA, FRENTE 49",
        "numero": "113"
      },
      {
        "nombre": "C/ CÓRDOBA, 19",
        "numero": "114"
      },
      {
        "nombre": "C/ CÓRDOBA, 54",
        "numero": "115"
      },
      {
        "nombre": "C/ CÓRDOBA, 29",
        "numero": "116"
      },
      {
        "nombre": "C/ ALICANTE (COLEGIO ISLAS CANARIAS)",
        "numero": "117"
      },
      {
        "nombre": "C/ CÓRDOBA, 49",
        "numero": "118"
      },
      {
        "nombre": "AVDA. DE AMURGA (C.S. CONO SUR)",
        "numero": "119"
      },
      {
        "nombre": "C/ CÓRDOBA, 71",
        "numero": "120"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 10",
        "numero": "121"
      },
      {
        "nombre": "C/ ALICANTE (COLEGIO ISLAS CANARIAS)",
        "numero": "122"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 20",
        "numero": "123"
      },
      {
        "nombre": "C/ SARGENTO SALOM, 34",
        "numero": "124"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS, FRENTE 16",
        "numero": "125"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 35",
        "numero": "126"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS, FRENTE 2",
        "numero": "127"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 53",
        "numero": "128"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES,  6",
        "numero": "129"
      },
      {
        "nombre": "C/ DEBUSSY, 3",
        "numero": "130"
      },
      {
        "nombre": "C/ JUAN SÁNCHEZ DE LA COBA, 2",
        "numero": "131"
      },
      {
        "nombre": "C/ DEBUSSY, 9",
        "numero": "132"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 6",
        "numero": "133"
      },
      {
        "nombre": "C/ DEBUSSY, FRENTE  6",
        "numero": "134"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 33)",
        "numero": "135"
      },
      {
        "nombre": "C/ ANTON DVORAK, 5",
        "numero": "136"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 1)",
        "numero": "137"
      },
      {
        "nombre": "C/ JUAN SEBASTIAN BACH, FRENTE 4",
        "numero": "138"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 5)",
        "numero": "139"
      },
      {
        "nombre": "C/ BERLIOZ, 5",
        "numero": "140"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 17)",
        "numero": "141"
      },
      {
        "nombre": "C/ SCHUBERT, FRENTE 6",
        "numero": "142"
      },
      {
        "nombre": "C/ SARGENTO SALOM, 44",
        "numero": "143"
      },
      {
        "nombre": "C/ SCHUBERT, 5",
        "numero": "144"
      },
      {
        "nombre": "C/PEDRO HIDALGO (POLIDEPORTIVO)",
        "numero": "145"
      },
      {
        "nombre": "C/ SCHUBERT, 17",
        "numero": "146"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, FRENTE 91",
        "numero": "147"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, 5",
        "numero": "148"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, FRENTE 51",
        "numero": "149"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES, 19",
        "numero": "150"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 96",
        "numero": "151"
      },
      {
        "nombre": "C/ FRANCISCO INGLOTT ARTILES, 33",
        "numero": "152"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA,  FRENTE 133",
        "numero": "153"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 19",
        "numero": "154"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 168",
        "numero": "155"
      },
      {
        "nombre": "AVDA. DE AMURGA (C.S. CONO SUR)",
        "numero": "156"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "157"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TEERRERAS EL LASSO, 33)",
        "numero": "158"
      },
      {
        "nombre": "C/ CANDELARIA DE LÉON, 6",
        "numero": "159"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASAS TERRERAS EL LASSO, 1)",
        "numero": "160"
      },
      {
        "nombre": "C/ FARMACEÚTICO ARENCIBIA CABRERA (COFARCA)",
        "numero": "161"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 4)",
        "numero": "162"
      },
      {
        "nombre": "C/ CONCEJAL ANDRÉS ALVARADO JANINA (LOCAL SOCIAL HOYA DE LA PLATA)",
        "numero": "163"
      },
      {
        "nombre": "AVDA. DE AMURGA (EL LASSO, BLOQUE 17)",
        "numero": "164"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (HOSPITAL MATERNO INSULAR)",
        "numero": "165"
      },
      {
        "nombre": "C/ PEDRO HIDALGO, 97",
        "numero": "166"
      },
      {
        "nombre": "AVDA. MARÍTIMA DEL SUR (ESCUELA DE ARTE)",
        "numero": "167"
      },
      {
        "nombre": "C/ SALAMANCA, 63",
        "numero": "168"
      },
      {
        "nombre": "C/ ARGUINEGUÍN",
        "numero": "169"
      },
      {
        "nombre": "C/ SALAMANCA, 99",
        "numero": "170"
      },
      {
        "nombre": "C/ REYES CATÓLICOS, 9",
        "numero": "171"
      },
      {
        "nombre": "C/ SALAMANCA, 135",
        "numero": "172"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 2",
        "numero": "173"
      },
      {
        "nombre": "AVDA.  JUAN CARLOS I, 9",
        "numero": "174"
      },
      {
        "nombre": "C/ NUEVA, FRENTE  67",
        "numero": "175"
      },
      {
        "nombre": "AVDA JUAN CARLOS I, 23",
        "numero": "176"
      },
      {
        "nombre": "C/ ANDENES, FRENTE 15",
        "numero": "177"
      },
      {
        "nombre": "C/ CANDELARIA DE LEÓN, 7",
        "numero": "178"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN, 10",
        "numero": "179"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 128",
        "numero": "180"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN, 42",
        "numero": "181"
      },
      {
        "nombre": "C/ CONCEJAL ANDRES ALVARADO JANINA (LOCAL SOCIAL HOYA DE LA PLATA)",
        "numero": "182"
      },
      {
        "nombre": "C/ CAMINO AL POLVORÍN (PLAZA DEL SOL NACIENTE)",
        "numero": "183"
      },
      {
        "nombre": "RESIDENCIAL FLOR SIRERA",
        "numero": "184"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN, 16",
        "numero": "185"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 1",
        "numero": "186"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN, 48",
        "numero": "187"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (TRÓPICO)",
        "numero": "188"
      },
      {
        "nombre": "C/ REAL DE SAN ROQUE, FRENTE 11",
        "numero": "189"
      },
      {
        "nombre": "C/ ANDENES, 9",
        "numero": "190"
      },
      {
        "nombre": "C/ FARNESIO, FRENTE 15",
        "numero": "191"
      },
      {
        "nombre": "C/ NÉSTOR ÁLAMO (CAMPO DE LUCHA)",
        "numero": "192"
      },
      {
        "nombre": "C/ FARNESIO, FRENTE 59",
        "numero": "193"
      },
      {
        "nombre": "CARRETERA EL CARDON (ROTONDA)",
        "numero": "194"
      },
      {
        "nombre": "C/ FAMA, FRENTE 85",
        "numero": "195"
      },
      {
        "nombre": "AVDA. JUAN XXIII (CLINICA DEL PINO)",
        "numero": "196"
      },
      {
        "nombre": "C/ ANDENES, FRENTE 39",
        "numero": "197"
      },
      {
        "nombre": "ACCESO ANTIGUA CARCEL",
        "numero": "198"
      },
      {
        "nombre": "C/ NUEVA, FRENTE 25",
        "numero": "199"
      },
      {
        "nombre": "C/ LOS MANZANO",
        "numero": "200"
      },
      {
        "nombre": "C/ BARAHONA, 77",
        "numero": "201"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN",
        "numero": "202"
      },
      {
        "nombre": "C/ BARAHONA, FRENTE 19",
        "numero": "203"
      },
      {
        "nombre": "C/ JUAN DE QUESADA (RECTORADO ULPGC)",
        "numero": "204"
      },
      {
        "nombre": "LA MATULA, FRENTE 25",
        "numero": "205"
      },
      {
        "nombre": "C/ REAL DE SAN ROQUE, 13",
        "numero": "206"
      },
      {
        "nombre": "LA MATULA, FRENTE 61",
        "numero": "207"
      },
      {
        "nombre": "C/ FARNESIO, 13",
        "numero": "208"
      },
      {
        "nombre": "LA MATULA, FRENTE  95",
        "numero": "209"
      },
      {
        "nombre": "C/ FARNESIO, 53",
        "numero": "210"
      },
      {
        "nombre": "PUENTE LA MATULA",
        "numero": "211"
      },
      {
        "nombre": "C/ FAMA, 71",
        "numero": "212"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (HNOS. TOLEDO SUAREZ)",
        "numero": "213"
      },
      {
        "nombre": "C/ ANDENES, 19",
        "numero": "214"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (LOMO VERDEJO)",
        "numero": "215"
      },
      {
        "nombre": "C/ NUEVA, 35",
        "numero": "216"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (FELIPE MARTELL)",
        "numero": "217"
      },
      {
        "nombre": "C/ NUEVA, 77",
        "numero": "218"
      },
      {
        "nombre": "C/ SAN JOSÉ ARTESANO, 24",
        "numero": "219"
      },
      {
        "nombre": "C/ BARAHONA, 19",
        "numero": "220"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 62",
        "numero": "221"
      },
      {
        "nombre": "C/ LA MATULA, 25",
        "numero": "222"
      },
      {
        "nombre": "C/ SEVERO OCHOA",
        "numero": "223"
      },
      {
        "nombre": "C/ LA MATULA, 65",
        "numero": "224"
      },
      {
        "nombre": "C/ SEVERO OCHOA,  12",
        "numero": "225"
      },
      {
        "nombre": "C/ LA MATULA, 97",
        "numero": "226"
      },
      {
        "nombre": "C/ SEVERO OCHOA (GEORGE PIRE)",
        "numero": "227"
      },
      {
        "nombre": "C/ AYAGAURES (TANATORIO SAN MIGUEL)",
        "numero": "228"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS, 5",
        "numero": "229"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (PUENTE LA MATULA)",
        "numero": "230"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS (IGLESIA EL BATÁN)",
        "numero": "231"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (HNOS. TOLEDO SUÁREZ)",
        "numero": "232"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 116",
        "numero": "233"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (EL HORNILLO)",
        "numero": "234"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, FRENTE 121",
        "numero": "235"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (FELIPE MARTEL)",
        "numero": "236"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 166",
        "numero": "237"
      },
      {
        "nombre": "C/ ARGUINEGUÍN, 8",
        "numero": "238"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 220",
        "numero": "239"
      },
      {
        "nombre": "AUTOVIA DE GUINIGUADA (SAN JUAN BOSCO)",
        "numero": "240"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, 276",
        "numero": "241"
      },
      {
        "nombre": "C/ SEVERO OCHOA, FRENTE 10",
        "numero": "242"
      },
      {
        "nombre": "AVDA. PRIMERO DE MAYO (CORREOS)",
        "numero": "243"
      },
      {
        "nombre": "C/ SEVERO OCHOA (ALBERT SCHWITZER)",
        "numero": "244"
      },
      {
        "nombre": "C/ INGENIERO JOSÉ BOSCH Y SINTÉS, 1",
        "numero": "245"
      },
      {
        "nombre": "C/ SEVERO OCHOA (GEORGE BERNARD SHAW)",
        "numero": "246"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "247"
      },
      {
        "nombre": "C/ MIGUEL ANGEL ASTURIAS, FRENTE 5",
        "numero": "248"
      },
      {
        "nombre": "PASEO TOMÁS MORALES, FRENTE 69",
        "numero": "249"
      },
      {
        "nombre": "C/ MIGUEL ÁNGEL ASTURIAS (IGLESIA EL BATAN)",
        "numero": "250"
      },
      {
        "nombre": "PASEO TOMÁS MORALES, 120",
        "numero": "251"
      },
      {
        "nombre": "ROTONDA DE LOMO BLANCO",
        "numero": "252"
      },
      {
        "nombre": "C/ EMILIO LEY (PISCINAS JULIO NAVARRO)",
        "numero": "253"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY, 9",
        "numero": "254"
      },
      {
        "nombre": "C/ PÍO XII (COLEGIO TERESIANO)",
        "numero": "255"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY, FRENTE 132",
        "numero": "256"
      },
      {
        "nombre": "C/ PÍO XII (ESTADIO INSULAR)",
        "numero": "257"
      },
      {
        "nombre": "C/ ERNEST HEMINGWAY (COLEGIO EL BATÁN)",
        "numero": "258"
      },
      {
        "nombre": "C/ GALICIA (MERCADO CENTRAL)",
        "numero": "259"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA (COFARCA)",
        "numero": "260"
      },
      {
        "nombre": "C/ GALICIA, 32",
        "numero": "261"
      },
      {
        "nombre": "AVDA. PRIMERO DE MAYO, 35",
        "numero": "262"
      },
      {
        "nombre": "C/ TOMÁS MILLER, FRENTE 31",
        "numero": "263"
      },
      {
        "nombre": "C/ PASEO TOMÁS MORALES, 5",
        "numero": "264"
      },
      {
        "nombre": "C/ LUJÁN PÉREZ, 20",
        "numero": "265"
      },
      {
        "nombre": "C/ EMILIO LEY (PARQUE DORAMAS)",
        "numero": "266"
      },
      {
        "nombre": "C/ LUJÁN PÉREZ, 66",
        "numero": "267"
      },
      {
        "nombre": "AVDA PRIMERO DE MAYO, 1",
        "numero": "268"
      },
      {
        "nombre": "C/ TINGUARÓ, 18",
        "numero": "269"
      },
      {
        "nombre": "C/ PÍO XII , 27 (COLEGIO TERESIANO)",
        "numero": "270"
      },
      {
        "nombre": "C/ GUMIDAFE, 30",
        "numero": "271"
      },
      {
        "nombre": "C/ PÍO XII (ESTADIO INSULAR)",
        "numero": "272"
      },
      {
        "nombre": "C / OSORIO, 28",
        "numero": "273"
      },
      {
        "nombre": "C/ PÍO XII, 75",
        "numero": "274"
      },
      {
        "nombre": "C/ OSORIO, 58",
        "numero": "275"
      },
      {
        "nombre": "C/ GALICIA, 15 (MERCADO CENTRAL)",
        "numero": "276"
      },
      {
        "nombre": "C/ FELIPE MARTELL (LINDERO)",
        "numero": "277"
      },
      {
        "nombre": "C/ BANDAMA, 25",
        "numero": "278"
      },
      {
        "nombre": "C/ PRIMERO DE MAYO, 56",
        "numero": "279"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 38",
        "numero": "280"
      },
      {
        "nombre": "CARRETERA DE MATA (PL. DEL PINO)",
        "numero": "281"
      },
      {
        "nombre": "C/ ALBAREDA (MERCADO DEL PUERTO)",
        "numero": "282"
      },
      {
        "nombre": "CARRETERA DE MATA, 10-12  (SAN ANTONIO)",
        "numero": "283"
      },
      {
        "nombre": "C/ FARO, 11",
        "numero": "284"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, FRENTE AL Nº83",
        "numero": "285"
      },
      {
        "nombre": "C/ FARO, 43",
        "numero": "286"
      },
      {
        "nombre": "PASEO DE SAN ANTONIO, 56",
        "numero": "287"
      },
      {
        "nombre": "C/ FARO, 99",
        "numero": "288"
      },
      {
        "nombre": "C/ MARIUCHA (PLAZA DON BENITO)",
        "numero": "289"
      },
      {
        "nombre": "C/ CORONEL ROCHA (NUEVA ISLETA)",
        "numero": "290"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 24",
        "numero": "291"
      },
      {
        "nombre": "C/ EDUARDO PEÑATE SANTANA, LOCAL 4",
        "numero": "292"
      },
      {
        "nombre": "C/ ZARAGOZA, 26",
        "numero": "293"
      },
      {
        "nombre": "C/ PALMAR, FRENTE 82",
        "numero": "294"
      },
      {
        "nombre": "C/ OBISPO ROMO, FRENTE 27",
        "numero": "295"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 172",
        "numero": "296"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 51",
        "numero": "297"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 186",
        "numero": "298"
      },
      {
        "nombre": "AVDA. ESCALERITAS (CÁRITAS)",
        "numero": "299"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO (IGLESIA DE LOS DOLORES)",
        "numero": "300"
      },
      {
        "nombre": "AVDA. ESCALERITAS (CLUB LA CORNISA)",
        "numero": "301"
      },
      {
        "nombre": "C/ ALCESTE, 27",
        "numero": "302"
      },
      {
        "nombre": "PASEO DE CHIL (ESTADIO INSULAR)",
        "numero": "303"
      },
      {
        "nombre": "C/ ZARAGOZA, 27",
        "numero": "304"
      },
      {
        "nombre": "C/ OBISPO ROMO (MERCADO DE ALTAVISTA)",
        "numero": "306"
      },
      {
        "nombre": "C/ PÁRROCO VILLAR REINA, F/ Nª8",
        "numero": "307"
      },
      {
        "nombre": "C/ OBISPO ROMO (PARQUE HERMANOS MILLARES)",
        "numero": "308"
      },
      {
        "nombre": "PASEO DE CHIL (JARDINES RUBIÓ)",
        "numero": "309"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 48",
        "numero": "310"
      },
      {
        "nombre": "C/ TOMÁS MILLER (PLAYA DE LAS CANTERAS)",
        "numero": "311"
      },
      {
        "nombre": "PASEO DE CHIL (ESTADIO INSULAR)",
        "numero": "312"
      },
      {
        "nombre": "C/ ALFREDO L. JONES, 1",
        "numero": "313"
      },
      {
        "nombre": "C/ OLOF PALME, 40",
        "numero": "314"
      },
      {
        "nombre": "C/ FARMACÉUTICO PEDRO RIVERO (POLÍGONO CRUZ DE PIEDRA)",
        "numero": "315"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 40",
        "numero": "316"
      },
      {
        "nombre": "CARRETERA DE MATA, 42",
        "numero": "317"
      },
      {
        "nombre": "CARRETERA DE MATA (PARQUE DE LAS REHOYAS)",
        "numero": "319"
      },
      {
        "nombre": "CALZADA LATERAL DEL NORTE (DIVINA PASTORA)",
        "numero": "320"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 14",
        "numero": "321"
      },
      {
        "nombre": "CALZADA LATERAL DEL NORTE (C.S. MILLER BAJO)",
        "numero": "322"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 30",
        "numero": "323"
      },
      {
        "nombre": "C/ VIRGEN DE LA PALOMA, FRENTE 19",
        "numero": "324"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC, 43",
        "numero": "325"
      },
      {
        "nombre": "C/ VIRGEN DE LA PALOMA (IGLESIA DE LA PAZ)",
        "numero": "326"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC (PLAZA MARTÍN COBOS)",
        "numero": "327"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO,54",
        "numero": "328"
      },
      {
        "nombre": "C/ SANTA LUISA DE MARILLAC (BINGO CINEMA)",
        "numero": "329"
      },
      {
        "nombre": "C/ JUAN SARAZÁ ORTÍZ, FRENTE 7",
        "numero": "330"
      },
      {
        "nombre": "C/ JUAN SARAZÁ ORTÍZ, 14",
        "numero": "331"
      },
      {
        "nombre": "C/ CRUZ DE PIEDRA, 9",
        "numero": "332"
      },
      {
        "nombre": "C/ CRUZ DE PIEDRA, FRENTE  7",
        "numero": "333"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 1",
        "numero": "334"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE  1",
        "numero": "335"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 33",
        "numero": "336"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE 35",
        "numero": "337"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, 71",
        "numero": "338"
      },
      {
        "nombre": "C/ CARMEN QUINTANA, FRENTE 73",
        "numero": "339"
      },
      {
        "nombre": "C/ PINO APOLINARIO, 9",
        "numero": "340"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, FRENTE 92",
        "numero": "341"
      },
      {
        "nombre": "C/ PINO APOLINARIO,  53",
        "numero": "342"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, FRENTE  42",
        "numero": "343"
      },
      {
        "nombre": "C/ PÁRROCO SEGUNDO VEGA, FRENTE 238",
        "numero": "344"
      },
      {
        "nombre": "C/ ANA BENÍTEZ, 7",
        "numero": "345"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO (BARRANCO)",
        "numero": "346"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (BAMBÚ)",
        "numero": "347"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO",
        "numero": "348"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 32",
        "numero": "349"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO, 117",
        "numero": "350"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA (REAL DEL CASTILLO)",
        "numero": "351"
      },
      {
        "nombre": "C/ FARMACÉUTICO PEDRO RIVERO, 1",
        "numero": "352"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA, 50",
        "numero": "353"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA, 24",
        "numero": "355"
      },
      {
        "nombre": "C/ FARMACEÚTICO PEDRO RIVERO (JOAQUIN BELÓN)",
        "numero": "356"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (HOSPITAL DR. NEGRÍN)",
        "numero": "357"
      },
      {
        "nombre": "C/ FARMACEÚTICO PEDRO RIVERO, 20",
        "numero": "359"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN, 67",
        "numero": "360"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN, 145",
        "numero": "362"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 120",
        "numero": "363"
      },
      {
        "nombre": "C/ AGUSTINA DE ARAGÓN (IGLESIA SAN MARCOS)",
        "numero": "364"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 152",
        "numero": "365"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 114",
        "numero": "366"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 194",
        "numero": "367"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 104",
        "numero": "368"
      },
      {
        "nombre": "C/ DON PEDRO INFINITO, 204",
        "numero": "369"
      },
      {
        "nombre": "AVDA, ESCALERITAS, 84",
        "numero": "370"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 109",
        "numero": "371"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 70",
        "numero": "372"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 95",
        "numero": "373"
      },
      {
        "nombre": "CARRETERA DEL NORTE (IES CRUZ DE PIEDRA)",
        "numero": "374"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 79",
        "numero": "375"
      },
      {
        "nombre": "CARRETERA DEL NORTE (FRENTE CC LA BALLENA)",
        "numero": "376"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 57",
        "numero": "377"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (SALIDA DE LA PATERNA)",
        "numero": "378"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 40",
        "numero": "379"
      },
      {
        "nombre": "CARRETERA DEL NORTE (CC LA BALLENA)",
        "numero": "380"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 68",
        "numero": "381"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, 383",
        "numero": "382"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (PUENTE AÉREO)",
        "numero": "383"
      },
      {
        "nombre": "C/ HENRY DUNANT, FRENTE 42",
        "numero": "384"
      },
      {
        "nombre": "CARRETERA DEL NORTE (LOS TARAHALES)",
        "numero": "385"
      },
      {
        "nombre": "C/ CRONISTA MARTÍN MORENO,8",
        "numero": "386"
      },
      {
        "nombre": "ACCESO MANUEL DE FALLA",
        "numero": "387"
      },
      {
        "nombre": "C/ PEPE DAMASO, 43",
        "numero": "388"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 118",
        "numero": "389"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 234",
        "numero": "390"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE  11",
        "numero": "391"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 169",
        "numero": "392"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 84",
        "numero": "393"
      },
      {
        "nombre": "CARRETERA DE CHILE, 75",
        "numero": "489"
      },
      {
        "nombre": "AVDA. ESCALERITAS (URBANIZACIÓN PARQUE CENTRAL)",
        "numero": "394"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 72",
        "numero": "395"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 7",
        "numero": "396"
      },
      {
        "nombre": "C/ EMILIO ARRIETA, FRENTE  7",
        "numero": "397"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (C.S. ALCARAVANERAS)",
        "numero": "398"
      },
      {
        "nombre": "CARRETERA DEL NORTE (LOS TARAHALES)",
        "numero": "399"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (MADERA Y CORCHO)",
        "numero": "400"
      },
      {
        "nombre": "AVDA. ESCALERITAS, 178",
        "numero": "401"
      },
      {
        "nombre": "C/ COSTA RICA, FRENTE 33",
        "numero": "402"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I, 50",
        "numero": "403"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (C.C. LAS RAMBLAS)",
        "numero": "404"
      },
      {
        "nombre": "CARRETERA DEL NORTE, 225",
        "numero": "405"
      },
      {
        "nombre": "C/ CASTILLEJOS, 23",
        "numero": "406"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSÉ SÁNCHEZ PEÑATE (CC LAS ARENAS),NORTE",
        "numero": "407"
      },
      {
        "nombre": "C/ CASTILLEJOS, 71",
        "numero": "408"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (C.S. ALCARAVANERAS)",
        "numero": "409"
      },
      {
        "nombre": "C/ NUMANCIA, 68",
        "numero": "410"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ (MADERA Y CORCHO)",
        "numero": "411"
      },
      {
        "nombre": "PLAZA DE SAN LORENZO",
        "numero": "412"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 118",
        "numero": "413"
      },
      {
        "nombre": "C/ MARIA DOLOROSA, 1",
        "numero": "414"
      },
      {
        "nombre": "C/ SIMANCAS, 70",
        "numero": "415"
      },
      {
        "nombre": "CARRETERA DE SAN LORENZO, FRENTE 282",
        "numero": "416"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 34",
        "numero": "417"
      },
      {
        "nombre": "C/ LORENZO SUÁREZ RIVERO, 9",
        "numero": "418"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 78",
        "numero": "419"
      },
      {
        "nombre": "C/ VEGA DE RÍO PALMA, 48",
        "numero": "420"
      },
      {
        "nombre": "C/ PÉREZ MUÑOZ, 100",
        "numero": "421"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 52",
        "numero": "422"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "423"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 28",
        "numero": "424"
      },
      {
        "nombre": "AVDA. SEMANA DE LA PASION, 29",
        "numero": "425"
      },
      {
        "nombre": "C/ SAN FERMÍN, 20",
        "numero": "426"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "427"
      },
      {
        "nombre": "C/ GALILEA, 34",
        "numero": "428"
      },
      {
        "nombre": "PARQUE SANTA CATALINA",
        "numero": "429"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 30",
        "numero": "430"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 2",
        "numero": "431"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 20",
        "numero": "432"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN, 14",
        "numero": "433"
      },
      {
        "nombre": "C/ JUAN SÁNCHEZ DE LA COBA, 16",
        "numero": "434"
      },
      {
        "nombre": "C/ REAL DE SAN JUAN F/89",
        "numero": "435"
      },
      {
        "nombre": "AUTOVÍA DE GUINIGUADA",
        "numero": "436"
      },
      {
        "nombre": "AVDA. MESA Y LOPEZ, 86",
        "numero": "437"
      },
      {
        "nombre": "C/ SEVERO OCHOA (C.S. EL BATÁN)",
        "numero": "438"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSÉ SÁNCHEZ PEÑATE (CC LAS ARENAS),SUR",
        "numero": "439"
      },
      {
        "nombre": "C/ JOSE LUIS GUERRA DE ARMAS (CRUCE LAS COLORADAS)",
        "numero": "440"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (CLUB NÁUTICO)",
        "numero": "441"
      },
      {
        "nombre": "C/ CRUZ DEL OVEJERO, 28",
        "numero": "442"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "443"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 172",
        "numero": "444"
      },
      {
        "nombre": "AVDA. DE AMURGA (PASEO BLAS CABRERA FELIPE)",
        "numero": "445"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 140",
        "numero": "446"
      },
      {
        "nombre": "AVDA. DE AMURGA (CASABLANCA)",
        "numero": "447"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 68",
        "numero": "448"
      },
      {
        "nombre": "SABINO BERTHELOT (ENLACE LINEAS 9- 12-13)",
        "numero": "449"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE F/Nº 35  (ROTONDA LOMO LOS FRAILES)",
        "numero": "450"
      },
      {
        "nombre": "C/ DOCTOR SVENTENIUS (ENLACE LINEAS 12-13)",
        "numero": "451"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (URBANIZACIÓN LA GUILLENA)",
        "numero": "452"
      },
      {
        "nombre": "C/ MIMOSA (NARDO)",
        "numero": "454"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, 196",
        "numero": "455"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE FRENTE 71",
        "numero": "456"
      },
      {
        "nombre": "C/ JOSE LUIS GUERRA DE ARMAS (ALONSO QUIJANO)",
        "numero": "457"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (LAS PERRERAS)",
        "numero": "458"
      },
      {
        "nombre": "C/ CRUZ DEL OVEJERO, 25",
        "numero": "459"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE, FRENTE 21",
        "numero": "460"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 171",
        "numero": "461"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE (URB. IND. LOMO BLANCO)",
        "numero": "462"
      },
      {
        "nombre": "CARRETERA GENERAL DE TAMARACEITE, 143",
        "numero": "463"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (CRUCE LAS TORRES)",
        "numero": "464"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (URBANIZACIÓN DÍAZ CASANOVAS)",
        "numero": "466"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN, FRENTE 49",
        "numero": "468"
      },
      {
        "nombre": "CARRETERA GENERAL DEL NORTE",
        "numero": "469"
      },
      {
        "nombre": "CARRETERA DE CHILE, FRENTE 91",
        "numero": "470"
      },
      {
        "nombre": "CARRETERA GENERAL DEL NORTE (LA GUILLENA)",
        "numero": "471"
      },
      {
        "nombre": "CARRETERA DE CHILE, 68",
        "numero": "472"
      },
      {
        "nombre": "CARRETERA TAMARACEITE (LAS PERRERAS)",
        "numero": "473"
      },
      {
        "nombre": "CARRETERA DE CHILE (CAMPO DE GOLF)",
        "numero": "474"
      },
      {
        "nombre": "CARRETERA TAMARACEITE, FRENTE 62",
        "numero": "475"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 150",
        "numero": "476"
      },
      {
        "nombre": "CARRETERA DE TAMARACEITE  (LAS MAJADILLAS)",
        "numero": "477"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 138",
        "numero": "478"
      },
      {
        "nombre": "CARRETERA TAMARACEITE (DANONE)",
        "numero": "479"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO (TISCAMANITA)",
        "numero": "480"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (CRUCE LAS TORRES)",
        "numero": "481"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 62",
        "numero": "482"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN (URBANIZACIÓN DÍAZ CASANOVAS)",
        "numero": "483"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 30",
        "numero": "484"
      },
      {
        "nombre": "CARRETERA DEL CARDÓN, 41",
        "numero": "485"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME (PLAZOLETA FARRAY)",
        "numero": "486"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, 1",
        "numero": "487"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME (FRAY JUNIPERO)",
        "numero": "488"
      },
      {
        "nombre": "C/ JUNCO (AMAPOLA)",
        "numero": "490"
      },
      {
        "nombre": "CARRETERA DE CHILE, 45",
        "numero": "491"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 138",
        "numero": "492"
      },
      {
        "nombre": "CARRETERA DE CHILE (CAMPO DE GOLF)",
        "numero": "493"
      },
      {
        "nombre": "C/ MUNGUÍA, 8",
        "numero": "494"
      },
      {
        "nombre": "C/ FERNANDO GUANARTEME, 185",
        "numero": "495"
      },
      {
        "nombre": "AVDA. RAFAEL CABRERA (SAN TELMO)",
        "numero": "496"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 85",
        "numero": "497"
      },
      {
        "nombre": "C/ JUNCO (HIPERDINO)",
        "numero": "498"
      },
      {
        "nombre": "C/ AREQUIPA (GUAGUAS MUNICIPALES)",
        "numero": "500"
      },
      {
        "nombre": "C/ MADRESELVA, FRENTE 69",
        "numero": "501"
      },
      {
        "nombre": "CARRETERA A LAS TORRES, 21 ESQUINA MADRESELVA",
        "numero": "502"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 94",
        "numero": "504"
      },
      {
        "nombre": "C/ NARDO, 31",
        "numero": "506"
      },
      {
        "nombre": "C/ MADRESELVA F/Nº 82",
        "numero": "508"
      },
      {
        "nombre": "C/ ACONCAGUA, 1",
        "numero": "510"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 42",
        "numero": "511"
      },
      {
        "nombre": "C/ ACONCAGUA (COLEGIO CASABLANCA III)",
        "numero": "512"
      },
      {
        "nombre": "C/ LENTINI (MONOPOL)",
        "numero": "513"
      },
      {
        "nombre": "C/ ACONCAGUA, FRENTE 3",
        "numero": "515"
      },
      {
        "nombre": "C/ ACONCAGUA  (COLEGIO CASABLANCA III)",
        "numero": "517"
      },
      {
        "nombre": "C/ARCHIVERO JOAQUIN BLANCO MONTESDEOCA (PEDRO BARBER)",
        "numero": "518"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO (MIMOSA)",
        "numero": "519"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA , 21",
        "numero": "520"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, 4",
        "numero": "521"
      },
      {
        "nombre": "C/ PASEO SAN ANTONIO, 27",
        "numero": "522"
      },
      {
        "nombre": "AVDA. RAFAEL CABRERA (TEATRO)",
        "numero": "523"
      },
      {
        "nombre": "C/ PASEO DE SAN ANTONIO, 85",
        "numero": "524"
      },
      {
        "nombre": "C/ ARMINDA, FRENTE 1",
        "numero": "525"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA 28",
        "numero": "527"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUÍN BLANCO MONTESDEOCA (RTDA. NICOLÁS DÍAZ CHICO)",
        "numero": "529"
      },
      {
        "nombre": "C/ ALCALDE DÍAZ SAAVEDRA NAVARRO (PRUDENCIO GUZMÁN)",
        "numero": "530"
      },
      {
        "nombre": "C/ VERACRUZ, 16",
        "numero": "531"
      },
      {
        "nombre": "C/ FARMACÉUTICO ARENCIBIA CABRERA, FRENTE 18",
        "numero": "532"
      },
      {
        "nombre": "C/ MARIANAO, 60",
        "numero": "533"
      },
      {
        "nombre": "C/ PINO APOLINARIO (IGLESIA LOMO APOLINARIO)",
        "numero": "534"
      },
      {
        "nombre": "C/ MONTERREY, 1",
        "numero": "535"
      },
      {
        "nombre": "C/ BUENOS AIRES, 43",
        "numero": "536"
      },
      {
        "nombre": "C/ ARMINDA (LA FAVORITA)",
        "numero": "540"
      },
      {
        "nombre": "AVDA. DE AMURGA (IGLESIA)",
        "numero": "541"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (CANARIAS 7)",
        "numero": "543"
      },
      {
        "nombre": "C/ MARIANAO, 5",
        "numero": "544"
      },
      {
        "nombre": "PLAZA BARRANCO LA BALLENA",
        "numero": "545"
      },
      {
        "nombre": "C/ MARIANAO, 53",
        "numero": "546"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR, 28",
        "numero": "547"
      },
      {
        "nombre": "C/ MARIANAO, 103",
        "numero": "548"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, FRENTE 74",
        "numero": "549"
      },
      {
        "nombre": "C/ CAMINO VIEJO EL CARDÓN, 55",
        "numero": "551"
      },
      {
        "nombre": "C/ PROFESOR LOZANO, 10",
        "numero": "552"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 25",
        "numero": "554"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 2",
        "numero": "555"
      },
      {
        "nombre": "AVDA AMURGA (IGLESIA)",
        "numero": "556"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 18",
        "numero": "557"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR (PLAZA BARRANCO DE LA BALLENA)",
        "numero": "558"
      },
      {
        "nombre": "C/ PINO APOLINARIO, 86",
        "numero": "559"
      },
      {
        "nombre": "C/ VIRGEN DEL PILAR, FRENTE 26",
        "numero": "560"
      },
      {
        "nombre": "CARRETERA EL CARDÓN, FRENTE 118",
        "numero": "561"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (NUEVA PATERNA)",
        "numero": "562"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (IES FELO MONZON)",
        "numero": "563"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 52",
        "numero": "564"
      },
      {
        "nombre": "CTRA. LOMO BLANCO, 94",
        "numero": "565"
      },
      {
        "nombre": "C/ MANUEL DE FALLA (COLEGIO LA PATERNA)",
        "numero": "566"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (URBANIZACIÓN EL ZURBARÁN)",
        "numero": "567"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ, 49",
        "numero": "568"
      },
      {
        "nombre": "C/ VERACRUZ, 36",
        "numero": "569"
      },
      {
        "nombre": "C/ ZARAGOZA ( DON PEDRO INFINITO)",
        "numero": "570"
      },
      {
        "nombre": "C/ JUAN MANUEL DURÁN GONZÁLEZ, 20",
        "numero": "572"
      },
      {
        "nombre": "AUTOVÍA GUINIGUADA (TEATRO GUINIGUADA)",
        "numero": "574"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 17",
        "numero": "576"
      },
      {
        "nombre": "CTRA. LOMO BLANCO (URBANIZACIÓN EL ZURBARÁN)",
        "numero": "578"
      },
      {
        "nombre": "PLAZA DE LA CONSTITUCIÓN (OBELISCO)",
        "numero": "579"
      },
      {
        "nombre": "CTRA. LOMO BLANCO, 81",
        "numero": "580"
      },
      {
        "nombre": "C/ PEPE DÁMASO, 12",
        "numero": "581"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, FRENTE 51",
        "numero": "582"
      },
      {
        "nombre": "C/ BETANIA, 69",
        "numero": "583"
      },
      {
        "nombre": "C/ BETANIA, 41",
        "numero": "585"
      },
      {
        "nombre": "C/ BETANIA, 7",
        "numero": "587"
      },
      {
        "nombre": "C/ SAN BORONDÓN, 10",
        "numero": "589"
      },
      {
        "nombre": "AVDA. DE LA FERIA (URBANIZACIÓN LOS GERANIOS)",
        "numero": "595"
      },
      {
        "nombre": "C/ HEBRÓN, 2",
        "numero": "596"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA, FRENTE 3",
        "numero": "597"
      },
      {
        "nombre": "C/ HEBRÓN, 24",
        "numero": "598"
      },
      {
        "nombre": "C/ GALILEA, FRENTE 6",
        "numero": "599"
      },
      {
        "nombre": "C/ VENTURA DORESTE,  7",
        "numero": "600"
      },
      {
        "nombre": "C/ SAN ANDRÉS, FRENTE 6",
        "numero": "601"
      },
      {
        "nombre": "CARRETERA DE TEROR",
        "numero": "603"
      },
      {
        "nombre": "C/ LAS BORRERAS, 1",
        "numero": "604"
      },
      {
        "nombre": "CIENCIAS BÁSICAS/ INFORMÁTICA",
        "numero": "605"
      },
      {
        "nombre": "C/ ARCHIVERO JOAQUIN BLANCO MONTESDEOCA, 3",
        "numero": "606"
      },
      {
        "nombre": "C/ GOBERNADOR MARÍN ACUÑA (HOSPITAL JUAN CARLOS I)",
        "numero": "607"
      },
      {
        "nombre": "AVDA. DE LA FERIA (URBANIZACIÓN LOS GERANIOS)",
        "numero": "608"
      },
      {
        "nombre": "C/ ALICANTE (C.S. SAN JOSÉ)",
        "numero": "610"
      },
      {
        "nombre": "C/ SAN JOSÉ ARTESANO, 46",
        "numero": "611"
      },
      {
        "nombre": "CIENCIAS BÁSICAS/ TEOLOGÍA",
        "numero": "612"
      },
      {
        "nombre": "CARRETERA LOMO BLANCO, 54",
        "numero": "613"
      },
      {
        "nombre": "C/ NUEVA, 73",
        "numero": "614"
      },
      {
        "nombre": "HOSPITAL JUAN CARLOS I",
        "numero": "615"
      },
      {
        "nombre": "AVDA. DE LA FERIA (INFECAR)",
        "numero": "617"
      },
      {
        "nombre": "C/ GALILEA, 8",
        "numero": "618"
      },
      {
        "nombre": "HOSPITAL JUAN CARLOS I (REHABILITACIÓN)",
        "numero": "619"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 6",
        "numero": "620"
      },
      {
        "nombre": "C/ ACONCAGUA, 38",
        "numero": "621"
      },
      {
        "nombre": "CARRETERA DE TEROR, 16",
        "numero": "622"
      },
      {
        "nombre": "C/ SAN ANDRÉS, 39",
        "numero": "623"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (FRENTE HIPERCOR)",
        "numero": "624"
      },
      {
        "nombre": "CARRETERA DEL CENTRO (ANTIGUA CÁRCEL)",
        "numero": "625"
      },
      {
        "nombre": "C/ CASTILLO, 16",
        "numero": "626"
      },
      {
        "nombre": "C/ LAS BORRERAS, 10",
        "numero": "627"
      },
      {
        "nombre": "C/ LAS BORRERAS, FRENTE 1",
        "numero": "629"
      },
      {
        "nombre": "C/ ACONCAGUA- CRUCE CON ORINOCO",
        "numero": "630"
      },
      {
        "nombre": "C/ SAN FERNANDO, 38",
        "numero": "631"
      },
      {
        "nombre": "AVDA. DE AMURGA (CARRETERA SAN JUAN DE DIOS)",
        "numero": "633"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (JUZGADOS)",
        "numero": "634"
      },
      {
        "nombre": "C/ FONDOS DE SEGURA, FRENTE 17",
        "numero": "635"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 37",
        "numero": "636"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 28",
        "numero": "637"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 29",
        "numero": "638"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (CATAMARCA)",
        "numero": "639"
      },
      {
        "nombre": "C/ EUFEMIANO JURADO (REYES CATÓLICOS)",
        "numero": "640"
      },
      {
        "nombre": "C/ PROFESOR LOZANO (ROTONDA AREQUIPA)",
        "numero": "641"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (PARQUE ROMANO)",
        "numero": "642"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 26",
        "numero": "643"
      },
      {
        "nombre": "C/ CÓRDOBA (BOMBEROS VEGUETA)",
        "numero": "644"
      },
      {
        "nombre": "CATAMARCA, FRENTE  2",
        "numero": "646"
      },
      {
        "nombre": "C/ PROFESOR LOZANO, 34",
        "numero": "648"
      },
      {
        "nombre": "C/ SABINO BERTHELOT, 39",
        "numero": "650"
      },
      {
        "nombre": "AVDA.DE AMURGA (EL LASSO, BLOQUE 1)",
        "numero": "651"
      },
      {
        "nombre": "C/ GUANTÁNAMO, FRENTE 121",
        "numero": "655"
      },
      {
        "nombre": "AVDA. DE AMURGA (ACCESO A LOS GRANJEROS)",
        "numero": "656"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 108",
        "numero": "657"
      },
      {
        "nombre": "AVDA. DE AMURGA (CARRETERA SAN JUAN DE DIOS)",
        "numero": "658"
      },
      {
        "nombre": "LOMO DEL CAPON POSTERIOR, 6",
        "numero": "659"
      },
      {
        "nombre": "C/ MARIANAO, FRENTE 82",
        "numero": "660"
      },
      {
        "nombre": "C/ GALILEA, 31",
        "numero": "661"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 115",
        "numero": "662"
      },
      {
        "nombre": "C/ ALBAHACA (I.E.S. JOSE SARAMAGO)",
        "numero": "663"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 165",
        "numero": "664"
      },
      {
        "nombre": "C/ JUDAS TADEO (BARRANQUILLO)",
        "numero": "665"
      },
      {
        "nombre": "PARQUE TECNOLÓGICO",
        "numero": "666"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO",
        "numero": "667"
      },
      {
        "nombre": "AVDA. ALCALDE JOSÉ RAMÍREZ BETHENCOURT (CARVAJAL)",
        "numero": "668"
      },
      {
        "nombre": "C/ REAL DEL CASTILLO (SAN NICOLÁS)",
        "numero": "669"
      },
      {
        "nombre": "C/ ALBAHACA (I.E.S. JOSE SARAMAGO)",
        "numero": "670"
      },
      {
        "nombre": "C/ SIERRA NEVADA, FRENTE  44",
        "numero": "671"
      },
      {
        "nombre": "C/ JUDAS TADEO, 34",
        "numero": "672"
      },
      {
        "nombre": "C/ GUANTÁNAMO (CENTRO P. SALTO DEL NEGRO)",
        "numero": "673"
      },
      {
        "nombre": "C/ GUANTÁNAMO, 215",
        "numero": "674"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 72",
        "numero": "675"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 102B",
        "numero": "676"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 42",
        "numero": "677"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 64",
        "numero": "678"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, 41",
        "numero": "679"
      },
      {
        "nombre": "C/ SAN JUDAS TADEO (BARRANQUILLO)",
        "numero": "680"
      },
      {
        "nombre": "C/ ARQUITECTO JOSE LUIS JIMENEZ, 3",
        "numero": "681"
      },
      {
        "nombre": "BIBLIOTECA UNIVERSITARIA",
        "numero": "682"
      },
      {
        "nombre": "VIAL SIN NOMBRE",
        "numero": "683"
      },
      {
        "nombre": "ALAMEDA DE COLÓN",
        "numero": "684"
      },
      {
        "nombre": "C/ ISLA DE LA MONTAÑA CLARA, FRENTE 5",
        "numero": "685"
      },
      {
        "nombre": "BERNARDINO CORREA VIERA (C.S. TRIANA)",
        "numero": "686"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO, 73",
        "numero": "687"
      },
      {
        "nombre": "BIBLIOTECA UNIVERSITARIA",
        "numero": "688"
      },
      {
        "nombre": "BERNARDINO CORREA VIERA,  FRENTE 13",
        "numero": "689"
      },
      {
        "nombre": "AULARIO CIENCIAS JURÍDICAS",
        "numero": "690"
      },
      {
        "nombre": "CIENCIAS JURIDICAS (MÓDULO B)",
        "numero": "691"
      },
      {
        "nombre": "C/ TABLERO DE GONZALO, FRENTE  7",
        "numero": "692"
      },
      {
        "nombre": "C/ JUDAS TADEO, 36",
        "numero": "693"
      },
      {
        "nombre": "C/ MIGUEL MARTIN FERNANDEZ DE LA TORRE (CENTRO DE MENORES)",
        "numero": "694"
      },
      {
        "nombre": "C/ MANZANILLA FRENTE 14",
        "numero": "695"
      },
      {
        "nombre": "C/ TUNERILLAS, FRENTE 20",
        "numero": "696"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 17",
        "numero": "698"
      },
      {
        "nombre": "C/ TABLERO DE GONZALO",
        "numero": "699"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 25",
        "numero": "700"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 88",
        "numero": "701"
      },
      {
        "nombre": "AVDA. DE ANSITE ( FRENTE CEMENTERIO DEL PUERTO)",
        "numero": "702"
      },
      {
        "nombre": "AVDA. DE ANSITE (CEMENTERIO DEL PUERTO)",
        "numero": "703"
      },
      {
        "nombre": "C/ HOYA DE LA GALLINA (ESTADIO GRAN CANARIA)",
        "numero": "704"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (HOSPITALIZACIÓN)",
        "numero": "705"
      },
      {
        "nombre": "ROTONDA HOSPITAL DR. NEGRÍN",
        "numero": "706"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (ROTONDA HOSPITAL DR. NEGRÍN)",
        "numero": "708"
      },
      {
        "nombre": "CARRETERA CIUDAD SAN JUAN DE DIOS (GUINCHO)",
        "numero": "709"
      },
      {
        "nombre": "C/ PARDELA 14",
        "numero": "711"
      },
      {
        "nombre": "C/ MIMOSA",
        "numero": "712"
      },
      {
        "nombre": "CIENCIAS BÁSICAS",
        "numero": "714"
      },
      {
        "nombre": "CARRETERA CIUDAD SAN JUAN DE DIOS (GUINCHO)",
        "numero": "715"
      },
      {
        "nombre": "C/ MIMOSA",
        "numero": "717"
      },
      {
        "nombre": "C/ CAMELIA, FRENTE 11",
        "numero": "719"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 22",
        "numero": "721"
      },
      {
        "nombre": "C/ MARIUCHA (CANÓDROMO)",
        "numero": "722"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN, 38",
        "numero": "723"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 3",
        "numero": "724"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (C.C. SIETE PALMAS)",
        "numero": "725"
      },
      {
        "nombre": "C/ JUDAS TADEO, 66",
        "numero": "726"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, FRENTE 102",
        "numero": "728"
      },
      {
        "nombre": "INGENIERÍAS",
        "numero": "731"
      },
      {
        "nombre": "C/ CÉSAR MANRIQUE, 12",
        "numero": "733"
      },
      {
        "nombre": "AVDA. MESA Y LÓPEZ, 3",
        "numero": "734"
      },
      {
        "nombre": "C/ JUDAS TADEO, 61",
        "numero": "735"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "736"
      },
      {
        "nombre": "C/ SERVENTIA, 145",
        "numero": "738"
      },
      {
        "nombre": "C/ PLUTÓN, FRENTE 14",
        "numero": "739"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE (FÁBRICA DE TEJAS)",
        "numero": "740"
      },
      {
        "nombre": "C/ LEOPOLDO ALONSO, 5",
        "numero": "741"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE (GASOLINERA)",
        "numero": "742"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 20",
        "numero": "743"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE",
        "numero": "744"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, FRENTE 47",
        "numero": "745"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 135",
        "numero": "746"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, FRENTE 71",
        "numero": "747"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 169",
        "numero": "748"
      },
      {
        "nombre": "C/ SERVENTÍA, 189",
        "numero": "749"
      },
      {
        "nombre": "CARRETERA DE ALMATRICHE, 259",
        "numero": "750"
      },
      {
        "nombre": "C/ SERVENTÍA, 101",
        "numero": "751"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 400",
        "numero": "752"
      },
      {
        "nombre": "C/ SERVENTIA, 85",
        "numero": "753"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 3",
        "numero": "754"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, FRENTE 32",
        "numero": "756"
      },
      {
        "nombre": "C/ PLUTÓN (CEIP HOYA ANDREA)",
        "numero": "757"
      },
      {
        "nombre": "C/ CAMILO MARTINÓN NAVARRO, 69",
        "numero": "758"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 230",
        "numero": "759"
      },
      {
        "nombre": "C/ LORENZO SUÁREZ RIVERO, FRENTE 51",
        "numero": "760"
      },
      {
        "nombre": "CARRETERA NUEVA DE SAN LORENZO",
        "numero": "761"
      },
      {
        "nombre": "C/ LORENZO SUAREZ RIVERO, 22",
        "numero": "762"
      },
      {
        "nombre": "CARRETERA NUEVA DE SAN LORENZO (GASOLINERA)",
        "numero": "763"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 282",
        "numero": "764"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 120",
        "numero": "765"
      },
      {
        "nombre": "C/ OLIVO (CARRETERA DE ALMATRICHE)",
        "numero": "766"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 154",
        "numero": "767"
      },
      {
        "nombre": "C/ HABANA, 27",
        "numero": "768"
      },
      {
        "nombre": "CARRETERA SAN LORENZO, 188",
        "numero": "769"
      },
      {
        "nombre": "C/ PINTOR JUAN GUILLERMO, FRENTE 19",
        "numero": "770"
      },
      {
        "nombre": "CARRETERA SAN LORENZO 254",
        "numero": "771"
      },
      {
        "nombre": "C/ PINTOR JUAN GUILLERMO (C.C. LA MINILLA)",
        "numero": "772"
      },
      {
        "nombre": "C/ LEOPOLDO ALONSO",
        "numero": "773"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 13",
        "numero": "774"
      },
      {
        "nombre": "C/ EL OLIVO (CARRETERA DE ALMATRICHE)",
        "numero": "775"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 61",
        "numero": "776"
      },
      {
        "nombre": "C/ HABANA, 28",
        "numero": "777"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 9",
        "numero": "778"
      },
      {
        "nombre": "AVDA. GARCIA LORCA, FRENTE 14",
        "numero": "779"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 41",
        "numero": "780"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, FRENTE 11",
        "numero": "781"
      },
      {
        "nombre": "C/ DOÑA JUANA MARRERO, 70",
        "numero": "783"
      },
      {
        "nombre": "CARRETERA SUBIDA A TAFIRA (LA FAVORITA)",
        "numero": "786"
      },
      {
        "nombre": "CTRA. PICO VIENTO (ASILO DE ANCIANOS)",
        "numero": "787"
      },
      {
        "nombre": "CTRA. PICO VIENTO (ASILO DE ANCIANOS)",
        "numero": "788"
      },
      {
        "nombre": "AVDA. GARCIA LORCA, 17",
        "numero": "789"
      },
      {
        "nombre": "C/ LÁZARO  DE ORTEGA (CIUDAD DEL CAMPO)",
        "numero": "791"
      },
      {
        "nombre": "C/ LÁZARO DE ORTEGA, 39",
        "numero": "793"
      },
      {
        "nombre": "C/ CUESTA BLANCA, FRENTE 11",
        "numero": "795"
      },
      {
        "nombre": "C/ CUESTA BLANCA, 34",
        "numero": "797"
      },
      {
        "nombre": "PASEO TOMAS MORALES, 4",
        "numero": "799"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "892"
      },
      {
        "nombre": "INTERCAMBIADOR DE TAMARACEITE",
        "numero": "893"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "894"
      },
      {
        "nombre": "LATERAL NORTE - MERCADO VEGUETA",
        "numero": "895"
      },
      {
        "nombre": "C/ SIERRA NEVADA (SAN FRANCISCO)",
        "numero": "897"
      },
      {
        "nombre": "INGENIERÍAS",
        "numero": "898"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "899"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "901"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO (IES FELO MONZON)",
        "numero": "902"
      },
      {
        "nombre": "CARRETERA DE LOMO BLANCO, FRENTE 51",
        "numero": "903"
      },
      {
        "nombre": "AVDA. PINTOR FELO MONZÓN (FRENTE HIPERCOR)",
        "numero": "904"
      },
      {
        "nombre": "C/ ISLA DE LA GRACIOSA, FRENTE 72",
        "numero": "905"
      },
      {
        "nombre": "C/ BETANIA, 69",
        "numero": "906"
      },
      {
        "nombre": "C/ SAN CRISTÓBAL DE LA LAGUNA, FRENTE 51",
        "numero": "907"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "928"
      },
      {
        "nombre": "LA BALLENA",
        "numero": "929"
      },
      {
        "nombre": "TEATRO",
        "numero": "930"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "931"
      },
      {
        "nombre": "TEATRO",
        "numero": "932"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "933"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "934"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "935"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "936"
      },
      {
        "nombre": "TEATRO",
        "numero": "938"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "939"
      },
      {
        "nombre": "GUINIGUADA",
        "numero": "940"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "941"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "942"
      },
      {
        "nombre": "C/ DOCTOR JUAN DOMÍNGUEZ PÉREZ (EL SEBADAL)",
        "numero": "943"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "944"
      },
      {
        "nombre": "AVDA. JUAN CARLOS I (HOSPITAL DR. NEGRÍN)",
        "numero": "945"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "946"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "947"
      },
      {
        "nombre": "GUINIGUADA",
        "numero": "948"
      },
      {
        "nombre": "C/ MANUEL DE FALLA, FRENTE 56",
        "numero": "949"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "950"
      },
      {
        "nombre": "RESIDENCIAS (CAMPUS UNIVERSITARIO)",
        "numero": "951"
      },
      {
        "nombre": "AUDITORIO",
        "numero": "955"
      },
      {
        "nombre": "TEATRO",
        "numero": "956"
      },
      {
        "nombre": "AVDA. SEMANA DE LA PASIÓN, 13  (LAS COLORADAS)",
        "numero": "957"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "958"
      },
      {
        "nombre": "C/ JUDAS TADEO (ISLA PERDIDA)",
        "numero": "959"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "960"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "962"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "963"
      },
      {
        "nombre": "MANUEL BECERRA (PUERTO)",
        "numero": "965"
      },
      {
        "nombre": "INTERCAMBIADOR DE TAMARACEITE",
        "numero": "966"
      },
      {
        "nombre": "CAMPUS UNIVERSITARIO (INGENIERÍAS)",
        "numero": "968"
      },
      {
        "nombre": "C/ LEONARDO TORRIANI (ZÁRATE)",
        "numero": "970"
      },
      {
        "nombre": "AVDA DEL PINTOR FELO MONZÓN (HIPERCOR)",
        "numero": "971"
      },
      {
        "nombre": "C/ GAVILAN (RESIDENCIAL LOS GRANJEROS)",
        "numero": "972"
      },
      {
        "nombre": "C/ OTOÑO (HOYA ANDREA)",
        "numero": "973"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "974"
      },
      {
        "nombre": "C/ BATERÍA DE SAN JUAN",
        "numero": "975"
      },
      {
        "nombre": "TEATRO",
        "numero": "976"
      },
      {
        "nombre": "C/ CRONISTA NAVARRO RUIZ ,6",
        "numero": "977"
      },
      {
        "nombre": "CIUDAD DE SAN JUAN DE DIOS",
        "numero": "978"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "979"
      },
      {
        "nombre": "C/ ARQUITECTO LAUREANO ARROYO (SAN FRANCISCO DE PAULA)",
        "numero": "980"
      },
      {
        "nombre": "HOYA DE LA PLATA",
        "numero": "981"
      },
      {
        "nombre": "TEATRO",
        "numero": "982"
      },
      {
        "nombre": "CAMPUS UNIVERSITARIO (INGENIERÍAS)       (ES LA MISMA QUE LA P898)",
        "numero": "983"
      },
      {
        "nombre": "TEATRO",
        "numero": "984"
      },
      {
        "nombre": "C/ ARMINDA, 28 (EL SECADERO)",
        "numero": "985"
      },
      {
        "nombre": "TEATRO",
        "numero": "986"
      },
      {
        "nombre": "C/ LOMO DE LA CRUZ",
        "numero": "987"
      },
      {
        "nombre": "TEATRO",
        "numero": "988"
      },
      {
        "nombre": "C/ SIERRA NEVADA (SAN FRANCISCO)",
        "numero": "989"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "990"
      },
      {
        "nombre": "HOSPITAL DR. NEGRÍN (CONSULTAS EXTERNAS)",
        "numero": "991"
      },
      {
        "nombre": "TEATRO",
        "numero": "992"
      },
      {
        "nombre": "MERCADO DE  VEGUETA",
        "numero": "993"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "994"
      },
      {
        "nombre": "INTERCAMBIADOR TAMARACEITE",
        "numero": "995"
      },
      {
        "nombre": "EDUARDO BENOT (frente los bardinos)",
        "numero": "996"
      },
      {
        "nombre": "TEATRO",
        "numero": "998"
      },
      {
        "nombre": "INTERCAMBIADOR SANTA CATALINA",
        "numero": "999"
      },
      {
        "nombre": "GLORIA",
        "numero": "465"
      },
      {
        "nombre": "C/ SALAMANCA, 171 (PEDRO HIDALGO)",
        "numero": "892"
      },
      {
        "nombre": "AVDA. MARITIMA DEL SUR",
        "numero": "516"
      },
      {
        "nombre": "Aparcamiento Inter-Modal El Rincón",
        "numero": "509"
      },
      {
        "nombre": "Carretera de Mata (Castillo de Mata)",
        "numero": "318"
      },
      {
        "nombre": "JUAN M DURAN GALICIA",
        "numero": "782"
      },
      {
        "nombre": "MIGUEL CURBELO AUTORIDAD PORTUARIA",
        "numero": "573"
      },
      {
        "nombre": "ROTONDA CAPITAN N.MASTRO",
        "numero": "575"
      },
      {
        "nombre": "MUELLE LEON Y CASTILLO GASOLINERA BP",
        "numero": "577"
      },
      {
        "nombre": "Av de las Petroliferas Depositos Comerciales",
        "numero": "579"
      },
      {
        "nombre": "MIGUEL CURBELO AUTORIDAD PORTUARIA",
        "numero": "586"
      },
      {
        "nombre": "MUELLE LEON Y CASTILLO GASOLINERA BP",
        "numero": "588"
      },
      {
        "nombre": "Av de las Petroliferas Depositos Comerciales",
        "numero": "590"
      },
      {
        "nombre": "Av de las Petroliferas Astican",
        "numero": "591"
      },
      {
        "nombre": "Av de las Petroliferas Astican",
        "numero": "592"
      },
      {
        "nombre": "Av de las Petroliferas Repnaval",
        "numero": "593"
      },
      {
        "nombre": "Av de las Petroliferas Repnaval",
        "numero": "594"
      },
      {
        "nombre": "REINA SOFIA",
        "numero": "937"
      },
      {
        "nombre": "M BECERRA L20",
        "numero": "953"
      },
      {
        "nombre": "San Cristobal Acceso Av Maritima",
        "numero": "526"
      },
      {
        "nombre": "San Cristobal Estribor",
        "numero": "514"
      },
      {
        "nombre": "C/ FARMACEUTICO PEDRO RIVERO, FRENTE 15",
        "numero": "361"
      },
      {
        "nombre": "C/ LEÓN Y CASTILLO (OFICINAS MUNICIPALES)",
        "numero": "18"
      },
      {
        "nombre": "Carretera Centro Barrio Quilmes 3",
        "numero": "790"
      },
      {
        "nombre": "Hermanos Dominguez Santana - CC ALISIOS",
        "numero": "755"
      },
      {
        "nombre": "Hermanos Dominguez Santana (CC ALISIOS)",
        "numero": "727"
      },
      {
        "nombre": "C/ RAFAEL MESA Y LOPEZ (CEIP TIMPLISTA JOSE ANTONIO RAMOS)",
        "numero": "467"
      },
      {
        "nombre": "C/ RAFAEL MESA Y LOPEZ (EL AUDAZ)",
        "numero": "499"
      },
      {
        "nombre": "C/ INDUSTRIAL JOSE SANCHEZ PENATE (CC LAS ARENAS)",
        "numero": "961"
      },
      {
        "nombre": "GALILEA 60",
        "numero": "730"
      },
      {
        "nombre": "C/ GAVILAN (RESIDENCIAL LOS GRANJEROS)",
        "numero": "713"
      },
      {
        "nombre": "C/ IGNACIO PEREZ GALDOS CON CALZADA LATERAL DEL NORTE",
        "numero": "507"
      },
      {
        "nombre": "C/ OBISPO MARQUINA (CEIP SANTIAGO RAMON Y CAJAL)",
        "numero": "453"
      },
      {
        "nombre": "AVDA. 8 DE MARZO DIA INTERNACIONAL DE LA MUJER",
        "numero": "729"
      },
      {
        "nombre": "AVDA. 8 DE MARZO DIA INTERNACIONAL DE LA MUJER",
        "numero": "732"
      },
      {
        "nombre": "REINA SOFIA",
        "numero": "628"
      },
      {
        "nombre": "AV. DE LAS PETROLIFERAS (REINA SOFIA)",
        "numero": "602"
      },
      {
        "nombre": "NELSON MANDELA (ACCESO)",
        "numero": "609"
      },
      {
        "nombre": "NELSON MANDELA (SALIDA)",
        "numero": "616"
      },
      {
        "nombre": "HERMANOS DOMINGUEZ SANTANA (DECATHLON)",
        "numero": "737"
      },
      {
        "nombre": "NELSON MANDELA (ARMAS)",
        "numero": "964"
      },
      {
        "nombre": "PROVISIONAL FRANCISCO GOURIE",
        "numero": "926"
      },
      {
        "nombre": "MESA Y LOPEZ (BASE NAVAL)",
        "numero": "798"
      },
      {
        "nombre": "PICO VIENTO",
        "numero": "794"
      },
      {
        "nombre": "Ciudad Deportiva Gran Canaria",
        "numero": "792"
      },
      {
        "nombre": "Hoya de la Plata",
        "numero": "796"
      },
      {
        "nombre": "CONCEPCIÓN ARENAL",
        "numero": "647"
      },
      {
        "nombre": "FRENTE CS SAN JOSE",
        "numero": "645"
      },
      {
        "nombre": "Miller Alto",
        "numero": "785"
      },
      {
        "nombre": "Alejandro Hidalgo",
        "numero": "652"
      },
      {
        "nombre": "Párroco Villar Reina (P de Chil)",
        "numero": "653"
      },
      {
        "nombre": "Emilio Ley",
        "numero": "707"
      },
      {
        "nombre": "San Cristóbal (Iglesia)",
        "numero": "784"
      },
      {
        "nombre": "DR MARAÑÓN",
        "numero": "697"
      },
      {
        "nombre": "Sta. Luisa de Marillac",
        "numero": "710"
      },
      {
        "nombre": "Castillo de la luz",
        "numero": "32"
      },
      {
        "nombre": "Agustin millares sall(Mercado del puerto)",
        "numero": "112"
      },
      {
        "nombre": "Woermann",
        "numero": "542"
      }
    ]
    """.trimIndent()
