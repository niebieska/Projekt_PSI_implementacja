package pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto.PlanStudiowDto;
import pl.edu.pwr.AssignmentsSystem.Kursy.Usecase.PlanStudiowService;

import java.util.List;

@RestController
public class KursController {

    @Autowired
    private PlanStudiowService planStudiowService;

    @GetMapping("/getAllKurs")
    public PlanStudiowDto getAllKursy(@RequestParam IdentyfikatorSemestruDto identyfikatorSemestruDto) {
        return planStudiowService
                .getPlanStudiowForKey(identyfikatorSemestruDto);
    }
    @GetMapping("/importCoursesFromExternalSystem")
    public boolean importCourses(){
        return planStudiowService.importKursFromExternalSystem();
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() throws Exception {
        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().noneMatch(x ->  x.getAuthority().equals("USER"))) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>("Hello",HttpStatus.OK);
        }
    }

    @GetMapping("/helloAdmin")
    public ResponseEntity<String> helloAdmin() throws Exception {
        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().noneMatch(x ->  x.getAuthority().equals("ADMIN"))) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>("Hello admin",HttpStatus.OK);
        }
    }
}
