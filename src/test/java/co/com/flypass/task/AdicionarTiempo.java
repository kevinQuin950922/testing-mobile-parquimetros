package co.com.flypass.task;

import co.com.flypass.userinterface.AdicionDeTiempo;
import co.com.flypass.userinterface.ConfirmarTransaccionFlujoUno;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AdicionarTiempo implements Task {
    public static AdicionarTiempo adicionarTiempo(){
        return instrumented(AdicionarTiempo.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AdicionDeTiempo.AGREGAR_TIEMPO),
                Click.on(AdicionDeTiempo.BOTON_AGREGAR_TIEMPO),
                Click.on(ConfirmarTransaccionFlujoUno.ACEPTAR)
        );
    }
}
