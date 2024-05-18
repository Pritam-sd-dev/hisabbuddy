package com.hisab.hisab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.time.Duration;

@Service
public class AwsService {

    String awsRegion;
    AwsCredentialsProvider awsCredentialsProvider;

    @Autowired
    public AwsService(
            AwsCredentialsProvider awsCredentialsProvider,
            @Value("${AWS_REGION}") String awsRegion
    ) {
        this.awsCredentialsProvider = awsCredentialsProvider;
        this.awsRegion = awsRegion;
    }

    public String generatePreSignedUrlForImageUpload(String bucketName, String keyName) {
        try {
            System.out.println(awsRegion);
            Region region = Region.of(awsRegion);
            S3Presigner presigner = S3Presigner.builder()
                    .credentialsProvider(awsCredentialsProvider)
                    .region(region).build();

            PutObjectRequest objectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(keyName)
                    .contentType("image/jpeg")
                    .build();

            PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(2)) // The URL will expire in 10 minutes.
                    .putObjectRequest(objectRequest)
                    .build();

            PresignedPutObjectRequest presignedRequest = presigner.presignPutObject(presignRequest);
            presigner.close();
            return presignedRequest.url().toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
