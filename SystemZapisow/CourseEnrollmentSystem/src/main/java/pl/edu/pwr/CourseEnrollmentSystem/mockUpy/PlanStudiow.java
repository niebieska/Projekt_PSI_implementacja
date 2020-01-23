package pl.edu.pwr.CourseEnrollmentSystem.mockUpy;

public class PlanStudiow {
    String cyklKrztalcenia;
    int liczbaStudentow;
    String kierunekStudiow;
    String specjalnosc;
    int numerSemestru;
    Modul modul;

    public PlanStudiow(String cyklKrztalcenia, int liczbaStudentow, String kierunekStudiow, String specjalnosc, int numerSemestru, Modul modul) {
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

    public Modul getModul() {
        return modul;
    }

    public void setModul(Modul modul) {
        this.modul = modul;
    }
}
