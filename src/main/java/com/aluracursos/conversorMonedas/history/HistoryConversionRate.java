package com.aluracursos.conversorMonedas.history;

import com.aluracursos.conversorMonedas.conversionRate.ConversionRateResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class HistoryConversionRate {

    private ConversionRateResponse conversionRateData;

    private Map<String, ConversionRateResponse> history;

    Gson gson;

    public HistoryConversionRate() {
        this.history = new HashMap<>();
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void registerConversionRate(ConversionRateResponse conversionRateData) {
        FileReader reader = getHistoryConvertions();

        Type listType = new TypeToken<Map<String, ConversionRateResponse>>(){}.getType();
        history = gson.fromJson(reader, listType);

        if (history == null) {
            history = new HashMap<>();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);

        history.put(formattedDateTime, conversionRateData);

        try {
            Writer writer = new FileWriter("history.json");

            gson.toJson(history, writer);

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static FileReader getHistoryConvertions() {
        File file = new File("history.json");
        FileReader reader;
        try {
            if (!file.exists() && !file.createNewFile()) {
                throw new RuntimeException("Error al crear el archivo history.json");
            }
            reader = new FileReader("history.json");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return reader;
    }

    public void printHistory()  {
        FileReader reader = getHistoryConvertions();

        Type listType = new TypeToken<Map<String, ConversionRateResponse>>(){}.getType();

        history = gson.fromJson(reader, listType);


        System.out.println("-----------------------------------------------------------------------------\n\t\tTu historial de conversión monetaria");
        for (Map.Entry<String, ConversionRateResponse> entry : history.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("-----------------------------------------------------------------------------\n");

    }

}

