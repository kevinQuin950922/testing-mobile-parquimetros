package co.com.flypass.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ServiciosEnCurso {
    public static final Target MENSAJE_SIN_SERVICIOS = Target.the("mensaje sin servicios").locatedBy("//android.view.View[@text='Deberías comenzar ¿no?']");
    public static final Target SERVICIO_EN_CURSO = Target.the("servicio en curso").locatedBy("//android.view.View[@index=11]");
    public static final Target TIEMPO_RESTANTE = Target.the("tiempo restante").locatedBy("//android.view.View[@index=7]");
}
