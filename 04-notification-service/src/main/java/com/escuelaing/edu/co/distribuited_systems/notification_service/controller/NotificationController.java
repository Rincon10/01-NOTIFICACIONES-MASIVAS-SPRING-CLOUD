package com.escuelaing.edu.co.distribuited_systems.notification_service.controller;

import com.escuelaing.edu.co.distribuited_systems.notification_service.dto.NotificationRequest;
import com.escuelaing.edu.co.distribuited_systems.notification_service.dto.NotificationResponse;
import com.escuelaing.edu.co.distribuited_systems.notification_service.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/5/2024
 */
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<NotificationResponse> sendNotification(@RequestBody NotificationRequest request) {

        var response = notificationService.sendNotification(request);
        return ResponseEntity.status(response.getHttpStatusCode().value())
                .body(response);
    }
}
