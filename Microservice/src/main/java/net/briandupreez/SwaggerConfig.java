package net.briandupreez;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * Created by NATHAN2 on 06/09/2015.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Predicate<String> paths() {
        return or(
                regex("/cities")
        );
    }

    @Bean
    public Docket apigateway() {
        return new Docket(DocumentationType.SWAGGER_2).
                select().
                apis(RequestHandlerSelectors.any()).
                paths(paths()).build().
                pathMapping("/")
                .apiInfo(apiInfo()).
                        genericModelSubstitutes(ResponseEntity.class).
                        alternateTypeRules(newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)))
                .directModelSubstitute(XMLGregorianCalendar.class, Date.class)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(new ResponseMessageBuilder().code(HttpStatus.BAD_REQUEST.value()).
                                message(HttpStatus.BAD_REQUEST.name()).
                                responseModel(new ModelRef("Error")).build()));
    }


    @Autowired
    private TypeResolver typeResolver;


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Cloud API Manager Demo")
                .description("Spring cloud netflix + api managers demo")
                .termsOfServiceUrl("http://www.discovery.co.za")
                .license("Discovery License Version 1.0")
                .licenseUrl("http://www.discovery.co.za/LICENSE")
                .version("1.0")
                .build();
    }

}
