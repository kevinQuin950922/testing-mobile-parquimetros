package co.com.flypass.task;

import co.com.flypass.userinterface.ConfirmarTransaccionFlujoUno;
import co.com.flypass.userinterface.ServiciosEnCurso;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarPantallaDetalle implements Task {
    public static IngresarPantallaDetalle ingresarPantallaDetalle(){
        return instrumented(IngresarPantallaDetalle.class);
    }
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ServiciosEnCurso.SERVICIO_EN_CURSO)
        );
    }
}
