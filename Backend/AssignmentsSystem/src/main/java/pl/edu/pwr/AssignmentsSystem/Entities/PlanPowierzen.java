package pl.edu.pwr.AssignmentsSystem.Entities;

import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;
import java. sql. Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlanPowierzen {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@NotNull
private int id;

private int zgodaKoordynatoraZapisow;
private  String nazwa;
private String  wersjaPlanu;
private  Timestamp dataUtworzenia; // do weryfikacji


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
}
