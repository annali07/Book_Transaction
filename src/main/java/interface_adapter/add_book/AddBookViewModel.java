package interface_adapter.add_book;

import interface_adapter.view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the Add Book view, managing the state and labels for the view components.
 * Provides methods for updating the state and notifying listeners of property changes.
 */
public class AddBookViewModel extends ViewModel {

    public final String TITLE_LABEL = "Add Book to Database for Book Store";
    public final String ISBN_LABEL = "Enter ISBN number";
    public final String PRICE_LABEL = "Enter book price";
    public final String ADD_BOOK_LABEL = "Add Book to Database";
    public final String CANCEL_LABEL = "Cancel";
    private AddBookState state = new AddBookState();

    /**
     * Constructs an AddBookViewModel with a default view name of "add book".
     */
    public AddBookViewModel() {
        super("add book");
    }

    /**
     * Sets the state of this view model.
     *
     * @param state the new state to set
     */
    public void setState(AddBookState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies listeners that the state property has changed.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a PropertyChangeListener to the listener list.
     *
     * @param listener the PropertyChangeListener to be added
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Returns the current state of this view model.
     *
     * @return the current AddBookState
     */
    public AddBookState getState(){
        return this.state;
    }
}
