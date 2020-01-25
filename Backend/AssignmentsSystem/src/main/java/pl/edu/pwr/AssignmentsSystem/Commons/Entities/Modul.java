package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Modul {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    private int liczbaGodzin;
    private String nazwa;
    private boolean ogolnouczelniany;
    private boolean wybieralny;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="moduly")
    private List<Kurs> kursList;

    public Modul() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Modul(int liczbaGodzin, String nazwa, boolean ogolnouczelniany, boolean wybieralny, List<Kurs> kursList,
            PlanStudiow planStudiow) {
        this.liczbaGodzin = liczbaGodzin;
        this.nazwa = nazwa;
        this.ogolnouczelniany = ogolnouczelniany;
        this.wybieralny = wybieralny;
        this.kursList = kursList;
    }

    public boolean isOgolnouczelniany() {
        return ogolnouczelniany;
    }

    public void setOgolnouczelniany(boolean ogolnouczelniany) {
        this.ogolnouczelniany = ogolnouczelniany;
    }

    public boolean isWybieralny() {
        return wybieralny;
    }

    public void setWybieralny(boolean wybieralny) {
        this.wybieralny = wybieralny;
    }

    public List<Kurs> getKursList() {
        return kursList;
    }

    public void setKursList(List<Kurs> kursList) {
        this.kursList = kursList;
    }

}
