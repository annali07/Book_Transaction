package interface_adapter.RentInformation.returnbook;

import interface_adapter.RentMenu.RentMenuState;
import interface_adapter.view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the Return Book view, managing the state and labels for the view components.
 * Provides methods for updating the state and notifying listeners of property changes.
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
     * Constructs an ReturnBookViewModel with a default view name of "return book".
     */
    public ReturnBookViewModel(){
        super("return book");
    }

    /**
     * Sets the state of this view model.
     *
     * @param state the new state to set
     */
    public void setState(ReturnBookState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the MainMenu Presenter will call to let the ViewModel know to alert the View
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
     * @return the current ReturnBookState
     */
    public ReturnBookState getState() {
        return this.state;
    }
}
