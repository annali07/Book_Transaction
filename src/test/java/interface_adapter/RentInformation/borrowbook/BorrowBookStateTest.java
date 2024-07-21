package interface_adapter.RentInformation.borrowbook;

import interface_adapter.RentInformation.borrowbook.BorrowBookState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class BorrowBookStateTest {

    private BorrowBookState borrowBookState;

    @BeforeEach
    void setUp() {
        borrowBookState = new BorrowBookState();
    }

    @Test
    void testBookID() {
        int bookID = 123;
        borrowBookState.setBookID(bookID);
        assertEquals(bookID, borrowBookState.getBookID());
    }

    @Test
    void testBookIDError() {
        int bookIDError = 1;
        borrowBookState.setBookIDError(bookIDError);
        assertEquals(bookIDError, borrowBookState.getBookIDError());
    }

    @Test
    void testRentStartDate() {
        Date startDate = new Date();
        borrowBookState.setRentStartDate(startDate);
        assertEquals(startDate, borrowBookState.getRentStartDate());
    }

    @Test
    void testRentStartDateError() {
        Date startDateError = new Date();
        borrowBookState.setRentStartDateError(startDateError);
        assertEquals(startDateError, borrowBookState.getRentStartDateError());
    }

    @Test
    void testRentEndDate() {
        Date endDate = new Date();
        borrowBookState.setRentEndDate(endDate);
        assertEquals(endDate, borrowBookState.getRentEndDate());
    }

    @Test
    void testRentEndDateError() {
        Date endDateError = new Date();
        borrowBookState.setRentEndDateError(endDateError);
        assertEquals(endDateError, borrowBookState.getRentEndDateError());
    }

    @Test
    void testBorrowerName() {
        String borrowerName = "John Doe";
        borrowBookState.setBorrowerName(borrowerName);
        assertEquals(borrowerName, borrowBookState.getBorrowerName());
    }

    @Test
    void testBorrowerNumber() {
        String borrowerNumber = "1234567890";
        borrowBookState.setBorrowerNumber(borrowerNumber);
        assertEquals(borrowerNumber, borrowBookState.getBorrowerNumber());
    }

    @Test
    void testBorrowerNameError() {
        String borrowerNameError = "Name Error";
        borrowBookState.setBorrowerNameError(borrowerNameError);
        assertEquals(borrowerNameError, borrowBookState.getBorrowerNameError());
    }

    @Test
    void testBorrowerNumberError() {
        String borrowerNumberError = "Number Error";
        borrowBookState.setBorrowerNumberError(borrowerNumberError);
        assertEquals(borrowerNumberError, borrowBookState.getBorrowerNumberError());
    }

    @Test
    void testBookName() {
        String bookName = "Book Title";
        borrowBookState.setBookName(bookName);
        assertEquals(bookName, borrowBookState.getBookName());
    }

    @Test
    void testBookNameError() {
        String bookNameError = "Book Name Error";
        borrowBookState.setBookNameError(bookNameError);
        assertEquals(bookNameError, borrowBookState.getBookNameError());
    }

    @Test
    void testCopyConstructor() {
        // Initialize the state with some values
        BorrowBookState original = new BorrowBookState();
        original.setBookID(123);
        original.setBookIDError(1);
        original.setRentStartDate(new Date());
        original.setRentStartDateError(new Date());
        original.setRentEndDate(new Date());
        original.setRentEndDateError(new Date());
        original.setBorrowerName("John Doe");
        original.setBorrowerNameError("Name Error");
        original.setBorrowerNumber("1234567890");
        original.setBorrowerNumberError("Number Error");
        original.setBookName("Book Title");
        original.setBookNameError("Book Name Error");

        // Create a copy using the copy constructor
        BorrowBookState copy = new BorrowBookState(original);

        // Verify that the copy has the same values as the original
        assertEquals(original.getBookID(), copy.getBookID());
        assertEquals(original.getBookIDError(), copy.getBookIDError());
        assertEquals(original.getRentStartDate(), copy.getRentStartDate());
        assertEquals(original.getRentStartDateError(), copy.getRentStartDateError());
        assertEquals(original.getRentEndDate(), copy.getRentEndDate());
        assertEquals(original.getRentEndDateError(), copy.getRentEndDateError());
        assertEquals(original.getBorrowerName(), copy.getBorrowerName());
        assertEquals(original.getBorrowerNameError(), copy.getBorrowerNameError());
        assertEquals(original.getBorrowerNumber(), copy.getBorrowerNumber());
        assertEquals(original.getBorrowerNumberError(), copy.getBorrowerNumberError());
        assertEquals(original.getBookName(), copy.getBookName());
        assertEquals(original.getBookNameError(), copy.getBookNameError());
    }
}
