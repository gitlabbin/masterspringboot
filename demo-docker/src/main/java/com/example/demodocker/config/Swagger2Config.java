package com.example.demodocker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    private final String BASE_PATH = "/idm";

    private final ServletContext servletContext;

    @Autowired
    public Swagger2Config(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).pathProvider(new PathProvider() {
            @Override
            public String getApplicationBasePath() {
                return null;
            }

            @Override
            public String getOperationPath(String operationPath) {
                return BASE_PATH.concat(operationPath);
            }

            @Override
            public String getResourceListingPath(String groupName, String apiDeclaration) {
                return BASE_PATH;
            }
        })
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demodocker"))
                .paths(PathSelectors.regex("/api/v1/.*"))
                .build()
                .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {

        return new ApiInfoBuilder()
                .title("IDM Consumer REST API")
                .description("IDM Management REST API")
                .contact(new Contact("Api support", "www.idmservice.com", "idmsupport@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration(null,
                null,
                null,
                null,
                "apikey access_token",
                ApiKeyVehicle.HEADER,
                "apikey", ",");
    }
}
