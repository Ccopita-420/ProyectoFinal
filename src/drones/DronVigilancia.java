package drones;

public class DronVigilancia extends Dron {
    protected String campoVision;

    public DronVigilancia(String codigo, String modelo, String estado, String tipo, double nivelBateria, String campoVision) {
        super(codigo, modelo, estado, tipo, nivelBateria);
        this.campoVision = campoVision;
    }
    
    @Override
    public void mostrarInformacion(){
        System.out.println("--- INFORMACIÓN DRON DE VIGILANCIA ---");
        System.out.println("Código: "+ codigo);
        System.out.println("Modelo: "+modelo);
        System.out.println("Estado: "+estado);
        System.out.println("Tipo: "+tipo);
        System.out.println("Batería: "+ nivelBateria + "%");
        System.out.println("Campo de Vision: " + campoVision);
    }
}
