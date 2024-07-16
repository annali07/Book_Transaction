package use_case.purchase_book;

public interface PurchaseInputDataBoundary {
    public void purchase(PurchaseInputData pd);
    public void cancel();
}
