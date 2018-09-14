package ATM;

import javax.naming.OperationNotSupportedException;


public abstract class AbstractCashMachine implements AmountOperation, AccountInfo {
    private int amountFiftyNotes;
    private int amountHundredNotes;
    private int amountTwentyNotes;

    private final Bank bank;
    private final Manufacturer manufacturer;

    public void info() {
        this.bank.displayInfo();
        this.manufacturer.displayInfo();
    }

    public AbstractCashMachine(Bank bank, Manufacturer manufacturer) {
        this.bank = bank;
        this.manufacturer = manufacturer;
        this.amountFiftyNotes = 2;
        this.amountHundredNotes = 2;
        this.amountTwentyNotes = 2;
    }

    public int getAmountFiftyNotes() {

        return amountFiftyNotes;
    }

    public void setAmountFiftyNotes(int amounеtFiftyNotes) {

        this.amountFiftyNotes = amounеtFiftyNotes;
    }

    public int getAmountHundredNotes() {

        return amountHundredNotes;
    }

    public void setAmountHundredNotes(int amounеtHundredNotes) {

        this.amountHundredNotes = amounеtHundredNotes;
    }

    public int getAmountTwentyNotes() {
        return amountTwentyNotes;
    }

    public void setAmountTwentyNotes(int amounеtTwentyNotes) {
        this.amountTwentyNotes = amounеtTwentyNotes;
    }

    public Bank getBank() {
        return bank;
    }

    public Manufacturer getManufacturer() {

        return manufacturer;
    }

    @Override
    public void displayBalance() {
        System.out.println("All cash = " + (this.amountFiftyNotes * 50 + this.amountHundredNotes * 100 +
                this.amountTwentyNotes * 20) + " USD in " + bank.getName());
    }

    @Override
    public void getMoney(int amount) {
        if (amount > (this.amountFiftyNotes * 50 + this.amountHundredNotes * 100 +
                this.amountTwentyNotes * 20)) {
            System.out.println("Your cash is less than required amount");
        } else {
            int usedFiftyNotes = 0;
            int usedHundredNotes = 0;
            int usedTwentyNotes = 0;

            int remainingAmount = amount % 100;
            usedHundredNotes = (amount - remainingAmount) / 100;

            if (remainingAmount > 0) {
                remainingAmount = remainingAmount % 50;
                usedFiftyNotes = (amount - usedHundredNotes * 100 - remainingAmount) / 50;
            }

            if (remainingAmount > 0) {
                remainingAmount = remainingAmount % 20;
                usedTwentyNotes = (amount - usedHundredNotes * 100 - usedFiftyNotes * 50 - remainingAmount) / 20;
            }

            if (remainingAmount > 0) {
                System.out.println("Please enter another amount");
            } else {
                this.amountHundredNotes = this.amountHundredNotes - usedHundredNotes;
                this.amountFiftyNotes = this.amountFiftyNotes - usedFiftyNotes;
                this.amountTwentyNotes = this.amountTwentyNotes - usedTwentyNotes;
            }
        }
    }
}

