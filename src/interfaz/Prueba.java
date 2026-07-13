package interfaz;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import drones.*;
import usuarios.*;

public class Prueba {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        SistemaGestionDrones sistema = new SistemaGestionDrones();

        sistema.registrarUsuario(new Administrador("12345678", "Pepito", "A", "admin", "123"));
        sistema.registrarUsuario(new Operador("87654321", "Juan", "Pérez", "operador", "123"));
        sistema.registrarUsuario(new Supervisor("43556464", "Lolito", "xd", "supervisor", "123"));
        

        Dron dronEntrega = new DronEntrega("DRN-002", "Matrice 300", "Disponible", "Entrega", 80.0, 5, "Medicinas");
        Dron dronVigilancia = new DronVigilancia("DRN-001", "Phantom 4 Pro", "Disponible", "Vigilancia", 95.5, "360");
        Dron dronTransmision = new DronTransmision("DRN-003", "Inspire 3", "Disponible", "Transmisión", 88.0, "4K UHD", "YouTube Live");

        sistema.registrarDron(dronEntrega);
        sistema.registrarDron(dronVigilancia);
        sistema.registrarDron(dronTransmision);


        Sede sedeNacional = new Sede("SDE-01", "Estadio Nacional", "Lima", 20);
        Sede sedeMonumental = new Sede("SDE-02", "Estadio Monumental", "Ate", 12);

        sistema.registrarSede(sedeNacional);
        sistema.registrarSede(sedeMonumental);

 
        Mision mision1 = new Mision("MIS-101", "15/07/2026", "20:00", "Vigilancia aérea", "Pendiente", sedeNacional, dronVigilancia);
        Mision mision2 = new Mision("MIS-102", "16/07/2026", "16:00", "Transmisión de imágenes", "Pendiente", sedeMonumental, dronTransmision);

        sistema.crearMision(mision1);
        sistema.crearMision(mision2);

        mision1.agregarRuta(new RutaVuelo("RUT-A1", "Tribuna Norte y Accesos", 15, 1));
        mision1.agregarRuta(new RutaVuelo("RUT-A2", "Estacionamiento General", 10, 2));

        mision2.agregarRuta(new RutaVuelo("RUT-B1", "Cancha Principal - Calentamiento", 25, 1));
        mision2.agregarRuta(new RutaVuelo("RUT-B2", "Zona de Prensa Exterior", 20, 3));

        sistema.crearMision(mision1);
        sistema.crearMision(mision2);

        java.awt.EventQueue.invokeLater(() -> new VentanaLogin(sistema).setVisible(true));
    }

}
