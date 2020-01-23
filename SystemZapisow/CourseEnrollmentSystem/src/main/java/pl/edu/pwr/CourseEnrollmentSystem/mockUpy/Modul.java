package pl.edu.pwr.CourseEnrollmentSystem.mockUpy;

public class Modul {
    int liczbaGodzin;
    String nazwa;
    Boolean ogolnouczelniany;
    Boolean wybieralny;
    Kurs kurs;

    public Modul(int liczbaGodzin, String nazwa, Boolean ogolnouczelniany, Boolean wybieralny, Kurs kurs) {
        this.liczbaGodzin = liczbaGodzin;
        this.nazwa = nazwa;
        this.ogolnouczelniany = ogolnouczelniany;
        this.wybieralny = wybieralny;
        this.kurs = kurs;
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

    public Boolean getOgolnouczelniany() {
        return ogolnouczelniany;
    }

    public void setOgolnouczelniany(Boolean ogolnouczelniany) {
        this.ogolnouczelniany = ogolnouczelniany;
    }

    public Boolean getWybieralny() {
        return wybieralny;
    }

    public void setWybieralny(Boolean wybieralny) {
        this.wybieralny = wybieralny;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }
}
