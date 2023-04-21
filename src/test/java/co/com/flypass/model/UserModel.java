package co.com.flypass.model;

public class UserModel {
    private String cedula;
    private String contrasena;

    public UserModel() {
        this.cedula = "";
        this.contrasena = "";
    }

    public String getCedula() {
        return cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
