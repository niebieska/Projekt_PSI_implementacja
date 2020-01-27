package pl.edu.pwr.AssignmentsSystem.Commons.Dto;

public class ProwadzacyDto {
    private int id;
    private String imie;
    private String nazwisko;
    private String email;
    private int pensum;
    private int pozostaloPensum;
    private String tytulNaukowy;
    private String formaZatrudnienia;
    private String stanowisko;
    private Boolean zgodaNaPrzekroczeniePensum;
    private Boolean pozytywneZaopiniowanie;


    public ProwadzacyDto(int id, String imie, String nazwisko, String email, int pensum, int pozostaloPensum) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.pensum = pensum;
        this.pozostaloPensum = pozostaloPensum;
    }

    public ProwadzacyDto(int id, String imie, String nazwisko, String email, int pensum, int pozostaloPensum,
            String tytulNaukowy, String formaZatrudnienia, String stanowisko, Boolean zgodaNaPrzekroczeniePensum,
            Boolean pozytywneZaopiniowanie) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.pensum = pensum;
        this.pozostaloPensum = pozostaloPensum;
        this.tytulNaukowy = tytulNaukowy;
        this.formaZatrudnienia = formaZatrudnienia;
        this.stanowisko = stanowisko;
        this.zgodaNaPrzekroczeniePensum = zgodaNaPrzekroczeniePensum;
        this.pozytywneZaopiniowanie = pozytywneZaopiniowanie;
    }

    public ProwadzacyDto() {
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

    public int getPensum() {
        return pensum;
    }

    public void setPensum(int pensum) {
        this.pensum = pensum;
    }

    public int getPozostaloPensum() {
        return pozostaloPensum;
    }

    public void setPozostaloPensum(int pozostaloPensum) {
        this.pozostaloPensum = pozostaloPensum;
    }
}
