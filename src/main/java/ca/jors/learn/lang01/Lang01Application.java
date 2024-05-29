package ca.jors.learn.lang01;

import ca.jors.learn.lang01.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Lang01Application {

  public static void main(String[] args) {
    SpringApplication.run(Lang01Application.class, args);
    var sc = new SomeClass();
    log.info("test");
    log.info(sc.getName());

    log.info(sc.getMoreS());

    log.info(sc.mySecret());

    AppService.run();
  }
}
