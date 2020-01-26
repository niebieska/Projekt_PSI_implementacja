package pl.edu.pwr.AssignmentsSystem.Commons.Utils;

import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PlanPowierzenDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PowierzenieDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanPowierzen;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Powierzenie;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Uzytkownik;

import java.util.stream.Collectors;

public class PowierzenieMapper {

    public static PowierzenieDto toDto(Powierzenie pow){
        return new PowierzenieDto(pow.getId(), ProwadzacyMapper.toDto(pow.getUzytkownik()), KursMapper.toKursDto(pow.getKurs()), pow.getLiczbaGodzin(), pow.isZgodaProwadzacego());
    }
    public static Powierzenie toEntity(PowierzenieDto dto){
        Powierzenie pow = new Powierzenie();
        pow.setAktywny(true);
        pow.setKurs(KursMapper.toKurs(dto.getKurs()));
        pow.setUzytkownik(new Uzytkownik(dto.getProwadzacy().getId()));
        pow.setLiczbaGodzin(dto.getLiczbaGodzin());
        pow.setId(dto.getId());
        return pow;
    }
    public static PlanPowierzenDto toDto(PlanPowierzen plan){
        return new PlanPowierzenDto(plan.getId(), plan.getPowierzenia().stream().filter(Powierzenie::isAktywny).map(PowierzenieMapper::toDto).collect(Collectors
                .toList()),plan.getNazwa(), null, plan.isZgodaKoordynatoraZapisow());
    }
    public static PlanPowierzen toEntity(PlanPowierzenDto plan)
    {
        PlanPowierzen pp = new PlanPowierzen();
        pp.setNazwa(plan.getNazwa());
        pp.setZgodaKoordynatoraZapisow(plan.getZatwierdzony());
        return pp;
    }
}
