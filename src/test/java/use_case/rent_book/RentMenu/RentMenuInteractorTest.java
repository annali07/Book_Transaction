package use_case.rent_book.RentMenu;

import data_access.database_rental_entry.DatabaseRentalEntryDataAccessInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RentMenuInteractorTest {

    private DatabaseRentalEntryDataAccessInterface userGateway;
    private RentMenuOutputBoundary presenter;
    private RentMenuInteractor interactor;

    @BeforeEach
    void setUp() {
        userGateway = mock(DatabaseRentalEntryDataAccessInterface.class);
        presenter = mock(RentMenuOutputBoundary.class);
        interactor = new RentMenuInteractor(userGateway, presenter);
    }

    @Test
    void testExecuteSuccess() {
        int bookID = 1;
        RentMenuInputData inputData = new RentMenuInputData(bookID);

        when(userGateway.validatebook(bookID)).thenReturn(true);

        boolean result = interactor.execute(inputData);

        assertTrue(result);
        verify(presenter).prepareSuccessView(any(RentMenuOutputData.class));
    }

    @Test
    void testExecuteFail() {
        int bookID = 1;
        RentMenuInputData inputData = new RentMenuInputData(bookID);

        when(userGateway.validatebook(bookID)).thenReturn(false);

        boolean result = interactor.execute(inputData);

        assertFalse(result);
        verify(presenter).prepareFailView("cannot find the book");
    }

    @Test
    void testCancel() {
        interactor.cancel();

        verify(presenter).prepareCancelView();
    }
}
