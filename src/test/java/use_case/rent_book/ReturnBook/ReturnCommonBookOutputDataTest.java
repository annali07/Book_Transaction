package use_case.rent_book.ReturnBook;

import org.junit.jupiter.api.Test;
import use_case.rent_book.ReturnBook.ReturnBookOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReturnCommonBookOutputDataTest {

    @Test
    void testReturnBookOutputData() {
        int bookID = 123;
        int charge = 50;

        // Create an instance of ReturnBookOutputData
        ReturnBookOutputData outputData = new ReturnBookOutputData(bookID, charge);

        // Validate the bookID
        assertEquals(bookID, outputData.getBookID());

        // Validate the charge
        assertEquals(charge, outputData.getCharge());

        // Validate the default button status
        assertEquals("none", outputData.defaultButton());
    }
}
