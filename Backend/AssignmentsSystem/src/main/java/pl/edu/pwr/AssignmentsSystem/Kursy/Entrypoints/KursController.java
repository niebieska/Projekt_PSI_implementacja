package pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PlanStudiowDto;
import pl.edu.pwr.AssignmentsSystem.Kursy.Usecase.PlanStudiowService;

import java.util.List;

@CrossOrigin
@RestController
public class KursController {

    @Autowired
    private PlanStudiowService planStudiowService;

    @PostMapping("/getAllKurs")
    public PlanStudiowDto getAllKursy(@RequestBody IdentyfikatorSemestruDto identyfikatorSemestruDto) {
        return planStudiowService
                .getPlanStudiowForKey(identyfikatorSemestruDto);
    }
    @GetMapping("/importCoursesFromExternalSystem")
    public boolean importCourses(){
        return planStudiowService.importPlanStudiowFromExternalSystem();
    }

    @GetMapping("/getAllIdentyfikatoryPlanuStudiow")
    public List<IdentyfikatorSemestruDto> getAllIdentyfikatory()
    {
        return planStudiowService.extractIdentyfikatory();
    }

    // tak bedzie chyba autoryzacja
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
