package use_case.rent_book.ReturnBook;

import data_access.data_base_return_book.DatabaseReturnInterface;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * The ReturnBookInteractor class handles the business logic for returning a book.
 * It interacts with the database to edit and write return information and calculates any overdue charges.
 *
 */
public class ReturnBookInteractor implements ReturnBookInputBoundary {

    private final DatabaseReturnInterface userGateway;
    private final ReturnBookOutputBoundary presenter;

    /**
     * Constructs a ReturnBookInteractor object with the specified database gateway and presenter.
     *
     * @param userGateway the database gateway for handling return information
     * @param presenter the presenter for preparing views
     */
    public ReturnBookInteractor(DatabaseReturnInterface userGateway, ReturnBookOutputBoundary presenter) {
        this.userGateway = userGateway;
        this.presenter = presenter;
    }

    /**
     * Executes the return book operation by calculating any overdue charges,
     * updating the book file, and writing the return information to the database.
     * It then prepares the success view with the return data.
     *
     * @param borrowBookInputData the input data containing return information
     */
    @Override
    public void execute(ReturnBookInputData borrowBookInputData) {
        // We could use entity here to calculate the charge
        Date endDate = borrowBookInputData.getEndDate();
        Date returnDate = borrowBookInputData.getReturnDate();
        int charge = 0;
        if (returnDate.after(endDate)){
            long diffInMillies = Math.abs(returnDate.getTime() - endDate.getTime());
            long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            charge = (int)diffInDays;
        }
        userGateway.editBookFile(borrowBookInputData.getBookID());
        userGateway.writeReturnFile(borrowBookInputData.getBookID(), charge);
        ReturnBookOutputData response = new ReturnBookOutputData(borrowBookInputData.getBookID(), charge);
        presenter.prepareSuccessView(response);
        System.out.println("I have returned the book");
    }

    /**
     * Cancels the return book operation and invokes the presenter's cancel view.
     */
    @Override
    public void cancel() {
        presenter.prepareCancelView();
    }
}
