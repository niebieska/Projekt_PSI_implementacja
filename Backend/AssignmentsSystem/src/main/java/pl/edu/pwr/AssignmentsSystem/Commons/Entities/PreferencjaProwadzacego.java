package pl.edu.pwr.AssignmentsSystem.Commons.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class PreferencjaProwadzacego {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @ManyToOne
    private Uzytkownik uzytkownik;
    @ManyToOne
    private Kurs kurs;


}
