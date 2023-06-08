package co.com.flypass.task;

import co.com.flypass.userinterface.DetalleServicioEnCurso;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarPantallaAdicionDeTiempo implements Task {
    public static IngresarPantallaAdicionDeTiempo ingresarPorDetalleDelServicio(){
        return instrumented(IngresarPantallaAdicionDeTiempo.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DetalleServicioEnCurso.BOTON_AGREGAR_MAS_TIEMPO)
        );
    }
}
