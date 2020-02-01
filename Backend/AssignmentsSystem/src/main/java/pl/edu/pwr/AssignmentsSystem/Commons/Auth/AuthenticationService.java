package pl.edu.pwr.AssignmentsSystem.Commons.Auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean isUserPermitted(String role){
        /*if(SecurityContextHolder
                .getContext().getAuthentication().getAuthorities().stream().noneMatch(x ->  x.getAuthority().equals("role"))) {
            return false;
        }
        return true;*/
        return true;
    }
}
