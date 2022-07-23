package model;

import java.util.Objects;

public class Estado
{
    private int ambito;
    private String descripcion;
    private Boolean esCarcelable;
    private Boolean esReservable;
    private String nombre;

    public Estado(String nombre, int ambito) {

        this.nombre = nombre;
        this.ambito = ambito;
    }

    public int getAmbito() { return ambito; }

    public void setAmbito(int ambito) { this.ambito = ambito; }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEsCarcelable() {
        return esCarcelable;
    }

    public void setEsCarcelable(Boolean esCarcelable) {
        this.esCarcelable = esCarcelable;
    }

    public Boolean getEsReservable() {
        return esReservable;
    }

    public void setEsReservable(Boolean esReservable) {
        this.esReservable = esReservable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public boolean esReservable() {
        return Objects.equals(nombre, "Activo");
    }
    public boolean esAmbitoTurno() {
        return ambito == 1;
    }

    public boolean esReservado() {
        return Objects.equals(nombre, "Reservado");
    }
}