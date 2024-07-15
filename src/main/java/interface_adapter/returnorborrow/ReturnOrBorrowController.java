package interface_adapter.returnorborrow;

import use_case.rent_book.RentMenu.RentMenuInputBoundary;
import use_case.rent_book.RentMenu.RentMenuInputData;
import use_case.rent_book.ReturnOrBorrow.RobInteractor;

public class ReturnOrBorrowController {
    final RobInteractor robInteractor;

    public ReturnOrBorrowController(RobInteractor robInteractor) {
        this.robInteractor = robInteractor;
    }

    public void returnBook() {
        this.robInteractor.returnBook();
    }

    public void cancel() {
        this.robInteractor.cancel();
    }

    public void borrowBook(){
        this.robInteractor.borrowBook();
    }

}
