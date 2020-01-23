package pl.edu.pwr.HRSystem.mockUpy;

public class Pracownik {
    String imie;
    String nazwisko;
    String email;
    String login;
    String tytulNaukowy;
    String formaZatrudnienia;
    String stanowisko;
    int pensum;
    Boolean zgodaNaPrzekroczeniePensum;
    Boolean pozytywneZaopiniowanie;

    public Pracownik(String imie, String nazwisko, String email, String login, String tytulNaukowy, String formaZatrudnienia, String stanowisko, int pensum, Boolean zgodaNaPrzekroczeniePensum, Boolean pozytywneZaopiniowanie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
                this.login = login;
        this.tytulNaukowy = tytulNaukowy;
        this.formaZatrudnienia = formaZatrudnienia;
        this.stanowisko =  stanowisko;
        this.pensum = pensum;
        this.zgodaNaPrzekroczeniePensum = zgodaNaPrzekroczeniePensum;
        this.pozytywneZaopiniowanie = pozytywneZaopiniowanie;
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

    public Boolean getPozytywneZaopiniowanie() {
        return pozytywneZaopiniowanie;
    }

    public void setPozytywneZaopiniowanie(Boolean pozytywneZaopiniowanie) {
        this.pozytywneZaopiniowanie = pozytywneZaopiniowanie;
    }
}
