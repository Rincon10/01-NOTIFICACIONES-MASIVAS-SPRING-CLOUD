package com.escuelaing.edu.co.distribuited_systems.batch_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/6/2024
 */
@Data
@AllArgsConstructor
@Builder
public class NotificationRequest {
    private String email;
    private String message;
    private String subject;
}
