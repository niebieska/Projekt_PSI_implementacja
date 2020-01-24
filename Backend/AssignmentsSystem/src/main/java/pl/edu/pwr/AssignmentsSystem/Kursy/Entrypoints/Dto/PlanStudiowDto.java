package pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto;

import java.util.ArrayList;

public class PlanStudiowDto {
    String cyklKrztalcenia;
    int liczbaStudentow;
    String kierunekStudiow;
    String specjalnosc;
    int numerSemestru;
    ArrayList<ModulDto> modulDto;

    public PlanStudiowDto(String cyklKrztalcenia, int liczbaStudentow, String kierunekStudiow, String specjalnosc, int numerSemestru, ArrayList<ModulDto> modulDto) {
        this.cyklKrztalcenia = cyklKrztalcenia;
        this.liczbaStudentow = liczbaStudentow;
        this.kierunekStudiow = kierunekStudiow;
        this.specjalnosc = specjalnosc;
        this.numerSemestru = numerSemestru;
        this.modulDto = modulDto;
    }

    public String getCyklKrztalcenia() {
        return cyklKrztalcenia;
    }

    public void setCyklKrztalcenia(String cyklKrztalcenia) {
        this.cyklKrztalcenia = cyklKrztalcenia;
    }

    public int getLiczbaStudentow() {
        return liczbaStudentow;
    }

    public void setLiczbaStudentow(int liczbaStudentow) {
        this.liczbaStudentow = liczbaStudentow;
    }

    public String getKierunekStudiow() {
        return kierunekStudiow;
    }

    public void setKierunekStudiow(String kierunekStudiow) {
        this.kierunekStudiow = kierunekStudiow;
    }

    public String getSpecjalnosc() {
        return specjalnosc;
    }

    public void setSpecjalnosc(String specjalnosc) {
        this.specjalnosc = specjalnosc;
    }

    public int getNumerSemestru() {
        return numerSemestru;
    }

    public void setNumerSemestru(int numerSemestru) {
        this.numerSemestru = numerSemestru;
    }

    public ArrayList<ModulDto> getModulDto() {
        return modulDto;
    }

    public void setModulDto(ArrayList<ModulDto> modulDto) {
        this.modulDto = modulDto;
    }
}
