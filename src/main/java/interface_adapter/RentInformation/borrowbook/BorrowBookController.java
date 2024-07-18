package interface_adapter.RentInformation.borrowbook;

import use_case.rent_book.BorrowBook.BorrowBookInputBoundary;
import use_case.rent_book.BorrowBook.BorrowBookInputData;

import java.util.Date;

/**
 * The BorrowBookController class handles the user input for borrowing a book.
 * It interacts with the borrow book interactor to execute and cancel book borrowing operations.
 *
 */
public class BorrowBookController {
    final BorrowBookInputBoundary borrowBookInteractor;

    /**
     * Constructs a BorrowBookController object with the specified borrow book interactor.
     *
     * @param borrowBookInteractor the interactor for borrowing a book
     */
    public BorrowBookController(BorrowBookInputBoundary borrowBookInteractor) {
        this.borrowBookInteractor = borrowBookInteractor;
    }

    /**
     * Executes the borrow book operation with the specified parameters.
     *
     * @param bookID the ID of the book to be borrowed
     * @param date_start the start date of the borrowing period
     * @param date_end the end date of the borrowing period
     * @param borrowerNumber the number of the borrower
     * @param borrowerName the name of the borrower
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
