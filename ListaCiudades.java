import java.util.ArrayList;
import java.util.Scanner;

public class ListaCiudades {
    public static void main(String[] args) {
        //Paso 1: Inicializar Array list
        ArrayList <String> ciudades = new ArrayList<>();

        //Paso 2: Solicitar al usuario ingresar nombres de cuidades
        Scanner scanner = new Scanner(System.in);
        String respuestas;

        do {
            System.out.println("Ingrese el nombre de una ciudad: ");
            String ciudad = scanner.nextLine();

            //Paso 3: Agregar el nombre de la cuidad a la ArrayList
            ciudades.add(ciudad);

            //Preguntar al usuario si desea agregar más ciudades
            System.out.println("¿Quieres agregar otra cuidad? (Si/No): ");
            respuestas = scanner.nextLine().toLowerCase();
        } while (respuestas.equals("si"));

        //Paso 4: Mostrar la lista completa cuidades
        System.out.println("Lista completa de cuidades: ");
        for (String ciudad:ciudades){
            System.out.println(ciudad);
        }

        //Cerrar el scanner para evitar posibles fugas de recursos
        scanner.close();
    }
}