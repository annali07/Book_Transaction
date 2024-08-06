package interface_adapter.purchase_book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.purchase_book.PurchaseInputData;
import use_case.purchase_book.PurchaseInputDataBoundary;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseControllorTest {

    private PurchaseControllor controller;
    private TestPurchaseInputDataBoundary purchaseUsecaseInteractor;

    @BeforeEach
    void setUp() {
        purchaseUsecaseInteractor = new TestPurchaseInputDataBoundary();
        controller = new PurchaseControllor(purchaseUsecaseInteractor);
    }

    @Test
    void testExecute() {
        int bookId = 123;
        controller.execute(bookId);
        assertNotNull(purchaseUsecaseInteractor.purchaseInputData);
        assertEquals(bookId, purchaseUsecaseInteractor.purchaseInputData.getBookId());
    }

    @Test
    void testCancel() {
        controller.cancel();
        assertTrue(purchaseUsecaseInteractor.cancelCalled);
    }

    // Test class for PurchaseInputDataBoundary

    private static class TestPurchaseInputDataBoundary implements PurchaseInputDataBoundary {
        PurchaseInputData purchaseInputData;
        boolean cancelCalled = false;

        @Override
        public void purchase(PurchaseInputData purchaseInputData) {
            this.purchaseInputData = purchaseInputData;
        }

        @Override
        public void cancel() {
            cancelCalled = true;
        }
    }
}
