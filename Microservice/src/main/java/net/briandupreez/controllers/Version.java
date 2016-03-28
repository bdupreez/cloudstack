package net.briandupreez.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


@Component
@RefreshScope
class Version {

    public Version() {
    }

    @Value("${version.name}")
    private String name;

    @Value("${version.major}")
    private String major;

    @Value("${version.build}")
    private String build;


    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getBuild() {
        return build;
    }
}
