package interface_adapter.RentInformation.borrowbook;

import interface_adapter.RentInformation.returnbook.ReturnBookState;
import interface_adapter.view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The BorrowBookViewModel class represents the view model for borrowing a book.
 * It manages the state of the borrow book process and provides property change support.
 *
 */
public class BorrowBookViewModel extends ViewModel {

    public final String TITLE_LABEL = "Borrow CommonBook";
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

    /**
     * Constructs a BorrowBookViewModel object with the default view name "borrow book".
     */
    public BorrowBookViewModel() {super("borrow book");}

    /**
     * Sets the current state of the borrow book process.
     *
     * @param state the new borrow book state
     */
    public void setState(BorrowBookState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the MainMenu Presenter will call to let the ViewModel know to alert the View
    /**
     * Fires a property change event for the state property.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener the listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the borrow book process.
     *
     * @return the current borrow book state
     */
    public BorrowBookState getState() {
        return this.state;
    }
}
