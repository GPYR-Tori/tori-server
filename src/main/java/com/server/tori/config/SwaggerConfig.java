package com.server.tori.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // 실행: http://localhost:8080/swagger-ui.html
    @Bean
    public OpenAPI openAPI() {

        Info info = new Info()
                .version("v1.0.0")
                .title("TORI API Document")
                .description("경기청년 갭이어 아기사자 팀의 프로젝트 TORI의 API 문서입니다.");

        return new OpenAPI()
                .info(info);
    }
}
