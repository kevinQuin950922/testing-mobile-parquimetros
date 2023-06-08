package co.com.flypass.stepDefinitions;

import co.com.flypass.task.*;
import co.com.flypass.userinterface.Notificaciones;
import co.com.flypass.userinterface.PaginaPrincipal;
import co.com.flypass.userinterface.ServiciosEnCurso;
import co.com.flypass.userinterface.Tarifas;
import co.com.flypass.utils.apiFlypass.CreateTransaction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.sql.SQLException;

import static co.com.flypass.utils.bdOracle.ConectionBd.consultTable;
import static co.com.flypass.utils.bdOracle.ConectionBd.ejecutarQuery;
import static java.lang.Thread.sleep;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class FlujoUno {

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
        OnStage.theActorInTheSpotlight().should(seeThat(the(PaginaPrincipal.ALERTA_TRANSACCION_DENEGADA),isCurrentlyVisible()));

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
        OnStage.theActorInTheSpotlight().should(seeThat(the(PaginaPrincipal.ALERTA_TRANSACCION_APROBADA),isCurrentlyVisible()));
        try {
            sleep(50000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Given("^Se tiene un servicio en curso$")
    public void se_tiene_un_servicio_en_curso() {
        theActorCalled("kevin").attemptsTo(IngresarServiciosEnCurso.ingresarServiciosEnCurso());
    }

    @When("^Cuando se ingrese al detalle del servicio en curso$")
    public void cuando_se_ingrese_al_detalle_del_servicio_en_curso() {
        theActorCalled("kevin").attemptsTo(IngresarPantallaDetalle.ingresarPantallaDetalle());
    }

    @Then("^Se valida que se pueda adicionar tiempo$")
    public void se_valida_que_se_pueda_adicionar_tiempo() {
        theActorCalled("kevin").attemptsTo(IngresarPantallaAdicionDeTiempo.ingresarPorDetalleDelServicio());
        theActorCalled("kevin").attemptsTo(AdicionarTiempo.adicionarTiempo());
        OnStage.theActorInTheSpotlight().should(seeThat(the(PaginaPrincipal.ALERTA_TRANSACCION_APROBADA),isCurrentlyVisible()));
        try {
            sleep(70000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        theActorCalled("kevin").attemptsTo(IngresarServiciosEnCurso.ingresarServiciosEnCurso());
        OnStage.theActorInTheSpotlight().should(seeThat(the(ServiciosEnCurso.TIEMPO_RESTANTE),containsText("02")));
    }
    @Then("^Se valida que se pueda ingresar a la pantalla de tarifas$")
    public void se_valida_que_se_pueda_ingresar_a_la_pantalla_de_tarifas() {
        theActorCalled("kevin").attemptsTo(IngresarPantallaAdicionDeTiempo.ingresarPorDetalleDelServicio());
        theActorCalled("kevin").attemptsTo(IngresarPantallaTarifas.ingresarPantallaTarifas());
        OnStage.theActorInTheSpotlight().should(seeThat(the(Tarifas.VER_TARIFAS),isCurrentlyVisible()));
        OnStage.theActorInTheSpotlight().should(seeThat(the(Tarifas.ZER),isCurrentlyVisible()));
        OnStage.theActorInTheSpotlight().should(seeThat(the(Tarifas.BOTON_ACEPTAR),isCurrentlyVisible()));

    }

    @Then("^Se valida que se pueda finalizar el estacionamiento$")
    public void se_valida_que_se_pueda_finalizar_el_estacionamiento() throws SQLException, ClassNotFoundException {
        theActorCalled("kevin").attemptsTo(FinalizarEstacionamiento.darClickEnBoton());
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        theActorCalled("kevin").attemptsTo(IngresarServiciosEnCurso.ingresarServiciosEnCurso());
        OnStage.theActorInTheSpotlight().should(seeThat(the(ServiciosEnCurso.MENSAJE_SIN_SERVICIOS),containsOnlyText("Deberías comenzar ¿no?")));
        String respuesta =consultTable ("SELECT * FROM TFPS_VEHICULOS WHERE DSPLACA = 'ABC185'","CDUSUARIO");
        ejecutarQuery("UPDATE FLYPASS_PDN.tfps_usuarios SET vrsaldo_disponible=200000 where cdusuario="+respuesta);
    }



}
