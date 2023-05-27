package co.com.flypass.stepDefinitions;

import co.com.flypass.task.*;
import co.com.flypass.userinterface.Notificaciones;
import co.com.flypass.userinterface.PaginaPrincipal;
import co.com.flypass.userinterface.ServiciosEnCurso;
import co.com.flypass.utils.apiFlypass.CreateTransaction;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.time.Duration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsOnlyText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class FlujoUno {
    @Before()
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Kevin").attemptsTo(IniciarSesionUsuarioYContrasenaCorrectos.iniciarSesionConContrasenaCorrecta());
//        theActorCalled("Kevin").attemptsTo(IngresarTokenOTP.ingresarToken());
    }
    @Given("^Se tiene una transacción por cobrar$")
    public void seTieneUnaTransacciónPorCobrar() {
        CreateTransaction createTransaction = new CreateTransaction();
        createTransaction.createTransactionFromASF("ABC185","60","40800");
    }

    @When("^Cuando llegue la notificación$")
    public void cuandoLlegueLaNotificación() {
        theActorCalled("kevin").attemptsTo(IngresarPantallaNotificaciones.ingresarPantallaNotificaciones());
    }

    @Then("^Se valida que el mensaje esté de forma correcta$")
    public void seValidaQueElMensajeEstéDeFormaCorrecta() {
        OnStage.theActorInTheSpotlight().should(seeThat(the(Notificaciones.NOTIFICACION),containsOnlyText("Tienes un nuevo cobro de tasa de uso Z.E.R")));
    }

    @Given("^Se tiene una transacción activa$")
    public void seTieneUnaTransacciónActiva() {
        // Write code here that turns the phrase above into concrete actions
        theActorCalled("kevin").attemptsTo(IngresarPantallaNotificaciones.ingresarPantallaNotificaciones());
    }

    @When("^Cuando se ingrese a la notificacion$")
    public void cuandoSeIngreseALaNotificacion() {
        theActorCalled("kevin").attemptsTo(IngresarNotificacion.ingresarNotificacion());

    }

    @Then("^Se valida que se pueda denegar el servicio$")
    public void seValidaQueSePuedaDenegarElServicio() {
        theActorCalled("kevin").attemptsTo(DenegarServicio.denegarServicio());
        theActorCalled("kevin").attemptsTo(IngresarServiciosEnCurso.ingresarServiciosEnCurso());
        OnStage.theActorInTheSpotlight().should(seeThat(the(ServiciosEnCurso.MENSAJE_SIN_SERVICIOS),containsOnlyText("Deberías comenzar ¿no?")));
    }
    @Given("^Se tiene una transacción activa por pagar$")
    public void seTieneUnaTransaccionActivaPorPagar() {
        CreateTransaction createTransaction = new CreateTransaction();
        createTransaction.createTransactionFromASF("ABC185","60","40800");
        theActorCalled("kevin").attemptsTo(IngresarPantallaNotificaciones.ingresarPantallaNotificaciones());
    }
    @Then("^Se valida que se pueda pagar el servicio$")
    public void seValidaQueSePuedaPagarElServicio() {
        theActorCalled("kevin").attemptsTo(AceptarServicio.aceptarServicio());
        theActorCalled("kevin").attemptsTo(IngresarServiciosEnCurso.ingresarServiciosEnCurso());
// Falta ver como se valida el servicio en curso
        OnStage.theActorInTheSpotlight().should(seeThat(the(ServiciosEnCurso.SERVICIO_EN_CURSO),containsOnlyText("transacción finalizada")));
    }


}
