package co.com.flypass.task;

import co.com.flypass.userinterface.ConfirmarTransaccionFlujoUno;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AceptarServicio implements Task {
    public static AceptarServicio aceptarServicio(){
        return instrumented(AceptarServicio.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ConfirmarTransaccionFlujoUno.ACEPTAR),
                Click.on(ConfirmarTransaccionFlujoUno.ACEPTAR)
        );
    }
}
