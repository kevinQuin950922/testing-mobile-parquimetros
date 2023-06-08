package co.com.flypass.task;

import co.com.flypass.userinterface.IniciarSesion;
import co.com.flypass.utils.bdOracle.ConectionBd;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.webdriver.WebDriverFacade;

import java.sql.SQLException;
import java.time.Duration;

import static java.lang.Thread.sleep;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class IngresarTokenOTP implements Task {
    AndroidDriver<AndroidElement> androidDriver() {
        return (AndroidDriver<AndroidElement>)
                ((WebDriverFacade) getDriver()).getProxiedDriver();
    }
    public static IngresarTokenOTP ingresarToken(){
        return instrumented(IngresarTokenOTP.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(Check.whether(IniciarSesion.PAGINA_OTP.resolveFor(actor).isCurrentlyVisible())
                    .andIfSo(
                            Enter.theValue(ConectionBd.consultTable("select * from tfps_otp_usuarios where cdusuario=35925 order by fevencimiento desc", "dsotp")).into(IniciarSesion.CODIGO_SEGURIDAD)
                    ).otherwise());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        androidDriver().navigate().back();
    }
}
