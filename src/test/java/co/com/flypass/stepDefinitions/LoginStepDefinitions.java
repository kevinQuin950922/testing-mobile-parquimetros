package co.com.flypass.stepDefinitions;

import co.com.flypass.task.IngresarTokenOTPTask;
import co.com.flypass.task.LoginErrorContraseñaIncorrectaTask;
import co.com.flypass.task.LoginUsuarioYContrasenaCorrectosTask;
import co.com.flypass.userinterface.PaginaPrincipalUserinterface;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.sql.SQLException;

import static co.com.flypass.userinterface.LoginUserinterface.ERROR_LOGIN;
import static co.com.flypass.utils.bdOracle.ConectionBd.consultTable;
import static co.com.flypass.utils.bdOracle.ConectionBd.eliminarRegistro;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^Se ingresa bien el usuario y mal la contrasena$")
    public void seIngresaBienElUsuarioYMalLaContrasena() {
        theActorCalled("Kevin").attemptsTo(LoginErrorContraseñaIncorrectaTask.iniciarSesionConContrasenaIncorrecta());
    }

    @Then("^Debe mostrar un mensaje de usuario y contrasena incorrectos$")
    public void debeMostrarUnMensajeDeUsuarioYContrasenaIncorrectos() {
        OnStage.theActorInTheSpotlight().should(seeThat(the(ERROR_LOGIN),containsText("Usuario o contraseña inválidos")));
    }

    @When("^Se ingresa bien el usuario y contrasena$")
    public void seIngresaBienElUsuarioYContrasena() {
        theActorCalled("Kevin").attemptsTo(LoginUsuarioYContrasenaCorrectosTask.iniciarSesionConContrasenaCorrecta());
    }

    @And("^Se ingresa token OTP$")
    public void SeIngresaTokenOTP() {
        theActorCalled("Kevin").attemptsTo(IngresarTokenOTPTask.ingresarToken());
    }

    @Then("^Debe mostrar la pantalla inicial$")
    public void debeMostrarLaPantallaInicial() throws SQLException, ClassNotFoundException {
        OnStage.theActorInTheSpotlight().should(seeThat(the(PaginaPrincipalUserinterface.PAGINA_PRINCIPAL),containsOnlyText("Información, promedios y movimientos generales de tu cuenta.")));
        String respuesta =consultTable ("select * from tfps_dispositivos where cdusuario_ingresa = 36448 order by femodifica desc","cddispositivo");
        eliminarRegistro("Delete from tfps_dispositivos where cddispositivo = "+respuesta);
    }

}