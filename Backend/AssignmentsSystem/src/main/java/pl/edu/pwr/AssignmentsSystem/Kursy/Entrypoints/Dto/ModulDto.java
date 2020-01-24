package pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto;

import java.util.ArrayList;

public class ModulDto {
    int liczbaGodzin;
    String nazwa;
    Boolean ogolnouczelniany;
    Boolean wybieralny;
    ArrayList<KursDto> kurs;

    public ModulDto(int liczbaGodzin, String nazwa, Boolean ogolnouczelniany, Boolean wybieralny, ArrayList<KursDto> kurs) {
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

    public ArrayList<KursDto> getKurs() {
        return kurs;
    }

    public void setKurs(ArrayList<KursDto> kurs) {
        this.kurs = kurs;
    }
}
