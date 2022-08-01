package controller;

import model.*;
import view.PantallaReservaDeTurno;

import java.util.ArrayList;

public class ControlReservaDeTurno {
    GeneradorObjetos generador;
    TipoRecursoTecnologico tipoRTseleccionado;
    RecursoTecnologico rtSeleccionado;
    AsignacionCientificoCI asignacionCientifico;
    CambioEstadoTurno ultimoCambioEstadoTurno;
    String fechaActual;
    Turno turnoSeleccionado;
    int opcionesDeNotificacion;

    public void setGenerador(GeneradorObjetos generador) {
        this.generador = generador;
    }

    public Boolean nuevaReservaDeTurno(PantallaReservaDeTurno pantalla) {
        boolean bandera = false;

        //Paso 2-3
        ArrayList<TipoRecursoTecnologico> tiposRT = generador.getTiposRT();
        ArrayList<String> tiposRTStrings = new ArrayList<>();
        for(TipoRecursoTecnologico tipo :tiposRT){
            tiposRTStrings.add(tipo.getNombre());
        }
        int seleccionTipoRT = pantalla.solicitarSeleccionarTipoRT(tiposRTStrings);
        tipoRTSeleccionado(tiposRT.get(seleccionTipoRT));
        //Paso 2-3

        //Paso 4-5
        ArrayList<Estado> estados = generador.getEstados();
        ArrayList<RecursoTecnologico> recursosTecnologicos = generador.getRecursosTecnologicos();
        ArrayList<ArrayList<String[]>> rTsDeTipoActivosStringsAgrupados = buscarRTDeTipoSinDarDeBaja(recursosTecnologicos);//Es un quilombo este metodo pero basicamente recibo listas de String de: [[[centro1],[centro2]],[[recurso1],...,[recursoN]]]
        int seleccionRT = pantalla.pedirSeleccionRT(rTsDeTipoActivosStringsAgrupados);
        for (RecursoTecnologico recurso :recursosTecnologicos){
            if(recurso.getNumeroRT()==seleccionRT){
                rtSeleccionado(recurso);
            }
        }
        //Paso 4-5

        //Paso 6
        PersonalCientifico cientificoEnSesion = generador.getSesion().getCientificoEnSesion();
        asignacionCientifico = verificarCentroDeCinetifico(cientificoEnSesion);
        if(asignacionCientifico == null){
            pantalla.msg("Usted no pertenece a este Centro de Investigacion, se requiere definir tiempo de antelacion de reserva del Centro...");
            return false;
        }
        //Paso 6

        //Paso 7-8
        boolean turnoYaReservado=false;
        buscarFechaActual();
        ArrayList<String[]> turnosString = rtSeleccionado.mostrarTurnos(fechaActual);
        int seleccionTurno = pantalla.pedirSeleccionTurno(turnosString);
        if(!(turnoSeleccionado(Integer.parseInt(turnosString.get(seleccionTurno)[4])))){
            turnoYaReservado = true;
            pantalla.error("\nEl turno seleccionado ya se encuentra reservado, por favor seleccione un turno sin reservar");
        }
        while(turnoYaReservado){
            seleccionTurno = pantalla.pedirSeleccionTurno(turnosString);
            if(turnoSeleccionado(Integer.parseInt(turnosString.get(seleccionTurno)[4]))){
                turnoYaReservado = false;
            }else{
                pantalla.error("\nEl turno seleccionado ya se encuentra reservado, por favor seleccione un turno sin reservar");
            }
        }
        //Paso 7-8

        //Paso 9-10
        int opcionNotificacion = presentarFormasDeNotificacion(pantalla);
        formaNotificacionSeleccionada(opcionNotificacion);
        if(pantalla.solicitarConfirmacionReserva(rtSeleccionado.mostrarRT(),turnoSeleccionado.mostrarTurno())==0){
            return false;
        }
        //Paso 9-10

        //Paso 11
        if(generarReservaTurnoSeleccionado(cientificoEnSesion, estados, pantalla)){
            if(opcionNotificacion == 0 && generarEmail(generador.getInterfazEmail(),cientificoEnSesion, pantalla)){
                bandera = true;
            }
        }
        return finCU(bandera);
        //Paso 11


    }



    public void tipoRTSeleccionado(TipoRecursoTecnologico tipoRTseleccionado) {
        this.tipoRTseleccionado = tipoRTseleccionado;
    }

    private ArrayList<ArrayList<String[]>> buscarRTDeTipoSinDarDeBaja(ArrayList<RecursoTecnologico> recursoTecnologicos) {
        ArrayList<RecursoTecnologico> rTsDeTipoActivos = new ArrayList<>();
        for(RecursoTecnologico recurso :recursoTecnologicos){
            if(recurso.esDeTipo(tipoRTseleccionado) && recurso.esActivo()){
                //System.out.println("SOY DEL TIPO Y ESTOY ACTIVO");
                rTsDeTipoActivos.add(recurso);
            }
        }

        ArrayList<String[]> rTsDeTipoActivosStrings = new ArrayList<>();
        ArrayList<String> centrosInvestigacion1 = new ArrayList<>();
        for(RecursoTecnologico recursoActivo :rTsDeTipoActivos){
            rTsDeTipoActivosStrings.add(recursoActivo.mostrarRT());
            int posicion = centrosInvestigacion1.indexOf(recursoActivo.mostrarRT()[0]);
            if (posicion >= 0) {
                //System.out.println("El elemento " + recursoActivo.mostrarRT()[0] + " está en la lista. En la posición " + posicion);
            }else
                centrosInvestigacion1.add(recursoActivo.mostrarRT()[0]);
        }

        ArrayList<String[]> centrosInvestigacion = new ArrayList<>();//Tuve que hacer esto porque tengo que devolver los mismos elementos en una lista
        for(String centro :centrosInvestigacion1){
            String[] array = {centro};
            centrosInvestigacion.add(array);
        }

        ArrayList<ArrayList<String[]>> rTsDeTipoActivosStringsAgrupados =  new ArrayList<>();
        rTsDeTipoActivosStringsAgrupados.add(centrosInvestigacion);
        rTsDeTipoActivosStringsAgrupados.add(rTsDeTipoActivosStrings);

        return rTsDeTipoActivosStringsAgrupados;
    }
    private void rtSeleccionado(RecursoTecnologico recurso) {
        rtSeleccionado = recurso;
    }

    private AsignacionCientificoCI verificarCentroDeCinetifico(PersonalCientifico cientificoEnSesion) {
        return rtSeleccionado.cientificoPerteneceAMiCentroDeInvestigacion(cientificoEnSesion);
    }

    private void buscarFechaActual() {
        fechaActual = "21/06/2022 13:00:00";
    }

    private boolean turnoSeleccionado(int seleccionTurno) {
        ultimoCambioEstadoTurno = rtSeleccionado.turnos.get(seleccionTurno).estoyDisponible();
        if( ultimoCambioEstadoTurno != null){
            turnoSeleccionado = rtSeleccionado.turnos.get(seleccionTurno);
            return true;
        }
        return false;
    }
    private void formaNotificacionSeleccionada(int opcion) {
        opcionesDeNotificacion = opcion;
    }

    private int presentarFormasDeNotificacion(PantallaReservaDeTurno pantalla) {
        return pantalla.solicitarFormaNotificacion();
    }
    private boolean generarReservaTurnoSeleccionado(PersonalCientifico cientificoEnSesion, ArrayList<Estado> estados, PantallaReservaDeTurno pantalla) {
        Estado estadoReservado = obtenerEstadoReservado(estados, pantalla);
        return rtSeleccionado.registrarReserva(turnoSeleccionado, estadoReservado, fechaActual, ultimoCambioEstadoTurno, asignacionCientifico);
    }

    private Estado obtenerEstadoReservado(ArrayList<Estado> estados, PantallaReservaDeTurno pantalla) {
        for(Estado estado :estados){
            if(estado.esAmbitoTurno() && estado.esReservado()){
                return estado;
            }
        }
        pantalla.error("No se encontró el Estado Reservado para Turno");
        return null;
    }

    public Boolean generarEmail(InterfazEmail interfazEmail, PersonalCientifico cientificoEnSesion, PantallaReservaDeTurno pantalla){
        if(interfazEmail.enviarMail(cientificoEnSesion.getCorreoElectronicoPersonal(), cientificoEnSesion.getCorreoElectronicoInstitucional(),
                "Usted tiene una nueva reserva.")){
            pantalla.msg("Notificaciones via mail enviadas");
            return true;
        }
        pantalla.error("Notificaciones via mail no pudieron ser enviadas");
        return false;
    }

    private Boolean finCU(boolean bandera) {
        return bandera;
    }

}
