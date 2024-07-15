package use_case.calculate_revenue;

public interface RevenueDataBoundary  {
    public void calculateRevenue(RevenueData revenueData);
    public void cancel();
}
