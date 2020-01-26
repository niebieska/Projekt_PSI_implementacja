package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Powierzenie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private int id;
    private int liczbaGodzin;
    private boolean zgodaProwadzacego;

    @CreatedDate
    private String dataUtworzenia;
    private boolean aktywny;

    @ManyToOne
    private Uzytkownik uzytkownik;
    @ManyToOne
    private Kurs kurs;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="powierzenie")
    private List<WersjaPowierzenia> wersjePowierzen;
    @ManyToOne
    private Uzytkownik koordynator;

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

    public boolean isZgodaProwadzacego() {
        return zgodaProwadzacego;
    }

    public void setZgodaProwadzacego(boolean zgodaProwadzacego) {
        this.zgodaProwadzacego = zgodaProwadzacego;
    }

    public String getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(String dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public boolean isAktywny() {
        return aktywny;
    }

    public void setAktywny(boolean aktywny) {
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
