package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainMenuViewModel extends ViewModel {

    public final String TITLE_LABEL = "Book Transaction Manager for Book Store";
    public final String ADD_BOOK = "Add Book Entry";
    public final String ADD_RENT = "Rent Book Entry";
    public final String ADD_PURCHASE = "Purchase Book Entry";
    public final String CALCULATE_REVENUE = "Calculate Revenue";

    private MainMenuState state = new MainMenuState();

    // Pass View Name to ViewModel
    public MainMenuViewModel() {
        super("main menu");
    }

    public void setState(MainMenuState state) {
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

    public MainMenuState getState() {
        return state;
    }
}