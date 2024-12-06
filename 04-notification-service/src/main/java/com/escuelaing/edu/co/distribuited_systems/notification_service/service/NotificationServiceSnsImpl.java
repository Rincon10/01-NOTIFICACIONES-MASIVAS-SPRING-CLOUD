package com.escuelaing.edu.co.distribuited_systems.notification_service.service;

import com.escuelaing.edu.co.distribuited_systems.notification_service.config.data.SNSConfigData;
import com.escuelaing.edu.co.distribuited_systems.notification_service.dto.NotificationRequest;
import com.escuelaing.edu.co.distribuited_systems.notification_service.dto.NotificationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

import java.util.Optional;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/5/2024
 */
@Service
public class NotificationServiceSnsImpl implements NotificationService {

    private final SnsClient snsClient;
    private final SNSConfigData snsConfigData;

    public NotificationServiceSnsImpl(SnsClient snsClient, SNSConfigData snsConfigData) {
        this.snsClient = snsClient;
        this.snsConfigData = snsConfigData;
    }


    @Override
    public NotificationResponse sendNotification(NotificationRequest request) {
        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(snsConfigData.getTopic())
                .message(request.getMessage())
                .subject(Optional.ofNullable(snsConfigData.getTopicDefaultSubject()).orElse(request.getSubject()))
                .build();

        NotificationResponse notificationResponse = null;

        try {
            PublishResponse publishResponse = snsClient.publish(publishRequest);
            notificationResponse = NotificationResponse.builder()
                    .httpStatusCode(HttpStatus.ACCEPTED)
                    .message("Notification sent with message ID: " + publishResponse.messageId())
                    .build();
        } catch (Exception exception) {
            notificationResponse = NotificationResponse.builder()
                    .httpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("some error sending the email")
                    .build();

        }
        return notificationResponse;
    }
}
