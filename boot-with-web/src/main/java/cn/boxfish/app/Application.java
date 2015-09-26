package cn.boxfish.app;

import cn.boxfish.app.interceptor.RequestMappingHandlerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by undancer on 15/8/16.
 */
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

    @Inject
    RequestMappingHandlerInterceptor webRequestInterceptor;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);

    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(webRequestInterceptor);
    }
}
