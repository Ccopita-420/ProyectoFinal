package drones;

public class Mantenimiento {
    protected String fecha, descripcion, codigoDron, responsable;
    protected double costo;

    public Mantenimiento(String fecha, String descripcion, String codigoDron, String responsable, double costo) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.codigoDron = codigoDron;
        this.responsable = responsable;
        this.costo = costo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoDron() {
        return codigoDron;
    }

    public void setCodigoDron(String codigoDron) {
        this.codigoDron = codigoDron;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
}
