package com.escuelaing.edu.co.distribuited_systems.batch_service.services;

import com.escuelaing.edu.co.distribuited_systems.batch_service.dto.BatchResponse;
import org.springframework.stereotype.Service;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/6/2024
 */

@Service
public class JobServiceImpl implements JobService {
//    @Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    Job job;

    @Override
    public BatchResponse startJob() {
//        try {
//            JobExecution execution = jobLauncher.run(job, new JobParameters());
//
//            return BatchResponse.builder()
//                    .httpStatusCode(HttpStatus.ACCEPTED)
//                    .message("Job executed with status: " + execution.getStatus())
//                    .build();
//
//        } catch (Exception e) {
//            return BatchResponse.builder()
//                    .httpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .message("Error executing job: " + e.getMessage())
//                    .build();
//        }
        return null;
    }

}
