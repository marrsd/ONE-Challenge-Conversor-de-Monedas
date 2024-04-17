package com.aluracursos.conversorMonedas.conversionRate;

import com.aluracursos.conversorMonedas.conversionRate.ConversionRateResponse;
import com.aluracursos.conversorMonedas.exception.ErrorConversionRateException;
import com.aluracursos.conversorMonedas.history.HistoryConversionRate;
import com.google.gson.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class Conversor {

    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;
    URI uriApi;
    Gson gson;

    public Conversor() {
        client = HttpClient.newHttpClient();
        gson = new GsonBuilder().create();

    }

    public double exchangeRate(String base_code, String target_code, double amount) {
        Properties properties = new Properties();

        try {
            FileInputStream file = new FileInputStream(".env");
            properties.load(file);
            file.close();

            String api_key = properties.getProperty("VAR_API_KEY");

            uriApi = URI.create("https://v6.exchangerate-api.com/v6/" + api_key + "/pair/"+ base_code+ "/" + target_code + "/" + amount);

            request = HttpRequest.newBuilder()
                    .uri(uriApi)
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ConversionRateResponse conversionRateResponse = gson.fromJson(response.body(), ConversionRateResponse.class);

            if(conversionRateResponse.result().equals("error")) {
                throw new ErrorConversionRateException("Error en la petición a la api: "+ conversionRateResponse.error_type());
            }

            HistoryConversionRate historyConversionRate = new HistoryConversionRate();
            historyConversionRate.registerConversionRate(conversionRateResponse);

            return conversionRateResponse.conversion_result();

        } catch(FileNotFoundException e) {
            throw new RuntimeException("Error al leer el archivo .env donde se guarda la api_key para realizar la consulta a la api: " + e.getMessage());
        }  catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        } catch (JsonSyntaxException e) {
            throw new RuntimeException("Error no se pudo deserializar la respuesta de la petición al objeto ConversionRateResponse");
        }

    }
}
