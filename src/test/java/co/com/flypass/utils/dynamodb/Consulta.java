package co.com.flypass.utils.dynamodb;



import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.sql.SQLException;
import java.util.Iterator;

public class Consulta {

    public static void consultarTabla(){
        DynamoDbClient cliente = ClienteDynamo.conexionDynamo();
        DynamoDB dynamoDB = new DynamoDB((AmazonDynamoDB) cliente);
        Table tabla = dynamoDB.getTable("cert_ParkingmeterNotificationCollection");

        QuerySpec query = new QuerySpec()
                .withFilterExpression("plate=ABC185");
        ItemCollection<QueryOutcome> items = tabla.query(query);

        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println(item.toJSON());
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Se llama al método de consulta pasando el nombre de la tabla como parámetro
        Consulta.consultarTabla();
    }


}


