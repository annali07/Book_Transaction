package use_case.rent_book.BorrowBook;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.database_borrow_book.DatabaseBorrowInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Date;

class BorrowCommonBookInteractorTest {

    @Mock
    private BookRepositoryDataAccessInterface mockBookRepository;
    @Mock
    private DatabaseBorrowInterface mockUserGateway;
    @Mock
    private BorrowBookOutputBoundary mockPresenter;

    @InjectMocks
    private BorrowBookInteractor interactor;

    private BorrowBookInputData inputData;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Date startDate = new Date();
        Date endDate = new Date();
        inputData = new BorrowBookInputData(1, startDate, endDate, "John Doe", "1234567890");
    }

    @Test
    void testSuccessfulBorrow() {
        // Arrange
        when(mockBookRepository.findBook(inputData.getBookID())).thenReturn(true);
        when(mockBookRepository.updateBook(anyInt(), any(Date.class), any(Date.class), anyString(), anyString())).thenReturn(true);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockPresenter).prepareSuccessView(any(BorrowBookOutputData.class));
        verify(mockBookRepository).updateBook(anyInt(), any(Date.class), any(Date.class), anyString(), anyString());
    }

    @Test
    void testBookNotFound() {
        // Arrange
        when(mockBookRepository.findBook(inputData.getBookID())).thenReturn(false);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockPresenter, never()).prepareSuccessView(any(BorrowBookOutputData.class));
        verify(mockBookRepository, never()).updateBook(anyInt(), any(Date.class), any(Date.class), anyString(), anyString());
        System.out.println("Output: The book with bookID " + inputData.getBookID() + " is not found.");
    }

    @Test
    void testFailedBorrowUpdate() {
        // Arrange
        when(mockBookRepository.findBook(inputData.getBookID())).thenReturn(true);
        when(mockBookRepository.updateBook(anyInt(), any(Date.class), any(Date.class), anyString(), anyString())).thenReturn(false);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockPresenter, never()).prepareSuccessView(any(BorrowBookOutputData.class));
        System.out.println("Output: The book with bookID " + inputData.getBookID() + " could not be borrowed.");
    }

    @Test
    void testCancelBorrowing() {
        // Act
        interactor.cancel();

        // Assert
        verify(mockPresenter).prepareCancelView();
    }
}
