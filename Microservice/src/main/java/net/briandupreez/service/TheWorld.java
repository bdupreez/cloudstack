package net.briandupreez.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

/**
 * Created by brian on 2016/03/23.
 */
@Component
public class TheWorld {

    @HystrixCommand(fallbackMethod = "defaultFail")
    public String greetings() {
        return "Awesome";
    }

    public String defaultFail() {
        return "Fails";
    }
}
