package interface_adapter.RentInformation.returnbook;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnBookStateTest {

    private ReturnBookState returnBookState;

    @BeforeEach
    void setUp() {
        returnBookState = new ReturnBookState();
    }

    @Test
    void testGetAndSetBookID() {
        returnBookState.setBookID(123);
        assertEquals(123, returnBookState.getBookID());
    }

    @Test
    void testGetAndSetBookIDError() {
        returnBookState.setBookIDError(1);
        assertEquals(1, returnBookState.getBookIDError());
    }

    @Test
    void testGetAndSetBookName() {
        returnBookState.setBookName("Harry Potter");
        assertEquals("Harry Potter", returnBookState.getBookName());
    }

    @Test
    void testGetAndSetBookNameError() {
        returnBookState.setBookNameError("Invalid Book Name");
        assertEquals("Invalid Book Name", returnBookState.getBookNameError());
    }

    @Test
    void testGetAndSetStartDate() {
        Date date = new Date();
        returnBookState.setStartDate(date);
        assertEquals(date, returnBookState.getStartDate());
    }

    @Test
    void testGetAndSetStartDateError() {
        Date date = new Date();
        returnBookState.setStartDateError(date);
        assertEquals(date, returnBookState.getStartDateError());
    }

    @Test
    void testGetAndSetEndDate() {
        Date date = new Date();
        returnBookState.setEndDate(date);
        assertEquals(date, returnBookState.getEndDate());
    }

    @Test
    void testGetAndSetEndDateError() {
        Date date = new Date();
        returnBookState.setEndDateError(date);
        assertEquals(date, returnBookState.getRentEndDateError());
    }

    @Test
    void testGetAndSetReturnDate() {
        Date date = new Date();
        returnBookState.setReturnDate(date);
        assertEquals(date, returnBookState.getReturnDate());
    }

    @Test
    void testGetAndSetReturnDateError() {
        Date date = new Date();
        returnBookState.setReturnDateError(date);
        assertEquals(date, returnBookState.getReturnDateError());
    }

    @Test
    void testCopyConstructor() {
        Date date = new Date();
        ReturnBookState originalState = new ReturnBookState();
        originalState.setBookID(123);
        originalState.setBookIDError(1);
        originalState.setBookName("Harry Potter");
        originalState.setBookNameError("Invalid Book Name");
        originalState.setStartDate(date);
        originalState.setStartDateError(date);
        originalState.setEndDate(date);
        originalState.setEndDateError(date);
        originalState.setReturnDate(date);
        originalState.setReturnDateError(date);

        ReturnBookState copiedState = new ReturnBookState(originalState);

        assertEquals(123, copiedState.getBookID());
        assertEquals(1, copiedState.getBookIDError());
        assertEquals("Harry Potter", copiedState.getBookName());
        assertEquals("Invalid Book Name", copiedState.getBookNameError());
        assertEquals(date, copiedState.getStartDate());
        assertEquals(date, copiedState.getStartDateError());
        assertEquals(date, copiedState.getEndDate());
        assertEquals(date, copiedState.getRentEndDateError());
        assertEquals(date, copiedState.getReturnDate());
        assertEquals(date, copiedState.getReturnDateError());
    }
}
