package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class WersjaPowierzenia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    private int wersja;
    private int liczbaGodzin;
    private boolean ZgodaProwadzacego;

    @CreatedDate
    private String dataUtworzenia;
    private int koordynatorID; // bez koniecznosci polaczenia

    @ManyToOne
    @JoinColumn(name ="kurs_id")
    private Kurs kurs;

    @ManyToOne
    @JoinColumn(name ="prowadzacy_id")
    private Uzytkownik prowadzacy;


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

    public boolean isZgodaProwadzacego() {
        return ZgodaProwadzacego;
    }

    public void setZgodaProwadzacego(boolean zgodaProwadzacego) {
        ZgodaProwadzacego = zgodaProwadzacego;
    }

    public String getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(String dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public int getKoordynatorID() {
        return koordynatorID;
    }

    public void setKoordynatorID(int koordynatorID) {
        this.koordynatorID = koordynatorID;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public Uzytkownik getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(Uzytkownik prowadzacy) {
        this.prowadzacy = prowadzacy;
    }
}
