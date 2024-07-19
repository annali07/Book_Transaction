package interface_adapter.returnorborrow;

import interface_adapter.RentInformation.borrowbook.BorrowBookViewModel;
import interface_adapter.RentInformation.returnbook.ReturnBookViewModel;
import interface_adapter.RentMenu.RentMenuViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.ReturnOrBorrow.RobOutputBoundary;
import view.views.MainMenuView;

/**
 * Presenter for handling the output of the return or borrow use case.
 * It updates the view models and manages view transitions based on the result of the use case execution.
 *
 */

public class ReturnOrBorrowPresenter implements RobOutputBoundary {
    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;
    private final ViewManagerModel viewManagerModel;
    private final RentMenuViewModel rentMenuViewModel;
    private final ReturnBookViewModel returnBookViewModel;
    private final BorrowBookViewModel borrowBookViewModel;
    private final MainMenuViewModel mainMenuViewModel;

    /**
     * Constructs an AddBookPresenter with the specified view models.
     *
     * @param returnOrBorrowViewModel the view model for the return or borrow view
     * @param viewManagerModel the view manager model for managing view transitions
     * @param mainMenuViewModel the view model for the main menu view
     * @param returnBookViewModel the view model for return book view
     * @param borrowBookViewModel the borrow model for borrow book view
     * @param rentMenuViewModel the rent menu model for rent menu view
     */
    public ReturnOrBorrowPresenter(ReturnOrBorrowViewModel returnOrBorrowViewModel, ViewManagerModel viewManagerModel, RentMenuViewModel rentMenuViewModel, ReturnBookViewModel returnBookViewModel, BorrowBookViewModel borrowBookViewModel, MainMenuViewModel mainMenuViewModel) {
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
        this.viewManagerModel = viewManagerModel;
        this.rentMenuViewModel = rentMenuViewModel;
        this.returnBookViewModel = returnBookViewModel;
        this.borrowBookViewModel = borrowBookViewModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }

    /**
     * prepare the view for returning the book
     */
    @Override
    public void returnBook() {
        System.out.println("Switched from Return or Borrow View to Return");
        viewManagerModel.setActiveView(returnBookViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepare the view for borrowing the book
     */

    @Override
    public void borrowBook() {
        System.out.println("Switched from Return or Borrow View to Borrow");
        viewManagerModel.setActiveView(borrowBookViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a canceled add book operation.
     * Switches the active view to the main menu view.
     */
    @Override
    public void prepareCancelView() {
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Return or Borrow View to main main Menu");
    }
}
