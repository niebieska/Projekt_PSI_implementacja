package pl.edu.pwr.AuthorizationSystem.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public void configure(ClientDetailsServiceConfigurer clients) {
        try {
            clients
                    .inMemory()
                    .withClient("test")
                    .secret(passwordEncoder().encode("test"))
                    .scopes("resource:any")
                    .authorizedGrantTypes("authorization_code")
                    .redirectUris("http://localhost:8081/terazMamAutoryzacje");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}