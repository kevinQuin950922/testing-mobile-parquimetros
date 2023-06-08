package co.com.flypass.task;

import co.com.flypass.userinterface.IniciarSesion;
import co.com.flypass.userinterface.Notificaciones;
import co.com.flypass.userinterface.PaginaPrincipal;
import co.com.flypass.utils.bdOracle.ConectionBd;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.webdriver.WebDriverFacade;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class IngresarNotificacion implements Task {

    public static IngresarNotificacion ingresarNotificacion(){
        return instrumented(IngresarNotificacion.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Notificaciones.NOTIFICACION)
        );
    }
}
