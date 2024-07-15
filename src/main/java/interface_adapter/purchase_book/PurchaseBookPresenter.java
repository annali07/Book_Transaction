package interface_adapter.purchase_book;

import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.purchase_book.PurchaseOutputData;
import use_case.purchase_book.PurchaseOutputDataBoundary;


public class PurchaseBookPresenter implements PurchaseOutputDataBoundary{
    private final PurchaseViewModel purchaseViewModel;
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;


    public PurchaseBookPresenter(PurchaseViewModel purchaseViewModel, ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.purchaseViewModel = purchaseViewModel;
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }

//    @Override
//    public void prepareSuccessView(PurchaseOutputData purchaseOutputData) {
//        System.out.println("prepareSuccessView");
//    }

    @Override
    public void prepareErrorView(PurchaseOutputData purchaseOutputData) {
        System.out.println("prepareErrorView");
    }

    @Override
    public void prepareSuccessView(){
        System.out.println("prepareSuccessView");
//        viewManagerModel.setActiveView(PurchaseViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Switched to Add Book View");
    }

    public void prepareFailView(){
        System.out.println("Fail to find the book");


    }

    public void prepareCancelView(){
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Cancel View");
    }

    @Override
    public void prepareFailView(PurchaseOutputData purchaseOutputData) {

    }
}
