package ar.edu.unju.fi.ejercicio4.main;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    //Colores para la consola.
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static Scanner sc = new Scanner(System.in);
    private static List<Jugador> jugadores;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        jugadores = new ArrayList<>();

        while(true){
            switch(menu()){
                case 1: altaJugador(); break;
                case 2: mostrarJugadores(); break;
                case 3: modificarPosicion(); break;
                case 4: eliminarJugador(); break;
                case 5: System.out.println("ADIOS."); return;
            }
        }
    }

    /**
     * Muestra un menú de opciones y solicita al usuario que ingrese una opción.
     * @return byte
     */
    public static byte menu(){
        byte opc;
        while(true){
            try{
                System.out.println("----- Menú -----");
                System.out.println("1- Alta de jugador.");
                System.out.println("2- Mostrar jugadores.");
                System.out.println("3- Modificar posición de un jugador.");
                System.out.println("4- Eliminar jugador.");
                System.out.println("5- Salir.");
                System.out.print("Ingrese una opción: ");
                opc = Byte.parseByte(sc.nextLine());
                if(opc >= 1 && opc <= 5){
                    return opc;
                } else {
                    System.out.println(ANSI_YELLOW+"No existe opcion elegida."+ANSI_RESET);
                }
            } catch (NumberFormatException ex){
                System.out.println(ANSI_RED+"Error: Debe ingresar un número entero."+ANSI_RESET);
            }
        }
    }

    public static void altaJugador(){
        String nombre = pedirString("Ingrese el nombre del jugador: ");
        String apellido = pedirString("Ingrese el apellido del jugador: ");
        LocalDate fechaNacimiento = pedirFecha("-- Ingrese la fecha de nacimiento del jugador --");
        String nacionalidad = pedirString("Ingrese la nacionalidad del jugador: ");
        short estatura = pedirShort("Ingrese la estatura(cm) del jugador: ");
        short peso = pedirShort("Ingrese el peso del jugador(cm): ");
        Posicion posicion = pedirPosicion("-- Ingrese la posición del jugador --");

        jugadores.add(new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion));
        System.out.println(ANSI_GREEN+"Jugador agregado con éxito."+ANSI_RESET);
    }

    /**
     * Solicita al usuario que ingrese un String.
     * @param mensaje mensaje a mostrar al usuario.
     * @return String
     */
    public static String pedirString(String mensaje){
        String input;
        while(true){
            System.out.print(mensaje);
            input = sc.nextLine();

            if(input.matches(".*\\d.*")){
                System.out.println(ANSI_YELLOW+"No se permiten números."+ANSI_RESET);
            }
            if(input.matches(".*\\W.*")){
                System.out.println(ANSI_YELLOW+"No se permiten caracteres especiales."+ANSI_RESET);
            }
            if(!input.isEmpty()){break;}
            else { System.out.println(ANSI_YELLOW+"No se permiten valores vacios."+ANSI_RESET);}
        }
        return input;
    }

    /**
     * Solicita al usuario que ingrese un número entero.
     * @param mensaje mensaje a mostrar al usuario.
     * @return int
     */
    public static short pedirShort(String mensaje){
        short input;
        while(true){
            try{
                System.out.print(mensaje);
                input = Short.parseShort(sc.nextLine());
                break;
            } catch (NumberFormatException ex){
                System.out.println(ANSI_RED+"Error: Debe ingresar un número entero."+ANSI_RESET);
            }
        }
        return input;
    }

    /**
     * Solicita al usuario que ingrese una fecha.
     * @param mensaje mensaje a mostrar al usuario.
     * @return LocalDate
     */
    public static LocalDate pedirFecha(String mensaje){
        short dia, mes, anio;
        while(true){
            try{
                System.out.println(mensaje);
                // dia
                while (true){
                    dia = pedirShort("Ingrese el día: ");
                    if(dia >= 1 && dia <= 31){break;}
                    else {System.out.println(ANSI_YELLOW+"Nota: El día debe ser un valor entre 1 y 31."+ANSI_RESET);}
                }
                // mes
                while (true){
                    mes = pedirShort("Ingrese el mes: ");
                    if(mes >= 1 && mes <= 12){break;}
                    else {System.out.println(ANSI_YELLOW+"Nota: El mes debe ser un valor entre 1 y 12."+ANSI_RESET);}
                }
                // anio
                while (true){
                    anio = pedirShort("Ingrese el año: ");
                    if(anio >= 1900 && anio <= 2020){break;}
                    else {System.out.println(ANSI_YELLOW+"Nota: El año debe ser un valor entre 1900 y 2021."+ANSI_RESET);}
                }
                break;
            } catch (Exception ex){
                System.out.println(ANSI_RED+"Error: Debe ingresar una fecha válida."+ANSI_RESET);
            }
        }
        return LocalDate.of(anio, mes, dia);
    }

    /**
     * Solicita al usuario que ingrese una posición.
     * @param mensaje mensaje a mostrar al usuario.
     * @return Posicion
     */
    public static Posicion pedirPosicion(String mensaje){
        Posicion posicion = null;
        while(true){
            try{
                System.out.println(mensaje);
                System.out.println("1- Arquero.");
                System.out.println("2- Defensor.");
                System.out.println("3- Mediocampista.");
                System.out.println("4- Delantero.");
                System.out.print("Ingrese una opción: ");
                byte opc = Byte.parseByte(sc.nextLine());
                switch(opc){
                    case 1: posicion = Posicion.ARQUERO; break;
                    case 2: posicion = Posicion.DEFENSA; break;
                    case 3: posicion = Posicion.MEDIO; break;
                    case 4: posicion = Posicion.DELANTERO; break;
                    default: System.out.println(ANSI_YELLOW+"No existe opcion elegida."+ANSI_RESET);
                }
                if(opc >= 1 && opc <= 4){break;}
            } catch (Exception ex){
                System.out.println(ANSI_RED+"Error: Debe ingresar una opción válida."+ANSI_RESET);
            }
        }
        return posicion;
    }

    /**
     * Muestra los jugadores.
     */
    public static void mostrarJugadores(){
        if(jugadores.isEmpty()){
            System.out.println(ANSI_YELLOW+"No hay jugadores para mostrar."+ANSI_RESET);
            return;
        }
        System.out.println(ANSI_CYAN+"----- Jugadores -----"+ANSI_RESET);
        jugadores.forEach(jugador -> System.out.println(ANSI_CYAN+ jugador +ANSI_RESET));
    }

    /**
     * Modifica la posición de un jugador.
     */
    public static void modificarPosicion(){
        if(jugadores.isEmpty()){
            System.out.println(ANSI_YELLOW+"No hay jugadores para modificar."+ANSI_RESET);
            return;
        }
        mostrarJugadores();
        String nombre = pedirString("Ingrese el nombre del jugador a modificar: ");
        String apellido = pedirString("Ingrese el apellido del jugador a modificar: ");
        for(Jugador jugador : jugadores){
            if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)){
                jugador.setPosicion(pedirPosicion("Ingrese la nueva posición del jugador: "));
                System.out.println(ANSI_GREEN+"Posición modificada con éxito."+ANSI_RESET);
                return;
            }
        }
        System.out.println(ANSI_YELLOW+"No se encontró el jugador."+ANSI_RESET);
    }

    /**
     * Elimina un jugador.
     */
    public static void eliminarJugador(){
        if(jugadores.isEmpty()){
            System.out.println(ANSI_YELLOW+"No hay jugadores para eliminar."+ANSI_RESET);
            return;
        }
        mostrarJugadores();
        String nombre = pedirString("Ingrese el nombre del jugador a eliminar: ");
        String apellido = pedirString("Ingrese el apellido del jugador a eliminar: ");
        Iterator<Jugador> jugadorIterator = jugadores.iterator();
        while(jugadorIterator.hasNext()){
            Jugador jugador = jugadorIterator.next();
            if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)){
                jugadorIterator.remove();
                System.out.println(ANSI_GREEN+"Jugador eliminado."+ANSI_RESET);
                return;
            }
        }
    }

}
