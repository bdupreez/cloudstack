package net.briandupreez.controllers;

import net.briandupreez.service.TheWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HystrixServiceController {

    @Autowired
    private TheWorld theWorld;

    @RequestMapping("/process")
    public String index() {

        return theWorld.executeFunction();
    }
}
