package interface_adapter.main_menu;

import interface_adapter.view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The MainMenuViewModel class represents the view model for the main menu.
 * It manages the state of the main menu and provides property change support.
 *
 */
public class MainMenuViewModel extends ViewModel {

    public final String TITLE_LABEL = "CommonBook Transaction Manager for CommonBook Store";
    public final String ADD_BOOK = "Add CommonBook Entry";
    public final String ADD_RENT = "Rent CommonBook Entry";
    public final String ADD_PURCHASE = "Purchase CommonBook Entry";
    public final String CALCULATE_REVENUE = "Calculate Revenue";

    private MainMenuState state = new MainMenuState();

    // Pass View Name to ViewModel
    /**
     * Constructs a MainMenuViewModel object with the default view name "main menu".
     */
    public MainMenuViewModel() {
        super("main menu");
    }

    /**
     * Sets the current state of the main menu.
     *
     * @param state the new main menu state
     */
    public void setState(MainMenuState state) {
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
     * Gets the current state of the main menu.
     *
     * @return the current main menu state
     */
    public MainMenuState getState() {
        return state;
    }
}