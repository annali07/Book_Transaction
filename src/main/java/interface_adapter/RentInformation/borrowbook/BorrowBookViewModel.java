package interface_adapter.RentInformation.borrowbook;

import interface_adapter.RentInformation.returnbook.ReturnBookState;
import interface_adapter.view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the Borrow Book view, managing the state and labels for the view components.
 * Provides methods for updating the state and notifying listeners of property changes.
 *
 */

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

    /**
     * Constructs an BorrowBookModel with a default view name of "borrow book".
     */
    public BorrowBookViewModel() {super("borrow book");}

    /**
     * Sets the state of this view model.
     *
     * @param state the new state to set
     */
    public void setState(BorrowBookState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies listeners that the state property has changed.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a PropertyChangeListener to the listener list.
     *
     * @param listener the PropertyChangeListener to be added
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Returns the current state of this view model.
     *
     * @return the current BorrowBookState
     */
    public BorrowBookState getState() {
        return this.state;
    }
}
