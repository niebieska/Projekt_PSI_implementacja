package pl.edu.pwr.AssignmentsSystem.Powierzenia.Respository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanPowierzen;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanStudiow;

import java.util.List;

public interface PlanPowierzenRepository extends CrudRepository<PlanPowierzen, Integer> {


}
