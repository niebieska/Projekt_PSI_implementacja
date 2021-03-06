package pl.edu.pwr.AssignmentsSystem.Commons.Dto;

import java.io.Serializable;

public class IdentyfikatorSemestruDto implements Serializable {


    String cyklKsztalcenia;
    String kierunekStudiow;
    String specjalnosc;
    int numerSemestru;

    public IdentyfikatorSemestruDto(String cyklKsztalcenia, String kierunekStudiow, String specjalnosc, int numerSemestru) {
        this.cyklKsztalcenia = cyklKsztalcenia;
        this.kierunekStudiow = kierunekStudiow;
        this.specjalnosc = specjalnosc;
        this.numerSemestru = numerSemestru;
    }

    public IdentyfikatorSemestruDto() {
    }

    public String getCyklKsztalcenia() {
        return cyklKsztalcenia;
    }

    public void setCyklKsztalcenia(String cyklKsztalcenia) {
        this.cyklKsztalcenia = cyklKsztalcenia;
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
}
