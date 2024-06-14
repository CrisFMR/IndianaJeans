package cl.praxis.model;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private ProductoServicio productoServicio = new ProductoServicio();
    private Utilidad utilidad = new Utilidad();
    private ExportarTxt exportadorTxt = new ExportadorTxt();

    public void verMenu() {


        int opcion;
        //Mensaje de bienvenida
        System.out.println("\n=====Bienvenido a AdminClothes v1.0====");
        System.out.println("\t Presione Enter para continuar");
        sc.nextLine();
        utilidad.tiempoEspera("Now Loading", 250);
        System.out.println("\n");

        do {
            //Se abre la opcion de menú.
            System.out.println("\n======== Menú =======");
            System.out.println("|1. Listar Producto |");
            System.out.println("|2. Agregar Producto|");
            System.out.println("|3. Exportar Datos  |");
            System.out.println("|4. Salir           |");
            System.out.println("|5. Limpiar Consola |");
            System.out.print("=====================");
            System.out.print("\nIngrese una opción: \n");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    //verificar que la lista este vacia.
                    utilidad.tiempoEspera("Generando listado", 150);
                    System.out.println("\n");
                    Producto primero = new Producto();
                    ProductoServicio servicio = new ProductoServicio();
                    servicio.agregarProductos(primero);
                    productoServicio.listarProductos();

                    break;
                case 2:
                    //El primer ejemplo se digita con estos datos "Jeans", "15000", "Es un Jean muy lindo con hermosos detalles", "1500", "42", "Levis", "Azul Marino";
                    //Esto con la finalidad de cumplir los parametro del ejercicio y mantener la experiencia como si fuera un primer registro de programa.
                    sc.nextLine();
                    //Nombre Articulo: Jeans
                    System.out.println("Ingrese Nombre Articulo: ");
                    String articulo = sc.nextLine();
                    //Precio: 15000
                    System.out.println("Ingrese Precio: ");
                    String precio = sc.nextLine();
                    //Descripcion: Es un Jean muy lindo con hermosos detalles
                    System.out.println("Ingrese Descripción: ");
                    String descripcion = sc.nextLine();
                    //Código: 1500
                    System.out.println("Ingrese Código: ");
                    String codigo = sc.nextLine();
                    //Talla: 42
                    System.out.println("Ingrese Talla: ");
                    String talla = sc.nextLine();
                    //Marca: Levis
                    System.out.println("Ingrese Marca: ");
                    String marca = sc.nextLine();
                    //Color: Azul Marino
                    System.out.println("Ingrese Color: ");
                    String color = sc.nextLine();
                    System.out.println("\nDatos agregados correctamente a la lista!");
                    Producto producto = new Producto (articulo, precio, descripcion, codigo, talla, marca, color);
                    productoServicio.agregarProductos(producto);
                    break;
                case 3:
                    // Crea una lista de productos con nombre auto-generado al generarse en base a segundos no existen duplicados, de igual forma se incorpora excepcion de nombre duplicado.
                    utilidad.tiempoEspera("Exportando productos", 200);
                    exportadorTxt.exportar(productoServicio.getListaProductos());
                    break;
                case 4:
                    //Cierre de programa
                    utilidad.tiempoEspera("Cerrando Programa", 250);
                    System.out.println("\n>===<PROGRAMA CERRADO EXITOSAMENTE>===<");
                    break;
                case 5:
                    utilidad.limpiarPantalla();
                    break;
                default:
                    //Se genera un default con la excepción de opciones menores a 1 y mayores a 4, lo que garantiza que el usuario elija una opcion entre dicho rango.
                    if (opcion < 1 || opcion > 4) {
                        System.out.println("No existe opción!. Ingrese una opción valida");
                    }break;
            }
            System.out.println();
        } while (opcion != 4);
        sc.close();
    }
}
