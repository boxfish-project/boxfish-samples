package cn.boxfish.boot;

import org.springframework.boot.SpringApplication;

/**
 * Created by undancer on 15/6/20.
 */
public class Application {
    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(Application.class, args)));
    }
}
