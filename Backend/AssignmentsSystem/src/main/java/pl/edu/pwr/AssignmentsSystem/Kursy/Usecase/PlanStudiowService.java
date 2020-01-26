package pl.edu.pwr.AssignmentsSystem.Kursy.Usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Kurs;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanPowierzen;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanStudiow;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PlanStudiowDto;
import pl.edu.pwr.AssignmentsSystem.Kursy.Respository.KursRepository;
import pl.edu.pwr.AssignmentsSystem.Kursy.Respository.PlanStudiowRepository;
import pl.edu.pwr.AssignmentsSystem.Commons.Utils.KursMapper;

import java.util.*;

@Service
public class PlanStudiowService {

    @Value("${external.system.courses}")
    private String coursesHost;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private PlanStudiowRepository planStudiowRepository;

    @Autowired
    private KursRepository kursRepository;


    public PlanStudiowDto getPlanStudiowForKey(IdentyfikatorSemestruDto identyfikatorSemestruDto) {
        PlanStudiow planStudiow =
                planStudiowRepository
                        .findAllByCyklKsztalceniaAndAndKierunekStudiowAndAndSpecjalnoscAndAndNumerSemestru(identyfikatorSemestruDto
                                .getCyklKsztalcenia(), identyfikatorSemestruDto
                                .getKierunekStudiow(), identyfikatorSemestruDto
                                .getSpecjalnosc(), identyfikatorSemestruDto.getNumerSemestru());
        return Optional.ofNullable(planStudiow).map(KursMapper::toPlanStudioDto).orElse(null);
    }
    public PlanStudiow getPlanStudiow(IdentyfikatorSemestruDto identyfikatorSemestruDto) {

                return planStudiowRepository
                        .findAllByCyklKsztalceniaAndAndKierunekStudiowAndAndSpecjalnoscAndAndNumerSemestru(identyfikatorSemestruDto
                                .getCyklKsztalcenia(), identyfikatorSemestruDto
                                .getKierunekStudiow(), identyfikatorSemestruDto
                                .getSpecjalnosc(), identyfikatorSemestruDto.getNumerSemestru());
    }

    public boolean importPlanStudiowFromExternalSystem() {
        PlanStudiowDto[] plans = Objects
                .requireNonNull(restTemplate.getForObject(coursesHost, PlanStudiowDto[].class, new Object()));
        for (PlanStudiowDto plan : plans) {
            IdentyfikatorSemestruDto identyfikatorSemestru = plan.getIdentyfikatorSemestru();
            if (!planStudiowRepository
                    .existsByCyklKsztalceniaAndKierunekStudiowAndSpecjalnoscAndNumerSemestru(identyfikatorSemestru
                            .getCyklKsztalcenia(), identyfikatorSemestru.getKierunekStudiow(), identyfikatorSemestru
                            .getSpecjalnosc(), identyfikatorSemestru.getNumerSemestru())) {
                PlanStudiow planStudiow = KursMapper.toPlanStudiow(plan);
                PlanPowierzen planPowierzen = new PlanPowierzen();
                planPowierzen.setNazwa("standard");
                planPowierzen.setZgodaKoordynatoraZapisow(false);
                planPowierzen.setWersjaPlanu("0");
                planStudiow.setPlanPowierzenList(Collections.singletonList(planPowierzen));
                planStudiowRepository.save(planStudiow);
            }
        }
        return true;
    }

    public void savePlanStudiow(PlanStudiow ps)
    {
        planStudiowRepository.save(ps);
    }

    public List<IdentyfikatorSemestruDto> extractIdentyfikatory()
    {
        return planStudiowRepository.findAllPlanStudiowGroupedByIdentfikator();
    }

    public Optional<Kurs> getKursByID(Integer id)
    {
        return kursRepository.findById(id);
    }
}
