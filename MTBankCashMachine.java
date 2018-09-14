package ATM;

import javax.naming.OperationNotSupportedException;

public class MTBankCashMachine extends AbstractCashMachine {
    public MTBankCashMachine(Bank bank, Manufacturer manufacturer) {
        super(bank, manufacturer);
    }


    @Override
    public void displayNotes() {
        System.out.println("Count of hundred notes " + getAmountHundredNotes());
        System.out.println("Count of fifty notes " + getAmountFiftyNotes());
        System.out.println("Count of twenty notes " + getAmountTwentyNotes());

    }

    @Override
    public void addMoney(int amount) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Operation addMoney are not supported in MTBank");

    }
}
