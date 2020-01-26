package pl.edu.pwr.AssignmentsSystem.Commons.Utils;

import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Powierzenie;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Uzytkownik;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.ProwadzacyDto;

public class ProwadzacyMapper {

    public static ProwadzacyDto toDto(Uzytkownik prow){
        ProwadzacyDto dto = new ProwadzacyDto(prow.getId(), prow.getImie(), prow.getNazwisko(), prow.getEmail(), prow.getPensum(),0);
        dto.setPozostaloPensum(prow.getPensum() - prow.getZarrzadzanePowierzenia().stream().map(Powierzenie::getLiczbaGodzin).reduce(Integer::sum).orElse(0));
        return dto;
    }
}
