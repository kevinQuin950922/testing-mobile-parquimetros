package co.com.flypass.task;

import co.com.flypass.builder.UserBuilder;
import co.com.flypass.model.UserModel;
import co.com.flypass.userinterface.IniciarSesion;
import co.com.flypass.utils.keyBoard.TecleoUsuario;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouseToBy;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.WebDriverFacade;

import static java.lang.Thread.sleep;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class IniciarSesionUsuarioYContrasenaCorrectos implements Task {
    private final UserModel userModel;

    public IniciarSesionUsuarioYContrasenaCorrectos(UserModel userModel) {
        this.userModel = userModel;
    }
    public static IniciarSesionUsuarioYContrasenaCorrectos iniciarSesionConContrasenaCorrecta(){
        UserModel usercorrecto = new UserBuilder().user("1152700942").contrasena("flypass18").build();
        return instrumented(IniciarSesionUsuarioYContrasenaCorrectos.class,usercorrecto);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(IniciarSesion.USER,isCurrentlyVisible()).forNoMoreThan(10).seconds());
        actor.attemptsTo(
                Clear.field(IniciarSesion.USER),
                Enter.theValue(userModel.getCedula()).into(IniciarSesion.USER),
                Click.on(IniciarSesion.BUTTON_CONTINUAR),
                Enter.theValue(userModel.getContrasena()).into(IniciarSesion.USER),
                Click.on(IniciarSesion.VER_CONTRASENA),
                Click.on(IniciarSesion.BUTTON_CONTINUAR)
        );
    }

}