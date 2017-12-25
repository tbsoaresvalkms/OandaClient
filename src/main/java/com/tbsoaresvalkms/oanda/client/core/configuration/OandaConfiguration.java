package com.tbsoaresvalkms.oanda.client.core.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "oanda")
@Setter
@Getter
public class OandaConfiguration implements ServiceConfiguration {
    private String url;
    private String token;
}
