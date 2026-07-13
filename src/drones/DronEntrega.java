package drones;

public class DronEntrega extends Dron {

    protected double capacidadCarga;
    protected String tipoSuministro;

    public DronEntrega(String codigo, String modelo, String estado, String tipo,
            double nivelBateria, double capacidadCarga, String tipoSuministro) {

        super(codigo, modelo, estado, tipo, nivelBateria);
        this.capacidadCarga = capacidadCarga;
        this.tipoSuministro = tipoSuministro;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public void setTipoSuministro(String tipoSuministro) {
        this.tipoSuministro = tipoSuministro;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public String getTipoSuministro() {
        return tipoSuministro;
    }

    @Override
    public boolean modificarAtributo(String aspecto, String nuevoValor) {
        if (super.modificarAtributo(aspecto, nuevoValor)) {
            return true;
        }
        if (aspecto.equalsIgnoreCase("Capacidad de carga (kg)")) {
            try {
                this.capacidadCarga = Double.parseDouble(nuevoValor);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else if (aspecto.equalsIgnoreCase("Tipo de suministro")) {
            this.tipoSuministro = nuevoValor;
            return true;
        }
        return false;
    }

    @Override
    public String getDetallesEspecificos() {
        return "Capacidad Máxima: " + this.capacidadCarga + " kg | Suministro: " + this.tipoSuministro;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- INFORMACIÓN DRON DE ENTREGA ---");
        System.out.println("Código: " + codigo);
        System.out.println("Modelo: " + modelo);
        System.out.println("Estado: " + estado);
        System.out.println("Tipo: " + tipo);
        System.out.println("Batería: " + nivelBateria + "%");
        System.out.println("Capacidad de carga: " + capacidadCarga + " kg");
        System.out.println("Tipo de suministro: " + tipoSuministro);
    }
}
