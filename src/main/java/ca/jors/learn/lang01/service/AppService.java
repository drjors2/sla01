package ca.jors.learn.lang01.service;

import ca.jors.learn.lang01.collaterals.UserSla;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppService {

  public static void run() {
    run1();
    slaMet();
    slaNotMet();
  }

  public static void run1() {
    var userSla = new UserSla();
    log.info("ddt {}", userSla.getDueDateTime());
    userSla.setSlaHours(5L);
    log.info("due: {}", userSla.getDueDateTime());
    userSla.start();
    log.info("due: {}", userSla.getDueDateTime());
    log.info("slaMet?: {}", userSla.isSlaMet());
  }

  public static void slaMet() {
    var userSla = new UserSla();
    log.info("ddt {}", userSla.getDueDateTime());
    userSla.start();
    log.info("due: {}", userSla.getDueDateTime());
    userSla.setSlaHours(5L);
    log.info("due: {}", userSla.getDueDateTime());
    log.info("end: {}", userSla.getEndDateTime());
    userSla.end();
    log.info("end: {}", userSla.getEndDateTime());
    log.info("slaMet?: {}", userSla.isSlaMet());
  }

  public static void slaNotMet() {
    var userSla = new UserSla();
    log.info("ddt {}", userSla.getDueDateTime());
    userSla.start();
    log.info("due: {}", userSla.getDueDateTime());
    userSla.setSlaHours(-1L);
    log.info("due: {}", userSla.getDueDateTime());
    log.info("end: {}", userSla.getEndDateTime());
    userSla.end();
    log.info("end: {}", userSla.getEndDateTime());
    log.info("slaMet?: {}", userSla.isSlaMet());
  }
}
