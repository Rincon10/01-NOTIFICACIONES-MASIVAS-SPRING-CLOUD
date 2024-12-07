package com.escuelaing.edu.co.distribuited_systems.batch_service.steps.chunk.processors;

import com.escuelaing.edu.co.distribuited_systems.batch_service.dto.NotificationRequest;
import com.escuelaing.edu.co.distribuited_systems.batch_service.entities.Client;
import com.escuelaing.edu.co.distribuited_systems.batch_service.steps.chunk.processors.helper.ClientItemProcessorHelper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/6/2024
 */
@Component
public class ClientItemProcessor implements ItemProcessor<Client, NotificationRequest> {
    private final ClientItemProcessorHelper clientItemProcessorHelper;

    public ClientItemProcessor(ClientItemProcessorHelper clientItemProcessorHelper) {
        this.clientItemProcessorHelper = clientItemProcessorHelper;
    }

    @Override
    public NotificationRequest process(Client item) throws Exception {
        return clientItemProcessorHelper.clientEntityToNotificationRequest(item);
    }
}
