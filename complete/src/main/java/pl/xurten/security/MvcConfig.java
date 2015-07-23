package pl.xurten.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/workers").setViewName("workers");
        registry.addViewController("/addworker").setViewName("addworker");
        registry.addViewController("/deleteworker").setViewName("deleteworker");
        registry.addViewController("/updateworker").setViewName("updateworker");
        registry.addViewController("/worker").setViewName("worker");
        registry.addViewController("/myworker").setViewName("myworker");
        registry.addViewController("/departments").setViewName("departments");


    }
}
