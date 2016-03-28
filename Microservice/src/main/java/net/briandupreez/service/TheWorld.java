package net.briandupreez.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

@Component
public class TheWorld {


    @HystrixCommand(fallbackMethod = "defaultFail")
    public String executeFunction() {
        return "Awesome";
    }

    public String defaultFail() {
        return "Fails";
    }
}
