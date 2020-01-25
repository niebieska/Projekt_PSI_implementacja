package pl.edu.pwr.AssignmentsSystem.Kursy.Usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanStudiow;
import pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto.PlanStudiowDto;
import pl.edu.pwr.AssignmentsSystem.Kursy.Respository.PlanStudiowRepository;
import pl.edu.pwr.AssignmentsSystem.Kursy.Utils.KursMapper;

import java.util.Objects;
import java.util.Optional;

@Service
public class PlanStudiowService {

    @Value("${external.system.courses}")
    private String coursesHost;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private PlanStudiowRepository planStudiowRepository;


    public PlanStudiowDto getPlanStudiowForKey(IdentyfikatorSemestruDto identyfikatorSemestruDto) {
        PlanStudiow planStudiow =
                planStudiowRepository
                        .findAllByCyklKsztalceniaAndAndKierunekStudiowAndAndSpecjalnoscAndAndNumerSemestru(identyfikatorSemestruDto
                                .getCyklKsztalcenia(), identyfikatorSemestruDto
                                .getKierunekStudiow(), identyfikatorSemestruDto
                                .getSpecjalnosc(), identyfikatorSemestruDto.getNumerSemestru());
        return Optional.ofNullable(planStudiow).map(KursMapper::toPlanStudioDto).orElse(null);
    }

    public boolean importKursFromExternalSystem() {
        PlanStudiowDto[] plans = Objects
                .requireNonNull(restTemplate.getForObject(coursesHost, PlanStudiowDto[].class, new Object()));
        for (PlanStudiowDto plan : plans) {
            IdentyfikatorSemestruDto identyfikatorSemestru = plan.getIdentyfikatorSemestru();
            if (!planStudiowRepository
                    .existsByCyklKsztalceniaAndKierunekStudiowAndSpecjalnoscAndNumerSemestru(identyfikatorSemestru
                            .getCyklKsztalcenia(), identyfikatorSemestru.getKierunekStudiow(), identyfikatorSemestru
                            .getSpecjalnosc(), identyfikatorSemestru.getNumerSemestru())) {
                PlanStudiow planStudiow = KursMapper.toPlanStudiow(plan);
                planStudiowRepository.save(planStudiow);
            }
        }
        return true;
    }
}
