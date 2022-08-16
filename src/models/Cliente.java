package models;
public class Cliente {

    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String valor) {
        nombre = valor;
    }

    public void setApellido(String valor) {
        apellido = valor;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String valor) {
        email = valor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String valor) {
        telefono = valor;
    }
}
