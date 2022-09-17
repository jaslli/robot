package com.yww.robot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *      SpringDoc配置类
 * </p>
 *
 * @ClassName SwaggerConfig
 * @Author yww
 * @Date 2022/9/17 23:40
 */
@Configuration
public class SwaggerConfig {

    /**
     * SpringDoc的配置
     */
    @Bean
    public GroupedOpenApi ywApi(){
        String[] paths = { "/**" };
        String[] packagedToMatch = { "com.yww.robot.controller" };
        return GroupedOpenApi.builder().group("API模块")
                .pathsToMatch(paths)
                .addOperationCustomizer((operation, handlerMethod) ->
                        operation.addParametersItem(new HeaderParameter()
                                .name("yww")
                                .schema(new StringSchema()._default("BR"))))
                .packagesToScan(packagedToMatch)
                .build();
    }

    /**
     * 界面信息配置
     */
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(
                new Info()
                    .title("yww的API")
                    .version("1.92")
                    .description("QQ机器人的API")
                    .termsOfService("http://yww52.com")
                    .license(new License().name("Apache 2.0").url("http://yww52.com"))
                );
    }



}
