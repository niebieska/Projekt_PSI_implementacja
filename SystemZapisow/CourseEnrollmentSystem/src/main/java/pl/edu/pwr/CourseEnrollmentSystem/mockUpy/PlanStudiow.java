package pl.edu.pwr.CourseEnrollmentSystem.mockUpy;

import java.util.ArrayList;

public class PlanStudiow {
    String cyklKrztalcenia;
    int liczbaStudentow;
    String kierunekStudiow;
    String specjalnosc;
    int numerSemestru;
    ArrayList<Modul> modul;

    public PlanStudiow(String cyklKrztalcenia, int liczbaStudentow, String kierunekStudiow, String specjalnosc, int numerSemestru, ArrayList<Modul> modul) {
        this.cyklKrztalcenia = cyklKrztalcenia;
        this.liczbaStudentow = liczbaStudentow;
        this.kierunekStudiow = kierunekStudiow;
        this.specjalnosc = specjalnosc;
        this.numerSemestru = numerSemestru;
        this.modul = modul;
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

    public ArrayList<Modul> getModul() {
        return modul;
    }

    public void setModul(ArrayList<Modul> modul) {
        this.modul = modul;
    }
}
