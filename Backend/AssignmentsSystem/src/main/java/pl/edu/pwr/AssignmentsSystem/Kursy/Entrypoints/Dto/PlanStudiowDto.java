package pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto;

import java.util.ArrayList;

public class PlanStudiowDto {

    int liczbaStudentow;
    IdentyfikatorSemestruDto identyfikatorSemestru;
    ArrayList<ModulDto> modulDto;

    public PlanStudiowDto(int liczbaStudentow, IdentyfikatorSemestruDto identyfikatorSemestru, ArrayList<ModulDto> modulDto) {
        this.liczbaStudentow = liczbaStudentow;
        this.identyfikatorSemestru = identyfikatorSemestru;
        this.modulDto = modulDto;
    }

    public int getLiczbaStudentow() {
        return liczbaStudentow;
    }

    public void setLiczbaStudentow(int liczbaStudentow) {
        this.liczbaStudentow = liczbaStudentow;
    }

    public IdentyfikatorSemestruDto getIdentyfikatorSemestru() {
        return identyfikatorSemestru;
    }

    public void setIdentyfikatorSemestru(IdentyfikatorSemestruDto identyfikatorSemestru) {
        this.identyfikatorSemestru = identyfikatorSemestru;
    }

    public ArrayList<ModulDto> getModulDto() {
        return modulDto;
    }

    public void setModulDto(ArrayList<ModulDto> modulDto) {
        this.modulDto = modulDto;
    }
}


