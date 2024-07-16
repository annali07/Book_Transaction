package use_case.rent_book.ReturnOrBorrow;

import use_case.rent_book.RentMenu.RentMenuOutputData;

public interface RobOutputBoundary {
    void returnBook();
    void borrowBook();
    void prepareCancelView();
}
