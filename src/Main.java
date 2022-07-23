import controller.ControlReservaDeTurno;
import model.GeneradorObjetos;
import view.PantallaReservaDeTurno;

public class Main {
    public static void main(String[] args) {
        GeneradorObjetos generador = new GeneradorObjetos();
        generador.generarTodosObjetos();

        ControlReservaDeTurno control = new ControlReservaDeTurno();
        PantallaReservaDeTurno pantalla = new PantallaReservaDeTurno();

        control.setGenerador(generador);

        System.out.println("\nInicio del CU:");
        while(true){
            pantalla.opReservarTurnoRT(control);
        }
    }
}