package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan(basePackages = "com.example.resources")
@Configuration
public class ExternalConfig {
    @Bean
    public Row row(){
        return new Row();
    }

}
