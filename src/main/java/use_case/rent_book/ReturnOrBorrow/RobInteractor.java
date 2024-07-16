package use_case.rent_book.ReturnOrBorrow;

import use_case.rent_book.RentMenu.RentMenuOutputBoundary;

public class RobInteractor{
    private final RobOutputBoundary presenter;

    public RobInteractor(RobOutputBoundary presenter){this.presenter = presenter;}

    public void cancel(){presenter.prepareCancelView();}
    public void returnBook(){presenter.returnBook();}
    public void borrowBook(){presenter.borrowBook();}
}
