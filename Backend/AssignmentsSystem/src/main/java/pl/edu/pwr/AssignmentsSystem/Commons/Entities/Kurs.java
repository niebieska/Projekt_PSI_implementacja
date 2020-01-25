package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kurs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    private String formaZajec;
    private int liczbaGodzin;
    private String nazwa;
    @OneToMany
    @JoinColumn(name="kurs")
    private List<PreferencjaProwadzacego> preferencjeProwadzacego;
    private int liczbaGrup;

    public Kurs() {
    }

    public Kurs(String formaZajec, int liczbaGodzin, String nazwa,
            List<PreferencjaProwadzacego> preferencjeProwadzacego, Modul moduly, int liczbaGrup) {
        this.formaZajec = formaZajec;
        this.liczbaGodzin = liczbaGodzin;
        this.nazwa = nazwa;
        this.preferencjeProwadzacego = preferencjeProwadzacego;
        this.liczbaGrup = liczbaGrup;
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

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<PreferencjaProwadzacego> getPreferencjeProwadzacego() {
        return preferencjeProwadzacego;
    }

    public void setPreferencjeProwadzacego(List<PreferencjaProwadzacego> preferencjeProwadzacego) {
        this.preferencjeProwadzacego = preferencjeProwadzacego;
    }


    public int getLiczbaGrup() {
        return liczbaGrup;
    }

    public void setLiczbaGrup(int liczbaGrup) {
        this.liczbaGrup = liczbaGrup;
    }
}
