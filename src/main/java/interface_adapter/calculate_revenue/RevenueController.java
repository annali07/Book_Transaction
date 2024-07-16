package interface_adapter.calculate_revenue;

import use_case.calculate_revenue.RevenueData;
import use_case.calculate_revenue.RevenueDataBoundary;

import java.util.Date;

public class RevenueController {
    final private RevenueDataBoundary revenueDataBoundary;

    public RevenueController(RevenueDataBoundary revenueDataBoundary) {
        this.revenueDataBoundary = revenueDataBoundary;
    }

    public void execute(Date startDate, Date endDate,boolean Rental, boolean Purchase) {
        RevenueData revenueData = new RevenueData(startDate, endDate, Rental, Purchase);
        revenueDataBoundary.calculateRevenue(revenueData);
    }
    public void cancel() {
        revenueDataBoundary.cancel();

    }
}
