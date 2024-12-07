package com.escuelaing.edu.co.distribuited_systems.batch_service.steps.chunk.processors.helper;

import com.escuelaing.edu.co.distribuited_systems.batch_service.dto.NotificationRequest;
import com.escuelaing.edu.co.distribuited_systems.batch_service.entities.Client;
import org.springframework.stereotype.Component;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/6/2024
 */
@Component
public class ClientItemProcessorHelper {


    public NotificationRequest clientEntityToNotificationRequest(Client client) {
        return NotificationRequest.builder()
                .email(client.getContactForm())
                .message("Default Message for client " + client.getId())
                .subject("Default Subject")
                .build();
    }
}
