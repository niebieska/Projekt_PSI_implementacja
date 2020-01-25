package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class WersjaPowierzenia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    private int wersja;
    private int liczbaGodzin;
    private int ZgodaProwadzacego;
    private Timestamp dataUtworzenia;
    private int prowadzacyId; // bez koniecznosci polaczenia

    @ManyToOne
    private Powierzenie powierzenie;
    @ManyToOne
    private Uzytkownik uzytkownik;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWersja() {
        return wersja;
    }

    public void setWersja(int wersja) {
        this.wersja = wersja;
    }

    public int getLiczbaGodzin() {
        return liczbaGodzin;
    }

    public void setLiczbaGodzin(int liczbaGodzin) {
        this.liczbaGodzin = liczbaGodzin;
    }

    public int getZgodaProwadzacego() {
        return ZgodaProwadzacego;
    }

    public void setZgodaProwadzacego(int zgodaProwadzacego) {
        ZgodaProwadzacego = zgodaProwadzacego;
    }

    public Timestamp getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Timestamp dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public int getProwadzacyId() {
        return prowadzacyId;
    }

    public void setProwadzacyId(int prowadzacyId) {
        this.prowadzacyId = prowadzacyId;
    }

    public Powierzenie getPowierzenie() {
        return powierzenie;
    }

    public void setPowierzenie(Powierzenie powierzenie) {
        this.powierzenie = powierzenie;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }
}
