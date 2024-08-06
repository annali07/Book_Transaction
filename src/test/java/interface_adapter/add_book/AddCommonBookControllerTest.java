package interface_adapter.add_book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.add_book.AddBookInputBoundary;
import use_case.add_book.AddBookInputData;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AddCommonBookControllerTest {
    private AddBookInputBoundary addBookUsecaseInteractor;
    private AddBookController addBookController;

    @BeforeEach
    void setUp() {
        addBookUsecaseInteractor = mock(AddBookInputBoundary.class);
        addBookController = new AddBookController(addBookUsecaseInteractor);
    }

    @Test
    void execute() {
        String isbn = "0394558782";
        double price = 29.99;

        addBookController.execute(isbn, price);

        verify(addBookUsecaseInteractor).addBook(any(AddBookInputData.class));
    }

    @Test
    void cancel() {
        addBookController.cancel();
        verify(addBookUsecaseInteractor).cancel();
    }
}