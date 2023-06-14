package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final String headers =  "Authorization, Access-Control-Allow-Headers, "+
                "Origin, Accept, X-Requested-With, Content-Type, " +
                "Access-Control-Request-Method, Custom-Filter-Header";
        System.out.println("Ingreso a la configuracion");
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Required for PUT method

        config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE", "OPTIONS")); // Required for PUT method
        config.addExposedHeader(headers);
        config.setAllowCredentials(true);
        config.applyPermitDefaultValues();

        source.registerCorsConfiguration("/**", config);

        return source;
    }
}