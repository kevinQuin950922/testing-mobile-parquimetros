package co.com.flypass.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaPrincipal {
    public static final Target PAGINA_PRINCIPAL = Target.the("pagina principal").locatedBy("//android.view.View[@text='Información, promedios y movimientos generales de tu cuenta.']");

    public static final Target IR_TRANSACCION = Target.the("ir transaccion").locatedBy("//android.widget.Button[@text='IR']");

}
