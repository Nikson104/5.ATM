package ATM;

public class Bank implements Info {
    private final String name;

    public Bank(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name of Bank: " + this.name);
    }
}
