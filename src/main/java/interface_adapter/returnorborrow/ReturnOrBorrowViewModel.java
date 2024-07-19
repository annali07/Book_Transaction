package interface_adapter.returnorborrow;

import interface_adapter.RentMenu.RentMenuState;
import interface_adapter.view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the Return Or Borrow view, managing the state and labels for the view components.
 * Provides methods for updating the state and notifying listeners of property changes.
 *
 */
public class ReturnOrBorrowViewModel extends ViewModel {
    public final String TITLE_LABEL = "Return or Borrow";
    public final String RETURN = "return";
    public final String CANCEL_LABEL = "Cancel";
    public final String BORROW = "borrow";

    private ReturnOrBorrowState state = new ReturnOrBorrowState();

    /**
     * Constructs an ReturnOrBorrow ViewModel with a default view name of "return or borrow".
     */
    public ReturnOrBorrowViewModel() {
        super("return or borrow");
    }

    /**
     * Sets the state of this view model.
     *
     * @param state the new state to set
     */
    public void setState(ReturnOrBorrowState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies listeners that the state property has changed.
     */
    // This is what the MainMenu Presenter will call to let the ViewModel know to alert the View
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
     * @return the current ReturnOrBorrowState
     */
    public ReturnOrBorrowState getState() {
        return state;
    }
}
