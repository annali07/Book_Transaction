package use_case.calculate_revenue;

import data_access.database_rental_entry.DatabaseRentalEntryDataAccessInterface;
import data_access.database_transaction_entry.DatabaseTransactionEntryDataAccessInterface;

import java.util.Date;

/**
 * The RevenueInteractor class implements the RevenueInputBoundary interface and handles the business logic for calculating revenue.
 *
 */
public class RevenueInteractor implements RevenueInputBoundary {

    private final DatabaseTransactionEntryDataAccessInterface databaseTransactionEntryDataAccessObject;
    private final DatabaseRentalEntryDataAccessInterface databaseRentalEntryDataAccessObject;
    private final RevenueOutputDataBoundary revenuePresenter;

    /**
     * Constructs a RevenueInteractor object with the specified revenue presenter.
     *
     * @param revenuePresenter the RevenueOutputDataBoundary object that handles the presentation of revenue data
     */
    public RevenueInteractor(DatabaseRentalEntryDataAccessInterface databaseRentalEntryDataAccessObject, DatabaseTransactionEntryDataAccessInterface databaseTransactionEntryDataAccessObject, RevenueOutputDataBoundary revenuePresenter) {
        this.databaseRentalEntryDataAccessObject = databaseRentalEntryDataAccessObject;
        this.databaseTransactionEntryDataAccessObject = databaseTransactionEntryDataAccessObject;
        this.revenuePresenter = revenuePresenter;
    }

    /**
     * Calculates the revenue based on the provided RevenueInputData.
     * It sums up the charges from rental entries and sold prices from transaction entries within the specified date range.
     *
     * @param revenueData the RevenueData object containing the start date, end date, and flags for rental and purchase inclusion
     */
    @Override
    public void calculateRevenue(RevenueInputData revenueData) {
        Date startDate = revenueData.getStartDate();
        Date endDate = revenueData.getEndDate();

        double revenue = 0;
        double purchaseRevenue = 0;
        double rentRevenue = 0;

        // Calculate From Purchase
        purchaseRevenue = databaseTransactionEntryDataAccessObject.getPurchaseRevenueBetweenDate(startDate, endDate);

        // Calculate From Rent
        rentRevenue = databaseRentalEntryDataAccessObject.getRentRevenueBetweenDate(startDate, endDate);

        if (revenueData.isRental()) {
            revenue += rentRevenue;
        }
        if (revenueData.isPurchase()) {
            revenue += purchaseRevenue;
        }
        System.out.println(revenue);
       revenuePresenter.prepareSuccessView("Revenue: " + revenue);
    }

    /**
     * Cancels the revenue calculation process and invokes the presenter's cancel view.
     */
    @Override
    public void cancel() {
        revenuePresenter.prepareCancelView();
    }
}