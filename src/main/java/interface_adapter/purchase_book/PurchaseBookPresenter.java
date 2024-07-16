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
//    public void prepareErrorView(PurchaseOutputData purchaseOutputData) {
//        System.out.println("Purchase Error");
//    }

    @Override
    public void prepareSuccessView(){
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Purchase Success");
    }

    @Override
    public void prepareFailView(){
        System.out.println("Failed to find the book");
    }

    public void prepareCancelView(){
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Cancel Purchase");
    }
}
