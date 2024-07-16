package use_case.calculate_revenue;

import java.util.Date;

public class RevenueData {
    /*
    Represents the data needed to calculate revenue for a given time period.
     */
    private Date startDate;
    private Date endDate;
    private boolean rental;
    private boolean purchase;

    public RevenueData (Date startDate,Date endDate,boolean rental,boolean purchase){
        this.startDate = startDate;
        this.endDate = endDate;
        this.rental = rental;
        this.purchase = purchase;

    }
    public Date getStartDate() {return startDate;}
    public Date getEndDate() {return endDate;}
    public boolean isRental() {return rental;}
    public boolean isPurchase() {return purchase;}
}
