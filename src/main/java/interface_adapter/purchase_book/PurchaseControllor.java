package interface_adapter.purchase_book;

import use_case.purchase_book.PurchaseInputData;
import use_case.purchase_book.PurchaseInputDataBoundary;

/**
 * PurchaseControllor class is responsible for handling user interactions for book purchases.
 * It acts as an intermediary between the user interface and the purchase use case.
 *
 * @version 1.0
 */
public class PurchaseControllor {
    final PurchaseInputDataBoundary addBookUsecaseInteractor;

    /**
     * Constructs a PurchaseControllor object.
     *
     * @param purchaseUsecaseInteractor the PurchaseInputDataBoundary object that handles the business logic for purchasing books
     */
    public PurchaseControllor(PurchaseInputDataBoundary purchaseUsecaseInteractor) {
        this.addBookUsecaseInteractor = purchaseUsecaseInteractor;
    }

    /**
     * Processes a purchase request by creating a PurchaseInputData object and passing it to the purchase use case interactor.
     *
     * @param bookid the ID of the book to be purchased
     */
    public void execute(int bookid) {
        PurchaseInputData purchaseInputData = new PurchaseInputData();
        addBookUsecaseInteractor.purchase(purchaseInputData);
    }

    /**
     * Process the cancel request
     */
    public void cancel() {
        addBookUsecaseInteractor.cancel();
    }
}
