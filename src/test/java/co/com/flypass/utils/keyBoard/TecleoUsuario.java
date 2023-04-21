package co.com.flypass.utils.keyBoard;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.thucydides.core.webdriver.WebDriverFacade;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class TecleoUsuario {
    AndroidDriver<AndroidElement> androidDriver() {
        return (AndroidDriver<AndroidElement>)
                ((WebDriverFacade) getDriver()).getProxiedDriver();
    }
    public void usuarioCorrecto (){
        androidDriver().getKeyboard();
        androidDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        androidDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        androidDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        androidDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        androidDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_7));
        androidDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_0));
        androidDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_0));
        androidDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_9));
        androidDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_4));
        androidDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_2));
    }
}
