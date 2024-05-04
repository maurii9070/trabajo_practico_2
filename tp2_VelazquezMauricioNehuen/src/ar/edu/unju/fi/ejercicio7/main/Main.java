package ar.edu.unju.fi.ejercicio7.main;

import ar.edu.unju.fi.ejercicio5.model.Producto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CYAN = "\u001B[36m";


    private static Scanner sc;
    private static ArrayList<Producto> productos;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        cargarProductos();

        while (true) {
            switch (menu()) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    mostrarProductosFaltantes();
                    break;
                case 3:
                    incrementarPrecios();
                    break;
                case 4:
                    mostrarProdElectrohogarDisp();
                    break;
                case 5:
                    ordenarProductosPorPrecio();
                    break;
                case 6:
                    mostrarProductosMayuscula();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    /**
     * Método que carga los productos en la lista
     */
    public static void cargarProductos(){
        productos = new ArrayList<>();

        productos.add(new Producto("A001", "Samsung A55", 45000.0,
                Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA, true));
        productos.add(new Producto("A002", "Notebook Lenovo", 150000.0,
                Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, false));
        productos.add(new Producto("A003", "Smart TV 55", 50000.0,
                Producto.OrigenFabricacion.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("A004", "Heladera Whirpool", 80000.0,
                Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("A005", "Iphone 15", 200000.0,
                Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.TELEFONIA, false));
        productos.add(new Producto("A006", "Taladro Black & Decker", 5000.0,
                Producto.OrigenFabricacion.CHINA, Producto.Categoria.HERRAMIENTAS, true));
        productos.add(new Producto("A007", "Impresora HP", 8000.0,
                Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto("A008", "Cafetera Nespresso", 10000.0,
                Producto.OrigenFabricacion.ARGENTINA,Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("A009", "Router TP-Link", 2000.0,
                Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, false));
        productos.add(new Producto("A010", "Amoladora Bosch", 7000.0,
                Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
        productos.add(new Producto("A011", "Smart TV 32", 30000.0,
                Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, false));
        productos.add(new Producto("A012", "Samsung A20", 20000.0,
                Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, false));
        productos.add(new Producto("A013", "Notebook HP", 120000.0,
                Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto("A014", "Lavarropas Drean", 40000.0,
                Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("A015", "Taladro Makita", 6000.0,
                Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.HERRAMIENTAS, false));
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
                System.out.println("1- Mostrar Productos.");
                System.out.println("2- Mostrar Productos faltantes.");
                System.out.println("3- Incrementar precios (20%).");
                System.out.println("4- Mostrar Productos Electrohogar disponibles.");
                System.out.println("5- Ordernar los productos por precio (des).");
                System.out.println("6- Mostrar productos (nombres mayuscula).");
                System.out.println("7- Salir.");
                System.out.print("Ingrese una opción: ");
                opc = Byte.parseByte(sc.nextLine());
                if(opc >= 1 && opc <= 7){
                    return opc;
                } else {
                    System.out.println(ANSI_YELLOW+"No existe opcion elegida."+ANSI_RESET);
                }
            } catch (NumberFormatException ex){
                System.out.println(ANSI_RED+"Error: Debe ingresar un número entero."+ANSI_RESET);
            }
        }
    }

    /**
     * Muestra los productos en la lista utilizando Consumer
     */
    public static void mostrarProductos(){
        Consumer<Producto> printConsumer = p -> System.out.println(ANSI_CYAN+p+ANSI_RESET);
        System.out.println(ANSI_CYAN+"----- Productos -----"+ANSI_RESET);
        productos.forEach(printConsumer);
    }

    /**
     * Filtra los productos faltantes con Predicate y los muestra con Consumer
     */
    public static void mostrarProductosFaltantes(){
        Predicate<Producto> filtrarFaltantes = p -> !p.getEstado();
        System.out.println(ANSI_YELLOW+"----- Productos Faltantes -----"+ANSI_RESET);
        productos.stream().filter(filtrarFaltantes).forEach(p -> System.out.println(ANSI_YELLOW+p+ANSI_RESET));
    }

    /**
     * Incrementa los precios de los productos en un 20% utilizando Function y los muestra con Consumer
     */
    public static void incrementarPrecios(){
        Function<Producto, Producto> incrementarPrecio = p -> {
            p.setPrecioUnitario(p.getPrecioUnitario() * 1.20);
            return p;
        };

        List<Producto> productosIncrementados = productos.stream().map(incrementarPrecio).collect(Collectors.toList());

        System.out.println(ANSI_CYAN+"----- Productos Incrementados -----"+ANSI_RESET);
        productosIncrementados.forEach(p -> System.out.println(ANSI_CYAN +p+ ANSI_RESET));
    }

    /**
     * Muestra los productos de la categoría Electrohogar disponibles
     * utilizando Predicate y filter
     */
    public static void mostrarProdElectrohogarDisp(){
        Predicate<Producto> filtrarElectrohogar = p -> p.getCategoria().equals(Producto.Categoria.ELECTROHOGAR) && p.getEstado();
        System.out.println(ANSI_CYAN+"----- Productos Electrohogar Disponibles -----"+ANSI_RESET);
        productos.stream().filter(filtrarElectrohogar).forEach(p -> System.out.println(ANSI_CYAN+p+ANSI_RESET));
    }

    /**
     * Ordena los productos por precio de mayor a menor utilizando Comparator
     */
    public static void ordenarProductosPorPrecio(){
        Comparator<Producto> c = Comparator.comparingDouble(Producto::getPrecioUnitario);
        productos.sort(c.reversed());
        mostrarProductos();
    }

    /**
     * Convierte la descripción de Producto en mayúscula utilizando Function
     * y muestra los productos
     */
    public static void mostrarProductosMayuscula(){
        Function<Producto, Producto> convertirMayuscula = p -> {
            p.setDescripcion(p.getDescripcion().toUpperCase());
            return p;
        };
        System.out.println(ANSI_CYAN+"----- Productos (Descripción en mayúscula) -----"+ANSI_RESET);
        productos.stream().map(convertirMayuscula).forEach(p -> System.out.println(ANSI_CYAN+p+ANSI_RESET));
    }
}
