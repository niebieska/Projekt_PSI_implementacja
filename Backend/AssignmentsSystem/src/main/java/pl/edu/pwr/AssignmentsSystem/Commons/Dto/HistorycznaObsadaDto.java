package pl.edu.pwr.AssignmentsSystem.Commons.Dto;

import java.util.ArrayList;

public class HistorycznaObsadaDto {

String nazwaKursu;
ArrayList<ProwadzacyDto> prowadzacy;

    public HistorycznaObsadaDto(String nazwaKursu, ArrayList<ProwadzacyDto> prowadzacy) {
        this.nazwaKursu = nazwaKursu;
        this.prowadzacy = prowadzacy;
    }

    public String getNazwaKursu() {
        return nazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }

    public ArrayList<ProwadzacyDto> getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(ArrayList<ProwadzacyDto> prowadzacy) {
        this.prowadzacy = prowadzacy;
    }
}
