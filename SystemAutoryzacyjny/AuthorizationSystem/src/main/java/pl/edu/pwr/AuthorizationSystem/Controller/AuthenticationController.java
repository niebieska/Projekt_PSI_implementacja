package pl.edu.pwr.AuthorizationSystem.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class AuthenticationController {

    private BCryptPasswordEncoder crypter = new BCryptPasswordEncoder(15);

    private HashMap<String, StandardUser> users = new HashMap<>();

    public AuthenticationController(){
        StandardUser admin = new StandardUser();
        admin.setEmail("admin@pwr.edu.pl");
        admin.setPassword("admin");
        admin.setRole("ADMIN");

        StandardUser user = new StandardUser();
        user.setEmail("user@pwr.edu.pl");
        user.setPassword("user");
        user.setRole("USER");

        users.put(admin.getEmail(), admin);
        users.put(user.getEmail(), user);
    }

    @PostMapping(path="/auth", consumes = "application/json")
    public String auth(@RequestBody UserDto user)
    {
        if(users.get(user.email) != null && crypter.matches(users.get(user.email).getPassword(),user.password))
        {
            return users.get(user.email).getRole();
        }
        return null;
    }

    private static class UserDto{
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public UserDto(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public UserDto() {
        }
    }
}
