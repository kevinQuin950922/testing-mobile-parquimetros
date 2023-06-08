package co.com.flypass.task;

import co.com.flypass.userinterface.AdicionDeTiempo;
import co.com.flypass.userinterface.ConfirmarTransaccionFlujoUno;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarPantallaTarifas implements Task {
    public static IngresarPantallaTarifas ingresarPantallaTarifas(){
        return instrumented(IngresarPantallaTarifas.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AdicionDeTiempo.VER_TARIFAS)
        );
    }
}
