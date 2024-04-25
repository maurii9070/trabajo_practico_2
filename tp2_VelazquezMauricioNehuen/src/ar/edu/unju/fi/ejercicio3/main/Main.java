package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {

        Provincia[] provincias = Provincia.values();

        for (Provincia provincia : provincias) {
            System.out.println(ANSI_GREEN +"Provincia: " + provincia.name() +ANSI_RESET);
            System.out.println("Cantidad de poblacion: " + provincia.getCantidadPoblacion() + " habitantes");
            System.out.println("Superficie: " + provincia.getSuperficie() + " km2");
            System.out.println("Densidad poblacional: " +
                    String.format("%.2f", provincia.getDensidadPoblacional()) + " hab/km2");
            System.out.println();
        }


    }
}
