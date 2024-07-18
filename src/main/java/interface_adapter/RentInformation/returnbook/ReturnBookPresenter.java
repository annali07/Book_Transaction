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
 * The ReturnBookPresenter class handles the presentation logic for the return book operation.
 * It interacts with the view models and the view manager to update the views based on the return book operation results.
 *
 */
public class ReturnBookPresenter implements ReturnBookOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;

    private final ReturnBookViewModel returnBookViewModel;

    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;

    /**
     * Constructs a ReturnBookPresenter object with the specified view manager, main menu view model,
     * return book view model, and return or borrow view model.
     *
     * @param viewManagerModel the view manager model
     * @param mainMenuViewModel the main menu view model
     * @param returnBookViewModel the return book view model
     * @param returnOrBorrowViewModel the return or borrow view model
     */
    public ReturnBookPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel, ReturnBookViewModel returnBookViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.returnBookViewModel = returnBookViewModel;
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
    }

    /**
     * Prepares and displays the success view for the return book operation.
     *
     * @param returnBookOutputData the output data of the return book operation
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
     * Prepares and switches to the cancel view.
     */
    @Override
    public void prepareCancelView() {
        viewManagerModel.setActiveView(returnOrBorrowViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Return Book View to choose Menu");

    }
}
