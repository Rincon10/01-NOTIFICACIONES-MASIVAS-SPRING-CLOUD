package com.escuelaing.edu.co.distribuited_systems.notification_service.config.data;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/5/2024
 */

@Component
@ConfigurationProperties(prefix = "aws")
@Data
public class AWSConfigData {

    private String accessKeyId;
    private String secretAccessKey;
    private String sessionToken;
    private String region;

}
