package cn.boxfish.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.bootstrap.BootstrapConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by undancer on 15/6/20.
 */
@SpringBootApplication(exclude = {})
@BootstrapConfiguration
@ImportResource("classpath*:META-INF/spring.xml")
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        System.exit(SpringApplication.exit(SpringApplication.run(Application.class, args)));
    }
}
