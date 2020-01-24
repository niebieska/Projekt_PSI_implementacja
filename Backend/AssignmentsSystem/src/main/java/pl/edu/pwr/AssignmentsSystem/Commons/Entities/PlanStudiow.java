package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlanStudiow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    private String cyklKrztalcenia;
    private int liczbaStudentow;
    private String kierunekStudiow;
    private String specjalnosc;
    private int numerSemestru;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="planStudiow")
    private List<Modul> modulList;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="planPowierzen")
    private List<PlanPowierzen> planPowierzenList;

    public PlanStudiow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCyklKrztalcenia() {
        return cyklKrztalcenia;
    }

    public void setCyklKrztalcenia(String cyklKrztalcenia) {
        this.cyklKrztalcenia = cyklKrztalcenia;
    }

    public int getLiczbaStudentow() {
        return liczbaStudentow;
    }

    public void setLiczbaStudentow(int liczbaStudentow) {
        this.liczbaStudentow = liczbaStudentow;
    }

    public String getKierunekStudiow() {
        return kierunekStudiow;
    }

    public void setKierunekStudiow(String kierunekStudiow) {
        this.kierunekStudiow = kierunekStudiow;
    }

    public String getSpecjalnosc() {
        return specjalnosc;
    }

    public void setSpecjalnosc(String specjalnosc) {
        this.specjalnosc = specjalnosc;
    }

    public int getNumerSemestru() {
        return numerSemestru;
    }

    public void setNumerSemestru(int numerSemestru) {
        this.numerSemestru = numerSemestru;
    }
}
