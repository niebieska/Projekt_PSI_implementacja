package pl.edu.pwr.AuthorizationSystem.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class AuthenticationController {

    private HashMap<String, UserDTO> users = new HashMap<>();

    private BCryptPasswordEncoder crypter = new BCryptPasswordEncoder();

    public AuthenticationController(){
        UserDTO admin = new UserDTO();
        admin.setEmail("mateusz.klimiuk@pwr.edu.pl");
        admin.setPassword("admin");
        admin.setRoles(Arrays.asList("ADMIN", "USER"));

        UserDTO user = new UserDTO();
        user.setEmail("mykhailo.stavniichuk@pwr.edu.pl");
        user.setPassword("user");
        user.setRoles(Arrays.asList("USER"));

        users.put(admin.getEmail(), admin);
        users.put(user.getEmail(), user);
    }

    @PostMapping(path="/auth", consumes = "application/json")
    public UserDTO auth(@RequestBody UserDTO user)
    {
        if(users.get(user.getEmail()) != null)
        {
            UserDTO fromDB = users.get(user.getEmail());
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(fromDB.getEmail());
            userDTO.setPassword(crypter.encode(fromDB.getPassword()));
            userDTO.setRoles(fromDB.getRoles());
            return userDTO;
        }
        return null;
    }


}
