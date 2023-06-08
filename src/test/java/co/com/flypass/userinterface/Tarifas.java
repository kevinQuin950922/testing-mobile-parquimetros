package co.com.flypass.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class Tarifas {
    public static final Target VER_TARIFAS= Target.the("ver tarifas").locatedBy("//android.view.View[@text='Tarifas de']");
    public static final Target ZER= Target.the("ZER").locatedBy("//android.view.View[@text='Z.E.R']");
    public static final Target BOTON_ACEPTAR= Target.the("ver tarifas").locatedBy("//android.widget.Button[@text='ACEPTAR']");
}
