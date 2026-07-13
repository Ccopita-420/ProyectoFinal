package drones;

import usuarios.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class SistemaGestionDrones implements Reportable {

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
            if (misiones[i] != null && misiones[i].getCodigo().equalsIgnoreCase(codigo)) {
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

    public Mision[] getMisiones() {
        return this.misiones;
    }

    public int getContMisiones() {
        return this.contMisiones;
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

    public Sede buscarSedePorCodigo(String codigo) {
        for (int i = 0; i < contSedes; i++) {
            if (sedes[i] != null && sedes[i].getCodigo().equalsIgnoreCase(codigo)) {
                return sedes[i];
            }
        }
        return null;
    }

    @Override
    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("==================================================\n");
        sb.append("      REPORTE CONSOLIDADO DE MISIONES POR SEDE\n");
        sb.append("==================================================\n\n");

        if (contSedes == 0) {
            sb.append("No hay sedes registradas en el sistema.\n");
            return sb.toString();
        }

        for (int i = 0; i < contSedes; i++) {
            if (sedes[i] != null) {
                sb.append("SEDE: ").append(sedes[i].getNombre())
                        .append(" (Código: ").append(sedes[i].getCodigo()).append(")\n");
                sb.append("--------------------------------------------------\n");

                int misionesEnSede = 0;
                for (int j = 0; j < contMisiones; j++) {
                    if (misiones[j] != null && misiones[j].getSedeAsignada().getCodigo().equalsIgnoreCase(sedes[i].getCodigo())) {
                        misionesEnSede++;
                        sb.append(" Misión: ").append(misiones[j].getCodigo())
                                .append(" | Tipo: ").append(misiones[j].getTipoMision())
                                .append(" | Estado: ").append(misiones[j].getEstado()).append("\n");
                        sb.append("    Dron: ").append(misiones[j].getDronAsignado().getCodigo())
                                .append(" (").append(misiones[j].getDronAsignado().getModelo()).append(")\n");
                        sb.append("    Tramos de vuelo: ").append(misiones[j].getContRutas()).append("\n\n");
                    }
                }
                if (misionesEnSede == 0) {
                    sb.append("  [Sin misiones asignadas a esta sede aún]\n\n");
                }
            }
        }
        return sb.toString();
    }

    public String generarReporteEstadoDrones() {
        StringBuilder sb = new StringBuilder();
        sb.append("==================================================\n");
        sb.append("          ESTADO ACTUAL DE LA FLOTA DE DRONES\n");
        sb.append("==================================================\n\n");

        for (int i = 0; i < contDrones; i++) {
            if (drones[i] != null) {
                sb.append("Dron: ").append(drones[i].getCodigo())
                        .append(" | Modelo: ").append(drones[i].getModelo())
                        .append("\n   Estado: ").append(drones[i].getEstado())
                        .append(" | Batería: ").append(drones[i].getNivelBateria()).append("%\n");

                sb.append("   Especificación: ").append(drones[i].getDetallesEspecificos()).append("\n");
                sb.append("--------------------------------------------------\n");
            }
        }
        return sb.toString();
    }

    public String generarReporteCostosMantenimiento() {
        StringBuilder sb = new StringBuilder();
        sb.append("==================================================\n");
        sb.append("      REPORTE DE COSTOS DE MANTENIMIENTO POR DRON\n");
        sb.append("==================================================\n\n");

        if (contDrones == 0) {
            sb.append("No hay drones registrados en el sistema.\n");
            return sb.toString();
        }

        double costoTotalGeneral = 0;

        for (int i = 0; i < contDrones; i++) {
            if (drones[i] != null) {
                String codDron = drones[i].getCodigo();
                double costoAcumuladoDron = 0;
                int cantidadMantenimientos = 0;

                for (int j = 0; j < contMantenimientos; j++) {
                    if (mantenimientos[j] != null && mantenimientos[j].getCodigoDron().equalsIgnoreCase(codDron)) {
                        costoAcumuladoDron += mantenimientos[j].getCosto();
                        cantidadMantenimientos++;
                    }
                }

                sb.append(" Dron: ").append(codDron).append(" (").append(drones[i].getModelo()).append(")\n");
                sb.append("   Cantidad de mantenimientos: ").append(cantidadMantenimientos).append("\n");
                sb.append("   Costo Total Acumulado: $").append(String.format("%.2f", costoAcumuladoDron)).append("\n");
                sb.append("--------------------------------------------------\n");

                costoTotalGeneral += costoAcumuladoDron;
            }
        }

        sb.append("\n INVERSIÓN TOTAL EN MANTENIMIENTO: $").append(String.format("%.2f", costoTotalGeneral)).append("\n");
        return sb.toString();
    }

    public String generarReporteBateriaBaja() {
        StringBuilder sb = new StringBuilder();
        sb.append("==================================================\n");
        sb.append("     REPORTE DE UNIDADES CON BATERIA CRITICA      \n");
        sb.append("==================================================\n\n");

        int dronesCriticos = 0;

        for (int i = 0; i < contDrones; i++) {
            if (drones[i] != null) {
                if (drones[i].getEstado().equalsIgnoreCase("Batería baja") || drones[i].getNivelBateria() < 30.0) {
                    dronesCriticos++;
                    sb.append("REGISTRO - Dron: ").append(drones[i].getCodigo()).append("\n");
                    sb.append("   Modelo: ").append(drones[i].getModelo()).append("\n");
                    sb.append("   Nivel de Bateria: ").append(drones[i].getNivelBateria()).append("%\n");
                    sb.append("   Estado Actual: ").append(drones[i].getEstado()).append("\n");
                    sb.append("--------------------------------------------------\n");
                }
            }
        }

        if (dronesCriticos == 0) {
            sb.append("Estado Operativo: No se detectaron drones con bateria baja en la flota.\n");
        } else {
            sb.append("Atencion: Se requiere asistencia inmediata para ").append(dronesCriticos).append(" unidad(es).\n");
        }

        return sb.toString();
    }

}
