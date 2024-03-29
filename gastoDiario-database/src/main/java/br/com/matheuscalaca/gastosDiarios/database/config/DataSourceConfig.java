package br.com.matheuscalaca.gastosDiarios.database.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${gastodiario.database.host}")
    private String host;
    @Value("${gastodiario.database.username}")
    private String username;
    @Value("${gastodiario.database.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url(host)
                .username(username)
                .password(password)
                .build();
    }
}