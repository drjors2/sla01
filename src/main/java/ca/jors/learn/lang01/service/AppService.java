package ca.jors.learn.lang01.service;

import ca.jors.learn.lang01.collaterals.UserSla;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppService {

  private AppService() {}

  private static final String END_MESSAGE = "end: {}";
  private static final String SLA_MET_MESSAGE = "slaMet?: {}";
  private static final String DUE_MESSAGE = "due: {}";
  private static final String DDT_MESSAGE = "ddt {}";

  public static void run() {
    run1();
    slaMet();
    slaNotMet();
  }

  public static void run1() {
    var userSla = new UserSla();
    log.info(DDT_MESSAGE, userSla.getDueDateTime());
    userSla.setSlaHours(5L);
    log.info(DUE_MESSAGE, userSla.getDueDateTime());
    userSla.start();
    log.info(DUE_MESSAGE, userSla.getDueDateTime());
    log.info(SLA_MET_MESSAGE, userSla.isSlaMet());
  }

  public static void slaMet() {
    var userSla = new UserSla();
    log.info(DDT_MESSAGE, userSla.getDueDateTime());
    userSla.start();
    log.info(DUE_MESSAGE, userSla.getDueDateTime());
    userSla.setSlaHours(5L);
    log.info(DUE_MESSAGE, userSla.getDueDateTime());
    log.info(END_MESSAGE, userSla.getEndDateTime());
    userSla.end();
    log.info(END_MESSAGE, userSla.getEndDateTime());
    log.info(SLA_MET_MESSAGE, userSla.isSlaMet());
  }

  public static void slaNotMet() {
    var userSla = new UserSla();
    log.info(DDT_MESSAGE, userSla.getDueDateTime());
    userSla.start();
    log.info(DUE_MESSAGE, userSla.getDueDateTime());
    userSla.setSlaHours(-1L);
    log.info(DUE_MESSAGE, userSla.getDueDateTime());
    log.info(END_MESSAGE, userSla.getEndDateTime());
    userSla.end();
    log.info(END_MESSAGE, userSla.getEndDateTime());
    log.info(SLA_MET_MESSAGE, userSla.isSlaMet());
  }
}
