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

    public boolean savePowierzenie(PlanPowierzenDto planPowierzenDto) throws Exception {

        PlanPowierzen planPowierzen = planPowierzenRepository.findById(planPowierzenDto.getId()).orElse(null);
        Powierzenie powierzenie = PowierzenieMapper.toEntity(planPowierzenDto.getPowierzenia().get(0));
        Optional<Uzytkownik> uzytkownik = prowadzacyService
                .getUzytkownikByID(powierzenie.getUzytkownik().getId());
        Optional<Kurs> kurs = planStudiowService.getKursByID(powierzenie.getKurs().getId());


        if (planPowierzen == null || !uzytkownik.isPresent() || !kurs.isPresent() || powierzenie
                .getLiczbaGodzin() <= 0 || checkStanowiskoPermission(uzytkownik.get(), kurs
                .get()) || checkFreeTime(uzytkownik.get(), planPowierzen, powierzenie
                .getLiczbaGodzin()) || checkKursCapacity(planPowierzen, powierzenie, kurs.get())) {
            return false;
        }

        if (powierzenie.getId() != 0) {
            Powierzenie toSave = powierzenieRepository.findById(powierzenie.getId())
                    .orElseThrow(() -> new Exception("Wrong powierzenie Id"));
            toSave.setAktywny(true);
            toSave.setUzytkownik(uzytkownik.get());
            toSave.setKurs(kurs.get());
            toSave.setLiczbaGodzin(powierzenie.getLiczbaGodzin());
            toSave.setPlanPowierzen(planPowierzen);
            WersjaPowierzenia wersja = new WersjaPowierzenia();
            wersja.setLiczbaGodzin(toSave.getLiczbaGodzin());
            wersja.setZgodaProwadzacego(toSave.isZgodaProwadzacego());
            wersja.setKurs(toSave.getKurs());
            wersja.setProwadzacy(toSave.getUzytkownik());
            wersja.setWersja(toSave.getWersjePowierzen().stream().map(WersjaPowierzenia::getWersja)
                    .max(Comparator.comparing(Integer::valueOf)).orElse(-1) + 1);
            toSave.getWersjePowierzen().add(wersja);
            planPowierzen.getPowierzenia().add(toSave);
            //TODO jeszcze koordynator
            planPowierzenRepository.save(planPowierzen);
        } else {
            Powierzenie newPowierzenie = new Powierzenie();
            newPowierzenie.setUzytkownik(uzytkownik.get());
            newPowierzenie.setKurs(kurs.get());
            newPowierzenie.setLiczbaGodzin(powierzenie.getLiczbaGodzin());
            newPowierzenie.setAktywny(true);
            newPowierzenie.setPlanPowierzen(planPowierzen);
            WersjaPowierzenia wersja = new WersjaPowierzenia();
            wersja.setLiczbaGodzin(newPowierzenie.getLiczbaGodzin());
            wersja.setZgodaProwadzacego(newPowierzenie.isZgodaProwadzacego());
            wersja.setKurs(newPowierzenie.getKurs());
            wersja.setProwadzacy(newPowierzenie.getUzytkownik());
            wersja.setWersja(0);
            newPowierzenie.setWersjePowierzen(new ArrayList<>());
            newPowierzenie.getWersjePowierzen().add(wersja);
            planPowierzen.getPowierzenia().add(newPowierzenie);
            //TODO jeszcze koordynator
            planPowierzenRepository.save(planPowierzen);
        }
        return true;
    }

    private boolean checkKursCapacity(PlanPowierzen planPowierzen, Powierzenie powierzenie, Kurs kurs) {
        return kurs.getLiczbaGodzin() < planPowierzen.getPowierzenia().stream()
                .filter(x -> x.getKurs().getId() == kurs.getId()).filter(x -> x.getId() != powierzenie.getId()).map(Powierzenie::getLiczbaGodzin).reduce(Integer::sum)
                .orElse(0) + powierzenie.getLiczbaGodzin();
    }

    private boolean checkStanowiskoPermission(Uzytkownik uzytkownik, Kurs kurs) {
        return kurs.getFormaZajec().equals("wykład") || kurs.getFormaZajec()
                .equals("seminarium") && Stanowiska.nieuprawnieni.contains(uzytkownik.getStanowisko());
    }

    public void savePlanPowierzen(PlanPowierzenDto planPowierzenDto) {
        PlanPowierzen pp = PowierzenieMapper.toEntity(planPowierzenDto);
        PlanStudiow planStudiow = planStudiowService
                .getPlanStudiow(planPowierzenDto.getIdentyfikatorSemestru());
        planStudiow.getPlanPowierzenList().add(pp);
        pp.setPlanStudiow(planStudiow);
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
            newWersja.setWersja(wersja + 1);
            newWersja.setProwadzacy(powierzenie.getUzytkownik());
            newWersja.setKurs(powierzenie.getKurs());
            newWersja.setLiczbaGodzin(powierzenie.getLiczbaGodzin());
            newWersja.setZgodaProwadzacego(powierzenie.isZgodaProwadzacego());
            pow.get().getWersjePowierzen().add(newWersja);
            powierzenieRepository.save(pow.get());
        }
    }

    private boolean checkFreeTime(Uzytkownik uzytkownik, PlanPowierzen planPowierzen, int liczbGodzin) {
        int freeTime = uzytkownik.getPensum() - uzytkownik.getPowierzenia().stream().filter(Powierzenie::isAktywny)
                .filter(x -> x.getPlanPowierzen().isZgodaKoordynatoraZapisow()).map(Powierzenie::getLiczbaGodzin)
                .reduce(Integer::sum).orElse(0);
        freeTime -= uzytkownik.getPowierzenia().stream().filter(Powierzenie::isAktywny)
                .filter(x -> x.getPlanPowierzen().getId() == planPowierzen.getId()).map(Powierzenie::getLiczbaGodzin)
                .reduce(Integer::sum).orElse(0);
        return freeTime < liczbGodzin;
    }

}
