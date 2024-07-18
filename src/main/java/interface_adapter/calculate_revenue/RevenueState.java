package interface_adapter.calculate_revenue;

/**
 * The RevenueState class represents the state of the revenue calculation.
 * It includes the start and end dates for the revenue calculation.
 *
 */
public class RevenueState {
    private String startDate;
    private String endDate;

    /**
     * Constructs a RevenueState object with the specified start and end dates.
     *
     * @param startDate the start date for the revenue calculation
     * @param endDate the end date for the revenue calculation
     */
    public RevenueState(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Constructs a RevenueState object with empty start and end dates.
     */
    public RevenueState() {
        this.startDate = "";
        this.endDate = "";
    }

    /**
     * Gets the start date string.
     *
     * @return the start date string
     */
    public String getStartDateString() {
        return startDate;
    }

    /**
     * Gets the end date string.
     *
     * @return the end date string
     */
    public String getEndDateString() {
        return endDate;
    }

    /**
     * Sets the start date string.
     *
     * @param startDate the start date string to set
     */
    public void setStartDateString(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Sets the end date string.
     *
     * @param endDate the end date string to set
     */
    public void setEndDateString(String endDate) {
        this.endDate = endDate;
    }

}
