package use_case.rent_book.BorrowBook;

import data_access.database_borrow_book.DatabaseBorrowInterface;

import java.util.Date;

/**
 * Use case class for borrowing a book.
 * This class contains the business logic for borrowing a book and
 * interacts with the presenter to update the view.
 */

public class BorrowBookInteractor implements BorrowBookInputBoundary {

    /**
     * The user gateway for accessing book data.
     */
    private final DatabaseBorrowInterface userGateway;

    /**
     * The presenter to prepare the output data for the view.
     */
    private final BorrowBookOutputBoundary presenter;

    /**
     * Constructs a BorrowBookInteractor instance with the specified user gateway and presenter.
     *
     * @param userGateway The user gateway for accessing book data.
     * @param presenter The presenter to prepare the output data for the view.
     */
    public BorrowBookInteractor(DatabaseBorrowInterface userGateway, BorrowBookOutputBoundary presenter) {
        this.userGateway = userGateway;
        this.presenter = presenter;
    }

    /**
     * Executes the borrow process using the provided input data.
     *
     * @param returnBookInputData The input data containing relevant information for the book borrow.
     */
    @Override
    public void execute(BorrowBookInputData returnBookInputData) {
        int bookID = returnBookInputData.getBookID();
        Date startDate = returnBookInputData.getStartDate();
        Date endDate = returnBookInputData.getEndDate();
        String borrowerName = returnBookInputData.getBorrowerName();
        String borrowerNumber = returnBookInputData.getBorrowerNumber();

        userGateway.writeBorrowFile(bookID, startDate,endDate,borrowerName,borrowerNumber);
        BorrowBookOutputData borrowBookOutputData = new BorrowBookOutputData(bookID, startDate, endDate, borrowerName, borrowerNumber);
        presenter.prepareSuccessView(borrowBookOutputData);
        System.out.println("I have borrowed the book");
    }

    /**
     * Cancel the current operation
     */
    @Override
    public void cancel() {
        presenter.prepareCancelView();
    }
}
