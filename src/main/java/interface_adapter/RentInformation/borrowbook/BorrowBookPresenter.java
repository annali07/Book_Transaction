package interface_adapter.RentInformation.borrowbook;

import interface_adapter.RentInformation.returnbook.ReturnBookState;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.BorrowBook.BorrowBookOutputBoundary;
import use_case.rent_book.BorrowBook.BorrowBookOutputData;

/**
 * Presenter for handling the output of the borrow book use case.
 * It updates the view models and manages view transitions based on the result of the use case execution.
 *
 */
public class BorrowBookPresenter implements BorrowBookOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;

    private final BorrowBookViewModel borrowBookViewModel;

    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;

    /**
     * Constructs an BorrowBookPresenter with the specified view models.
     *
     * @param borrowBookViewModel the view model for the borrow book view
     * @param viewManagerModel the view manager model for managing view transitions
     * @param mainMenuViewModel the view model for the main menu view
     * @param returnOrBorrowViewModel the view model for the return or borrow book view
     */
    public BorrowBookPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel, BorrowBookViewModel borrowBookViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.borrowBookViewModel = borrowBookViewModel;
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
    }

    /**
     * Prepares the view for a successful borrow book operation.
     * Switches the active view to the main menu view.
     */
    @Override
    public void prepareSuccessView(BorrowBookOutputData borrowBookOutputData) {
        BorrowBookState borrowBookState = borrowBookViewModel.getState();
        MainMenuState mainMenuState = mainMenuViewModel.getState();
        mainMenuState.setActiveButton(borrowBookOutputData.defaultButton());
        this.mainMenuViewModel.setState(mainMenuState);
        mainMenuViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("I find and borrow the book");

    }

    /**
     * Prepares the view for a canceled borrow book operation.
     * Switches the active view to the return or borrow book view.
     */
    @Override
    public void prepareCancelView() {
        viewManagerModel.setActiveView(returnOrBorrowViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Borrow Book View to choose Menu");

    }
}
