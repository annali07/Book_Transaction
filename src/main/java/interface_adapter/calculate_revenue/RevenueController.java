package interface_adapter.calculate_revenue;

import use_case.calculate_revenue.RevenueData;
import use_case.calculate_revenue.RevenueDataBoundary;

import java.util.Date;

/**
 * The RevenueController class handles the user input for calculating revenue.
 * It interacts with the revenue data boundary to execute and cancel revenue calculations.
 *
 */
public class RevenueController {
    final private RevenueDataBoundary revenueDataBoundary;

    /**
     * Constructs a RevenueController object with the specified revenue data boundary.
     *
     * @param revenueDataBoundary the boundary interface for revenue data operations
     */
    public RevenueController(RevenueDataBoundary revenueDataBoundary) {
        this.revenueDataBoundary = revenueDataBoundary;
    }

    /**
     * Executes the revenue calculation with the specified parameters.
     *
     * @param startDate the start date for the revenue calculation
     * @param endDate the end date for the revenue calculation
     * @param Rental whether to include rental revenue
     * @param Purchase whether to include purchase revenue
     */
    public void execute(Date startDate, Date endDate,boolean Rental, boolean Purchase) {
        RevenueData revenueData = new RevenueData(startDate, endDate, Rental, Purchase);
        revenueDataBoundary.calculateRevenue(revenueData);
    }

    /**
     * Cancels the revenue calculation.
     */
    public void cancel() {
        revenueDataBoundary.cancel();

    }
}
