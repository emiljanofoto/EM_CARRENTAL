package Project.EM_CarRental.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private static final String[] WHITE_LIST_URL = {
            "**/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**",
            "/registration/**",
            "/login/"

    };
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(WHITE_LIST_URL).permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/users/**").hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.PUT, "/users/**").hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.POST, "/users/**").hasAnyAuthority("ROLE_MANAGER")
                .requestMatchers(HttpMethod.GET, "/users/**").hasAnyAuthority("ROLE_MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/cars/**").hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.PUT, "/cars/**").hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.POST, "/cars/**").hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/cars/**").hasAnyAuthority("ROLE_USER")
                .requestMatchers(HttpMethod.GET, "/orders/").hasAnyAuthority("ROLE_MANAGER")
                .requestMatchers(HttpMethod.POST, "/orders/").hasAnyAuthority("ROLE_USER")
                .requestMatchers("/payment/**", "/delivery/**").hasAnyAuthority("ROLE_USER")
                .anyRequest().authenticated()
        )

                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .authenticationProvider(authenticationProvider)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }


    //Authentication
    @Bean
    public AuthenticationManager authenticate(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


}



