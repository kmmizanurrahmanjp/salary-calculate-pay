package com.ibcsprimax.assignment.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(SwaggerConfig.class);
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("com.ibcsprimax.assignment.controller"))
            .paths(PathSelectors.regex("/.*"))
            .build()
            .apiInfo(apiEndPointsInfo());
    }
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Job Assignment")
            .description("Api Documentation for salary calculate and pay")
            .contact(new Contact("IBCS-PRIMAX Software(Bangladesh) Limited", "https://www.ibcs-primax.com", " info@ibcs-primax.com"))
            .license("Open source license")
            .licenseUrl("https://www.ibcs-primax.com")
            .version("0.0.1-SNAPSHOT")
            .build();
    }
}
