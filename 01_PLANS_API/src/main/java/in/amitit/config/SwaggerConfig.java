
package in.amitit.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;



@Configuration
public class SwaggerConfig {

	 @Bean
	    public GroupedOpenApi plansApi() {
	        return GroupedOpenApi.builder()
	                .group("plans-api")
	                .packagesToScan("in.amitit.controller") // 👈 fix spelling if needed!
	                .build();
	    }
		/*
		 * @Bean public OpenAPI customOpenAPI() { return new OpenAPI() .info(new Info()
		 * .title("Plans API") .description("API documentation for Plans project")
		 * .version("1.0.0")); }
		 */
}
