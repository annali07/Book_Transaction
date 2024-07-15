package use_case.calculate_revenue;

public interface RevenueOutputDataBoundary {
    public void prepareSuccessView(String displayString);

    public void prepareFailView(String error);

    public void prepareCancelView();
}
