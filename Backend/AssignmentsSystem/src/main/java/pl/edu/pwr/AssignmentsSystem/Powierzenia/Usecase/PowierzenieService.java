package pl.edu.pwr.AssignmentsSystem.Powierzenia.Usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.IdentyfikatorSemestruDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PowierzenieDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.*;
import pl.edu.pwr.AssignmentsSystem.Commons.Utils.PowierzenieMapper;
import pl.edu.pwr.AssignmentsSystem.Kursy.Usecase.PlanStudiowService;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PlanPowierzenDto;
import pl.edu.pwr.AssignmentsSystem.Powierzenia.Respository.PlanPowierzenRepository;
import pl.edu.pwr.AssignmentsSystem.Powierzenia.Respository.PowierzenieRepository;
import pl.edu.pwr.AssignmentsSystem.Powierzenia.Respository.WersjaPowtorzenieRepository;
import pl.edu.pwr.AssignmentsSystem.Commons.Utils.Stanowiska;
import pl.edu.pwr.AssignmentsSystem.Prowadzacy.Usecase.ProwadzacyService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PowierzenieService {

    @Autowired
    private PlanStudiowService planStudiowService;

    @Autowired
    private PlanPowierzenRepository planPowierzenRepository;

    @Autowired
    private PowierzenieRepository powierzenieRepository;

    @Autowired
    private ProwadzacyService prowadzacyService;

    @Autowired
    private WersjaPowtorzenieRepository wersjaPowtorzenieRepository;

    public List<PlanPowierzenDto> getAllPlanPowerzen(IdentyfikatorSemestruDto identyfikatorSemestruDto) {
        PlanStudiow planStudiow = planStudiowService.getPlanStudiow(identyfikatorSemestruDto);
        List<PlanPowierzen> powierzenia = planStudiow.getPlanPowierzenList();
        return powierzenia.stream().map(PowierzenieMapper::toDto).collect(Collectors.toList());
    }

    public boolean savePowierzenie(PlanPowierzenDto planPowierzenDto) {
        PlanPowierzen planPowierzen = planPowierzenRepository.findById(planPowierzenDto.getId()).orElse(null);
        if(planPowierzen == null)
        {
            return false;
        }
            Powierzenie powierzenie = PowierzenieMapper.toEntity(planPowierzenDto.getPowierzenia().get(0));
            if (powierzenie.getId() != 0) {
                Optional<Powierzenie> entity = powierzenieRepository.findById(powierzenie.getId());
                Optional<Uzytkownik> uzytkownik = prowadzacyService
                        .getUzytkownikByID(powierzenie.getUzytkownik().getId());
                Optional<Kurs> kurs = planStudiowService.getKursByID(powierzenie.getKurs().getId());

                if (uzytkownik.isPresent() && kurs.isPresent() && entity.isPresent() && powierzenie
                        .getLiczbaGodzin() >= 0) {
                    if(kurs.get().getFormaZajec().equals("wykład") || kurs.get().getFormaZajec().equals("seminarium")  &&  Stanowiska.nieuprawnieni.contains(uzytkownik.get().getStanowisko())){
                        return  false;
                    }
                    Powierzenie toSave = entity.get();
                    toSave.setAktywny(true);
                    toSave.setUzytkownik(uzytkownik.get());
                    toSave.setKurs(kurs.get());
                    toSave.setLiczbaGodzin(powierzenie.getLiczbaGodzin());
                    WersjaPowierzenia wersja = new WersjaPowierzenia();
                    wersja.setLiczbaGodzin(toSave.getLiczbaGodzin());
                    wersja.setZgodaProwadzacego(toSave.isZgodaProwadzacego());
                    wersja.setKurs(toSave.getKurs());
                    wersja.setProwadzacy(toSave.getUzytkownik());
                    wersja.setWersja(toSave.getWersjePowierzen().stream().map(WersjaPowierzenia::getWersja).max(Comparator.comparing(Integer::valueOf)).orElse(-1) + 1);
                    toSave.getWersjePowierzen().add(wersja);
                    planPowierzen.getPowierzenia().add(toSave);
                    //TODO jeszcze koordynator
                    planPowierzenRepository.save(planPowierzen);
                }

            } else {
                Powierzenie entity = new Powierzenie();
                Optional<Uzytkownik> uzytkownik = prowadzacyService
                        .getUzytkownikByID(powierzenie.getUzytkownik().getId());
                Optional<Kurs> kurs = planStudiowService.getKursByID(powierzenie.getKurs().getId());
                if (uzytkownik.isPresent() && kurs.isPresent() && powierzenie
                        .getLiczbaGodzin() >= 0) {
                    entity.setUzytkownik(uzytkownik.get());
                    entity.setKurs(kurs.get());
                    entity.setLiczbaGodzin(powierzenie.getLiczbaGodzin());
                    entity.setAktywny(true);
                    WersjaPowierzenia wersja = new WersjaPowierzenia();
                    wersja.setLiczbaGodzin(entity.getLiczbaGodzin());
                    wersja.setZgodaProwadzacego(entity.isZgodaProwadzacego());
                    wersja.setKurs(entity.getKurs());
                    wersja.setProwadzacy(entity.getUzytkownik());
                    wersja.setWersja(0);
                    entity.setWersjePowierzen(new ArrayList<>());
                    entity.getWersjePowierzen().add(wersja);
                    planPowierzen.getPowierzenia().add(entity);
                    //TODO jeszcze koordynator
                    planPowierzenRepository.save(planPowierzen);

                }
            }
        return true;
    }

    public void savePlanPowierzen(PlanPowierzenDto planPowierzenDto)
    {
        PlanPowierzen pp = PowierzenieMapper.toEntity(planPowierzenDto);
        PlanStudiow planStudiow = planStudiowService
                .getPlanStudiow(planPowierzenDto.getIdentyfikatorSemestru());
        planStudiow.getPlanPowierzenList().add(pp);
        planStudiowService.savePlanStudiow(planStudiow);
    }

    public void removePowierzenie(PowierzenieDto powierzenieDto) {
        Optional<Powierzenie> pow = powierzenieRepository.findById(powierzenieDto.getId());
        if (pow.isPresent()) {
            Powierzenie powierzenie = pow.get();
            powierzenie.setAktywny(false);
            int wersja = powierzenie.getWersjePowierzen().stream().map(WersjaPowierzenia::getWersja)
                    .max(Comparator.comparing(Integer::valueOf)).orElse(0);
            WersjaPowierzenia newWersja = new WersjaPowierzenia();
            newWersja.setWersja(wersja+1);
            newWersja.setProwadzacy(powierzenie.getUzytkownik());
            newWersja.setKurs(powierzenie.getKurs());
            newWersja.setLiczbaGodzin(powierzenie.getLiczbaGodzin());
            newWersja.setZgodaProwadzacego(powierzenie.isZgodaProwadzacego());
            pow.get().getWersjePowierzen().add(newWersja);
            powierzenieRepository.save(pow.get());
        }
    }

}
