package co.com.flypass.utils.apiZER;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.rest;

public class TokenRequest{
    public static String getToken(){
        String usuario = "flypass@integracionesterminal.com";
        String contrasena = "8v78pARhgweNF2R";
        String cuerpo = "grant_type=password" + "&username=" + usuario + "&password=" + contrasena;
        Response respuesta = rest().given().contentType("application/x-www-form-urlencoded")
                .body(cuerpo).post("http://sistemattm-001-site5.mysitepanel.net/integracionesApi/oauth/token");
        String cuerpoRespuesta = respuesta.getBody().asString();
        String token = JsonPath.with(cuerpoRespuesta).get("access_token");
        return token;
    }
}
