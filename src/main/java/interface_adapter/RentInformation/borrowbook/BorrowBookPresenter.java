package interface_adapter.RentInformation.borrowbook;

import interface_adapter.RentInformation.returnbook.ReturnBookState;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.BorrowBook.BorrowBookOutputBoundary;
import use_case.rent_book.BorrowBook.BorrowBookOutputData;

public class BorrowBookPresenter implements BorrowBookOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;

    private final BorrowBookViewModel borrowBookViewModel;

    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;

    public BorrowBookPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel, BorrowBookViewModel borrowBookViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.borrowBookViewModel = borrowBookViewModel;
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
    }

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

    @Override
    public void prepareCancelView() {
        viewManagerModel.setActiveView(returnOrBorrowViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Borrow Book View to choose Menu");

    }
}
