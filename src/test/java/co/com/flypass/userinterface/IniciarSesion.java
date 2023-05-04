package co.com.flypass.userinterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IniciarSesion {
    public static final Target USER = Target.the("User").located(By.className("android.widget.EditText"));

    public static final Target BUTTON_CONTINUAR = Target.the("Button_continuar").locatedBy("//android.widget.Button[@text='CONTINUAR']");

    //public static final Target ERROR_LOGIN = Target.the("Error login").locatedBy("//android.view.View[@text='Usuario o contraseña inválidos']");
    public static final Target ERROR_LOGIN = Target.the("Error login").locatedBy("//*[contains(@text,'Usuario o contraseña inválidos')]");
    public static final Target VER_CONTRASENA = Target.the("ver contrasena").locatedBy("//android.widget.Image[@text='eye off outline']");

    public static final Target CODIGO_SEGURIDAD = Target.the("codigo seguridad").located(By.className("android.widget.EditText"));
    public static final Target PAGINA_OTP = Target.the("pagina otp").locatedBy("//android.view.View[@text='OTP']");




}

