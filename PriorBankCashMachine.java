package ATM;

import javax.naming.OperationNotSupportedException;

public class PriorBankCashMachine extends AbstractCashMachine {

    public PriorBankCashMachine(Bank bank, Manufacturer manufacturer) {
        super(bank, manufacturer);
    }

    @Override
    public void displayNotes() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Operation displayNotes are not supported in PriorBank");
    }

    @Override
    public void addMoney(int amount) {

        int addedFiftyNotes = 0;
        int addedHundredNotes = 0;
        int addedTwentyNotes = 0;

        int remainingAmount = amount % 100;
        addedHundredNotes = (amount - remainingAmount) / 100;

        if (remainingAmount > 0) {
            remainingAmount = remainingAmount % 50;
            addedFiftyNotes = (amount - addedHundredNotes * 100 - remainingAmount) / 50;
        }

        if (remainingAmount > 0) {
            remainingAmount = remainingAmount % 20;
            addedTwentyNotes = (amount - addedHundredNotes * 100 - addedFiftyNotes * 50 - remainingAmount) / 20;
        }

        if (remainingAmount > 0) {
            System.out.println("Please enter another amount");
        } else {
            this.setAmountHundredNotes(this.getAmountHundredNotes() + addedHundredNotes);
            this.setAmountFiftyNotes(this.getAmountFiftyNotes() + addedFiftyNotes);
            this.setAmountTwentyNotes(this.getAmountTwentyNotes() + addedTwentyNotes);
        }
    }

}


