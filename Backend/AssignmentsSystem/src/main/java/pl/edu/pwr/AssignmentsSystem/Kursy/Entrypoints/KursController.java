package pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.AssignmentsSystem.Commons.Auth.AuthenticationService;
import pl.edu.pwr.AssignmentsSystem.Commons.Auth.ROLE;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PlanStudiowDto;
import pl.edu.pwr.AssignmentsSystem.Kursy.Usecase.PlanStudiowService;

import java.util.List;

@CrossOrigin
@RestController
public class KursController {

    @Autowired
    private PlanStudiowService planStudiowService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/getAllKurs")
    public PlanStudiowDto getAllKursy(@RequestBody IdentyfikatorSemestruDto identyfikatorSemestruDto) {
        return planStudiowService
                .getPlanStudiowForKey(identyfikatorSemestruDto);
    }
    @GetMapping("/importCoursesFromExternalSystem")
    public boolean importCourses(){
        //if(authenticationService.isUserPermitted(ROLE.ADMIN.name()))
        //{
            return planStudiowService.importPlanStudiowFromExternalSystem();
        //}
        //return false;
    }

    @GetMapping("/getAllIdentyfikatoryPlanuStudiow")
    public List<IdentyfikatorSemestruDto> getAllIdentyfikatory()
    {
        return planStudiowService.extractIdentyfikatory();
    }

}
