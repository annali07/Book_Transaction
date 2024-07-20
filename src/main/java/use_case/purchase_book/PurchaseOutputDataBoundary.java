package use_case.purchase_book;

public interface PurchaseOutputDataBoundary {
    int prepareCancelView();
    int prepareFailView();
    int prepareSuccessView();
}
