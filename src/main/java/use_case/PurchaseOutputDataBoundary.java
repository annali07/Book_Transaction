package use_case;

public interface PurchaseOutputDataBoundary {
    void prepareSuccessView(PurchaseOutputData purchaseOutputData);
    void prepareErrorView(PurchaseOutputData purchaseOutputData);

}
