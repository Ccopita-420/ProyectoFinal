package drones;

public abstract class Dron {
    protected String codigo, modelo, estado, tipo;
    protected double nivelBateria;

    public Dron(String codigo, String modelo, String estado, String tipo, double nivelBateria) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.estado = estado;
        this.tipo = tipo;
        this.nivelBateria = nivelBateria;
    }
    
    public abstract void mostrarInformacion();
     public String getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public double getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(double nivelBateria) {
        this.nivelBateria = nivelBateria;
    }
}

