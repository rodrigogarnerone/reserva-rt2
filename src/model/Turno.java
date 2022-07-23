//Source file: C:\\Users\\rodri\\Desktop\\Nueva carpeta\\Turno.java
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Turno
{
    private String fechaGeneracion;
    private String diaSemana;
    private String fechaHoraInicio;
    private String fechaHoraFin;
    public ArrayList<CambioEstadoTurno> cambiosEstadoTurno;

    public Turno(String fechaGeneracion, String diaSemana, String fechaHoraInicio, String fechaHoraFin, ArrayList<CambioEstadoTurno> cambioEstadoTurno) {
        this.fechaGeneracion = fechaGeneracion;
        this.diaSemana = diaSemana;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.cambiosEstadoTurno = cambioEstadoTurno;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(String fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(String fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public ArrayList<CambioEstadoTurno> getCambiosEstadoTurno() {
        return cambiosEstadoTurno;
    }

    public void setCambioEstadoTurno(ArrayList<CambioEstadoTurno> cambioEstadoTurno) {
        this.cambiosEstadoTurno = cambioEstadoTurno;
    }



    public boolean estoyDisponible()
    {
        for (CambioEstadoTurno cambioEstado :cambiosEstadoTurno){
            if(cambioEstado.esActual()){
               if(!(cambioEstado.getEstado().esReservado())){
                    return true;
               }
            }
        }
        return false;
    }

    public boolean esPosteriorAFechaActual(String fechaActualString) {
        ManejadorFechas fechas = new ManejadorFechas();
        LocalDateTime fechaTurno =  fechas.stringToLocalDateTime(fechaHoraInicio);
        LocalDateTime fechaActual = fechas.stringToLocalDateTime(fechaActualString);
        return fechaActual.isBefore(fechaTurno);
    }

    public String[] mostrarTurno() {
        String estado = null;
        for (CambioEstadoTurno cambioEstado :cambiosEstadoTurno){
            if(cambioEstado.esActual()){
                estado = cambioEstado.getEstadoString();
            }
        }
        return new String[]{diaSemana,fechaHoraInicio,fechaHoraFin,estado,""};
    }

    public boolean reservarTurno(Estado estadoReservado, String fechaActual) {
        for(CambioEstadoTurno cambioEstadoTurno :cambiosEstadoTurno){
            if(cambioEstadoTurno.esActual()){
                cambioEstadoTurno.finalizar(fechaActual);
            }
        }
        return cambiosEstadoTurno.add(new CambioEstadoTurno(fechaActual, estadoReservado));
    }
}