package co.com.flypass.task;

import co.com.flypass.builder.UserBuilder;
import co.com.flypass.model.UserModel;
import co.com.flypass.userinterface.IniciarSesion;
import co.com.flypass.utils.keyBoard.TecleoUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesionUsuarioYContrasenaCorrectos implements Task {
    private final UserModel userModel;

    public IniciarSesionUsuarioYContrasenaCorrectos(UserModel userModel) {
        this.userModel = userModel;
    }


    public static IniciarSesionUsuarioYContrasenaCorrectos iniciarSesionConContrasenaCorrecta(){
        UserModel usercorrecto = new UserBuilder().user("1152700942").contrasena("flypass18").build();
        return instrumented(IniciarSesionUsuarioYContrasenaCorrectos.class,usercorrecto);
    }

    TecleoUsuario tecleoUsuario = new TecleoUsuario();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(IniciarSesion.USER),
                Click.on(IniciarSesion.USER)

        );
        tecleoUsuario.usuarioCorrecto();
        actor.attemptsTo(
                Click.on(IniciarSesion.BUTTON_CONTINUAR),
                Enter.theValue(userModel.getContrasena()).into(IniciarSesion.USER),
                Click.on(IniciarSesion.VER_CONTRASENA),
                Click.on(IniciarSesion.BUTTON_CONTINUAR)
        );
    }

}