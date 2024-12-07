package com.escuelaing.edu.co.distribuited_systems.batch_service.controllers;

import com.escuelaing.edu.co.distribuited_systems.batch_service.dto.BatchResponse;
import com.escuelaing.edu.co.distribuited_systems.batch_service.services.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/6/2024
 */
@RestController
@RequestMapping("/batch")
public class BatchController {
    private final JobService jobService;

    public BatchController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping("/start")
    public ResponseEntity<BatchResponse> startBatch() {
        var response = jobService.startJob();
        return ResponseEntity.status(response.getHttpStatusCode().value())
                .body(response);
    }
}
