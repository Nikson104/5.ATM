package ATM;

import javax.naming.OperationNotSupportedException;

public interface AmountOperation {

    void addMoney (int amount) throws OperationNotSupportedException;
    void getMoney (int amount);
}
