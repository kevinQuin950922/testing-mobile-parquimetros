package co.com.flypass.utils.apiFlypass;

import io.restassured.response.Response;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static co.com.flypass.utils.apiFlypass.RequestLogin.login;
import static co.com.flypass.utils.apiZER.RegistrarIngreso.registrarIngresoASF;
import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.rest;

public class CreateTransaction {
    public void createTransactionFromASF(String plate, String minutosAnticipado, String valor){
        Boolean intentos = true;
        int intentosInt = 3;
        String cuerpo = new String();
        while (intentos && intentosInt!=0){
            List valoresASF = registrarIngresoASF(minutosAnticipado,valor);
            String codigoEstado = valoresASF.get(0).toString();
            if (codigoEstado.equals("200")){
                intentos=Boolean.FALSE;
                String tiquete = valoresASF.get(1).toString();
                String ingresoId = valoresASF.get(2).toString();
                String transactionId = valoresASF.get(3).toString();
                String fechaEnd = LocalDateTime.now().plusMinutes(300+Integer.parseInt(minutosAnticipado)).format(DateTimeFormatter.ISO_DATE_TIME);
                String fechaStard =  LocalDateTime.now().plusMinutes(300).format(DateTimeFormatter.ISO_DATE_TIME);
                cuerpo="{\"amount\":"+valor+",\"endDate\":\""+fechaEnd+"\",\"accountingDate\":\""+fechaStard+
                        "\",\"ingresoId\":"+ingresoId+",\"minutes\":"+minutosAnticipado+",\"plate\":\""+plate+"\",\"readingType\": \"1\",\"taxesAmount\": 0.0," +
                        "\"transactionId\":\""+transactionId+"\",\"tiquete\":"+tiquete+",\"stationId\": \"100101\","+"\"details\":"+"[{\"amount\":"+
                        valor+",\"description\": \"Description detail 286_ALS124_ov6NCNEwq55\",\"movementDate\":\""+
                        fechaStard+"\",\"endMovementDate\":\""+fechaEnd+"\",\"serviceType\":\"8\",\"taxesAmount\":0.0}]}";
            }
            else{
                intentosInt=intentosInt-1;
            }
        }
        String token = login();
        Response respuesta = rest().with().header("Authorization", token).given()
                .contentType("application/json").body(cuerpo)
                .post("https://test.services.flypass.co/parkingMeter/api/v1/transactions");
        System.out.println(respuesta.statusCode());
        System.out.println(respuesta.body());
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CreateTransaction createTransaction = new CreateTransaction();
        createTransaction.createTransactionFromASF("ABC185","60","3400");
    }

}
