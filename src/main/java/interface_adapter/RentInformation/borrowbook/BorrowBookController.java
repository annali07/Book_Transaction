package interface_adapter.RentInformation.borrowbook;

import use_case.rent_book.BorrowBook.BorrowBookInputBoundary;
import use_case.rent_book.BorrowBook.BorrowBookInputData;

import java.util.Date;

/**
 * Controller for handling the borrowing book functionality.
 * It interacts with the use case interactor to perform the borrow book operation and cancel the operation.
 *
 */

public class BorrowBookController {
    final BorrowBookInputBoundary borrowBookInteractor;

    /**
     * Constructs an BorrowBookController with the specified use case interactor.
     *
     * @param borrowBookInteractor the use case interactor for borrowing a book
     */
    public BorrowBookController(BorrowBookInputBoundary borrowBookInteractor) {
        this.borrowBookInteractor = borrowBookInteractor;
    }

    /**
     * Executes the borrow book operation with the provided bookID, date_start, date_end, borrowerNumber, borrowerName.
     *
     * @param bookID the bookID of the book to borrow
     * @param date_start the borrow start date of the book to borrow
     * @param date_end the borrow end date of the book to borrow
     * @param borrowerNumber the borrower's phone number to add
     * @param borrowerName the borrower's name to add
     */
    public void execute(int bookID, Date date_start, Date date_end, String borrowerNumber, String borrowerName){
        BorrowBookInputData borrowBookInputData = new BorrowBookInputData(bookID, date_start, date_end, borrowerNumber, borrowerName);
        borrowBookInteractor.execute(borrowBookInputData);
    }

    /**
     * Cancels the borrow book operation.
     */
    public void cancel(){borrowBookInteractor.cancel();}

}
