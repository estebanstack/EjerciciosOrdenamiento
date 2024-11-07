package ejercicios;

import java.util.ArrayList;

public class ListaProd {
    static ArrayList<Producto> ventas = new ArrayList<>();

    public static void llenarLista(){
        for(int i=0; i<5; i++){
            int codigo= (int) (Math.random() *1999 +1000);
            int cantidad= (int) (Math.random() *100);
            long precio= (int) (Math.random() *2000);

            ventas.add(new Producto(codigo,cantidad,precio));
        }
    }

    public static void mostrar(){
        System.out.printf("%-10s %-10s %-10s\n", "código", "cantidad", "precio");

        for (Producto producto : ventas) {
            System.out.printf("%-10d %-10d %-10d\n", producto.getCodigo(), producto.getCantidad(), producto.getPrecio());
        }
    }

}
