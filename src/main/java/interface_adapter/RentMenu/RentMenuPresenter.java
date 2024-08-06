package interface_adapter.RentMenu;

import data.misc_info.TemproraryInfo;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.RentMenu.RentMenuOutputBoundary;
import use_case.rent_book.RentMenu.RentMenuOutputData;

/**
 * Presenter for handling the output of the rent menu use case.
 * It updates the view models and manages view transitions based on the result of the use case execution.
 *
 */
public class RentMenuPresenter implements RentMenuOutputBoundary {
    private final RentMenuViewModel rentMenuViewModel;
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;
    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;

    /**
     * Constructs an RentMenuPresenter with the specified view models.
     *
     * @param rentMenuViewModel the view model for the rent menu view
     * @param viewManagerModel the view manager model for managing view transitions
     * @param mainMenuViewModel the view model for the main menu view
     * @param returnOrBorrowViewModel the view model for return or borrow view
     */
    public RentMenuPresenter(ViewManagerModel viewManagerModel, RentMenuViewModel rentMenuViewModel, MainMenuViewModel mainMenuViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) {
        this.rentMenuViewModel = rentMenuViewModel;
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
    }

    /**
     * Prepares the view for a successful search book operation.
     * Store the temporary variable for bookID
     * Switches the active view to the return or borrow view.
     */
    @Override
    public void prepareSuccessView(RentMenuOutputData rentMenuOutputData) {
        RentMenuState rentMenuState = rentMenuViewModel.getState();
        MainMenuState mainMenuState = mainMenuViewModel.getState();
        mainMenuState.setActiveButton(rentMenuOutputData.defaultButton());
        this.mainMenuViewModel.setState(mainMenuState);
        TemproraryInfo.setClassVariable(rentMenuOutputData.getBookID());
        mainMenuViewModel.firePropertyChanged();

//        ReturnOrBorrowState robState = returnOrBorrowViewModel.getState();
//        robState.setBookId(rentMenuOutputData.getBookID());
//        returnOrBorrowViewModel.setState(robState);
//        returnOrBorrowViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(returnOrBorrowViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Found the book");
    }

    /**
     * Prepares the view for a failed search book operation.
     * Displays an error message.
     *
     * @param error the error message to display
     */
    @Override
    public void prepareFailView(String error) {
        System.out.println("cannot find the book");
    }

    /**
     * Prepares the view for a canceled search book operation.
     * Switches the active view to the main menu view.
     */
    @Override
    public void prepareCancelView() {
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Rent CommonBook View to Main Menu");

    }
}
