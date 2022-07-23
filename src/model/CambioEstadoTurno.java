package model;

public class CambioEstadoTurno
{
    private String fechaHoraDesde;
    private String fechaHoraHasta;
    public Estado estado;

    public CambioEstadoTurno(String fechaHoraDesde, Estado estado) {
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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getEstadoString() {
        return estado.getNombre();
    }

    public boolean esActual() {
        return fechaHoraHasta == null;
    }

    public void finalizar(String fechaActual) {
        setFechaHoraHasta(fechaActual);
    }
}

