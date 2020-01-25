package pl.edu.pwr.AssignmentsSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class AssignmentsSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentsSystemApplication.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

}
