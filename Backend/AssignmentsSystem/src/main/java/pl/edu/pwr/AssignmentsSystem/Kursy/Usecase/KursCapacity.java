package pl.edu.pwr.AssignmentsSystem.Kursy.Usecase;

public enum KursCapacity {

    laboratorium(15),
    projekt(15),
    cwiczenia(30),
    wyklad(150),
    seminarium(20);
    private int capacity;

    private KursCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
