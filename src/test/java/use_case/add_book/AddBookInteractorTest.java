//package use_case.add_book;
//
//import data_access.add_book_repository.BookRepositoryDataAccessInterface;
//import data_access.api.ExternalBookApiInterface;
//import entity.api.ApiResponse;
//import entity.book.Book;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class AddBookInteractorTest {
//
//    private BookRepositoryDataAccessInterface bookRepositoryDataAccessObject;
//    private ExternalBookApiInterface externalBookApi;
//    private AddBookOutputBoundary presenter;
//    private AddBookInteractor addBookInteractor;
//
//    @BeforeEach
//    void setUp() {
//        bookRepositoryDataAccessObject = mock(BookRepositoryDataAccessInterface.class);
//        externalBookApi = mock(ExternalBookApiInterface.class);
//        presenter = mock(AddBookOutputBoundary.class);
//
//        addBookInteractor = new AddBookInteractor(bookRepositoryDataAccessObject, externalBookApi, presenter);
//    }
//
//    @Test
//    void addBook() {
//        String isbn = "0394558782";
//        String bookName = "Test Book";
//        double price = 29.99;
//
//        AddBookInputData addBookInputData = new AddBookInputData(isbn, price);
//        ApiResponse apiResponse = new ApiResponse(bookName, "Some Author");
//        when(externalBookApi.fetchBookDetails(isbn)).thenReturn(apiResponse);
//        when(bookRepositoryDataAccessObject.saveBook(any(Book.class))).thenReturn(true);
//
//        addBookInteractor.addBook(addBookInputData);
//
//        ArgumentCaptor<Book> bookCaptor = ArgumentCaptor.forClass(Book.class);
//        verify(bookRepositoryDataAccessObject).saveBook(bookCaptor.capture());
//        assertEquals(bookName, bookCaptor.getValue().getBookName());
//        assertEquals(price, bookCaptor.getValue().getBookPrice());
//
//        verify(presenter).prepareSuccessView();
//        verify(presenter, never()).prepareFailView(anyString());
//    }
//
//    @Test
//    void addBookFailure() {
//        String isbn = "0394558782";
//        String bookName = "Test Book";
//        double price = 29.99;
//
//        AddBookInputData addBookInputData = new AddBookInputData(isbn, price);
//        ApiResponse apiResponse = new ApiResponse(bookName, "Some Author");
//        when(externalBookApi.fetchBookDetails(isbn)).thenReturn(apiResponse);
//        when(bookRepositoryDataAccessObject.saveBook(any(Book.class))).thenReturn(false);
//
//        addBookInteractor.addBook(addBookInputData);
//        verify(presenter).prepareFailView("Failed to save to DB");
//    }
//
//    @Test
//    void cancel() {
//        addBookInteractor.cancel();
//        verify(presenter).prepareCancelView();
//    }
//}
