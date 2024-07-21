package interface_adapter.returnorborrow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReturnOrBorrowStateTest {

    @Test
    void testDefaultConstructor() {
        ReturnOrBorrowState state = new ReturnOrBorrowState();
        assertEquals(0, state.getBookId());
    }

    @Test
    void testParameterizedConstructor() {
        ReturnOrBorrowState originalState = new ReturnOrBorrowState();
        originalState.setBookId(123);

        ReturnOrBorrowState copiedState = new ReturnOrBorrowState(originalState);
        assertEquals(123, copiedState.getBookId());
    }

    @Test
    void testSetBookId() {
        ReturnOrBorrowState state = new ReturnOrBorrowState();
        state.setBookId(456);
        assertEquals(456, state.getBookId());
    }
}
