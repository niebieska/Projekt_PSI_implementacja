package pl.edu.pwr.AssignmentsSystem.Commons.Utils;

import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PlanPowierzenDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.PowierzenieDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.PlanPowierzen;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Powierzenie;

import java.util.stream.Collectors;

public class PowierzenieMapper {

    public static PowierzenieDto toDto(Powierzenie pow){
        return new PowierzenieDto(pow.getId(), ProwadzacyMapper.toDto(pow.getUzytkownik()), KursMapper.toKursDto(pow.getKurs()), pow.getLiczbaGodzin(), pow.isZgodaProwadzacego());
    }
    public static PlanPowierzenDto toDto(PlanPowierzen plan){
        return new PlanPowierzenDto(plan.getPowierzenia().stream().map(PowierzenieMapper::toDto).collect(Collectors
                .toList()),plan.getNazwa(), null, plan.isZgodaKoordynatoraZapisow());
    }
}
