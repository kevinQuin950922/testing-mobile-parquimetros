package co.com.flypass.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ConfirmarTransaccionFlujoUnoUserinterface {
    public static final Target DENEGAR = Target.the("denegar").locatedBy("//android.widget.Button[@text='DENEGAR']");
    public static final Target ACEPTAR = Target.the("aceptar").locatedBy("//android.widget.Button[@text='ACEPTAR']");

}
