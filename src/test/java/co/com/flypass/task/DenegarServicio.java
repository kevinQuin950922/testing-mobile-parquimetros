package co.com.flypass.task;

import co.com.flypass.userinterface.ConfirmarTransaccionFlujoUno;
import co.com.flypass.userinterface.Notificaciones;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DenegarServicio implements Task {
    public static DenegarServicio denegarServicio(){
        return instrumented(DenegarServicio.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ConfirmarTransaccionFlujoUno.DENEGAR),
                Click.on(ConfirmarTransaccionFlujoUno.DENEGAR)
        );
    }
}
