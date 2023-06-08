package co.com.flypass.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DetalleServicioEnCurso {
    public static final Target BOTON_AGREGAR_MAS_TIEMPO = Target.the("agregar mas tiempo").locatedBy("//android.widget.Button[@text='AGREGAR MÁS TIEMPO']");
    public static final Target BOTON_FINALIZAR_ESTACINAMIENTO = Target.the("finalizar estacionamiento").locatedBy("//android.widget.Button[@text='FINALIZAR ESTACIONAMIENTO']");
}
