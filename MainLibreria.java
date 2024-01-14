import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Libro {
    private String titulo;
    private String autor;
    private String isbn;    
    
    public Libro (String titulo,String autor, String isbn) {
        this.titulo=titulo;
        this.autor=autor;
        this.isbn=isbn;
    }

    public String getIsbn(){
        return isbn;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if  (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode(){
        return Objects.hash(isbn);
    }

    @Override
    public String toString(){
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

class Libreria{
    private Set<Libro> catalogo;

    public Libreria(){
        catalogo = new HashSet<>();
    }

    //Método para agregar un libro al catálogo
    public void agregarLibro(Libro libro){
        if (catalogo.contains(libro)){
            System.out.println("El libro ya está en el catálogo.");
        }else{
            catalogo.add(libro);
            System.out.println("Libro agregado al catálogo: " + libro);
        }
    }

    //Método para eliminar un libro del catálogo por número de ISBN
    public void eliminarLibro(String isbn){
        Libro libroEliminar = new Libro(" ", " ", isbn);
        if (catalogo.contains(libroEliminar)){
            catalogo.remove(libroEliminar);
            System.out.println("Libro eliminado del catálogo: " + libroEliminar);
        }else{
            System.out.println("El libro ISBN: " + isbn + "no está en el catálogo.");
        }
    }

    //Método para mostrar el catálogo actual
    public void mostrarCalalogo(){
        if (catalogo.isEmpty()){
            System.out.println("El catálogo está vacío.");
        }else{
            System.out.println("Catálogo de libreria: ");
            for (Libro libro : catalogo) {
                System.out.println(libro);                
            }
        }
    }
}


public class MainLibreria {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\nMenú");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Mostrar catálogo");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción: ");
            opcion= scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingrese el título del libro");
                    String titulo = scanner.nextLine();
                    System.out.println("Ingrese el nombre del autor del libro");
                    String autor = scanner.nextLine();
                    System.out.println("Ingrese el ISBN del libro");
                    String isbn = scanner.nextLine();
                    Libro libro = new Libro(titulo, autor, isbn);
                    libreria.agregarLibro(libro);                    
                    break;

                case "2":
                    System.out.println("Ingrese el nro de ISBN a eliminar ");
                    String isbnEliminar = scanner.nextLine();
                    libreria.eliminarLibro(isbnEliminar);
                    break;

                case "3":
                    libreria.mostrarCalalogo();
                    break;

                case "4":
                    System.out.println("¡Hasta luego!");
                    break;
            
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (!opcion.equals("4"));
        
        scanner.close();
    }
}