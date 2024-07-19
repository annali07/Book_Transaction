package interface_adapter.RentInformation.returnbook;


import interface_adapter.RentMenu.RentMenuState;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.ReturnBook.ReturnBookOutputBoundary;
import use_case.rent_book.ReturnBook.ReturnBookOutputData;
import view.views.ReturnBookView;

/**
 * Presenter for handling the output of the return book use case.
 * It updates the view models and manages view transitions based on the result of the use case execution.
 *
 */
public class ReturnBookPresenter implements ReturnBookOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;

    private final ReturnBookViewModel returnBookViewModel;

    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;

    /**
     * Constructs an ReturnBookPresenter with the specified view models.
     *
     * @param returnBookViewModel the view model for the return book view
     * @param viewManagerModel the view manager model for managing view transitions
     * @param mainMenuViewModel the view model for the main menu view
     * @param returnOrBorrowViewModel the view model for the return or borrow book view
     */
    public ReturnBookPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel, ReturnBookViewModel returnBookViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.returnBookViewModel = returnBookViewModel;
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
    }

    /**
     * Prepares the view for a successful return book operation.
     * Switches the active view to the main menu view.
     */
    @Override
    public void prepareSuccessView(ReturnBookOutputData returnBookOutputData) {
        ReturnBookState returnBookstate = returnBookViewModel.getState();
        MainMenuState mainMenuState = mainMenuViewModel.getState();
        mainMenuState.setActiveButton(returnBookOutputData.defaultButton());
        this.mainMenuViewModel.setState(mainMenuState);
        mainMenuViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("I find and return the book");

    }

    /**
     * Prepares the view for a canceled return book operation.
     * Switches the active view to the return or borrow book view.
     */
    @Override
    public void prepareCancelView() {
        viewManagerModel.setActiveView(returnOrBorrowViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Return Book View to choose Menu");

    }
}
