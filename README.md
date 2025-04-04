# Weather Mobile App

#### This app is meant to be used with it's Golang backend from which it consumes weather data. [Golang Server Repo Here](https://github.com/Tokelo-s-Evil-corp/golang-weather-api-bff)

- Created with ***Kotlin***
- ***Jetpack Compose*** for UI
- ***Retrofit*** to Make Requests to Golang server
- ***ngrok*** for tunneling
- ***Material 3*** UI library
- ***GIN***

### Description
- This app performs a get request to a server written in Golang for weather data that is consumed from the [Open-Meteo](https://open-meteo.com/) API.
- Makes use of charts to display data to the user.

![Untitled design](https://github.com/user-attachments/assets/adae8852-d6b5-44b8-9295-f6314b0e9f65)

## Golang Server screenshot
![server screenshot](https://github.com/Tokelo-s-Evil-corp/weather-ui-mobile/blob/main/Weather-golang-server.png)

### How to run
- Latest version of ***Android Studio***
- Install [Go](go.dev)
- Install [***ngrok***](https://ngrok.com/)
- Clone and run backend server on terminal with `go run .`command. [Repo here](https://github.com/Tokelo-s-Evil-corp/golang-weather-api-bff)
- Open terminal and run ***ngrok*** against `http://localhost:8001` 
- Clone this repo into desired directory
- Replace `BASE_URL` value in ***"app/src/main/java/com/example/reboot/network/ApiService.kt"*** with ***ngrok*** tunnel url.
- Run Mobile App.
- Enjoy!

