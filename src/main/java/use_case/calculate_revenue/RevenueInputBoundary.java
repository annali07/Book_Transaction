package use_case.calculate_revenue;

public interface RevenueInputBoundary {
    public void calculateRevenue(RevenueInputData revenueInputData);
    public void cancel();
}
