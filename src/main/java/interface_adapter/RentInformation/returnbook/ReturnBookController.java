package interface_adapter.RentInformation.returnbook;

import use_case.rent_book.ReturnBook.ReturnBookInputBoundary;
import use_case.rent_book.ReturnBook.ReturnBookInputData;

import java.util.Date;

public class ReturnBookController {

    final ReturnBookInputBoundary returnBookInteractor;

    public ReturnBookController(ReturnBookInputBoundary returnBookInteractor) {
        this.returnBookInteractor = returnBookInteractor;
    }

    public void execute(int bookID, Date date_return, Date date_end) {
        ReturnBookInputData returnBookInputData = new ReturnBookInputData(bookID, date_return, date_end);
        returnBookInteractor.execute(returnBookInputData);

    }
    public void cancel() {
        returnBookInteractor.cancel();
    }
}
