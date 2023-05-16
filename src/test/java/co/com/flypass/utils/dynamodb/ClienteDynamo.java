package co.com.flypass.utils.dynamodb;


import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.seleniumhq.jetty9.util.security.CredentialProvider;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

import static javax.crypto.Cipher.SECRET_KEY;

public class ClienteDynamo {

    public static DynamoDbClient conexionDynamo() {
//        // Obtener las credenciales de AWS
        String accessKey = "ASIAZE7LHG2A26MU4LU3";
        String secretKey = "yZ2TUDLiwJN04u1sCn9TPinlwY6+n6EJHKcOJXmw";
        String token = "IQoJb3JpZ2luX2VjEKf//////////wEaCXVzLWVhc3QtMSJGMEQCIB7igV3wMLM/aJ1Ooxm37nMchVSFaVniW76sqlpIvIkdAiAaYKdhtl5RVtLLUy3YacFOmbomiLDXfilooB+ocKiBTiqTAwjA//////////8BEAAaDDYyOTE2OTE0MTM3NyIMl25q2W3ehRfM0tbnKucCLIN2uGnCFoGslGLMEIENzhdJmMCKzag9ZuDKTZ+Vnf3F5+YBWddIT0duyVqk5sMLbsTH/BAfu4p9hBsOC6LE0yjLt567LQa1ZGZpKHyu9fZbXrrGIGt+vw3Yu/IIJM+Ejcb54UfmmdC2paS3T4Ml5OY4BVTlog6GySpifNI+DaRyFsQG1+g3g7798mA7DRsYT2Ww9dp0ozIMz7Mpq2ox/vwLbHNxE3QBAbDzQOMQT8G3YqEtNkEQj5c1dlWm6MzHqcbBoC65yeYTLvqdvPPao6gHGu/Jvkk7mQxr86YqJGdCVvsZePr2pFovg7DZSudmded+yE/sBzQt/fMMj8DN/pifMnQLV3sziB55PPfoLsw0GbLjDhnUAGO1yt32RE1w6SeATvUGMzek914Z9wPrdsVEZekcTca7K2JdH7Xdzwjhh82q7PFA6yoRFSAn1sQDGBkMYlrhWNWo+i324mkv23AutiNonQswqKH5ogY6pwFKn0E70wph19pkwWVw23Wc80OIn0sACCiPuqkLopkpgZj8YOxBX7WpvKGk4coqTu3OzRbSs8cX246TNeCEDKmZBe06Ogdoy+VzIwpYckBr0wxKrcEqUYKOHHPTFhuGI8WkClR45dglWJWBCMFi8tUmbI+thaZoJc0Vj8ZdnzQNuwNoSMlZXwujpEzR478UVtq4fv+hkPknOPurQsuPkbt4CHBL/e6ajg==";        System.setProperty("aws.accessKeyId", accessKey);
        System.setProperty("aws.accessKeyId", accessKey);
        System.setProperty("aws.secretAccessKey",secretKey);
        System.setProperty("aws.sessionToken",token);

//
//
//        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration("https://flypass.awsapps.com/start#","us-east-1");
//        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
//        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
//                .withCredentials(new AWSStaticCredentialsProvider(credentials))
//                .withEndpointConfiguration(endpointConfiguration)
//                .build();


//        // Crear el cliente de DynamoDB
        Region region = Region.US_EAST_1;
        DynamoDbClient dynamoDB = DynamoDbClient.builder()
                .endpointOverride(URI.create("https://flypass.awsapps.com/start#"))
                .region(region)
                .credentialsProvider(SystemPropertyCredentialsProvider.create())
                .build();
        return dynamoDB;
    }
}
