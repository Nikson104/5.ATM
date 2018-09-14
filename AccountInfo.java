package ATM;

import javax.naming.OperationNotSupportedException;

public interface AccountInfo {

    void displayBalance ();
    void displayNotes () throws OperationNotSupportedException;
}
