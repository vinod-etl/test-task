package com.hashstudioz.testtask;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.hashstudioz", exclude = {DataSourceAutoConfiguration.class})
public class Application {
  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    LOGGER.info("Test task started with command arguments - {}", Arrays.toString(args));
    SpringApplication.run(Application.class, args).close();
    LOGGER.info("Test task completed");
  }
}
