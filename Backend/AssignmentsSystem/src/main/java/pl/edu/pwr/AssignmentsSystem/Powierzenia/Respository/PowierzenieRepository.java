package pl.edu.pwr.AssignmentsSystem.Powierzenia.Respository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Powierzenie;

public interface PowierzenieRepository extends CrudRepository<Powierzenie, Integer> {
}
