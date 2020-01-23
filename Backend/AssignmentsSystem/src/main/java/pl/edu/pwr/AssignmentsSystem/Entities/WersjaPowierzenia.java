package pl.edu.pwr.AssignmentsSystem.Entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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


}
