package co.com.flypass.task;

import co.com.flypass.builder.UserBuilder;
import co.com.flypass.model.UserModel;
import co.com.flypass.userinterface.LoginUserinterface;
import co.com.flypass.utils.keyBoard.TecleoUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginUsuarioYContrasenaCorrectosTask implements Task {
    private final UserModel userModel;

    public LoginUsuarioYContrasenaCorrectosTask(UserModel userModel) {
        this.userModel = userModel;
    }


    public static LoginUsuarioYContrasenaCorrectosTask iniciarSesionConContrasenaCorrecta(){
        UserModel usercorrecto = new UserBuilder().user("1152700942").contrasena("flypass18").build();
        return instrumented(LoginUsuarioYContrasenaCorrectosTask.class,usercorrecto);
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
                Click.on(LoginUserinterface.VER_CONTRASENA),
                Click.on(LoginUserinterface.BUTTON_CONTINUAR)
        );
    }

}