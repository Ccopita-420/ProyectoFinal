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
    //aaa
    public abstract void mostrarInformacion();
}
