package interface_adapter.RentInformation.returnbook;

import use_case.rent_book.ReturnBook.ReturnBookInputBoundary;
import use_case.rent_book.ReturnBook.ReturnBookInputData;

import java.util.Date;

/**
 * The ReturnBookController class handles the user input for returning a book.
 * It interacts with the return book interactor to execute and cancel book return operations.
 *
 */
public class ReturnBookController {

    final ReturnBookInputBoundary returnBookInteractor;

    /**
     * Constructs a ReturnBookController object with the specified return book interactor.
     *
     * @param returnBookInteractor the interactor for returning a book
     */
    public ReturnBookController(ReturnBookInputBoundary returnBookInteractor) {
        this.returnBookInteractor = returnBookInteractor;
    }

    /**
     * Executes the return book operation with the specified parameters.
     *
     * @param bookID the ID of the book to be returned
     * @param date_return the return date of the book
     * @param date_end the end date of the borrowing period
     */
    public void execute(int bookID, Date date_return, Date date_end, Date date_start) {
        ReturnBookInputData returnBookInputData = new ReturnBookInputData(bookID, date_return, date_end, date_start);
        returnBookInteractor.execute(returnBookInputData);

    }

    /**
     * Cancels the return book operation.
     */
    public void cancel() {
        returnBookInteractor.cancel();
    }
}
