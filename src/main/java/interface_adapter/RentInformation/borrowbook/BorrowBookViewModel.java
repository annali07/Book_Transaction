package interface_adapter.RentInformation.borrowbook;

import interface_adapter.RentInformation.returnbook.ReturnBookState;
import interface_adapter.view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BorrowBookViewModel extends ViewModel {

    public final String TITLE_LABEL = "Borrow Book";
    public final String BOOKID_LABEL = "Enter bookID";
    public final String BOOK_NAME = "Enter bookName";

    public final String CANCEL_LABEL = "Cancel";

    public final String START_DATE = "start date";
    public final String ERROR_MESSAGE = "ERROR";
    public final String END_DATE = "end date";
    public final String BORROWER_NAME = "borrower name";
    public final String BORROWER_NUMBER = "borrower number";
    public final String BORROW_BOOK = "borrow book";

    private BorrowBookState state = new BorrowBookState();


    public BorrowBookViewModel() {super("borrow book");}
    public void setState(BorrowBookState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the MainMenu Presenter will call to let the ViewModel know to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public BorrowBookState getState() {
        return this.state;
    }
}
