package co.com.flypass.utils.apiZER;

import co.com.flypass.utils.apiFlypass.CreateTransaction;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.json.JSONObject;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static co.com.flypass.utils.apiZER.TokenRequest.getToken;
import static net.serenitybdd.rest.SerenityRest.rest;

public class RegistrarIngreso {
    public static String crearPlaca (){
        Random random = new Random();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder plate = new StringBuilder();

        // Generar las primeras tres letras aleatorias
        for (int i = 0; i < 3; i++) {
            char letra = letters.charAt(random.nextInt(letters.length()));
            plate.append(letra);
        }

        // Generar los últimos tres dígitos aleatorios
        for (int i = 0; i < 3; i++) {
            int digito = random.nextInt(10);
            plate.append(digito);
        }
        return plate.toString();
    }

    public static List<String> registrarIngresoASF (String minutosAnticipado, String valor){
        List <String> listadoValores = new ArrayList<>();
        Random random = new Random();
        String placa= crearPlaca();
        String codigoParquimetro = "100101";
        String referencia="test_"+placa+"_"+random.nextInt(100);
        String token = getToken();
        String cuerpo = "{\"placa\": \""+placa+"\",\"codigoParquimetro\": \""+codigoParquimetro+"\",\"referencia\": \""+referencia+"\"," +
                "\"minutosAnticipado\": "+minutosAnticipado+",\"valor\": "+valor+"}";

        Response respuesta = rest().with().header("Authorization", "Bearer "+token).given().contentType("application/json")
                .body(cuerpo).post("http://sistemattm-001-site5.mysitepanel.net/integracionesApi/zer/external/ingreso/crear");
        JSONObject cuerpoRespuesta = new JSONObject(respuesta.getBody().asString());
        JSONObject dataJson = new JSONObject(cuerpoRespuesta.get("data").toString());
        String tiquete = dataJson.get("tiquete").toString();
        String ingresoId = dataJson.get("ingresoId").toString();

        listadoValores.add(String.valueOf(respuesta.getStatusCode()));
        listadoValores.add(tiquete);
        listadoValores.add(ingresoId);
        listadoValores.add(referencia);
        return listadoValores;//statuscode,tiquete,IngresoId, referencia
    }
}
