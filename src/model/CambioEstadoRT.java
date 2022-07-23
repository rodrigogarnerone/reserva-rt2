package model;

public class CambioEstadoRT
{
    private String fechaHoraDesde;
    private String fechaHoraHasta;
    public Estado estado;


    public CambioEstadoRT(String fechaHoraDesde, Estado estado) {
        this.fechaHoraDesde = fechaHoraDesde;
        this.estado = estado;
    }

    public String getFechaHoraDesde() {
        return fechaHoraDesde;
    }

    public void setFechaHoraDesde(String fechaHoraDesde) {
        this.fechaHoraDesde = fechaHoraDesde;
    }

    public String getFechaHoraHasta() {
        return fechaHoraHasta;
    }

    public void setFechaHoraHasta(String fechaHoraHasta) {
        this.fechaHoraHasta = fechaHoraHasta;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean esActual() {
        return fechaHoraHasta == null;
    }

    public boolean esEstadoActualReservable() {
        return estado.esReservable();
    }


    public String getNombreEstado() {
        return estado.getNombre();
    }
}

