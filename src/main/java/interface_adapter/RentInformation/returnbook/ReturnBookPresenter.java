package interface_adapter.RentInformation.returnbook;


import interface_adapter.RentMenu.RentMenuState;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.ReturnBook.ReturnBookOutputBoundary;
import use_case.rent_book.ReturnBook.ReturnBookOutputData;
import view.views.ReturnBookView;

public class ReturnBookPresenter implements ReturnBookOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;

    private final ReturnBookViewModel returnBookViewModel;

    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;

    public ReturnBookPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel, ReturnBookViewModel returnBookViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.returnBookViewModel = returnBookViewModel;
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
    }

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

    @Override
    public void prepareCancelView() {
        viewManagerModel.setActiveView(returnOrBorrowViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Return Book View to choose Menu");

    }
}
