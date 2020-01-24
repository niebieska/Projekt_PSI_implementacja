package pl.edu.pwr.AssignmentsSystem.Kursy.Usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanStudiow;
import pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto.PlanStudiowDto;
import pl.edu.pwr.AssignmentsSystem.Kursy.Respository.PlanStudiowRepository;

@Service
public class PlanStudiowService {

    @Autowired
    private PlanStudiowRepository planStudiowRepository;


    public PlanStudiowDto getPlanStudiowForKey(IdentyfikatorSemestruDto identyfikatorSemestruDto)
    {
        PlanStudiow planStudiow =
                planStudiowRepository
                .findAllByCyklKrztalceniaAndAndKierunekStudiowAndAndSpecjalnoscAndAndNumerSemestru(identyfikatorSemestruDto.getCyklKsztalcenia(), identyfikatorSemestruDto
                        .getKierunekStudiow(), identyfikatorSemestruDto.getSpecjalnosc(), Integer
                        .parseInt(identyfikatorSemestruDto.getNumerSemestru()));
        //PlanStudiowDto dto = new PlanStudiowDto(planStudiow.getLiczbaStudentow(), identyfikatorSemestruDto, )
        return null;
    }
}
