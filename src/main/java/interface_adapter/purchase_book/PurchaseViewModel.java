

package interface_adapter.purchase_book;

import interface_adapter.add_book.AddBookState;
import interface_adapter.view.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * PurchaseViewModel class manages the view state for book purchases.
 *
 * @version 1.0
 */
public class PurchaseViewModel extends ViewModel {

    public final String TITLE_LABELE = "Purchase";
    public final String ID_BOX_LABLE = "Enter the bookID";

    public final String PURCHASE_SUCCESS_LABLE = "Purchase successfully!";
    public final String SEARCH_FAILURE_LABLE = "Failed to purchase the book";

    private PurchaseState purchaseState = new PurchaseState();

    public final String CONFIREM_LABLE = "Purchase";
    public final String CANCEL_LABLE = "Cancel";

    /**
     * Constructs a PurchaseViewModel object.
     */
    public PurchaseViewModel() {
        super("purchase book");
    }

    /**
     * Sets the purchase state.
     *
     * @param purchaseState the PurchaseState object
     */
    public void setPurchaseState(PurchaseState purchaseState) {
        this.purchaseState = purchaseState;
    }

    /**
     * Gets the purchase state.
     *
     * @return the PurchaseState object
     */
    public PurchaseState getPurchaseState(){
        return purchaseState;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires a property change event.
     */
    public void firePropertyChange()  {
        support.firePropertyChange("state", null, this.purchaseState);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    /**
     * Gets the current purchase state.
     *
     * @return the PurchaseState object
     */
    public PurchaseState getState(){
        return this.purchaseState;
    }
}

