package interface_adapter.returnorborrow;

import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.ReturnOrBorrow.RobOutputBoundary;

public class ReturnOrBorrowPresenter implements RobOutputBoundary {
    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;
    private final ViewManagerModel viewManagerModel;
    private final RentMenuViewModel rentMenuViewModel;
    private final ReturnBookViewModel returnBookViewModel;
    private final BorrowBookViewModel borrowBookViewModel;

    public ReturnOrBorrowPresenter(ReturnOrBorrowViewModel returnOrBorrowViewModel, ViewManagerModel viewManagerModel, RentMenuViewModel rentMenuViewModel, ReturnBookViewModel returnBookViewModel, BorrowBookViewModel borrowBookViewModel) {
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
        this.viewManagerModel = viewManagerModel;
        this.rentMenuViewModel = rentMenuViewModel;
        this.returnBookViewModel = returnBookViewModel;
        this.borrowBookViewModel = borrowBookViewModel;
    }

    @Override
    public void returnBook() {

        System.out.println("Switched from Return or Borrow View to Return");
        viewManagerModel.setActiveView(returnBookViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void borrowBook() {
        System.out.println("Switched from Return or Borrow View to Borrow");
        viewManagerModel.setActiveView(borrowBookViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareCancelView() {
        viewManagerModel.setActiveView(rentMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Return or Borrow View to rent Menu");

    }
}
