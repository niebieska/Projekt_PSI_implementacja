package pl.edu.pwr.AssignmentsSystem.Kursy.Usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanStudiow;
import pl.edu.pwr.AssignmentsSystem.Kursy.Respository.PlanStudiowRepository;

@Service
public class PlanStudiowService {

    @Autowired
    private PlanStudiowRepository planStudiowRepository;


    public PlanStudiow getPlanStudiowForKey(String cyklKsztalcenia, String kierunekStudiow, String specjalnosc, int numerSemestru)
    {
        return planStudiowRepository.findAllByCyklKrztalceniaAndAndKierunekStudiowAndAndSpecjalnoscAndAndNumerSemestru(cyklKsztalcenia,kierunekStudiow,specjalnosc,numerSemestru);
    }
}
