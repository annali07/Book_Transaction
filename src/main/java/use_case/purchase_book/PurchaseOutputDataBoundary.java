package use_case.purchase_book;

public interface PurchaseOutputDataBoundary {
//    void prepareSuccessView(PurchaseOutputData purchaseOutputData);
//    void prepareErrorView(PurchaseOutputData purchaseOutputData);
    void prepareCancelView();
    void prepareFailView();
    void prepareSuccessView();
}
