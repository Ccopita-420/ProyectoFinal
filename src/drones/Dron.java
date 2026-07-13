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

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public String getDetallesEspecificos() {
        return "Sin especificaciones adicionales.";
    }

    public boolean modificarAtributo(String aspecto, String nuevoValor) {
        if (aspecto.equalsIgnoreCase("Código")) {
            if (nuevoValor.trim().isEmpty()) {
                return false;
            }
            this.codigo = nuevoValor;
            return true;
        } else if (aspecto.equalsIgnoreCase("Modelo")) {
            this.modelo = nuevoValor;
            return true;
        } else if (aspecto.equalsIgnoreCase("Estado")) {
            this.estado = nuevoValor;
            return true;
        } else if (aspecto.equalsIgnoreCase("Batería (%)")) {
            try {
                this.nivelBateria = Double.parseDouble(nuevoValor);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
