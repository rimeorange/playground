package com.multi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(
        basePackages = "com.multi.test2",
        entityManagerFactoryRef = "secondDatabaseEntityManagerFactory",
        transactionManagerRef = "secondTransactionManager"
)
public class DataSourceSecondConfiguration {
    @Bean
    public DataSourcSecondProperties dataSourcSecondProperties() {
             return new DataSourcSecondProperties();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondDatabaseEntityManagerFactory(DataSourcSecondProperties dataSourcSecondProperties) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSecondSource(dataSourcSecondProperties ));
        em.setPackagesToScan("com.multi.test2");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    public DataSource dataSecondSource(DataSourcSecondProperties dataSecondSourceProperties){
              DriverManagerDataSource dataSecondSource = new DriverManagerDataSource();
                dataSecondSource.setDriverClassName(dataSecondSourceProperties.getDriverClassName());
                dataSecondSource.setUrl(dataSecondSourceProperties.getJdbcUrl());
                dataSecondSource.setUsername(dataSecondSourceProperties.getUsername());
                dataSecondSource.setPassword(dataSecondSourceProperties.getPassword());

              return dataSecondSource;
    }

    @Bean
    public PlatformTransactionManager secondTransactionManager(DataSourcSecondProperties dataSecondSourceProperties){

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                secondDatabaseEntityManagerFactory(dataSecondSourceProperties).getObject());
        return transactionManager;
    }


}
