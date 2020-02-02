package pl.edu.pwr.AssignmentsSystem.Prowadzacy.Entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.AssignmentsSystem.Commons.Auth.AuthenticationService;
import pl.edu.pwr.AssignmentsSystem.Commons.Auth.ROLE;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.ProwadzacyDto;
import pl.edu.pwr.AssignmentsSystem.Prowadzacy.Usecase.ProwadzacyService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ProwadzacyController {

    @Autowired
    private ProwadzacyService prowadzacyService;
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/allProwadzacy")
    public List<ProwadzacyDto> getAllProwadzacy()
    {
        if(authenticationService.isUserPermitted(ROLE.USER.name())) {
            return prowadzacyService.getAllProwadzacy();
        }
        return new ArrayList<>();
    }

    @GetMapping("/importUzytkownikow")
    public void importUzytkownikow()
    {
        //if(authenticationService.isUserPermitted(ROLE.ADMIN.name())) {
            prowadzacyService.importUzytkownikow();
       // }
    }
}
