package use_case.rent_book.ReturnBook;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.data_base_return_book.DatabaseReturnInterface;
import entity.rent_entry.RentalEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Date;

class ReturnBookInteractorTest {

    @Mock
    private BookRepositoryDataAccessInterface mockBookRepository;
    @Mock
    private DatabaseReturnInterface mockUserGateway;
    @Mock
    private ReturnBookOutputBoundary mockPresenter;

    @InjectMocks
    private ReturnBookInteractor interactor;

    private ReturnBookInputData inputData;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        inputData = new ReturnBookInputData(123, new Date(), new Date(), new Date());
    }

    @Test
    void testBookNotFound() {
        // Arrange
        when(mockBookRepository.findBook(inputData.getBookID())).thenReturn(false);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockPresenter, never()).prepareSuccessView(any(ReturnBookOutputData.class));
        verify(mockUserGateway, never()).writeReturnFile(any(RentalEntry.class));
        System.out.println("Output: The bookID is invalid");
    }

    @Test
    void testBookReturnedSuccessfully() {
        // Arrange
        when(mockBookRepository.findBook(inputData.getBookID())).thenReturn(true);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockUserGateway).writeReturnFile(any(RentalEntry.class));
        verify(mockPresenter).prepareSuccessView(any(ReturnBookOutputData.class));
        System.out.println("Output: The book has been returned.");
    }

    @Test
    void testCancelReturnBook() {
        // Act
        interactor.cancel();

        // Assert
        verify(mockPresenter).prepareCancelView();
    }
}
