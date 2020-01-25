package pl.edu.pwr.CourseEnrollmentSystem.mockUpy;

public class KursDto {
    int id;
    String formaZajec;
    int liczbaGodzin;
    int liczbaGrup;
    String nazwa;


    public KursDto(int id, String formaZajec, int liczbaGodzin, int liczbaGrup, String nazwa) {
        this.id = id;
        this.formaZajec = formaZajec;
        this.liczbaGodzin = liczbaGodzin;
        this.liczbaGrup = liczbaGrup;
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLiczbaGrup() {
        return liczbaGrup;
    }

    public void setLiczbaGrup(int liczbaGrup) {
        this.liczbaGrup = liczbaGrup;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
