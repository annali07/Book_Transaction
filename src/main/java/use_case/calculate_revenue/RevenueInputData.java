package use_case.calculate_revenue;

import java.util.Date;

public class RevenueInputData {
    /*
    Represents the data needed to calculate revenue for a given time period.
     */
    private Date startDate;
    private Date endDate;
    private boolean rental;
    private boolean purchase;

    /**
     * Constructs a RevenueInputData object with the specified start date, end date, rental status, and purchase status.
     *
     * @param startDate the start date of the revenue period
     * @param endDate the end date of the revenue period
     * @param rental whether the revenue includes rentals
     * @param purchase whether the revenue includes purchases
     */
    public RevenueInputData (Date startDate,Date endDate,boolean rental,boolean purchase){
        this.startDate = startDate;
        this.endDate = endDate;
        this.rental = rental;
        this.purchase = purchase;

    }

    /**
     * Gets the start date of the revenue period.
     *
     * @return the start date
     */
    public Date getStartDate() {return startDate;}

    /**
     * Gets the end date of the revenue period.
     *
     * @return the end date
     */
    public Date getEndDate() {return endDate;}

    /**
     * Checks if the revenue includes rentals.
     *
     * @return true if the revenue includes rentals, false otherwise
     */
    public boolean isRental() {return rental;}

    /**
     * Checks if the revenue includes purchases.
     *
     * @return true if the revenue includes purchases, false otherwise
     */
    public boolean isPurchase() {return purchase;}
}
