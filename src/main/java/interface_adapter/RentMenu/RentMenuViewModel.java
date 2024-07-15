
package interface_adapter.RentMenu;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import interface_adapter.view.ViewModel;

public class RentMenuViewModel extends ViewModel{

    public final String TITLE_LABEL = "Rent Screen";
    public final String BOOKID_LABEL = "Enter bookID";
    public final String CANCEL_LABEL = "Cancel";

    public final String SEARCH_LABEL = "Search";
    public final String ERROR_MEESAGE = "ERROR";

    private RentMenuState state = new RentMenuState();

    public RentMenuViewModel() {
        super("rent book menu");
    }

    public void setState(RentMenuState state) {
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

    public RentMenuState getState() {
        return state;
    }

}

