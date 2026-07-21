package de.init_software.demo.services;

import de.init_software.demo.config.TimeAPIConfig;
import de.init_software.demo.model.TimeApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TimeServiceImpl implements TimeService {

  private final TimeAPIConfig timeAPIConfig;
  private final RestClient restClient;

  public TimeServiceImpl(TimeAPIConfig timeAPIConfig) {
    this.timeAPIConfig = timeAPIConfig;
    this.restClient = RestClient.create();
  }

  @Override
  public String getCurrentTime(String timeZone) {

    TimeApiResponse response =
            restClient.get()
                    .uri(timeAPIConfig.getEndpoint()
                            + timeAPIConfig.getContinent()
                            + timeZone)
                    .retrieve()
                    .body(TimeApiResponse.class);

    return response.getFormatted();
  }
}
