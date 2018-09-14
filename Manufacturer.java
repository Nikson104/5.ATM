package ATM;

public class Manufacturer implements Info {
    private final String name;

    public Manufacturer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name of Manufacturer: " + this.name);
    }
}
