package pl.edu.pwr.AssignmentsSystem.Prowadzacy.Respository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Uzytkownik;

public interface ProwadzacyRepository extends CrudRepository<Uzytkownik, Integer> {
}
