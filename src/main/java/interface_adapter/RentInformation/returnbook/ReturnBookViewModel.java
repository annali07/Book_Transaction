package interface_adapter.RentInformation.returnbook;

import interface_adapter.RentMenu.RentMenuState;
import interface_adapter.view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The ReturnBookViewModel class represents the view model for returning a book.
 * It manages the state of the return book process and provides property change support.
 *
 */
public class ReturnBookViewModel extends ViewModel {


    public final String TITLE_LABEL = "Return Book";
    public final String BOOKID_LABEL = "Enter bookID";
    public final String BOOK_NAME = "Enter bookName";

    public final String CANCEL_LABEL = "Cancel";

    public final String START_DATE = "start date";
    public final String ERROR_MESSAGE = "ERROR";
    public final String END_DATE = "end date";
    public final String RETURN_DATE = "return date";
    public final String RETURN_BOOK = "return book";


    private ReturnBookState state = new ReturnBookState();


    /**
     * Constructs a ReturnBookViewModel object with the default view name "return book".
     */
    public ReturnBookViewModel(){
        super("return book");
    }

    /**
     * Sets the current state of the return book process.
     *
     * @param state the new return book state
     */
    public void setState(ReturnBookState state) {
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
     * Gets the current state of the return book process.
     *
     * @return the current return book state
     */
    public ReturnBookState getState() {
        return this.state;
    }
}
