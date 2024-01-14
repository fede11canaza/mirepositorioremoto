import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GestorDeTareas {
    private Set<String> tareasPendientes;

    public GestorDeTareas(){
        tareasPendientes = new HashSet<>();
    }

    //Método para agregar una tarea al HashSet
    public void agregarTarea(String tarea){
        tareasPendientes.add(tarea);
        System.out.println("Tarea agregada: " + tarea);
    }

    //Método para eliminar una tarea del HashSet
    public void eliminiarTarea(String tarea){
        if (tareasPendientes.contains(tarea)){
            tareasPendientes.remove(tarea);
            System.out.println("Tarea eliminada: " + tarea);
        }else{
            System.out.println("La tarea no existe en la lista.");
        }
    }

    //Método para mostrar la lista actual de tareas pendientes
    public void mostrarTareas(){
        if (tareasPendientes.isEmpty()){
            System.out.println("No hay tareas pendientes en la lista.");
        }else{
            System.out.println("Lista de tareas pendientes");
            for (String tarea : tareasPendientes){
                System.out.println("-" + tarea);
            }
        }
    }
    public static void main(String[] args) {
        GestorDeTareas gestor = new GestorDeTareas();
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println(" \nMenú");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Mostrar tarea");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingrese la descripción de la tarea a agregar");
                    String nuevaTarea = scanner.nextLine();
                    gestor.agregarTarea(nuevaTarea);
                    break;
                
                case "2":
                    System.out.println("Ingrese la descripción de la tarea a eliminar: ");
                    String tareaEliminar = scanner.nextLine();
                    gestor.eliminiarTarea(tareaEliminar);
                    break;
                
                case "3":
                    gestor.mostrarTareas();
                    break;
                
                case "4":
                    System.out.println("¡Hasta luego!");
                    break;       
            
                default:
                    System.out.println("Opción no válida. Intentelo de nuevo");                    
            }

        } while (!opcion.equals("4"));

        scanner.close();     
    }
}