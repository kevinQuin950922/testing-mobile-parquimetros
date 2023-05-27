package co.com.flypass.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ServiciosEnCurso {
    public static final Target MENSAJE_SIN_SERVICIOS = Target.the("mensaje sin servicios").locatedBy("//android.widget.TextView[@text='Deberías comenzar ¿no?']");
    public static final Target SERVICIO_EN_CURSO = Target.the("servicio en curso").locatedBy("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[12]");
}
