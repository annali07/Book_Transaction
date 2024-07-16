package interface_adapter.purchase_book;

import use_case.purchase_book.PurchaseInputData;
import use_case.purchase_book.PurchaseInputDataBoundary;

public class PurchaseControllor {
    final PurchaseInputDataBoundary addBookUsecaseInteractor;

    /*
    * Constructs a purchaseControllor with spcified use case
    */
    public PurchaseControllor(PurchaseInputDataBoundary purchaseUsecaseInteractor) {
        this.addBookUsecaseInteractor = purchaseUsecaseInteractor;
    }

    /**/
    public void execute(int bookid) {
        PurchaseInputData purchaseInputData = new PurchaseInputData(bookid);
        addBookUsecaseInteractor.purchase(purchaseInputData);
    }

    public void cancel() {
        addBookUsecaseInteractor.cancel();
    }
}
