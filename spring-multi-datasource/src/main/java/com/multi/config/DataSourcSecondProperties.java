package com.multi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("spring.datasource-second.hikari")
public class DataSourcSecondProperties {
    private String driverClassName;
    private String jdbcUrl;
    private String username;
    private String password;
}
