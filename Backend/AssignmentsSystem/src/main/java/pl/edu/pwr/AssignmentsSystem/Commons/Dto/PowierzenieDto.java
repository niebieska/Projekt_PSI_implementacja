package pl.edu.pwr.AssignmentsSystem.Commons.Dto;

public class PowierzenieDto {

    int id;
    ProwadzacyDto prowadzacy;
    KursDto kurs;
    int liczbaGodzin;
    Boolean zgodaProwadzacego;

    public PowierzenieDto(int id, ProwadzacyDto prowadzacy, KursDto kurs, int liczbaGodzin, Boolean zgodaProwadzacego) {
        this.id = id;
        this.prowadzacy = prowadzacy;
        this.kurs = kurs;
        this.liczbaGodzin = liczbaGodzin;
        this.zgodaProwadzacego = zgodaProwadzacego;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProwadzacyDto getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(ProwadzacyDto prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public KursDto getKurs() {
        return kurs;
    }

    public void setKurs(KursDto kurs) {
        this.kurs = kurs;
    }

    public int getLiczbaGodzin() {
        return liczbaGodzin;
    }

    public void setLiczbaGodzin(int liczbaGodzin) {
        this.liczbaGodzin = liczbaGodzin;
    }

    public Boolean getZgodaProwadzacego() {
        return zgodaProwadzacego;
    }

    public void setZgodaProwadzacego(Boolean zgodaProwadzacego) {
        this.zgodaProwadzacego = zgodaProwadzacego;
    }
}
