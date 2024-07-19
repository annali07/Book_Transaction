package interface_adapter.calculate_revenue;

import interface_adapter.add_book.AddBookState;
import interface_adapter.view.ViewModel;
import view.views.RevenueView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RevenueViewModel extends ViewModel {
    public final String TOTAL_REVENUE = "Total Revenue";
    public final String RENT_REVENUE = "Rental Revenue";
    public final String PURCHASE_REVENUE = "Purchase Revenue";
    public final String CANCEL = "Cancel";


    private RevenueState state = new RevenueState();

    /**
     * Constructs an AddBookViewModel with a default view name of "add book".
     */
    public RevenueViewModel() {
        super("Calculate Revenue");
    }

    /**
     * Sets the state of this view model.
     *
     * @param state the new state to set
     */
    public void setState(RevenueState state ){
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

    public RevenueState getState(){
        return this.state;
    }
}
