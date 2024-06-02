package com.hisab.hisab.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsConfig {
    @Value("${aws.access_key_id}")
    private String awsAccessKey;

    @Value("${aws.secret_access_key}")
    private String awsSecretKey;

    @Value("${AWS_REGION}")
    private String awsRegion;

    @Bean
    public AwsCredentials awsCredentials() {
        return AwsBasicCredentials.create(awsAccessKey, awsSecretKey);
    }

    @Bean
    public AwsCredentialsProvider awsCredentialsProvider() {
        return StaticCredentialsProvider.create(awsCredentials());
    }

    @Bean
    public S3Client s3Client(AwsCredentialsProvider awsCredentialsProvider) {
        return S3Client.builder()
                .credentialsProvider(awsCredentialsProvider)
                .region(Region.of(awsRegion))
                .build();
    }
}
