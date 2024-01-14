import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrdenDeMerito {
    public static void main(String[] args) {
        //Paso 1: Inicializar ArrayList
        ArrayList<Integer> notas = new ArrayList<>();

        // Paso 2: Solicitar al usuario ingresar números enteros
        Scanner scanner = new Scanner (System.in);
    
        String respuestas;

        do {
            System.out.println("Ingrese una nota (entre 1 y 10): ");
            int nota = scanner.nextInt();

            //Validar que la nota sea entre 1 y 10 rango permitido
            if (nota >=1 && nota <= 10){
                // Paso 3: Agregar notas al ArrayList
                notas.add(nota);
            }else{
                System.out.println("La nota ingresa no está dentro del rando del 1 al 10");
            }

            //Consumir la nueva línea en el buffer del scanner
            scanner.nextLine();

            System.out.println("¿Quieres agregar otra nota?(Si/No): ");
            respuestas = scanner.nextLine().toLowerCase();
        } while (respuestas.equals("si"));

        //Paso 4: Ordenar la lista de forma descendente
        Collections.sort(notas, Collections.reverseOrder());

        //Paso 5: Imprimir por pantalla la lista ordenada en orden ascedente
        System.out.println("Lista ordenada en orden descendente: ");
        for (int nota: notas){
            System.out.println(nota);
        }

        //Imprimir por pantalla la lista ordenada en orden descendente
        System.out.println("Lista en orden en orden ascendente: ");
        for (int i= notas.size() -1; i >= 0; i--){
            System.out.println(notas.get(i));
        }

        //Cerrar el scanner para evitar posibles fugas de recursos
        scanner.close();
    }
}