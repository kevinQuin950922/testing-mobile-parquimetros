package co.com.flypass.builder;

import co.com.flypass.model.UserModel;

public class UserBuilder {
    private final UserModel userModel;

    public UserBuilder() {
        userModel = new UserModel();
    }

    public  UserBuilder user(String cedula){
        userModel.setCedula(cedula);
        return this;
    }

    public UserBuilder contrasena (String contrasena){
        userModel.setContrasena(contrasena);
        return this;
    }

    public UserModel build() {
        return userModel;
    }
}
