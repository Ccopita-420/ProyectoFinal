package usuarios;

public class Supervisor extends Usuario {

    public Supervisor(String dni, String nombres, String apellidos, String username, String password) {
        super(dni, nombres, apellidos, username, password, "Supervisor");
    }
    
}
