package pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto;

public class IdentyfikatorSemestruDto {


    String cyklKsztalcenia;
    String kierunekStudiow;
    String specjalnosc;
    String numerSemestru;

    public IdentyfikatorSemestruDto(String cyklKsztalcenia, String kierunekStudiow, String specjalnosc, String numerSemestru) {
        this.cyklKsztalcenia = cyklKsztalcenia;
        this.kierunekStudiow = kierunekStudiow;
        this.specjalnosc = specjalnosc;
        this.numerSemestru = numerSemestru;
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

    public String getNumerSemestru() {
        return numerSemestru;
    }

    public void setNumerSemestru(String numerSemestru) {
        this.numerSemestru = numerSemestru;
    }
}
