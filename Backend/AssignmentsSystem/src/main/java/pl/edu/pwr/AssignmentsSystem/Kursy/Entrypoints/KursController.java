package pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
