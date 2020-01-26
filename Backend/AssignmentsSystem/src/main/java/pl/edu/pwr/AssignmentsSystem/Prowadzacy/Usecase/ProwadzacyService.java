package pl.edu.pwr.AssignmentsSystem.Prowadzacy.Usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PlanStudiowDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.ProwadzacyDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanPowierzen;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanStudiow;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Uzytkownik;
import pl.edu.pwr.AssignmentsSystem.Commons.Utils.KursMapper;
import pl.edu.pwr.AssignmentsSystem.Commons.Utils.ProwadzacyMapper;
import pl.edu.pwr.AssignmentsSystem.Prowadzacy.Respository.ProwadzacyRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProwadzacyService {

    @Value("${external.system.staff}")
    private String staffHost;

    @Autowired
    private ProwadzacyRepository prowadzacyRepository;

    private RestTemplate restTemplate = new RestTemplate();

    public List<ProwadzacyDto> getAllProwadzacy()
    {
        Iterable<Uzytkownik>  prowadzacy = prowadzacyRepository.findAll();
        List<Uzytkownik> result = new ArrayList<>();
        prowadzacy.forEach(result::add);
        return result.stream().map(ProwadzacyMapper::toDto).collect(Collectors.toList());
    }

    public Optional<Uzytkownik> getUzytkownikByID(Integer id)
    {
        return prowadzacyRepository.findById(id);
    }

    public void importUzytkownikow()
    {
        ProwadzacyDto[] uzytkownicy = Objects
                .requireNonNull(restTemplate.getForObject(staffHost, ProwadzacyDto[].class, new Object()));
        for (ProwadzacyDto prowadzacy : uzytkownicy) {
            if (!prowadzacyRepository
                    .existsByEmail(prowadzacy.getEmail())) {
                Uzytkownik user = ProwadzacyMapper.toEntity(prowadzacy);
                user.setRolaUzytkownika("USER");
                if(!prowadzacyRepository.existsByEmail(user.getEmail()))
                {
                    prowadzacyRepository.save(user);
                }
            }
        }
    }
}
