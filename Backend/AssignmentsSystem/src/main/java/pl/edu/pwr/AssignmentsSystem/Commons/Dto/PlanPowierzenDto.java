package pl.edu.pwr.AssignmentsSystem.Commons.Dto;

import java.util.ArrayList;
import java.util.List;

public class PlanPowierzenDto {

    List<PowierzenieDto> powierzenia;
    String nazwa;
    IdentyfikatorSemestruDto identyfikatorSemestru;
    Boolean zatwierdzony;
    Integer id;

    public PlanPowierzenDto(Integer id, List<PowierzenieDto> powierzenia, String nazwa, IdentyfikatorSemestruDto identyfikatorSemestru, Boolean zatwierdzony) {
        this.id = id;
        this.powierzenia = powierzenia;
        this.nazwa = nazwa;
        this.identyfikatorSemestru = identyfikatorSemestru;
        this.zatwierdzony = zatwierdzony;
    }

    public List<PowierzenieDto> getPowierzenia() {
        return powierzenia;
    }

    public void setPowierzenia(List<PowierzenieDto> powierzenia) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
