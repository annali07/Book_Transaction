//package use_case.rent_book.ReturnBook;
//
//import data_access.data_base_return_book.DatabaseReturnInterface;
//import entity.rent_entry.RentalEntry;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class ReturnBookInteractorTest {
//
//    private DatabaseReturnInterface mockUserGateway;
//    private ReturnBookOutputBoundary mockPresenter;
//    private ReturnBookInteractor interactor;
//
//    @BeforeEach
//    void setUp() {
//        mockUserGateway = mock(DatabaseReturnInterface.class);
//        mockPresenter = mock(ReturnBookOutputBoundary.class);
//        interactor = new ReturnBookInteractor(mockUserGateway, mockPresenter);
//    }
//
//    @Test
//    void testExecute() {
//        int bookID = 123;
//        Date startDate = new Date(2023, 3, 10);
//        Date endDate = new Date(2023, 4, 10);
//        Date returnDate = new Date(2023, 4, 15);
//        ReturnBookInputData inputData = new ReturnBookInputData(bookID, returnDate, endDate, startDate);
//
//        interactor.execute(inputData);
//
//        // Verify interactions with userGateway
//        verify(mockUserGateway).editBookFile(bookID);
//
//        ArgumentCaptor<RentalEntry> rentalEntryCaptor = ArgumentCaptor.forClass(RentalEntry.class);
//        verify(mockUserGateway).writeReturnFile(rentalEntryCaptor.capture());
//
//        RentalEntry rentalEntry = rentalEntryCaptor.getValue();
//        assertEquals(bookID, rentalEntry.getBookID());
//        assertEquals(startDate, rentalEntry.getStartDate());
//        assertEquals(endDate, rentalEntry.getEndDate());
//        assertEquals(returnDate, rentalEntry.getReturnDate());
//
//        // Verify interaction with presenter
//        ArgumentCaptor<ReturnBookOutputData> outputDataCaptor = ArgumentCaptor.forClass(ReturnBookOutputData.class);
//        verify(mockPresenter).prepareSuccessView(outputDataCaptor.capture());
//
//        ReturnBookOutputData outputData = outputDataCaptor.getValue();
//        assertEquals(bookID, outputData.getBookID());
//        // Add any additional assertions for charge if necessary
//    }
//
//    @Test
//    void testCancel() {
//        interactor.cancel();
//
//        // Verify interaction with presenter
//        verify(mockPresenter).prepareCancelView();
//    }
//}
