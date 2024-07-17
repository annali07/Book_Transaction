package interface_adapter.returnorborrow;

import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.ReturnOrBorrow.RobOutputBoundary;
import view.views.MainMenuView;

public class ReturnOrBorrowPresenter implements RobOutputBoundary {
    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;
    private final ViewManagerModel viewManagerModel;
    private final RentMenuViewModel rentMenuViewModel;
    private final ReturnBookViewModel returnBookViewModel;
    private final BorrowBookViewModel borrowBookViewModel;
    private final MainMenuViewModel mainMenuViewModel;

    public ReturnOrBorrowPresenter(ReturnOrBorrowViewModel returnOrBorrowViewModel, ViewManagerModel viewManagerModel, RentMenuViewModel rentMenuViewModel, ReturnBookViewModel returnBookViewModel, BorrowBookViewModel borrowBookViewModel, MainMenuViewModel mainMenuViewModel) {
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
        this.viewManagerModel = viewManagerModel;
        this.rentMenuViewModel = rentMenuViewModel;
        this.returnBookViewModel = returnBookViewModel;
        this.borrowBookViewModel = borrowBookViewModel;
        this.mainMenuViewModel = mainMenuViewModel;
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
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Return or Borrow View to rent Menu");

    }
}
