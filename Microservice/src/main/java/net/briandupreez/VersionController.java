package net.briandupreez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @Autowired
    private Version version;

    @RequestMapping("/version")
    public String index() {
        return String.format("Version: %s - %s Build: %s" , version.getName(), version.getMajor(), version.getBuild());
    }


}
