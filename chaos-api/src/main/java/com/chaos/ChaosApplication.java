package com.chaos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * chaos 启动类
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/05 12:56
 */
@EnableJpaRepositories
@SpringBootApplication
public class ChaosApplication {

  public static void main(String[] args) {
    SpringApplication.run(ChaosApplication.class, args);
  }

}
