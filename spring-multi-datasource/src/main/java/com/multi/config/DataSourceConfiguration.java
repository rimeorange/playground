package com.multi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(
        basePackages = "com.multi.product",
        entityManagerFactoryRef = "firstDatabaseEntityManagerFactory",
        transactionManagerRef = "firstTransactionManager"
)
public class DataSourceConfiguration {
    @Bean
    @Primary
    public DataSourceProperties dataSourceProperties() {
             return new DataSourceProperties();
    }


    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean firstDatabaseEntityManagerFactory(DataSourceProperties dataSourceProperties) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource(dataSourceProperties ));
        em.setPackagesToScan("org.multi.product");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    @Primary
    public DataSource dataSource( DataSourceProperties dataSourceProperties) {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
      dataSource.setUrl(dataSourceProperties.getJdbcUrl());
      dataSource.setUsername(dataSourceProperties.getUsername());
      dataSource.setPassword(dataSourceProperties.getPassword());

      return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager firstTransactionManager(DataSourceProperties dataSourceProperties)  {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                firstDatabaseEntityManagerFactory(dataSourceProperties).getObject());
        return transactionManager;
    }


}
