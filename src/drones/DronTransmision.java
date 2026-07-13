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

    public void setResolucionCamara(String resolucionCamara) {
        this.resolucionCamara = resolucionCamara;
    }

    public void setPlataformaTransmision(String plataformaTransmision) {
        this.plataformaTransmision = plataformaTransmision;
    }

    public String getResolucionCamara() {
        return resolucionCamara;
    }

    public String getPlataformaTransmision() {
        return plataformaTransmision;
    }

    @Override
    public boolean modificarAtributo(String aspecto, String nuevoValor) {
        if (super.modificarAtributo(aspecto, nuevoValor)) {
            return true;
        }
        if (aspecto.equalsIgnoreCase("Resolución de Cámara")) {
            this.resolucionCamara = nuevoValor;
            return true;
        } else if (aspecto.equalsIgnoreCase("Plataforma de transmisión")) {
            this.plataformaTransmision = nuevoValor;
            return true;
        }
        return false;
    }
    @Override
public String getDetallesEspecificos() {
    return "Calidad de Video: " + this.resolucionCamara + " | Transmitiendo vía: " + this.plataformaTransmision;
}

    @Override
    public void mostrarInformacion() {
        System.out.println("--- INFORMACIÓN DRON DE TRANSMISIÓN ---");
        System.out.println("Código: " + codigo);
        System.out.println("Modelo: " + modelo);
        System.out.println("Estado: " + estado);
        System.out.println("Tipo: " + tipo);
        System.out.println("Batería: " + nivelBateria);
        System.out.println("Resolución Cámara: " + resolucionCamara);
        System.out.println("Plataforma Transmisión: " + plataformaTransmision);
    }
}
