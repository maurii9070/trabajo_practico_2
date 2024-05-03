package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {
    public static void main(String[] args) {

        // Garfield (Felino doméstico) está manifestando comportamientos salvajes, entonces vamos a realizar
        //la conversión a felino salvaje de la siguiente forma:

        FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);

        //definición de expresión lambda que define el convertidor de FelinoDomestico a
        //FelinoSalvaje.

        Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());

        // Se realiza la conversion
        FelinoSalvaje felino1 = converter.convert(gato);

        // Mostrar los datos del objeto felino salvaje felino1
        converter.mostrarObjeto(felino1);

        /* ------------------------------------------------------------------- */
        /* ---------------------------Felino Salvaje-------------------------- */
        /* ------------------------------------------------------------------- */
        FelinoSalvaje leon = new FelinoSalvaje("Tanner", (byte) 20, 186f);
        Converter<FelinoSalvaje, FelinoDomestico> converter1 = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
        if(Converter.isNotNull(leon)) {
            FelinoDomestico felino2 = converter1.convert(leon);
            converter1.mostrarObjeto(felino2);
        }
    }
}
