//Source file: C:\\Users\\rodri\\Desktop\\Nueva carpeta\\RecursoTecnologico.java
package model;

import java.util.ArrayList;
import java.util.Collections;

public class RecursoTecnologico
{
    private int numeroRT;
    private String fechaAlta;
    private String periodicidadMantinimientoPrev;
    private int durecionMantenimientoPrev;
    private int fraccionHorarioTurnos;
    public CentroInvestigacion centroInvestigacion;
    public ArrayList<HorarioRT> disponibilidad;
    public ArrayList<Mantenimiento> mantenimientos;
    public Modelo modelo;
    public TipoRecursoTecnologico tipoRecursoTecnologico;
    public ArrayList<CaracteristicaRecurso> caracteristicasRecurso;
    public ArrayList<CambioEstadoRT> cambiosEstadoRT;
    public ArrayList<Turno> turnos;

    public RecursoTecnologico(int num,TipoRecursoTecnologico tipoRT,Modelo model,ArrayList<CambioEstadoRT> cambiosERT,ArrayList<Turno> turnos) {
        this.numeroRT = num;
        this.tipoRecursoTecnologico = tipoRT;
        this.modelo = model;
        this.cambiosEstadoRT = cambiosERT;
        this.turnos = turnos;
    }

    public int getNumeroRT() {
        return numeroRT;
    }

    public void setNumeroRT(int numeroRT) {
        this.numeroRT = numeroRT;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getPeriodicidadMantinimientoPrev() {
        return periodicidadMantinimientoPrev;
    }

    public void setPeriodicidadMantinimientoPrev(String periodicidadMantinimientoPrev) {
        this.periodicidadMantinimientoPrev = periodicidadMantinimientoPrev;
    }

    public int getDurecionMantenimientoPrev() {
        return durecionMantenimientoPrev;
    }

    public void setDurecionMantenimientoPrev(int durecionMantenimientoPrev) {
        this.durecionMantenimientoPrev = durecionMantenimientoPrev;
    }

    public int getFraccionHorarioTurnos() {
        return fraccionHorarioTurnos;
    }

    public void setFraccionHorarioTurnos(int fraccionHorarioTurnos) {
        this.fraccionHorarioTurnos = fraccionHorarioTurnos;
    }

    public CentroInvestigacion getCentroInvestigacion() {
        return centroInvestigacion;
    }

    public void setCentroInvestigacion(CentroInvestigacion centroInvestigacion) {
        this.centroInvestigacion = centroInvestigacion;
    }

    public ArrayList<HorarioRT> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(ArrayList<HorarioRT> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public ArrayList<Mantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(ArrayList<Mantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public TipoRecursoTecnologico getTipoRecursoTecnologico() {
        return tipoRecursoTecnologico;
    }

    public void setTipoRecursoTecnologico(TipoRecursoTecnologico tipoRecursoTecnologico) {
        this.tipoRecursoTecnologico = tipoRecursoTecnologico;
    }

    public ArrayList<CaracteristicaRecurso> getCaracteristicasRecurso() {
        return caracteristicasRecurso;
    }

    public void setCaracteristicasRecurso(ArrayList<CaracteristicaRecurso> caracteristicasRecurso) {
        this.caracteristicasRecurso = caracteristicasRecurso;
    }

    public ArrayList<CambioEstadoRT> getCambiosEstadoRT() {
        return cambiosEstadoRT;
    }

    public void setCambiosEstadoRT(ArrayList<CambioEstadoRT> cambiosEstadoRT) {
        this.cambiosEstadoRT = cambiosEstadoRT;
    }

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(ArrayList<Turno> turnos) {
        this.turnos = turnos;
    }





    public void habilitar()
    {

    }

    /**
     * @roseuid 5B2720CA0203
     */
    public void conocerCategoria()
    {

    }

    /**
     * @roseuid 5B2720CF00DA
     */
    public void conocerCaracteristicaRecurso()
    {

    }

    /**
     * @roseuid 5B2720E40128
     */
    public void miModeloMarca()
    {

    }

    /**
     * @roseuid 5B2720EF0290
     */
    public void nuevoManteinimientoPreventivo()
    {

    }

    /**
     * @roseuid 5B2720FD033C
     */
    public void misTurnosDisponibles()
    {

    }

    public boolean esDeTipo(TipoRecursoTecnologico tipoRTseleccionado) {
        return tipoRecursoTecnologico.equals(tipoRTseleccionado);
    }

    public boolean esActivo() {
        int posicionUltimoCambioEstado = -1;
        boolean esUltimoyActivo = false;
        for(int i = 0; i < cambiosEstadoRT.size(); i++){
            if(cambiosEstadoRT.get(i).esActual()){
                posicionUltimoCambioEstado = i;
                if(cambiosEstadoRT.get(i).esEstadoActualReservable()){
                    esUltimoyActivo = true;
                }
            }
        }
        //System.out.println("posicionUltimoCambioEstado = "+posicionUltimoCambioEstado);
        if(cambiosEstadoRT.size()-1 != posicionUltimoCambioEstado){
            Collections.swap(cambiosEstadoRT, posicionUltimoCambioEstado, cambiosEstadoRT.size()-1);
            //System.out.println("NO ESTABA EN LA ULTIMA POSICION, POR ESO ME POSICIONE EN LA ULTIMA");
        }
        return esUltimoyActivo;
    }

    public String[] mostrarRT() {
        String estado = cambiosEstadoRT.get(cambiosEstadoRT.size()-1).getNombreEstado();
        String centro = mostrarCentroDeInvestigacion();
        String[] marcaModelo = mostrarMarcaYModelo();
        String numInventario = String.valueOf(numeroRT);
        return new String[]{centro,numInventario,marcaModelo[1],marcaModelo[0],estado};
    }

    private String mostrarCentroDeInvestigacion() {
        return centroInvestigacion.getCentroInvestigacion();
    }

    private String[] mostrarMarcaYModelo() {
        return modelo.getMarcaYModelo();
    }

    public AsignacionCientificoCI cientificoPerteneceAMiCentroDeInvestigacion(PersonalCientifico cientificoEnSesion) {
        return centroInvestigacion.esCientificoActivo(cientificoEnSesion);
    }

    public ArrayList<String[]> mostrarTurnos(String fechaActual) {
        ArrayList<String[]> turnosString = new ArrayList<>();
        for(Turno turno :turnos){
            if(turno.esPosteriorAFechaActual(fechaActual)){
                String[] turnoString = turno.mostrarTurno();
                turnoString[4] = String.valueOf(turnos.indexOf(turno));
                turnosString.add(turnoString);
            }
        }
        return turnosString;
    }

    public Boolean registrarReserva(Turno turnoSeleccionado, Estado estadoReservado, String fechaActual, CambioEstadoTurno ultimoCambioEstadoTurno, AsignacionCientificoCI asignacionCientifico) {
        return turnoSeleccionado.reservarTurno(estadoReservado, fechaActual, ultimoCambioEstadoTurno) && turnoSeleccionado.asignarNuevoTurno(asignacionCientifico);
    }
}