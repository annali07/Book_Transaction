package interface_adapter.returnorborrow;

import interface_adapter.RentMenu.RentMenuState;
import interface_adapter.view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ReturnOrBorrowViewModel extends ViewModel {
    public final String TITLE_LABEL = "Return or Borrow";
    public final String RETURN = "return";
    public final String CANCEL_LABEL = "Cancel";
    public final String BORROW = "borrow";

    private ReturnOrBorrowState state = new ReturnOrBorrowState();

    public ReturnOrBorrowViewModel() {
        super("return or borrow");
    }

    public void setState(ReturnOrBorrowState state) {
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

    public ReturnOrBorrowState getState() {
        return state;
    }
}
