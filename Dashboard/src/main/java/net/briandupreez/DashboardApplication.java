package net.briandupreez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class DashboardApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(DashboardApplication.class, args);

    }
}

