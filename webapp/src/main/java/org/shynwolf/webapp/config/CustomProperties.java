package org.shynwolf.webapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("webapp")
public class CustomProperties {

    private String apiUrl;
}
