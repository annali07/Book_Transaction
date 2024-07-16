package use_case.purchase_book;

public interface PurchaseInputDataBoundary {
    void purchase(PurchaseInputData purchaseInputData);
    void cancel();
}
