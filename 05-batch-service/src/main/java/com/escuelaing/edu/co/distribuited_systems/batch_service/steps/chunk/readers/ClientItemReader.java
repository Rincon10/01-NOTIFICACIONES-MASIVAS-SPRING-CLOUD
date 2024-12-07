package com.escuelaing.edu.co.distribuited_systems.batch_service.steps.chunk.readers;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.item.database.JpaPagingItemReader;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/6/2024
 */
public class ClientItemReader extends JpaPagingItemReader {


    public ClientItemReader(EntityManagerFactory entityManagerFactory) {
        setEntityManagerFactory(entityManagerFactory);
        this.setQueryString("SELECT c FROM Client c");
        this.setPageSize(10);
    }
}
