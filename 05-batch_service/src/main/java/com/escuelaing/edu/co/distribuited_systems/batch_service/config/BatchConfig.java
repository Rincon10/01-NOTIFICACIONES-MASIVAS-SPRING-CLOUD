package com.escuelaing.edu.co.distribuited_systems.batch_service.config;

import com.escuelaing.edu.co.distribuited_systems.batch_service.dto.NotificationResponse;
import com.escuelaing.edu.co.distribuited_systems.batch_service.entities.Client;
import com.escuelaing.edu.co.distribuited_systems.batch_service.steps.chunk.processors.ClientItemProcessor;
import com.escuelaing.edu.co.distribuited_systems.batch_service.steps.chunk.readers.ClientItemReader;
import com.escuelaing.edu.co.distribuited_systems.batch_service.steps.chunk.writers.SnsRequestItemProcessor;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 12/6/2024
 */
@Configuration
public class BatchConfig {
    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.escuelaing.edu.co.distribuited_systems.batch_service.entities");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }

    @Bean
    public JobRepository jobRepository(DataSource dataSource,PlatformTransactionManager transactionManager) throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(transactionManager);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("clientJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository,
                     PlatformTransactionManager transactionManager,
                     ItemProcessor processor,
                     SnsRequestItemProcessor writer) {
        return new StepBuilder("chunkStep", jobRepository)
                .<Client, NotificationResponse>chunk(10, transactionManager)
                .allowStartIfComplete(true)
                .reader(clientItemReader(null))
                .processor(processor)
                .writer(writer)
                .build();
    }


    @Bean
    public JpaPagingItemReader<Client> clientItemReader(EntityManagerFactory entityManagerFactory) {
        JpaPagingItemReader<Client> reader = new JpaPagingItemReader<>();
        reader.setEntityManagerFactory(entityManagerFactory);
        reader.setQueryString("SELECT c FROM Client c");
        reader.setPageSize(10);
        return reader;
    }


}
