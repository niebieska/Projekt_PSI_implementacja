package pl.edu.pwr.AuthorizationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableAuthorizationServer
@RestController
public class AuthorizationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationSystemApplication.class, args);
	}

	@RestController
	public class UserController {
		@GetMapping("/user/me")
		public Principal user(Principal principal) {
			return principal;
		}
	}

}
