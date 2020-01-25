package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import com.sun.istack.NotNull;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

@Entity
public class PlanPowierzen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    private int zgodaKoordynatoraZapisow;
    private String nazwa;
    private String wersjaPlanu;
    private Timestamp dataUtworzenia; // do weryfikacji
    @ManyToOne
    private PlanStudiow planStudiow;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="powierzenia")
    private List<Powierzenie> powierzenia;

    public PlanPowierzen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZgodaKoordynatoraZapisow() {
        return zgodaKoordynatoraZapisow;
    }

    public void setZgodaKoordynatoraZapisow(int zgodaKoordynatoraZapisow) {
        this.zgodaKoordynatoraZapisow = zgodaKoordynatoraZapisow;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getWersjaPlanu() {
        return wersjaPlanu;
    }

    public void setWersjaPlanu(String wersjaPlanu) {
        this.wersjaPlanu = wersjaPlanu;
    }

    public Timestamp getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Timestamp dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public PlanStudiow getPlanStudiow() {
        return planStudiow;
    }

    public void setPlanStudiow(PlanStudiow planStudiow) {
        this.planStudiow = planStudiow;
    }

    public List<Powierzenie> getPowierzenia() {
        return powierzenia;
    }

    public void setPowierzenia(List<Powierzenie> powierzenia) {
        this.powierzenia = powierzenia;
    }
}
