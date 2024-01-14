import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class SopaDeNumeros {
    public static void main(String[] args) {
        // Paso 1: Llamar al método leerValores para obtener el ArrayList
        ArrayList <Integer> numeros = leerValores();

        //Calcular la suma y la media
        int suma = caclcularSuma(numeros);
        double media = calcularPromedio(numeros);

        //Paso 3: Mostrar resultados
        mostrarResultados(numeros,suma, media);
    }

    public static ArrayList <Integer> leerValores(){
        ArrayList <Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner (System.in);

        System.out.println("Ingresa valores numéricos (corta con -99)");
        
        int valor;
        do {
            valor = scanner.nextInt();
            if (valor != -99){
                numeros.add(valor);
            }
        } while (valor != -99);

        return numeros;
    }

    // Método para calcular la suma de los valores en el ArraysList
    public static int caclcularSuma(ArrayList <Integer> numeros){
        int suma = 0;
        Iterator <Integer> iterator = numeros.iterator();
        
        while (iterator.hasNext()) {
            suma += iterator.next();
            
        }
        return suma;
    }

    // Método para calcular la media de los valores en el ArrayList
    public static double calcularPromedio(ArrayList <Integer> numeros){
        int suma = caclcularSuma(numeros);
        return (double) suma / numeros.size();
    }

    // Método para mostrar resultados por pantalla
    public static void mostrarResultados(ArrayList <Integer> numeros, int suma, double media){
        System.out.println("\nResultados:");
        System.out.println("Número de valores leídos: " + numeros.size());
        System.out.println("Suma de los valores: " + suma);
        System.out.println("Media aritmética: " + media);

        int contadorMayoresQueMedia = 0;
        Iterator<Integer> iterator = numeros.iterator();
        while (iterator.hasNext()) {
            int valor = iterator.next();
            System.out.println(valor + " ");
            if (valor > media){
                contadorMayoresQueMedia++;
            }            
        }
        System.out.println("\nNúmero de valores mayores que la media: " + contadorMayoresQueMedia);
    }
}