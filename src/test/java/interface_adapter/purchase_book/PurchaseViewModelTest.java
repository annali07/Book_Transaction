package interface_adapter.purchase_book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseViewModelTest {

    private PurchaseViewModel purchaseViewModel;

    @BeforeEach
    void setUp() {
        purchaseViewModel = new PurchaseViewModel();
    }

    @Test
    void testInitialValues() {
        assertEquals("Purchase", purchaseViewModel.TITLE_LABELE);
        assertEquals("Enter the bookID", purchaseViewModel.ID_BOX_LABLE);
        assertEquals("Purchase successfully!", purchaseViewModel.PURCHASE_SUCCESS_LABLE);
        assertEquals("Failed to purchase the book", purchaseViewModel.SEARCH_FAILURE_LABLE);
        assertEquals("Purchase", purchaseViewModel.CONFIREM_LABLE);
        assertEquals("Cancel", purchaseViewModel.CANCEL_LABLE);
        assertEquals("purchase book", purchaseViewModel.getViewName());
        assertNotNull(purchaseViewModel.getPurchaseState());
    }

    @Test
    void testSetAndGetPurchaseState() {
        PurchaseState newState = new PurchaseState();
        newState.setBookId(123);
        purchaseViewModel.setPurchaseState(newState);
        assertEquals(newState, purchaseViewModel.getPurchaseState());
    }

    @Test
    void testFirePropertyChange() {
        TestPropertyChangeListener listener = new TestPropertyChangeListener();
        purchaseViewModel.addPropertyChangeListener(listener);

        PurchaseState newState = new PurchaseState();
        newState.setBookId(123);
        purchaseViewModel.setPurchaseState(newState);
        purchaseViewModel.firePropertyChange();

        assertTrue(listener.propertyChangeCalled);
        assertEquals("state", listener.event.getPropertyName());
        assertEquals(newState, listener.event.getNewValue());
    }

    private static class TestPropertyChangeListener implements PropertyChangeListener {
        boolean propertyChangeCalled = false;
        PropertyChangeEvent event;

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            propertyChangeCalled = true;
            event = evt;
        }
    }
}
