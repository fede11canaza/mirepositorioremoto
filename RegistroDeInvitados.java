import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RegistroDeInvitados {
    private Set <String> invitados;

    public RegistroDeInvitados(){
        invitados = new HashSet<>();
    }

    //Método para agragar un invitado al HashnetSet
    public void agregarInvitado(String nombreInvitado){
        // Asegurarse que siempre se guarden con el mismo formato
        String nombreFormateado = nombreInvitado.trim().toLowerCase();
        invitados.add(nombreFormateado);
        System.out.println("Invitado agregado: " + nombreFormateado);
    }

    //Método para eliminar un invitado del HashSet, si existe
    public void eliminarInvitado(String nombreInvitado){
        //Asegurarse que siempre se guarden con el mismo formato
        String nombreFormateado = nombreInvitado.trim().toLowerCase();
        if (invitados.contains(nombreFormateado)){
            invitados.remove(nombreFormateado);
            System.out.println("Invitado eliminado: " + nombreFormateado);
        }else{
            System.out.println("El invitado no está en la lista.");
        }
    }

    //Método para mostrar la lista actual de invitados
    public void mostrarInvitados(){
        if (invitados.isEmpty()){
            System.out.println("No hay invitados en la lista.");
        }else{
            System.out.println("Lista de invitados: ");
            for (String invitado: invitados)
            System.out.println("- " + invitado);
        }
    }

    public static void main(String[] args) {
        RegistroDeInvitados registro= new RegistroDeInvitados();
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\nMenú");
            System.out.println("1. Agregar Invitado");
            System.out.println("2. Borrar Invitado");
            System.out.println("3. Mostrar invitados");
            System.out.println("4. Salir");
            System.out.println("Selecciona una Opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingrese el nombre del invitado a agregrar:");
                    String nuevoInvitado = scanner.nextLine();
                    registro.agregarInvitado(nuevoInvitado);                    
                    break;
                
                case "2":
                    System.out.println("Ingrese el nombre del invitado a eliminar");
                    String invitadoEliminar = scanner.nextLine();
                    registro.eliminarInvitado(invitadoEliminar);
                    break;
                
                case "3":
                    registro.mostrarInvitados();
                    break;
                
                case "4":
                    System.out.println("¡Hasta Luego!");
                    break;
            
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (!opcion.equals("4"));
        
        scanner.close();        
    }
}