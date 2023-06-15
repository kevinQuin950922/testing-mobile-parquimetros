package co.com.flypass.utils.dynamodb;



import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

public class Consulta {

    public static void consultarTabla(){
        DynamoDbClient cliente = ClienteDynamo.conexionDynamo();
        ScanRequest request = ScanRequest.builder()
                .tableName("cert_VehiclesCollection")
                .build();
        ScanResponse response = cliente.scan(request);
        response.items().forEach(item -> {
            // Acceder a los atributos del item
            AttributeValue atributo = item.get("dsplaca");
            AttributeValue atributo1 = item.get("vrsaldo_disponible");

            // Realizar las operaciones deseadas con el atributo
            if ((atributo.s()).equals("ABC185") || (atributo.s()).equals("ABC186")){
                System.out.println(atributo1.n());
                UpdateItemRequest request1 = UpdateItemRequest.builder()
                        .tableName("cert_VehiclesCollection")
                        .key(Map.of(
                                "dsplaca", AttributeValue.builder().s(atributo.s()).build()
                        ))
                        .updateExpression("SET vrsaldo_disponible = :valor")
                        .expressionAttributeValues(Map.of(
                                ":valor", AttributeValue.builder().n("200000").build()
                        ))
                        .build();

                // Ejecutar la actualización
                cliente.updateItem(request1);

                System.out.println("Elemento actualizado correctamente.");
            }

        });
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Se llama al método de consulta pasando el nombre de la tabla como parámetro
        Consulta.consultarTabla();
    }


}


