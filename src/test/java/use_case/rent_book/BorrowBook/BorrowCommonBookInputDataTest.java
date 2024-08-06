package use_case.rent_book.BorrowBook;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class BorrowCommonBookInputDataTest {

    @Test
    void testGetBookID() {
        int bookID = 123;
        Date startDate = new Date();
        Date endDate = new Date();
        String borrowerName = "John Doe";
        String borrowerNumber = "1234567890";

        BorrowBookInputData inputData = new BorrowBookInputData(bookID, startDate, endDate, borrowerName, borrowerNumber);

        assertEquals(bookID, inputData.getBookID());
    }

    @Test
    void testGetBorrowerName() {
        int bookID = 123;
        Date startDate = new Date();
        Date endDate = new Date();
        String borrowerName = "John Doe";
        String borrowerNumber = "1234567890";

        BorrowBookInputData inputData = new BorrowBookInputData(bookID, startDate, endDate, borrowerName, borrowerNumber);

        assertEquals(borrowerName, inputData.getBorrowerName());
    }

    @Test
    void testGetEndDate() {
        int bookID = 123;
        Date startDate = new Date();
        Date endDate = new Date();
        String borrowerName = "John Doe";
        String borrowerNumber = "1234567890";

        BorrowBookInputData inputData = new BorrowBookInputData(bookID, startDate, endDate, borrowerName, borrowerNumber);

        assertEquals(endDate, inputData.getEndDate());
    }

    @Test
    void testGetStartDate() {
        int bookID = 123;
        Date startDate = new Date();
        Date endDate = new Date();
        String borrowerName = "John Doe";
        String borrowerNumber = "1234567890";

        BorrowBookInputData inputData = new BorrowBookInputData(bookID, startDate, endDate, borrowerName, borrowerNumber);

        assertEquals(startDate, inputData.getStartDate());
    }

    @Test
    void testGetBorrowerNumber() {
        int bookID = 123;
        Date startDate = new Date();
        Date endDate = new Date();
        String borrowerName = "John Doe";
        String borrowerNumber = "1234567890";

        BorrowBookInputData inputData = new BorrowBookInputData(bookID, startDate, endDate, borrowerName, borrowerNumber);

        assertEquals(borrowerNumber, inputData.getBorrowerNumber());
    }
}
