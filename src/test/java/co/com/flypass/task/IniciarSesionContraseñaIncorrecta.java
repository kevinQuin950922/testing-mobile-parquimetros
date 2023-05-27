package co.com.flypass.task;

import co.com.flypass.builder.UserBuilder;
import co.com.flypass.model.UserModel;
import co.com.flypass.userinterface.IniciarSesion;
import co.com.flypass.utils.keyBoard.TecleoUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class IniciarSesionContraseñaIncorrecta implements Task {
    private final UserModel userModel;

    public IniciarSesionContraseñaIncorrecta(UserModel userModel) {
        this.userModel = userModel;
    }

    public static IniciarSesionContraseñaIncorrecta iniciarSesionConContrasenaIncorrecta(){
        UserModel userIncorrecto = new UserBuilder().user("1152700942").contrasena("123456").build();
        return instrumented(IniciarSesionContraseñaIncorrecta.class,userIncorrecto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(IniciarSesion.USER,isCurrentlyVisible()).forNoMoreThan(10).seconds());
        actor.attemptsTo(
                Clear.field(IniciarSesion.USER),
                Enter.theValue(userModel.getCedula()).into(IniciarSesion.USER),
                Click.on(IniciarSesion.BUTTON_CONTINUAR),
                Enter.theValue(userModel.getContrasena()).into(IniciarSesion.USER),
                Click.on(IniciarSesion.BUTTON_CONTINUAR)
        );
    }
}
