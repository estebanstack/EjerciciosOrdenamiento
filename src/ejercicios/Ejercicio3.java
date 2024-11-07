package ejercicios;

import java.util.ArrayList;

public class Ejercicio3 {
    static ArrayList<Producto> ventas = new ArrayList<>();
    public static void main(String[] args) {
        llenarventas();
        mostrar();
        totalizarVentas();


    }
    public static void llenarventas(){
        for(int i=0; i<5; i++){
            int codigo= (int) (Math.random() *1999 +1000);
            int cantidad= (int) (Math.random() *100);
            long precio= (int) (Math.random() *2000);

            ventas.add(new Producto(codigo,cantidad,precio));

            //para aumentar la probabilidad de que se repita un codigo
            if (Math.random() < 0.5) {
                int nuevaCantidad = (int) (Math.random() * 100);
                ventas.add(new Producto(codigo, nuevaCantidad, precio));
            }
        }
    }

    public static void mostrar(){
        System.out.printf("%-10s %-10s %-10s\n", "código", "cantidad", "precio");

        for (Producto producto : ventas) {
            System.out.printf("%-10d %-10d %-10d\n", producto.getCodigo(), producto.getCantidad(), producto.getPrecio());
        }

    }

    public static void totalizarVentas() {
        ArrayList<Producto> totalizada = new ArrayList<>();

        while (!ventas.isEmpty()) {
            Producto actual = ventas.remove(0);
            int totalCantidad = actual.getCantidad();
            long totalPrecio = actual.getPrecio();
            int conteo = 1;

            for (int i = 0; i < ventas.size(); i++) {
                Producto siguiente = ventas.get(i);
                if (actual.getCodigo() == siguiente.getCodigo()) {
                    totalCantidad += siguiente.getCantidad();
                    totalPrecio += siguiente.getPrecio();
                    conteo++;
                    ventas.remove(i);
                    i--; // Ajustar el índice después de eliminar un elemento
                }
            }


            long precioPromedio = totalPrecio / conteo;
            totalizada.add(new Producto(actual.getCodigo(), totalCantidad, precioPromedio));
        }

        ordenamientoPorSeleccion(totalizada);
        System.out.println("ventas totalizada:");
        System.out.printf("%-10s %-10s %-10s\n", "código", "cantidad", "precio promedio");
        for (Producto producto : totalizada) {
            System.out.printf("%-10d %-10d %-10d\n", producto.getCodigo(), producto.getCantidad(), producto.getPrecio());
        }


    }
    public static void ordenamientoPorSeleccion(ArrayList<Producto> lista) {
        int n = lista.size();

        for (int i = 0; i < n - 1; i++) {
            int indiceMin = i;
            for (int j = i + 1; j < n; j++) {
                if (lista.get(j).getCodigo() < lista.get(indiceMin).getCodigo()) {
                    indiceMin = j;
                }
            }
            // Intercambiar el elemento mínimo encontrado con el elemento en la posición i
            Producto temp = lista.get(indiceMin);
            lista.set(indiceMin, lista.get(i));
            lista.set(i, temp);
        }
        
    }
}

