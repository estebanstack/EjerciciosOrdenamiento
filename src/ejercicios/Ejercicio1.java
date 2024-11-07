package ejercicios;
import java.util.Scanner;

public class Ejercicio1 {
    static int[] codigo = new int[4];
    static double[][] notas = new double[4][4];
    static String[] nombres = new String[4];

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        llenarDatos(codigo, notas, nombres);
        mostrarDatos(codigo,nombres,notas);
        ordenamientoPorSeleccion(codigo, nombres,notas);
        System.out.println("Organizado por codigo");
        mostrarDatos(codigo,nombres,notas);

        System.out.println("Ingrese el codigo del estudiante que quiere ver: ");
        int code=sc.nextInt();
        System.out.println(busquedaBinaria(codigo,nombres,notas,code));





    }

    public static void llenarDatos(int[] codigo, double[][] notas, String[] nombre) {
        for (int i = 0; i < 4; i++) {
            codigo[i] = (int) (Math.random() * 1999 +1000 );
            nombre[i] = "est" + (i + 1);
            for (int j = 0; j < 4; j++) {
                notas[i][j] = Math.random() * 5.0;

            }
            notas[i][3] = (notas[i][0] * 0.3) + (notas[i][1] * 0.3) + (notas[i][2] * 0.4);
        }
    }

    public static void ordenamientoPorSeleccion(int[] codigo, String[] nombre, double[][] notas) {
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
            double[] tempNotas = notas[i];

            codigo[i] = codigo[indiceMinimo];
            nombre[i] = nombre[indiceMinimo];
            notas[i] = notas[indiceMinimo];

            codigo[indiceMinimo] = tempC;
            nombre[indiceMinimo] = tempN;
            notas[indiceMinimo] = tempNotas;
        }
    }



    public static String busquedaBinaria(int[] codigo, String[] nombre, double[][] notas, int objetivo) {
        int izquierda = 0;
        int derecha = codigo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (codigo[medio] == objetivo) {
                StringBuilder notasStr = new StringBuilder();
                for (double nota : notas[medio]) {
                    notasStr.append(String.format("%.2f ", nota));
                }
                return String.format("Código: %d, Nombre: %s, Notas: %s",
                        codigo[medio], nombre[medio], notasStr.toString().trim());
            }
            if (codigo[medio] < objetivo) {
                izquierda = medio + 1;
            }
            else {
                derecha = medio - 1;
            }
        }

        // Si el objetivo no está en el arreglo, se retorna un mensaje indicándolo
        return "Código no encontrado.";
    }
    public static void mostrarDatos(int[] codigo, String[] nombre, double[][] notas) {
        System.out.printf("%-10s %-15s %-20s%n", "Código", "Nombre", "Notas");

        for (int i = 0; i < codigo.length; i++) {
            // Convertimos las notas de cada estudiante a una cadena para mostrar
            StringBuilder notasStr = new StringBuilder();
            for (double nota : notas[i]) {
                notasStr.append(String.format("%.2f ", nota));
            }

            // Imprimimos cada fila
            System.out.printf("%-10d %-15s %-20s%n", codigo[i], nombre[i], notasStr.toString().trim());
        }
    }



}