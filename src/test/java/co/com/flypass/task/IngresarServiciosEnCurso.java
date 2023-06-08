package co.com.flypass.task;

import co.com.flypass.userinterface.PaginaPrincipal;
import co.com.flypass.userinterface.ServiciosEnCurso;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;

import static java.lang.Thread.sleep;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarServiciosEnCurso implements Task {
    public static IngresarServiciosEnCurso ingresarServiciosEnCurso(){
        return instrumented(IngresarServiciosEnCurso.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaPrincipal.SERVICIOS_EN_CURSO)
        );
    }
}
