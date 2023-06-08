package co.com.flypass.task;

import co.com.flypass.builder.UserBuilder;
import co.com.flypass.model.UserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class IniciarSesion implements Task {
    private final UserModel userModel;

    public IniciarSesion(UserModel userModel) {
        this.userModel = userModel;
    }

    public static IniciarSesion iniciarSesionConContrasenacCorrecta(){
        UserModel userIncorrecto = new UserBuilder().user("1152700942").contrasena("flypass18").build();
        return instrumented(IniciarSesion.class,userIncorrecto);
    }
    public static IniciarSesion iniciarSesionConContrasenaIncorrecta(){
        UserModel userIncorrecto = new UserBuilder().user("1152700942").contrasena("123456").build();
        return instrumented(IniciarSesion.class,userIncorrecto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(co.com.flypass.userinterface.IniciarSesion.USER,isCurrentlyVisible()).forNoMoreThan(10).seconds());
        actor.attemptsTo(
                Clear.field(co.com.flypass.userinterface.IniciarSesion.USER),
                Enter.theValue(userModel.getCedula()).into(co.com.flypass.userinterface.IniciarSesion.USER),
                Click.on(co.com.flypass.userinterface.IniciarSesion.BUTTON_CONTINUAR),
                Enter.theValue(userModel.getContrasena()).into(co.com.flypass.userinterface.IniciarSesion.USER),
                Click.on(co.com.flypass.userinterface.IniciarSesion.BUTTON_CONTINUAR)
        );
    }
}
