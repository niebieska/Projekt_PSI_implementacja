package pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto.PlanStudiowDto;

import java.util.List;

@RestController
public class KursController {

    @GetMapping("/getAllKurs")
    public List<PlanStudiowDto> getAllKursy()
    {
        return null;
    }
}
