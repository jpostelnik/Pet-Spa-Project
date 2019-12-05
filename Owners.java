import java.util.ArrayList;

public class Owners {
    private String name;
    private ArrayList<Pets> pets = new ArrayList<Pets>();
    private String number, streetAddress;
    private double bill;

    public Owners(String name, String number, String streetAddress) {
        this.name = name;
        this.number = number;
        this.streetAddress = streetAddress;
        this.bill = 0.0;
    }

    public ArrayList<Pets> getPets() {
        return pets;
    }

    public void setPets(String n, int a) {
        pets.add(new Pets(n, a));

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill += bill;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPets(ArrayList<Pets> pets) {
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " owes us: " + String.format("%0.2f",bill);
    }
}
