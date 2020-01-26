package pl.edu.pwr.AssignmentsSystem.Powierzenia.Entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PlanPowierzenDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PowierzenieDto;
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

    @PutMapping("/savePowierzenie")
    public ResponseEntity savePowierzenie(@RequestBody PlanPowierzenDto planPowierzenDto)
    {
        if(powierzenieService.savePowierzenie(planPowierzenDto))
        {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/savePlanPowierzen")
    public ResponseEntity savePlanPowierzen(@RequestBody PlanPowierzenDto planPowierzenDto)
    {
        powierzenieService.savePlanPowierzen(planPowierzenDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/removePowierzenie")
    public ResponseEntity removePowierzenie(@RequestBody PowierzenieDto powierzenieDto)
    {
        powierzenieService.removePowierzenie(powierzenieDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
