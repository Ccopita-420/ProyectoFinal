package usuarios;

public class Administrador extends Usuario{

    public Administrador(String dni, String nombres, String apellidos, String username, String password) {
        super(dni, nombres, apellidos, username, password, "Administrador");
    }
    
}
