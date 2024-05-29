package ca.jors.learn.lang01.service;

import ca.jors.learn.lang01.collaterals.UserSla;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppService {

  public static void run() {
    run2();
  }

  public static void run1() {
    var userSla = new UserSla();
    log.info("ddt {}", userSla.getDueDateTime());
    userSla.setSlaHours(5L);
    log.info("due: {}", userSla.getDueDateTime());
    userSla.start();
    log.info("due: {}", userSla.getDueDateTime());
  }

  public static void run2() {
    var userSla = new UserSla();
    log.info("ddt {}", userSla.getDueDateTime());
    userSla.start();
    log.info("due: {}", userSla.getDueDateTime());
    userSla.setSlaHours(5L);
    log.info("due: {}", userSla.getDueDateTime());
    log.info("end: {}", userSla.getEndDateTime());
    userSla.end();
    log.info("end: {}", userSla.getEndDateTime());
  }
}
