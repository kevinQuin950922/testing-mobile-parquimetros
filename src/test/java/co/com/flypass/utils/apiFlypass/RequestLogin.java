package co.com.flypass.utils.apiFlypass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.rest;

public class RequestLogin {
    public static String login (){
        String cuerpo= "{\"username\": \"14\",\"password\":\"password\"}";
        Response respuesta =rest().header("x-forwarded-for", "S").given()
                .contentType("application/json").body(cuerpo)
                .post("https://test.services.flypass.co/parkingMeter/login");
        List<Header> autorizacion = respuesta.getHeaders().getList("authorization");
        String token = autorizacion.get(0).getValue();
        return token;
    }

}
