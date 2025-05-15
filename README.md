## Wawas amarillo limon.

### ¿De qué va este repo?
Es una app simple que replica algunas de las funciones de la aplicación original de la compañía de transportes públicos perteneciente a la ciudad de Las Palmas de Gran Canaria. 🇮🇨

### ¿Que es lo que puedo hacer en la app?
- Consultar la información de la parada en la que te encuentras.
- Seleccionar tus paradas favoritas para un acceso más rápido.
- Consultar la información de las líneas de la ciudad.
- Consultar el horario de cualquier línea.
- Consultar el saldo de tu bono de guaguas.

### ¿Donde me puedo descargar el APK más reciente?
https://github.com/AbrahamCardenes/WawaAmarillaLimon/releases 🚀 (recuerda que es el fichero `.apk` el que debes seleccionar 🙂)

### ¿Cuál es el propósito?
Principalmente, aprendizaje y ocio sobre el proceso de creación de una aplicación Android con los estándares más conocidos y usados a día de hoy (02/2025).

### Stack:
- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/compose)
- [Retrofit2](https://square.github.io/retrofit/)
- [RoomDB](https://developer.android.com/training/data-storage/room)
- [Hilt](https://dagger.dev/hilt/)
- [Firebase](https://firebase.google.com/)
- [Ktlint](https://pinterest.github.io/ktlint/latest/)
- Love and coffee, specially coffee :yellow_heart: :coffee:



## 📱 Screenshots

### 🏃🏻‍➡️ 🚏 Paradas
<table>
  <tr>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/b06c60c5-b473-4a54-8cc9-0df74d6a22e2" width="200"/>
    </td>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/a2ca5c62-5303-45d5-ad3f-57145a78fcf1" width="200"/>
    </td>
  </tr>
  <tr>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/6443e1d9-2e31-4370-b8c6-eddfafd36183" width="200"/>
    </td>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/0a50f9c4-13dd-4b2c-b32c-92e535330718" width="200"/>
    </td>
  </tr>
</table>

### 🚍 Líneas

<table>
  <tr>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/b349636f-3e9e-4dc8-877e-982f29505f39" width="200"/>
    </td>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/ffb8207e-a10e-47e2-925b-32f463d259bb" width="200"/>
    </td>
  </tr>
  <tr>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/89183c7f-e1f9-49d9-9418-a064e9efa2fc" width="200"/>
    </td>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/54089a66-3051-4cd7-9c93-a9b33ee92a84" width="200"/>
    </td>
  </tr>
</table>

### 📅 Horarios

<table>
  <tr>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/409b27d2-bc9b-44ae-89cf-8676257398af" width="200"/>
    </td>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/5b5ab516-390f-4759-bba8-6c9120b7e28c" width="200"/>
    </td>
  </tr>
</table>

### 💳 Saldo

<table>
  <tr>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/66050713-8bed-4967-8dc2-0eea8d934f75" width="200"/>
    </td>
    <td align="center">
        <img src="https://github.com/user-attachments/assets/4aa8d9d7-3b35-44f8-bc2c-3345f1936f25" width="200"/>
    </td>
  </tr>
</table>


##### Firebase, encoding and decoding command to put google-services.json inside a Github secret.
- Encoding google-services.json: `base64 -i google-services.json -o google-services.b64`
- Decoding: `base64 -D -i google-services.b64 -o google-services-decode.json`
- Notes:
    - You will need to generate your own `google-services.json` in [Firebase](https://firebase.google.com/)
    - Execute the command inside the `app` directory, or use it with `yourpPath/app/google-services.json`
    - `google-services.json`, `google-services.b64` and `google-services-decode.json` are included in `.gitignore`
