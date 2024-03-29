package com.ems.ems.utils;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.datasource")
@Configuration
public class AppProperties implements Serializable {
    private String username;
    private String password;
}
