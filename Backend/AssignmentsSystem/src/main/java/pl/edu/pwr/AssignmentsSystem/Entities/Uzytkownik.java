package pl.edu.pwr.AssignmentsSystem.Entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Uzytkownik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private int id;

    private String imie;
    private String nazwisko;
    private String email;
    private String login;
    private String rola;
    private String tytulNaukowy;
    private String formaZatrudnienia;
    private String stanowisko;
    private int pensum;
    private Boolean zgodaNaPrzekroczeniePensum;
    private Boolean pozytywnieZaopiniowany;
    private String rolaUzytkownika; //DType

    public Uzytkownik() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }


    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public String getTytulNaukowy() {
        return tytulNaukowy;
    }

    public void setTytulNaukowy(String tytulNaukowy) {
        this.tytulNaukowy = tytulNaukowy;
    }

    public String getFormaZatrudnienia() {
        return formaZatrudnienia;
    }

    public void setFormaZatrudnienia(String formaZatrudnienia) {
        this.formaZatrudnienia = formaZatrudnienia;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getPensum() {
        return pensum;
    }

    public void setPensum(int pensum) {
        this.pensum = pensum;
    }

    public Boolean getZgodaNaPrzekroczeniePensum() {
        return zgodaNaPrzekroczeniePensum;
    }

    public void setZgodaNaPrzekroczeniePensum(Boolean zgodaNaPrzekroczeniePensum) {
        this.zgodaNaPrzekroczeniePensum = zgodaNaPrzekroczeniePensum;
    }

    public Boolean getPozytywnieZaopiniowany() {
        return pozytywnieZaopiniowany;
    }

    public void setPozytywnieZaopiniowany(Boolean pozytywnieZaopiniowany) {
        this.pozytywnieZaopiniowany = pozytywnieZaopiniowany;
    }

    public String getRolaUzytkownika() {
        return rolaUzytkownika;
    }


    public void setRolaUzytkownika(String rolaUzytkownika) {
        this.rolaUzytkownika = rolaUzytkownika;
    }
}
