package com.escuelaing.edu.co.distribuited_systems.batch_service.steps.chunk.writers;

import com.escuelaing.edu.co.distribuited_systems.batch_service.clients.ApiGatewayClientRest;
import com.escuelaing.edu.co.distribuited_systems.batch_service.dto.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/6/2024
 */
@Slf4j
@Component
public class SnsRequestItemProcessor implements ItemWriter<NotificationRequest> {
    private final ApiGatewayClientRest apiGatewayClientRest;

    public SnsRequestItemProcessor(@Autowired ApiGatewayClientRest apiGatewayClientRest) {
        this.apiGatewayClientRest = apiGatewayClientRest;
    }

    @Override
    public void write(Chunk<? extends NotificationRequest> chunk) throws Exception {
        log.info("Processing chunk with size {}", chunk.getItems().size());
        chunk.getItems().forEach(notificationRequest -> {
            try {
                apiGatewayClientRest.sendNotification(notificationRequest);
            } catch (Exception exception) {
                log.error("Error enviando el correo:{}, causa: {}", notificationRequest.getEmail(),
                        exception.getMessage());
            }
        });
    }
}
