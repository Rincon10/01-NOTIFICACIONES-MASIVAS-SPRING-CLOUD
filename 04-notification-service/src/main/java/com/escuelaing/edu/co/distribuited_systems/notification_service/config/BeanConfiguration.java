package com.escuelaing.edu.co.distribuited_systems.notification_service.config;

import com.escuelaing.edu.co.distribuited_systems.notification_service.config.data.AWSConfigData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/5/2024
 */
@Configuration
public class BeanConfiguration {
    private final AWSConfigData awsProperties;

    public BeanConfiguration(AWSConfigData awsProperties) {
        this.awsProperties = awsProperties;
    }


    @Bean
    public SnsClient snsClient() {
        AwsCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(
                AwsSessionCredentials.create(
                        awsProperties.getAccessKeyId(),
                        awsProperties.getSecretAccessKey(),
                        awsProperties.getSessionToken()
                )
        );

        return SnsClient.builder()
                .credentialsProvider(credentialsProvider)
                .region(Region.of(awsProperties.getRegion()))
                .build();
    }
}
