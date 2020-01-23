package pl.edu.pwr.AssignmentsSystem.Entities;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

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
}
