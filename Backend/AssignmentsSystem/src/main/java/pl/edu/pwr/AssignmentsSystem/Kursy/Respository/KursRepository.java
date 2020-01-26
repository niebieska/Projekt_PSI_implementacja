package pl.edu.pwr.AssignmentsSystem.Kursy.Respository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Kurs;

public interface KursRepository extends CrudRepository<Kurs, Integer> {
}
