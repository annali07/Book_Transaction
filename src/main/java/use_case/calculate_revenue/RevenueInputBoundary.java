package use_case.calculate_revenue;

/**
 * The RevenueInputBoundary interface provides methods for calculating and canceling revenue calculations.
 * It serves as an input boundary for use cases related to revenue calculation.
 */
public interface RevenueInputBoundary {

    /**
     * Initiates the revenue calculation process.
     *
     * @param revenueInputData the input data required for revenue calculation
     */
    public void calculateRevenue(RevenueInputData revenueInputData);

    /**
     * Cancels the revenue calculation process.
     */
    public void cancel();
}
