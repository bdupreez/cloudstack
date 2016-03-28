package za.co.discovery.health.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


@SpringBootApplication
@EnableTurbine
@EnableDiscoveryClient
public class TurbineApplication {

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(TurbineApplication.class, args);
    }

}
