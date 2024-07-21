package use_case.rent_book.RentMenu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.rent_book.RentMenu.RentMenuOutputData;

import static org.junit.jupiter.api.Assertions.*;

public class RentMenuOutputDataTest {

    private RentMenuOutputData outputData;

    @BeforeEach
    void setUp() {
        outputData = new RentMenuOutputData(123, false);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(123, outputData.getBookID());
        assertFalse(outputData.getSuccess());
    }

    @Test
    void testSetSuccess() {
        outputData.setSuccess(true);
        assertTrue(outputData.getSuccess());

        outputData.setSuccess(false);
        assertFalse(outputData.getSuccess());
    }

    @Test
    void testDefaultButton() {
        assertEquals("none", outputData.defaultButton());
    }
}
