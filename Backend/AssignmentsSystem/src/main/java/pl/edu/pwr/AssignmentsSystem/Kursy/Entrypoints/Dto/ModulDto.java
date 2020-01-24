package pl.edu.pwr.AssignmentsSystem.Kursy.Entrypoints.Dto;

import java.util.ArrayList;

public class ModulDto {
    String id;
    int liczbaGodzin;
    String nazwa;
    Boolean ogolnouczelniany;
    Boolean wybieralny;
    ArrayList<KursDto> kursy;

    public ModulDto(String id, int liczbaGodzin, String nazwa, Boolean ogolnouczelniany, Boolean wybieralny, ArrayList<KursDto> kursy) {
        this.id = id;
        this.liczbaGodzin = liczbaGodzin;
        this.nazwa = nazwa;
        this.ogolnouczelniany = ogolnouczelniany;
        this.wybieralny = wybieralny;
        this.kursy = kursy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ArrayList<KursDto> getKursy() {
        return kursy;
    }

    public void setKursy(ArrayList<KursDto> kursy) {
        this.kursy = kursy;
    }
}
