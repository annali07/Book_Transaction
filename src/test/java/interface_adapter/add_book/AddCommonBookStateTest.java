package interface_adapter.add_book;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddCommonBookStateTest {

    private AddBookState addBookState;
    private AddBookState copiedAddBookState;
    private final String isbn = "1234567890";
    private final int price = 29;

    @BeforeEach
    void setUp() {
        addBookState = new AddBookState();
        addBookState.setISBN(isbn);
        addBookState.setPrice(price);
        copiedAddBookState = new AddBookState(addBookState);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setISBN() {
        addBookState.setISBN(isbn);
        assertEquals(isbn, addBookState.getISBN());
    }

    @Test
    void setPrice() {
        addBookState.setPrice(price);
        assertEquals(price, addBookState.getPrice());
    }

    @Test
    void getISBN() {
        addBookState.setISBN(isbn);
        assertEquals(isbn, addBookState.getISBN());
    }

    @Test
    void getPrice() {
        addBookState.setPrice(price);
        assertEquals(price, addBookState.getPrice());
    }

    @Test
    void copyConstructor() {
        assertEquals(isbn, copiedAddBookState.getISBN());
        assertEquals(price, copiedAddBookState.getPrice());
    }
}