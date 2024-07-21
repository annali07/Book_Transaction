package interface_adapter.RentMenu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RentMenuStateTest {

    private RentMenuState rentMenuState;

    @BeforeEach
    void setUp() {
        rentMenuState = new RentMenuState();
    }

    @Test
    void testDefaultConstructor() {
        assertEquals(0, rentMenuState.getBookID());
        assertEquals(0, rentMenuState.getBookIDError());
    }

    @Test
    void testCopyConstructor() {
        rentMenuState.setBookID(123);
        rentMenuState.setBookIDError(1);

        RentMenuState copy = new RentMenuState(rentMenuState);
        assertEquals(123, copy.getBookID());
        assertEquals(1, copy.getBookIDError());
    }

    @Test
    void testSetAndGetBookID() {
        rentMenuState.setBookID(456);
        assertEquals(456, rentMenuState.getBookID());
    }

    @Test
    void testSetAndGetBookIDError() {
        rentMenuState.setBookIDError(2);
        assertEquals(2, rentMenuState.getBookIDError());
    }
}
