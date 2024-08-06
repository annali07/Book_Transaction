
package interface_adapter.RentMenu;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import interface_adapter.view.ViewModel;

/**
 * ViewModel for the Rent CommonBook view, managing the state and labels for the view components.
 * Provides methods for updating the state and notifying listeners of property changes.
 *
 */

public class RentMenuViewModel extends ViewModel{

    public final String TITLE_LABEL = "Rent Screen";
    public final String BOOKID_LABEL = "Enter bookID";
    public final String CANCEL_LABEL = "Cancel";

    public final String SEARCH_LABEL = "Search";
    public final String ERROR_MEESAGE = "ERROR";

    private RentMenuState state = new RentMenuState();

    /**
     * Constructs an RentMenuViewModel with a default view name of "rent book menu".
     */

    public RentMenuViewModel() {
        super("rent book menu");
    }

    /**
     * Sets the state of this view model.
     *
     * @param state the new state to set
     */

    public void setState(RentMenuState state) {
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
     * @return the current RentMenuState
     */
    public RentMenuState getState() {
        return state;
    }

}

