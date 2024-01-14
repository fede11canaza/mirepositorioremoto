import java.util.ArrayList;

public class Turnero {
    public static void main(String[] args) {
        // Crear un ArrayList para almacenar los números de turnos
        ArrayList <Integer> turnos = new ArrayList<>();

        //Emular la llegada de clientes y asignación de turnos
        asignarTurnos(turnos,1);
        asignarTurnos(turnos,2);
        asignarTurnos(turnos,3);
        asignarTurnos(turnos,4);
        asignarTurnos(turnos,5);
        asignarTurnos(turnos,6);

        //Mostrar la lista de turnos
        System.out.println("Lista de turnos: " + turnos);

        //Simular sorteo y atención inmediata
        int numeroSorteado = sortearTurno(turnos.size());
        System.out.println("Número sorteado: " + numeroSorteado);

        //Atender al cliente sorteado
        atenderCliente(turnos, numeroSorteado);

        //Mostrar la lista actualizada de turnos
        System.out.println("Lista de turnos después del sorteo: " + turnos);
    }

     // Método para asignar un turno
    public static void asignarTurnos(ArrayList<Integer> turnos, int numeroTurno) {
        turnos.add(numeroTurno);
    }

    //Método para realizar un sorteo y obtener un número aleatorio
    public static int sortearTurno(int cantidadTurnos){
        return (int) (Math.random()* cantidadTurnos)+1;
    }

    //Método para atender a un cliente según el número del turno sorteado
    public static void atenderCliente(ArrayList<Integer> turnos, int numeroSorteado){
        int indice = turnos.indexOf(numeroSorteado);
        if (indice != -1){
            System.out.println("Atendiendo al cliente con el turno: " + numeroSorteado);
            turnos.remove(indice);
        }else{
            System.out.println("El turno sorteado no está en la lista");
        }
    }
}