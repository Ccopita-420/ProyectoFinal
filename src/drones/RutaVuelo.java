package drones;

public class RutaVuelo {
    protected String codigo, zonaAsignada;
    protected int duracionMinutos, nivelPrioridad;

    public RutaVuelo(String codigo, String zonaAsignada, int duracionMinutos, int nivelPrioridad) {
        this.codigo = codigo;
        this.zonaAsignada = zonaAsignada;
        this.duracionMinutos = duracionMinutos;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getZonaAsignada() {
        return zonaAsignada;
    }

    public void setZonaAsignada(String zonaAsignada) {
        this.zonaAsignada = zonaAsignada;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }
    
    
}
