package co.com.flypass.utils.dynamodb;


import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class ClienteDynamo {

    public static DynamoDbClient conexionDynamo() {
        AwsSessionCredentials credentials = AwsSessionCredentials.create(
                "",
                "",
                ""
        );

        AwsCredentialsProvider provider = () -> credentials;
        DynamoDbClient client = DynamoDbClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(provider)
                .build();

        return client;
    }
}
