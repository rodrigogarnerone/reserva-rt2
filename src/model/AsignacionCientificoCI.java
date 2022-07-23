package model;

import java.util.ArrayList;

public class AsignacionCientificoCI
{
    private String fechaDesde;
    private String fechaHasta;
    public PersonalCientifico personalCientifico;

    public ArrayList<Turno> turnos;

    public AsignacionCientificoCI(PersonalCientifico thePersonalCientifico) {
        this.personalCientifico = thePersonalCientifico;
        turnos = new ArrayList<>();
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public void setPersonalCientifico(PersonalCientifico personalCientifico) {
        this.personalCientifico = personalCientifico;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public PersonalCientifico getPersonalCientifico() {
        return personalCientifico;
    }

    public void misTurnos() {

    }

    public boolean esCientificoActivo(PersonalCientifico cientificoEnSesion) {
        return fechaHasta == null && personalCientifico.equals(cientificoEnSesion);
    }

    public boolean asignarNuevoTurnoACientifico(Turno turnoSeleccionado) {
        return turnos.add(turnoSeleccionado);
    }
}
