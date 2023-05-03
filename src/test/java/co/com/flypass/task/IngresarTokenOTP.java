package co.com.flypass.task;

import co.com.flypass.userinterface.IniciarSesion;
import co.com.flypass.utils.bdOracle.ConectionBd;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.sql.SQLException;
import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarTokenOTP implements Task {

    public static IngresarTokenOTP ingresarToken(){
        return instrumented(IngresarTokenOTP.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(IniciarSesion.CODIGO_SEGURIDAD.waitingForNoMoreThan(Duration.ofSeconds(10))));
        try {
            String otp = ConectionBd.consultTable("select * from tfps_otp_usuarios where cdusuario=35925 order by fevencimiento desc", "dsotp");
            actor.attemptsTo(
                    Enter.theValue(otp).into(IniciarSesion.CODIGO_SEGURIDAD)
            );
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
