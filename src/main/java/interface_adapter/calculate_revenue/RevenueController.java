package interface_adapter.calculate_revenue;

import use_case.calculate_revenue.RevenueInputBoundary;
import use_case.calculate_revenue.RevenueInputData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The RevenueController class handles the user input for calculating revenue.
 * It interacts with the revenue data boundary to execute and cancel revenue calculations.
 *
 */
public class RevenueController {
    final RevenueInputBoundary revenueUsecaseInteractor;

    /**
     * Constructs a RevenueController object with the specified revenue data boundary.
     *
     * @param revenueUsecaseInteractor the boundary interface for revenue data operations
     */
    public RevenueController(RevenueInputBoundary revenueUsecaseInteractor) {
        this.revenueUsecaseInteractor = revenueUsecaseInteractor;
    }

    /**
     * Executes the revenue calculation with the specified parameters.
     *
     * @param startDateStr the start date for the revenue calculation
     * @param endDateStr the end date for the revenue calculation
     * @param Rental whether to include rental revenue
     * @param Purchase whether to include purchase revenue
     */
    public void execute(String startDateStr, String endDateStr, boolean Rental, boolean Purchase) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate;
        Date endDate;
        try {
            startDate = formatter.parse(startDateStr);
            endDate = formatter.parse(endDateStr);
            System.out.println(startDate);
            RevenueInputData revenueData = new RevenueInputData(startDate, endDate, Rental, Purchase);
            revenueUsecaseInteractor.calculateRevenue(revenueData);
        } catch (ParseException e) {
            e.printStackTrace();
            revenueUsecaseInteractor.cancel();
        }
    }

    /**
     * Cancels the revenue calculation.
     */
    public void cancel() {
        revenueUsecaseInteractor.cancel();

    }
}
