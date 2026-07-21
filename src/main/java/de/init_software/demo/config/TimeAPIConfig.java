package de.init_software.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api")
public class TimeAPIConfig {
  private String endpoint;

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint( String endpoint ) {
    this.endpoint = endpoint;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent( String continent ) {
    this.continent = continent;
  }

  private String continent;
}
