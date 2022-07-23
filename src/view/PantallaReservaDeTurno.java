package view;

import controller.ControlReservaDeTurno;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PantallaReservaDeTurno {
    Scanner scanner;
    public PantallaReservaDeTurno (){
        scanner = new Scanner(System.in);
    }

    public void opReservarTurnoRT(ControlReservaDeTurno control){
        control.nuevaReservaDeTurno(this);
    }

    public int solicitarSeleccionarTipoRT(ArrayList<String> tiposRT) {
        System.out.println("\n");
        for(int i = 0 ; i < tiposRT.size() ; i++){
            System.out.println((i + 1) + "-" + tiposRT.get(i));
        }
        System.out.println("\nSELECCIONE UN TIPO DE RECURSO TECNOLOGICO:");
        return seleccionarTipoRT(scanner.nextInt());
    }

    public int seleccionarTipoRT(int seleccion){
        return seleccion-1;
    }

    public int pedirSeleccionRT(ArrayList<ArrayList<String[]>> rTsDeTipoActivos) {
        int i = 1;
        for(String[] centro :rTsDeTipoActivos.get(0)){
            System.out.println("\nCentro de Investigacion: "+centro[0]);
            for (String[] rt :rTsDeTipoActivos.get(1)){
                if (Objects.equals(centro[0], rt[0])){
                    System.out.println("\n  Recurso tecnologico ("+i+"):");
                    i++;
                    System.out.println("    Numero de inventario: " + rt[1]);
                    System.out.println("    Marca:  " + rt[2]);
                    System.out.println("    Modelo: " + rt[3]);
                    System.out.println("    Estado: " + rt[4]);
                }
            }
        }
        System.out.println("\nSELECCIONE UN RECURSO TECNOLOGICO (POR NUMERO DE INVENTARIO):");
        return seleccionarRT(scanner.nextInt());
    }

    private int seleccionarRT(int seleccion) {
        return seleccion;
    }

    public int pedirSeleccionTurno(ArrayList<String[]> turnosString) {
        int i = 1;
        for(String[] turno :turnosString){
            System.out.println("\n  Turno Nro. "+i+":");
            i++;
            System.out.println("    Para el día: " + turno[0]);
            System.out.println("    Fecha y hora de inicio:  " + turno[1]);
            System.out.println("    Fecha y hora de finalización: " + turno[2]);
            System.out.println("    Estado de turno: " + turno[3]);
        }
        System.out.println("\nSELECCIONE UN TURNO:");
        return seleccionarTurno(scanner.nextInt());
    }

    private int seleccionarTurno(int seleccion) {
        return seleccion-1;
    }

    public void error(String s) {
        System.out.println("\n-------------------------------------------------");
        System.out.println("\nERROR: " + s);
        System.out.println("\n-------------------------------------------------");
    }

    public void msg(String s) {
        System.out.println("\n-------------------------------------------------");
        System.out.println("\nMENSAJE: " + s);
        System.out.println("\n-------------------------------------------------");
    }


    public int solicitarFormaNotificacion() {
        System.out.println("\nNOTIFICACIÓN: (0 - mail, 1 - Whatsapp, 2 - ambos) ");
        System.out.println("\nSeleccione opción: ");
        return seleccionarFormaNotificacion(scanner.nextInt());
    }

    private int seleccionarFormaNotificacion(int opcion) {
        return opcion;
    }

    public int solicitarConfirmacionReserva(String[] rtSeleccionadoString, String[] turnoSeleccionadoString) {
        System.out.println("\nDATOS PARA LA RESERVA: ");
        System.out.println("\nRECURSO: ");
        System.out.println("    Numero de inventario: " + rtSeleccionadoString[1]);
        System.out.println("    Marca:  " + rtSeleccionadoString[2]);
        System.out.println("    Modelo: " + rtSeleccionadoString[3]);
        System.out.println("    Estado: " + rtSeleccionadoString[4]);
        System.out.println("\nTURNO: ");
        System.out.println("    Para el día: " + turnoSeleccionadoString[0]);
        System.out.println("    Fecha y hora de inicio:  " + turnoSeleccionadoString[1]);
        System.out.println("    Fecha y hora de finalización: " + turnoSeleccionadoString[2]);
        System.out.println("    Estado de turno: " + turnoSeleccionadoString[3]);
        System.out.println("\n¿CONFIRMAR? (0 – No, 1 – Si)");
        System.out.println("\nSeleccione opción: ");
        return confirmarReserva(scanner.nextInt());
    }

    private int confirmarReserva(int opcion) {
        return opcion;
    }
}
