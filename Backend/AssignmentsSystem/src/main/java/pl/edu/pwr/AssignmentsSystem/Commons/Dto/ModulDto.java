package pl.edu.pwr.AssignmentsSystem.Commons.Dto;

import java.util.List;

public class ModulDto {
    int id;
    int liczbaGodzin;
    String nazwa;
    Boolean ogolnouczelniany;
    Boolean wybieralny;
    List<KursDto> kursy;

    public ModulDto(int id, int liczbaGodzin, String nazwa, Boolean ogolnouczelniany, Boolean wybieralny, List<KursDto> kursy) {
        this.id = id;
        this.liczbaGodzin = liczbaGodzin;
        this.nazwa = nazwa;
        this.ogolnouczelniany = ogolnouczelniany;
        this.wybieralny = wybieralny;
        this.kursy = kursy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModulDto() {
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

    public List<KursDto> getKursy() {
        return kursy;
    }

    public void setKursy(List<KursDto> kursy) {
        this.kursy = kursy;
    }
}
