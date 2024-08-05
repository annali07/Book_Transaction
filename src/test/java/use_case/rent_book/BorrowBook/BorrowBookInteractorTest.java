package use_case.rent_book.BorrowBook;

import data_access.add_book_repository.BookRepositoryDataAccessObject;
import data_access.database_borrow_book.DatabaseBorrowInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BorrowBookInteractorTest {

    private DatabaseBorrowInterface mockDatabase;
    private BorrowBookOutputBoundary mockPresenter;
    private BorrowBookInteractor interactor;
    private BookRepositoryDataAccessObject mockBookRepository;

    @BeforeEach
    void setUp() {
        mockDatabase = mock(DatabaseBorrowInterface.class);
        mockPresenter = mock(BorrowBookOutputBoundary.class);
        interactor = new BorrowBookInteractor(mockBookRepository, mockDatabase, mockPresenter);
    }

    @Test
    void testExecute() {
        // Arrange
        int bookID = 1;
        Date startDate = new Date(2023, 4, 12);
        Date endDate = new Date(2023, 5, 12);
        String borrowerName = "John Doe";
        String borrowerNumber = "1234567890";
        BorrowBookInputData inputData = new BorrowBookInputData(bookID, startDate, endDate, borrowerName, borrowerNumber);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockDatabase).writeBorrowFile(bookID, startDate, endDate, borrowerName, borrowerNumber);

        ArgumentCaptor<BorrowBookOutputData> captor = ArgumentCaptor.forClass(BorrowBookOutputData.class);
        verify(mockPresenter).prepareSuccessView(captor.capture());

        BorrowBookOutputData outputData = captor.getValue();
        assertEquals(bookID, outputData.getBookID());
        assertEquals(startDate, outputData.getStartDate());
        assertEquals(endDate, outputData.getEndDate());
        assertEquals(borrowerName, outputData.getBorrowerName());
        assertEquals(borrowerNumber, outputData.getBorrowerNumber());
    }

    @Test
    void testCancel() {
        // Act
        interactor.cancel();

        // Assert
        verify(mockPresenter).prepareCancelView();
    }
}
