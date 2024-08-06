package interface_adapter.RentInformation.borrowbook;

import interface_adapter.RentInformation.returnbook.ReturnBookState;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.BorrowBook.BorrowBookOutputBoundary;
import use_case.rent_book.BorrowBook.BorrowBookOutputData;

/**
 * The BorrowBookPresenter class handles the presentation logic for the borrow book operation.
 * It interacts with the view models and the view manager to update the views based on the borrow book operation results.
 *
 */
public class BorrowBookPresenter implements BorrowBookOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;

    private final BorrowBookViewModel borrowBookViewModel;

    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;

    /**
     * Constructs a BorrowBookPresenter object with the specified view manager, main menu view model,
     * borrow book view model, and return or borrow view model.
     *
     * @param viewManagerModel the view manager model
     * @param mainMenuViewModel the main menu view model
     * @param borrowBookViewModel the borrow book view model
     * @param returnOrBorrowViewModel the return or borrow view model
     */
    public BorrowBookPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel, BorrowBookViewModel borrowBookViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.borrowBookViewModel = borrowBookViewModel;
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
    }

    /**
     * Prepares and displays the success view for the borrow book operation.
     *
     * @param borrowBookOutputData the output data of the borrow book operation
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
     * Prepares and switches to the cancel view.
     */
    @Override
    public void prepareCancelView() {
        viewManagerModel.setActiveView(returnOrBorrowViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Borrow CommonBook View to choose Menu");

    }
}
