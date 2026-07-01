package proyecto;

public class DronEntrega extends Dron {

    protected double capacidadCarga;
    protected String tipoSuministro;

    public DronEntrega(String codigo, String modelo, String estado, String tipo, 
                       double nivelBateria, double capacidadCarga, String tipoSuministro) {

        super(codigo, modelo, estado, tipo, nivelBateria);
        this.capacidadCarga = capacidadCarga;
        this.tipoSuministro = tipoSuministro;
    }


    @Override
    public void mostrarInformacion(){
        System.out.println("--- INFORMACIÓN DRON DE ENTREGA ---");
        System.out.println("Código: "+ codigo);
        System.out.println("Modelo: "+modelo);
        System.out.println("Estado: "+estado);
        System.out.println("Tipo: "+tipo);
        System.out.println("Batería: "+ nivelBateria + "%");
        System.out.println("Capacidad de carga: " + capacidadCarga + " kg");
        System.out.println("Tipo de suministro: " + tipoSuministro);
    }
}