package interface_adapter.RentInformation.borrowbook;

import use_case.rent_book.BorrowBook.BorrowBookInputBoundary;
import use_case.rent_book.BorrowBook.BorrowBookInputData;

import java.util.Date;

public class BorrowBookController {
    final BorrowBookInputBoundary borrowBookInteractor;

    public BorrowBookController(BorrowBookInputBoundary borrowBookInteractor) {
        this.borrowBookInteractor = borrowBookInteractor;
    }

    public void execute(int bookID, Date date_start, Date date_end, String borrowerNumber, String borrowerName){
        BorrowBookInputData borrowBookInputData = new BorrowBookInputData(bookID, date_start, date_end, borrowerNumber, borrowerName);
        borrowBookInteractor.execute(borrowBookInputData);
    }
    public void cancel(){borrowBookInteractor.cancel();}

}
