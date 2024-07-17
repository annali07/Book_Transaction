package interface_adapter.RentMenu;

import data.misc_info.TemproraryInfo;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.returnorborrow.ReturnOrBorrowViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.rent_book.RentMenu.RentMenuOutputBoundary;
import use_case.rent_book.RentMenu.RentMenuOutputData;

public class RentMenuPresenter implements RentMenuOutputBoundary {
    private final RentMenuViewModel rentMenuViewModel;
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;
    private final ReturnOrBorrowViewModel returnOrBorrowViewModel;

    public RentMenuPresenter(ViewManagerModel viewManagerModel, RentMenuViewModel rentMenuViewModel, MainMenuViewModel mainMenuViewModel, ReturnOrBorrowViewModel returnOrBorrowViewModel) {
        this.rentMenuViewModel = rentMenuViewModel;
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.returnOrBorrowViewModel = returnOrBorrowViewModel;
    }

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

    @Override
    public void prepareFailView(String error) {
        System.out.println("cannot find the book");
    }

    @Override
    public void prepareCancelView() {
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched from Rent Book View to Main Menu");

    }
}
