package pl.edu.pwr.AssignmentsSystem.Powierzenia.Entrypoints.Dto;

import pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto.IdentyfikatorSemestruDto;

import java.util.ArrayList;

public class PlanPowierzenDto {

    ArrayList<PowierzenieDto> powierzenia;
    String nazwa;
    IdentyfikatorSemestruDto identyfikatorSemestru;
    Boolean zatwierdzony;

    public PlanPowierzenDto(ArrayList<PowierzenieDto> powierzenia, String nazwa, IdentyfikatorSemestruDto identyfikatorSemestru, Boolean zatwierdzony) {
        this.powierzenia = powierzenia;
        this.nazwa = nazwa;
        this.identyfikatorSemestru = identyfikatorSemestru;
        this.zatwierdzony = zatwierdzony;
    }

    public ArrayList<PowierzenieDto> getPowierzenia() {
        return powierzenia;
    }

    public void setPowierzenia(ArrayList<PowierzenieDto> powierzenia) {
        this.powierzenia = powierzenia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public IdentyfikatorSemestruDto getIdentyfikatorSemestru() {
        return identyfikatorSemestru;
    }

    public void setIdentyfikatorSemestru(IdentyfikatorSemestruDto identyfikatorSemestru) {
        this.identyfikatorSemestru = identyfikatorSemestru;
    }

    public Boolean getZatwierdzony() {
        return zatwierdzony;
    }

    public void setZatwierdzony(Boolean zatwierdzony) {
        this.zatwierdzony = zatwierdzony;
    }
}
