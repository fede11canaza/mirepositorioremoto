import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

class Contacto{
    private String nombre;
    private String telefono;
    private String correo;    
    
    public Contacto (String nombre, String telefono, String correo){
        this.nombre = nombre;
        this.telefono = telefono;    
        this.correo = correo;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return Objects.equals(nombre, contacto.nombre);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }

    @Override
    public String toString(){
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}

class GestorDeContactos{
    private ArrayList <Contacto> listaContactosArrayList;
    private HashSet <Contacto> conjuntoContactosHashSet;

    public GestorDeContactos(){
        listaContactosArrayList = new ArrayList<>();
        conjuntoContactosHashSet = new HashSet<>();
    }

    //Método para ArraysList
    public void agregarContactoArrayList(Contacto contacto){
        if (!listaContactosArrayList.contains(contacto)){
            listaContactosArrayList.add(contacto);
            System.out.println("Contacto agregado (ArrayList): " + contacto);
        }else{
            System.out.println("El contacto ya está en la lista (ArrayList).");
        }
    }

    public void eliminarContactoArrayList(String nombre){
        Contacto contactoEliminar = new Contacto(nombre, " ", " ");
        if (listaContactosArrayList.contains(contactoEliminar)){
        listaContactosArrayList.remove(contactoEliminar);
        System.out.println("Contacto eliminado (ArrayList): " + contactoEliminar);
        }else{
            System.out.println("El contacto no está en la lista (ArrayList).");
        }             
    }

    // Métodos para HashSet
    public void agregarContactoHashSet(Contacto contacto){
        if (!conjuntoContactosHashSet.add(contacto)){
            System.out.println("Contacto agregado (HashSet): " + contacto);
        }else{
            System.out.println("El contacto ya está en la lista (HashSet).");
        }
    }

    public void eliminarContactoHashSet(String nombre){
        Contacto contactoEliminar = new Contacto(nombre, " ", " ");
        if (conjuntoContactosHashSet.remove(contactoEliminar)){
            System.out.println("Contacto eliminado (HashSet): " + contactoEliminar);
        }else{
            System.out.println("El contacto no está en la lista (HashSet)");
        }
    }

    //Mostrar el contenido de ambas colecciones
    public void mostrarContenido(){
        System.out.println("\nContenido Actual(ArrayList):");
        listaContactosArrayList.forEach(System.out::println);

        System.out.println("\nContenido Actual (HashSet)");
        conjuntoContactosHashSet.forEach(System.out::println);
    }
}

public class MainGestorDeContactos {
    public static void main(String[] args) {
        GestorDeContactos gestor = new GestorDeContactos();
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\nMenú");
            System.out.println("1. Agregar contacto (ArrayList)");
            System.out.println("2. Eliminar contacto (ArrayList)");
            System.out.println("3. Agregar contacto (HashSet)");
            System.out.println("4. Eliminar contacto (HashSet)");
            System.out.println("5. Mostrar contenido");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingrese el nombre del contacto");
                    String nombreAgregarArrayList = scanner.nextLine();
                    Contacto nuevoContactoArrayList = new Contacto(nombreAgregarArrayList, "", "");
                    gestor.agregarContactoArrayList(nuevoContactoArrayList);;                    
                    break;
                
                case "2":
                    System.out.println("Ingrese el nombre del contacto a eliminar: ");
                    String nombreEliminarArrayList = scanner.nextLine();
                    gestor.eliminarContactoArrayList(nombreEliminarArrayList);
                    break;
                
                case "3":
                    System.out.println("Ingesa el nombre del contacto");
                    String nombreAgregarHashSet = scanner.nextLine();
                    Contacto nuevoContactoHashSet = new Contacto(nombreAgregarHashSet, " ", " ");
                    gestor.agregarContactoHashSet(nuevoContactoHashSet);
                    break;

                case "4":
                    System.out.println("Ingrese el nombre del contacto a eliminar: ");
                    String nombreEliminarHashSet = scanner.nextLine();
                    gestor.eliminarContactoHashSet(nombreEliminarHashSet);
                    break;
                
                case "5":
                    gestor.mostrarContenido();
                    break;
                    
                case "6":
                    System.out.println("¡Hasta Luego!");
                    break;

                default:
                    System.out.println("Opción no válida: Intentelo de nuevo.");
            }
        } while (!opcion.equals("6"));
        scanner.close();       
    }
}