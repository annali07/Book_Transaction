package use_case.calculate_revenue;

/**
 * The RevenueOutputDataBoundary interface provides methods for preparing different views based on the outcome of the revenue calculation process.
 * It serves as an output boundary for use cases related to revenue calculation.
 */
public interface RevenueOutputDataBoundary {

    /**
     * Prepares the view to be displayed when the revenue calculation is successful.
     *
     * @param displayString the string to be displayed upon successful revenue calculation
     */
    public void prepareSuccessView(String displayString);

    /**
     * Prepares the view to be displayed when the revenue calculation fails.
     *
     * @param error the error message to be displayed upon failed revenue calculation
     */
    public void prepareFailView(String error);

    /**
     * Prepares the view to be displayed when the revenue calculation process is canceled.
     */
    public void prepareCancelView();
}
