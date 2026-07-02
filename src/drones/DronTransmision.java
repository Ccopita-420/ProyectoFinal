package drones;

public class DronTransmision extends Dron {

    protected String resolucionCamara;
    protected String plataformaTransmision;

    public DronTransmision(String codigo, String modelo, String estado, String tipo, 
                           double nivelBateria, String resolucionCamara, String plataformaTransmision) {

        super(codigo, modelo, estado, tipo, nivelBateria);
        this.resolucionCamara = resolucionCamara;
        this.plataformaTransmision = plataformaTransmision;
    }


    @Override
    public void mostrarInformacion(){
        System.out.println("--- INFORMACIÓN DRON DE TRANSMISIÓN ---");
        System.out.println("Código: "+ codigo);
        System.out.println("Modelo: "+modelo);
        System.out.println("Estado: "+estado);
        System.out.println("Tipo: "+tipo);
        System.out.println("Batería: "+ nivelBateria );
        System.out.println("Resolución Cámara: " + resolucionCamara);
        System.out.println("Plataforma Transmisión: " + plataformaTransmision);
    }
}