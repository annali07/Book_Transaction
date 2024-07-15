package interface_adapter.purchase_book;

import use_case.purchase_book.PurchaseInputData;
import use_case.purchase_book.PurchaseInputDataBoundary;

public class PurchaseControllor {
    final PurchaseInputDataBoundary purchaseInputDataBoundary;


    /*
    * Constructs a purchaseControllor with spcified use case*/
    public PurchaseControllor(PurchaseInputDataBoundary purchaseInputDataBoundary) {
        this.purchaseInputDataBoundary = purchaseInputDataBoundary;
    }

    /**/
    public void execute(int bookid) {
        PurchaseInputData purchaseInputData = new PurchaseInputData(bookid);
        purchaseInputDataBoundary.purchase(purchaseInputData);
    }

    public void cancel() {
        purchaseInputDataBoundary.cancel();
    }
}
