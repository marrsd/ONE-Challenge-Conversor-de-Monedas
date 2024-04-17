package com.aluracursos.conversorMonedas.conversionRate;

import com.google.gson.annotations.SerializedName;

public record ConversionRateResponse(String result, String base_code, String target_code, double conversion_rate, double conversion_result, @SerializedName("error-type") String error_type) {

    @Override
    public String toString() {
        double amount = conversion_result/conversion_rate;
        return  String.format("Conversión: %.4f [%s] -> %.4f [%s]", amount, base_code, conversion_result, target_code);
    }
}
