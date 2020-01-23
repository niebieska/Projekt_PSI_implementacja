package pl.edu.pwr.AssignmentsSystem.Entities;

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
    private int ogolnouczelniany;
    private int wybieralny;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Kurs> kursList;
    @ManyToOne
    private PlanStudiow planStudiow;

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

    public int getOgolnouczelniany() {
        return ogolnouczelniany;
    }

    public void setOgolnouczelniany(int ogolnouczelniany) {
        this.ogolnouczelniany = ogolnouczelniany;
    }

    public int getWybieralny() {
        return wybieralny;
    }

    public void setWybieralny(int wybieralny) {
        this.wybieralny = wybieralny;
    }
}
