package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class PreferencjaProwadzacego {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @ManyToOne
    private Uzytkownik uzytkownik;
    @ManyToOne
    private Kurs kurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
