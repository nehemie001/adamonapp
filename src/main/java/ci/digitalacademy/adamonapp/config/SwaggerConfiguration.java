package ci.digitalacademy.adamonapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerConfiguration {

    @Bean
    public OpenAPI getOpenAPI() {
        final Info info = new Info()
                .title("MonEtabAPIs")
                .version("2.0.2")
                .description("These APIs expose Mon ETAB endpoints");

        return new OpenAPI().info(info);
    }
}
