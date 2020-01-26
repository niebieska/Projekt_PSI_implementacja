package pl.edu.pwr.AssignmentsSystem.Powierzenia.Entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PlanPowierzenDto;
import pl.edu.pwr.AssignmentsSystem.Powierzenia.Usecase.PowierzenieService;

import java.util.List;

@RestController
public class PowierzenieController {

    @Autowired
    private PowierzenieService powierzenieService;

    @PostMapping("/getPlanPowierzen")
    public List<PlanPowierzenDto> getPlanPowierzen(@RequestBody IdentyfikatorSemestruDto identyfikatorSemestruDto)
    {
        return powierzenieService.getAllPlanPowerzen(identyfikatorSemestruDto);
    }
}
