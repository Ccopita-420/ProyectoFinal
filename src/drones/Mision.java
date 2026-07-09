package drones;

public class Mision {
    protected String codigo, fecha, hora, tipoMision,estado;
    protected Sede sedeAsignada;
    protected Dron dronAsignado;
    protected RutaVuelo[] rutas = new RutaVuelo[10];
    protected int contRutas = 0;

    public Mision(String codigo, String fecha, String hora, String tipoMision, String estado, Sede sedeAsignada, Dron dronAsignado) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoMision = tipoMision;
        this.estado = estado;
        this.sedeAsignada = sedeAsignada;
        this.dronAsignado = dronAsignado;
        
    }
    
    public void agregarRuta(RutaVuelo nuevaRuta) {
        if(contRutas<rutas.length){
            rutas[contRutas] = nuevaRuta;
            contRutas++;
        }
    }
    public String getCodigo() {
    return codigo;
}

public String getEstado() {
    return estado;
}

public void setEstado(String estado) {
    this.estado = estado;
}

public Dron getDronAsignado() {
    return dronAsignado;
}

public Sede getSedeAsignada() {
    return sedeAsignada;
}

public String getTipoMision() {
    return tipoMision;
}

public String getFecha() {
    return fecha;
}

public String getHora() {
    return hora;
}
}
