package use_case.calculate_revenue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.calculate_revenue.RevenueInputData;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class RevenueInputDataTest {

    private RevenueInputData revenueInputData;
    private Date startDate;
    private Date endDate;

    @BeforeEach
    void setUp() {
        startDate = new Date(2023 - 1900, 6, 1); // July 1, 2023
        endDate = new Date(2023 - 1900, 6, 31); // July 31, 2023
        revenueInputData = new RevenueInputData(startDate, endDate, true, true);
    }

    @Test
    void testGetStartDate() {
        assertEquals(startDate, revenueInputData.getStartDate());
    }

    @Test
    void testGetEndDate() {
        assertEquals(endDate, revenueInputData.getEndDate());
    }

    @Test
    void testIsRental() {
        assertTrue(revenueInputData.isRental());
    }

    @Test
    void testIsPurchase() {
        assertTrue(revenueInputData.isPurchase());
    }

    @Test
    void testSetDifferentValues() {
        Date newStartDate = new Date(2023 - 1900, 7, 1); // August 1, 2023
        Date newEndDate = new Date(2023 - 1900, 7, 31); // August 31, 2023
        revenueInputData = new RevenueInputData(newStartDate, newEndDate, false, false);

        assertEquals(newStartDate, revenueInputData.getStartDate());
        assertEquals(newEndDate, revenueInputData.getEndDate());
        assertFalse(revenueInputData.isRental());
        assertFalse(revenueInputData.isPurchase());
    }
}


