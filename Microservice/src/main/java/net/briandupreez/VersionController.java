package net.briandupreez;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @Value("${version}")
    private String version;

    @RequestMapping("/version")
    public String index() {
        return "Version:" + version;
    }
}
