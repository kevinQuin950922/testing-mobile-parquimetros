package co.com.flypass.task;

import co.com.flypass.builder.UserBuilder;
import co.com.flypass.model.UserModel;
import co.com.flypass.userinterface.LoginUserinterface;
import co.com.flypass.utils.keyBoard.TecleoUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;


import static net.serenitybdd.screenplay.Tasks.instrumented;


public class LoginErrorContraseñaIncorrectaTask implements Task {
    private final UserModel userModel;

    public LoginErrorContraseñaIncorrectaTask(UserModel userModel) {
        this.userModel = userModel;
    }

    public static LoginErrorContraseñaIncorrectaTask iniciarSesionConContrasenaIncorrecta(){
        UserModel userIncorrecto = new UserBuilder().user("1152700942").contrasena("123456").build();
        return instrumented(LoginErrorContraseñaIncorrectaTask.class,userIncorrecto);
    }

    TecleoUsuario tecleoUsuario = new TecleoUsuario();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(LoginUserinterface.USER),
                Click.on(LoginUserinterface.USER)

        );
        tecleoUsuario.usuarioCorrecto();
        actor.attemptsTo(
                Click.on(LoginUserinterface.BUTTON_CONTINUAR),
                Enter.theValue(userModel.getContrasena()).into(LoginUserinterface.USER),
                Click.on(LoginUserinterface.BUTTON_CONTINUAR)
        );
    }
}
