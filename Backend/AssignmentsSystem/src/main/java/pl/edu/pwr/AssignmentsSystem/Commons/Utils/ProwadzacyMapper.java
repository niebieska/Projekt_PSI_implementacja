package pl.edu.pwr.AssignmentsSystem.Commons.Utils;

import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Powierzenie;
import pl.edu.pwr.AssignmentsSystem.Commons.Entities.Uzytkownik;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.ProwadzacyDto;

public class ProwadzacyMapper {

    public static ProwadzacyDto toDto(Uzytkownik prow) {
        ProwadzacyDto dto = new ProwadzacyDto(prow.getId(), prow.getImie(), prow.getNazwisko(), prow.getEmail(), prow
                .getPensum(), 0);
        dto.setPozostaloPensum(prow.getPensum() - prow.getPowierzenia().stream().filter(Powierzenie::isAktywny)
                .filter(x -> x.getPlanPowierzen().isZgodaKoordynatoraZapisow()).map(Powierzenie::getLiczbaGodzin)
                .reduce(Integer::sum).orElse(0));
        return dto;
    }

    public static Uzytkownik toEntity(ProwadzacyDto prowadzacyDto){
        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setEmail(prowadzacyDto.getEmail());
        uzytkownik.setImie(prowadzacyDto.getImie());
        uzytkownik.setNazwisko(prowadzacyDto.getNazwisko());
        uzytkownik.setPensum(prowadzacyDto.getPensum());
        uzytkownik.setTytulNaukowy(prowadzacyDto.getTytulNaukowy());
        uzytkownik.setFormaZatrudnienia(prowadzacyDto.getFormaZatrudnienia());
        uzytkownik.setStanowisko(prowadzacyDto.getStanowisko());
        uzytkownik.setZgodaNaPrzekroczeniePensum(prowadzacyDto.getZgodaNaPrzekroczeniePensum());
        uzytkownik.setPozytywnieZaopiniowany(prowadzacyDto.getPozytywneZaopiniowanie());
        return uzytkownik;
    }
}
