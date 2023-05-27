package co.com.flypass.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaPrincipal {
    public static final Target PAGINA_PRINCIPAL = Target.the("pagina principal").locatedBy("//android.widget.TextView[@text='Información, promedios y movimientos generales de tu cuenta.']");

    public static final Target IR_TRANSACCION = Target.the("ir transaccion").locatedBy("//android.widget.Button[@text='IR']");

    public static final Target NOTIFICACIONES = Target.the("Notificaciones").locatedBy("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Button");

    public static final Target SERVICIOS_EN_CURSO = Target.the("servicios en curso").locatedBy("//android.widget.TextView[@text='Servicios en curso']");

}
