package com.aluracursos.conversorMonedas;

import com.aluracursos.conversorMonedas.conversionRate.Conversor;
import com.aluracursos.conversorMonedas.history.HistoryConversionRate;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conversor conversor = new Conversor();

        int opcion = 0;

        while(opcion != 8) {
            String base_code = "";
            String target_code = "";

            System.out.print("""
                    *******************************************************
                    Sea bienvenido/a al Conversor de Moneda
                                    
                    1)  Dólar -----------> Peso Argentino    [USD] -> [ARS]
                    2)  Peso Argentino --> Dólar             [ARS] -> [USD]
                    3)  Dólar -----------> Real Brasileño    [USD] -> [BRL]
                    4)  Real Brasileño --> Dólar             [BRL] -> [USD]
                    5)  Dólar -----------> Peso Colombiano   [USD] -> [COP]
                    6)  Peso Colombiano -> Dólar             [COP] -> [USD]
                    7)  Ver Historial
                    8)  Salir
                                    
                    Elija una opción válida: """);

            opcion = sc.nextInt();
            if (opcion == 8) {
                System.out.println("Gracias por usar nuestro conversor de monedas!");
                break;
            };

            switch (opcion) {
                case 1, 3, 5:
                    target_code = opcion == 1 ? "ARS" : opcion == 3 ? "BRL" : opcion == 5 ? "COP" : null;
                    base_code = "USD";
                    break;
                case 2, 4, 6:
                    base_code = opcion == 2 ? "ARS" : opcion == 4 ? "BRL" : opcion == 6 ? "COP" : null;
                    target_code = "USD";
                    break;
                case 7:
                    HistoryConversionRate h = new HistoryConversionRate();
                    h.printHistory();
                    break;
            }
            if (opcion == 7) { continue; }

                System.out.print("Ingrese el valor que deseas convertir: ");
                double amount = sc.nextDouble();

                double conversion_rate = conversor.exchangeRate(base_code, target_code, amount);

                System.out.println("""
                        ------------------------------------------------------------
                                %.4f [%s] corresponden a %.4f [%s]      
                        ------------------------------------------------------------
                        """.formatted(amount, base_code, conversion_rate, target_code));
            }


    }
}
