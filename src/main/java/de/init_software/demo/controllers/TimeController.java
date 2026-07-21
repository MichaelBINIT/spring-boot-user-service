package de.init_software.demo.controllers;

import de.init_software.demo.services.TimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

  private final TimeService timeService;

  public TimeController(TimeService timeService) {
    this.timeService = timeService;
  }

  @GetMapping("/getCurrentTime/{timeZone}")
  public String getCurrentTime(@PathVariable String timeZone) {
    return timeService.getCurrentTime(timeZone);
  }
}
