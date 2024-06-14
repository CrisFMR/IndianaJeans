package cl.praxis.model;

import java.util.ArrayList;

public class ProductoServicio {
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();


    public void listarProductos () {
        if (listaProductos.isEmpty()) {
            System.out.println("La lista se encuentra vacía, favor agregue productos");
            return;
            }else{
            System.out.println("Listado cargado exitosamente!");
        }
        for (Producto producto: listaProductos) {
            System.out.println(producto.toString());
        }
    }
    public void agregarProductos(Producto producto) {
        listaProductos.add(producto);
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "ProductoServicio [listaProductos=" + listaProductos + "]";
    }



}