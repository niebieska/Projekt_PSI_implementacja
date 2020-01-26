package pl.edu.pwr.AssignmentsSystem.Kursy.Respository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanPowierzen;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanStudiow;

import java.util.List;

public interface PlanStudiowRepository extends CrudRepository<PlanStudiow, Long> {

    public PlanStudiow findAllByCyklKsztalceniaAndAndKierunekStudiowAndAndSpecjalnoscAndAndNumerSemestru(String cyklKsztalcenia, String kierunekStudiow, String specjalnosc, int numerSemestru);
    public boolean existsByCyklKsztalceniaAndKierunekStudiowAndSpecjalnoscAndNumerSemestru(String cyklKsztalcenia, String kierunekStudiow, String specjalnosc, int numerSemestru);
}
