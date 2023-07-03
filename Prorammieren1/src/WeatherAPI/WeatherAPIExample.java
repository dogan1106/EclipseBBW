package WeatherAPI;

/*folgende Bibliotheken sind nötig, um eine Verbindung zur   OpenWeatherMap-API aufzubauen, die API-Antwort lesen und die Wetterdaten zu verarbeiten.*/
import java.net.*;
import java.io.*;
import org.json.*;
public class WeatherAPIExample {

 
public static void main(String[] args) {
  try { 
    // API-URL mit API-Key und New Orleans Koordinaten
  	String city = "New Orleans"; // Name der gewünschten USA Stadt
  	String apiKey = "897a770204371a446cc7c0acd3379d41";// Ihr OpenWeatherMap-API-Schlüssel
  	String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey; // URL mit dem Stadtnamen anstelle der Koordinaten
    
   // String apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=29.9511&lon=-90.0715&appid=" + apiKey;

/*
Verbindung zur API öffnen.
die GET-Methode also die Anfrage, die dein Programm an den Server sendet, um die Wetterdaten für New Orleans zu erhalten.
Wenn dein Programm eine Anfrage an die API sendet, gibt die API eine Antwort zurück. 
Diese Antwort enthält in der Regel Informationen, die dein Programm verarbeiten und anzeigen muss*/
URL url = new URL(apiUrl);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");


/* Antwort von der API werden gelesen. 
Die Antwort wird als String in einem StringBuffer-Objekt gespeichert, bis alle Zeilen gelesen sind.
Ein BufferedReader ist ein Java-Objekt, das verwendet wird, um Text aus einer 
Eingabestromquelle (z.B. einem HTTP-Antwortstream) zu lesen und in ein String gespeichert werden kann
Dann wird der BufferedReader geschlossen. */
BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
response.append(inputLine);
}
in.close();
// JSON-Antwort parsen und Wetterdaten ausgeben
JSONObject jsonObject = new JSONObject(response.toString());
JSONObject mainObject = jsonObject.getJSONObject("main");
double temperature = mainObject.getDouble("temp") - 273.15; // // Temperatur in Kelvin umrechnen
double feelsLike = mainObject.getDouble("feels_like") - 273.15; // gefühlte Temperatur in Kelvin umrechnen
int humidity = mainObject.getInt("humidity");
System.out.printf("Temperature: %.2f C\nFeels like: %.2f C\nHumidity: %d%%\n", temperature, feelsLike, humidity);
} catch (Exception e) {
// Fehlerbehandlung
System.out.println("Error: " + e.getMessage());
}}}

