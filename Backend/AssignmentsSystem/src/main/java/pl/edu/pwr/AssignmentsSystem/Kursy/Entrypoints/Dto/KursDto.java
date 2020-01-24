package pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto;

public class KursDto {
    String formaZajec;
    int liczbaGodzin;
    String nazwa;


    public KursDto(String formaZajec, int liczbaGodzin, String nazwa) {
        this.formaZajec = formaZajec;
        this.liczbaGodzin = liczbaGodzin;
        this.nazwa = nazwa;
    }

    public String getFormaZajec() {
        return formaZajec;
    }

    public void setFormaZajec(String formaZajec) {
        this.formaZajec = formaZajec;
    }

    public int getLiczbaGodzin() {
        return liczbaGodzin;
    }

    public void setLiczbaGodzin(int liczbaGodzin) {
        this.liczbaGodzin = liczbaGodzin;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
