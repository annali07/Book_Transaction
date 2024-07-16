package interface_adapter.RentInformation.returnbook;

import interface_adapter.RentMenu.RentMenuState;
import interface_adapter.view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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
    public ReturnBookViewModel(){
        super("return book");
    }
    public void setState(ReturnBookState state) {
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

    public ReturnBookState getState() {
        return this.state;
    }
}
