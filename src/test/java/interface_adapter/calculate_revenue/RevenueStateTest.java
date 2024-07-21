package interface_adapter.calculate_revenue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import interface_adapter.calculate_revenue.RevenueState;

import static org.junit.jupiter.api.Assertions.*;

public class RevenueStateTest {

    private RevenueState revenueState;

    @BeforeEach
    void setUp() {
        revenueState = new RevenueState("2023-07-01", "2023-07-31");
    }

    @Test
    void testGetStartDateString() {
        assertEquals("2023-07-01", revenueState.getStartDateString());
    }

    @Test
    void testGetEndDateString() {
        assertEquals("2023-07-31", revenueState.getEndDateString());
    }

    @Test
    void testSetStartDateString() {
        revenueState.setStartDateString("2023-08-01");
        assertEquals("2023-08-01", revenueState.getStartDateString());
    }

    @Test
    void testSetEndDateString() {
        revenueState.setEndDateString("2023-08-31");
        assertEquals("2023-08-31", revenueState.getEndDateString());
    }

    @Test
    void testDefaultConstructor() {
        RevenueState defaultState = new RevenueState();
        assertEquals("", defaultState.getStartDateString());
        assertEquals("", defaultState.getEndDateString());
    }
}

