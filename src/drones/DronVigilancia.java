package drones;

public class DronVigilancia extends Dron {

    protected String campoVision;

    public DronVigilancia(String codigo, String modelo, String estado, String tipo, double nivelBateria, String campoVision) {
        super(codigo, modelo, estado, tipo, nivelBateria);
        this.campoVision = campoVision;
    }

    public void setCampoVision(String campoVision) {
        this.campoVision = campoVision;
    }

    public String getCampoVision() {
        return campoVision;
    }

    @Override
    public boolean modificarAtributo(String aspecto, String nuevoValor) {
        if (super.modificarAtributo(aspecto, nuevoValor)) {
            return true;
        }
        if (aspecto.equalsIgnoreCase("Campo de Visión")) {
            this.campoVision = nuevoValor;
            return true;
        }
        return false;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- INFORMACIÓN DRON DE VIGILANCIA ---");
        System.out.println("Código: " + codigo);
        System.out.println("Modelo: " + modelo);
        System.out.println("Estado: " + estado);
        System.out.println("Tipo: " + tipo);
        System.out.println("Batería: " + nivelBateria + "%");
        System.out.println("Campo de Vision: " + campoVision);
    }
}
