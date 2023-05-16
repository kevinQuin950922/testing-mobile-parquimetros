package co.com.flypass.utils.dynamodb;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Consulta {

    public static void consultarTabla(){
//        AmazonDynamoDB dynamoDbClient = ClienteDynamo.conexionDynamo();
//        DynamoDB dynamoDB = new DynamoDB(dynamoDbClient);
//        Table tabla = dynamoDB.getTable("cert_ParkingmeterNotificationCollection");
//        System.out.println(tabla);
        DynamoDbClient dynamoDbClient = ClienteDynamo.conexionDynamo();
        queryTable(dynamoDbClient,"cert_ParkingmeterNotificationCollection","transactionId","test_ABC185_70");
    }
    public static void queryTable(DynamoDbClient ddb,String tableName,String key,String keyVal ) {

        HashMap<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put(key, AttributeValue.builder()
                .s(keyVal)
                .build());

        GetItemRequest request = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(tableName)
                .build();

        try {
            Map<String, AttributeValue> returnedItem = ddb.getItem(request).item();
            if (returnedItem != null) {
                Set<String> keys = returnedItem.keySet();
                System.out.println("Amazon DynamoDB table attributes: \n");

                for (String key1 : keys) {
                    System.out.format("%s: %s\n", key1, returnedItem.get(key1).toString());
                }
            } else {
                System.out.format("No item found with the key %s!\n", key);
            }

        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }



    public static void main(String[] args) {
        // Se llama al método de consulta pasando el nombre de la tabla como parámetro
        Consulta.consultarTabla();
    }


}


