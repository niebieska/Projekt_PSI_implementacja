package pl.edu.pwr.AssignmentsSystem.Powierzenia.Usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanPowierzen;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanStudiow;
import pl.edu.pwr.AssignmentsSystem.Commons.Utils.PowierzenieMapper;
import pl.edu.pwr.AssignmentsSystem.Kursy.Usecase.PlanStudiowService;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PlanPowierzenDto;
import pl.edu.pwr.AssignmentsSystem.Powierzenia.Respository.PlanPowierzenRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PowierzenieService {

    @Autowired
    private PlanStudiowService planStudiowService;

    @Autowired
    private PlanPowierzenRepository planPowierzenRepository;

    public List<PlanPowierzenDto> getAllPlanPowerzen(IdentyfikatorSemestruDto identyfikatorSemestruDto){
        PlanStudiow planStudiow = planStudiowService.getPlanStudiow(identyfikatorSemestruDto);
        List<PlanPowierzen> powierzenia = planStudiow.getPlanPowierzenList();
        return powierzenia.stream().map(PowierzenieMapper::toDto).collect(Collectors.toList());
    }
}
