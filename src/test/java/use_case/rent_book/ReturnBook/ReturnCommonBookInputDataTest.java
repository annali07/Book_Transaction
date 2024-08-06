package use_case.rent_book.ReturnBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.rent_book.ReturnBook.ReturnBookInputData;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnCommonBookInputDataTest {

    private ReturnBookInputData inputData;
    private final int bookID = 123;
    private final Date returnDate = new Date(2023, 4, 15);
    private final Date endDate = new Date(2023, 4, 10);
    private final Date startDate = new Date(2023, 3, 10);

    @BeforeEach
    void setUp() {
        inputData = new ReturnBookInputData(bookID, returnDate, endDate, startDate);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(bookID, inputData.getBookID());
        assertEquals(returnDate, inputData.getReturnDate());
        assertEquals(endDate, inputData.getEndDate());
        assertEquals(startDate, inputData.getStartDate());
    }

    @Test
    void testSetBookID() {
        inputData.setBookID(456);
        assertEquals(456, inputData.getBookID());
    }

    @Test
    void testSetReturnDate() {
        Date newReturnDate = new Date(2023, 5, 20);
        inputData.setReturnDate(newReturnDate);
        assertEquals(newReturnDate, inputData.getReturnDate());
    }

    @Test
    void testSetEndDate() {
        Date newEndDate = new Date(2023, 5, 10);
        inputData.setEndDate(newEndDate);
        assertEquals(newEndDate, inputData.getEndDate());
    }

    @Test
    void testSetStartDate() {
        Date newStartDate = new Date(2023, 4, 20);
        inputData.setStartDate(newStartDate);
        assertEquals(newStartDate, inputData.getStartDate());
    }
}
