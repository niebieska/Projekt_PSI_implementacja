package pl.edu.pwr.AssignmentsSystem.Prowadzacy.Respository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Uzytkownik;

import java.util.List;
import java.util.Optional;

public interface ProwadzacyRepository extends CrudRepository<Uzytkownik, Integer> {

public boolean existsByEmail(String email);
public Optional<Uzytkownik> findByEmail(String email);
}
