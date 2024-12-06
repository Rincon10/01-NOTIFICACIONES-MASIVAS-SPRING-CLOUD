package com.escuelaing.edu.co.distribuited_systems.notification_service.service;

import com.escuelaing.edu.co.distribuited_systems.notification_service.dto.NotificationRequest;
import com.escuelaing.edu.co.distribuited_systems.notification_service.dto.NotificationResponse;

public interface NotificationService {

    NotificationResponse sendNotification(NotificationRequest request);
}
