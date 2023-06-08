package co.com.flypass.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class AdicionDeTiempo {
    public static final Target BOTON_AGREGAR_TIEMPO = Target.the("boton agregar tiempo").locatedBy("//android.widget.Button[@text='AGREGAR']");
    public static final Target AGREGAR_TIEMPO = Target.the("agregar tiempo").locatedBy("//android.widget.Button[@text='+']");
    public static final Target VER_TARIFAS= Target.the("ver tarifas").locatedBy("//android.widget.Button[@text='VER TARIFAS']");

}
