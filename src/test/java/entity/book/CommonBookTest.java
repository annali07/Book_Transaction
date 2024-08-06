package entity.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CommonBookTest {

    private CommonBook book;

    @BeforeEach
    public void setUp() {
        book = new CommonBook("Test Book", 29.99);
    }

    @Test
    public void testConstructorWithTwoParameters() {
        assertEquals("Test Book", book.getBookName());
        assertEquals(29.99, book.getBookPrice());
        assertNull(book.getRentalStartDate());
        assertNull(book.getRentalEndDate());
        assertEquals("", book.getBorrowerName());
        assertEquals("", book.getBorrowerNumber());
    }

    @Test
    public void testConstructorWithSevenParameters() {
        Date rentalStartDate = new Date();
        Date rentalEndDate = new Date(System.currentTimeMillis() + 100000);
        CommonBook bookWithAllParams = new CommonBook(1, "Test Book", 29.99, rentalStartDate, rentalEndDate, "true", "John Doe", "12345");

        assertEquals(1, bookWithAllParams.getBookID());
        assertEquals("Test Book", bookWithAllParams.getBookName());
        assertEquals(29.99, bookWithAllParams.getBookPrice());
        assertEquals(rentalStartDate, bookWithAllParams.getRentalStartDate());
        assertEquals(rentalEndDate, bookWithAllParams.getRentalEndDate());
        assertEquals("true", bookWithAllParams.getIsRented());
        assertEquals("John Doe", bookWithAllParams.getBorrowerName());
        assertEquals("12345", bookWithAllParams.getBorrowerNumber());
    }

    @Test
    public void testSetAndGetBookName() {
        book.setBookName("New Book Name");
        assertEquals("New Book Name", book.getBookName());
    }

    @Test
    public void testSetAndGetRentalStartDate() {
        Date startDate = new Date();
        book.setRentalStartDate(startDate);
        assertEquals(startDate, book.getRentalStartDate());
    }

    @Test
    public void testSetAndGetRentalEndDate() {
        Date endDate = new Date();
        book.setRentalEndDate(endDate);
        assertEquals(endDate, book.getRentalEndDate());
    }

    @Test
    public void testGetRentalPrice() {
        assertEquals(CommonBook.RENTAL_PRICE, book.getRentalPrice());
    }
}
