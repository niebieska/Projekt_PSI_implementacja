package pl.edu.pwr.CourseEnrollmentSystem.mockUpy;

import java.util.List;

public class PlanStudiowDto {

    int liczbaStudentow;
    IdentyfikatorSemestruDto identyfikatorSemestru;
    List<ModulDto> modulDto;

    public PlanStudiowDto(int liczbaStudentow, IdentyfikatorSemestruDto identyfikatorSemestru, List<ModulDto> modulDto) {
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

    public List<ModulDto> getModulDto() {
        return modulDto;
    }

    public void setModulDto(List<ModulDto> modulDto) {
        this.modulDto = modulDto;
    }
}


