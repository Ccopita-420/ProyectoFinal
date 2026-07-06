package drones;

import usuarios.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class SistemaGestionDrones {
    private Usuario[] usuarios = new Usuario[100];
    private int contUsuarios = 0;
    
    public Usuario buscarUsuarioPorUsername(String username) {
        for (int i = 0; i < contUsuarios; i++) {
            if (usuarios[i].getUsername().equalsIgnoreCase(username)) {
                return usuarios[i];
            }
        }
        return null;
    }
    public boolean registrarUsuario(Usuario nuevo) {
        if (contUsuarios < usuarios.length) {
            usuarios[contUsuarios] = nuevo;
            contUsuarios++;
            return true;
        }
        return false; 
    }
    
    public boolean eliminarUsuario(String username) {
        for (int i = 0; i < contUsuarios; i++) {
            if (usuarios[i].getUsername().equalsIgnoreCase(username)) {
                for (int j = i; j < contUsuarios - 1; j++) {
                usuarios[j] = usuarios[j + 1];
            }
                usuarios[contUsuarios - 1] = null;
                contUsuarios--;
                return true;
            }
        }
        return false;
    }
    
    public Usuario[] getUsuarios() {
        return this.usuarios;
    }
    public int getContUsuarios() {
        return this.contUsuarios;
    }
    
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
        
        // TODO code application logic here
        System.out.println("=== 1. PRUEBA DE USUARIOS ===");
        Usuario[] listaUsuarios = new Usuario[3];

        listaUsuarios[0] = new Administrador("11111111", "Carlos", "Mendoza", "admin01", "pasw123");

        Usuario usuarioLogueado = listaUsuarios[0]; 
        System.out.println("Intento de login correcto: " + usuarioLogueado.login("admin01", "pasw123"));
        System.out.println("Intento de login incorrecto: " + usuarioLogueado.login("admin01", "claveFalsa"));
        
        System.out.println();

        System.out.println("=== 2. PRUEBA DE DRONES ===");

        Dron[] inventarioDrones = new Dron[3];

        inventarioDrones[0] = new DronVigilancia("DRN-001", "Phantom 4 Pro", "Disponible", "Vigilancia", 95.5, "360 grados panorámica");
        inventarioDrones[1] = new DronEntrega("DRN-002", "Matrice 300", "Disponible", "Entrega", 80.0, 5, "lol");

        for (int i = 0; i < inventarioDrones.length; i++) {
            if (inventarioDrones[i] != null) {
                inventarioDrones[i].mostrarInformacion();
                System.out.println("------------------------------------");
            }
        }
    
    }
}

