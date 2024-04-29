package ar.edu.unju.fi.ejercicio5.main;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Colores para la consola.
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static Scanner sc;
    private static List<Producto> productos;
    private static List<Producto> carritoCompra;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        cargarProductos();

        while (true){
            switch (menu()){
                case 1: mostrarProductos(); break;
                case 2:
                    realizarCompra();
                    if(!carritoCompra.isEmpty()){
                        switch(pagoMenu()){
                            case 1:
                                PagoEfectivo pagoEfectivo = new PagoEfectivo();
                                pagoEfectivo(carritoCompra, pagoEfectivo);
                                break;
                            case 2:
                                PagoTarjeta pagoTarjeta = new PagoTarjeta();
                                pagoTarjeta(carritoCompra, pagoTarjeta);
                                break;
                            case 3: System.out.println("Volviendo al menu..."); break;
                        }
                    }
                    break;
                case 3: System.out.println("ADIOS."); return;

            }
        }

    }

    /**
     * Método que carga los productos en la lista
     */
    public static void cargarProductos(){
        productos = new ArrayList<>();

        productos.add(new Producto("A001", "Samsung A55", 150.0,
                Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA, true));
        productos.add(new Producto("A002", "Notebook Lenovo", 150000.0,
                Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto("A003", "Smart TV 55", 50000.0,
                Producto.OrigenFabricacion.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("A004", "Heladera Whirpool", 80000.0,
                Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("A005", "Iphone 15", 200000.0,
                Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.TELEFONIA, true));
        productos.add(new Producto("A006", "Taladro Black & Decker", 5000.0,
                Producto.OrigenFabricacion.CHINA, Producto.Categoria.HERRAMIENTAS, true));
        productos.add(new Producto("A007", "Impresora HP", 8000.0,
                Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto("A008", "Cafetera Nespresso", 10000.0,
                Producto.OrigenFabricacion.ARGENTINA,Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("A009", "Router TP-Link", 2000.0,
                Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto("A010", "Amoladora Bosch", 7000.0,
                Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
        productos.add(new Producto("A011", "Smart TV 32", 30000.0,
                Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("A012", "Samsung A20", 20000.0,
                Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true));
        productos.add(new Producto("A013", "Notebook HP", 120000.0,
                Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto("A014", "Lavarropas Drean", 40000.0,
                Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("A015", "Taladro Makita", 6000.0,
                Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
    }

    /**
     * Muestra los productos en la lista
     */
    public static void mostrarProductos(){
        System.out.println(ANSI_CYAN+"----- Listado de Productos -----"+ANSI_RESET);
        productos.forEach(System.out::println);
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
                System.out.println("2- Realizar Compra.");
                System.out.println("3- Salir.");
                System.out.print("Ingrese una opción: ");
                opc = Byte.parseByte(sc.nextLine());
                if(opc >= 1 && opc <= 3){
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
     * Realiza la compra de productos.
     */
    public static void realizarCompra(){
        carritoCompra = new ArrayList<>();
        while(true){
            mostrarProductos();
            System.out.print("Ingrese el código del producto a comprar: ");
            String codigo = sc.nextLine();
            Producto producto = buscarProducto(codigo);
            if(producto != null){
                carritoCompra.add(producto);
                System.out.println(ANSI_GREEN+"Producto agregado al carrito."+ANSI_RESET);
            } else {
                System.out.println(ANSI_RED+"Producto no encontrado."+ANSI_RESET);
            }
            while (true) {
                System.out.print("Desea seguir comprando? (s/n): ");
                String respuesta = sc.nextLine();
                if(respuesta.equalsIgnoreCase("n")){
                    return;
                }
                else if(respuesta.equalsIgnoreCase("s")){
                    break;
                } else{
                    System.out.println(ANSI_YELLOW+"Opción incorrecta."+ANSI_RESET);

                }
            }
        }

    }

    /**
     * Busca un producto en la lista de productos.
     * @param codigo código del producto a buscar.
     * @return Producto
     */
    public static Producto buscarProducto(String codigo){
        for(Producto p : productos){
            if(p.getCodigo().equalsIgnoreCase(codigo)){
                return p;
            }
        }
        return null;
    }

    /**
     * Muestra un menú de opciones de pago y solicita al usuario que ingrese una opción.
     * @return byte
     */
    public static byte pagoMenu(){
        byte opc;
        while(true){
            try{
                System.out.println("----- Menú Pago -----");
                System.out.println("1- Pago Efectivo.");
                System.out.println("2- Pago con Tarjeta.");
                System.out.println("3- Salir.");
                System.out.print("Ingrese una opción: ");
                opc = Byte.parseByte(sc.nextLine());
                if(opc >= 1 && opc <= 3){
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
     * Realiza el pago en efectivo.
     * @param carrito lista de productos a comprar.
     * @param pago objeto de tipo PagoEfectivo.
     */
    public static void pagoEfectivo(List<Producto> carrito, PagoEfectivo pago){
        LocalDate fechaPago = LocalDate.now();
        double total = 0;
        for(Producto producto : carrito){
            total += producto.getPrecioUnitario();
        }
        pago.setFechaPago(fechaPago);
        pago.realizarPago(total);
        pago.imprimirPago();
    }

    /**
     * Realiza el pago con tarjeta.
     * @param carrito lista de productos a comprar.
     * @param pago objeto de tipo PagoTarjeta.
     */
    public static void pagoTarjeta(List<Producto> carrito, PagoTarjeta pago){
        LocalDate fechaPago = LocalDate.now();
        double total = 0;
        String numeroTarjeta = pedirNroTarjeta("Ingrese el número de tarjeta: ");
        for(Producto producto : carrito){
            total += producto.getPrecioUnitario();
        }
        pago.setFechaPago(fechaPago);
        pago.setNumeroTarjeta(numeroTarjeta);
        pago.realizarPago(total);
        pago.imprimirPago();
    }

    /**
     * Solicita al usuario que ingrese un String.
     * @param mensaje mensaje a mostrar al usuario.
     * @return String
     */
    public static String pedirNroTarjeta(String mensaje){
        String input;
        while(true){
            System.out.print(mensaje);
            input = sc.nextLine();

            if(input.matches("[a-zA-Z]+")){
                System.out.println(ANSI_YELLOW+"No se permiten letras."+ANSI_RESET);
            } else if (input.matches(".*\\W.*")) {
                System.out.println(ANSI_YELLOW+"No se permiten caracteres especiales."+ANSI_RESET);
            } else if(!input.isEmpty()){
                if(input.length() == 16){
                    break;
                } else {
                    System.out.println(ANSI_YELLOW+"El número de tarjeta debe tener 16 dígitos."+ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_YELLOW+"No se permiten valores vacios."+ANSI_RESET);
            }
        }
        return input;
    }
}
