package drones;

import usuarios.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class SistemaGestionDrones {

    private Dron[] drones = new Dron[100];
    private int contDrones = 0;
    private Usuario[] usuarios = new Usuario[100];
    private int contUsuarios = 0;
    private Mision[] misiones = new Mision[100];
    private int contMisiones = 0;
    private Mantenimiento[] mantenimientos = new Mantenimiento[100];
    private int contMantenimientos = 0;
    private Sede[] sedes = new Sede[50];
    private int contSedes = 0;

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

    public boolean modificarUsuario(String username, String aspecto, String nuevoValor) {
        Usuario u = buscarUsuarioPorUsername(username);

        if (u != null) {
            if (aspecto.equalsIgnoreCase("DNI")) {
                u.setDni(nuevoValor);
            } else if (aspecto.equalsIgnoreCase("Nombres")) {
                u.setNombres(nuevoValor);
            } else if (aspecto.equalsIgnoreCase("Apellidos")) {
                u.setApellidos(nuevoValor);
            } else if (aspecto.equalsIgnoreCase("Usuario")) {
                u.setUsername(nuevoValor);
            } else if (aspecto.equalsIgnoreCase("Contraseña")) {
                u.setPassword(nuevoValor);
            } else if (aspecto.equalsIgnoreCase("Rol")) {
                u.setRol(nuevoValor);
            } else {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean crearMision(Mision nuevaMision) {
        if (contMisiones < misiones.length) {
            Dron dron = nuevaMision.getDronAsignado();

            if (dron.getEstado().equalsIgnoreCase("Disponible")
                    && dron.getNivelBateria() >= 30) {

                misiones[contMisiones] = nuevaMision;
                contMisiones++;

                dron.setEstado("En misión");
                nuevaMision.setEstado("En proceso");

                return true;
            }
        }
        return false;
    }

    public Mision buscarMisionPorCodigo(String codigo) {
        for (int i = 0; i < contMisiones; i++) {
            if (misiones[i].getCodigo().equalsIgnoreCase(codigo)) {
                return misiones[i];
            }
        }
        return null;
    }

    public boolean finalizarMision(String codigoMision, String nuevoEstadoDron) {
        Mision mision = buscarMisionPorCodigo(codigoMision);

        if (mision != null) {
            mision.setEstado("Finalizada");

            if (nuevoEstadoDron.equalsIgnoreCase("Disponible")
                    || nuevoEstadoDron.equalsIgnoreCase("En mantenimiento")
                    || nuevoEstadoDron.equalsIgnoreCase("Batería baja")) {

                mision.getDronAsignado().setEstado(nuevoEstadoDron);
                return true;
            }
        }
        return false;
    }

    public boolean registrarDron(Dron nuevoDron) {
        if (contDrones < drones.length) {
            drones[contDrones] = nuevoDron;
            contDrones++;
            return true;
        }
        return false;
    }

    public Dron[] getDrones() {
        return drones;
    }

    public int getContDrones() {
        return contDrones;
    }

    public Dron buscarDronPorCodigo(String codigo) {
        for (int i = 0; i < contDrones; i++) {
            if (drones[i].getCodigo().equalsIgnoreCase(codigo)) {
                return drones[i];
            }
        }
        return null;
    }

    public boolean eliminarDron(String codigo) {
        for (int i = 0; i < contDrones; i++) {
            if (drones[i].getCodigo().equalsIgnoreCase(codigo)) {

                for (int j = i; j < contDrones - 1; j++) {
                    drones[j] = drones[j + 1];
                }

                drones[contDrones - 1] = null;
                contDrones--;
                return true;
            }
        }

        return false;
    }

    public boolean modificarDron(String codigo, String aspecto, String nuevoValor) {
        Dron d = buscarDronPorCodigo(codigo);
        if (d != null) {
            return d.modificarAtributo(aspecto, nuevoValor);
        }
        return false;
    }

    public boolean registrarMantenimiento(Mantenimiento nuevo) {
        if (contMantenimientos < mantenimientos.length) {

            Dron dronAfectado = buscarDronPorCodigo(nuevo.getCodigoDron());

            if (dronAfectado != null) {
                dronAfectado.setEstado("En mantenimiento");

                mantenimientos[contMantenimientos] = nuevo;
                contMantenimientos++;
                return true;
            }
        }
        return false;
    }

    public boolean registrarSede(Sede nuevaSede) {
        if (contSedes < sedes.length) {
            sedes[contSedes] = nuevaSede;
            contSedes++;
            return true;
        }
        return false;
    }

    public Sede[] getSedes() {
        return sedes;
    }

    public int getContSedes() {
        return contSedes;
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
        System.out.println();
        System.out.println("=== 3. PRUEBA DE MISIONES ===");

        SistemaGestionDrones sistema = new SistemaGestionDrones();

        Sede sede1 = new Sede("SED-001", "Estadio Nacional", "Lima", 43000);

        Mision mision1 = new Mision(
                "MIS-001",
                "15/06/2026",
                "18:00",
                "Vigilancia aérea",
                "Pendiente",
                sede1,
                inventarioDrones[0]
        );

        boolean creada = sistema.crearMision(mision1);

        System.out.println("Misión creada: " + creada);
        System.out.println("Estado del dron: " + inventarioDrones[0].getEstado());

        boolean finalizada = sistema.finalizarMision("MIS-001", "Disponible");

        System.out.println("Misión finalizada: " + finalizada);
        System.out.println("Estado final del dron: " + inventarioDrones[0].getEstado());
    }
}
