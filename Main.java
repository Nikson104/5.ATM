package ATM;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank("MTBank");
        Bank bank2 = new Bank("PriorBank");

        Manufacturer manufacturer = new Manufacturer("NCR");
        AbstractCashMachine priorBankCashMachine = new PriorBankCashMachine(bank1, manufacturer);
        AbstractCashMachine mtbBankCashMachine = new MTBankCashMachine(bank2, manufacturer);

        bank1.displayInfo();
        bank2.displayInfo();
        manufacturer.displayInfo();
        priorBankCashMachine.displayBalance();

        try {
            mtbBankCashMachine.addMoney(150);

        } catch(OperationNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            priorBankCashMachine.addMoney(150);

        } catch(OperationNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            priorBankCashMachine.displayNotes();

        } catch(OperationNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            mtbBankCashMachine.displayNotes();

        } catch(OperationNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }
        mtbBankCashMachine.displayBalance();
        priorBankCashMachine.displayBalance();
        mtbBankCashMachine.getMoney(150);
        priorBankCashMachine.getMoney(150);
        mtbBankCashMachine.displayBalance();
        priorBankCashMachine.displayBalance();
        mtbBankCashMachine.info();
        priorBankCashMachine.info();
    }
}