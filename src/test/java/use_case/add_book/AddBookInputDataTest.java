package use_case.add_book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddBookInputDataTest {

    private AddBookInputData addBookInputData;
    private final String isbn = "0394558782";
    private final double price = 29.99;

    @BeforeEach
    void setUp() {
        addBookInputData = new AddBookInputData(isbn, price);
    }

    @Test
    void getIsbn() {
        assertEquals(isbn, addBookInputData.getIsbn());
    }

    @Test
    void getPrice() {
        assertEquals(price, addBookInputData.getPrice());
    }
}
