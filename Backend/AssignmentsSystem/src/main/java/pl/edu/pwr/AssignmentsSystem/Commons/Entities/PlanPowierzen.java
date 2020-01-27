package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class PlanPowierzen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    private boolean zgodaKoordynatoraZapisow;
    private String nazwa;
    private String wersjaPlanu;
    @CreatedDate
    private String dataUtworzenia; // do weryfikacji

    @ManyToOne
    @JoinColumn(name="planStudiow_id")
    private PlanStudiow planStudiow;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planPowierzen")
    private List<Powierzenie> powierzenia;

    public PlanPowierzen() {
    }

    public PlanStudiow getPlanStudiow() {
        return planStudiow;
    }

    public void setPlanStudiow(PlanStudiow planStudiow) {
        this.planStudiow = planStudiow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isZgodaKoordynatoraZapisow() {
        return zgodaKoordynatoraZapisow;
    }

    public void setZgodaKoordynatoraZapisow(boolean zgodaKoordynatoraZapisow) {
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

    public String getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(String dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public List<Powierzenie> getPowierzenia() {
        return powierzenia;
    }

    public void setPowierzenia(List<Powierzenie> powierzenia) {
        this.powierzenia = powierzenia;
    }
}
