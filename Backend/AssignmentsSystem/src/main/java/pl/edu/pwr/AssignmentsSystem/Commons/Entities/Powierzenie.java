package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Powierzenie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private int id;
    private int liczbaGodzin;
    private int zgodaProwadzacego;
    private Timestamp dataUtworzenia;
    private int aktywny;

    @ManyToOne
    Uzytkownik uzytkownik;
    @ManyToOne
    private Kurs kurs;
    @ManyToOne
    @JoinColumn(name="powierzenie")
    private PlanPowierzen planPowierzen;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="powierzenie")
    private List<WersjaPowierzenia> wersjePowierzen;
    @ManyToOne
    Uzytkownik koordynator;

    public Powierzenie() {
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

    public int getZgodaProwadzacego() {
        return zgodaProwadzacego;
    }

    public void setZgodaProwadzacego(int zgodaProwadzacego) {
        this.zgodaProwadzacego = zgodaProwadzacego;
    }

    public Timestamp getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Timestamp dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public int getAktywny() {
        return aktywny;
    }

    public void setAktywny(int aktywny) {
        this.aktywny = aktywny;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public PlanPowierzen getPlanPowierzen() {
        return planPowierzen;
    }

    public void setPlanPowierzen(PlanPowierzen planPowierzen) {
        this.planPowierzen = planPowierzen;
    }

    public List<WersjaPowierzenia> getWersjePowierzen() {
        return wersjePowierzen;
    }

    public void setWersjePowierzen(List<WersjaPowierzenia> wersjePowierzen) {
        this.wersjePowierzen = wersjePowierzen;
    }

    public Uzytkownik getKoordynator() {
        return koordynator;
    }

    public void setKoordynator(Uzytkownik koordynator) {
        this.koordynator = koordynator;
    }
}
