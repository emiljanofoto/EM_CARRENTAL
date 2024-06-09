package Project.EM_CarRental.Config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@AllArgsConstructor
@EnableMethodSecurity
@EnableWebSecurity
@Configuration
@SecurityScheme(name = "basicAuth", type = SecuritySchemeType.HTTP, scheme = "basic")
public class SecurityConfiguration {

    private UserDetailsService userDetailsService;


    //Authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
//                      .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/users/**").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/users/**").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/users/**").hasAnyAuthority("ROLE_MANAGER, ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users/**").hasAnyAuthority("ROLE_MANAGER, ROLE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/cars/**").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/cars/**").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/cars/**").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET, "/cars/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/orders/").hasAnyAuthority("ROLE_MANAGER, ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/orders/").hasAnyAuthority("ROLE_USER")
                        .requestMatchers("/payment/**", "/delivery/**").hasAnyAuthority("ROLE_USER")

                        .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Authentication
    @Bean
    public AuthenticationManager authenticate(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }





}