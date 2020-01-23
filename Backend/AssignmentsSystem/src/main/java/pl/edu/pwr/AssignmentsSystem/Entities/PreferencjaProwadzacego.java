package pl.edu.pwr.AssignmentsSystem.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

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
