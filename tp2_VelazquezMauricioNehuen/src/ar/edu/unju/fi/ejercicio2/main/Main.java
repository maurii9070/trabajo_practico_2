package ar.edu.unju.fi.ejercicio2.main;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

import java.util.*;

public class Main {

    // Colores para la consola.
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static Scanner sc;
    private static List<Efemeride> efemerides;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        efemerides = new ArrayList<>();

        int opc = 0;
        do {
            try{
                opc = Integer.parseInt(menu());
                switch (opc) {
                    case 1: crearEfemeride(); break;
                    case 2: mostrarEfemerides();break;
                    case 3: eliminarEfemeride();break;
                    case 4: modificarEfemeride();break;
                    case 5: System.out.println(ANSI_GREEN+"ADIOS."+ANSI_RESET);break;
                    default: System.out.println(ANSI_RED+"Opción inválida."+ANSI_RESET);break;
                }
            }catch (NumberFormatException e){
                System.out.println(ANSI_RED+ "Error: Debe ingresar un número entero." + ANSI_RESET);
            }
        }while (opc != 5);

        sc.close();
    }

    /**
     * Muestra un menú de opciones y solicita al usuario que ingrese una opción.
     * @return int
     */
    public static String menu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Ingresar efeméride.");
        System.out.println("2. Mostrar efeméride.");
        System.out.println("3. Eliminar efeméride.");
        System.out.println("4. Modificar efeméride.");
        System.out.println("5. Salir.");
        System.out.print("Ingrese una opción: ");
        return sc.nextLine();
    }

    /**
     * Crea una efeméride y la agrega al ArrayList de efemérides.
     */
    public static void crearEfemeride(){
        String codigo, detalle;
        Mes mes;
        byte dia;

        // Codigo
        codigo = setString("Ingrese el código de la efeméride: ");

        // Mes
        mes = setMesEfemeride();

        // Dia
        while (true) {
            dia = setByte("Ingrese el día de la efeméride: ");
            if(dia >= 0 && dia <= 31){
                break;
            }else {
                System.out.println(ANSI_YELLOW + "Nota: El día debe ser un valor entre 1 y 31." + ANSI_RESET);
            }
        }

        // Detalle
        detalle = setString("Ingrese el detalle de la efeméride: ");

        efemerides.add(new Efemeride(codigo, mes, dia, detalle));
    }

    /**
     * Solicita al usuario que ingrese un valor de tipo String.
     * @param mensaje Mensaje a mostrar al usuario.
     * @return String
     */
    public static String setString(String mensaje){
        String input;
        while(true){
            System.out.print(mensaje);
            input = sc.nextLine();
            if( !input.isEmpty()){break;}
            System.out.println(ANSI_YELLOW + "Nota: No se permiten valores vacíos." + ANSI_RESET);
        }
        return input;
    }

    /**
     * Solicita al usuario que ingrese un valor de tipo Mes.
     * @return Mes
     */
    public static Mes setMesEfemeride(){
        Mes mes = null;
        int opc;
        System.out.println("----- Seleccionar Mes -----");
        do {
            try{
                System.out.println("1. Enero \t\t 2. Febrero \t 3. Marzo");
                System.out.println("4. Abril \t\t 5. Mayo \t\t 6. Junio");
                System.out.println("7. Julio \t\t 8. Agosto \t\t 9. Septiembre");
                System.out.println("10. Octubre \t 11. Noviembre \t 12. Diciembre");
                System.out.print("Ingrese el mes de la efeméride: ");
                opc = Integer.parseInt(sc.nextLine());
                switch (opc) {
                    case 1: mes = Mes.ENERO; break;
                    case 2: mes = Mes.FEBRERO; break;
                    case 3: mes = Mes.MARZO; break;
                    case 4: mes = Mes.ABRIL; break;
                    case 5: mes = Mes.MAYO; break;
                    case 6: mes = Mes.JUNIO; break;
                    case 7: mes = Mes.JULIO; break;
                    case 8: mes = Mes.AGOSTO; break;
                    case 9: mes = Mes.SEPTIEMBRE; break;
                    case 10: mes = Mes.OCTUBRE; break;
                    case 11: mes = Mes.NOVIEMBRE; break;
                    case 12: mes = Mes.DICIEMBRE; break;
                    default: System.out.println(ANSI_YELLOW + "Opción inválida." + ANSI_RESET); break;
                }
            } catch (NumberFormatException err){
                System.out.println(ANSI_RED + "Error: Debe ingresar un número." + ANSI_RESET);
                opc = 0;
            }
        }while (opc < 1 || opc > 12);
        return mes;
    }

    /**
     * Solicita al usuario que ingrese un valor de tipo byte.
     * @param mensaje Mensaje a mostrar al usuario.
     * @return byte
     */
    public static byte setByte(String mensaje){
        byte input;
        while (true) {
            try {
                System.out.print(mensaje);
                input = Byte.parseByte(sc.nextLine());
                if (input > 0) {
                    break;
                }
                System.out.println(ANSI_YELLOW + "Nota: Debe ingresar un valor mayor a 0." + ANSI_RESET);
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Error: Debe ingresar un número entero." + ANSI_RESET);
            }
        }
        return input;
    }

    /**
     * Muestra las efemérides almacenadas.
     */
    public static void mostrarEfemerides(){
        if(efemerides.isEmpty()){
            //System.out.println("No hay efemérides para mostrar.");
            System.out.println(ANSI_RED + "No hay efemérides para mostrar." + ANSI_RESET);
        }else{
            System.out.println(ANSI_CYAN+"----- Efemérides -----"+ANSI_RESET);
            for (Efemeride efemeride : efemerides) {
                System.out.println(ANSI_CYAN + efemeride + ANSI_RESET);
            }
        }
    }

    /**
     * Elimina una efeméride solicitando el codigo.
     */
    public static void eliminarEfemeride(){
        mostrarEfemerides();
        if(efemerides.isEmpty()){
            System.out.println(ANSI_RED + "No hay efemérides para eliminar." + ANSI_RESET);
        }else {
            String codigo = setString("Ingrese el código de la efeméride a eliminar: ");
            Iterator<Efemeride> efemerideIterator= efemerides.iterator();
            while(efemerideIterator.hasNext()) {
                Efemeride efemeride = efemerideIterator.next();
                if (efemeride.getCodigo().equals(codigo)) {
                    efemerideIterator.remove();
                    System.out.println(ANSI_GREEN + "Efeméride eliminada." + ANSI_RESET);
                    return;
                }
            }
            System.out.println(ANSI_YELLOW + "No se encontró la efeméride con el código ingresado." + ANSI_RESET);
        }
    }

    /**
     * Modifica una efeméride solicitando el codigo.
     */
    public static void modificarEfemeride(){
        mostrarEfemerides();
        String codigo = setString("Ingrese el código de la efeméride a modificar: ");
        for (Efemeride efemeride : efemerides) {
            if(efemeride.getCodigo().equals(codigo)){
                switch (menuModificacion()){
                    case 1: efemeride.setMes(setMesEfemeride()); break;
                    case 2: efemeride.setDia(setByte("Ingrese el nuevo día de la efeméride: ")); break;
                    case 3: efemeride.setDetalle(setString("Ingrese el nuevo detalle de la efeméride: ")); break;
                    case 4: return;
                }
                System.out.println(ANSI_GREEN + "Efeméride modificada." + ANSI_RESET);
                return;
            }
        }
        System.out.println(ANSI_YELLOW + "No se encontró la efeméride con el código ingresado." + ANSI_RESET);
    }

    /**
     * Muestra un menú de opciones para modificar una efeméride.
     * @return int
     */
    public static byte menuModificacion(){
        byte input ;
        while(true) {
            try{
                System.out.println("----- Modificar efeméride -----");
                System.out.println("1. Modificar mes.");
                System.out.println("2. Modificar día.");
                System.out.println("3. Modificar detalle.");
                System.out.println("4. Salir.");
                input = setByte("Ingrese una opcion: ");
                if(input >= 1 && input <= 4){break;}
            } catch (NumberFormatException e){
                System.out.println(ANSI_RED + "Error: Debe ingresar un número entero." + ANSI_RESET);
            }
        }
        return input;
    }
}
