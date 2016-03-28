package net.briandupreez;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api-doc")
public class SwaggerController {

    @RequestMapping(value = "/swagger-ui.html", method = RequestMethod.GET)
    public String swagger(final Model model) {
        return "swagger-ui.html";
    }

    @RequestMapping(value = "/configuration/ui", method = RequestMethod.GET)
    public String configurationUi(final Model model) {
        return "forward:/configuration/ui";
    }

    @RequestMapping(value = "/swagger-resources", method = RequestMethod.GET)
    public String swaggerResources(final Model model) {
        return "forward:/swagger-resources";
    }

    @RequestMapping(value = "/configuration/security", method = RequestMethod.GET)
    public String configurationSecurity(final Model model) {
        return "forward:/configuration/security";
    }

    @RequestMapping(value = "/v2/api-docs", method = RequestMethod.GET)
    public String api(final Model model) {
        return "forward:/v2/api-docs";
    }



}
