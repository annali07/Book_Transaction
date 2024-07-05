package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/*
    2 Buttons: Add Book & Cancel
    Various Input Fields:
*/
public class AddBookViewModel extends ViewModel{

    public final String TITLE_LABEL = "Add Book View";
    public final String ADD_BOOK_LABEL = "Add Book to Database";
    public final String CANCEL_LABEL = "Cancel";

//    private AddBookState state = new AddBookState();

    public AddBookViewModel() {
        super("add book");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

}
