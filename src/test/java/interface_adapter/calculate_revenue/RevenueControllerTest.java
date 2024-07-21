package interface_adapter.calculate_revenue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.calculate_revenue.RevenueInputBoundary;
import use_case.calculate_revenue.RevenueInputData;
import interface_adapter.calculate_revenue.RevenueController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RevenueControllerTest {

    private RevenueInputBoundary revenueUsecaseInteractor;
    private RevenueController controller;

    @BeforeEach
    void setUp() {
        revenueUsecaseInteractor = mock(RevenueInputBoundary.class);
        controller = new RevenueController(revenueUsecaseInteractor);
    }

    @Test
    void testExecuteSuccess() throws ParseException {
        String startDateStr = "2023-07-01";
        String endDateStr = "2023-07-31";
        boolean rental = true;
        boolean purchase = true;

        controller.execute(startDateStr, endDateStr, rental, purchase);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = formatter.parse(startDateStr);
        Date endDate = formatter.parse(endDateStr);
        RevenueInputData expectedData = new RevenueInputData(startDate, endDate, rental, purchase);

        verify(revenueUsecaseInteractor).calculateRevenue(Mockito.refEq(expectedData));
    }

    @Test
    void testExecuteParseException() {
        String invalidDateStr = "invalid-date";
        String endDateStr = "2023-07-31";
        boolean rental = true;
        boolean purchase = true;

        controller.execute(invalidDateStr, endDateStr, rental, purchase);

        verify(revenueUsecaseInteractor).cancel();
    }

    @Test
    void testCancel() {
        controller.cancel();
        verify(revenueUsecaseInteractor).cancel();
    }
}
