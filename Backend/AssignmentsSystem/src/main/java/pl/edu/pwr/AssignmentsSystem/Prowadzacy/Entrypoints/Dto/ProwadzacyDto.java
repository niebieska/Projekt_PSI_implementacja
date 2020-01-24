package pl.edu.pwr.AssignmentsSystem.Prowadzacy.Entrypoints.Dto;

public class ProwadzacyDto {
String id;
String imie;
String nazwisko;
String email;
int pensum;
int pozostaloPensum;

    public ProwadzacyDto(String id, String imie, String nazwisko, String email, int pensum, int pozostaloPensum) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.pensum = pensum;
        this.pozostaloPensum = pozostaloPensum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
