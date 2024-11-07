package ejercicios;

import java.util.Scanner;

public class Ejercicio2 {
    static int[] id = new int[4];
    static long[][] sueldo = new long[4][3];
    static String[] nombres = new String[4];

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        llenarDatos(id, sueldo, nombres);
        mostrarDatos(id,nombres, sueldo);
        ordenamientoPorSeleccion(id, nombres,sueldo);
        System.out.println("Organizado por id");
        mostrarDatos(id,nombres,sueldo);

        System.out.println("Ingrese el codigo del empleado que quiere ver: ");
        int code=sc.nextInt();
        System.out.println(busquedaBinaria(id,nombres,sueldo,code));





    }

    public static void llenarDatos(int[] codigo, long[][] sueldo, String[] nombre) {
        for (int i = 0; i < 4; i++) {
            codigo[i] = (int) (Math.random() * 1999 +1000 );
            nombre[i] = "empleado" + (i + 1);
            sueldo[i][0] = (long) (Math.random() * 200000 + 100000);
            sueldo[i][1] = (long) (Math.random() * sueldo[i][0]);
            sueldo[i][2] = sueldo[i][0] - sueldo[i][1];
        }
    }

    public static void ordenamientoPorSeleccion(int[] codigo, String[] nombre, long[][] sueldo) {
        int n = codigo.length;
        for (int i = 0; i < n; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (codigo[j] < codigo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int tempC = codigo[i];
            String tempN = nombre[i];
            long[] tempNotas = sueldo[i];

            codigo[i] = codigo[indiceMinimo];
            nombre[i] = nombre[indiceMinimo];
            sueldo[i] = sueldo[indiceMinimo];

            codigo[indiceMinimo] = tempC;
            nombre[indiceMinimo] = tempN;
            sueldo[indiceMinimo] = tempNotas;
        }
    }



    public static String busquedaBinaria(int[] codigo, String[] nombre, long[][] sueldo, int objetivo) {
        int izquierda = 0;
        int derecha = codigo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (codigo[medio] == objetivo) {
                StringBuilder sueldoStr = new StringBuilder();
                for (long sueldito : sueldo[medio]) {
                    sueldoStr.append(sueldito).append(" ");
                }
                return String.format("Código: %d, Nombre: %s, Sueldo: %s",
                        codigo[medio], nombre[medio], sueldoStr.toString().trim());
            }

            if (codigo[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        // Si el objetivo no está en el arreglo, se retorna un mensaje indicándolo
        return "Código no encontrado.";
    }


    public static void mostrarDatos(int[] codigo, String[] nombre, long[][] sueldo) {
        System.out.printf("%-10s %-15s %-20s%n", "Código", "Nombre", "Sueldo");

        for (int i = 0; i < codigo.length; i++) {
            StringBuilder sueldoStr = new StringBuilder();
            for (long s : sueldo[i]) {
                sueldoStr.append(String.format("%d ", s));
            }

            System.out.printf("%-10d %-15s %-20s%n", codigo[i], nombre[i], sueldoStr.toString().trim());
        }
    }
}
