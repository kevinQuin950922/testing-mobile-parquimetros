package co.com.flypass.stepDefinitions;

import co.com.flypass.task.IngresarTokenOTP;
import co.com.flypass.task.IniciarSesion;
import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hook {
    @Before
    public void setup(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Before(value = "@flujouno , @flujoDos")
    public void beforeTag1Scenario() {
        theActorCalled("Kevin").attemptsTo(IniciarSesion.iniciarSesionConContrasenacCorrecta());
        theActorCalled("Kevin").attemptsTo(IngresarTokenOTP.ingresarToken());
    }
}
