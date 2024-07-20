package use_case.purchase_book;

public interface PurchaseOutputDataBoundary {
    void prepareCancelView();
    void prepareFailView();
    void prepareSuccessView();
}
