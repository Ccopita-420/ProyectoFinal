package interfaz;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import drones.*;
import usuarios.*;

public class NewMain {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        SistemaGestionDrones sistema = new SistemaGestionDrones();

        sistema.registrarUsuario(new Administrador("12345678", "Pepito", "A", "admin", "123"));
        sistema.registrarUsuario(new Operador("87654321", "Juan", "Pérez", "operador", "123"));
        sistema.registrarUsuario(new Supervisor("43556464", "Lolito", "xd", "supervisor", "123"));
        
        java.awt.EventQueue.invokeLater(() -> new VentanaLogin(sistema).setVisible(true));
    }

}