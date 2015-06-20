package cn.boxfish.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by undancer on 15/6/20.
 */

@SpringBootApplication(exclude = {})
@ImportResource("classpath*:META-INF/spring.xml")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
//        System.exit(SpringApplication.exit(SpringApplication.run(Application.class, args)));
        SpringApplication.run(Application.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }
}
