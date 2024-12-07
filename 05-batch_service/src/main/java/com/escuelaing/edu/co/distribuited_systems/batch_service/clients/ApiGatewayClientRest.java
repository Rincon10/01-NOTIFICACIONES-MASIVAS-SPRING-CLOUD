package com.escuelaing.edu.co.distribuited_systems.batch_service.clients;

import com.escuelaing.edu.co.distribuited_systems.batch_service.dto.NotificationRequest;
import com.escuelaing.edu.co.distribuited_systems.batch_service.dto.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/6/2024
 */

@FeignClient(name = "api-gateway-service")
public interface ApiGatewayClientRest {

    @PostMapping("/api/notifications")
    ResponseEntity<NotificationResponse> sendNotification(@RequestBody NotificationRequest notificationRequest);
}
