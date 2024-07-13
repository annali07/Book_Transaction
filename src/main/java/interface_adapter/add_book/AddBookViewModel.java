package interface_adapter.add_book;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/*
    2 Buttons: Add Book & Cancel
    Various Input Fields:
*/
public class AddBookViewModel extends ViewModel {

    public final String TITLE_LABEL = "Add Book to Database for Book Store";
    public final String ISBN_LABEL = "Enter ISBN Number";
    public final String ADD_BOOK_LABEL = "Add Book to Database";
    public final String CANCEL_LABEL = "Cancel";

    private AddBookState state = new AddBookState();

    public AddBookViewModel() {
        super("add book");
    }

    public void setState(AddBookState state){
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public AddBookState getState(){
        return state;
    }
}
