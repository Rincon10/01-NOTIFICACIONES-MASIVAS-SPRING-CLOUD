package com.escuelaing.edu.co.distribuited_systems.notification_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/5/2024
 */
@Data
@AllArgsConstructor
@Builder
public class NotificationResponse {
    private HttpStatusCode httpStatusCode;
    private String message;
}
