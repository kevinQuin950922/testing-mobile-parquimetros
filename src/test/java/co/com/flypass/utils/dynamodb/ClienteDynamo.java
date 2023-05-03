package co.com.flypass.utils.dynamodb;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class ClienteDynamo {

    public static DynamoDbClient conexionDynamo() {
        AwsSessionCredentials credentials = AwsSessionCredentials.create(
                "ASIAZE7LHG2AVYWW7VRH",
                "v9zdgTN7aaZBcK2YQIBUrcfgqDCN3MhSLDLML7MC",
                "IQoJb3JpZ2luX2VjELj//////////wEaCXVzLWVhc3QtMSJGMEQCIHM38uoqPSkgALZrVUDglcFtkzCpcwqpWs+X6p+R+lK9AiAuOteDylbkui7/bjeXShudKLG5PaJWE/bCt/cnnp7cyiqUAwix//////////8BEAAaDDYyOTE2OTE0MTM3NyIMNMRG8VsA+Ft+99UYKugCadzgv2X/MDjE4Rvho3S24LoTLyLxslrYdp8I+u1OyIgdT55pGrmZiN8oB8M3Xscjn94pQJpELa7BvT1D3YHH068TnFBDUDqSBi/gPzQp+aINSvvas+jTD6WqMB9utEB/UzmAFMMCW90ngQjk+lQHwpkh6YpGNUlShPlmrzj2jakHO57ankk806w/6IVDV19qgZxP3a4/m2M2R0gYEZCy1a8XQClqyYGVnK+/u3IbnCN6oCyFnIex5+PaLwLTtVoLN0s21kv60KILl8PsVtOCmn/t2hSD4/g3B6rrx1Rb6NNPJRCuyYzA/Kzgj2L33hFVbo0mtVfvF96Lo6ajcGbJ9BF+UFtN5883N/GYvyO52dsPm2BGY/jxl3By8WOnIqxOe/V+FNIRcSVRFJIRAVhL9XuP2zJUgF+8R2wMe3n9oaszT1gvRckiGEHhJbPSXIOPDWWtOVDID3HJWcGPfQXXAAlHG57sVj4IMNi5jKIGOqcBYdsqHbYXLextDpdqDrvnrD2OI4TGxvq3gRH3aWfoSXTIiSY+gwsxeOEpVPr7UIqx5vcCtm6CdfUoPx8ErKjiD6T8o2KIGx5uhQ61hktQK27al8FtOpwwLZNOGvUeIhrlyizVBsnvN56oh39JH6gx2qEL77UprfmzKOV2DcGoc4OBPBJNNtwi4r9UrndTlG30PNfNrS9x2h1hkWpoQMliGCl/GDswkpM="
        );

        AwsCredentialsProvider provider = () -> credentials;
        DynamoDbClient client = DynamoDbClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(provider)
                .build();

        return client;
    }
}
