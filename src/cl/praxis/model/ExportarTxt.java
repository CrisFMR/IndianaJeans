package cl.praxis.model;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ExportarTxt extends Exportador {
    Scanner sc = new Scanner(System.in);

    @Override
    public void exportar(ArrayList<Producto> listaProducto) {
        //Se realiza un auto-generado de nombre en base a fecha utilizando la clase SimpleDateFormat ayudando a convertir la fecha y hora actual en texto
        String fichero = "src/cl/praxis/model/productos";
        SimpleDateFormat indicador = new SimpleDateFormat("YYMMddHHmmss");
        String diferenciador = indicador.format(new Date());
        File dir = new File(fichero);
        //Se utiliza directorio absoluto para mostrar la dirección de guardado dentro del PC del usuario.
        File absolute = dir.getAbsoluteFile();
        //Se realiza creacion de directorio y se aplican excepciones
        if (!dir.exists()) {
            try {
                dir.mkdirs();
                System.out.println("\nDirectorio creado correctamente");
            } catch (Exception e) {
                System.out.println("\nError al crear directorio " + e.getMessage());
                e.printStackTrace();
            }
        }else {
            System.out.println("\nEl directorio ya fue creado!");
        }
        //Se realiza creacion de archivo con auto-nombre y se aplican excepciones.
            File file = new File(absolute + "/Lista" + diferenciador + ".txt");
        if(!file.exists()){
            try {
                FileWriter fr = new FileWriter(file);
                for (Producto producto : listaProducto) {
                    fr.write(producto.toString() + "\n");
                }
                System.out.printf("\nArchivo creado exitosamente %s ", file);
                fr.close();
            } catch (Exception e) {
                System.out.println("\nError al escribir archivo " + e.getMessage());
                e.printStackTrace();
            }

        }else {
            System.out.println("\nEl archivo ya existe!");
        }
    }
}
