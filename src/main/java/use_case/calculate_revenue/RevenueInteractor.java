package use_case.calculate_revenue;

import data_access.database_rental_entry.DatabaseRentalEntryDataAccessInterface;
import data_access.database_rental_entry.DatabaseRentalEntryDataAccessObject;
import data_access.database_transaction_entry.DataTransactionEntryDataAccessObject;
import data_access.database_transaction_entry.DatabaseTransactionEntryDataAccessInterface;
import entity.purchase_entry.TransactionEntry;
import entity.rent_entry.RentalEntry;
import interface_adapter.calculate_revenue.RevenuePresenter;

import java.util.ArrayList;

public class RevenueInteractor implements RevenueDataBoundary {
    private RevenueOutputDataBoundary revenuePresenter;

    public RevenueInteractor(RevenueOutputDataBoundary revenuePresenter) {
        this.revenuePresenter = revenuePresenter;
    }
    @Override
    public void calculateRevenue(RevenueData revenueData) {
        double revenue = 0;

       if (revenueData.isRental()) {
           DatabaseRentalEntryDataAccessInterface databaseRentalEntryDataAccessInterface = new DatabaseRentalEntryDataAccessObject();
           ArrayList<RentalEntry> rentalEntries = databaseRentalEntryDataAccessInterface.getRentalEntryBetweenDate(revenueData.getStartDate(), revenueData.getEndDate());
           if (rentalEntries == null) {
               System.out.println("rentel entry is null");
           } else {
               for (RentalEntry rentalEntry : rentalEntries) {
                    revenue += rentalEntry.getCharge();
               }
           }
       }
       if (revenueData.isPurchase()) {
           DatabaseTransactionEntryDataAccessInterface databaseTransactionEntryDataAccessInterface = new DataTransactionEntryDataAccessObject();
           ArrayList<TransactionEntry> transactionEntries = databaseTransactionEntryDataAccessInterface.getTransactionEntriesBetweenDate(revenueData.getStartDate(), revenueData.getEndDate());
           if (transactionEntries == null) {
               revenuePresenter.prepareFailView("Error: transaction entry is null");
           } else {
               for (TransactionEntry transactionEntry : transactionEntries) {
                    revenue += transactionEntry.getSoldPrice();
               }
           }
       }

       revenuePresenter.prepareSuccessView("Revenue: " + revenue);
    }

    @Override
    public void cancel() {
        revenuePresenter.prepareCancelView();
    }
}