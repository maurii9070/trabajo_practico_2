package ar.edu.unju.fi.ejercicio1.main;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc;
    private static List<Producto> productos;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        productos = new ArrayList<>();

        while (true){
            try{
                int opc = menu();

                switch (opc){
                    case 1:{altaProducto();break;}
                    case 2:{mostrarProductos();break;}
                    case 3:{modificarProducto();break;}
                    case 4:{System.out.println("ADIOS."); break;}
                    default:{
                        System.out.println("Error. Opcion no valida");
                    }
                }
                if(opc == 4){break;}
            }catch (InputMismatchException err){
                System.out.println("Error. Opcion debe ser un numero");
                sc.nextLine();
            }
        }

    }

    /**
     * Menu que retorna la opcion elegida
     * @return opcion elegida
     */
    public static int menu(){
        System.out.println("----- MENU -----");
        System.out.println("1- Crear Producto.");
        System.out.println("2- Mostrar Productos.");
        System.out.println("3- Modificar Productos.");
        System.out.println("4- Salir.");
        System.out.print("Elegir -> ");

        return sc.nextInt();
    }

    /**
     * Metodo que da de alta un Producto y agrega al ArrayList de productos
     */
    public static void altaProducto(){
        String codigo, descripcion;
        double precioUnitario;
        OrigenFabricacion origenFabricacion ;
        Categoria categoria;

        // Codigo
        codigo = setString("Ingrese codigo del producto: ");
        // Descripcion
        descripcion = setString("Ingrese una descripcion: ");
        // Precio Unitario
        precioUnitario = setDouble("Ingrese el precio del producto: ");
        // Origen de Fabricacion
        origenFabricacion = setOrigen();
        // Categoria
        categoria = setCategoriaProducto();

        Producto producto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
        productos.add(producto);
    }

    /**
     * Metodo para ingresar un string
     * @param mensage mensage que se muestra por pantalla
     * @return salida del String
     */
    public static String setString(String mensage){
        String output;
        do {
            System.out.print(mensage);
            output = sc.next();
            if(output.length() < 2){
                System.out.println("El dato ingresado debe ser mayor de 2 caracteres.");
            }
        } while (output.length() < 2);
        return output;
    }

    /**
     * Metodo para ingresar un double
     * @param mensage mensage que se muestra por pantalla
     * @return salida del double
     */
    public static double setDouble(String mensage){
        double output;
        while (true){
            try{
                System.out.print(mensage);
                output = sc.nextDouble();
                if(output > 0){break;}
            }catch (InputMismatchException err){
                System.out.println("ERROR. El valor de precio no es valido.");
                sc.nextLine();
            }
        }
        return output;
    }

    /**
     * Metodo para ingre un Origen de fabricacion
      * @return Origen de fabricacion
     */
    public static OrigenFabricacion setOrigen(){
        OrigenFabricacion origenFabricacion = null;
        while (true){
            try{
                int opc = menuFabricacion();
                switch (opc){
                    case 1:
                        origenFabricacion = OrigenFabricacion.ARGENTINA;
                        break;
                    case 2:
                        origenFabricacion = OrigenFabricacion.CHINA;
                        break;
                    case 3:
                        origenFabricacion = OrigenFabricacion.BRASIL;
                        break;
                    case 4:
                        origenFabricacion = OrigenFabricacion.URUGUAY;
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
                if(opc > 0 && opc <= 4){break;}
            } catch (InputMismatchException e){
                System.out.println("ERROR. La opcion de origen de fabricacion no es valida.");
                sc.nextLine();
            }
        }
        return origenFabricacion;
    }

    /**
     * Metodo para ingresar una categoria
     * @return categoria
     */
    public static Categoria setCategoriaProducto(){
        Categoria categoria = null;
        while (true){
            try{
                int opc = menuCategoria();
                switch (opc){
                    case 1:
                        categoria = Categoria.TELEFONIA;
                        break;
                    case 2:
                        categoria = Categoria.INFORMATICA;
                        break;
                    case 3:
                        categoria = Categoria.ELECTROHOGAR;
                        break;
                    case 4:
                        categoria = Categoria.HERRAMIENTAS;
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
                if(opc > 0 && opc <= 4){break;}
            } catch (InputMismatchException e){
                System.out.println("ERROR. La opcion de categoria no es valida.");
                sc.nextLine();
            }
        }
        return categoria;
    }

    /**
     * Menu de fabricacion
     * @return opcion elegida para origen de fabricacion
     */
    public static int menuFabricacion(){
        System.out.println("----- Elegir Origen de Fabricacion -----");
        System.out.println("1- Argentina");
        System.out.println("2- China");
        System.out.println("3- Brasil");
        System.out.println("4- Uruguay");
        System.out.print("Elegir -> ");
        return sc.nextInt();
    }

    /**
     * Menu de categoria
     * @return opcion elegida para categoria
     */
    public static int menuCategoria(){
        System.out.println("----- Elegir Categoria -----");
        System.out.println("1- Telefonia");
        System.out.println("2- Informatica");
        System.out.println("3- Electro hogar");
        System.out.println("4- Herramientas");
        System.out.print("Elegir -> ");
        return sc.nextInt();
    }

    /**
     * Metodo que muestra todos los productos en
     */
    public static void mostrarProductos(){
        System.out.println("----- Lista de Productos -----");
        for (Producto producto : productos){
            System.out.println(producto);
        }
    }

    /**
     * Metodo que modifica un producto
     */
    public static void modificarProducto(){
        // Codigo
        mostrarProductos();
        String codigo = setString("Ingrese codigo del producto a modificar: ");
        boolean encontrado = false;

        for (Producto producto : productos){
            if(producto.getCodigo().equals(codigo)){
                encontrado = true;
                while (true){
                    try{
                        int opc = menuModificacion();
                        switch (opc){
                            case 1:
                                producto.setDescripcion(setString("Ingrese nueva descripcion: "));
                                break;
                            case 2:
                                producto.setPrecioUnitario(setDouble("Ingrese nuevo precio unitario: "));
                                break;
                            case 3:
                                producto.setOrigenFabricacion(setOrigen());
                                break;
                            case 4:
                                producto.setCategoria(setCategoriaProducto());
                                break;
                            default:
                                System.out.println("Error. Opcion mal elegida.");
                        }
                        if(opc > 0 && opc <= 4){System.out.println("Modificacion completada.");break;}
                    } catch (InputMismatchException e) {
                        System.out.println("Error. Opcion debe ser un entero.");
                        sc.nextLine();
                    }
                }
            }
        }
        if(!encontrado){
            System.out.println("No se encontro el producto. Revisar entrada.");
        }
    }

    /**
     * Menu para la modificacion
     * @return opcion elegida
     */
    public static int menuModificacion(){
        System.out.println("----- MODIFICACION -----");
        System.out.println("1- Modificar descripcion.");
        System.out.println("2- Modificar precio unitario.");
        System.out.println("3- Modificar origen de fabricacion.");
        System.out.println("4- Modificar categoria.");
        System.out.print("Elegir -> ");
        return sc.nextInt();
    }
}
