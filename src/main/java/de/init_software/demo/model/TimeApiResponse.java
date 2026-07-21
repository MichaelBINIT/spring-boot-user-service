package de.init_software.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class TimeApiResponse {
  private String formatted;

  public TimeApiResponse(){}

  public String getFormatted() {
    return formatted;
  }

  public void setformatted( String formatted ) {
    this.formatted = formatted;
  }
}
