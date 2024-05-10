package principal;

import com.google.gson.Gson;
import modelos.LogicaHttp;
import modelos.Moneda;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        LogicaHttp peticionHttp = new LogicaHttp();
        Gson gson = new Gson();
        Moneda moneda = new Moneda();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("¡Bienvenido al Conversor de Moneda!");

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Convertir de dólares a pesos argentinos");
            System.out.println("2. Convertir de pesos argentinos a dólares");
            System.out.println("3. Convertir de euros a pesos argentinos");
            System.out.println("4. Convertir de pesos argentinos a euros");
            System.out.println("5. Convertir de dólares a euros");
            System.out.println("6. Convertir de euros a dólares");
            System.out.println("7. Salir");

            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convesion(peticionHttp,gson,moneda,scanner,"USD","ARS");
                    break;
                case 2:
                    convesion(peticionHttp,gson,moneda,scanner,"ARS","USD");
                    break;
                case 3:
                    convesion(peticionHttp,gson,moneda,scanner,"EUR","ARS");
                    break;
                case 4:
                    convesion(peticionHttp,gson,moneda,scanner,"ARS","EUR");
                    break;
                case 5:
                    convesion(peticionHttp,gson,moneda,scanner,"USD","EUR");
                    break;
                case 6:
                    convesion(peticionHttp,gson,moneda,scanner,"EUR","USD");
                    break;
                case 7:
                    System.out.println("Saliendo del Conversor de Moneda. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 7);

        scanner.close();

    }
    public static void convesion(LogicaHttp peticionHttp , Gson gson, Moneda moneda, Scanner scanner,String monedaBase, String monedaAConvertir) throws IOException, InterruptedException {
        System.out.println("Realizar conversión de "+monedaBase+" a "+monedaAConvertir+"...");
        String json = (String) peticionHttp.peticion(monedaBase,monedaAConvertir).body();
        moneda = gson.fromJson(json, Moneda.class);
        System.out.println("Cuantos "+monedaBase+" desea convertir a "+monedaAConvertir+"?");
        float cantidad = scanner.nextFloat();
        float total = cantidad * moneda.getValorConvertido();
        System.out.println("************************************************************\n");
        System.out.println("El total de "+cantidad+" "+monedaBase+" en "+monedaAConvertir+" es: " + String.format("%.2f",total) +" "+ monedaAConvertir);
        System.out.println("\n************************************************************\n");
    }
}
