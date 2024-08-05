package use_case.rent_book.BorrowBook;

import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.database_borrow_book.DatabaseBorrowInterface;

import java.util.Date;

/**
 * The BorrowBookInteractor class handles the business logic for borrowing a book.
 * It interacts with the database to write borrow information and with the presenter to prepare views.
 *
 */
public class BorrowBookInteractor implements BorrowBookInputBoundary {
    private final BookRepositoryDataAccessInterface bookRepositoryDataAccessObject;
    private final DatabaseBorrowInterface userGateway;
    private final BorrowBookOutputBoundary presenter;

    /**
     * Constructs a BorrowBookInteractor object with the specified database gateway and presenter.
     *
     * @param userGateway the database gateway for writing borrow information
     * @param presenter the presenter for preparing views
     */
    public BorrowBookInteractor(BookRepositoryDataAccessInterface bookRepositoryDataAccessObject, DatabaseBorrowInterface userGateway, BorrowBookOutputBoundary presenter) {
        this.bookRepositoryDataAccessObject = bookRepositoryDataAccessObject;
        this.userGateway = userGateway;
        this.presenter = presenter;
    }

    /**
     * Executes the borrowing process by writing borrow information to the database and preparing the success view.
     *
     * @param returnBookInputData the input data containing borrow information
     */
    @Override
    public void execute(BorrowBookInputData returnBookInputData) {
        int bookID = returnBookInputData.getBookID();
        boolean isFound = bookRepositoryDataAccessObject.findBook(bookID);
        if (isFound){
            Date startDate = returnBookInputData.getStartDate();
            Date endDate = returnBookInputData.getEndDate();
            String borrowerName = returnBookInputData.getBorrowerName();
            String borrowerNumber = returnBookInputData.getBorrowerNumber();

//            userGateway.writeBorrowFile(bookID, startDate,endDate,borrowerName,borrowerNumber);
            boolean success = bookRepositoryDataAccessObject.updateBook(bookID, startDate,endDate,borrowerName,borrowerNumber);
            if (success){
                BorrowBookOutputData borrowBookOutputData = new BorrowBookOutputData(bookID, startDate, endDate, borrowerName, borrowerNumber);
                presenter.prepareSuccessView(borrowBookOutputData);
                System.out.println("The book with bookID " + bookID + " has been successfully borrowed.");
            } else {
                System.out.println("The book with bookID " + bookID + " could not be borrowed.");
            }

        } else {
            System.out.println("The book with bookID " + bookID + " is not found.");
        }
    }

    /**
     * Cancels the borrowing process and invokes the presenter's cancel view.
     */
    @Override
    public void cancel() {
        presenter.prepareCancelView();
    }
}
