package use_case.rent_book.BorrowBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.rent_book.BorrowBook.BorrowBookOutputData;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BorrowBookOutputDataTest {

    private BorrowBookOutputData outputData;
    private final int bookID = 1;
    private final Date startDate = new Date(2023, 4, 12);
    private final Date endDate = new Date(2023, 5, 12);
    private final String borrowerName = "John Doe";
    private final String borrowerNumber = "1234567890";

    @BeforeEach
    void setUp() {
        outputData = new BorrowBookOutputData(bookID, startDate, endDate, borrowerName, borrowerNumber);
    }

    @Test
    void testGetBookID() {
        assertEquals(bookID, outputData.getBookID());
    }

    @Test
    void testGetStartDate() {
        assertEquals(startDate, outputData.getStartDate());
    }

    @Test
    void testGetEndDate() {
        assertEquals(endDate, outputData.getEndDate());
    }

    @Test
    void testGetBorrowerName() {
        assertEquals(borrowerName, outputData.getBorrowerName());
    }

    @Test
    void testGetBorrowerNumber() {
        assertEquals(borrowerNumber, outputData.getBorrowerNumber());
    }

    @Test
    void testDefaultButton() {
        assertEquals("none", outputData.defaultButton());
    }
}
