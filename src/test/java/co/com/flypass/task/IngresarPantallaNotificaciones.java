package co.com.flypass.task;

import co.com.flypass.userinterface.IniciarSesion;
import co.com.flypass.userinterface.Notificaciones;
import co.com.flypass.userinterface.PaginaPrincipal;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.WebDriverFacade;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class IngresarPantallaNotificaciones implements Task {

    public static IngresarPantallaNotificaciones ingresarPantallaNotificaciones(){
        return instrumented(IngresarPantallaNotificaciones.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Check.whether(PaginaPrincipal.IR_TRANSACCION.resolveFor(actor).isCurrentlyVisible())
                    .andIfSo(
                            Click.on(PaginaPrincipal.ELIMINAR_NOTIFICACION)
                    ).otherwise(),
                Click.on(PaginaPrincipal.NOTIFICACIONES)
        );
    }
}
