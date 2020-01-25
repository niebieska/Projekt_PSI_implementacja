package pl.edu.pwr.AssignmentsSystem.Preferencje.Entrypoints.Dto;

import pl.edu.pwr.AssignmentsSystem.Commons.Dto.KursDto;
import pl.edu.pwr.AssignmentsSystem.Commons.Dto.ProwadzacyDto;

import java.util.ArrayList;

public class PreferencjeDto {
ProwadzacyDto prowadzacy;
ArrayList<KursDto> preferencje;

    public PreferencjeDto(ProwadzacyDto prowadzacy, ArrayList<KursDto> preferencje) {
        this.prowadzacy = prowadzacy;
        this.preferencje = preferencje;
    }

    public ProwadzacyDto getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(ProwadzacyDto prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public ArrayList<KursDto> getPreferencje() {
        return preferencje;
    }

    public void setPreferencje(ArrayList<KursDto> preferencje) {
        this.preferencje = preferencje;
    }
}
