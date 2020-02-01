package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class PlanStudiow implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    private String cyklKsztalcenia;
    private int liczbaStudentow;
    private String kierunekStudiow;
    private String specjalnosc;
    private int numerSemestru;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="planStudiow")
    private List<Modul> modulList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planStudiow")
    private List<PlanPowierzen> planPowierzenList;

    public PlanStudiow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCyklKsztalcenia() {
        return cyklKsztalcenia;
    }

    public void setCyklKsztalcenia(String cyklKsztalcenia) {
        this.cyklKsztalcenia = cyklKsztalcenia;
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

    public List<Modul> getModulList() {
        return modulList;
    }

    public void setModulList(List<Modul> modulList) {
        this.modulList = modulList;
    }

    public List<PlanPowierzen> getPlanPowierzenList() {
        return planPowierzenList;
    }

    public void setPlanPowierzenList(List<PlanPowierzen> planPowierzenList) {
        this.planPowierzenList = planPowierzenList;
    }
}
