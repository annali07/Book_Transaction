

package interface_adapter.purchase_book;

import interface_adapter.add_book.AddBookState;
import interface_adapter.view.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PurchaseViewModel extends ViewModel {

    public final String TITLE_LABELE = "Purchase";
    public final String ID_BOX_LABLE = "Enter the bookID";

    public final String PURCHASE_SUCCESS_LABLE = "Purchase successfully!";
    public final String SEARCH_FAILURE_LABLE = "Failed to purchase the book";

    private PurchaseState purchaseState = new PurchaseState();

    public final String CONFIREM_LABLE = "Purchase";
    public final String CANCEL_LABLE = "Cancel";

    public PurchaseViewModel() {
        super("purchase book");
    }

    public void setPurchaseState(PurchaseState purchaseState) {
        this.purchaseState = purchaseState;
    }

    public PurchaseState getPurchaseState(){
        return purchaseState;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

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

    public PurchaseState getState(){
        return this.purchaseState;
    }
}

