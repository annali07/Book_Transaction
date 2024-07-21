import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.calculate_revenue.RevenueInteractor;
import use_case.calculate_revenue.RevenueInputData;
import use_case.calculate_revenue.RevenueOutputDataBoundary;
import data_access.database_rental_entry.DatabaseRentalEntryDataAccessInterface;
import data_access.database_transaction_entry.DatabaseTransactionEntryDataAccessInterface;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RevenueInteractorTest {

    private DatabaseRentalEntryDataAccessInterface rentalDataAccess;
    private DatabaseTransactionEntryDataAccessInterface transactionDataAccess;
    private RevenueOutputDataBoundary presenter;
    private RevenueInteractor interactor;

    @BeforeEach
    void setUp() {
        rentalDataAccess = mock(DatabaseRentalEntryDataAccessInterface.class);
        transactionDataAccess = mock(DatabaseTransactionEntryDataAccessInterface.class);
        presenter = mock(RevenueOutputDataBoundary.class);
        interactor = new RevenueInteractor(rentalDataAccess, transactionDataAccess, presenter);
    }

    @Test
    void testCalculateRevenueWithRentalAndPurchase() {
        Date startDate = new Date(2023 - 1900, 6, 1); // July 1, 2023
        Date endDate = new Date(2023 - 1900, 6, 31); // July 31, 2023
        RevenueInputData inputData = new RevenueInputData(startDate, endDate, true, true);

        when(transactionDataAccess.getPurchaseRevenueBetweenDate(startDate, endDate)).thenReturn(500.0);
        when(rentalDataAccess.getRentRevenueBetweenDate(startDate, endDate)).thenReturn(300.0);

        interactor.calculateRevenue(inputData);

        verify(presenter).prepareSuccessView("Revenue: 800.0");
    }

    @Test
    void testCalculateRevenueWithOnlyRental() {
        Date startDate = new Date(2023 - 1900, 6, 1); // July 1, 2023
        Date endDate = new Date(2023 - 1900, 6, 31); // July 31, 2023
        RevenueInputData inputData = new RevenueInputData(startDate, endDate, true, false);

        when(rentalDataAccess.getRentRevenueBetweenDate(startDate, endDate)).thenReturn(300.0);

        interactor.calculateRevenue(inputData);

        verify(presenter).prepareSuccessView("Revenue: 300.0");
    }

    @Test
    void testCalculateRevenueWithOnlyPurchase() {
        Date startDate = new Date(2023 - 1900, 6, 1); // July 1, 2023
        Date endDate = new Date(2023 - 1900, 6, 31); // July 31, 2023
        RevenueInputData inputData = new RevenueInputData(startDate, endDate, false, true);

        when(transactionDataAccess.getPurchaseRevenueBetweenDate(startDate, endDate)).thenReturn(500.0);

        interactor.calculateRevenue(inputData);

        verify(presenter).prepareSuccessView("Revenue: 500.0");
    }

    @Test
    void testCancel() {
        interactor.cancel();

        verify(presenter).prepareCancelView();
    }
}
