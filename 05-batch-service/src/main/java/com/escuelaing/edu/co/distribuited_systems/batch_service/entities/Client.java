package com.escuelaing.edu.co.distribuited_systems.batch_service.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/6/2024
 */
@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "CONTACTFORM")
    private String contactForm;
}
