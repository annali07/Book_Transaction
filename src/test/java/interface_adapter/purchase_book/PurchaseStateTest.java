package interface_adapter.purchase_book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseStateTest {

    private PurchaseState purchaseState;

    @BeforeEach
    void setUp() {
        purchaseState = new PurchaseState();
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(purchaseState);
        assertEquals(0, purchaseState.getBookId());
    }

    @Test
    void testCopyConstructor() {
        purchaseState.setBookId(123);
        PurchaseState copiedState = new PurchaseState(purchaseState);

        assertEquals(123, copiedState.getBookId());
    }

    @Test
    void testSetAndGetBookId() {
        purchaseState.setBookId(456);
        assertEquals(456, purchaseState.getBookId());
    }
}
