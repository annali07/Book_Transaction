package use_case.rent_book.RentMenu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.rent_book.RentMenu.RentMenuInputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentMenuInputDataTest {

    private RentMenuInputData inputData;
    private final int bookID = 1;

    @BeforeEach
    void setUp() {
        inputData = new RentMenuInputData(bookID);
    }

    @Test
    void testGetBookID() {
        assertEquals(bookID, inputData.getBookID());
    }
}
