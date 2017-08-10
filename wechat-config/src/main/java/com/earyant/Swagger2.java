package com.earyant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * spring boot 集成Swagger2配置类
 * @author 韩志伟
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2 extends WebMvcConfigurerAdapter{

	/**
	 * 配置启动页
	 * 访问路径http://localhost:8080/swagger-ui.html
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
              .addResourceLocations("classpath:/META-INF/resources/");

		/*registry.addResourceHandler("/webjars/**")
              .addResourceLocations("classpath:/META-INF/resources/webjars/");*/
	}
	
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.earyant"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("wechat-config")
                .description("wechat-configAPI接口说明")
                .termsOfServiceUrl("http://localhost:8881")
                .contact("wechat-config")
                .version("1.0")
                .build();
    }

   /* public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        //指定配置文件的名字
        bootstrap.setName("helloWorld");
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }*/
}
