package co.com.flypass.task;

import co.com.flypass.userinterface.ConfirmarTransaccionFlujoUno;
import co.com.flypass.userinterface.DetalleServicioEnCurso;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinalizarEstacionamiento implements Task {
    public static FinalizarEstacionamiento darClickEnBoton(){
        return instrumented(FinalizarEstacionamiento.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DetalleServicioEnCurso.BOTON_FINALIZAR_ESTACINAMIENTO),
                Click.on(ConfirmarTransaccionFlujoUno.ACEPTAR)
        );
    }
}
